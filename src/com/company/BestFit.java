package com.company;
import java.util.ArrayList;
import java.util.List;

public class BestFit implements BBPAlgorithm {
    //Het best fit algoritme vult de doos met de minste capaciteit over. Waar het product wel in past.

    @Override
    public List<Box> simulate(int capacity, List<Product> products) {
        ArrayList<Box> ListBox = new ArrayList<Box>();
        ArrayList<Box> ListBoxFit = new ArrayList<Box>();   //List met passende dozen
        Box box1 = new Box(capacity);
        ListBox.add(box1);
        boolean noFit = false;

            for (int i = 0; i < products.size() ; i++) {
                int SmallestFitPointer = 0;
                if (!noFit) {
                    for (int x = 0; x < products.size() ; x++) {
                        for (int j = 0; j < ListBox.size(); j++) {
                            if (ListBox.get(j).getCapacityLeftOver() > products.get(x).getSize()) {
                                ListBoxFit.add(ListBox.get(j));
                            } else {
                                noFit = true;
                            }
                        }
                    } if (!noFit) {
                        for (int x = 0; x < ListBoxFit.size() ; x++) {
                            if (ListBoxFit.get(SmallestFitPointer).getCapacityLeftOver() > ListBoxFit.get(x).getCapacityLeftOver()) {
                                SmallestFitPointer = x;
                            }
                        }
                        ListBoxFit.get(SmallestFitPointer).addProductDirect(products.get(i));
                        ListBox.add(ListBoxFit.get(SmallestFitPointer));
                    }
                } if (noFit) {
                    Box box2 = new Box(capacity);
                    box2.addProductDirect(products.get(i));
                    ListBox.add(box2);
                    noFit = false;
                }
            }
        return ListBox;
    }
}
