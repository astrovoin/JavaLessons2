package Lesson7_8_Test.Client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;

public class Client3 {
    public static void main(String[] args)
    {
        int port = 8888;
        try
        {
            InetAddress inetAddress = InetAddress.getLocalHost(); //127.0.0.1
            Socket socket = new Socket(inetAddress, port);
            System.out.println("We have the connection...");
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            DataInputStream dis = new DataInputStream(inputStream);
            DataOutputStream dos = new DataOutputStream(outputStream);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("We are beginning.... Enter something....");



            new Thread(() -> {
                try {
                    messageFromServer(dis);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();


            new Thread(() -> {
                try {
                    messageForServer(dos, keyboard);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void messageFromServer(DataInputStream dis) throws IOException {
        while (true){
            String msgFromServer;
            msgFromServer = dis.readUTF();
            System.out.println("Server " + new Date().toString() + ": " + msgFromServer);
        }
    }

    private static void messageForServer(DataOutputStream dos, BufferedReader keyboard) throws IOException {
        while (true) {
            String msg = keyboard.readLine();
            dos.writeUTF(msg);
            dos.flush();
         //   System.out.println("Client " + new Date().toString() + ": " + msg);
        }
    }

}

