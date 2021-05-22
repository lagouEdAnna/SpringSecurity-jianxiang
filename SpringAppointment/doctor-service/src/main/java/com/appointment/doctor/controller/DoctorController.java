package com.appointment.doctor.controller;

import com.appointment.doctor.domain.Doctor;
import com.appointment.doctor.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="doctors")
public class DoctorController {
//
//    @Autowired
//    DoctorRestTemplateClient doctorRestTemplateClient;
//
//    @GetMapping(value="/{name}")
//    public String hello(@PathVariable("name") String name) {
//        return "Hello" + ":" + name;
//    }
//
//    @GetMapping(value="/eureka")
//    public List<String> getEurekaServices() {
//
//        return doctorRestTemplateClient.getEurekaServices();
//    }
//
//    @GetMapping(value="/ribbon/{name}")
//    public String getHello(@PathVariable("name") String name) {
//        //TODO：作业：通过请求端口验证服务访问是否已经集成了负载均衡
//
//        return doctorRestTemplateClient.hello(name);
//    }

    @Autowired
    private DoctorService doctorService;

    @GetMapping(value="/{doctorId}")
    public Doctor getDoctorById(@PathVariable("doctorId") Long doctorId) {
        return new Doctor(doctorId, "DemoCode", "DemoName");

    }

    @GetMapping(value="/doctorName/{doctorName}")
    public Doctor getDoctorByDoctorName(@PathVariable("doctorName") String doctorName) {
        return doctorService.getDoctorByDoctorName(doctorName);
    }

    @PostMapping(value = "/")
    public void addDoctor(@RequestBody Doctor doctor) {
        doctorService.addDoctor(doctor);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void updateDoctor(@RequestBody Doctor doctor) {
        doctorService.updateDoctor(doctor);
    }

    @RequestMapping(value = "/{doctorId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDoctor(@PathVariable("doctorId") Long doctorId) {
        Doctor doctor = new Doctor();
        doctor.setId(doctorId);

        doctorService.deleteDoctor(doctor);
    }

}
