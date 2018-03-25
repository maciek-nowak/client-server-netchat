package com.codecool.networking.modes;

import java.net.Socket;
import java.net.SocketException;

public class Client extends Messenger {

    public Client(String name) {
        super(name);
    }

    public void start(int port, String host) {

        while (true) {
            try (
                    Socket client = new Socket(host, port)
            ) {
                chat(client);
            } catch (Exception e) {
                if (e.getClass().equals(SocketException.class)) {
                    System.out.println("Server disconnected");
                    System.exit(0);
                } else if (e.getClass().equals(ClassNotFoundException.class)) {
                    System.out.println("Message unreadable");
                } else {
                    System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
                    System.exit(1);
                }
            }
        }
    }
}
