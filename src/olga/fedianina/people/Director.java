package olga.fedianina.people;

import olga.fedianina.people.base.BaseConst;
import olga.fedianina.people.base.People;
import olga.fedianina.school.School;


public class Director extends People {

    public Director(String name, String surname, int age) {
        super(name, surname);
        if (age > 45) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Возраст должен быть не менее 45 лет");
        }
    }

    public Director() {
        super();
        age = (int) (45 + Math.random() * 30);
    }


    public Teacher[] hiringTeachers() {
        Teacher[] teachers = new Teacher[BaseConst.MAX_TEACHER_COUNT];
        for (int i = 0; i < BaseConst.MAX_TEACHER_COUNT; ++i) {
            teachers[i] = new Teacher();
            System.out.println(teachers[i]);
        }
        return teachers;
    }

    public void startDay(School school) {
        openSchool(school);
        school.educationalProcess();
        closeSchool(school);

    }

    public void openSchool(School school) {
        school.setOpenClose(true);
    }


    public void closeSchool(School school) {
        school.setOpenClose(false);
    }

    @Override
    public String toString() {
        return "Director{" +
                "Имя " + name + '\'' +
                ", Фамилия " + surname + '\'' +
                ", Возраст=" + age +
                '}';
    }
}
