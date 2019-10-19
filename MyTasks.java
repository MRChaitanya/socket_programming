package Networks;
import java.io.*;
import java.net.InetAddress;
import java.net.*;


public class MyTasks {
		    
	    private Socket socket;
        private DataInputStream input;
        private DataOutputStream output;

	    MyTasks(InetAddress acceptorHost, int acceptorPort)
	            throws SocketException, IOException {
	        socket = new Socket(acceptorHost, acceptorPort);
	        setStreams();
	    }


	    MyTasks(Socket socket) throws IOException {
	        this.socket = socket;
	        setStreams();
	    }


	    private void setStreams() throws IOException {
	        // get an input stream for reading from the data socket
	        input = new DataInputStream(socket.getInputStream());
	        output = new DataOutputStream(socket.getOutputStream());
	    }


	    public void sendMessage(String message) throws IOException {
	        output.writeUTF(message);
	        output.flush();
	    } // end sendMessage


	    public String receiveMessage() throws IOException {
	        String message = input.readUTF();
	        return message;
	    } // end receiveMessage


	    public void close() throws IOException {
	        socket.close();
	    }


	    public void sendFile(File file) throws IOException {
	        FileInputStream fileIn = new FileInputStream(file);
	        byte[] buf = new byte[Short.MAX_VALUE];
	        int bytesRead;        
	        while( (bytesRead = fileIn.read(buf)) != -1 ) {
	            output.writeShort(bytesRead);
	            output.write(buf,0,bytesRead);
	        }
	        output.writeShort(-1);
	        fileIn.close();
	    }



	    public void receiveFile(File file) throws IOException {
	        FileOutputStream fileOut = new FileOutputStream(file);
	        byte[] buf = new byte[Short.MAX_VALUE];
	        int bytesSent;        
	        while( (bytesSent = input.readShort()) != -1 ) {
	            input.readFully(buf,0,bytesSent);
	            fileOut.write(buf,0,bytesSent);
	        }
	        fileOut.close();
	    }    
	}
	    
	   
