package org.iesfm.inversionofcontrol;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationMember.class);

        MemberMenu menu = context.getBean(MemberMenu.class);
        menu.elegirOpcion();
    }
}
