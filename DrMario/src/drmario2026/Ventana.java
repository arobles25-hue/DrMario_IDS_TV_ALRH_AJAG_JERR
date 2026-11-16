package drmario2026;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ventana extends JFrame{
  
    Canvas canvas;
    
    public Ventana()
    {
        this.setSize(1000, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setLayout(null);
         
        canvas=new Canvas();
        canvas.setPreferredSize(new Dimension(1000, 800));
        this.add(canvas);
        
        HiloJuego h1=new HiloJuego(canvas);
        h1.start();
        
        this.validate();
        this.repaint();
    }
}
