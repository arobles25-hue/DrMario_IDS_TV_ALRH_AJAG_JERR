
package drmario2026;

import java.awt.image.BufferedImage;


public abstract class Elemento {
    public static final int AMARILLO=1;
    public static final int ROJO = 2;
    public static final int AZUL=3;
    
    private int color=AMARILLO;
    private int x;
    private int y;
    private int fila;
    private int columna;
    private boolean gravedad=true;

    public abstract BufferedImage getSprite();
    
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public boolean isGravedad() {
        return gravedad;
    }

    public void setGravedad(boolean gravedad) {
        this.gravedad = gravedad;
    }
   
}
