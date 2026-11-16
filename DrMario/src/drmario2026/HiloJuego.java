package drmario2026;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class HiloJuego extends Thread {

    Canvas canvas;
    BufferStrategy buffer;
    Graphics lapiz;
    int offsetX=395;
    int offsetY=210;

    Elemento matriz[][] = new Elemento[16][8];

    public static HashMap<String, BufferedImage> sprites = new HashMap<>();

    int x = 0;

    public HiloJuego(Canvas canvas) {
        this.canvas = canvas;
        sprites.put("fondo.png", getImagenDiscoDuro("fondo.png"));
        sprites.put("amarillo_derecho.png", getImagenDiscoDuro("amarillo_derecho.png"));
        sprites.put("amarillo_izquierdo.png", getImagenDiscoDuro("amarillo_izquierdo.png"));
        sprites.put("amarillo_solo.png", getImagenDiscoDuro("amarillo_solo.png"));

        Pildora p = new Pildora();
        p.setColor(Pildora.AMARILLO);
        p.setColumna(0);
        p.setFila(0);
        p.setX(p.getColumna() * 26 + offsetX);
        p.setY(p.getFila() * 26 + offsetY);

        matriz[0][0] = p;
    }

    public void actualizar() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 8; j++) {
                if (matriz[i][j] != null) {
                    matriz[i+1][j]=matriz[i][j];
                    matriz[i+1][j].setFila(i+1);
                    matriz[i+1][j].setY((i+1)*26+offsetY );
                    matriz[i][j]=null;
                    return;
                }
            }
        }
    }

    public void dibujar() {
        buffer = canvas.getBufferStrategy();
        if (buffer == null) {
            canvas.createBufferStrategy(3);
            return;
        }

        lapiz = buffer.getDrawGraphics();
        ///Dibujado
        lapiz.clearRect(0, 0, 1000, 800);

        lapiz.drawRect(x, 90, 100, 100);
         lapiz.drawImage(sprites.get("fondo.png"), 0, 0, 1000, 700, null);

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 8; j++) {
                if (matriz[i][j] != null) {
                    Elemento e = matriz[i][j];
                    lapiz.drawImage(e.getSprite(),e.getX(), e.getY(), 26, 26, null);
                }
            }
        }

        // imagen posx, posy, 
        lapiz.dispose();
        buffer.show(); /// imprimir al canvas

    }

    public BufferedImage getImagenDiscoDuro(String nombre) {
        BufferedImage imagen = null;
        try {
            imagen = ImageIO.
                    read(HiloJuego.class.getResource("/sprites/" + nombre));
        } catch (IOException ex) {
            Logger.getLogger(HiloJuego.class.getName()).log(Level.SEVERE, null, ex);
        }

        return imagen;
    }

    @Override
    public void run() {
        while (true) {
            actualizar();
            dibujar();

            try {
                this.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloJuego.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
