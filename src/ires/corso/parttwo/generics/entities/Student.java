package ires.corso.parttwo.generics.entities;

import java.util.List;

public class Student extends Entity
{
    @Override
    public List<String> listAllFields() {
        return null;
    }

    @Override
    public DBEntity loadFromDB() {
        // Carico da tabella studenti
        return null;
    }
}
