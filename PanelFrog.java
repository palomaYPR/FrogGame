/*                                                                                       
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frog;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author chuky
 */
public class PanelFrog extends javax.swing.JPanel {

    public Image icono;

    // TAMAÑO DEL PANEL
    public int xF = 0, yF = 0, ancho = 414, alto = 600;

    //FROG
    int xFr = 199, yFr = 560; //Coordenadas principales
    int xR = 20, yR = 20; // Tamaño de la rana
    
    //Sonido Rana
    AudioClip sonidoR;
    AudioClip sonidoW;

    //Movimientos
    boolean arr, aba, der, izq;
    boolean mov;
    boolean dirX = false;
    int ti = 0;

    //SCORE
    int score = 0;
    int interseccion = 0;
    
    //Name
    String name;

    //Autos
    //////////////////////////Highway1
    int xA1 = 40, yA1 = 457, xTamA1 = 100, yTamA1 = 35;
    int xA2 = 195, yA2 = 457, xTamA2 = 100, yTamA2 = 35;
    int xA3 = 380, yA3 = 457, xTamA3 = 80, yTamA3 = 35;
    ///////////////////////////Highway2
    int xA4 = 40, yA4 = 405, xTamA4 = 80, yTamA4 = 35;
    int xA5 = 180, yA5 = 405, xTamA5 = 100, yTamA5 = 35;
    int xA6 = 370, yA6 = 405, xTamA6 = 90, yTamA6 = 35;
    ///////////////////////////Highway3
    int xA7 = 70, yA7 = 357, xTamA7 = 90, yTamA7 = 35;
    ///////////////////////////Highway4
    int xA8 = 40, yA8 = 305, xTamA8 = 90, yTamA8 = 40;
    int xA9 = 262, yA9 = 301, xTamA9 = 95, yTamA9 = 50;

    // Leña && Peces
    ///////////////////////////Water1
    int xW1 = 40, yW1 = 207, xTamW1 = 60, yTamW1 = 30;
    int xW2 = 195, yW2 = 207, xTamW2 = 60, yTamW2 = 30;
    int xW3 = 380, yW3 = 207, xTamW3 = 60, yTamW3 = 30;
    ////////////////////////////Water2
    int xP1 = 60, yP1 = 158, xTamP1 = 80, yTamP1 = 35;
    int xP2 = 290, yP2 = 158, xTamP2 = 80, yTamP2 = 35;
    /////////////////////////////Water3
    int xW4 = 40, yW4 = 110, xTamW4 = 60, yTamW4 = 30;
    int xW5 = 180, yW5 = 110, xTamW5 = 60, yTamW5 = 30;
    int xW6 = 370, yW6 = 110, xTamW6 = 60, yTamW6 = 30;

