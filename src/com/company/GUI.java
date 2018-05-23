package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
public class GUI extends JFrame implements ActionListener {

    int value;

    //tekstvelden
    private JLabel titleTekst;                  //title;
    private JLabel selecterenAlgoritmeTekst;    // Algoritme Selecteren tekst
    private JLabel productenTitelTekst;              // Producten tekst
    private JLabel doosTekst;                   // Doos tekst
    private JLabel voegProductToeTekst;         //voeg Product toe tekst
    private JLabel invoerenOrderTekst;          // Order invoeren tekst
    private JLabel doosCapaciteitTekst;         // Doos capaciteit tekst
    private JLabel productGrootteTekst;         // Grootte product tekst

    private JNumberTextField CapacityProduct;
    private JSpinner CapacityBox;
    private DefaultListModel<Product> productList = new DefaultListModel<Product>();

    // panels
    private JPanel Panel1;
    private JPanel Panel2;
    private JPanel Panel3;
    private JList<Product> productenTekst;
    private TekenPanel DrawPanel;

    //knoppen
    private JButton bestandButton;
    private JButton ToevoegenButton;
    private JButton SimuleerButton;
    private JButton CapaciteitOkButton;

    private JOptionPane bigProduct;
    private String[] Algoritme = {"First Fit", "First Fit Decreasing", "Best Pick Fit", "Best Fit"};

    private String[] producten = {};
    private JComboBox AlgoritmeLijst;


    public GUI() {

        setTitle("BPP simulator");
        setSize(1550 , 750);
        setLayout(new FlowLayout());
        setResizable(false);

        SpinnerModel spinnerModel1 = new SpinnerNumberModel(50, 10, 100, 1);

        CapacityBox = new JSpinner(spinnerModel1);
        CapacityProduct = new JNumberTextField();

        bigProduct = new JOptionPane();
        AlgoritmeLijst = new JComboBox(Algoritme);

        Panel1 = new JPanel();
        Panel2 = new JPanel();
        Panel3 = new JPanel();
        productenTekst = new JList<Product>(productList);
        DrawPanel = new TekenPanel();

        Panel2.setLayout(new GridLayout(8, 1));
      //  Panel3.setLayout(new GridLayout(10, 1));
        Panel3.setLayout(new FlowLayout());

        Panel1.setPreferredSize(new Dimension(1500, 100));
        Panel2.setPreferredSize(new Dimension(300, 600));
        Panel3.setPreferredSize(new Dimension(300, 600));
        DrawPanel.setPreferredSize(new Dimension(900, 600));

        DrawPanel.setBackground(Color.white);

        // alle knoppen
        bestandButton = new JButton("Bestand");
        ToevoegenButton = new JButton("Toevoegen");
        SimuleerButton = new JButton("Simuleer");
        CapaciteitOkButton = new JButton("OK");

        // alle JLabels
        titleTekst = new JLabel("BPP - Simulator");
        selecterenAlgoritmeTekst = new JLabel("Selecteren Algoritme");
        productenTitelTekst = new JLabel("Producten");
        doosTekst = new JLabel("Doos");
        voegProductToeTekst = new JLabel("Voeg product toe");
        invoerenOrderTekst = new JLabel("Invoeren order");
        productGrootteTekst = new JLabel("product grootte:");
        doosCapaciteitTekst = new JLabel("Doos Capaciteit:");

        titleTekst.setFont(new Font("Serif", Font.PLAIN, 30));
        selecterenAlgoritmeTekst.setFont(new Font("Serif", Font.PLAIN, 20));
        productenTitelTekst.setFont(new Font("Serif", Font.PLAIN, 20));
        doosTekst.setFont(new Font("Serif", Font.PLAIN, 20));
        voegProductToeTekst.setFont(new Font("Serif", Font.PLAIN, 20));
        invoerenOrderTekst.setFont(new Font("Serif", Font.PLAIN, 20));

        CapacityProduct.setSize(20, 5);
        CapacityProduct.setPreferredSize(new Dimension(40, 20));

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
        Panel3.add(productenTitelTekst);
        Panel3.add(new JScrollPane(productenTekst));
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
        if (e.getSource() == CapaciteitOkButton) {                          // knop om invoer product te bevestigen
            value = Integer.parseInt(CapacityBox.getValue().toString());    //Ingevoerde waarde
            Box.setCapacity(value);                                         //Zet de capaciteit van de doos
            DrawPanel.repaint();                                            //Refreshed de GUI
        } else if (e.getSource() == bestandButton) {                        // knop om bestanden te uploaden
            final JFileChooser fc = new JFileChooser();                     // een filefinder voor de JSON product
            fc.setCurrentDirectory(new java.io.File("."));
            int returnVal = fc.showOpenDialog(this);
            if (returnVal != JFileChooser.APPROVE_OPTION) {
                return;
            }
            File f = fc.getSelectedFile();
        } else if (e.getSource() == ToevoegenButton) {                     // knop om producten toe te voegen
            DrawPanel.set_SizeProduct(CapacityProduct.getNumber());
            if (CapacityProduct.getNumber() <= Box.getCapacity() && CapacityProduct.getNumber() >= 1) { // product grootte vergelijken met doos grootte
                Product product = new Product(CapacityProduct.getNumber());
                productList.addElement(product);

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        productenTekst.validate();
                        productenTekst.repaint();
                    }
                });
                System.out.println(productList.size());
            } else if (CapacityProduct.getNumber() > Box.getCapacity()) {
                bigProduct.showMessageDialog(ToevoegenButton, "Product te groot");

            } else if (CapacityProduct.getNumber() < 1) {
                bigProduct.showMessageDialog(ToevoegenButton, "Product te klein");
            }
        } else if (e.getSource() == SimuleerButton) {                      //Simuleerknop
            String selectedAlgorithm = (String) AlgoritmeLijst.getSelectedItem();
            Product[] t = Arrays.stream(productList.toArray()).toArray(Product[]::new);
            List<Product> allProducts = Arrays.asList(t);
            List<Box> BoxList = new ArrayList<>();
            if (selectedAlgorithm == "First Fit") {
                FirstFit firstFit = new FirstFit();
                BoxList = firstFit.simulate(value, allProducts); //Runt Firstfit algoritme
            } else if (selectedAlgorithm == "First Fit Decreasing") {
                FirstFitDecreasing firstFitDecreasing = new FirstFitDecreasing();
                BoxList = firstFitDecreasing.simulate(value,allProducts);
            } else if (selectedAlgorithm == "Best Pick Fit") {
                BestPickFit bestPickFit = new BestPickFit();
                BoxList = bestPickFit.simulate(value,allProducts);
            } else if (selectedAlgorithm == "Best Fit") {
                BestFit bestFit  = new BestFit();
                BoxList = bestFit.simulate(value,allProducts);
            }
            DrawPanel.setBoxes(BoxList);
            DrawPanel.repaint();
            Order order = new Order();
            order.CreateDeliveryNote(BoxList,order.getOrderId());
            repaint();
        }
    }
