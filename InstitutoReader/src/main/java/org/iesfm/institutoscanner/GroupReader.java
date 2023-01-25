package org.iesfm.institutoscanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GroupReader {
    private static Logger log = LoggerFactory.getLogger(GroupReader.class);

    private Scanner scanner;
    private StudentReader studentReader;
    private ScannerUtils scannerUtils;

    public GroupReader(Scanner scanner, StudentReader studentReader, ScannerUtils scannerUtils) {
        this.scanner = scanner;
        this.studentReader = studentReader;
        this.scannerUtils = scannerUtils;
    }

    public Group readGroup() {
        log.info("Introduce la letra");
        String letter = scanner.nextLine();
        log.info("Introduce el curso");
        int course = scannerUtils.scanPositive();

        log.info("¿Cuántos estudiantes tiene el grupo?");
        int numStudents = scannerUtils.scanPositive();
        List<Student> students = new LinkedList<>();
        for (int i = 0; i < numStudents; i++) {
            students.add(studentReader.readStudent());
        }
        return new Group(letter, course, students);
    }
}