    /**
     * Creates new form PanelFrog
     */
    /**
     * Creates new form PanelFrog
     *
     * @param ancho
     * @param alto
     */
    public PanelFrog(int ancho, int alto) {
        initComponents();
        this.setSize(ancho, alto);
        this.ancho = ancho;
        this.alto = alto;

        //Zona segura 1
        panelGround1 panelG1 = new panelGround1(414, 100);
        Safe1.add(panelG1);
        panelG1.setVisible(true);
        //Carretera1
        panelCarretera panelG2 = new panelCarretera(414, 51);
        highway1.add(panelG2);
        panelG2.setVisible(true);
        //Carretera2
        panelCarretera panelG3 = new panelCarretera(414, 51);
        highway2.add(panelG3);
        panelG3.setVisible(true);
        //Carretera3
        panelCarretera panelG4 = new panelCarretera(414, 51);
        highway3.add(panelG4);
        panelG4.setVisible(true);
        //Carretera 4
        panelCarretera panelG5 = new panelCarretera(414, 51);
        highway4.add(panelG5);
        panelG5.setVisible(true);
        //Zona segura 2
        panelGround2 panelG6 = new panelGround2(414, 60);
        Safe2.add(panelG6);
        panelG6.setVisible(true);
        //Water 3
        panelWater3 panelG7 = new panelWater3(414, 51);
        water3.add(panelG7);
        panelG7.setVisible(true);
        //Water 2
        panelWater2 panelG8 = new panelWater2(414, 51);
        water2.add(panelG8);
        panelG8.setVisible(true);
        //Water 1
        panelWater1 panelG9 = new panelWater1(414, 51);
        water1.add(panelG9);
        panelG9.setVisible(true);
        //Zona Segura 3
        panelGround3 panelG10 = new panelGround3(414, 60);
        Safe3.add(panelG10);
        panelG10.setVisible(true);    
        //Barra 
        panelBarra panelG11 = new panelBarra(414, 40);
        jLabel1.add(panelG11);
        panelG11.setVisible(true);

        ///INICIAN HILOS
        name = JOptionPane.showInputDialog(this, "INSTRUCTIONS: \n1.- The frog will start to jump to the right. "
                + "\n2.- You will have to dodge the cars. \n3.- Your frog has three lives. \n\nEnter your name: ");
        
        der = true;
        Rana.start();
        tiempo.start();
        
        sonidoR = java.applet.Applet.newAudioClip(getClass().getResource("/imagenes/ranaS.wav"));
//        
        Auto1.start();
        Auto2.start();
        Auto3.start();
        Auto4.start();
        Auto5.start();
        Auto6.start();
        Auto7.start();
        Auto8.start();
        Auto9.start();
        Wood1.start();
        Wood2.start();
        Wood3.start();
        Fish1.start();
        Fish2.start();
        Wood4.start();
        Wood5.start();
        Wood6.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //Score
        Font font = new Font("Consola", 1, 13);
        g.setFont(font);
        g.setColor(Color.black);
        g.drawString("SCORE: " + score, 15, 15);
        //Tiempo
        g.setColor(Color.black);
        g.drawString("TIME: " + ti + " seconds", 15, 30);
        //Intersecciones
        g.setColor(Color.black);
        g.drawString("DEATHS: " + interseccion, 300, 30); 
        //Name
        g.setColor(Color.black);
        g.drawString("NAME: " + name, 300, 15);
        

        //Frog
        Toolkit t = Toolkit.getDefaultToolkit();
        Image imagen = t.getImage(getClass().getResource("/imagenes/frogJ.png"));
        g.drawImage(imagen, xFr, yFr, xR, yR, this);
        Rectangle frog = new Rectangle();
        frog.setRect(xFr, yFr, xR, yR);

        //Autos
        // Auto 1
        Toolkit a1 = Toolkit.getDefaultToolkit();
        Image imagen1 = a1.getImage(getClass().getResource("/imagenes/auto1.png"));
        g.drawImage(imagen1, xA1, yA1, xTamA1, yTamA1, this);
        Rectangle auto1 = new Rectangle();
        auto1.setRect(xA1, yA1, xTamA1, yTamA1);

        // Auto 2
        Toolkit a2 = Toolkit.getDefaultToolkit();
        Image imagen2 = a2.getImage(getClass().getResource("/imagenes/auto2.png"));
        g.drawImage(imagen2, xA2, yA2, xTamA2, yTamA2, this);
        Rectangle auto2 = new Rectangle();
        auto2.setRect(xA2, yA2, xTamA2, yTamA2);

        // Auto 3
        Toolkit a3 = Toolkit.getDefaultToolkit();
        Image imagen3 = a3.getImage(getClass().getResource("/imagenes/auto3.png"));
        g.drawImage(imagen3, xA3, yA3, xTamA3, yTamA3, this);
        Rectangle auto3 = new Rectangle();
        auto3.setRect(xA3, yA3, xTamA3, yTamA3);

        // Auto 4
        Toolkit a4 = Toolkit.getDefaultToolkit();
        Image imagen4 = a4.getImage(getClass().getResource("/imagenes/auto4.png"));
        g.drawImage(imagen4, xA4, yA4, xTamA4, yTamA4, this);
        Rectangle auto4 = new Rectangle();
        auto4.setRect(xA4, yA4, xTamA4, yTamA4);

        // Auto 5
        Toolkit a5 = Toolkit.getDefaultToolkit();
        Image imagen5 = a5.getImage(getClass().getResource("/imagenes/auto5.png"));
        g.drawImage(imagen5, xA5, yA5, xTamA5, yTamA5, this);
        Rectangle auto5 = new Rectangle();
        auto5.setRect(xA5, yA5, xTamA5, yTamA5);

        // Auto 6
        Toolkit a6 = Toolkit.getDefaultToolkit();
        Image imagen6 = a6.getImage(getClass().getResource("/imagenes/auto6.png"));
        g.drawImage(imagen6, xA6, yA6, xTamA6, yTamA6, this);
        Rectangle auto6 = new Rectangle();
        auto6.setRect(xA6, yA6, xTamA6, yTamA6);

        // Auto 7
        Toolkit a7 = Toolkit.getDefaultToolkit();
        Image imagen7 = a7.getImage(getClass().getResource("/imagenes/auto7.png"));
        g.drawImage(imagen7, xA7, yA7, xTamA7, yTamA7, this);
        Rectangle auto7 = new Rectangle();
        auto7.setRect(xA7, yA7, xTamA7, yTamA7);

        // Auto 8
        Toolkit a8 = Toolkit.getDefaultToolkit();
        Image imagen8 = a8.getImage(getClass().getResource("/imagenes/auto8.png"));
        g.drawImage(imagen8, xA8, yA8, xTamA8, yTamA8, this);
        Rectangle auto8 = new Rectangle();
        auto8.setRect(xA8, yA8, xTamA8, yTamA8);

        // Auto 9
        Toolkit a9 = Toolkit.getDefaultToolkit();
        Image imagen9 = a9.getImage(getClass().getResource("/imagenes/auto9.png"));
        g.drawImage(imagen9, xA9, yA9, xTamA9, yTamA9, this);
        Rectangle auto9 = new Rectangle();
        auto2.setRect(xA9, yA9, xTamA9, yTamA9);

        ///////////////////////////////////////////////////  Water
        // Wood1
        Toolkit a10 = Toolkit.getDefaultToolkit();
        Image imagen10 = a10.getImage(getClass().getResource("/imagenes/woodJ.png"));
        g.drawImage(imagen10, xW1, yW1, xTamW1, yTamW1, this);
        Rectangle wood1 = new Rectangle();
        wood1.setRect(xW1, yW1, xTamW1, yTamW1);

        // Wood2
        Toolkit a11 = Toolkit.getDefaultToolkit();
        Image imagen11 = a11.getImage(getClass().getResource("/imagenes/woodJ.png"));
        g.drawImage(imagen11, xW2, yW2, xTamW2, yTamW2, this);
        Rectangle wood2 = new Rectangle();
        wood2.setRect(xW2, yW2, xTamW2, yTamW2);

        // Wood3
        Toolkit a12 = Toolkit.getDefaultToolkit();
        Image imagen12 = a12.getImage(getClass().getResource("/imagenes/woodJ.png"));
        g.drawImage(imagen12, xW3, yW3, xTamW3, yTamW3, this);
        Rectangle wood3 = new Rectangle();
        wood3.setRect(xW3, yW3, xTamW3, yTamW3);

        // Pez1
        Toolkit a13 = Toolkit.getDefaultToolkit();
        Image imagen13 = a13.getImage(getClass().getResource("/imagenes/pez.png"));
        g.drawImage(imagen13, xP1, yP1, xTamP1, yTamP1, this);
        Rectangle fish1 = new Rectangle();
        fish1.setRect(xP1, yP1, xTamP1, yTamP1);

        // Pez2
        Toolkit a14 = Toolkit.getDefaultToolkit();
        Image imagen14 = a14.getImage(getClass().getResource("/imagenes/pez.png"));
        g.drawImage(imagen14, xP2, yP2, xTamP2, yTamP2, this);
        Rectangle fish2 = new Rectangle();
        wood2.setRect(xP2, yP2, xTamP2, yTamP2);

        // Wood4
        Toolkit a15 = Toolkit.getDefaultToolkit();
        Image imagen15 = a15.getImage(getClass().getResource("/imagenes/woodJ.png"));
        g.drawImage(imagen15, xW4, yW4, xTamW4, yTamW4, this);
        Rectangle wood4 = new Rectangle();
        wood4.setRect(xW4, yW4, xTamW4, yTamW4);

        // Wood5
        Toolkit a16 = Toolkit.getDefaultToolkit();
        Image imagen16 = a16.getImage(getClass().getResource("/imagenes/woodJ.png"));
        g.drawImage(imagen16, xW5, yW5, xTamW5, yTamW5, this);
        Rectangle wood5 = new Rectangle();
        wood5.setRect(xW5, yW5, xTamW5, yTamW5);

        // Wood6
        Toolkit a17 = Toolkit.getDefaultToolkit();
        Image imagen17 = a17.getImage(getClass().getResource("/imagenes/woodJ.png"));
        g.drawImage(imagen17, xW6, yW6, xTamW6, yTamW6, this);
        Rectangle wood6 = new Rectangle();
        wood6.setRect(xW6, yW6, xTamW6, yTamW6);

        if (frog.intersects(auto1) || frog.intersects(auto2) || frog.intersects(auto3) || frog.intersects(auto4) || frog.intersects(auto5) || frog.intersects(auto6)
                || frog.intersects(auto7) || frog.intersects(auto8) || frog.intersects(auto9) || frog.intersects(wood1) || frog.intersects(wood2) || frog.intersects(wood3)
                || frog.intersects(fish1) || frog.intersects(fish2) || frog.intersects(wood4) || frog.intersects(wood5) || frog.intersects(wood6)) {
            interseccion++;
            if (interseccion == 3) {
                sonidoR.stop();
                Rana.stop();
                tiempo.stop();
                Auto1.stop();
                Auto2.stop();
                Auto3.stop();
                Auto4.stop();
                Auto5.stop();
                Auto6.stop();
                Auto7.stop();
                Auto8.stop();
                Auto9.stop();
                Wood1.stop();
                Wood2.stop();
                Wood3.stop();
                Fish1.stop();
                Fish2.stop();
                Wood4.stop();
                Wood5.stop();
                Wood6.stop();
                AudioClip sonido;
                sonido = java.applet.Applet.newAudioClip(getClass().getResource("/imagenes/gameO.wav"));
                sonido.play();
                Icono GO = new Icono();
                JOptionPane.showMessageDialog(this, "Game Over\nScore: " + score +"\nTime: " + ti, "The Frog's Game", JOptionPane.INFORMATION_MESSAGE, GO);
                sonido.stop();
//              JOptionPane.showMessageDialog(null, "Game Over", "Frog Game", JOptionPane.INFORMATION_MESSAGE, GO);
                System.exit(3);
            }
            score -= 15;
            xFr = 199;
            yFr = 560;
        }        
            if (yFr < 80 && interseccion < 3) {
                sonidoR.stop();
                Rana.stop();
                tiempo.stop();
                 Auto1.stop();
                Auto2.stop();
                Auto3.stop();
                Auto4.stop();
                Auto5.stop();
                Auto6.stop();
                Auto7.stop();
                Auto8.stop();
                Auto9.stop();
                Wood1.stop();
                Wood2.stop();
                Wood3.stop();
                Fish1.stop();
                Fish2.stop();
                Wood4.stop();
                Wood5.stop();
                Wood6.stop();
                sonidoW = java.applet.Applet.newAudioClip(getClass().getResource("/imagenes/winnerS.wav"));
                sonidoW.play();
                 ImageIcon W = new ImageIcon(getClass().getResource("/imagenes/Winner.png"));                 
                JOptionPane.showMessageDialog(this, "You win!\nScore: " + score +
                        "\nTime: " + ti + "\nDeaths: " + interseccion, "The Frog's Game", 
                        JOptionPane.INFORMATION_MESSAGE, W);
                sonidoW.stop();
                System.exit(3);
            }
    }

