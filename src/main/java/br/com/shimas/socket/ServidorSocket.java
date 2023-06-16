package br.com.shimas.socket;

import java.io.*;
import java.net.*;

public class ServidorSocket {

    public static void main(String[] args) {

        try {
            ServerSocket servidorSocket = new ServerSocket(4000);
            System.out.println("Servidor iniciado");

            while (true) {
                Socket clienteSocket = servidorSocket.accept();
                System.out.println("Cliente conectado");

                BufferedReader entradaDoCliente = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
                PrintStream saidaParaCliente = new PrintStream(clienteSocket.getOutputStream());

                String mensagemDoCliente;
                while (!(mensagemDoCliente = entradaDoCliente.readLine()).equals("sair")) {
                    System.out.println("Cliente: " + mensagemDoCliente);
                    
                    saidaParaCliente.println("Mensagem recebida: " + mensagemDoCliente + ", digite 'sair' para encerrar");
                }

                clienteSocket.close();
                System.out.println("Cliente desconectado");
                servidorSocket.close();
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}

