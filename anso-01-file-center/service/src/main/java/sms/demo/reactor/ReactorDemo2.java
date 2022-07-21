package sms.demo.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Package: sms.demo.reactor
 * @Description： ReactorDemo2
 * @Author: zdy AX1053
 * @Date: Created in 2022/7/5 14:20
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
public class ReactorDemo2 {
    public static void main(String[] args) {
        String src = "hello guys i am bole welcome to normal school jdk quick for prizev";
        Flux<String> s = Flux.fromArray(src.split(" "))
                .flatMap(i->Flux.fromArray(i.split("")))
                .distinct()
                .sort();
//                .subscribe().toString();
        s.subscribe(System.out::print);

    }
}
