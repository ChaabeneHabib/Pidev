package tn.esprit.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import tn.esprit.business.LogementBusiness;

@Path("logements")
public class LogementResource {

	LogementBusiness logeBusiness = new LogementBusiness();

	@GET
	@Produces("application/json")
	public Response getLogements() {
		
			if (logeBusiness.getLogements() == null)
				return Response.status(Response.Status.NOT_FOUND).build();

			if (logeBusiness.getLogements().size() == 0)
				return Response.status(Response.Status.NO_CONTENT).entity("Pas de contenu").build();

			else
				return Response.ok(logeBusiness.getLogements(), MediaType.APPLICATION_JSON).build();

	}


	@GET
	@Produces("application/json")
	public Response getLogements(@QueryParam(value = "delegation") String deleguation,
			@QueryParam(value = "gouvernorat") String gouvernorat, @QueryParam(value = "type") String type,
			@QueryParam(value = "prix") String prix) {

		if ((deleguation == null) && (gouvernorat == null) && (type == null) && (prix == null)) {
			// si pas de queryparam (getAllLogements)
			if (logeBusiness.getLogements() == null)
				return Response.status(Response.Status.NOT_FOUND).build();

			if (logeBusiness.getLogements().size() == 0)
				return Response.status(Response.Status.BAD_REQUEST).entity("Pas de contenu").build();

			else
				return Response.ok(logeBusiness.getLogements(), MediaType.APPLICATION_JSON).build();

		} else if ((deleguation != null) && (gouvernorat == null) && (type == null) && (prix == null)) {
			// si le paramètre envoyé est la délégation
			if (logeBusiness.getLogementsByDeleguation(deleguation) == null)
				return Response.status(Response.Status.NOT_FOUND).build();

			if (logeBusiness.getLogementsByDeleguation(deleguation).size() == 0)
				return Response.status(Response.Status.NO_CONTENT).entity("Pas de contenu").build();

			else {
				return Response.ok(logeBusiness.getLogementsByDeleguation(deleguation), MediaType.APPLICATION_JSON)
						.header("Access-Control-Allow-Origin", "*").build();
			}

		} else if ((deleguation == null) && (gouvernorat != null) && (type == null) && (prix == null)) {

			// si le paramètre envoyé est gouvernorat
			if (logeBusiness.getLogementsByGouvernorat(gouvernorat) == null)
				return Response.status(Response.Status.NOT_FOUND).build();

			if (logeBusiness.getLogementsByGouvernorat(gouvernorat).size() == 0)
				return Response.status(Response.Status.NO_CONTENT).entity("Pas de contenu").build();

			else {
				return Response.ok(logeBusiness.getLogementsByGouvernorat(gouvernorat), MediaType.APPLICATION_JSON)
						.header("Access-Control-Allow-Origin", "*").build();
			}

		} else
			return Response.status(Response.Status.BAD_REQUEST).entity("Requete eronnée").build();
	}

	// Get avec paths differents (n'est pas une bonne pratique)
	@GET
	@Produces("application/json")
	@Path("logementsAll")
	public Response getAllLogements() {

		if (logeBusiness.getLogements() == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		if (logeBusiness.getLogements().size() == 0)
			return Response.status(Response.Status.BAD_REQUEST).entity("Pas de contenu").build();

		else
			return Response.ok(logeBusiness.getLogements(), MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Produces("application/json")
	@Path("logementsByDelegation")
	public Response getLogementByDelegation(@QueryParam(value = "del") String deleguation) {

		System.out.println(deleguation);
		if (logeBusiness.getLogementsByDeleguation(deleguation) == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		if (logeBusiness.getLogementsByDeleguation(deleguation).size() == 0)
			return Response.status(Response.Status.NO_CONTENT).entity("Pas de contenu").build();

		else {
			return Response.ok(logeBusiness.getLogementsByDeleguation(deleguation), MediaType.APPLICATION_JSON)
					.header("Access-Control-Allow-Origin", "*").build();
		}
	}
}