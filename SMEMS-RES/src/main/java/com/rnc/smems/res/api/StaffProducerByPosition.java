package com.rnc.smems.res.api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rnc.smems.res.entities.Staff;
import com.rnc.smems.res.enums.Position;
import com.rnc.smems.res.services.StaffService;

@Path("/staffproducerbyposition/{positionID}")
public class StaffProducerByPosition {
	
	@Inject
	private StaffService staffService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Staff> produceStaffByPosition (@PathParam("positionID") String positionID) {
		if (positionID.equals("1")) {
			return staffService.findByPosition(Position.Manager);
		} else if (positionID.equals("2")) {
			return staffService.findByPosition(Position.HR_Staff);
		} else if (positionID.equals("3")) {
			return staffService.findByPosition(Position.Warehouse_Staff);
		} else if (positionID.equals("4")) {
			return staffService.findByPosition(Position.Marketing_Staff);
		} else if (positionID.equals("5")) {
			return staffService.findByPosition(Position.Labour);
		} else {
			return null;
		}
	}

}
