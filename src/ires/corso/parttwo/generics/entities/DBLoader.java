package ires.corso.parttwo.generics.entities;

import java.util.List;

public class DBLoader<T extends DBEntity>
{
    public List<T> loadEntitiesFromDB(T param) {
        param.loadFromDB();
        param.listAllFields();
        return null;
    }
}
