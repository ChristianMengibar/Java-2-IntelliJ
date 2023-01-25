package org.iesfm.inversionofcontrol;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.Scanner;

@Configuration
public class ConfigurationMember {

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean
    public MemberReader reader (Scanner scanner){
        return new MemberReader(scanner);
    }

    @Bean
    public MemberService servicio(Scanner scanner, Map<String, Member> memberMap) {
        return new MemberService(scanner, memberMap);
    }

    @Bean
    public MemberMenu menu(MemberReader reader, MemberService servicio, Scanner scanner){
        return new MemberMenu(reader, servicio, scanner);
    }
}
