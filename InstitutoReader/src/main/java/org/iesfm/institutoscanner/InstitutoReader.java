package org.iesfm.institutoscanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InstitutoReader {
    private static Logger log = LoggerFactory.getLogger(InstitutoReader.class);

    private Scanner scanner;
    private GroupReader groupReader;
    private ScannerUtils scannerUtils;

    public InstitutoReader(Scanner scanner, GroupReader groupReader, ScannerUtils scannerUtils) {
        this.scanner = scanner;
        this.groupReader = groupReader;
        this.scannerUtils = scannerUtils;
    }

    public Instituto readInstituto(){
        log.info("Introduce el nombre");
        String name = scanner.nextLine();

        log.info("¿Cuántos grupos tiene el instituto?");
        int numGroups = scannerUtils.scanPositive();
        List<Group> groups = new LinkedList<>();
        for (int i = 0; i < numGroups; i++) {
            groups.add(groupReader.readGroup());
        }
        return new Instituto(name, groups);
    }
}
