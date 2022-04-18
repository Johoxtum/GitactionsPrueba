package utils;

import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Owasp {

  private static final String ZAP_PROXYHOST = "localhost";
  private static final int ZAP_PROXYPORT = 8082;


  public static void owasp() throws IOException, ClientApiException {


    try {
        System.out.println("Implementa-------------------OWAPZAP");
        ClientApi api = new ClientApi(ZAP_PROXYHOST, ZAP_PROXYPORT);
        String Report = new String(api.core.htmlreport(), StandardCharsets.UTF_8);
        Path filePath = Paths.get("./scan-results/reporte.html");
        if (!Files.exists(filePath, LinkOption.NOFOLLOW_LINKS)) {
            Files.createFile(filePath);
        }
        Files.write(filePath, Report.getBytes());
    }catch (Exception e) {

        System.out.println("Error" + e.getMessage());
    }



   }

  }




