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
public class ReactiveStreamDome {

    public static void main(String[] args) {
        //1.创建一个发布者
        SubmissionPublisher publisher = new SubmissionPublisher();

        //2.创建一个订阅者
        Flow.Subscriber subscriber = new Flow.Subscriber() {

            Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                System.out.println("建立订阅关系");
                this.subscription = subscription;

                subscription.request(1);//第一次需要
            }

            @Override
            public void onNext(Object item) {
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

        //3.建立订阅关系
        publisher.subscribe(subscriber);

        for (int i = 0; i < 100; i++) {
            //4. 发送数据
            publisher.submit("hello reactive stream " + i);
        }
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
