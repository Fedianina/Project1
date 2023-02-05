package olga.fedianina;

import olga.fedianina.people.Director;
import olga.fedianina.school.School;

public class Live {
    public static void main(String[] args) {

        Director director = new Director();

        School school = new School(director);
        System.out.println(school);
        school.firstSeptember();
        school.educationalProcess();
        System.out.println(school);
    }
}
