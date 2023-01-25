package org.iesfm.build;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

public class BuildMain {

    private final static Logger log = LoggerFactory.getLogger(BuildMain.class);

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Build build = mapper.readValue(new File(Build.class.getResource("/build.json").toURI()), Build.class);
            log.info(build.toString());
            log.info(build.getApartments().get(0).getOwners().get(0).toString());
            mapper.writeValue(new FileOutputStream(new File("federica3.json")), build);
        } catch (URISyntaxException e) {
            log.error("", e);
        } catch (JsonProcessingException e) {
            log.error("El json no está bien formado", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}