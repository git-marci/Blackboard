package ires.corso.parttwo.advanced;

public class Student extends Person
{
    // Metodi specifici
    public String getHomeworkMaterial(Teacher t) {
        return "";
    }

    public boolean deliverHomework(Teacher t) {
        return true;
    }

    public boolean subscribeToCourse(String course, Staff s) {
        return true;
    }

    @Override
    public String eatSomething() {
        System.out.println("Sono lo staff e mangio in pizzeria");
        return null;
    }

    @Override
    public String drink() {
        return null;
    }

    @Override
    public String moveToSchool() {
        return null;
    }
}
