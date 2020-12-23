import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.awt.Color.BLUE;
class p2 implements Runnable
{
    Thread t;
    String  username;
    JList jList;
    JTextArea area1;
    p2(JList j,String x ,JTextArea are)
    {
        area1=are;
        t=new  Thread(this);
        jList=j;
        username=x;
        t.start();
    }


    @Override
    public void run() {
        while(true)
        {
            try {
                File file=new File("online1.txt");
                Scanner scanner=new Scanner(file);
                 ArrayList<String> arrayList=new ArrayList<String>();
                while(scanner.hasNextLine())
                {
                    arrayList.add(scanner.nextLine());
                }
                String[] stri={"",""};
                String[] str=new String[arrayList.size()];
                int n=1;
                for(int i=0;i<arrayList.size();i++)
                {
                    if(!arrayList.get(i).equals(username))
                    {
                        str[i]=arrayList.get(i);
                    }


                }
                for(int i=0;i<arrayList.size();i++)
                {
                    if(arrayList.get(i).equals(username))
                    {
                        n=0;
                    }
                }
                if(n==1)
                {
                    jList.setListData(stri);
                }
                else
                {
                    jList.setListData(str);
                }



                scanner.close();
               // printWriter.close();

            }
            catch (Exception e)
            {

            }
            try {

                File file=new File("post1.txt");
                Scanner scanner=new Scanner(file);
                area1.selectAll();
               area1.replaceSelection("");
                area1.setFont(new java.awt.Font(Font.SANS_SERIF,Font.BOLD,13));
                File file1=new File("online1.txt");
                try {
                    Scanner scanner1=new Scanner(file1);
                    while (scanner1.hasNextLine())
                    {
                        if(scanner1.nextLine().equals(A_Chat_Client_GUI.UserName))
                        {
                            while(scanner.hasNextLine())
                            {
                                String sc=scanner.nextLine();

                                if(!sc.equals(""))
                                {
                                    area1.append(sc+"\n");
                                }

                            }
                        }
                    }
                    scanner.close();
                    scanner1.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Thread.sleep(2000);
                // A_Chat_Client_GUI.TF_Message.setText("");
            }
            catch (Exception e)
            {
               // System.out.println("wrong in post file");
            }
        }
    }
}
public class Group1 {
    public static String UserName = "Be connected first";
    private static int num=0;
    private static JFrame MainWindow = new JFrame();
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
    public static JLabel L_LoggedInAs = new JLabel();
    public static JLabel L_LoggedInAsBox = new JLabel();

    private static JFrame LogInWindow = new JFrame();
    private static JTextField TF_UserNameBox = new JTextField(20);
    private static JButton B_ENTER = new JButton("ENTER");
    private static JLabel L_EnterUserName = new JLabel("Enter Username: ");

    public static JTextArea parea=new JTextArea();
    private static JScrollPane ppane=new JScrollPane();
    private static JButton pbutton=new JButton("Post");

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

