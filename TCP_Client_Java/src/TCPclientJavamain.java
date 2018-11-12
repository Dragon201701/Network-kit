/**
 * 
 */


//import java.io.IOException;
/**
 * @author yz-li
 *
 */

import java.net.*;
import java.io.*;
import java.util.*;

public class TCPclientJavamain {
	public static void start() throws UnknownHostException, IOException{
        Socket client = new Socket("144.92.48.171", 80);
        String modifiedSentence = null;
        try {
            PrintWriter output = new PrintWriter(client.getOutputStream(), true);
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("Enter some text: " + inFromServer);
            Scanner cin = new Scanner(System.in);
            String words = "";
 
            while (!words.equals("quit")) {
            	while(inFromServer.ready()) {
            		modifiedSentence = inFromServer.readLine();
            		System.out.println("Received from server: " + modifiedSentence);
            	}
            	System.out.print("Enter the text you want to send to server: ");
            	while(!inFromServer.ready() & !cin.hasNext()) {
            		
            	}
            	if(inFromServer.ready()) {
            		while(inFromServer.ready()) {
                		modifiedSentence = inFromServer.readLine();
                		System.out.println("Received from server: " + modifiedSentence);
                	}
            	}
            	else if(cin.hasNextLine()) {
            		words = cin.nextLine();
            		output.println(words);
                    System.out.println("Sending:  "+ words);
                    modifiedSentence = inFromServer.readLine();
            	}
            }
 
            cin.close();
        } finally {
            client.close();
        }
    }
	public static void main(String[] args) {
		System.out.println("Initializing socket server...");
		try {
			start();
		}catch(IOException ioe) {
			System.out.println("Socket I/O Exception occurs. Exception message: " + ioe.getMessage());
		}
	}
}
