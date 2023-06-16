/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.shimas.socket;


import java.net.InetAddress;
import java.net.UnknownHostException;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class MeuEnderecoIP {

    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress address = addresses.nextElement();
                    if (!address.isLoopbackAddress() && address.getHostAddress().indexOf(':') == -1) {
                        String enderecoIP = address.getHostAddress();
                        System.out.println("Endereço IP da máquina: " + enderecoIP);
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
