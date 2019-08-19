package ar.com.mercadolibre.javaop;

import java.util.LinkedList;

public class PlayaEstacionamiento {
    private LinkedList<Vehiculo> vehiculos;

    public PlayaEstacionamiento() {
        this.vehiculos = new LinkedList<Vehiculo>();
    }

    public void estacionar(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    public void retirar(Vehiculo vehiculo) {
        this.vehiculos.remove(vehiculo);
    }

    public boolean hayVehiculos() {
        return !this.vehiculos.isEmpty();
    }
}
