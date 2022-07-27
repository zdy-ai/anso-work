package com.example.anso04springquartz.quartz;

import ch.qos.logback.core.util.TimeUtil;
import com.example.anso04springquartz.job.MyJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Package: com.example.anso04springquartz.quartz
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2022/7/26 16:35
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
public class JobTest {

    public static void main(String[] args) throws Exception {
        //1.创建调度器 scheduler
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();

        //2.创建JobDetail 实例，并与Myjob 类绑定(job执行内容)
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("job1", "group1")
                .build();

        //3.构建trigger 实例，每隔30s执行一次
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(30)
                        .repeatForever())
                .build();
        //4.执行，开启调度器
        scheduler.scheduleJob(jobDetail, trigger);
        System.out.println("开始执行调度时间【" + System.currentTimeMillis() + "】");
        scheduler.start();

        //主线程睡眠1分钟，然后关闭调度器
//        Thread.currentThread().wait(1);
        scheduler.shutdown();
        System.out.println("结束执行调度时间【" + System.currentTimeMillis() + "】");
    }
}
