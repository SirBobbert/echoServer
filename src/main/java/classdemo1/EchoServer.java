package classdemo1;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static final int DEFAULT_PORT = 2345;

    public static void main(String[] args) {
        int port = 2345;
        if (args.length == 1) {
            port = Integer.parseInt(args[0]);
        }

        EchoServer echoServer = new EchoServer();
        try {
            echoServer.runServer();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void runServer() throws IOException, InterruptedException {

        int counter = 0;
        int limit = 2;

        ServerSocket ss = new ServerSocket(DEFAULT_PORT);

        while (counter < limit) {
            counter++;

            Socket client = ss.accept();

            ClientHandler c1 = new ClientHandler(client);
            c1.start();
            c1.join();

        }


    }
}