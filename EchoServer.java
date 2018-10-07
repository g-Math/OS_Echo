/*
Gurbir Matharu
Matthew D'Angelo

Operating Systems
Assignment 2 Question 2
 */

import java.net.*;
import java.io.*;


public class EchoServer {

    public static void main(String [] args){
        try{
            /* essential steps to begin connection via port 6013*/
            ServerSocket sock = new ServerSocket((6013));
            Socket client = sock.accept();
            /* creates print writer for sending text over the socket*/
            PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
            /*buffer reader to read the text sent from the socket by client*/
            BufferedReader bin = new BufferedReader(new InputStreamReader(client.getInputStream()));


            /*start of the continuous loop*/
            while (true)
            {
                String line = "notNull";
                /*start of the loop, loop breaks if the text being sent is null */
                while(line!= null){
                    /*gets value of the string from client*/
                    line = bin.readLine();
                    /*if the line is not null, the server continues onto the next line*/
                    if ( line != null )
                        /*prints the line back into the socket but adds "Server: " in front of it
                        so the client knows the data is being sent back from the server
                         */
                        pout.println("Server: "+ line);
                    pout.flush();
                }

                /*close connection second while loop was exited*/
                client.close();
            }
        }


        catch(IOException ioe){
            System.err.println((ioe));
        }
    }
}
