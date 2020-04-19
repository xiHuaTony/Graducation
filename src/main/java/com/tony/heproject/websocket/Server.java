package com.tony.heproject.websocket;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static class ClientHandler implements Runnable {

        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        /**
         * 该线程任务：接受并解析客户端发送的指令
         * 向客户端返回数据
         */
        @Override
        public void run() {
            try {
                //封装输入流（接收客户端的流）
                BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
                DataInputStream dis = new DataInputStream(bis);
                byte[] bytes = new byte[1]; // 一次读取一个byte
                String ret = "";
                while (dis.read(bytes) != -1) {
                    ret += bytesToHexString(bytes) + " ";
                    if (dis.available() == 0) {
                        //显示接收到的一个指令
                            System.out.println(socket.getRemoteSocketAddress() + "接受到的十六进制数据： " + ret);
                            ret = "";
                     }
                   }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("client is over");
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(8003);
                System.out.println("listening...");
                Socket socket = server.accept();
                System.out.println("连接客户端地址：" + socket.getRemoteSocketAddress());
                System.out.println("connected...");
                ClientHandler handler = new ClientHandler(socket);
                Thread t = new Thread(handler);
                t.start();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * byte[]数组转换为16进制的字符串
     * @param bytes 要转换的字节数组
     * @return 转换后的结果
     */
    public static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }

}

