package com.rnc.smems.res.api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rnc.smems.res.entities.Staff;
import com.rnc.smems.res.services.StaffService;

@Path("/staffremover/{id}")
public class StaffRemover {
	
	@Inject
	private StaffService staffService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public boolean removeStaff (
			@PathParam("id") String id
			) {
		try {
			Staff staff = staffService.findByID(Long.parseLong(id));
			staffService.delete(staff);
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
	}

}
