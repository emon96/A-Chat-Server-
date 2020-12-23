import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.*;

import static java.awt.Color.BLUE;
import static java.awt.Color.white;

class p implements Runnable
{
    Thread t;
    p()
    {
        t=new  Thread(this);
        t.start();
    }


    @Override
    public void run() {
        while(true)
        {
            try {

                File file=new File("post.txt");
                Scanner scanner=new Scanner(file);
                A_Chat_Client_GUI.parea.selectAll();
                A_Chat_Client_GUI.parea.replaceSelection("");

                while(scanner.hasNextLine())
                {
                    A_Chat_Client_GUI.parea.setFont(new java.awt.Font(Font.SANS_SERIF,Font.BOLD,13));
                    String sc=scanner.nextLine();
                    if(!sc.equals(""))
                    {
                        A_Chat_Client_GUI.parea.append(sc+"\n");
                    }

                }
                scanner.close();
                Thread.sleep(2000);
                 A_Chat_Client_GUI.TF_Message.setText("");
            }
            catch (Exception e)
            {
                System.out.println("wrong in post file");
            }
        }
    }
}
public class A_Chat_Client_GUI {

    public static A_Chat_Client ChatClient;
    public static String UserName = "";
    public static int num=0;
    public static JFrame MainWindow = new JFrame();
    private static JButton B_ABOUT = new JButton();
    private static JButton B_CONNECT = new JButton();
    private static JButton B_DISCONNECT = new JButton();
    private static JButton B_HELP = new JButton();
    private static JButton B_SEND = new JButton();
    private static JLabel L_Message = new JLabel("Message: ");
    public static JTextField TF_Message = new JTextField(20);
    private static JLabel L_Conversation = new JLabel();
    public static JTextArea TA_CONVERSATION = new JTextArea();
    private static JScrollPane SP_CONVERSATION = new JScrollPane();
    private static JLabel L_ONLINE = new JLabel();
    public static JList JL_ONLINE = new JList();
    private static JScrollPane SP_ONLINE = new JScrollPane();
    private static JLabel L_LoggedInAs = new JLabel();
    public static JLabel L_LoggedInAsBox = new JLabel();

    public static JFrame LogInWindow = new JFrame();
    public static JTextField TF_UserNameBox = new JTextField(20);
    private static JButton B_ENTER = new JButton("ENTER");
    private static JLabel L_EnterUserName = new JLabel("Enter Username: ");

    public static JTextArea parea=new JTextArea();
    public static JScrollPane ppane=new JScrollPane();
    public static JButton pbutton=new JButton("Post");

    private static JPanel P_Login = new JPanel();
    private static String[] strings=new String[100];
    public static JLabel jpost=new JLabel("Newsfeed");


    public static JButton sb=new JButton("Sing In");
    public static JPanel sp=new JPanel();
    public static JButton res=new JButton("Sign Up");
    public static JLabel wel=new JLabel();

    private static JFrame uj=new JFrame();
    public static JButton admin=new JButton("As an Admin");
    public static JButton user=new JButton("As an User");

    public static JLabel res_user=new JLabel("Enter Username");
    public static JTextField res_text=new JTextField();
    public static String image_name;
    public static String path;
    public static File select;