    ///Hilo de rana - 400
    Thread Rana = new Thread() {
        public void run() {
            try {
                while (true) {
                    Thread.sleep(150);
                    movimiento();
                    System.out.println(xFr + "-" + yFr);
                }
            } catch (InterruptedException r) {
                System.out.println(r.getMessage());
            }
        }
    };

    //Hilos de 500 (AUTOS) 
    Thread Auto1 = new Thread() {
        public void run() {
            try {
                while (true) {
                    Thread.sleep(500);
                    moverAuto();                    
                    score += 5;
                }
            } catch (InterruptedException r) {
                System.out.println(r.getMessage());
            }
        }
    };

    Thread Auto2 = new Thread() {
        public void run() {
            try {
                while (true) {
                    Thread.sleep(500);
                    moverAuto2();
                }
            } catch (InterruptedException r) {
                System.out.println(r.getMessage());
            }
        }
    };

    Thread Auto3 = new Thread() {
        public void run() {
            try {
                while (true) {
                    Thread.sleep(500);
                    moverAuto3();
                }
            } catch (InterruptedException r) {
                System.out.println(r.getMessage());
            }
        }
    };
    //Hilos de 200
    Thread Auto4 = new Thread() {
        public void run() {
            try {
                while (true) {
                    Thread.sleep(400);
                    moverAuto4();
                }
            } catch (InterruptedException r) {
                System.out.println(r.getMessage());
            }
        }
    };

