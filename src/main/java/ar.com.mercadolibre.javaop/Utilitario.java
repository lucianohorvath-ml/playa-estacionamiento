package ar.com.mercadolibre.javaop;

public abstract class Utilitario extends Vehiculo {

    private int cargaMaxima;
    private int cargaActual = 0;

    public Utilitario(int cargaMaxima) {
        super();
        this.cargaMaxima = cargaMaxima;
    }

    public int getCargaMaxima() {
        return this.cargaMaxima;
    }

    public boolean cargar(int carga) {
        boolean cargaExitosa = false;
        if (this.cargaActual + carga <= this.cargaMaxima){
            this.cargaActual += carga;
            cargaExitosa = true;
        }

        return cargaExitosa;
    }
}
