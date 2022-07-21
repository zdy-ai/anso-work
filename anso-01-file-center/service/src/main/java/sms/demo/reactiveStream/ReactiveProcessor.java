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
public class ReactiveProcessor extends SubmissionPublisher<String> implements Flow.Processor<String, String> {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("Processor 建立订阅关系");
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(String item) {
        System.out.println("Processor 接收数据：" + item);
        //中间处理 数据发送给订阅者
        this.submit(item.toUpperCase());
        //背压实现的核心
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Processor 出现异常");
        throwable.printStackTrace();
        this.subscription.cancel();
    }

    @Override
    public void onComplete() {
        System.out.println("Processor 数据接收完成");
    }
}
