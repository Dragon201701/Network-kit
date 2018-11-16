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
	public static void start(int port, String ip) throws UnknownHostException, IOException{
		System.out.println("Initializing socket server at 144.92.48.171:" + port);
        Socket client = new Socket(ip, port);
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
            	else if(cin.hasNext()) {
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
		int port = 0;
		String ip = "144.92.48.171";
		Scanner scnr = new Scanner(System.in);
		if(args.length != 2) {
			System.out.print("Enter the ip address: ");
			ip = scnr.nextLine();
			System.out.print("Enter the port number: ");
			port = scnr.nextInt();
		}
		else {
			ip = args[0];
			port = Integer.parseInt(args[1]);
		}
		
		
		try {
			start(port, ip);
		}catch(IOException ioe) {
			System.out.println("Socket I/O Exception occurs. Exception message: " + ioe.getMessage());
		}
	}
}
