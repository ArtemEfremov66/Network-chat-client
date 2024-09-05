package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name = "Arti Squirrel";
        Scanner scanner = new Scanner(System.in);
        String host = "127.0.0.1";
        int port = 8089;

        try(Socket clientSocket = new Socket(host, port);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println(name);
            String response = in.readLine();
            System.out.println(response);

            while (true) {
                String message = scanner.nextLine();
                out.println(message);
                if (message.equals("/exit")) {
                    break;
                } else {
                    String respMessage = in.readLine();
                    System.out.println(respMessage);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}