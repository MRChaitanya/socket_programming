package Networks;
import java.io.*;
import java.net.InetAddress;

public class Cmkkd_part1_b_Client_File {
    
         public static void main(String[] args) {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        File file = new File("C:\\Users\\Chaitanya Mallepudi\\Desktop\\TransferFile.txt");

        try {
            System.out.println("Welcome to the client\n"
                    + "What is the ip address of the server?");
            String hostName = br.readLine();
            if( hostName.length() == 0 ) 
                hostName = "localhost"; 
            System.out.println("What is the port number of the server?");
            String portNum = br.readLine();
            if( portNum.length() == 0 ) portNum = "80"; // default port number
            MyTasks socket = new MyTasks(InetAddress.getByName(hostName),Integer.parseInt(portNum));
            boolean done = false;
            String echo;
            while( !done ) {

                String message = br.readLine();
                boolean messageOK = false;

                     if( message.equals("200") ) {
                    messageOK = true;
                    socket.sendMessage("200");
                    socket.sendFile(file);
                      
                }
                 // get reply from server
                echo = socket.receiveMessage();
                System.out.println(echo);
                
                 File outFile1 = new File("C:\\Users\\Chaitanya Mallepudi\\Desktop\\ReceivedFile.txt");
                
                socket.receiveFile(outFile1);
                
                System.out.println("Appended file received successfully");
                
                System.out.println(outFile1);
                
                BufferedReader br1= new BufferedReader(new FileReader(outFile1));
                String line=null;
                while((line=br1.readLine())!=null)
                {
                	System.out.println(line);
                }
               
            } 
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        } 
    } 
} 