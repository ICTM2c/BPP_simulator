package com.company;
import java.util.ArrayList;
import java.util.List;

public class FirstFitDecreasing implements BBPAlgorithm {
    //Het first fit decreasing algoritme doet hetzelfde als first fit,
    // maar voordat hij begint sorteert hij de producten op volgorde van grootte, van groot naar klein.

    @Override
    public List<Box> simulate(int capacity, List<Product> products) {
        ArrayList<Box> ListBox = new ArrayList<Box>();
        ArrayList<Product> SortetProducts = new ArrayList<Product>(); //gesorteerde array
        int pointer = 0;

        for (int i = 0; i < products.size(); i++) { //Array sorteer loop
            for (int k = 0; k < products.size(); k++) { //loop zodat hij alle waardes van product langs gaat
                if (products.get(pointer).getSize() < products.get(k).getSize() ) { //vergelijkt 2 waardes en houd de grootste
                    pointer = k;
                }
            } SortetProducts.add(products.get(pointer)); //voegt de grootste toe aan de SortetProducts arraylist
        }
        for (int i = 0; i <= SortetProducts.size() ; i++) { //Hetzelfde als first fit
            for (int j = 0; j <= ListBox.size() ; j++) {
                if (ListBox.get(j).getCapacity() >= SortetProducts.get(i).getSize()) { //Als de (overgebleven) groote van de doos groter is als de groote van het product
                    ListBox.get(j).addProduct(SortetProducts.get(i)); //Voegt prodoct toe aan de doos
                } if (ListBox.get(j).getCapacity() < SortetProducts.get(i).getSize()) { //Als de (overgebleven) groote van de doos kleiner is als de groote van het product
                    Box box2 = new Box(capacity); //Maakt nieuwe doos
                    box2.addProduct(SortetProducts.get(i)); //Voegt Product toe aan box
                    ListBox.add(box2); //Voegt box toe aan list
                }
            }
        }
        return ListBox;
    }
}
