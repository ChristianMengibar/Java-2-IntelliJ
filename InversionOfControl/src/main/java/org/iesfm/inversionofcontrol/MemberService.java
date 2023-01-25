package org.iesfm.inversionofcontrol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MemberService {

    private final static Logger log = LoggerFactory.getLogger(MemberService.class);

    private Scanner scanner;
    private Map<String, Member> memberMap;

    public MemberService(Scanner scanner, Map<String, Member> memberMap) {
        this.scanner = scanner;
        this.memberMap = memberMap;
    }

    public List<Member> list() {
        return new LinkedList<>(memberMap.values());
    }

    public void insertar(Member member) {
        memberMap.put(member.getNif(), member);
    }

    public void borrar(String nif) {
        memberMap.remove(nif);
    }

    public void modificar(String nif) {
        Member member = memberMap.get(nif);
        log.info("Introduce el nuevo nombre:");
        String nombre = scanner.nextLine();
        member.setNombre(nombre);
        log.info("Introduce el nuevo apellido:");
        String apellido = scanner.nextLine();
        member.setApellido(apellido);
        log.info("Introduce el nuevo codigo postal:");
        int cp = scanner.nextInt();
        member.setCodigoPostal(cp);
        log.info("Miembro modificado satisfactoriamente.");
    }
}