    public static void BuildMainWindow(JFrame x) {

        UserName=A_Chat_Client_GUI.UserName;
        new p2(JL_ONLINE,UserName,parea);
        L_LoggedInAsBox=A_Chat_Client_GUI.L_LoggedInAsBox;
        x.getContentPane().removeAll();
        MainWindow=x;
        MainWindow.setTitle(UserName + "'s Chat Box");
        // MainWindow.setSize(800, 500);
        // MainWindow.setLocation(200, 250);
        MainWindow.setResizable(false);
        ConfigureMainWindow();
        MainWindow_Action();
        MainWindow.setVisible(true);
    }
    public static void ConfigureMainWindow() {

        MainWindow.getContentPane().removeAll();
        // MainWindow.setBackground(new java.awt.Color(255, 255, 255));
        float a = (float) .1, b = (float) .3, c = (float) .8, d = (float) .3;
        MainWindow.getContentPane().setBackground(new java.awt.Color(a, b, c, d));
        MainWindow.setSize(800, 550);
        MainWindow.getContentPane().setLayout(null);

        ImageIcon imageIcon = new ImageIcon("f.JPG");
        Image image = imageIcon.getImage();
        Image image1 = image.getScaledInstance(800, 550, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image1);
        JLabel jLabel = new JLabel(imageIcon, JLabel.CENTER);
        jLabel.setBounds(0, 0, 800, 550);

        MainWindow.getContentPane().add(jLabel);

        B_SEND.setBackground(new java.awt.Color(0, 0, 255));
        B_SEND.setForeground(Color.WHITE);
        B_SEND.setText("SEND");
        // MainWindow.getContentPane().add(B_SEND);
        jLabel.add(B_SEND);
        B_SEND.setBounds(450, 470, 100, 30);

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
        TF_Message.setBounds(80, 470, 350, 30);

        jLabel.add(pbutton);
        pbutton.setBounds(570, 470, 100, 30);
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

        jpost.setBounds(140, 42, 140, 16);
        jLabel.add(jpost);

        L_ONLINE.setHorizontalAlignment(SwingConstants.CENTER);
        L_ONLINE.setText("Current Online");
        L_ONLINE.setForeground(Color.white);
        L_ONLINE.setToolTipText("");
        jLabel.add(L_ONLINE);
        L_ONLINE.setBounds(647, 140, 130, 16);


        JL_ONLINE.setForeground(BLUE);
        jLabel.add(JL_ONLINE);
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

        JButton add = new JButton("Delete");
        add.setForeground(Color.white);
        add.setBackground(new java.awt.Color(0, 0, 255));
        add.setBounds(690, 470, 90, 30);
       // jLabel.add(add);
        JButton emo0=new JButton("(-_-)");
        emo0.setBackground(new java.awt.Color(250, 0, 0));
        emo0.setForeground(Color.white);
        emo0.setBounds(80,430,70,30);
        jLabel.add(emo0);
        emo0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                A_Chat_Client_GUI.ChatClient.SEND("(-_-)"+" ~");
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
                A_Chat_Client_GUI.ChatClient.SEND("^_^"+" ~");
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
                A_Chat_Client_GUI. ChatClient.SEND("^_-"+" ~");
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
                A_Chat_Client_GUI. ChatClient.SEND("(^.^)"+" ~");
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
                A_Chat_Client_GUI.ChatClient.SEND("(*_*)"+" ~");
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
                A_Chat_Client_GUI.ChatClient.SEND(":')"+" ~");
            }
        });



        JButton main_group = new JButton("Main Group");
        main_group.setBackground(new java.awt.Color(0, 0, 255));
        main_group.setForeground(Color.white);
        main_group.setBounds(340, 14, 95, 27);
        jLabel.add(main_group);

        JButton group2=new JButton("Group-2");
        group2.setBackground(new java.awt.Color(0, 0, 255));
        group2.setForeground(Color.white);
        group2.setBounds(445,14,95,27);
        jLabel.add(group2);

        ImageIcon imageIcon5=new ImageIcon(A_Chat_Client_GUI.path);
        Image image5=imageIcon5.getImage();
        Image image6=image5.getScaledInstance(130,100,Image.SCALE_SMOOTH);
        imageIcon5=new ImageIcon(image6);
        JLabel jLabel5=new JLabel(imageIcon5,JLabel.CENTER);
        jLabel5.setBounds(650,10,130,100);
        jLabel.add(jLabel5);

        main_group.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                A_Chat_Client_GUI.BuildMainWindow(MainWindow);
            }
        });
        group2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Group2.BuildMainWindow(MainWindow);
            }
        });



        add.addActionListener(new ActionListener() {
                                  @Override
                                  public void actionPerformed(ActionEvent actionEvent) {
                                      JL_ONLINE.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                                      int[] gr=JL_ONLINE.getSelectedIndices();
                                      List string=JL_ONLINE.getSelectedValuesList();
                                      String[] string1=new String[string.size()];
                                      for(int i=0;i<gr.length;i++)
                                      {
                                         // printWriter1.println(string.get(i));
                                          System.out.println("jsdfkjkj");
                                          string1[i]= (String) string.get(i);
                                          System.out.println(string1[i]);
                                      }

                                  }
                              }

        );


    }


    public static void Post()
    {
        try {
            FileWriter fileWriter=new FileWriter("post1.txt",true);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            PrintWriter printWriter=new PrintWriter(bufferedWriter);
            if(!UserName.equals("Be connected first"))
            {
                printWriter.println("                                 Post by: "+UserName+"\n\n"+TF_Message.getText());
            }

            printWriter.close();
            File file=new File("post1.txt");
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
                        //System.out.println(TF_Message);
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
                       // BuildLogInWindow();
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
        File file=new File("online1.txt");
        try {
            Scanner scanner=new Scanner(file);
            while(scanner.hasNextLine())
            {
                if(A_Chat_Client_GUI.res_text.getText().equals(scanner.nextLine()))
                {
                    if(!TF_Message.getText().equals(""))
                    {
                        String string=TF_Message.getText();
                        string=string+" ~";
                        System.out.println(string);
                        A_Chat_Client_GUI.ChatClient.SEND(string);
                        TF_Message.setText("");
                        //string.requestFocus();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
    public static void ACTION_B_DISCONNECT()
    {
        try
        {
            A_Chat_Client_GUI.ChatClient.DISCONNECT();
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
