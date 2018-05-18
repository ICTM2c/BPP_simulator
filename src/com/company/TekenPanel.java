package com.company;

import java.awt.*;
import javax.swing.*;

public class TekenPanel extends JPanel{
    private int SizeProduct;
    private int _capacity = 50;
    private int hoogteProduct;


    public TekenPanel(){
        this.setPreferredSize(new Dimension(400, 350));

    }
public void set_SizeProduct (int Size){
        this.SizeProduct = Size;
}

public void tekenProduct(Order order){
}


    public void setCapacity(int capacity) {
        this._capacity = capacity;
    }
@Override
    public void paintComponent(Graphics g) {


        super.paintComponent(g);

        setBackground(Color.WHITE);

        g.setColor(Color.BLACK);
        g.drawRect(100, 100, 50, 200);
        g.drawRect(200, 100, 50, 200);
        g.drawString("doos 1", 105, 320);
        g.drawString("doos 2", 205, 320);
        g.drawString(_capacity + " over", 105, 120);
        g.drawString(_capacity + " over", 205, 120);

        if(SizeProduct == 7){
            g.drawRect(100,100,50,100);
            repaint();
        }
    }



}
