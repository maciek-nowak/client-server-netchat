package com.codecool.networking.modes;

import com.codecool.networking.data.Message;

import java.io.*;
import java.net.Socket;

public abstract class Messenger {

    private String name;
    boolean isActive = true;
    BufferedReader stdin;

    Messenger(String name) {
        this.name = name;
        stdin = new BufferedReader(new InputStreamReader(System.in));
    }

    void chat(Socket client) throws Exception {
        new Receiver(client).start();

        try (ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream())) {
            System.out.println("Connection established");
            while (isActive) {

                Message m = new Message(stdin.readLine(), name);
                System.out.println(m);
                out.writeObject(m);
                out.flush();
                            }
        } catch (Exception e) {
            throw e;
        }
    }
}
