/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.shimas.socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author felipe
 */
public class Cliente {
    
    public static void main(String[] args) throws IOException {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Bem Vindo Cliente!");
        System.out.println("Digite o IP do servidor que deseja se conectar: ");
        String ip = scanner.next();
        System.out.println("Digite a porta do servidor que deseja se conectar: ");
        int porta = scanner.nextInt();
        
        Socket socket = new Socket(ip, porta);
        
        Scanner respostaServidor = new Scanner(socket.getInputStream());
        
        while(true) {
            PrintStream saida =  new PrintStream(socket.getOutputStream());
            String teclado = scanner.nextLine();
            saida.println(teclado);
            
            try {
                String resposta = respostaServidor.nextLine();
                System.out.println("servidor: " + resposta);
            } catch(NoSuchElementException e) {
                System.out.println("Conexão encerrada");
                break;
            }
            
        }
        
        respostaServidor.close();
        scanner.close();
        socket.close();
    
    }
}
