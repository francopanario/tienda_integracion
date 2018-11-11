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
            generarCsv(facturas);
            //ftpClient.open(ftpAddress,ftpPort ,ftpUser ,ftpPassword );
            //ftpClient.upload(sourceUrl,destinationUrl);
        }finally {
            //ftpClient.close();
        }
    }

    public static void generarCsv(List<Factura> purchases) {
        try {
            CsvMapper mapper = new CsvMapper();
            CsvSchema schema = mapper.schemaFor(Factura.class);
            schema = schema.withColumnSeparator(',').withoutQuoteChar().withoutHeader();
            ObjectWriter myObjectWriter = mapper.writer(schema);
            File tempFile = new File(sourceUrl);
            FileOutputStream tempFileOutputStream = null;
            tempFileOutputStream = new FileOutputStream(tempFile);

            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(tempFileOutputStream, 1024);
            OutputStreamWriter writerOutputStream = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
            myObjectWriter.writeValue(writerOutputStream, purchases);
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
