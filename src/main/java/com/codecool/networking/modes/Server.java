package com.codecool.networking.modes;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server extends Messenger {

    public Server(String name) {
        super(name);
    }

    public void start(int port) {
        boolean isActive = true;

        while (isActive) {
            System.out.println("Waiting for client...");
            try (
                    ServerSocket serverSocket = new ServerSocket(port);
                    Socket client = serverSocket.accept()
            ) {
                chat(client);
            } catch (SocketException e) {
                System.out.println("Client disconnected");
                isActive = false;
            } catch (ClassNotFoundException e) {
                System.out.println("Message unreadable");
            } catch (Exception e) {
                    System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
                    System.exit(1);

            }
        }
    }
}