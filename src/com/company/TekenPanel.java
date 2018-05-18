package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
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

public void tekenProduct(List<Box> boxList, Graphics g) {
    super.paintComponent(g);
    ArrayList<Color> Kleuren = new ArrayList<>();

    for (int i = 0; i < boxList.size(); i++) { //loopt de verschillende dozen
        int Xas = 100 + (100 * i); //Xas pos berekening
        int PixelCounter = 0; //counter om begin hoogte weer te geven
        int Yas = 100 + PixelCounter; //yas pos berekening
        int pixelsPerSlot = 200 / boxList.get(i).getCapacity(); //pixels per 1 size

        for (int j = 0; j < boxList.get(i).getProducts().size(); j++) { //loopt producten van de doos door
            int size = boxList.get(i).getProducts().get(j).getSize(); //size = size van product in doos
            g.fillRect(100, Yas, 50, size * pixelsPerSlot); //teken rect
            PixelCounter = PixelCounter + size * pixelsPerSlot; //geeft pixelcounter nieuwe waarde
            for (int k = 0; k < Kleuren.size(); k++) { //loopt door de gebruikte kleuren heen
                Color kleur = new Color((int) (Math.random() * 0x1000000)); //geeft random kleur code
                if (kleur == Kleuren.get(k)) { //als keur al is gebruikt
                } else {
                    g.setColor(kleur); //set kleur
                }
            }
        }
    }
}


    public void setCapacity ( int capacity){
        this._capacity = capacity;
    }
    @Override
    public void paintComponent (Graphics g){


        super.paintComponent(g);

        setBackground(Color.WHITE);

        g.setColor(Color.BLACK);
        g.drawRect(100, 100, 50, 200);
        g.drawRect(200, 100, 50, 200);
        g.drawString("doos 1", 105, 320);
        g.drawString("doos 2", 205, 320);
        g.drawString(_capacity + " over", 105, 120);
        g.drawString(_capacity + " over", 205, 120);

        if (SizeProduct == 7) {
            g.drawRect(100, 100, 50, 100);
            repaint();
        }
    }
}
