package br.com.projetofilmes.model;

public class Person {

    private String name, date_birth, type;
    private Integer image;

    public Person() {
    }

    public Person(String name, String date_birth, String type, Integer image) {
        this.name = name;
        this.date_birth = date_birth;
        this.type = type;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDate_birth() {
        return date_birth;
    }

    public Integer getImage() {
        return image;
    }

    @Override
    public String toString() {
        return name;
    }
}
