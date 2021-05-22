package com.appointment.appointment.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppointmentConfig {

    @Value("${appointment.remark}")
    private String remark;

    public String getRemark() {
        return remark;
    }
}
