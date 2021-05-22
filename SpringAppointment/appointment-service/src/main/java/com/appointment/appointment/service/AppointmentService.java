package com.appointment.appointment.service;

import com.appointment.appointment.client.CardMapper;
import com.appointment.appointment.client.CardRestTemplateClient;
import com.appointment.appointment.client.DoctorMapper;
import com.appointment.appointment.client.DoctorRestTemplateClient;
import com.appointment.appointment.config.AppointmentConfig;
import com.appointment.appointment.config.AppointmentConfig2;
import com.appointment.appointment.domain.Appointment;
import com.appointment.appointment.repository.AppointmentRepository;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AppointmentService {

    @Autowired
    DoctorRestTemplateClient doctorRestTemplateClient;

    @Autowired
    CardRestTemplateClient cardRestTemplateClient;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    AppointmentConfig2 appointmentConfig2;

//    @HystrixCommand(
//            threadPoolKey = "getDoctor",
//            threadPoolProperties = {
//                    @HystrixProperty(name="maxQueueSize", value="10"),
//                    @HystrixProperty(name="coreSize", value="2")
//            },commandProperties = {
//                    @HystrixProperty(name="execution.isolation.strategy", value="THREAD")
//            , @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
//            }, fallbackMethod = "getDoctorByIdFallback"
//    )
//    @CircuitBreaker(name = "appointmentService", fallbackMethod = "getDoctorByIdFallback")
    public DoctorMapper getDoctorById(Long doctorId) {

//        //模拟远程调用超时的场景
//        try{
//            Thread.sleep(2000);
//        } catch(InterruptedException ex) {
//            ex.printStackTrace();
//        }

        return doctorRestTemplateClient.getDoctorById(doctorId);
    }

    //resilience4j的Fallback方法的输入参数需要添加额外的exception参数
//    public DoctorMapper getDoctorByIdFallback(Long doctorId, Throwable t) {
//        return new DoctorMapper(10000L, "FallbackCode", "FallbackName");
//    }

//    public DoctorMapper getDoctorByIdFallback(Long doctorId) {
//        return new DoctorMapper(10000L, "FallbackCode", "FallbackName");
//    }



    public Appointment generateAppointment(Long doctorId, Long cardId) {

        Appointment appointment = new Appointment();
        appointment.setDoctorId(doctorId);
        appointment.setCardId(cardId);
        appointment.setRemark(appointmentConfig2.getRemark());
        appointment.setCreateTime(new Date());

        appointmentRepository.save(appointment);

        return appointment;
    }


    private CardMapper getCard(String cardCode) {

        return cardRestTemplateClient.getCardByCardCode(cardCode);
    }

    private DoctorMapper getDoctor(String doctorName) {

        return doctorRestTemplateClient.getDoctorByDoctorName(doctorName);
    }

    public Appointment generateAppointment(String doctorName, String cardCode) {

        Appointment appointment = new Appointment();

        //获取远程Card信息
        CardMapper card = getCard(cardCode);
        if (card == null) {
            return appointment;
        }

        //获取远程Doctor信息
        DoctorMapper doctor = getDoctor(doctorName);
        if (doctor == null) {
            return appointment;
        }

        appointment.setDoctorId(doctor.getId());
        appointment.setCardId(card.getId());
        appointment.setRemark(appointmentConfig2.getRemark());
        appointment.setCreateTime(new Date());

        appointmentRepository.save(appointment);

        return appointment;
    }
}
