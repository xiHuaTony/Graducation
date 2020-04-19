package com.tony.heproject.service.impl;
import com.tony.heproject.service.AsyncService;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
@Service
public  class AsyncServiceImpl implements AsyncService {
    private static final Logger logger =  LoggerFactory.getLogger(AsyncServiceImpl.class);
        /**
         * 该线程任务：接受并解析客户端发送的指令，向客户端返回数据
         */
        @Override
        @Async("asyncServiceExecutor")
        public void executeAsync() {
            logger.info("start executeAsync");
            try {
                 ServerSocket server = null;
                 server = new ServerSocket(8003);
                 System.out.println("正在连接...");
                 Socket socket = server.accept();
                 System.out.println("连接客户端地址：" + socket.getRemoteSocketAddress());
                 System.out.println("已连接上...");
                // 封装输入流（接收客户端的流）
                BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
                DataInputStream dis = new DataInputStream(bis);
                // 一次读取一个byte
                byte[] bytes = new byte[1];
                String ret = "";
                while (dis.read(bytes) != -1) {
                    ret += bytesToHexString(bytes) + " ";
                    if (dis.available() == 0) {
                        //显示接收到的一个指令
                        System.out.println("客户端的地址为： "+socket.getRemoteSocketAddress() + "    接受到的十六进制数据： " + ret);
                        ret = "";
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            logger.info("end executeAsync");
        }

        /**
         * byte[]数组转换为16进制的字符串
         * @param bytes 要转换的字节数组
         * @return 转换后的结果
         */
        public String bytesToHexString(byte[] bytes) {
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

        /**
         * 16进制表示的字符串转换为字节数组
         * @param hexString 16进制表示的字符串
         * @return byte[] 字节数组
         */
        public static byte[] hexStringToByteArray(String hexString) {
        hexString = hexString.replaceAll(" ", "");
        int len = hexString.length();
        byte[] bytes = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            // 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个字节
            bytes[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4) + Character.digit(hexString.charAt(i + 1), 16));
        }
        return bytes;
    }
}





