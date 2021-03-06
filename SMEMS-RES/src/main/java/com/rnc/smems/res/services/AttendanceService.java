package com.rnc.smems.res.services;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.rnc.smems.res.entities.Attendance;
import com.rnc.smems.res.entities.Staff;
import com.rnc.smems.res.repositories.AttendanceRepository;

@LocalBean
@Stateless
public class AttendanceService {
	
	@Inject
	private AttendanceRepository attendanceRepository;
	
	public void save(Attendance attendance) {
		if(attendance.getId() == 0) {
			attendanceRepository.save(attendance);
		} else {
			update(attendance);
		}
	}
	
	public void update(Attendance attendance) {
		attendanceRepository.update(attendance);
	}
	
	public void delete(Attendance attendance) {
		Attendance att = findByID(attendance.getId());
		attendanceRepository.delete(att);
	}
	
	public Attendance findByID(long id) {
		return attendanceRepository.findByID(id);
	}
	
	public List<Attendance> findByDate(LocalDate date){
		return attendanceRepository.findByDate(date);
	}
	
	public List<Attendance> findAll(){
		return attendanceRepository.findAll();
	}
	
	public List<Attendance> findByAbsent(Staff staff){
		return attendanceRepository.findByAbsent(staff.getId());
	}
	
	public List<Attendance> findByAttendance(LocalDate date){
		return attendanceRepository.findByAttendance(date);
		
	}
	
}

