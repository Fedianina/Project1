package olga.fedianina.people.base;

abstract public class People {
    protected String name;
    protected String surname;
    protected int age;


    protected People(String name, String surname) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("Имя не может быть короче 2х символов");
        }
        this.name = name;
        if (surname.length() < 3) {
            throw new IllegalArgumentException("Фамилия не может быть короче 2х символов");
        }
        this.surname = surname;

    }


    protected People() {
        if (((int) (Math.random() * 10)) % 2 == 0) {
            this.name = Title.MAN_NAME.getMeaning()[(int) (Math.random() * (Title.MAN_NAME.getMeaning().length))];
            this.surname = Title.MAN_SURNAME.getMeaning()[(int) (Math.random() * (Title.MAN_SURNAME.getMeaning().length))];
        } else {
            this.name = Title.WOMAN_NAME.getMeaning()[(int) (Math.random() * (Title.WOMAN_NAME.getMeaning().length))];
            this.surname = Title.WOMAN_SURNAME.getMeaning()[(int) (Math.random() * (Title.WOMAN_SURNAME.getMeaning().length))];
        }
    }
}
