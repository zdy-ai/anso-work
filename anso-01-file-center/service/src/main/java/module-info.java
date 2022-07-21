/**
 * @Package:
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2022/5/12 11:45
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */

module sms.service {
     exports sms.service;
     requires sms.model;
     requires sms.persistence;
     uses sms.persistence.PerService;
     provides sms.service.StudentService with sms.service.impl.StudentServiceImpl;
     exports sms.service.impl;
     //webflux依赖引入
     requires reactor.core;
     requires org.reactivestreams;

}