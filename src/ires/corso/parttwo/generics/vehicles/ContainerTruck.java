package ires.corso.parttwo.generics.vehicles;

import ires.corso.parttwo.monitoring.vehicles.VeicoliMotorizzati;

import java.util.ArrayList;
import java.util.List;

// Rappresenta autoarticolati che trasportano altri veicoli.
public class ContainerTruck<T extends VeicoliMotorizzati>
{
    private final String truckId; // targa
    private final String model; // modello
    private final ArrayList<T> vehicles = new ArrayList<>();

    public ContainerTruck(String truckId, String model) {
        this.truckId = truckId;
        this.model = model;
    }

    public String getTruckId() {
        return truckId;
    }

    public String getModel() {
        return model;
    }

    public void loadVehicle(T t) {
        this.vehicles.add(t);
    }

    public void loadVehicles(List<T> vehicles) {
        for(T t: vehicles) {
            loadVehicle(t);
        }
    }

    public List<T> listVehicles() {
        return null;
    }

    public void getAllPositions() {
        for(T t: vehicles) {
            System.out.println(t.whoAreYou());
            System.out.println(t.getNumTelaio());
            System.out.println(t.getTarga());
        }
    }
}
