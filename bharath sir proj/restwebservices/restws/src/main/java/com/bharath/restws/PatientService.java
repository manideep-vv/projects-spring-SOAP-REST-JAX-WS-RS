package com.bharath.restws;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import com.bharath.restws.model.Patient;

@Path("/patientservice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface PatientService {

	@Path("/patients")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	List<Patient> getPatients();

	@Path("/patients/{id}")
	@GET
	Patient getPatient(@PathParam("id") Long id);

	@Path("/patients")
	@POST
	Response createPatient(Patient patient);

	@Path("/patients")
	@PUT
	Response updatePatient(Patient patient);

	@Path("/patients/{id}")
	@DELETE
	Response deletePatient(@PathParam("id") Long id);

}
