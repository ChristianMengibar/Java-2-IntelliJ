package org.iesfm.inversionofcontrol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class MemberMenu {

    private final static Logger log = LoggerFactory.getLogger(MemberMenu.class);

    private MemberReader reader;
    private MemberService servicio;
    private Scanner scanner;

    public MemberMenu(MemberReader reader, MemberService servicio, Scanner scanner) {
        this.reader = reader;
        this.servicio = servicio;
        this.scanner = scanner;
    }

    private void menu() {
        log.info("\n" + "Elige una opcion:" + "\n" +
                        "1. Lista de miembros." + "\n" +
                        "2. Añadir miembro." + "\n" +
                        "3. ELiminar miembro por NIF." + "\n" +
                        "4. Modificar miembro por NIF." + "\n" +
                        "5. Salir." + "\n" +
                        "Introduce la opcion que quieres utilizar: ");
    }

    public void elegirOpcion() {
        List<Member> listaMiembro;
        int opcion;
        do {
            menu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:
                    listaMiembro = servicio.list();
                    for (Member miembro : listaMiembro){
                        log.info(miembro.toString());
                    }
                    break;
                case 2:
                    servicio.insertar(reader.leerMiembro());
                    break;
                case 3:
                    log.info("Introduce el NIF del miembro que quieres eliminar:");
                    servicio.borrar(scanner.nextLine());
                    break;
                case 4:
                    log.info("Introduce el NIF del miembro que quieres modificar:");
                    servicio.modificar(scanner.nextLine());
                    break;
                default:
                    log.info("Programa finalizado.");
                    break;
            }
        } while (opcion !=5);
    }
}
