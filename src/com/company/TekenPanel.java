package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class TekenPanel extends JPanel {
    private int SizeProduct;
    private List<Box> _boxes = new ArrayList<>();
    private final int boxWidth = 50;
    private final int StringHeight = 83;
    private final int doosYas = 100;


    public void set_SizeProduct(int Size) {
        this.SizeProduct = Size;
    }

    public void setBoxes(List<Box> boxes) {
        _boxes = boxes;
    }



    public void tekenProduct(Graphics g) {
        super.paintComponent(g);
    //    ArrayList<Color> Kleuren = new ArrayList<>();
        setBackground(Color.WHITE);
        int boxHeight = 400;

        for (int i = 0; i < _boxes.size(); i++) {                           //loopt de verschillende dozen
            int Xas = 75 + (150 * i);                                       //Xas pos berekening
            int PixelCounter = 0;                                           //counter om begin hoogte weer te geven
            int Yas = 500 + PixelCounter;                                   //yas pos berekening
            int pixelsPerSlot = 400 / Box.getCapacity();                    //pixels per 1 size

            int remainingSize = 400;
            int DoosCounter = i + 1;
            String doostekst = "doos" + DoosCounter;
            g.setColor(Color.BLACK);
            g.drawRect(Xas- 1, doosYas - 1, boxWidth + 1, boxHeight);
            g.drawString(doostekst, Xas + 10, StringHeight + 12);
            if(Box.getCapacity() == 0){
                g.drawString("Vol", Xas + 10, StringHeight);
            }else {
                g.drawString(_boxes.get(i).getCapacityLeftOver() + " over", Xas + 5, StringHeight);
            }
            for (int j = 0; j < _boxes.get(i).getProducts().size(); j++) {                              //loopt producten van de doos door
                int size = _boxes.get(i).getProducts().get(j).getSize();                                //size = size van product in doos
                Color kleur1 = new Color((int) (Math.random() * 0x1000000));                            //geeft random kleur code
                g.setColor(kleur1);
                g.fillRect(Xas,  (doosYas + remainingSize) - (size * pixelsPerSlot), boxWidth, size * pixelsPerSlot);        //teken rect
                System.out.println(remainingSize);
                remainingSize -= size * pixelsPerSlot;
                PixelCounter = PixelCounter + size * pixelsPerSlot;
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        tekenProduct(g);
        if (true){
            return;
        }
    }

}
