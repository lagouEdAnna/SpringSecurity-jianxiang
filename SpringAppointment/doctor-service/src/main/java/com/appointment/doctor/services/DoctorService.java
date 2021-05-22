package com.appointment.doctor.services;

import com.appointment.doctor.domain.Doctor;
import com.appointment.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
	
    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor getDoctorById(Long userId) {
        
        return doctorRepository.findById(userId).orElse(null);
    }
    
    public Doctor getDoctorByDoctorName(String doctorName) {
        
        return doctorRepository.findDoctorByDoctorName(doctorName);
    }

    public void addDoctor(Doctor doctor){
        doctorRepository.save(doctor);
    }

    public void updateDoctor(Doctor doctor){
        doctorRepository.save(doctor);
    }

    public void deleteDoctor(Doctor doctor){
        doctorRepository.delete(doctor);
    }
}
