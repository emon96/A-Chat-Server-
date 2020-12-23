import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class A_Chat_Client implements Runnable
{
    Socket SOCK;
    Scanner INPUT;
    Scanner SEND=new Scanner(System.in);
    PrintWriter OUT;
    public A_Chat_Client(Socket X)
    {
        this.SOCK=X;
    }
    public void run()
    {

        try {
            try {



                INPUT =new Scanner(SOCK.getInputStream());
                OUT=new PrintWriter(SOCK.getOutputStream());
                OUT.flush();
                checkStream();
            }
            finally {
                SOCK.close();
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
    public void  DISCONNECT() throws Exception
    {
        File file =
                new File("names.txt");
        Scanner sc = new Scanner(file);
        String  s=new String();
        String[] strings=new String[100];
        int i=0;
        while (sc.hasNextLine())
        {
            s=sc.nextLine();
            if(!s.equals(A_Chat_Client_GUI.UserName))
            {
                strings[i]=s;
                i++;
            }

        }
        FileWriter fileWriter=new FileWriter("names.txt");
        fileWriter=new FileWriter("names.txt",true);
        BufferedWriter b=new BufferedWriter(fileWriter);
        PrintWriter printWriter=new PrintWriter(b);
        for (int j=0;j<i;j++)
        {
            printWriter.println(strings[j]);
        }
        printWriter.close();

        OUT.println(A_Chat_Client_GUI.UserName+" has disconnected");
        OUT.flush();
        A_Chat_Client_GUI.MainWindow.setVisible(false);
       // SOCK.close();
        //JOptionPane.showMessageDialog(null,"You disconnected the ");
        System.exit(0);
    }
    public void checkStream()
    {

       /* try {
            try {


                INPUT =new Scanner(SOCK.getInputStream());

                OUT=new PrintWriter(SOCK.getOutputStream());
                OUT.flush();

            }
            finally {
                SOCK.close();
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }*/
        while (true)
        {
            try {

                File file=new File("post.txt");
                Scanner scanner=new Scanner(file);
                A_Chat_Client_GUI.parea.selectAll();
                A_Chat_Client_GUI.parea.replaceSelection("");

                while(scanner.hasNextLine())
                {
                    A_Chat_Client_GUI.parea.setFont(new java.awt.Font(Font.SANS_SERIF,Font.BOLD,13));
                    A_Chat_Client_GUI.parea.append(scanner.nextLine()+"\n");
                }
                scanner.close();
                // A_Chat_Client_GUI.TF_Message.setText("");
            }
            catch (Exception e)
            {
                System.out.println("wrong in post file");
            }
            try{
                File file =
                        new File("names.txt");
                Scanner sc = new Scanner(file);
                String s=new String();

                //String[] strings=new String[100];
                ArrayList<String> strings=new ArrayList<String>();
                int i=0;
                while (sc.hasNextLine())
                {
                    s=sc.nextLine();
                    if(!s.equals(A_Chat_Client_GUI.UserName))
                        strings.add(s);

                }
                String[]  str=new String[strings.size()];
                for(i=0;i<strings.size();i++)
                {
                    str[i]=strings.get(i);
                }
                A_Chat_Client_GUI.JL_ONLINE.setListData(str);
            }
            catch (Exception e)
            {

            }

            RECEIVE();
        }
    }
    public void RECEIVE()
    {
        if(INPUT.hasNext())
        {
            String MESSAGE=INPUT.nextLine();
            if(MESSAGE.contains("#?!"))
            {
                String TEMP1=MESSAGE.substring(3);
                TEMP1=TEMP1.replace("[","");
                TEMP1=TEMP1.replace("]","");
                String[] CurrentUsers=TEMP1.split(", ");
               // A_Chat_Client_GUI.JL_ONLINE.setListData(CurrentUsers);
            }
            else
            {
                int a=MESSAGE.indexOf("~");
                int b=MESSAGE.indexOf("!");

                if(a!=-1)
                {
                    StringTokenizer stringTokenizer=new StringTokenizer(MESSAGE,"~");
                    String s=stringTokenizer.nextToken();

                    File file=new File("online1.txt");
                    try {
                        Scanner scanner=new Scanner(file);
                        while (scanner.hasNextLine())
                        {
                            if(scanner.nextLine().equals(A_Chat_Client_GUI.UserName))
                            {
                                Group1.TA_CONVERSATION.append(s+"\n");
                            }
                        }
                        scanner.close();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }


                }
                else if(b!=-1)
                {
                    StringTokenizer stringTokenizer=new StringTokenizer(MESSAGE,"!");
                    String s=stringTokenizer.nextToken();

                    File file=new File("online2.txt");
                    try {
                        Scanner scanner=new Scanner(file);
                        while (scanner.hasNextLine())
                        {
                            if(scanner.nextLine().equals(A_Chat_Client_GUI.UserName))
                            {
                                Group2.TA_CONVERSATION.append(s+"\n");
                            }
                        }
                        scanner.close();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                else
                {
                    int c=MESSAGE.indexOf("#");
                    if(c!=-1)
                    {
                        StringTokenizer stringTokenizer=new StringTokenizer(MESSAGE,"#");
                        String s=stringTokenizer.nextToken();
                        File file=new File(s);
                        try {
                            FileWriter fileWriter = new FileWriter(A_Chat_Client_GUI.UserName + ".txt");
                            fileWriter.close();
                            String string=A_Chat_Client_GUI.UserName+".txt";
                            fileWriter=new FileWriter(string,true);
                            PrintWriter printWriter=new PrintWriter(fileWriter);
                            Scanner scanner = new Scanner(file);
                            while (scanner.hasNextLine()) {
                                printWriter.println(scanner.nextLine());
                                }
                                printWriter.close();
                            scanner.close();
                            } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                    else
                    {
                        A_Chat_Client_GUI.TA_CONVERSATION.append(MESSAGE+"\n");
                    }

                }


            }
        }
    }
    public void SEND(String  X)
    {
        OUT.println(A_Chat_Client_GUI.UserName+": "+X);
        OUT.flush();
        A_Chat_Client_GUI.TF_Message.setText("");
    }

}
