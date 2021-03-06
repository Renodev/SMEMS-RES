package com.rnc.smems.res.services;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import com.rnc.smems.res.entities.OverTime;
import com.rnc.smems.res.entities.Staff;
import com.rnc.smems.res.repositories.OverTimeRepository;


@LocalBean
@Stateless
public class OverTimeService {
	
	@Inject
	private OverTimeRepository overtimeRepository;
	
	public void save (OverTime overtime) {
		if (overtime.getId() == 0) {
			overtime.setDate(LocalDate.now());
			overtimeRepository.save(overtime);
		} else {
			update(overtime);
		}
	}
	
	public void update (OverTime overtime) {
		overtimeRepository.update(overtime);
	}
	
	public void delete (OverTime overtime) {
		OverTime ist = findByID(overtime.getId());
		overtimeRepository.delete(ist);
	}
	
	public OverTime findByID (long id) {
		return overtimeRepository.findByID(id);
	}
	
	public List<OverTime> findAll () {
		return overtimeRepository.findAll();
	}
	
	public List<OverTime> findByStaff(Staff staff){
		return overtimeRepository.findByStaff(staff.getId());
	}
	
	public List<OverTime> findByStaffAndDateFromAndDateTo(Staff staff, String dateFrom, String dateTo){
		return overtimeRepository.findByStaffAndDateFromAndDateTo(staff.getId(), dateFrom, dateTo);
	}
	
	//public List<OverTime> findByMonth(){
		//return overtimeRepository.findByMonth();
	//}
}
