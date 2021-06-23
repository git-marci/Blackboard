package ires.corso.parttwo.generics.entities;

import java.util.List;

public interface DBEntity
{
    public List<String> listAllFields();
    public DBEntity loadFromDB();
}
