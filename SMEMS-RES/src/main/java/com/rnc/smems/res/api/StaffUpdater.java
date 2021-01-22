package com.rnc.smems.res.api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rnc.smems.res.entities.Staff;
import com.rnc.smems.res.enums.Position;
import com.rnc.smems.res.services.StaffService;

@Path("/staffupdater/{id}/{name}/{phone}/{email}/{position}/{salary}/{address}")
public class StaffUpdater {
	
	@Inject
	private StaffService staffService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public boolean updateStaff (
			@PathParam("id") String id,
			@PathParam("name") String name,
			@PathParam("phone") String phone,
			@PathParam("email") String email,
			@PathParam("position") String position,
			@PathParam("salary") String salary,
			@PathParam("address") String address
			) {
		
		try {
			Staff staff = new Staff();
			staff.setId(Long.parseLong(id));
			staff.setName(name);
			staff.setPhone(phone);
			staff.setEmail(email);
			switch (position) {
			case "1": staff.setPosition(Position.Manager);break;
			case "2": staff.setPosition(Position.HR_Staff);break;
			case "3": staff.setPosition(Position.Warehouse_Staff);break;
			case "4": staff.setPosition(Position.Marketing_Staff);break;
			case "5": staff.setPosition(Position.Labour);break;
			default:
				break;
			}
			staff.setSalary(Double.parseDouble(salary));
			staff.setAddress(address);
			staffService.save(staff);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}
