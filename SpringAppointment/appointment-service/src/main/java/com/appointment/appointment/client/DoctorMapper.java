package com.appointment.appointment.client;

import java.io.Serializable;

public class DoctorMapper implements Serializable {

    private Long id;
    private String doctorCode;
    private String doctorName;

    public DoctorMapper() {
    }

    public DoctorMapper(Long id, String doctorCode, String doctorName) {
        this.id = id;
        this.doctorCode = doctorCode;
        this.doctorName = doctorName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

}
