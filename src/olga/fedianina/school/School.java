package olga.fedianina.school;

import olga.fedianina.people.Director;
import olga.fedianina.people.Student;
import olga.fedianina.people.Teacher;
import olga.fedianina.people.base.BaseConst;

import java.util.HashMap;

public class School {
    //мне немного не нравится название, но это не критично
    private boolean openClose;
    public HashMap<Integer, ClassRoom> classRooms;
    public Teacher[] teachers;
    public Director director;


    public School(Director director) {
        classRooms = new HashMap<>(BaseConst.MAX_CLASS_COUNT);
        teachers = director.hiringTeachers();
        this.director = director;
    }

    //в школе плодить учеников запрещено! метод явно относится к классу Student
    public Student newStudent() {
        Student student = new Student();
        return student;
    }

    public void firstSeptember() {
        int count = 0;
        while (count < 20) {
            newStudentInTheClass(newStudent());
            count++;
        }
    }

    public void educationalProcess() {
        if (openClose) {
            for (int i = 0; i < teachers.length; ++i) {
                //Несколько странная ситуация. Может ли учитель быть занят до образовательного процесса? Есть смысл в этой проверке и параметре в целом?
                if (teachers[i].isFree()) {
                    teachers[i].searchClass(classRooms);
                }
            }
            for (int i = 0; i < teachers.length; ++i) {
                teachers[i].setFree(true);
            }
        }
    }


    public void newClass(int number) {
        classRooms.put(number, new ClassRoom(number));
    }

    //acceptForStudy
    public void newStudentInTheClass(Student student) {
        if (!classRooms.containsKey(student.getLvl())) {
            newClass(student.getLvl());
            //две одинаковые строчки стоит вынести их за пределы if
            classRooms.get(student.getLvl()).welcomeToClass(student);


        } else {
            classRooms.get(student.getLvl()).welcomeToClass(student);

        }
    }


    public boolean isOpenClose() {
        return openClose;
    }

    public void setOpenClose(boolean openClose) {
        this.openClose = openClose;
    }


    @Override
    public String toString() {
        return "School{" + '\n' +
                "classRooms=" + classRooms +
                ", \n teachers=" + teachers +
                ", \n director=" + director +
                '}';
    }
}
