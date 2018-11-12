package integracion;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import controlador.Controlador;
import negocio.Factura;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class EnviarCsv {

    private static final Logger log = LoggerFactory.getLogger(EnviarCsv.class);

    
    private static FtpClient ftpClient;


    
    private static String ftpAddress;

    
    private static int ftpPort;

    
    private static String ftpUser;

    
    private static String ftpPassword;

    
    private static String destinationUrl;

   
    private static String sourceUrl;

   

    
    public static void traerFacturas() throws IOException {
        try {
            Date fechaTruncada = DateUtils.truncate(new Date(), Calendar.DATE);
            List<Factura> facturas = Controlador.getInstancia().getAllFacturasDay(fechaTruncada);
            System.out.println(facturas.get(0).getFacturaID());
            generarCsv(facturas);
            sourceUrl="C:\\Users\\Franco\\Desktop\\source.csv";
            ftpClient.open(ftpAddress,ftpPort ,ftpUser ,ftpPassword );
            ftpClient.upload(sourceUrl,destinationUrl);
        }finally {
            ftpClient.close();
        }
    }

    public static void generarCsv(List<Factura> purchases) {
        try {
        	List<PojoEnvioReclamos> pojos= new ArrayList();
        	sourceUrl="C:\\Users\\Franco\\Desktop\\source.csv";
        	for(int i=0;i<purchases.size();i++) {
        		ClientePojo cli= new ClientePojo(purchases.get(i).getComprador().getUsername(), purchases.get(i).getComprador().getApellido(), purchases.get(i).getComprador().getMail(), purchases.get(i).getComprador().getDireccion());
        		ProductoPojo prod= new ProductoPojo(purchases.get(i).getArticulo().getCodBarra(),purchases.get(i).getCantidad());
        		PojoEnvioReclamos pojo= new PojoEnvioReclamos(purchases.get(i).getArticulo().getNombre(), purchases.get(i).getComprador().getUsuario_id(), Integer.parseInt(purchases.get(i).getFacturaID()), purchases.get(i).getArticulo().getCodBarra(), purchases.get(i).getComprador().getMail(), purchases.get(i).getTotal(), purchases.get(i).getComprador().getUsername());
        		pojos.add(pojo);
        	}
            CsvMapper mapper = new CsvMapper();
            CsvSchema schema = mapper.schemaFor(PojoEnvioReclamos.class);
            schema = schema.withColumnSeparator(',').withoutQuoteChar().withoutHeader().sortedBy("descripcionProd","dni","nro_orden","id_prod","mail","monto","nombrecli");

            ObjectWriter myObjectWriter = mapper.writer(schema);
            File tempFile = new File(sourceUrl);
            FileOutputStream tempFileOutputStream = null;
            tempFileOutputStream = new FileOutputStream(tempFile);

            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(tempFileOutputStream, 1024);
            OutputStreamWriter writerOutputStream = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
            myObjectWriter.writeValue(writerOutputStream, pojos);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (JsonGenerationException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

}