//    private void selectGridFromOrder() {
//        //Create a file chooser
//        final JFileChooser fc = new JFileChooser();
//
//        //In response to a button click:
//        int returnVal = fc.showOpenDialog(this);
//
//        if (returnVal != JFileChooser.APPROVE_OPTION) {
//            return;
//        }
//
//        File f = fc.getSelectedFile();
//        try (FileInputStream br = new FileInputStream(f.getAbsolutePath())) {
//            // Read the order file.
//            String json = new String(br.readAllBytes(), "UTF-8");
//
//            // Deserialize it from Json to an Order object.
//            Gson deserializer = new Gson();
//            Order order = deserializer.fromJson(json, Order.class);
//
//            // Find all the products which are linked to the order including their location.
//            List<TSPSimulator.Models.Product> products = DbProduct.Get().findProductsForOrder(order.getOrder());
//
//            // Reset the size of the grid.
//            pnlSimulator.setSizeX(5);
//            pnlSimulator.setSizeY(5);
//
//            // Fill the products in the grid.
//            for (TSPSimulator.Models.Product product : products) {
//                pnlSimulator.setIsClicked((int) product.getLocation().getX(), (int) product.getLocation().getY(), true);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Unable to retrieve the order from the database.");
//        } catch (FileNotFoundException e) {
//            JOptionPane.showMessageDialog(this, "The file could not be found. Has it been removed?");
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(this, "Unable to open the order file.");
//        } catch (JsonSyntaxException e) {
//            JOptionPane.showMessageDialog(this, "The file is not an order file.");
//        } catch (OrderNotFoundException e) {
//            JOptionPane.showMessageDialog(this, e.toString());
//        }
//    }
}