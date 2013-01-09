package org.warmsheep.notepad;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class JNotePadUI extends JFrame {
    private JMenuItem menuOpen;
    private JMenuItem menuSave;
    private JMenuItem menuSaveAs;
    private JMenuItem menuClose;

    private JMenu editMenu;
    private JMenuItem menuCut;
    private JMenuItem menuCopy;
    private JMenuItem menuPaste;

    private JMenuItem menuAbout;
    
    private JTextArea textArea;
    private JLabel stateBar;
    private JFileChooser fileChooser;
    
    private JPopupMenu popUpMenu;

    public JNotePadUI() {
        super("新建文本文件");
        setUpUIComponent();
        setUpEventListener();
        setVisible(true);
    }
    
    private void setUpUIComponent() {
        setSize(640, 480);
        
        // 菜单栏
        JMenuBar menuBar = new JMenuBar();
        
        // 设置「文件」菜单
        JMenu fileMenu = new JMenu("文件");
        menuOpen = new JMenuItem("打开");
        // 快捷键设置
        menuOpen.setAccelerator(
                    KeyStroke.getKeyStroke(
                            KeyEvent.VK_O, 
                            InputEvent.CTRL_MASK));
        menuSave = new JMenuItem("保存");
        menuSave.setAccelerator(
                    KeyStroke.getKeyStroke(
                            KeyEvent.VK_S, 
                            InputEvent.CTRL_MASK));
        menuSaveAs = new JMenuItem("另存为");

        menuClose = new JMenuItem("关闭");
        menuClose.setAccelerator(
                    KeyStroke.getKeyStroke(
                            KeyEvent.VK_Q, 
                            InputEvent.CTRL_MASK));
        
        fileMenu.add(menuOpen);
        fileMenu.addSeparator(); // 分隔线
        fileMenu.add(menuSave);
        fileMenu.add(menuSaveAs);        
        fileMenu.addSeparator(); // 分隔线
        fileMenu.add(menuClose);
        
        // 设置「编辑」菜单        
        JMenu editMenu = new JMenu("编辑");
        menuCut = new JMenuItem("剪切");
        menuCut.setAccelerator(
                    KeyStroke.getKeyStroke(KeyEvent.VK_X, 
                            InputEvent.CTRL_MASK));
        menuCopy = new JMenuItem("复制");
        menuCopy.setAccelerator(
                    KeyStroke.getKeyStroke(KeyEvent.VK_C, 
                            InputEvent.CTRL_MASK));
        menuPaste = new JMenuItem("粘贴");
        menuPaste.setAccelerator(
                    KeyStroke.getKeyStroke(KeyEvent.VK_V, 
                            InputEvent.CTRL_MASK));
        editMenu.add(menuCut);
        editMenu.add(menuCopy);
        editMenu.add(menuPaste);
        
        // 设置「关于」菜单        
        JMenu aboutMenu = new JMenu("关于");
        menuAbout = new JMenuItem("关于JNotePad");
        aboutMenu.add(menuAbout);
        
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(aboutMenu);

        
        setJMenuBar(menuBar);
        
        // 文字编辑区域
        textArea = new JTextArea();
        textArea.setFont(new Font("宋体", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        JScrollPane panel = new JScrollPane(textArea,
          ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
          ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        Container contentPane = getContentPane();
        contentPane.add(panel, BorderLayout.CENTER);  
        
        // 状态栏
        stateBar = new JLabel("未修改");
        stateBar.setHorizontalAlignment(SwingConstants.LEFT); 
        stateBar.setBorder(
                BorderFactory.createEtchedBorder());
        contentPane.add(stateBar, BorderLayout.SOUTH);       
        
        popUpMenu = editMenu.getPopupMenu();
        fileChooser = new JFileChooser();
    }
    
    
    private void setUpEventListener() {
        // 按下窗口关闭钮事件处理
        addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) { 
                    closeFile();
                }
            }
        );
        
        // 菜单 - 打开
        menuOpen.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    openFile();
                }
            }
        );

        // 菜单 - 保存
        menuSave.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    saveFile();
                }
            }
        );

        // 菜单 - 另存为
        menuSaveAs.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    saveFileAs();
                }
            }
        );


        // 菜单 - 关闭文件
        menuClose.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    closeFile();
                }
            }
        );

        // 菜单 - 剪切
        menuCut.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cut();
                }
            }
        );

        // 菜单 - 复制
        menuCopy.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    copy();
                }
            }
        );

        // 菜单 - 粘贴
        menuPaste.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    paste();
                }
            }
        );
        
        // 菜单 - 关于
        menuAbout.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // 显示对话框
                    JOptionPane.showOptionDialog(null, 
                        "程序名称:\n    JNotePad \n" + 
                        "程序设计:\n      \n" + 
                        "简介:\n    一个简单的文字编辑器\n" + 
                        "    可作为验收Java的实现对象\n" +
                        "    欢迎网友下载研究交流\n\n" +
                        " /",
                        "关于JNotePad",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null, null, null);
                }
            }
        );      
        
        // 编辑区键盘事件
        textArea.addKeyListener(
            new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    processTextArea();
                }
            }
        );

        // 编辑区鼠标事件
        textArea.addMouseListener(
            new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {
                    if(e.getButton() == MouseEvent.BUTTON3)
                        popUpMenu.show(editMenu, e.getX(), e.getY());
                }
                
                public void mouseClicked(MouseEvent e) {
                    if(e.getButton() == MouseEvent.BUTTON1)
                        popUpMenu.setVisible(false);
                }
            }
        );        
    }

    private void openFile() {
        if(isCurrentFileSaved()) { // 文件是否为保存状态
            open(); // 打开
        }
        else {
            // 显示对话框
            int option = JOptionPane.showConfirmDialog(
                    null, "文件已修改，是否保存？",
                    "保存文件？", JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE, null);
            switch(option) { 
                // 确认文件保存
                case JOptionPane.YES_OPTION:
                    saveFile(); // 保存文件
                     break;
               // 放弃文件保存
                case JOptionPane.NO_OPTION:
                    open();
                    break;
            }
        }
    }
    private boolean isCurrentFileSaved() {
        if(stateBar.getText().equals("未修改")) {
            return false;
        }
        else {
            return true;
        }
    }
    private void open() {
        // fileChooser 是 JFileChooser 的实例
        // 显示文件选取的对话框
        int option = fileChooser.showDialog(null, null);
            
        // 使用者按下确认键
        if(option == JFileChooser.APPROVE_OPTION) {
            try {
                // 开启选取的文件
                BufferedReader buf = 
                    new BufferedReader(
                       new FileReader(
                         fileChooser.getSelectedFile()));

                // 设定文件标题
                setTitle(fileChooser.getSelectedFile().toString());
                // 清除前一次文件
                textArea.setText("");
                // 设定状态栏
                stateBar.setText("未修改");
                // 取得系统相依的换行字符
                String lineSeparator = System.getProperty("line.separator");
                // 读取文件并附加至文字编辑区
                String text;
                while((text = buf.readLine()) != null) {
                    textArea.append(text);
                    textArea.append(lineSeparator);
                }

                buf.close();
            }   
            catch(IOException e) {
                JOptionPane.showMessageDialog(null, e.toString(),
                    "开启文件失败", JOptionPane.ERROR_MESSAGE);
            }
        }        
    }
    private void saveFile() {
        // 从标题栏取得文件名称
        File file = new File(getTitle());

        // 若指定的文件不存在
        if(!file.exists()) {
            // 执行另存为
            saveFileAs();
        }
        else {
            try {
                // 开启指定的文件
                BufferedWriter buf = 
                    new BufferedWriter(
                            new FileWriter(file));
                // 将文字编辑区的文字写入文件
                buf.write(textArea.getText());
                buf.close();
                // 设定状态栏为未修改
                stateBar.setText("未修改");
            }
            catch(IOException e) {
                JOptionPane.showMessageDialog(null, e.toString(),
                  "写入文件失败", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void saveFileAs() {
        // 显示文件对话框
        int option = fileChooser.showSaveDialog(null);

        // 如果确认选取文件
        if(option == JFileChooser.APPROVE_OPTION) {
            // 取得选择的文件
            File file = fileChooser.getSelectedFile();
            
            // 在标题栏上设定文件名称
            setTitle(file.toString());
                
            try {
                // 建立文件
                file.createNewFile();
                // 进行文件保存
                    saveFile();
            }
            catch(IOException e) {
            JOptionPane.showMessageDialog(null, e.toString(),
                   "无法建立新文件", JOptionPane.ERROR_MESSAGE);
            }
        }   
    }

    private void closeFile() {
        // 是否已保存文件
        if(isCurrentFileSaved()) {
            // 释放窗口资源，而后关闭程序
            dispose();
        }
        else {
            int option = JOptionPane.showConfirmDialog(
                    null, "文件已修改，是否保存？",
                    "保存文件？", JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE, null);

            switch(option) {
                case JOptionPane.YES_OPTION:
                    saveFile();
                    break;
                case JOptionPane.NO_OPTION:
                   dispose();
            }
        }
    }

    private void cut() {
        textArea.cut();
        stateBar.setText("已修改");
        popUpMenu.setVisible(false);
    }

    private void copy() {
        textArea.copy();
        popUpMenu.setVisible(false);    
    }

    private void paste() {
        textArea.paste();
        stateBar.setText("已修改");
        popUpMenu.setVisible(false);
    }

    private void processTextArea() {
            stateBar.setText("已修改");
    }


    
    public static void main(String[] args) {
        new JNotePadUI();
    }    
   }