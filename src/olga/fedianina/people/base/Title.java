package olga.fedianina.people.base;
//Title это название для статьи/текста/.., но не для людей. Лучше что-то в духе Names
public enum Title {
    MAN_NAME(new String[]{"Михаил", "Владимир", "Никита", "Николай", "Сергей", "Инокентий", "Арсений"}),
    MAN_SURNAME(new String[]{"Иванов", "Петров", "Сидоров", "Васнецов", "Орлов", "Кузнецов"}),
    WOMAN_SURNAME(new String[]{"Иванова", "Петрова", "Сидорова", "Васнецова", "Орлова", "Кузнецова"}),
    WOMAN_NAME(new String[]{"Анна", "Олеся", "Юлия", "Светлана", "Инна", "Марина"});

    //meaning - смысл, я бы взял простое values
    private String[] meaning;
    //модификатор
    Title(String[] meaning) {
        this.meaning = meaning;
    }

    public String[] getMeaning() {
        return meaning;
    }
}
