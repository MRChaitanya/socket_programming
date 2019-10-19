package Networks;
import java.net.*;
import java.io.*;

public class cmkkd_part1_a_Server {

   public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		ServerSocket ss=new ServerSocket(80);
		Socket sk=ss.accept();
		BufferedReader cin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
		PrintStream cout=new PrintStream(sk.getOutputStream());
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (  true )
		{
			s=cin.readLine();
  			if (s.equalsIgnoreCase("BYE from manaswini"))
  			{
				cout.println("BYE from chaitanya");
    				break;
  			  }
			System. out.print("Client_Manaswini : "+s+"\n");
			System.out.print("Chaitanya : ");
			s=stdin.readLine();
			cout.println(s);
		}
		ss.close();
 		sk.close();
 		cin.close();
		cout.close();
 		stdin.close();
	}    
}
