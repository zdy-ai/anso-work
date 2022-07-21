package sms.demo.reactiveStream;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * @Package: sms.demo.reactiveStream
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2022/7/5 11:39
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
public class ReactiveStreamDome2 {

    public static void main(String[] args) {
        //1.创建一个发布者
        SubmissionPublisher publisher = new SubmissionPublisher();

        //2.创建处理者
        ReactiveProcessor processor = new ReactiveProcessor();

        //3.创建者与处理者建立订阅关系
        publisher.subscribe(processor);

        //4.创建最终订阅者
        Flow.Subscriber<String> subscriber = new Flow.Subscriber<String>() {

            Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                System.out.println("建立订阅关系");
                this.subscription = subscription;

                subscription.request(1);//第一次需要
            }

            @Override
            public void onNext(String item) {
                System.out.println("接收数据:" + item);
                //业务处理
                subscription.request(10);//背压
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("发生错误了");
            }

            @Override
            public void onComplete() {
                System.out.println("接收完成");
            }
        };

        //5.中间处理器与订阅者建立订阅关系
        processor.subscribe(subscriber);


        for (int i = 0; i < 500; i++) {
            //4. 发送数据
            System.out.println("发布数据 = " + i);
            processor.submit("bole: " + i);
        }
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
