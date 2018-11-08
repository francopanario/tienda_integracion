package integracion;


import java.io.*;
import java.net.*;
import java.util.Random;

import org.codehaus.jackson.map.ObjectMapper;

import controlador.Controlador;
import exceptions.FacturaException;

public class Almacen {
	
	public static String getHTML(String urlToRead) throws Exception {
		
		
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
	
	public static int consultarStock (String url) throws Exception {
		String result = Almacen.getHTML(url);
		
		
		ObjectMapper objectMapper = new ObjectMapper();
		PojoConsultaStock pojCon = objectMapper.readValue(result.toString(), PojoConsultaStock.class);
		return pojCon.cantidad;
	}

}