package com.rnc.smems.res.api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rnc.smems.res.entities.Material;
import com.rnc.smems.res.services.MaterialService;

@Path("/materialremover/{id}")
public class MaterialRemover {
	
	@Inject
	private MaterialService materialService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public boolean removeMaterial (
			@PathParam("id") String id
			) {
		try {
			Material material= materialService.findByID(Long.parseLong(id));
			materialService.delete(material);
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
	}

}