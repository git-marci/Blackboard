package ires.corso.parttwo.generics.entities;

import java.util.List;

public class Course extends Entity
{
    @Override
    public List<String> listAllFields() {
        return null;
    }

    @Override
    public DBEntity loadFromDB() {
        // Carico da tabella course
        return null;
    }
}
