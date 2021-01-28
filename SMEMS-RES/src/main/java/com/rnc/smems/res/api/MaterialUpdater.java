package com.rnc.smems.res.api;

import java.time.LocalDate;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rnc.smems.res.entities.Material;
import com.rnc.smems.res.services.MaterialService;

@Path("/materialupdater/{id}/{date}/{name}/{price}/{description}")
public class MaterialUpdater {
	
	@Inject
	private MaterialService materialService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public boolean receiveMaterial (
			@PathParam("id") String id,
			@PathParam("date") String date,
			@PathParam("name") String name,
			@PathParam("price") String price,
			@PathParam("description") String description
			) {
		try {
			Material material = new Material();
			material.setId(Long.parseLong(id));
			
			LocalDate date1 = LocalDate.parse(date);
			material.setDate(date1);
			
			material.setName(name);
			material.setPrice(Double.parseDouble(price));
			material.setDescription(description);
			materialService.save(material);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
		
}
