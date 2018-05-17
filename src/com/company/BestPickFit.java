package com.company;
import java.util.ArrayList;
import java.util.List;

public class BestPickFit implements BBPAlgorithm {
    //First fit better fill is vergelijkbaar aan First Fit,
    // maar kijkt eerst of er een andere lading is die groter is die wellicht ook past.

    @Override
    public List<Box> simulate(int capacity, List<Product> products) {
        List<Box> ListBoxFirstFit = new ArrayList<Box>(); //List voor resultaten van FirstFitAlgorithm
        List<Box> ListBoxBestFit = new ArrayList<Box>(); //List voor resultaten van BestFitAlgorithm
        List<Box> ListBoxFirstFitDecreasing = new ArrayList<Box>(); // List voor resultaten van FirstFitDecreasingAlgorithm

        FirstFit FirstFitAlgorithm = new FirstFit(); // maak nieuwe FirstFitAlgorithm aan
        ListBoxFirstFit = FirstFitAlgorithm.simulate(capacity, products); //voer FirstFitAlgorithm uit en zet de resultaten in ListBoxFirstFit
        BestFit BestFitAlgorithm = new BestFit(); //maak nieuwe BestFitAlgorithm aan
        ListBoxBestFit = BestFitAlgorithm.simulate(capacity, products); //voer BestFitAlgorithm uit en zet de resultaten in ListBoxBestFit
        FirstFitDecreasing FirstFitDecreasingAlgorithm = new FirstFitDecreasing(); //maak nieuwe FirstFitDecreasingAlgorithm aan
        FirstFitDecreasingAlgorithm.simulate(capacity, products); //voer FirstFitDecreasingAlgorithm uit en zet de resultaten in ListBoxFirstFitDecreasing


        if (ListBoxFirstFit.size() <= ListBoxBestFit.size()) { //vergelijkt FirstFit met BestFit
            if (ListBoxFirstFit.size() <= ListBoxFirstFitDecreasing.size()) { //vergelijkt FirstFit met FirstFitDecreasing
                return ListBoxFirstFit; //return
            } else {
                return ListBoxFirstFitDecreasing; //return
            }
        } else {
            return ListBoxBestFit; //return
        }
    }
}