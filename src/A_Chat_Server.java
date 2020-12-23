import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class A_Chat_Server {
    public static ArrayList<Socket> ConnectionArray =new ArrayList<Socket>();
    public static ArrayList<String> CurrentUsers=new ArrayList<String>();

    public static void main(String args[]) throws Exception
    {
        try
        {
            final int PORT=4448;
            ServerSocket SERVER=new ServerSocket(PORT);
            System.out.println("waiting for clients");
            FileWriter fileWriter=new FileWriter("names.txt");
            FileWriter fileWriter1=new FileWriter("online1.txt");
            FileWriter fileWriter2=new FileWriter("admin1.txt");
            FileWriter fileWriter3=new FileWriter("online2.txt");
            FileWriter fileWriter4=new FileWriter("admin2.txt");
            fileWriter.close();
            fileWriter1.close();
            fileWriter2.close();
            fileWriter3.close();
            fileWriter4.close();
            while (true)
            {
                Socket SOCK=SERVER.accept();
                ConnectionArray.add(SOCK);
                //CurrentUsers.add(A_Chat_Client_GUI.res_text.getText());
                System.out.println("client connected :"+SOCK.getLocalAddress().getHostName());
                // AddUserName(SOCK);
                A_Chat_Server_Return CHAT=new A_Chat_Server_Return(SOCK);
                Thread X=new Thread(CHAT);
                X.start();
            }

        }
        catch (Exception e)
        {
            System.out.println("wrong in A_Chat_server");
        }

    }
    public static void AddUserName(Socket X) throws Exception
    {
        Scanner INPUT=new Scanner(X.getInputStream());
        String UserName=INPUT.nextLine();
        CurrentUsers.add(UserName);
        for(int i=1;i<=A_Chat_Server.ConnectionArray.size();i++)
        {
            Socket TEMP_SOCK=(Socket)A_Chat_Server.ConnectionArray.get(i-1);
            PrintWriter OUT=new PrintWriter(TEMP_SOCK.getOutputStream());
            OUT.flush();
        }
    }

}
