/**
 * @Package:
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2022/5/12 14:41
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */module sms.runtime {
     requires sms.service;
     requires sms.filestore;
     uses sms.service.StudentService;
}