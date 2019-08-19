package ar.com.mercadolibre.javaop;

import java.util.LinkedList;

public class PlayaCarga extends PlayaEstacionamiento {
    private LinkedList<Integer> cargas;

    public PlayaCarga (){
        super();
        cargas = new LinkedList<Integer>();
    }

    public void asignarCarga(int peso) {
        cargas.add(peso);
    }

    public boolean hayCargas() {
        return !this.cargas.isEmpty();
    }

    public int retirarCarga() {
        return this.cargas.pop();
    }
}
