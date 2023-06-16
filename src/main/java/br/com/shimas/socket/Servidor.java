/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.shimas.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author felipe
 */
public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4000);
        Socket socket = server.accept();
        
        System.out.println("Cliente conectou");
        
        InputStreamReader inputReader = new InputStreamReader(socket.getInputStream());
        BufferedReader reader = new BufferedReader(inputReader);
        String x;
        while((x = reader.readLine()) != null) {
            System.out.println("Servidor: " + x);
        }
        
    }
}
