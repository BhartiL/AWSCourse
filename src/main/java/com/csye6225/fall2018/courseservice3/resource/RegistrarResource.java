package com.csye6225.fall2018.courseservice3.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.csye6225.fall2018.courseservice3.datamodel.Registrar;
import com.csye6225.fall2018.courseservice3.service.RegistrarService;

@Path("registrar")
public class RegistrarResource {
	RegistrarService regService = new RegistrarService();

	@POST
	@Path("/registerOffering")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Registrar addBoard(Registrar reg) {
		return regService.addRegistrar(reg);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Registrar> getRegistarrs() {
		return regService.getRegistrar();
	}

}
