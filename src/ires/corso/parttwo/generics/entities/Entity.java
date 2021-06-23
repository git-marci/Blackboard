package ires.corso.parttwo.generics.entities;

import java.util.List;

public abstract class Entity implements DBEntity
{
    @Override
    public abstract List<String> listAllFields();

    @Override
    public abstract DBEntity loadFromDB();
}
