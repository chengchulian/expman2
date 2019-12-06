package com.mzy.expman.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName WebAppConfig
 * @Description 配置类
 * @Author 程方园
 * @Date 2019/11/2 13:58
 * @Version 1.0
 */

@Configuration
public class WebAppConfig {

    @Value("${excelPath}")
    private String excelPath;


    @Bean(name = "heiMaoExpTheadPool")
    public ThreadPoolTaskExecutor heiMaoExpTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程数量
        executor.setCorePoolSize(5);
        //最大线程数量
        executor.setMaxPoolSize(10);
        //等待队列数量
        executor.setQueueCapacity(100);
        //线程活跃时间
        executor.setKeepAliveSeconds(20);
        //线程名称前缀
        executor.setThreadNamePrefix("heiMaoExpPool");
        //拒绝行为策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();

        return executor;
    }

    @Bean(name = "HeiMaoZipCodeTheadPool")
    public ThreadPoolTaskExecutor HeiMaoZipCodeTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程数量
        executor.setCorePoolSize(5);
        //最大线程数量
        executor.setMaxPoolSize(10);
        //等待队列数量
        executor.setQueueCapacity(500);
        //线程活跃时间
        executor.setKeepAliveSeconds(20);
        //线程名称前缀
        executor.setThreadNamePrefix("HeiMaoZipCodePool");
        //拒绝行为策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();

        return executor;
    }



    @Bean(name = "FamiportExpTheadPool")
    public ThreadPoolTaskExecutor FamiportExpTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程数量
        executor.setCorePoolSize(20);
        //最大线程数量
        executor.setMaxPoolSize(100);
        //等待队列数量
        executor.setQueueCapacity(1000);
        //线程活跃时间
        executor.setKeepAliveSeconds(20);
        //线程名称前缀
        executor.setThreadNamePrefix("FamiportExpPool");
        //拒绝行为策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();

        return executor;
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {

        return new WebMvcConfigurer() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/excel/**").addResourceLocations("file:" + excelPath);
            }
        };
    }

}

