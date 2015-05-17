package assessment;

import java.io.*;
import java.net.*;

public class frmclient 
{
 public static void main(String args[])throws Exception
 {

   try
        {
          DataInputStream d=new DataInputStream(System.in);
          System.out.print("\n1.fact\n2.Sum of digit\nEnter ur choice:");

           int ch=Integer.parseInt(d.readLine());
           System.out.print("\nEnter number:");
           int num=Integer.parseInt(d.readLine());

           Socket s=new Socket("localhost",1024);

           PrintStream ps=new PrintStream(s.getOutputStream());
           ps.println(ch+"");
           ps.println(num+"");

          DataInputStream dis=new DataInputStream(s.getInputStream());
           String response=dis.readLine();
                 System.out.print("Answer:"+response);


                s.close();
        }
        catch(Exception ex)
        {

        }
 }


}
