package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
public class GUI extends JFrame implements ActionListener{

    private Box Box1;   // doos aanmaken
    private Box Box2;   // doos aanmaken

    //tekstvelden
    private JLabel titleTekst;  //tite;
    private JLabel selecterenAlgoritmeTekst; // Algoritme Selecteren tekst
    private JLabel productenTekst;           // Producten tekst
    private JLabel doosTekst;               // Doos tekst
    private JLabel voegProductToeTekst;     //voeg Product toe tekst
    private JLabel invoerenOrderTekst;      // Order invoeren tekst
    private JLabel doosCapaciteitTekst;     // Doos capaciteit tekst
    private JLabel productGrootteTekst;     // Grootte product tekst

    private JNumberTextField CapacityProduct;


    private JSpinner CapacityBox;

    private ArrayList<Product> productList = new ArrayList<Product>();


    // panels
    private JPanel Panel1;
    private JPanel Panel2;
    private JPanel Panel3;
    private TekenPanel DrawPanel;

    //knoppen
    private JButton bestandButton;
    private JButton ToevoegenButton;
    private JButton SimuleerButton;
    private JButton CapaciteitOkButton;



    private JOptionPane bigProduct;
    private String[] Algoritme = {"First Fit", "First Fit Decreasing", "Next Fit", "Best Fit"};
    private JComboBox AlgoritmeLijst;


    private JLabel[] tekst = {selecterenAlgoritmeTekst, productenTekst, doosTekst, voegProductToeTekst, invoerenOrderTekst};

    public GUI() {
    Box1 = new Box();
    Box2 = new Box();
    setTitle("BPP simulator");
    setSize(1050, 500);
    setLayout(new FlowLayout());
    setResizable(false);

    int maxdoos = Box1.getCapacity();
    System.out.println(maxdoos);


    SpinnerModel spinnerModel1 = new SpinnerNumberModel(50,10,100,1);

    CapacityBox = new JSpinner(spinnerModel1);
    CapacityProduct = new JNumberTextField();




    bigProduct = new JOptionPane();
    AlgoritmeLijst = new JComboBox(Algoritme);


    Panel1 = new JPanel();
    Panel2 = new JPanel();
    Panel3 = new JPanel();
    DrawPanel = new TekenPanel();

    Panel2.setLayout(new GridLayout(8, 1));
    Panel3.setLayout(new GridLayout(6, 1));

    Panel1.setPreferredSize(new Dimension(1000, 100));
    Panel2.setPreferredSize(new Dimension(300, 350));
    Panel3.setPreferredSize(new Dimension(300, 350));
    DrawPanel.setPreferredSize(new Dimension(400, 350));


   /* Panel1.setBackground(Color.red);
    Panel2.setBackground(Color.green);
    Panel3.setBackground(Color.blue);
*/

    DrawPanel.setBackground(Color.white);


    // alle knoppen
    bestandButton = new JButton("Bestand");
    ToevoegenButton = new JButton("Toevoegen");
    SimuleerButton = new JButton("Simuleer");
    CapaciteitOkButton = new JButton("OK");

    // alle JLabels
    titleTekst = new JLabel("BPP - Simulator");
    selecterenAlgoritmeTekst = new JLabel("Selecteren Algoritme");
    productenTekst = new JLabel("Producten");
    doosTekst = new JLabel("Doos");
    voegProductToeTekst = new JLabel("Voeg product toe");
    invoerenOrderTekst = new JLabel("Invoeren order");
    productGrootteTekst = new JLabel("product grootte:");
    doosCapaciteitTekst = new JLabel("Doos Capaciteit:");


    titleTekst.setFont(new Font("Serif", Font.PLAIN, 30));
    selecterenAlgoritmeTekst.setFont(new Font("Serif", Font.PLAIN, 20));
    productenTekst.setFont(new Font("Serif", Font.PLAIN, 20));
    doosTekst.setFont(new Font("Serif", Font.PLAIN, 20));
    voegProductToeTekst.setFont(new Font("Serif", Font.PLAIN, 20));
    invoerenOrderTekst.setFont(new Font("Serif", Font.PLAIN, 20));



    CapacityProduct.setSize(20, 5);

    bestandButton.addActionListener(this);
    ToevoegenButton.addActionListener(this);
    SimuleerButton.addActionListener(this);
    CapaciteitOkButton.addActionListener(this);


    add(Panel1);
    add(Panel2);
    add(Panel3);
    add(DrawPanel);

    Panel1.add(titleTekst);


    Panel2.add(selecterenAlgoritmeTekst);
    Panel2.add(AlgoritmeLijst);
    Panel2.add(doosTekst);
    Panel2.add(doosCapaciteitTekst);
    Panel2.add(CapacityBox);
    Panel2.add(CapaciteitOkButton);
    Panel2.add(invoerenOrderTekst);
    Panel2.add(bestandButton);

//panel 3 components
    Panel3.add(productenTekst);
    Panel3.add(voegProductToeTekst);
    Panel3.add(productGrootteTekst);
    Panel3.add(CapacityProduct);
    Panel3.add(ToevoegenButton);
    Panel3.add(SimuleerButton);






    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == CapaciteitOkButton){                        // knop om invoer product te bevestigen
            int value =  Integer.parseInt(CapacityBox.getValue().toString());

            Box1.setCapacity(value);
            Box2.setCapacity(value);
            System.out.println(Box1.getCapacity());
            DrawPanel.setCapacity(value);
            DrawPanel.repaint();

        }
        else if(e.getSource() == bestandButton) {                       // knop om bestanden te uploaden
            final JFileChooser fc = new JFileChooser();                 // een filefinder voor de JSON product
            fc.setCurrentDirectory(new java.io.File("."));
            int returnVal = fc.showOpenDialog(this);
            if (returnVal != JFileChooser.APPROVE_OPTION) {
                return;
            }
            File f = fc.getSelectedFile();
        }else if(e.getSource() == ToevoegenButton){                     // knop om producten toe te voegen

            DrawPanel.set_SizeProduct(CapacityProduct.getNumber());
            if(CapacityProduct.getNumber() <= Box1.getCapacity() && CapacityProduct.getNumber() >= 1) { // product grootte vergelijken met doos grootte
                Product product = new Product(CapacityProduct.getNumber());
            productList.add(product);
                System.out.println(productList.size());
            } else if(CapacityProduct.getNumber() > Box1.getCapacity()){
                bigProduct.showMessageDialog(ToevoegenButton, "Product te groot");

            } else if (CapacityProduct.getNumber() < 1){
                bigProduct.showMessageDialog(ToevoegenButton, "Product te klein");
            }
        }else if(e.getSource() == SimuleerButton){
            String selectedAlgorithm = (String) AlgoritmeLijst.getSelectedItem();

            if(selectedAlgorithm == "First Fit"){
                System.out.println("FirstFit");                     // hier komt First Fit algoritme
            }else if(selectedAlgorithm == "First Fit Decreasing"){
                System.out.println("First Fit Decreasing");         // hier komt First Fit decreasing algoritme
            } else if(selectedAlgorithm == "Next Fit"){
                System.out.println("Next Fit");                     // hier komt Next Fit algoritme
            } else if(selectedAlgorithm == "Best Fit"){
                System.out.println("Best Fit");                     // hier komt Best Fit algoritme
            }
        }
        repaint();
    }
    }

