package sms.demo.function;

/**
 * @Package: sms.runtime
 * @Description： java function demo
 * @Author: zdy AX1053
 * @Date: Created in 2022/7/5 9:46
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
@FunctionalInterface
interface InterDemoA{
    void doStart();
}

@FunctionalInterface
interface InterDemoB{
    void doStart();
}

public class JavaFunctionDemo {
    void doStart(InterDemoA demoA){
        System.out.print("function A ");
        demoA.doStart();
    }

    void doStart(InterDemoB demoB){
        System.out.print("function A ");
        demoB.doStart();
    }

    public static void main(String[] args) {
        JavaFunctionDemo functionDemo = new JavaFunctionDemo();
        functionDemo.doStart((InterDemoB)()-> System.out.print("do start"));
    }

}
