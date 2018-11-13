package integracion;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
 
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ClaimRESTServiceClient {
	public static void main(String[] args) {
		String string = "";
		try {
 
			// Step1: Let's 1st read file from fileSystem
			// Change CrunchifyJSON.txt path here
			InputStream crunchifyInputStream = new FileInputStream("C://CrunchifyJSON.txt");
			InputStreamReader crunchifyReader = new InputStreamReader(crunchifyInputStream);
			BufferedReader br = new BufferedReader(crunchifyReader);
			String line;
			while ((line = br.readLine()) != null) {
				string += line + "\n";
			}
 
			JSONObject jsonObject = new JSONObject(string);
			
			//create ObjectMapper instance
		    ObjectMapper objectMapper = new ObjectMapper();

		    //convert json string to object
		    PojoConfiguracion conf = objectMapper.readValue(jsonObject.toString(), PojoConfiguracion.class); 
			System.out.println(jsonObject);
			System.out.println(conf.getIp());
 
			// Step2: Now pass JSON File Data to REST Service
			/*try {
				URL url = new URL("http://localhost:8080/tienda_integracion/api/claim");
				URLConnection connection = url.openConnection();
				connection.setDoOutput(true);
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);
				OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
				out.write(jsonObject.toString());
				out.close();
 
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
 
				while (in.readLine() != null) {
				}
				System.out.println("\nCrunchify REST Service Invoked Successfully..");
				in.close();
			} catch (Exception e) {
				System.out.println("\nError while calling Crunchify REST Service");
				System.out.println(e);
			}*/
 
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
