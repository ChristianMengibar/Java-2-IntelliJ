package org.iesfm.inversionofcontrol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class MemberReader {

    private final static Logger log = LoggerFactory.getLogger(MemberReader.class);

    private Scanner scanner;

    public MemberReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Member leerMiembro(){
        log.info("Introduce el NIF:");
        String nif = scanner.nextLine();

        log.info("Introduce el nombre:");
        String nombre = scanner.nextLine();

        log.info("Introduce el apellido:");
        String apellido = scanner.nextLine();

        log.info("Introduce el codigo postal:");
        int cp = scanner.nextInt();

        return new Member(nif, nombre, apellido, cp);
    }
}
