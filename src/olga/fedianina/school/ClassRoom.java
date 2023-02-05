package olga.fedianina.school;

import olga.fedianina.people.Student;
import olga.fedianina.people.base.BaseConst;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ClassRoom {
    private final int level;

    //массив создается один раз и указатель на него не меняется. Возможно стоит сделать final
    private Student[] students;


    public ClassRoom(int level) {
        this.level = level;
        this.students = new Student[BaseConst.STUDENTS_COUNT];

    }

    public void welcomeToClass(Student student) {
        for (int i = 0; i < BaseConst.STUDENTS_COUNT; ++i) {
            if (students[i] == null) {
                students[i] = student;
                System.out.println("Ученик добавлен, все хорошо");
                return;
            }
        }

        System.out.println("Места в классе нет");
    }

    public Student[] getStudents() {
        return students;
    }
    //нигде не используется
    public void setStudents(Student[] students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "level=" + level +
                ", students=" + Arrays.toString(students) +
                '}';
    }
}