    public static void main(String args[])
    {
        LogInWindow.getContentPane().setBackground(BLUE);
       // SignInWindow();
        JFrame x=new JFrame();
        UserType(x);
        //BuildLogInWindow();

       //BuildMainWindow(x);
       // Initialize();
    }
    public static void SignInWindow()
    {

         JFrame sif=new JFrame();
         ImageIcon imageIcon=new ImageIcon("f.JPG");
         Image image=imageIcon.getImage();
         Image image1=image.getScaledInstance(800,500,Image.SCALE_SMOOTH);
         imageIcon=new ImageIcon(image1);
         JLabel jLabel=new JLabel(imageIcon,JLabel.CENTER);
         jLabel.setBounds(0,0,800,500);
         JPanel jPanel=new JPanel();
         jPanel.setLayout(null);
         jPanel.setBackground(Color.BLACK);
         jPanel.setBounds(100,100,200,200);
         //jLabel.add(jPanel);


        sp=new JPanel();
        sp.setLayout(null);
        sif.setTitle("Welcome to miniMessenger");
        sif.setSize(800,500);
       // sif.setLocation(200,250);
        sif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        float a= (float) .1,b= (float) .3,c= (float) .8,d=(float) .1;
        //sp.setBackground(new java.awt.Color(a,b,c).brighter().brighter());
        sb.setBounds(240,200,140,40);
        sb.setForeground(Color.white);
        sb.setBackground(new java.awt.Color(160,180,45));
        res.setForeground(Color.white);
        res.setBackground(new java.awt.Color(160,183,45));
        res.setBounds(410,200,140,40);
        wel.setForeground(Color.BLUE);
        wel.setText("Welcome to miniMessenger");
       wel.setFont(new Font("SansSerif", Font.BOLD, 22));
        //wel.setFont(new Font("Tahoma", Font.BOLD, 22));
        wel.setBounds(120,50,300,40);
        JLabel copy=new JLabel();
        copy.setText("All Rights Reserved By");
        copy.setFont(new Font("Tahoma",Font.TRUETYPE_FONT,12));
        copy.setBounds(620,410,200,30);
        sp.add(copy);
        JLabel copy2=new JLabel();
        copy2.setText("   @Mehedi Hasan Emon");
        copy2.setFont(new Font("Tahoma",Font.TRUETYPE_FONT,11));
        copy2.setBounds(650,424,200,30);
        copy2.setForeground(Color.RED);
        sp.add(copy2);
        JLabel copy3=new JLabel();
        copy3.setText("   @Tanvir Arafat Anik");
        copy3.setFont(new Font("Tahoma",Font.TRUETYPE_FONT,11));
        copy3.setBounds(650,434,200,30);
        copy.setForeground(Color.RED);
        copy3.setForeground(Color.RED);
        sp.add(copy3);

        //sp.add(wel);
        sp.add(sb);
        sp.add(res);
        sp.add(jLabel);
        sif.add(sp);
        SignAndResister(sif);
        sif.setVisible(true);


    }
    public static void UserType(JFrame x)
    {
        //JFrame x=new JFrame();
        x.getContentPane().removeAll();
        JPanel up=new JPanel();
        x.remove(sp);
        up.setLayout(null);
        x.setTitle("Sign In");
        x.setSize(800,550);
       // x.setLocation(200,250);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        float a= (float) .1,b= (float) .3,c= (float) .8,d=(float) .1;
        //up.setBackground(new java.awt.Color(a,b,c).brighter().brighter());
        res_user.setBounds(200,130,100,30);
       // res_user.setForeground(Color.white);
        res_user.setFont(new java.awt.Font(Font.SANS_SERIF,Font.BOLD,12));
        res_text.setBackground(new java.awt.Color(210,180,140));

       // res_text.setForeground(new java.awt.Color(210,180,140));

        res_text.setBounds(300,130,200,30);

        JLabel label=new JLabel("Password");
       // label.setForeground(Color.white);
        label.setBounds(200,190,100,30);

        JButton jButton=new JButton("Enter");
        jButton.setBounds(340,250,100,30);
        jButton.setBackground(new java.awt.Color(160,183,45));

        JPasswordField textField=new JPasswordField("");
        textField.setBackground(new java.awt.Color(210,180,140));
        textField.setBounds(300,190,200,30);

        ImageIcon imageIcon=new ImageIcon("f.JPG");
        Image image=imageIcon.getImage();
        Image image1=image.getScaledInstance(800,550,Image.SCALE_SMOOTH);
        imageIcon=new ImageIcon(image1);
        JLabel jLabel=new JLabel(imageIcon,JLabel.CENTER);
        jLabel.setBounds(0,0,800,550);
        jLabel.setLayout(null);

        JPanel jPanel=new JPanel();
        jPanel.setLayout(null);
        jPanel.setBackground(new java.awt.Color(0,0,0,50));
        jPanel.setBounds(180,60,415,330);

        JLabel jLabel1=new JLabel("Want to sign up for a new account?");
        jLabel1.setBounds(300,295,200,30);


        res.setBounds(340,340,100,30);
        res.setBackground(new java.awt.Color(160,183,45));

        up.add(res);
        up.add(jLabel1);
        up.add(res_text);
        up.add(res_user);
        up.add(jButton);
        up.add(textField);
        up.add(label);
        up.add(jPanel);
        up.add(jLabel);

        jButton.addActionListener(new java.awt.event.ActionListener()
                                  {

                                      @Override
                                      public void actionPerformed(ActionEvent actionEvent) {
                                          if(res_text.getText().equals(""))
                                          {
                                              JOptionPane.showMessageDialog(null,"Enter username");
                                              x.getContentPane().removeAll();
                                              New2(x);
                                          }
                                          else if(textField.getText().equals(""))
                                          {
                                              JOptionPane.showMessageDialog(null,"Enter password");
                                          }
                                          else
                                              {
                                                  try
                                                  {

                                                      File file=new File("information.txt");
                                                      Scanner scanner=new Scanner(file);
                                                      String string=new String();
                                                      String s2=new String( );
                                                      int i=0;
                                                      while (scanner.hasNextLine())
                                                      {
                                                          string=scanner.nextLine();
                                                          s2=scanner.nextLine();
                                                          // scanner.nextLine();
                                                          if(string.equals(res_text.getText())&&s2.equals(textField.getText()))
                                                          {
                                                              System.out.println("hi");
                                                              UserName=res_text.getText();
                                                              x.getContentPane().removeAll();
                                                              ACTION_B_ENTER(x,up);

                                                              i=1;
                                                              break;

                                                          }
                                                      }
                                                      if(i==0)
                                                      {
                                                          JOptionPane.showMessageDialog(null,"Wrong Password or Username\nEnter again");
                                                          x.getContentPane().removeAll();
                                                          New2(x);
                                                          System.out.println("have");
                                                      }
                                                      if(i==1)
                                                      {

                                                      }

                                                  }
                                                  catch (Exception e)
                                                  {

                                                  }
                                                  }

                                      }
                                  }
        );
        SignAndResister(x);

       x.add(up);
        x.setVisible(true);

    }
    public static void New2(JFrame x)
    {
        x.getContentPane().removeAll();
        UserType(x);
    }
    public static void SignAndResister(JFrame x)
    {
        sb.addActionListener(new  java.awt.event.ActionListener()
                             {

                                 @Override
                                 public void actionPerformed(ActionEvent actionEvent) {
                                     UserType(x);
                                 }
                             }
        );
        res.addActionListener(new  java.awt.event.ActionListener()
                             {

                                 @Override
                                 public void actionPerformed(ActionEvent actionEvent) {

                                     x.getContentPane().removeAll();
                                     Resister(x);
                                 }
                             }
        );
        admin.addActionListener(new  java.awt.event.ActionListener()
                             {

                                 @Override
                                 public void actionPerformed(ActionEvent actionEvent) {
                                     Adimn(x);
                                 }
                             }
        );
        user.addActionListener(new  java.awt.event.ActionListener()
                             {

                                 @Override
                                 public void actionPerformed(ActionEvent actionEvent) {
                                     User(x);
                                 }
                             }
        );
    }
    public static void Resister(JFrame x)
    {
        JPanel up=new JPanel();
        x.remove(sp);
        up.setLayout(null);
        x.setTitle("Register");
        x.setSize(800,550);
        // x.setLocation(200,250);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        float a= (float) .1,b= (float) .3,c= (float) .8,d=(float) .1;
        up.setBackground(new java.awt.Color(a,b,c).brighter().brighter());
        res_user.setBounds(200,160,100,30);
        res_text.setText("");
        res_user.setForeground(Color.white);
        res_user.setFont(new java.awt.Font(Font.SANS_SERIF,Font.BOLD,12));
        res_text.setBackground(new java.awt.Color(210,180,140));

        // res_text.setForeground(new java.awt.Color(210,180,140));

        res_text.setBounds(320,160,200,30);

        JLabel label=new JLabel("Password");
        label.setForeground(Color.white);
        label.setBounds(200,210,100,30);

        JButton jButton=new JButton("Submit");
        jButton.setBounds(350,340,100,30);
        jButton.setBackground(new java.awt.Color(160,183,45));

        JPasswordField textField=new JPasswordField("");
        textField.setBackground(new java.awt.Color(210,180,140));
        textField.setBounds(320,210,200,30);

        ImageIcon imageIcon=new ImageIcon("f.JPG");
        Image image=imageIcon.getImage();
        Image image1=image.getScaledInstance(800,550,Image.SCALE_SMOOTH);
        imageIcon=new ImageIcon(image1);
        JLabel jLabel=new JLabel(imageIcon,JLabel.CENTER);
        jLabel.setBounds(0,0,800,550);

        JLabel label2=new JLabel("Name");
        label2.setForeground(Color.white);
        label2.setBounds(200,60,100,30);

        JTextField jTextField=new JTextField();
        jTextField.setBackground(new java.awt.Color(210,180,140));
        jTextField.setBounds(320,60,200,30);

        JLabel label3=new JLabel("Email");
        label3.setForeground(Color.white);
        label3.setBounds(200,110,100,30);

        JTextField jTextField1=new JTextField();
        jTextField1.setBackground(new java.awt.Color(210,180,140));
        jTextField1.setBounds(320,110,200,30);

        JLabel label4=new JLabel("Confirm Password");
        label4.setForeground(Color.white);
        label4.setBounds(200,260,200,30);
        JPasswordField textField1=new JPasswordField("");
        textField1.setBackground(new java.awt.Color(210,180,140));
        textField1.setBounds(320,260,200,30);

        JPanel jPanel=new JPanel();
        jPanel.setLayout(null);
        jPanel.setBackground(new java.awt.Color(0,0,0,50));
        jPanel.setBounds(180,40,415,350);

        JLabel jLabel1=new JLabel("Choose Profile Photo");
        jLabel1.setBounds(200,300,200,30);
        jLabel1.setForeground(Color.white);
        up.add(jLabel1);

        JButton but=new JButton("Select");
        but.setBounds(350,300,100,30);
        but.setForeground(Color.black);
        but.setBackground(new java.awt.Color(160,183,45));
        up.add(but);

        up.add(res_text);
        up.add(jTextField1);
        up.add(label4);
        up.add(textField1);
        up.add(label3);
        up.add(jTextField);
        up.add(label2);
        up.add(res_user);
        up.add(jButton);
        up.add(textField);
        up.add(label);
        up.add(jPanel);

        up.add(jLabel);

        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser=new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter fileNameExtensionFilter=new FileNameExtensionFilter("*Images","jpg","JPG","gif","png");
                fileChooser.addChoosableFileFilter(fileNameExtensionFilter);
                int result=fileChooser.showSaveDialog(null);
                if(result==JFileChooser.APPROVE_OPTION)
                {
                    select=fileChooser.getSelectedFile();
                    path=select.getAbsolutePath();
                }
            }
        });

        jButton.addActionListener(new java.awt.event.ActionListener()
                                  {

                                      @Override
                                      public void actionPerformed(ActionEvent actionEvent) {
                                          if(jTextField.getText().equals(""))
                                          {
                                              JOptionPane.showMessageDialog(null,"Name field can't be empty");
                                             // New(x);
                                          }
                                          else if(jTextField1.getText().equals(""))
                                          {
                                              JOptionPane.showMessageDialog(null,"Email field can't be empty");
                                             // New(x);
                                          }
                                          else if(res_text.getText().equals(""))
                                          {
                                              JOptionPane.showMessageDialog(null,"Username field can't be empty");
                                             // New(x);
                                          }
                                          else if (textField.getText().equals(""))
                                          {
                                              JOptionPane.showMessageDialog(null,"Password field can't be empty");
                                             // New(x);
                                          }
                                          else if (textField1.getText().equals(""))
                                          {
                                              JOptionPane.showMessageDialog(null,"Confirm Password");
                                             // New(x);
                                          }
                                          else if(!textField.getText().equals(textField1.getText()))
                                          {
                                              JOptionPane.showMessageDialog(null,"Confirm Password correctly");
                                          }
                                          else
                                          {
                                              try
                                              {
                                                  FileWriter fileWriter=new FileWriter("information.txt",true);
                                                  BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
                                                  PrintWriter printWriter=new PrintWriter(bufferedWriter);
                                                  File file=new File("information.txt");
                                                  Scanner scanner=new Scanner(file);
                                                  String string=new String();
                                                  int i=0;

                                                  while (scanner.hasNextLine())
                                                  {
                                                      string=scanner.nextLine();
                                                      // scanner.nextLine();
                                                      if(string.equals(res_text.getText()))
                                                      {
                                                          JOptionPane.showMessageDialog(null,"Username already used\nEnter a new Username");
                                                          New(x);
                                                          i=1;
                                                          System.out.println("have");
                                                          break;

                                                      }
                                                  }
                                                  if(i==0)
                                                  {
                                                      char[] c=new char[100];
                                                     // c=res_text.getText().toCharArray();
                                                      printWriter.println(res_text.getText());
                                                      printWriter.println(textField.getText());

                                                      printWriter.close();
                                                      fileWriter=new FileWriter("image.txt",true);
                                                      printWriter=new PrintWriter(fileWriter);
                                                      printWriter.println(res_text.getText());
                                                      printWriter.println(path);
                                                      printWriter.close();
                                                      System.out.println("hi");
                                                      UserName=res_text.getText();
                                                      x.getContentPane().removeAll();
                                                      ACTION_B_ENTER(x,up);
                                                  }

                                              }
                                              catch (Exception e)
                                              {

                                              }
                                          }


                                      }
                                  }
        );

        x.add(up);
        x.setVisible(true);
    }
    public static void  New(JFrame x)
    {
       /* x.remove(y);
        x.remove(res_text);
        x.remove(res);
        x.remove(user);
        x.remove(res_user);*/
       x.getContentPane().removeAll();
        Resister(x);
    }
    public static void Adimn(JFrame x)
    {

    }
    public static void User(JFrame x)
    {

    }
    public static void Connect() {
        try {
            final int PORT = 4448;
            final String HOST = "localhost";
            Socket SOCK = new Socket(HOST, PORT);
            System.out.println("You connected to: " + HOST);

            ChatClient = new A_Chat_Client(SOCK);
            PrintWriter OUT = new PrintWriter(SOCK.getOutputStream());
            OUT.flush();
            Thread X = new Thread(ChatClient);
            X.start();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Server not responding");
            System.exit(0);
        }
    }

    public static void Initialize() {
        B_SEND.setEnabled(false);
        B_DISCONNECT.setEnabled(false);
        B_CONNECT.setEnabled(true);
    }

    public static void BuildLogInWindow() {

        LogInWindow.setTitle("Messenger");

        LogInWindow.setSize(800, 320);
        LogInWindow.setLocation(250, 200);
        LogInWindow.setResizable(false);
        P_Login = new JPanel();
        P_Login.setLayout(null);
        float a= (float) .1,b= (float) .3,c= (float) .8;
        P_Login.setBackground(new java.awt.Color(a,b,c).brighter());
        LogInWindow.add(P_Login);
        L_EnterUserName.setBounds(50,50,200,20);
        TF_UserNameBox.setBounds(160,50,200,20);
        B_ENTER.setBounds(200,200,100,30);
        L_EnterUserName.setForeground(Color.WHITE);
        P_Login.add(L_EnterUserName);
        P_Login.add(TF_UserNameBox);
        P_Login.add(B_ENTER);

        Login_Action();
        LogInWindow.setVisible(true);

    }

    public static void BuildMainWindow(JFrame x) {
        x.getContentPane().removeAll();
        MainWindow=x;
        MainWindow.setTitle(UserName + "'s Chat Box");
       // MainWindow.setSize(800, 500);
       // MainWindow.setLocation(200, 250);
        MainWindow.setResizable(false);
        ConfigureMainWindow(x);
        MainWindow_Action();
        MainWindow.setVisible(true);
    }

    public static void ConfigureMainWindow(JFrame x) {
        Group1 g1=new Group1();
        g1.Post();
        MainWindow.getContentPane().removeAll();
       // MainWindow.setBackground(new java.awt.Color(255, 255, 255));
        float a= (float) .1,b= (float) .3,c= (float) .8,d=(float) .3;
        MainWindow.getContentPane().setBackground(new java.awt.Color(a,b,c,d));
        MainWindow.setSize(800, 550);
        MainWindow.getContentPane().setLayout(null);

        ImageIcon imageIcon=new ImageIcon("f.JPG");
        Image image=imageIcon.getImage();
        Image image1=image.getScaledInstance(800,550,Image.SCALE_SMOOTH);
        imageIcon=new ImageIcon(image1);
        JLabel jLabel=new JLabel(imageIcon,JLabel.CENTER);
        jLabel.setBounds(0,0,800,550);

        MainWindow.getContentPane().add(jLabel);

        B_SEND.setBackground(new java.awt.Color(0, 0, 255));
        B_SEND.setForeground(Color.WHITE);
        B_SEND.setText("SEND");
       // MainWindow.getContentPane().add(B_SEND);
        jLabel.add(B_SEND);
        B_SEND.setBounds(390, 470, 90, 30);

        B_DISCONNECT.setBackground(new java.awt.Color(0, 0, 255));
        B_DISCONNECT.setForeground(Color.WHITE);
        B_DISCONNECT.setText("DISCONNECT");
        jLabel.add(B_DISCONNECT);
        B_DISCONNECT.setBounds(10, 14, 110, 27);

        B_CONNECT.setBackground(BLUE);
        B_CONNECT.setForeground(Color.WHITE);
        B_CONNECT.setText("CONNECT");
        B_CONNECT.setToolTipText("");
        //MainWindow.getContentPane().add(B_CONNECT);
        B_CONNECT.setBounds(130, 40, 110, 25);

        B_HELP.setBackground(BLUE);
        B_HELP.setForeground(Color.WHITE);
        B_HELP.setText("HELP");
        jLabel.add(B_HELP);
        B_HELP.setBounds(235, 14, 95, 27);

        B_ABOUT.setBackground(BLUE);
        B_ABOUT.setForeground(Color.WHITE);
        B_ABOUT.setText("ABOUT");
        jLabel.add(B_ABOUT);
        B_ABOUT.setBounds(130, 14, 95, 27);

        L_Message.setText("Message");
        L_Message.setForeground(Color.white);
        jLabel.add(L_Message);
        L_Message.setBounds(10, 475, 100, 20);

        TF_Message.setForeground(BLUE);
        TF_Message.requestFocus();
        jLabel.add(TF_Message);
        TF_Message.setBounds(80, 470, 300, 30);

        jLabel.add(pbutton);
        pbutton.setBounds(490,470,90,30);
        pbutton.setForeground(Color.white);
        pbutton.setBackground(BLUE);

        L_Conversation.setHorizontalAlignment(SwingConstants.CENTER);
        L_Conversation.setText("Conversation");
        L_Conversation.setForeground(Color.white);
        jLabel.add(L_Conversation);
        L_Conversation.setBounds(422, 40, 140, 16);

        TA_CONVERSATION.setColumns(20);
        TA_CONVERSATION.setFont(new java.awt.Font(Font.SANS_SERIF, 0, 12));
        TA_CONVERSATION.setForeground(BLUE);
        TA_CONVERSATION.setLineWrap(true);
        TA_CONVERSATION.setRows(5);
        TA_CONVERSATION.setEditable(false);

        SP_CONVERSATION.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        SP_CONVERSATION.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        SP_CONVERSATION.setViewportView(TA_CONVERSATION);
        jLabel.add(SP_CONVERSATION);
        SP_CONVERSATION.setBounds(360, 60, 280, 360);

        JButton filebutton=new JButton("File");
        filebutton.setBounds(590,470,90,30);
        filebutton.setForeground(Color.white);
        filebutton.setBackground(new java.awt.Color(0, 0, 255));
        jLabel.add(filebutton);

        JButton emo0=new JButton("(-_-)");
        emo0.setBackground(new java.awt.Color(250, 0, 0));
        emo0.setForeground(Color.white);
        emo0.setBounds(80,430,70,30);
        jLabel.add(emo0);
        emo0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ChatClient.SEND("(-_-)");
            }
        });
        JButton emo1=new JButton("^_^");
        emo1.setBackground(new java.awt.Color(250, 0, 0));
        emo1.setForeground(Color.white);
        emo1.setBounds(160,430,70,30);
        jLabel.add(emo1);
        emo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ChatClient.SEND("^_^");
            }
        });
        JButton emo2=new JButton("^_-");
        emo2.setBackground(new java.awt.Color(250, 0, 0));
        emo2.setForeground(Color.white);
        emo2.setBounds(240,430,70,30);
        jLabel.add(emo2);
        emo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ChatClient.SEND("^_-");
            }
        });
        JButton emo3=new JButton("(^.^)");
        emo3.setBackground(new java.awt.Color(250, 0, 0));
        emo3.setForeground(Color.white);
        emo3.setBounds(320,430,70,30);
        jLabel.add(emo3);
        emo3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ChatClient.SEND("(^.^)");
            }
        });
        JButton emo4=new JButton("(*_*)");
        emo4.setBackground(new java.awt.Color(250, 0, 0));
        emo4.setForeground(Color.white);
        emo4.setBounds(400,430,70,30);
        jLabel.add(emo4);
        emo4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ChatClient.SEND("(*_*)");
            }
        });
        JButton emo5=new JButton(":')");
        emo5.setBackground(new java.awt.Color(250, 0, 0));
        emo5.setForeground(Color.white);
        emo5.setBounds(480,430,70,30);
        jLabel.add(emo5);
        emo5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ChatClient.SEND(":')");
            }
        });

        filebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser=new JFileChooser();
                fileChooser.showOpenDialog(null);

                    select=fileChooser.getSelectedFile();
                    path=select.getAbsolutePath();
                    path=path+"#";
                    ChatClient.SEND(path);

            }
        });

        parea.setColumns(20);
        parea.setFont(new java.awt.Font(Font.SANS_SERIF, 0, 12));
        parea.setForeground(BLUE);
        parea.setLineWrap(true);
        parea.setRows(5);
        parea.setEditable(false);

        ppane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        ppane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        ppane.setViewportView(parea);
        jLabel.add(ppane);
        ppane.setBounds(10, 60, 340, 360);

        jpost.setBounds(140,42,140,16);
        jLabel.add(jpost);

        L_ONLINE.setHorizontalAlignment(SwingConstants.CENTER);
        L_ONLINE.setText("Current Online");
        L_ONLINE.setForeground(Color.white);
        L_ONLINE.setToolTipText("");
        jLabel.add(L_ONLINE);
        L_ONLINE.setBounds(647, 140, 130, 16);


        JL_ONLINE.setForeground(BLUE);
        jpost.setForeground(Color.white);
       // JL_ONLINE.setListData(TestNames);

        SP_ONLINE.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        SP_ONLINE.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        SP_ONLINE.setViewportView(JL_ONLINE);
        jLabel.add(SP_ONLINE);
        SP_ONLINE.setBounds(650, 160, 130, 260);

        L_LoggedInAs.setFont(new java.awt.Font(Font.SANS_SERIF, 0, 12));
        L_LoggedInAs.setText("Currently Logged As");
        L_LoggedInAs.setForeground(Color.white);
       // jLabel.add(L_LoggedInAs);
        L_LoggedInAs.setBounds(656, 100, 140, 15);

        L_LoggedInAsBox.setHorizontalAlignment(SwingConstants.CENTER);
        L_LoggedInAsBox.setFont(new java.awt.Font(Font.SANS_SERIF, Font.BOLD, 19));
        L_LoggedInAsBox.setBackground(Color.white);
        L_LoggedInAsBox.setForeground(new java.awt.Color(255, 0, 0));
        L_LoggedInAsBox.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel.add(L_LoggedInAsBox);
        L_LoggedInAsBox.setBounds(650, 114, 130, 25);



        File file=new File("image.txt");
        try {
            Scanner scanner=new Scanner(file);
            while (scanner.hasNextLine())
            {
                if(scanner.nextLine().equals(res_text.getText()))
                {
                    path=scanner.nextLine();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ImageIcon imageIcon5=new ImageIcon(path);
        Image image5=imageIcon5.getImage();
        Image image6=image5.getScaledInstance(130,100,Image.SCALE_SMOOTH);
        imageIcon5=new ImageIcon(image6);
        JLabel jLabel5=new JLabel(imageIcon5,JLabel.CENTER);
        jLabel5.setBounds(650,10,130,100);
        jLabel.add(jLabel5);

        JButton add=new JButton("Add");
        add.setForeground(Color.white);
        add.setBackground(new java.awt.Color(0, 0, 255));
        add.setBounds(690,470,90,30);
        jLabel.add(add);

        JButton group2=new JButton("Group-2");
        group2.setBackground(new java.awt.Color(0, 0, 255));
        group2.setForeground(Color.white);
        group2.setBounds(445,14,95,27);
        jLabel.add(group2);

        JButton group1=new JButton("Group-1");
        group1.setBackground(new java.awt.Color(0, 0, 255));
        group1.setForeground(Color.white);
        group1.setBounds(340,14,95,27);
        jLabel.add(group1);

        group1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Group1.BuildMainWindow(x);
            }
        });

        group2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Group2.BuildMainWindow(x);
            }
        });

        add.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JL_ONLINE.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                int[] gr=JL_ONLINE.getSelectedIndices();
                String c=JOptionPane.showInputDialog(null,"Enter chat group uumber");
                int cn=Integer.parseInt(c);

                if(cn>2)
                {
                    JOptionPane.showMessageDialog(null,"Enter between 1 to 3");
                }
                else {
                    if(cn==1)
                    {
                        File file=new File("admin1.txt");
                        try {
                            Scanner scanner=new Scanner(file);
                            if(!scanner.hasNextLine())
                            {System.out.println("1");
                                String s=new String();
                                String j;
                                j=JOptionPane.showInputDialog(null,"Enter Password");
                                scanner.close();
                                FileWriter fileWriter=new FileWriter("admin1.txt");
                                PrintWriter printWriter=new PrintWriter(fileWriter);
                                printWriter.println(j);
                                printWriter.close();
                                try {
                                    FileWriter fileWriter1=new FileWriter("online1.txt");
                                    PrintWriter printWriter1=new PrintWriter(fileWriter1);

                                    List string=JL_ONLINE.getSelectedValuesList();
                                    String[] string1=new String[string.size()];
                                    for(int i=0;i<gr.length;i++)
                                    {
                                        printWriter1.println(string.get(i));
                                        string1[i]= (String) string.get(i);
                                        System.out.println("2sdfdsfsd");

                                    }
                                    printWriter1.println(UserName);
                                    Group1.JL_ONLINE.setListData(string1);
                                    for(int i=0;i<string1.length;i++)
                                    {
                                        System.out.println(string1[i]);
                                        System.out.println("3");
                                    }
                                    printWriter1.close();
                                   // FileWriter fileWriter2=new FileWriter("admin1.txt");
                                    //PrintWriter printWriter2=new PrintWriter(fileWriter2);
                                    printWriter.close();
                                    ChatClient.SEND("-has become the admin of group-1");
                                }
                                catch (Exception e)
                                {

                                }


                            }
                            else
                            {
                                String string=new String();
                                string=scanner.nextLine();
                                System.out.println("4");
                                String  j=JOptionPane.showInputDialog(null,"Enter Password");
                                if(j.equals(string))
                                {

                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null,"You are not allowed to add members");
                                }


                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else if(cn==2)
                    {
                        File file=new File("admin2.txt");
                        try {
                            Scanner scanner=new Scanner(file);
                            if(!scanner.hasNextLine())
                            {System.out.println("1");
                                String s=new String();
                                String j;
                                j=JOptionPane.showInputDialog(null,"Enter Password");
                                scanner.close();
                                FileWriter fileWriter=new FileWriter("admin2.txt");
                                PrintWriter printWriter=new PrintWriter(fileWriter);
                                printWriter.println(j);
                                printWriter.close();
                                try {
                                    FileWriter fileWriter1=new FileWriter("online2.txt");
                                    PrintWriter printWriter1=new PrintWriter(fileWriter1);

                                    List string=JL_ONLINE.getSelectedValuesList();
                                    String[] string1=new String[string.size()];
                                    for(int i=0;i<gr.length;i++)
                                    {
                                        printWriter1.println(string.get(i));
                                        string1[i]= (String) string.get(i);
                                        System.out.println("2sdfdsfsd");

                                    }
                                    printWriter1.println(UserName);
                                    Group1.JL_ONLINE.setListData(string1);
                                    for(int i=0;i<string1.length;i++)
                                    {
                                        System.out.println(string1[i]);
                                        System.out.println("3");
                                    }
                                    printWriter1.close();
                                    // FileWriter fileWriter2=new FileWriter("admin1.txt");
                                    //PrintWriter printWriter2=new PrintWriter(fileWriter2);
                                    printWriter.close();
                                    ChatClient.SEND("-has become the admin of group-2");
                                }
                                catch (Exception e)
                                {

                                }


                            }
                            else
                            {
                                String string=new String();
                                string=scanner.nextLine();
                                System.out.println("4");
                                String  j=JOptionPane.showInputDialog(null,"Enter Password");
                                if(j.equals(string))
                                {

                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null,"You are not allowed to add members");
                                }


                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    }


            }
        });



       //new p();
        try {

            File file1=new File("post.txt");
            Scanner scanner=new Scanner(file1);
            parea.selectAll();
            parea.replaceSelection("");

            while(scanner.hasNextLine())
            {
                parea.setFont(new java.awt.Font(Font.SANS_SERIF,Font.BOLD,13));
                parea.append(scanner.nextLine()+"\n");
            }
            scanner.close();
            // A_Chat_Client_GUI.TF_Message.setText("");
        }
        catch (Exception e)
        {
            System.out.println("wrong in post file");
        }

    }



    public static void Login_Action()
    {
        B_ENTER.addActionListener(
                new java.awt.event.ActionListener()
                {
                    public void actionPerformed(java.awt.event.ActionEvent evt )
                    {
                       // ACTION_B_ENTER();

                    }
                }
        );
    }
    public static void ACTION_B_ENTER (JFrame x,JPanel y)
    {

           // UserName=TF_UserNameBox.getText().trim();
            L_LoggedInAsBox.setText(UserName);

          try
          {
              FileWriter fileWriter=new FileWriter("names.txt",true);
              BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
              PrintWriter printWriter=new PrintWriter(bufferedWriter);
              //System.out.println(UserName);

              printWriter.println(UserName);
              printWriter.close();


          }
          catch (Exception e)
          {

          }


           // MainWindow=x;
            x.remove(y);
            x.remove(res_user);
            x.remove(res);
            x.remove(res_text);
            x.remove(admin);
            x.remove(user);
            x.remove(wel);
            BuildMainWindow(x);
            x.setTitle(UserName+"'s Chat Box");
            //LogInWindow.setVisible(false);
            B_SEND.setEnabled(true);
            B_DISCONNECT.setEnabled(true);
            B_CONNECT.setEnabled(false);
            Connect();



    }
    public static void Post()
    {
        try {
            FileWriter fileWriter=new FileWriter("post.txt",true);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            PrintWriter printWriter=new PrintWriter(bufferedWriter);
            printWriter.println("                                   Post by: "+UserName+"\n\n"+TF_Message.getText());
            printWriter.close();
            File file=new File("post.txt");
            Scanner scanner=new Scanner(file);
            parea.selectAll();
            parea.replaceSelection("");

            while(scanner.hasNextLine())
            {
                parea.setFont(new java.awt.Font(Font.SANS_SERIF,Font.BOLD,13));
                parea.append(scanner.nextLine()+"\n");
            }
            scanner.close();
            TF_Message.setText("");
        }
        catch (Exception e)
        {
            System.out.println("wrong in post file");
        }

    }
    public static void MainWindow_Action()
    {
        pbutton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        Post();
                    }
                }
        );

        B_SEND.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {

                        ACTION_B_SEND();
                    }
                }
        );
        B_DISCONNECT.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        ACTION_B_DISCONNECT();
                    }
                }
        );
        B_CONNECT.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        BuildLogInWindow();
                    }
                }
        );
        B_HELP.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        ACTION_B_HELP();
                    }
                }
        );
        B_ABOUT.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        ACTION_B_HELP();
                    }
                }
        );
    }
    public static void ACTION_B_SEND()
    {
        if(!TF_Message.getText().equals(""))
        {
            ChatClient.SEND(TF_Message.getText());
            TF_Message.requestFocus();
        }
    }
    public static void ACTION_B_DISCONNECT()
    {
        try
        {
            ChatClient.DISCONNECT();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void ACTION_B_HELP()
    {
        JOptionPane.showMessageDialog(null,"Multi-Client Chat Program\nDesigned By Mehedi Hasan Emon");
    }



}
