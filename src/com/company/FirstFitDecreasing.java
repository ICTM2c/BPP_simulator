package com.company;
import java.util.ArrayList;
import java.util.List;

public class FirstFitDecreasing extends FirstFit {
    //Het first fit decreasing algoritme doet hetzelfde als first fit,
    // maar voordat hij begint sorteert hij de producten op volgorde van grootte, van groot naar klein.

    @Override
    public List<Box> simulate(int capacity, List<Product> products) {
        // Sort the products first
        products.sort((p1, p2) -> p1.compareTo(p2));

        // Pass the sorted array over to the FirstFit algorithm.
        return super.simulate(capacity, products);
    }
    /*@Override
    public List<Box> simulate(int capacity, List<Product> products) {
        ArrayList<Box> ListBox = new ArrayList<Box>();
        Box box1 = new Box(capacity);
        ListBox.add(box1);                                                                          //Begin doos toevoegen zodat het geen null is
        ArrayList<Product> SortedProducts = new ArrayList<Product>();                                     //gesorteerde array
        int pointer = 0;

        for (int i = 0; i < products.size();) {                                                     //Array sorteer loop
            for (int k = 0; k < products.size(); k++) {                                             //loop zodat hij alle waardes van product langs gaat
                if (products.get(pointer).getSize() < products.get(k).getSize() ) {                 //vergelijkt 2 waardes en houd de grootste
                    pointer = k;
                }
            }
            SortedProducts.add(products.get(pointer));                                              //voegt de grootste toe aan de SortedProducts arraylist
            products.remove(pointer);                                                               //Haalt de waarde uit producten zodat dezelfdewaarde niet opnieuw wordt toegevoegd
            pointer = 0;
        }
//        for (int i = 0; i < SortedProducts.size() ; i++) {                                         //Hetzelfde als first fit
//            for (int j = 0; j < ListBox.size() ; j++) {
//                if (ListBox.get(j).getCapacityLeftOver() > SortedProducts.get(i).getSize()) {       //Als de (overgebleven) groote van de doos groter is als de groote van het product
//                    ListBox.get(j).addProduct(SortedProducts.get(i));                               //Voegt prodoct toe aan de doos
//                } if (ListBox.get(j).getCapacityLeftOver() < SortedProducts.get(i).getSize()) {     //Als de (overgebleven) groote van de doos kleiner is als de groote van het product
//                    Box box2 = new Box(capacity);                                                   //Maakt nieuwe doos
//                    box2.addProduct(SortedProducts.get(i));                                         //Voegt Product toe aan box
//                    ListBox.add(box2);                                                              //Voegt box toe aan list
//                }
//            }
//        }
        for (Product product : SortedProducts) {
            boolean didAdd = false;
            for (int j = 0; j < ListBox.size() ; j++) {
                Box box = ListBox.get(j);
                if (box.addProduct(product)) {
                    didAdd = true;
                    break;
                }
            }

            if (!didAdd) {
                Box newBox = new Box();     //Maakt nieuwe doos met capacity en haal er de size van het het product vanaf
                newBox.addProduct(product); //Voegt Product toe aan box
                ListBox.add(newBox);        //Voegt box toe aan list
            }
        }
        return ListBox;
    }*/
}
