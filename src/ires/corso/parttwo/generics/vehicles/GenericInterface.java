package ires.corso.parttwo.generics.vehicles;

public interface GenericInterface<Type1, Type2>
{
    Type1 convertFrom(Type2 t2);
    Type2 convertTo(Type1 t1);
}
