package com.example.anso04springquartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Package: com.example.anso04springquartz.job
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2022/7/26 16:31
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
@Slf4j
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("任务被执行了 ...[s%]", System.currentTimeMillis());
    }
}
