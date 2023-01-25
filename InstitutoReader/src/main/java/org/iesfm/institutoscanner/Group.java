package org.iesfm.institutoscanner;

import java.util.List;
import java.util.Objects;

public class Group {
    private String letter;
    private int course;
    private List<Student> students;

    public Group(String letter, int course, List<Student> students) {
        this.letter = letter;
        this.course = course;
        this.students = students;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return course == group.course && Objects.equals(letter, group.letter) && Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(letter, course, students);
    }

    @Override
    public String toString() {
        return "Group{" +
                "letter='" + letter + '\'' +
                ", course=" + course +
                ", students=" + students +
                '}';
    }
}
