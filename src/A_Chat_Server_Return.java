import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;

public class A_Chat_Server_Return implements Runnable{
    Socket SOCK;
    private Scanner INPUT;
    private PrintWriter OUT;
    String MESSAGE="";
    public A_Chat_Server_Return(Socket X)
    {
        this.SOCK=X;
    }

    public void CheckConnection() throws Exception
    {
        if(!SOCK.isConnected())
        {
            for (int i=1;i<=A_Chat_Server.ConnectionArray.size();i++)
            {
                if(A_Chat_Server.ConnectionArray.get(i)==SOCK)
                {
                    A_Chat_Server.ConnectionArray.remove(i);
                }
            }
            for (int i=1;i<=A_Chat_Server.ConnectionArray.size();i++)
            {
                Socket TEMP_SOCK=(Socket)A_Chat_Server.ConnectionArray.get(i-1);
                PrintWriter TEMP_OUT=new PrintWriter(TEMP_SOCK.getOutputStream());
                TEMP_OUT.println(TEMP_SOCK.getLocalAddress().getHostName()+"disconnected");
                TEMP_OUT.flush();
                System.out.println(TEMP_SOCK.getLocalAddress().getHostName()+"disconnected");

            }
        }
    }
    public void run()
    {
        int  n=0;
        try
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
            try {
                INPUT=new Scanner(SOCK.getInputStream());
                OUT=new PrintWriter(SOCK.getOutputStream());
                while (true)
                {

                    CheckConnection();

                    if(!INPUT.hasNext())
                    {
                        return;
                    }
                    MESSAGE=INPUT.nextLine();
                    int in=MESSAGE.indexOf("@");
                    System.out.println("Client said:"+MESSAGE);
                    if(in!=-1)
                    {
                        StringTokenizer stringTokenizer=new StringTokenizer(MESSAGE,"@");
                        String s1=stringTokenizer.nextToken();
                        String s2=stringTokenizer.nextToken();
                        try {
                            File file=new File("names.txt");
                            Scanner scanner=new Scanner(file);
                            while (scanner.hasNextLine())
                            {

                                String un=scanner.nextLine();
                                System.out.println("-"+un);
                                if(s2.equals(un))
                                {
                                    Socket TEMP_SOCK=(Socket)A_Chat_Server.ConnectionArray.get(n);
                                    PrintWriter TEMP_OUT=new PrintWriter(TEMP_SOCK.getOutputStream());
                                    TEMP_OUT.println(s1);
                                    TEMP_OUT.flush();
                                    System.out.println("Sent to: "+TEMP_SOCK.getLocalAddress().getHostName());
                                    break;
                                }
                                n++;

                            }
                        }
                        catch (Exception e)
                        {
                            System.out.println(""+e.getMessage());
                        }


                    }
                    else
                    {
                        for (int i=1;i<=A_Chat_Server.ConnectionArray.size();i++)
                        {
                            Socket TEMP_SOCK=(Socket)A_Chat_Server.ConnectionArray.get(i-1);
                            PrintWriter TEMP_OUT=new PrintWriter(TEMP_SOCK.getOutputStream());
                            TEMP_OUT.println(MESSAGE);
                            TEMP_OUT.flush();
                            System.out.println("Sent to: "+TEMP_SOCK.getLocalAddress().getHostName());

                        }
                    }

                }
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
}
