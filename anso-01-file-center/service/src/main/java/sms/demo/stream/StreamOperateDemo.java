package sms.demo.stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @Package: sms.demo.stream
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2022/7/5 10:22
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
public class StreamOperateDemo {

    public static void main(String[] args) {
        String[] arr = {"bole", "webflux", "redis", "spring","bo_le", "microservice", "bo_le"};
        //1.数组
        Arrays.stream(arr).forEach(System.out::println);

        //2. List
        Arrays.asList(arr).stream().forEach(System.out::println);

        //3.Stream of
        Stream.of(arr).forEach(System.out::println);

        //4.迭代器 打印1-10元素
        Stream.iterate(1, i -> i + 1).limit(10).forEach(System.out::println);

        //5. generate  打印前10个随机数
        Stream.generate(() -> new Random().nextInt(10)).limit(10).forEach(System.out::println);

        //流编程完整案例   结果输出 b,e,l,o
        Stream.of(arr).filter(i -> !i.isEmpty())
                .distinct()
                .sorted()
                .limit(1)
                .map(i->i.replace("_", ""))
                .flatMap(i->Stream.of(i.split("")))
                .sorted()
//                .findFirst() //在流编程中 中止操作只能有一个， 中间操作可以有多个
//                .peek(i->System.out.println(i));//在流编程中必须要有一个终止操作
        .forEach(s -> System.out.println(s));


    }
}
