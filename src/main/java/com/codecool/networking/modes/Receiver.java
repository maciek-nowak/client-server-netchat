package com.codecool.networking.modes;

import com.codecool.networking.data.Message;

import java.io.ObjectInputStream;
import java.net.Socket;

public class Receiver extends Thread {

    private Socket client;

    public Receiver(Socket client) {
        this.client = client;
    }

    public void run() {
        try (ObjectInputStream in = new ObjectInputStream(client.getInputStream())) {

            while (true) {

                System.out.println((Message) in.readObject());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
