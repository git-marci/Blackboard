package ires.corso.parttwo.generics.vehicles;

import ires.corso.parttwo.generics.vehicles.ContainerTruck;
import ires.corso.parttwo.monitoring.vehicles.Automobile;

public class GenericTester
{
    //ContainerTruck<Car> ctCar = new ContainerTruck<>();
    ContainerTruck<Automobile> ctAutomobile = new ContainerTruck<>("PN33170", "Volvo superturbo bivalve");
}
