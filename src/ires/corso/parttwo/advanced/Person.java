package ires.corso.parttwo.advanced;

public abstract class Person
{
    private String name;
    private String surname;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*
     * METODO che deve essere implementato da tutte le sottoclassi
     */
    public abstract String eatSomething();
    public abstract String drink();
    public abstract String moveToSchool();
}
