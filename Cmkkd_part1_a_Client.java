package Networks;
import java.io.*;
import java.net.*;


public class Cmkkd_part1_a_Client {
    public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Socket sk=new Socket("10.151.0.253",80);
		BufferedReader sin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
		PrintStream sout=new PrintStream(sk.getOutputStream());
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (  true )
		{
			System.out.print("Chaitanya : ");
			s=stdin.readLine();
			sout.println(s);
			s=sin.readLine();
			System.out.print("Server_Manaswini : "+s+"\n");
  			if ( s.equalsIgnoreCase("Bye from Manaswini") )
 			   break;
		}
		 sk.close();
		 sin.close();
		 sout.close();
 		stdin.close();


	}

    
}
