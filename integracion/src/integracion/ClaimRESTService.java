package integracion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import integracion.PojoReclamo;
import negocio.Factura;

import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import controlador.Controlador;
import dao.FacturaDAO;
import entities.ReclamoEntity;
import exceptions.FacturaException;


@Path("/")
public class ClaimRESTService {
	@POST
	@Path("/claim/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crunchifyREST(InputStream incomingData) {
		StringBuilder crunchifyBuilder = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				crunchifyBuilder.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		System.out.println("Data Received: " + crunchifyBuilder.toString());
		
		
		
		//Hecho por Mathi //Hecho por Mathi //Hecho por Mathi //Hecho por Mathi //Hecho por Mathi //Hecho por Mathi //Hecho por Mathi
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			PojoReclamo pojRec = objectMapper.readValue(crunchifyBuilder.toString(), PojoReclamo.class);
			Random rand = new Random();
			int  n = rand.nextInt(999999999) + 111111111;
			String id = Integer.toString(n);
			Controlador.getInstancia().ingresarReclamo(id, pojRec.descripcion, true, pojRec.estado, Integer.toString(pojRec.idPedido));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (FacturaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Hecho por Mathi //Hecho por Mathi //Hecho por Mathi //Hecho por Mathi //Hecho por Mathi //Hecho por Mathi //Hecho por Mathi
		
		
		
		// return HTTP response 200 in case of success
		return Response.status(200).entity(crunchifyBuilder.toString()).build();
	}
 
	@GET
	@Path("/verifyClaim")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData) {
		String result = "CrunchifyRESTService Successfully started..";
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
	}
 
}
