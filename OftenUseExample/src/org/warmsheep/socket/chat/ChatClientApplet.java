package org.warmsheep.socket.chat;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class ChatClientApplet extends Applet implements Runnable {
	  private boolean isStandalone = false;
	  JLabel jLabel1 = new JLabel();
	  JTextField jTextField1 = new JTextField();
	  JLabel jLabel2 = new JLabel();
	  JButton jButton1 = new JButton();
	  DataInputStream  m_in;   //消息输入流
	  DataOutputStream  m_out; //消息输出流
	  JScrollPane jScrollPane1 = new JScrollPane();
	  JTextArea jTextArea1 = new JTextArea();
	  JLabel jLabel3 = new JLabel();
	  //Get a parameter value
	  public String getParameter(String key, String def) {
	    return isStandalone ? System.getProperty(key, def) :
	      (getParameter(key) != null ? getParameter(key) : def);
	  }
	  //Construct the applet
	  public ChatClientApplet() {
	  }
	  //Initialize the applet
	  public void init() {
	    m_in=null;
	    m_out=null;
	    try{
	      URL  url=getCodeBase();  //获取applet 的URL 值。
	      //获取服务器IP地址
	      InetAddress  inetaddr=InetAddress.getByName(url.getHost());
	      Socket  m_socket;
	      //屏幕显示服务器IP地址、通讯协议
	      System.out.println("服务器:"+inetaddr+" "+url.getHost()+" "+url.getProtocol());
	      m_socket=new Socket(inetaddr,8888); //创建与服务器IP地址连接的套接口
	      //在套接口上建立输入流
	      m_in=new  DataInputStream(m_socket.getInputStream());
	      //在套接口上建立输出流
	      m_out=new DataOutputStream(m_socket.getOutputStream());
	    }
	    catch (Exception e)
	    {
	      System.out.println("Error:"+e);
	    }
	    try {
	      jbInit();
	    }
	    catch(Exception e) {
	      e.printStackTrace();
	    }
	  }
	  //Component initialization
	  private void jbInit() throws Exception {
	    jLabel1.setFont(new java.awt.Font("DialogInput", 1, 20));
	    jLabel1.setForeground(Color.red);
	    jLabel1.setText("一对多聊天程序Java Applet客户端");
	    jLabel1.setBounds(new Rectangle(81, 22, 358, 38));
	    this.setBackground(UIManager.getColor("ComboBox.selectionBackground"));
	    this.setLayout(null);
	    jLabel2.setFont(new java.awt.Font("Dialog", 1, 16));
	    jLabel2.setForeground(Color.blue);
	    jLabel2.setText("输入发送消息：");
	    jLabel2.setBounds(new Rectangle(35, 78, 124, 37));
	    jButton1.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
	    jButton1.setBounds(new Rectangle(413, 77, 70, 39));
	    jButton1.setFont(new java.awt.Font("Dialog", 1, 16));
	    jButton1.setForeground(Color.blue);
	    jButton1.setToolTipText("点击发送按钮即可发送文本框中输入的消息");
	    jButton1.setText("发送");
	    jButton1.addActionListener(new ChatClientApplet_jButton1_actionAdapter(this));
	    jTextField1.setBackground(new Color(182, 231, 223));
	    jTextField1.setFont(new java.awt.Font("Dialog", 0, 17));
	    jTextField1.setToolTipText("此文本框用来输入发送的消息");
	    jTextField1.setBounds(new Rectangle(153, 80, 248, 35));
	    jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    jScrollPane1.getViewport().setBackground(UIManager.getColor("MenuItem.acceleratorForeground"));
	    jScrollPane1.setBounds(new Rectangle(54, 130, 410, 231));
	    jTextArea1.setBackground(UIManager.getColor("Desktop.background"));
	    jTextArea1.setFont(new java.awt.Font("Dialog", 0, 18));
	    jTextArea1.setForeground(Color.black);
	    jLabel3.setFont(new java.awt.Font("Dialog", 0, 16));
	    jLabel3.setForeground(Color.blue);
	    jLabel3.setText("如想离开聊天室，可在发送框中输入字符串leave并发送");
	    jLabel3.setBounds(new Rectangle(62, 367, 394, 24));
	    this.add(jLabel1, null);
	    this.add(jLabel2, null);
	    this.add(jTextField1, null);
	    this.add(jButton1, null);
	    this.add(jScrollPane1, null);
	    this.add(jLabel3, null);
	    jScrollPane1.getViewport().add(jTextArea1, null);
	    //启动监听线程
	    new Thread(this).start();
	  }
	  //Get Applet information
	  public String getAppletInfo() {
	    return "Applet Information";
	  }
	  //Get parameter info
	  public String[][] getParameterInfo() {
	    return null;
	  }
	  public void run()
	    {
	        try
	        {
	            while(true)
	            {
	             //监听服务者发来的消息，线程将阻塞在该语句中，直到消息到来。
	                String s=m_in.readUTF();  //读一个UTF格式字符串。
	                if(s!=null)
	                //将消息显示在信息显示窗口中。
	                jTextArea1.append(s+"\n");
	            }
	        }
	            catch(Exception e)
	            {
	                jTextArea1.append("Network problem or Sever down.\n");
	                jTextArea1.setVisible(false);
	            }
	        }
	        public void stop()
	        {
	           try
	           {
	              m_out.writeUTF("leave");
	              //如想离开聊天室，可在发送框中输入字符串leave
	           }
	           catch(IOException e){}
	        }
	    void jButton1_actionPerformed(ActionEvent e){
	      String b = jTextField1.getText();
	      jTextField1.setText("");
	      //将用户输入的消息发送给 Chat Server
	      try{
	        m_out.writeUTF(b); //向服务者发送一UTF格式字符串。
	      }
	      catch(IOException g){}
	    }
	}


	class ChatClientApplet_jButton1_actionAdapter implements java.awt.event.ActionListener {
	  ChatClientApplet adaptee;
	  ChatClientApplet_jButton1_actionAdapter(ChatClientApplet adaptee) {
	    this.adaptee = adaptee;
	  }
	  public void actionPerformed(ActionEvent e) {
	    adaptee.jButton1_actionPerformed(e);
	  }
	}
