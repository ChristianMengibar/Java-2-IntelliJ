package org.iesfm.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

public class CompanyMain {

    private final static Logger log = LoggerFactory.getLogger(CompanyMain.class);

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Company company = mapper.readValue(new File(Company.class.getResource("/company.json").toURI()), Company.class);
            log.info(company.toString());
            log.info(company.getDepartments().get(0).getEmployees().get(0).toString());
            mapper.writeValue(new FileOutputStream(new File("federica2.json")), company);
        } catch (URISyntaxException e) {
            log.error("", e);
        } catch (JsonProcessingException e) {
            log.error("El json no está bien formado", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}