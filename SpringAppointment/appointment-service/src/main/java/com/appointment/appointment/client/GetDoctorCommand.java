package com.appointment.appointment.client;

import com.netflix.hystrix.*;
import org.springframework.beans.factory.annotation.Autowired;

public class GetDoctorCommand extends HystrixCommand<DoctorMapper> {

    @Autowired
    private DoctorRestTemplateClient doctorRestTemplateClient;

    protected GetDoctorCommand(String name) {
        super(Setter.withGroupKey(
                //设置服务分组
                HystrixCommandGroupKey.Factory.asKey("appointmentGroup"))
                //设置命令键
                .andCommandKey(HystrixCommandKey.Factory.asKey("appointmentCommandKey"))
                //设置线程池键
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey(name))
                //设置命令属性
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(5000))
                //设置线程池属性
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withMaxQueueSize(10).withCoreSize(2))
        );
    }

    @Override
    protected DoctorMapper run() throws Exception {
        return doctorRestTemplateClient.getDoctorById(1L);
    }

    @Override
    protected DoctorMapper getFallback() {
        return new DoctorMapper(10000L, "FallbackDemoCode", "FallbackDemoName");
    }
}
