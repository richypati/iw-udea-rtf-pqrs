package co.com.inversionesxyz.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("cliente")
public class ClienteWebService {

	String cliente[][] = { { "richypati@gmail.com", "12345", "admin" },
			{ "jenniferperezb@gmail.com", "54321", "cliente" },
			{ "6969", "6969", "analista" }, { "12345", "12345", "analista" } };
	private static String rol="";

	@GET
	@Path("/validarCliente")
	@Produces(MediaType.TEXT_PLAIN)
	public Response validarCliente(
			@QueryParam("emailCliente") String emailCliente,
			@QueryParam("password") String password) {

		if (!clienteValido(emailCliente, password)) {
			return Response.ok("Nombre de usuario o contraseña incorrectos")
					.build();
		}

		return Response.ok(rol).build();
	}

	private boolean clienteValido(String emailCliente, String password) {
		for (int i = 0; i < cliente.length; i++) {
			if (cliente[i][0].equalsIgnoreCase(emailCliente)
					&& cliente[i][1].equals(password)) {
				rol = cliente[i][2];
				return true;
			}

		}
		return false;
	}
}
