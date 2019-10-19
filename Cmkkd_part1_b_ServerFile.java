/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networks;
import java.io.*;
import java.net.*;


public class Cmkkd_part1_b_ServerFile {
    

    public static void main(String[] args) {
        int serverPort = 80; // default port
        String message;

        if( args.length == 1 ) serverPort = Integer.parseInt(args[0]);
        try {
            // instantiates a stream socket for accepting
            // connections
            ServerSocket myConnectionSocket = new ServerSocket(serverPort);
           
            while( true ) { // forever loop
                // wait to accept a connection
                /**/System.out.println("Waiting for a connection.");
                MyTasks myDataSocket = new MyTasks(
                        myConnectionSocket.accept());
                /**/System.out.println("connection accepted");
                boolean done = false;
                while( !done ) {
                    message = myDataSocket.receiveMessage();

                    /**/System.out.println("message received: " + message);

                    
                    if( (message.trim()).equals("200") ) {

                            File outFile = new File("C:\\Users\\Chaitanya Mallepudi\\Desktop\\SentFile.txt");
                            System.out.println("File received and about to append");
                        myDataSocket.receiveFile(outFile);
                        myDataSocket.sendMessage("File received "+outFile.length()+" bytes");
                        
                        System.out.println(outFile);
                        BufferedReader br1= new BufferedReader(new FileReader(outFile));
                        String line=null;
                        while((line=br1.readLine())!=null)
                        {
                        	System.out.println(line);
                        }
                        BufferedWriter writer=new BufferedWriter(new FileWriter(outFile,true));
                        writer.newLine();
                        writer.write("This is an added line from a server)");
                        writer.close();
                        myDataSocket.sendFile(outFile);
                        
                        System.out.print("file appended successfully");
                    }

                } // end while !done
            } // end while forever
        } // end try
        catch (Exception ex) {
            ex.printStackTrace();
        }
    } // end main
} // end class
