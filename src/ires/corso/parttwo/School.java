package ires.corso.parttwo;

import ires.corso.parttwo.advanced.*;

public class School
{
    public static void main(String[] args) {

        Teacher t = new Teacher();
        Student s = new Student();
        Staff f = new Staff();

        Person[] allThePeople = {(Person)t, (Person)s, (Person)f};

        for(int i = 0; i < allThePeople.length; i++) {
            allThePeople[i].eatSomething();
        }
    }
}