    Thread Auto5 = new Thread() {
        public void run() {
            try {
                while (true) {
                    Thread.sleep(400);
                    moverAuto5();
                }
            } catch (InterruptedException r) {
                System.out.println(r.getMessage());
            }
        }
    };

    Thread Auto6 = new Thread() {
        public void run() {
            try {
                while (true) {
                    Thread.sleep(400);
                    moverAuto6();
                }
            } catch (InterruptedException r) {
                System.out.println(r.getMessage());
            }
        }
    };
    //Hilo de 80
    Thread Auto7 = new Thread() {
        public void run() {
            try {
                while (true) {
                    Thread.sleep(100);
                    moverAuto7();
                }
            } catch (InterruptedException r) {
                System.out.println(r.getMessage());
            }
        }
    };
    //Hilos de 150
    Thread Auto8 = new Thread() {
        public void run() {
            try {
                while (true) {
                    Thread.sleep(150);
                    moverAuto8();
                }
            } catch (InterruptedException r) {
                System.out.println(r.getMessage());
            }
        }
    };

    Thread Auto9 = new Thread() {
        public void run() {
            try {
                while (true) {
                    Thread.sleep(150);
                    moverAuto9();
                }
            } catch (InterruptedException r) {
                System.err.println(r.getMessage());
            }
        }
    };

