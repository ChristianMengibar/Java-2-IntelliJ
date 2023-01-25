package org.iesfm.institutoscanner.annotations;

import org.iesfm.institutoscanner.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class InstitutoScannerConfiguration {

    @Bean
    public InstitutoReader institutoReader(Scanner scanner, GroupReader groupReader, ScannerUtils scannerUtils) {
        return new InstitutoReader(scanner, groupReader, scannerUtils);
    }

    @Bean
    public GroupReader groupReader(Scanner scanner, StudentReader studentReader, ScannerUtils scannerUtils) {
        return new GroupReader(scanner, studentReader, scannerUtils);
    }

    @Bean
    public ScannerUtils scannerUtils(Scanner scanner) {
        return new ScannerUtils(scanner);
    }

    @Bean
    public StudentReader studentReader(Scanner scanner) {
        return new StudentReader(scanner);
    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
