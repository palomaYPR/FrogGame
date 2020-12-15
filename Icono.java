/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frog;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author chuky
 */
public class Icono implements Icon{
    
    @Override
    public void paintIcon(Component cmpnt, Graphics grphcs, int i, int i1) {
        Image Mi_Imagen = new ImageIcon(getClass()
                .getResource("/imagenes/gameOver2.png")).getImage();
        grphcs.drawImage(Mi_Imagen, i, i1, cmpnt);

    }

    @Override
    public int getIconWidth() {
        return 50;
    }

    @Override
    public int getIconHeight() {
       return 50;
    }
}
