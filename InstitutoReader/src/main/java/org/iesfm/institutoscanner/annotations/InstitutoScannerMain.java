package org.iesfm.institutoscanner.annotations;

import org.iesfm.institutoscanner.StudentReader;
import org.iesfm.institutoscanner.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InstitutoScannerMain {
    private static Logger log = LoggerFactory.getLogger(InstitutoScannerMain.class);
    public static void main(String[] args) {
        // Se crea el contexto de la aplicación
        // Se crean los beans y se inyectan las dependencias
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        InstitutoScannerConfiguration.class
                );
        // Sacamos el bean StudentReader del contexto de la aplicación
        StudentReader programa = context.getBean(StudentReader.class);
        // Leemos un estudiante
        Student student = programa.readStudent();
        log.info(student.toString());
    }
}
