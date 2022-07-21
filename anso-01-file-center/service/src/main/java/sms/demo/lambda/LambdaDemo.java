package sms.demo.lambda;

/**
 * @Package: sms.runtime
 * @Description： java lambda demo
 * @Author: zdy AX1053
 * @Date: Created in 2022/7/5 9:47
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
public class LambdaDemo {

    public static void main(String[] args) {
        //正常创建线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("normal创建一个线程");
            }
        }).start();

        //lambda创建一个线程
        new Thread(()-> System.out.println("lambda创建一个线程")).start();

        //函数接口@FunctionalInterface

    }
}
