package ar.com.mercadolibre.javaop;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PlayaCargaTest {

    @Test
    public void crearPlayaDeCarga(){
        PlayaCarga playaCarga = new PlayaCarga();
        Assertions.assertThat(playaCarga).isNotNull();
    }

    @Test
    public void crearPlayaDeEstacionamiento(){
        PlayaEstacionamiento playaEstacionamiento = new PlayaEstacionamiento();
        Assertions.assertThat(playaEstacionamiento).isNotNull();
    }

    @Test
    public void asignarCargaAPlayaDeCarga(){
        PlayaCarga playaCarga = new PlayaCarga();
        playaCarga.asignarCarga(20);
        Assertions.assertThat(playaCarga.hayCargas()).isTrue();
    }

    @Test
    public void ingresarUnAutoAlEstacionamiento(){
        PlayaEstacionamiento playaEstacionamiento = new PlayaEstacionamiento();
        Auto auto = new Auto();
        playaEstacionamiento.estacionar(auto);
        Assertions.assertThat(playaEstacionamiento.hayVehiculos()).isTrue();
    }

    @Test
    public void ingresarUnCamionAlEstacionamiento(){
        PlayaEstacionamiento playaEstacionamiento = new PlayaEstacionamiento();
        Camion camion = new Camion(100);
        playaEstacionamiento.estacionar(camion);
        Assertions.assertThat(playaEstacionamiento.hayVehiculos()).isTrue();
    }

    @Test
    public void ingresarUnCamionetaAlEstacionamiento(){
        PlayaEstacionamiento playaEstacionamiento = new PlayaEstacionamiento();
        Camioneta camioneta = new Camioneta(50);
        playaEstacionamiento.estacionar(camioneta);
        Assertions.assertThat(playaEstacionamiento.hayVehiculos()).isTrue();
    }

    @Test
    public void ingresarYEgresarAutoAlEstacionamiento(){
        PlayaEstacionamiento playaEstacionamiento = new PlayaEstacionamiento();
        Auto auto = new Auto();
        playaEstacionamiento.estacionar(auto);
        playaEstacionamiento.retirar(auto);
        Assertions.assertThat(playaEstacionamiento.hayVehiculos()).isFalse();
    }

    @Test
    public void ingresarYEgresarCamionAlEstacionamiento(){
        PlayaEstacionamiento playaEstacionamiento = new PlayaEstacionamiento();
        Camion camion = new Camion(50);
        playaEstacionamiento.estacionar(camion);
        playaEstacionamiento.retirar(camion);
        Assertions.assertThat(playaEstacionamiento.hayVehiculos()).isFalse();
    }

    @Test
    public void unCamionTieneCargaMaxima(){
        int cargaMaxima = 100;
        Camion camion = new Camion(cargaMaxima);
        Assertions.assertThat(camion.getCargaMaxima()).isEqualTo(cargaMaxima);
    }

    @Test
    public void unCamionRetiraCargaDeLaPlaya(){
        PlayaCarga playaCarga = new PlayaCarga();
        playaCarga.asignarCarga(50);
        Camion camion = new Camion(60);
        camion.cargar(playaCarga.retirarCarga());
        Assertions.assertThat(playaCarga.hayCargas()).isFalse();
    }

    @Test
    public void unCamionRetiraVariasCargasDeLaPlaya(){
        PlayaCarga playaCarga = new PlayaCarga();
        playaCarga.asignarCarga(50);
        playaCarga.asignarCarga(30);
        Camion camion = new Camion(100);
        camion.cargar(playaCarga.retirarCarga());
        camion.cargar(playaCarga.retirarCarga());
        Assertions.assertThat(playaCarga.hayCargas()).isFalse();
    }

    @Test
    public void unCamionNoPuedeExcederSuCargaMaxima(){
        PlayaCarga playaCarga = new PlayaCarga();
        playaCarga.asignarCarga(50);
        playaCarga.asignarCarga(100);
        Camion camion = new Camion(120);
        camion.cargar(playaCarga.retirarCarga());
        camion.cargar(playaCarga.retirarCarga());
        Assertions.assertThat(playaCarga.hayCargas()).isTrue();
    }
}
