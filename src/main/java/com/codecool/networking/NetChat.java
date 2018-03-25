package com.codecool.networking;

import com.codecool.networking.modes.Client;
import com.codecool.networking.modes.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NetChat {
    public static void main(String[] args) throws IOException {

        switch (args[0]) {
            case "client":
                new Client(getName()).start(Integer.parseInt(args[2]), args[1]);
                break;
            case "server":
                new Server(getName()).start(Integer.parseInt(args[1]));
                break;
        }
    }

    public static String getName() throws IOException {
        System.out.print("Enter your name: ");
        return new BufferedReader(new InputStreamReader(System.in)).readLine();

    }
}