    //Hilos de 500 (Wood) 
    Thread Wood1 = new Thread() {
        public void run() {
            try {
                while (true) {
                    Thread.sleep(500);
                    moverWood1();
                }
            } catch (InterruptedException r) {
                System.err.println(r.getMessage());
            }
        }
    };

    Thread Wood2 = new Thread() {
        public void run() {
            try {
                while (true) {
                    Thread.sleep(500);
                    moverWood2();
                }
            } catch (InterruptedException r) {
                System.err.println(r.getMessage());
            }
        }
    };

    Thread Wood3 = new Thread() {
        public void run() {
            try {
                while (true) {
                    Thread.sleep(500);
                    moverWood3();
                }
            } catch (InterruptedException r) {
                System.err.println(r.getMessage());
            }
        }
    };
    //Hilos de 200 (Fishes) 
    Thread Fish1 = new Thread() {
        public void run() {
            try {
                while (true) {
                    Thread.sleep(300);
                    moverFish1();
                }
            } catch (InterruptedException r) {
                System.err.println(r.getMessage());
            }
        }
    };

    Thread Fish2 = new Thread() {
        public void run() {
            try {
                while (true) {
                    Thread.sleep(300);
                    moverFish2();
                }
            } catch (InterruptedException r) {
                System.err.println(r.getMessage());
            }
        }
    };

    //Hilos de 150 (Wood) 
    Thread Wood4 = new Thread() {
        public void run() {
            try {
                while (true) {
                    Thread.sleep(400);
                    moverWood4();
                }
            } catch (InterruptedException r) {
                System.err.println(r.getMessage());
            }
        }
    };

    Thread Wood5 = new Thread() {
        public void run() {
            try {
                while (true) {
                    Thread.sleep(400);
                    moverWood5();
                }
            } catch (InterruptedException r) {
                System.err.println(r.getMessage());
            }
        }
    };

    Thread Wood6 = new Thread() {
        public void run() {
            try {
                while (true) {
                    Thread.sleep(400);
                    moverWood6();
                }
            } catch (InterruptedException r) {
                System.err.println(r.getMessage());
            }
        }
    };

    //////////////////////Metodos de movimiento de los hilos (Autos)
    public void moverAuto() {
        xA1 += 10;
        if (xA1 > 414) {
            xA1 = -120;
            xA1 += 10;
        }
        repaint();
    }

    public void moverAuto2() {
        xA2 += 10;
        if (xA2 > 414) {
            xA2 = -120;
            xA2 += 10;
        }
        repaint();
    }

    public void moverAuto3() {
        xA3 += 10;
        if (xA3 > 414) {
            xA3 = -120;
            xA3 += 10;
        }
        repaint();
    }

    public void moverAuto4() {
        xA4 -= 10;
        if (xA4 < -80) {
            xA4 = 430;
            xA4 -= 10;
        }
        repaint();
    }

    public void moverAuto5() {
        xA5 -= 10;
        if (xA5 < -80) {
            xA5 = 430;
            xA5 -= 10;
        }
        repaint();
    }

    public void moverAuto6() {
        xA6 -= 10;
        if (xA6 < -80) {
            xA6 = 430;
            xA6 -= 10;
        }
        repaint();
    }

    public void moverAuto7() {
        xA7 += 10;
        if (xA7 > 414) {
            xA7 = -120;
            xA7 += 10;
        }
        repaint();
    }

    public void moverAuto8() {
        xA8 += 10;
        if (xA8 > 414) {
            xA8 = -150;
            xA8 += 10;
        }
        repaint();
    }

