package tn.esprit.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import tn.esprit.business.RendezVousBusiness;
import tn.esprit.entites.Logement;
@Path("rendezvous")
public class RDVResoureces {
	RendezVousBusiness rdv = new RendezVousBusiness();
/*	
	@GET
	@Produces("application/json")
	public Response getResources() {
		
		if (rdv.getListeRendezVous() == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		if (rdv.getListeRendezVous().size() == 0)
			return Response.status(Response.Status.NO_CONTENT).entity("Pas de contenu").build();

		else
			return Response.ok(rdv.getListeRendezVous(), MediaType.APPLICATION_JSON).build();
}	
	
	@GET
	@Produces("application/json")
	public Response getRdvByReference(@QueryParam(value = "reflog") int reflogmement) {

		System.out.println(reflogmement);
		if (rdv.getListeRendezVousByLogementReference(reflogmement) == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		if (rdv.getListeRendezVousByLogementReference(reflogmement).size() == 0)
			return Response.status(Response.Status.NO_CONTENT).entity("Pas de contenu").build();

		else {
			return Response.ok(rdv.getListeRendezVousByLogementReference(reflogmement), MediaType.APPLICATION_JSON)
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}
	
 */
	
	@GET
	@Produces("application/json")
	public Response getRdvById(@QueryParam(value ="id") int id) {

		System.out.println(id);
		if (rdv.getRendezVousById(id) == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		else {
			return Response.ok(rdv.getRendezVousById(id), MediaType.APPLICATION_JSON)
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}	
}
