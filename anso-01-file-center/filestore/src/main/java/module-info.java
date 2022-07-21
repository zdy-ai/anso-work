/**
 * @Package:
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2022/5/12 14:04
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */module sms.filestore {
     requires sms.model;
     requires sms.persistence;
     provides sms.persistence.PerService with sms.filestore.PerServiceImpl;
}