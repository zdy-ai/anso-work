package sms.runtime;

import sms.service.ServiceException;
import sms.service.StudentService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Package: sms.runtime
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2022/5/12 14:43
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
public class CommandRunner {
    private Map<String, Object> services = new HashMap<>();

    private Map<String, Map<String, Method>> methods = new HashMap<>();

    private Map<String, Class<?>> serviceTypes = Map.of("student", StudentService.class);

    public CommandRunner() {
        serviceTypes.forEach((type, clazz) ->
                ServiceLoader.load(clazz).findFirst().ifPresent(obj -> {
                    services.put(type, obj);
                    methods.put(type, Stream.of(obj.getClass().getDeclaredMethods()).collect(Collectors.toMap(Method::getName, Function.identity())));
                })
        );
    }

    public void run(String service, String task, List<Object> args) {
        Object serviceObj = services.get(service);
        Method method = methods.get(service).get(task);
        try {
            Object result = method.invoke(serviceObj, args.toArray());
            System.out.println(result);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
