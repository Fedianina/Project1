package olga.fedianina.people;

import olga.fedianina.people.base.BaseConst;
import olga.fedianina.people.base.People;
import olga.fedianina.school.School;


public class Director extends People {
    //здесь я бы задумался об отношении школы и директора. Не бывает директора без школы, так что возможно стоит задать ему такое поле, 
    //но может быть это излишне, тут не уверен.
    public Director(String name, String surname, int age) {
        super(name, surname);
        if (age > 45) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Возраст должен быть не менее 45 лет");
        }
    }
    
    //Пустой конструктор вводит в небольшое заблуждение. Лучше написать фабричный метод, который вернет экземпляр класса
    public Director() {
        super();
        age = (int) (45 + Math.random() * 30);
    }

    //во всех остальных случаях ты используешь другую форму глаголов, для единообразия лучше поставить hire.
    //так же встает вопрос: а куда он их нанимает? Это же не его рабы. Я бы отпавил этот метод в класс школы, тогда и return, скорее всего, не понадобится
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
