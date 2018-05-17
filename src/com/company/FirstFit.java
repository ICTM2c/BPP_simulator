package com.company;
import java.util.ArrayList;
import java.util.List;

public class FirstFit implements BBPAlgorithm {

    @Override
    public List<Box> simulate(int capacity, List<Product> products) {
        ArrayList<Box> ListBox = new ArrayList<Box>();
        Box box1 = new Box(capacity); //De begin doos
        ListBox.add(box1);

        for (int i = 0; i <= products.size() ; i++) {
            for (int j = 0; j <= ListBox.size() ; j++) {
                if (ListBox.get(j).getCapacity() >= products.get(i).getSize()) { //Als de (overgebleven) groote van de doos groter is als de groote van het product
                    ListBox.get(j).addProduct(products.get(i)); //Voegt prodoct toe aan de doos
                } if (ListBox.get(j).getCapacity() < products.get(i).getSize()) { //Als de (overgebleven) groote van de doos kleiner is als de groote van het product
                    Box box2 = new Box(capacity); //Maakt nieuwe doos
                    box2.addProduct(products.get(i)); //Voegt Product toe aan box
                    ListBox.add(box2); //Voegt box toe aan list
                }
            }
        }
        return ListBox;
    }
}