    public void moverAuto9() {
        xA9 += 10;
        if (xA9 > 414) {
            xA9 = -150;
            xA9 += 10;
        }
        repaint();
    }

    //////////////////////Metodos de movimiento de los hilos (Wood && Fish)
    public void moverWood1() {
        xW1 += 10;
        if (xW1 > 414) {
            xW1 = -120;
            xW1 += 10;
        }
        repaint();
    }

    public void moverWood2() {
        xW2 += 10;
        if (xW2 > 414) {
            xW2 = -120;
            xW2 += 10;
        }
        repaint();
    }

    public void moverWood3() {
        xW3 += 10;
        if (xW3 > 414) {
            xW3 = -120;
            xW3 += 10;
        }
        repaint();
    }

    public void moverFish1() {
        xP1 -= 10;
        if (xP1 < -80) {
            xP1 = 430;
            xP1 -= 10;
        }
        repaint();
    }

    public void moverFish2() {
        xP2 -= 10;
        if (xP2 < -80) {
            xP2 = 430;
            xP2 -= 10;
        }
        repaint();
    }

    public void moverWood4() {
        xW4 += 10;
        if (xW4 > 414) {
            xW4 = -120;
            xW4 += 10;
        }
        repaint();
    }

    public void moverWood5() {
        xW5 += 10;
        if (xW5 > 414) {
            xW5 = -120;
            xW5 += 10;
        }
        repaint();
    }

    public void moverWood6() {
        xW6 += 10;
        if (xW6 > 414) {
            xW6 = -120;
            xW6 += 10;
        }
        repaint();
    }
    
    Thread tiempo = new Thread(){
        public void run(){
            try{
                while(true){
                    Thread.sleep(500);
                    ti++;
                }
            }catch(InterruptedException r){
                System.err.println(r.getMessage());
            }
        }
    };

    //Movimiento Rana
    public void movimiento() {
        if (xFr > 390 || yFr > 595) {
            sonidoR.stop();
            JOptionPane.showMessageDialog(this, "Don't leave the limits");
            sonidoR.play();
            xFr = 207;
            yFr = 560;
        }        
        if (arr) {
            if (yFr >= 10) {
                yFr -= 10;
            } else {
                //Finalizar
            }
        } else if (aba) {
            if (yFr + 20 < alto) {
                yFr += 10;
            } else {
                //Finalizar
            }
        } else if (der) {
            if (xFr + 20 < ancho) {
                xFr += 10;
            } else {
                //Finalizar
            }
        } else if (izq) {
            if (xFr >= 10) {
                xFr -= 10;
            } else {
                //Finalizar
            }
        }
        repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Safe1 = new javax.swing.JLabel();
        highway1 = new javax.swing.JLabel();
        highway2 = new javax.swing.JLabel();
        highway3 = new javax.swing.JLabel();
        highway4 = new javax.swing.JLabel();
        Safe2 = new javax.swing.JLabel();
        water3 = new javax.swing.JLabel();
        water2 = new javax.swing.JLabel();
        water1 = new javax.swing.JLabel();
        Safe3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Safe1.setText("jLabel1");
        Safe1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(Safe1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 414, 100));

        highway1.setText("jLabel2");
        highway1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(highway1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 414, 51));

        highway2.setText("jLabel3");
        highway2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(highway2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 414, 51));

        highway3.setText("jLabel4");
        highway3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(highway3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 414, 51));

        highway4.setText("jLabel5");
        highway4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(highway4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 414, 51));

        Safe2.setText("jLabel6");
        Safe2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(Safe2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 414, 51));

        water3.setText("jLabel7");
        water3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(water3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 414, 51));

        water2.setText("jLabel8");
        water2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(water2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 414, 51));

        water1.setText("jLabel9");
        water1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(water1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 414, 51));

        Safe3.setText("jLabel10");
        Safe3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(Safe3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 414, 60));

        jLabel1.setText("jLabel1");
        jLabel1.setBorder(new javax.swing.border.MatteBorder(null));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 414, 40));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Safe1;
    private javax.swing.JLabel Safe2;
    private javax.swing.JLabel Safe3;
    private javax.swing.JLabel highway1;
    private javax.swing.JLabel highway2;
    private javax.swing.JLabel highway3;
    private javax.swing.JLabel highway4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel water1;
    private javax.swing.JLabel water2;
    private javax.swing.JLabel water3;
    // End of variables declaration//GEN-END:variables
}
