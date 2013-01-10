package org.warmsheep.socket.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Vector;

/**
 * 网络聊天室服务端
 * @author Warmsheep
 * @createTime Jan 7, 2013
 * @function 
 *
 */
public class ChatServer {
	
	private static Vector<ServerThread> m_threads = new Vector<ServerThread>();
	
	public ChatServer(){
	}
	
	public void start(){
		ServerSocket socket = null;
		System.out.println("服务器已启动，正在等待客户的请求...");
		try {
			// 设置Server监听端口号为8888, 这个数字必须
			// 和程序ChatClient中的port参数一致。
			socket = new ServerSocket(8888);
		} catch (Exception e) {
			System.out.println("服务接口建立失败!");
			return;
		}
		try {
			int nid = 0;
			while (true) {
				// 监听是否有新Chat Applet连接到Server,
				// 线程运行到该语句会封锁，直到有新的连接产生。
				Socket s = socket.accept();
				// 创建一个新的ServerThread.
				ServerThread st = new ServerThread(s);
				// 为该线程设置一个ID号。
				st.setID(nid++);
				// 将该线程加入到m_threads Vector中。
				m_threads.addElement(st);
				// 启动服务线程。
				new Thread(st).start();
				// 通知所有Chat Applet有一个新的网友加入。
				for (int i = 0; i < m_threads.size(); i++) {
					ServerThread st1 = (ServerThread) m_threads.elementAt(i);
					st1.write("<服务器>欢迎 " + st.getID() + "号朋友进入聊天室!");
				}
				System.out.println("接受" + st.getID() + "号客户请求");
				System.out.println("继续等待其他客户的请求...\n");
			}
		} catch (Exception e) {
			System.out.println("服务器已关闭...");
		}
	}
	
	/*
	 * 监听线程，监听对应的Chat Applet是否有信息传来。
	 */
	private final class ServerThread implements Runnable {
		Socket m_socket = null;
		DataInputStream m_in = null;
		DataOutputStream m_out = null;
		int m_nid;

		// 初始化该线程。
		public ServerThread(Socket s) {
			m_socket = s;
			try {
				m_in = new DataInputStream(m_socket.getInputStream());
				m_out = new DataOutputStream(m_socket.getOutputStream());
			} catch (Exception e) {
			}
		}

		public void run()
		{
			System.out.println("等待进程正在运行");
			try {
				while (true) {
					// 监听对应的Applet是否传来消息
					// 程序陷入到m_in.readUTF()中，直到有信息传来才返回。
					String s = m_in.readUTF();
					if (s == null)
						break;
					// 如果Chat Applet传来的信息为"leave",
					// 则通知所有其他的的Chat Applet自己退出了。
					if (s.trim().equals("leave"))
						for (int i = 0; i < m_threads.size(); i++) {
							ServerThread st = (ServerThread) m_threads.elementAt(i);
							st.write("*各位朋友， " + getID() + "号朋友离开聊天室" + "！*");
						}
					else
						// 向所有Chat Applet广播该信息。
						for (int i = 0; i < m_threads.size(); i++) {
							ServerThread st = (ServerThread) m_threads.elementAt(i);
							st.write("<" + getID() + "朋友说>" + s);
						}
				}
			} catch (SocketException e) {
				System.out.println(getID() + "号朋友离开聊天室" + "！*");
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			// 从m_threads Vector中删除该线程，表示该线程已经离开聊天室。
			m_threads.removeElement(this);
			try {
				m_socket.close();
			} catch (Exception e) {
			}
		}

		// 将msg送回对应的Applet
		public void write(String msg) {
			synchronized (m_out) {
				try {
					m_out.writeUTF(msg);
				} catch (IOException e) {
				}
			}
		}

		public int getID() // 获得该线程的ID.
		{
			return m_nid;
		}

		public void setID(int nid) // //设置线程的ID.
		{
			m_nid = nid;
		}
	}
}


