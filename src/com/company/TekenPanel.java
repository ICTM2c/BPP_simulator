package com.company;

import java.awt.*;
import javax.swing.*;

public class TekenPanel extends JPanel{
    public TekenPanel(){
        this.setPreferredSize(new Dimension(400, 350));
    }
    public void paintComponent(Graphics g) {


        super.paintComponent(g);

        setBackground(Color.WHITE);


        g.setColor(Color.BLACK);
        g.drawRect(100, 100, 50, 200);
        g.drawRect(200, 100, 50, 200);
        g.drawString("doos 1", 105, 320);
        g.drawString("doos 2", 205, 320);
        g.drawString("50 over", 105, 120);
        g.drawString("50 over", 205, 120);
        /*g.setColor(Color.RED);
        g.fillRect(100, 280, 50, 20);
        g.setColor(Color.blue);
        g.fillRect(100, 200, 50, 80);
    */
    }



}
