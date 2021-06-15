package ires.corso.parttwo.advanced;

public class Teacher extends Person
{
    // Metodi specifici
    public boolean assignHomework(String course, String homework) {
        return true;
    }

    public boolean reviewHomework(Student s) {
        return true;
    }

    @Override
    public String eatSomething() {
        System.out.println("Sono l'insegnante e mangio un panino");
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
