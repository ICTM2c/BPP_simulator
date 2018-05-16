package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class GUI extends JFrame implements ActionListener{
   //tekstvelden
    private JLabel titleTekst;
    private JLabel selecterenAlgoritmeTekst;
    private JLabel productenTekst;
    private JLabel doosTekst;
    private JLabel voegProductToeTekst;
    private JLabel invoerenOrderTekst;
    private JLabel doosCapaciteitTekst;
    private JLabel productGrootteTekst;

    private JDialog b;
    private JFileChooser fc;
    private JSpinner d;


    // panels
    private JPanel Panel1;
    private JPanel Panel2;
    private JPanel Panel3;
    private TekenPanel Panel4;


    //knoppen
    private JButton bestandButton;
    private JButton ToevoegenButton;
    private JButton SimuleerButton;


    private String[] Algoritme = {"First Fit", "First Fit Decreasing", "Next Fit", "Best Fit"};
    private JComboBox AlgoritmeLijst;


    private JLabel[] tekst = {selecterenAlgoritmeTekst, productenTekst, doosTekst, voegProductToeTekst, invoerenOrderTekst};


public GUI() {
    setTitle("BPP simulator");
    setSize(1050, 500);
    setLayout(new FlowLayout());

    SpinnerModel spinnerModel = new SpinnerNumberModel(50,10,100,1);
    JSpinner d = new JSpinner(spinnerModel);




    JFileChooser fc = new JFileChooser();

    fc.setCurrentDirectory(new java.io.File("."));
    fc.getFileFilter();




    AlgoritmeLijst = new JComboBox(Algoritme);

    JPanel Panel1 = new JPanel();
    JPanel Panel2 = new JPanel();
    JPanel Panel3 = new JPanel();
    Panel4 = new TekenPanel();

    Panel2.setLayout(new GridLayout(7, 1));
    Panel3.setLayout(new GridLayout(5, 1));

    Panel1.setPreferredSize(new Dimension(1000, 100));
    Panel2.setPreferredSize(new Dimension(300, 350));
    Panel3.setPreferredSize(new Dimension(300, 350));
    Panel4.setPreferredSize(new Dimension(400, 350));


   /* Panel1.setBackground(Color.red);
    Panel2.setBackground(Color.green);
    Panel3.setBackground(Color.blue);
*/

    Panel4.setBackground(Color.white);

    bestandButton = new JButton("Bestand");
    ToevoegenButton = new JButton("Toevoegen");
    SimuleerButton = new JButton("Simuleer");

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





    bestandButton.addActionListener(this);
    ToevoegenButton.addActionListener(this);
    SimuleerButton.addActionListener(this);


    add(Panel1);
    add(Panel2);
    add(Panel3);
    add(Panel4);

    Panel1.add(titleTekst);


    Panel2.add(selecterenAlgoritmeTekst);
    Panel2.add(AlgoritmeLijst);
    Panel2.add(doosTekst);
    Panel2.add(doosCapaciteitTekst);
    Panel2.add(d);
    Panel2.add(invoerenOrderTekst);
    Panel2.add(bestandButton);


    Panel3.add(productenTekst);
    Panel3.add(voegProductToeTekst);
    Panel3.add(productGrootteTekst);
    Panel3.add(ToevoegenButton);
    Panel3.add(SimuleerButton);





    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bestandButton){
            System.out.println("Bestand knop doet het");
                if(fc.showOpenDialog(bestandButton) == JFileChooser.APPROVE_OPTION){
        //
    }

    System.out.println(fc.getSelectedFile().getAbsolutePath());

        }else if(e.getSource() == ToevoegenButton){
            System.out.println("Toevoeg knop doet het");
            product p = new product(1, 20);

        }else if(e.getSource() == SimuleerButton){
            System.out.println("Simuleer knop doet het");
        }
        repaint();
    }
    }

