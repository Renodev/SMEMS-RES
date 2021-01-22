package com.rnc.smems.res.api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rnc.smems.res.entities.Staff;
import com.rnc.smems.res.services.StaffService;

@Path("/staffproducerbynofilter")
public class StaffProducerByNoFilter {
	
	@Inject
	private StaffService staffService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Staff> produceStaffByNoFilter () {
		return staffService.findAll();
	}
	
}
