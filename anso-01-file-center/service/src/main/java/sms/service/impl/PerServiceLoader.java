package sms.service.impl;

import sms.persistence.PerService;

import java.util.Optional;
import java.util.ServiceLoader;

/**
 * @Package: sms.service.impl
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2022/5/12 14:29
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
public class PerServiceLoader {
    public static PerService perService;

    static {
        final Optional<PerService> optionalPerService = ServiceLoader.load(PerService.class).findFirst();
        if (optionalPerService.isPresent()){
            perService = optionalPerService.get();
        }else {
            throw new RuntimeException("No PerService Get");
        }
    }
}
