package com.tony.heproject.websocket;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;

public class Client {

    public static void main(String[] args) {

        Socket socket = null;
        try {
            System.out.println("connecting...");
            socket = new Socket("127.0.0.1", 8003);
            System.out.println("connection success");
            int cnt=0;
             while (true) {
                      //抓取指令
                      String order = Client.instruct();
                    if (order.length()==8){
                      //指令转换为字节流
                      byte[] bytes = hexStringToByteArray(order);
                      OutputStream os = socket.getOutputStream();
                      os.write(bytes);
                      //指令清空
                      order=null;
                      cnt++;
                     }
                  }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {

                }
            }
        }
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
            bytes[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4) + Character
                    .digit(hexString.charAt(i + 1), 16));
        }
        return bytes;
    }

    /**
     * 生成六种指令
     */
    public static String instruct() {
        //帧头:0X8A8BCD
        StringBuffer str = new StringBuffer();
        str.append("8A8BCD");
        /**
         *随机拼接六种功能字
         */
        Random r = new Random();
        //生成int类型的随机数
        //[0-5]之间的随机数
        int ran = r.nextInt(6);
        ran = ran + 1;
        switch (ran) {
            case 1:
                str.append("01");
                break;
            case 2:
                str.append("02");
                break;
            case 3:
                str.append("03");
                break;
            case 4:
                str.append("04");
                break;
            case 5:
                str.append("05");
                break;
            case 6:
                str.append("06");
                break;
            default:
                System.out.println("指令错误");
        }
            //此时指令生成完毕,将StringBuffer转换为String
            String s = str.toString();
            return  s;
    }
}
