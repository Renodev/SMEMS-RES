package com.rnc.smems.res.api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rnc.smems.res.entities.Material;
import com.rnc.smems.res.services.MaterialService;

@Path("/materialproducerbynofilter")
public class MaterialProducerByNoFilter {
	
	@Inject
	private MaterialService materialService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Material> produceMaterialByNoFilter () {
		return materialService.findAll();
	}
}