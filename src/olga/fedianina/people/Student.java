package olga.fedianina.people;

import olga.fedianina.people.base.People;
import olga.fedianina.people.base.Subject;

import java.util.HashMap;

public class Student extends People {

    private int age;
    private int lvl;
    private HashMap<String, Integer> subject = new HashMap<>();
    private int maxSubjectLvl;


    public Student(String name, String surname, int age, int lvl) {
        super(name, surname);
        if (age < 6) {
            throw new IllegalArgumentException("Ребенку слишком рано ходить в школу");
        }
        this.age = age;
        if (lvl > 0 && lvl <= 11) {
            this.lvl = lvl;
        } else {
            throw new IllegalArgumentException("Таких классов в школе нет");
        }
        maxSubjectLvl = lvl * 10;
        this.fillingSubject(this.lvl);
    }

    public Student() {
        super();
        age = (int) (6 + Math.random() * 11);
        lvl = age - 5;
        maxSubjectLvl = lvl * 10;
        this.fillingSubject(this.lvl);
    }


    void fillingSubject(int lvl) {

        Subject count;
        switch (lvl) {
            case 1, 2 -> {
                count = Subject.SUBJECT_1;
                break;
            }
            case 3 -> {
                count = Subject.SUBJECT_3;
                break;
            }
            case 4 -> {
                count = Subject.SUBJECT_4;
                break;
            }
            case 5 -> {
                count = Subject.SUBJECT_5;
                break;
            }
            case 6 -> {
                count = Subject.SUBJECT_6;
                break;
            }
            default -> count = Subject.SUBJECT_7;
        }


        for (int i = 0; i < count.getSubjects().length; ++i) {
            subject.put(count.getSubjects()[i], 0);
        }

    }


    public int getAge() {
        return age;
    }

    public int getLvl() {
        return lvl;
    }


    public HashMap<String, Integer> getSubject() {
        return subject;
    }

    public void setSubject(HashMap<String, Integer> subject) {
        this.subject = subject;
    }

    public int getMaxSubjectLvl() {
        return maxSubjectLvl;
    }


    @Override
    public String toString() {
        return "Student{" + '\n' +
                name + " " +
                surname + " " +
                "age=" + age +
                ", lvl=" + lvl +
                ", subject=" + subject +
                '}';
    }

}

