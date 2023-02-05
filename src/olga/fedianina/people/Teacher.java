package olga.fedianina.people;

import olga.fedianina.people.base.BaseConst;
import olga.fedianina.people.base.People;
import olga.fedianina.people.base.Subject;
import olga.fedianina.school.ClassRoom;

import java.util.HashMap;

public class Teacher extends People {

    private String subject;
    private int lessonPoint;
    private boolean free = true;


    public Teacher(String name, String surname, int age, String subject, int lessonPoint) {
        super(name, surname);
        if (age < 18) {
            throw new IllegalArgumentException("Учитель не может быть моложе 18  лет");
        } else {
            this.age = age;
        }

        if (lessonPoint < 1000) {
            throw new IllegalArgumentException("Учитель  ничему не может научить учеников");
        }
        this.subject = subject;
        this.lessonPoint = lessonPoint;


    }

    public Teacher() {
        super();
        age = (int) (18 + Math.random() * 64);
        lessonPoint = (int) (2500 + Math.random() * 1000);
        subject = Subject.SUBJECTS_FOR_TEACHERS.getSubjects()[(int) (Math.random() * Subject.SUBJECTS_FOR_TEACHERS.getSubjects().length)];
    }

    public void teach(ClassRoom classRoom) {

        for (Student student : classRoom.getStudents()) {
            if (!(student == null)) {
                student.getSubject().replace(subject, (student.getSubject().get(subject) + (int) (1 + Math.random() * student.getMaxSubjectLvl())));
                //System.out.println("Ученик повысил свои знания");
            }
        }
    }

    public void searchClass(HashMap<Integer, ClassRoom> classRooms) {
        for (int i = 0; i < BaseConst.MAX_CLASS_COUNT; ++i) {
            if (classRooms.containsKey(i)) {
                if (classRooms.get(i).getStudents()[0].getSubject().containsKey(subject)) {
                    this.free = false;
                    this.teach(classRooms.get(i));
                }
            }
        }


    }

    public String getSubject() {
        return subject;
    }


    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    @Override
    public String toString() {
        return "Teacher{" + "Имя" + " " + name + '\'' +
                ", Фамилия'" + surname + '\'' +'\n' +
                ", Возраст" + " " + age +'\n' +
                "Предмет'" + " " + subject + '\'' +
                ", lessonPoint=" + lessonPoint +
                '}';
    }
}

