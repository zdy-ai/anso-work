/**
 * 
 */
package com.open.capacity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.open.capacity.common.feign.GolbalFeignConfig;
import com.open.capacity.common.port.PortApplicationEnvironmentPreparedEventListener;

/** 
* @author owen 624191343@qq.com
 * @version 创建时间：2017年11月12日 上午22:57:51
* 类说明 
*/
@SpringBootApplication
@EnableFeignClients(defaultConfiguration=GolbalFeignConfig.class)
public class FileClientApp {
	
	public static void main(String[] args) {
//		固定端口启动
//		SpringApplication.run(OpenAuthServerApp.class, args);
		
		//随机端口启动
		SpringApplication app = new SpringApplication(FileClientApp.class);
        app.addListeners(new PortApplicationEnvironmentPreparedEventListener());
        app.run(args);
		
	}

}
