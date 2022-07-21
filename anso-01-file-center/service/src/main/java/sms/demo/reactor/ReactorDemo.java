package sms.demo.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Package: sms.demo.reactor
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2022/7/5 14:20
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
public class ReactorDemo {
    public static void main(String[] args) {
        //mono 创建方式
        Mono.empty().subscribe(System.out::println);
        Mono.just("hello mono").subscribe(System.out::println);

        //flux 创建方式 0-n元素序列
        //集合、数组
        Flux.just(1,2,3,4,5,6).subscribe(System.out::println);
        //迭代器
        Flux.fromIterable(Arrays.asList("a","b","c","d","e")).subscribe(System.out::println);
        //数组
        Flux.fromArray(new String[]{"a","b","c","d","e"}).subscribe(System.out::println);
        //流
        Flux.fromStream(Stream.of(1,2,3,4,5,6,7,8)).subscribe(System.out::println);
        //通过范围
        Flux.range(1,100).subscribe(System.out::println);
        /**
         * 2*0 = 0
         * 。。。
         * 2*9=18
         */
        Flux.generate(() -> 0, (i, sink) -> {
            sink.next("2 * " + i + "= " + 2 * i);
            if (i == 9) {
                sink.complete();
            }
            return 1 + i;
        }).subscribe(System.out::println);

    }
}
