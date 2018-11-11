package integracion;


import java.io.*;
import java.net.*;
import java.util.Random;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import controlador.Controlador;
import exceptions.FacturaException;
import negocio.Factura;

public class Almacen {
	
	public static int consultarStock (String url) throws Exception {
		String result = Almacen.getHTML(url);
		
		
		ObjectMapper objectMapper = new ObjectMapper();
		PojoConsultaStock pojCon = objectMapper.readValue(result.toString(), PojoConsultaStock.class);
		return pojCon.cantidad;
	}
	
	public static String getHTML(String urlToRead) throws Exception {
		
		  System.setProperty("javax.net.ssl.trustStore","C:\\Program Files\\Java\\jdk-11.0.1\\lib\\security\\cacerts");
	      StringBuilder result = new StringBuilder();
	      URL url = new URL(urlToRead);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setRequestMethod("GET");
	      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	      String line;
	      while ((line = rd.readLine()) != null) {
	         result.append(line);
	      }
	      rd.close();
	      return result.toString();
	   }

	public static void enviarCompra(String urlToPost, Factura fac) {
		
		ObjectMapper mapper = new ObjectMapper();
		ClientePojo cliente = new ClientePojo(fac.getComprador().getUsername(), "ApellidoHardcodeado", fac.getComprador().getMail(), fac.getComprador().getDireccion());
		ProductoPojo producto = new ProductoPojo(fac.getArticulo().getCodBarra(), fac.getCant());
		PojoEnvioCompra pojEnv = new PojoEnvioCompra(fac.getFacturaID(), cliente, producto);
	
			//Convert object to JSON string
			String jsonInString;
			try {
				// 1. URL
				URL url = new URL(urlToPost);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
				conn.setRequestProperty("Content-Type", "application/json");
				
				conn.setConnectTimeout(5000);
				conn.setReadTimeout(5000);
				OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
				  
		
				jsonInString = mapper.writeValueAsString(pojEnv);
				    try {
				        JSONObject request = new JSONObject(jsonInString);
				        out.write(request.toString());
						out.close();
				    } catch (JSONException e) {
				        // TODO Auto-generated catch block
				        e.printStackTrace();
				    }
	            // 6. Get the response
	            int responseCode = conn.getResponseCode();
	            System.out.println("Sending 'POST' request to URL : " + urlToPost);
	            System.out.println("Response Code : " + responseCode);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}