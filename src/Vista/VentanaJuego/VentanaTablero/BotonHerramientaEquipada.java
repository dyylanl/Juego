package Vista.VentanaJuego.VentanaTablero;

import Modelo.Construccion.Constructor;
import Modelo.Herramientas.Herramienta;
import Modelo.Herramientas.Mano;
import Modelo.ElementosJugador.Jugador;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.HashMap;
import java.util.Map;

public class BotonHerramientaEquipada extends Button {

    private Jugador jugador;
    private Constructor constructor;
    private Map<Herramienta, Image> imagenes;

    public BotonHerramientaEquipada(Jugador obtenerJugador) {

        this.setPrefSize(50,50);

        this.jugador = obtenerJugador;
        this.imagenes = new HashMap<>();
        this.constructor = new Constructor();

        this.inicializarImagenes();
        this.actualizarImagen();
        this.setStyle("-fx-text-fill: rgb(252,246,255)");
        this.setAlignment(Pos.BOTTOM_RIGHT);
    }

    private void inicializarImagenes() {

        imagenes.put(new Mano(), new Image("BotonVacio.png"));
        imagenes.put(constructor.crearHachaDeMadera(), new Image("BotonHachaMadera.png"));
        imagenes.put(constructor.crearHachaDeMetal(), new Image("BotonHachaMetal.png"));
        imagenes.put(constructor.crearHachaDePiedra(), new Image("BotonHachaPiedra.png"));
        imagenes.put(constructor.crearPicoDeMadera(), new Image("BotonPicoMadera.png"));
        imagenes.put(constructor.crearPicoDePiedra(), new Image("BotonPicoPiedra.png"));
        imagenes.put(constructor.crearPicoDeMetal(), new Image("BotonPicoMetal.png"));
        imagenes.put(constructor.crearPicoDePiedraRefinada(), new Image("BotonPicoFino.png"));

    }

    public void actualizarImagen() {
        Herramienta herramienta = jugador.herramientaEquipada();
        Image imagen = imagenes.get(herramienta);

        BackgroundImage backgroundImage = new BackgroundImage(imagen,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(backgroundImage));

        int durabilidadHerramienta = herramienta.durabilidad();
        this.setText(Integer.toString(durabilidadHerramienta));
    }

}
