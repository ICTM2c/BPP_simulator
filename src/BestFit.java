import java.util.ArrayList;
import java.util.List;

public class BestFit implements BBPAlgorithm {

    @Override
    public List<Box> simulate(int capacity, List<Product> products) {
        ArrayList<Box> ListBox = new ArrayList<Box>();
        ArrayList<Box> SizeLeftList = new ArrayList<Box>(); //List met passende dozen
        Box box1 = new Box(capacity); //De begin doos
        ListBox.add(box1);
        int smallestSizeLeft = 0; //iniatilisatie zodat de vergelijker begint op de eerste doos

        for (int i = 0; i <= products.size() ; i++) {
            for (int j = 0; j <= ListBox.size() ; j++) {
                if (ListBox.get(j).getCapacity() >= products.get(i).getSize()) { //Als de (overgebleven) groote van de doos groter is als de groote van het product
                    SizeLeftList.add(ListBox.get(j));//Voegt de doos toe aan de list met passende dozen
                }else if (ListBox.get(j).getCapacity() < products.get(i).getSize()) { //Als de (overgebleven) groote van de doos kleiner is als de groote van het product
                    Box box2 = new Box(capacity); //Maakt nieuwe doos
                    SizeLeftList.add(box2); //Voegt box toe aan list
                }
            }
            for (int k = 0; k < SizeLeftList.size() ; k++) {
                if (SizeLeftList.get(smallestSizeLeft).getCapacity() >= SizeLeftList.get(k).getCapacity()) { //vergelijkt grootes van de overgebleven dozen en kiest de kleinste
                    smallestSizeLeft = k;
                }
            }
            ListBox.add(SizeLeftList.get(smallestSizeLeft)); //voegt de uit eindelijke kleinste toe
            SizeLeftList.clear(); //maakt de sizeleftlist leeg
            smallestSizeLeft = 0; //Zet de pointer weer op de eerste plek
        }
        return ListBox;
    }
}
