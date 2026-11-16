package drmario2026;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Pildora extends Elemento {

    Pildora adjuta = null;

    @Override
    public BufferedImage getSprite() {

        ///amarillo_izquierdo.png
        String nombreArchivo = "";
        switch (getColor()) {
            case AMARILLO:
                nombreArchivo = "amarillo_";
                break;
            case AZUL:
                nombreArchivo = "azul_";
                break;
            case ROJO:
                nombreArchivo = "rojo_";
                break;
        }
        if (adjuta == null) {
            nombreArchivo += "solo.png";
        }

        return HiloJuego.sprites.get(nombreArchivo);
    }

}
