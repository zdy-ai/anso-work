package sms.demo.function;

import java.util.function.*;

/**
 * @Package: sms.demo.function
 * @Description： jdk function demo
 * @Author: zdy AX1053
 * @Date: Created in 2022/7/5 10:03
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
public class JdkFunctionDemo {
    public static void main(String[] args) {
        //supplier 没有输入 只有一个输出
        Supplier<String> supplier = () -> "this is supplier demo ";
        System.out.println(supplier.get());

        //consumer 只有一个输入，没有输出
        Consumer<String> consumer = i -> System.out.println("this is demo for " + i);
        consumer.accept("consumer");

        //Function 输入T 输出R
        Function<Integer, Integer> function = i -> i * i;
        System.out.println("Function demo: " + function.apply(5));

        //UnaryOperator 输入R 输出R
        UnaryOperator<Integer> unaryOperator = i -> i;
        System.out.println("unaryOperator dome: " + unaryOperator.apply(6));

        //BiFunction 输入T,U 输出R
        BiFunction<Integer, Integer, String> biFunction = (i, j) -> i + "*" + j + "=" + i * j;
        System.out.println("biFunction demo: " + biFunction.apply(3, 4));
    }
}
