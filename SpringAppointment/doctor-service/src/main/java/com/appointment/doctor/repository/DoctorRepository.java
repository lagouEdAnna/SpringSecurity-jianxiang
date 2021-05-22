package com.appointment.doctor.repository;

import com.appointment.doctor.domain.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long>  {

	Doctor findDoctorByDoctorName(String doctorName);
}
