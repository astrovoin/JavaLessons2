package Lesson6;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class Server
{
    public static void main(String[] args) throws IOException
    {
        int port = 8888;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("We are waiting a new client");
        Socket clientSocket = serverSocket.accept();
        System.out.println("We have a new client");

        InputStream inputStream = clientSocket.getInputStream(); // входящие сообщения
        OutputStream outputStream = clientSocket.getOutputStream(); //исходящие сообщения

        DataInputStream dis = new DataInputStream(inputStream);
        DataOutputStream dos = new DataOutputStream(outputStream);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));



            new Thread(() -> {
                try {
                    messageFromClient(dis);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();


            new Thread(() -> {
                try {
                    messageForClient(dos, keyboard);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();


    }

    private static void messageForClient(DataOutputStream dos, BufferedReader keyboard) throws IOException {
        while (true) {
            String msgForClient = keyboard.readLine();
            dos.writeUTF(msgForClient);
            dos.flush();
            System.out.println("Server " + new Date().toString() + ": " + msgForClient);
        }
    }

    private static void messageFromClient(DataInputStream dis) throws IOException {
        while (true) {
            String msg;
            msg = dis.readUTF();
            System.out.println("Client " + new Date().toString() + ": " + msg);
        }
    }
}
