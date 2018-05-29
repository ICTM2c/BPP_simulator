package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
public class GUI extends JFrame implements ActionListener {

    //tekstvelden
    private JLabel Jlbltitle;                   //title;
    private JLabel JlblselecterenAlgoritme;    // AlgoritmeNamen Selecteren tekst
    private JLabel JlblproductenTitel;         // Producten tekst
    private JLabel Jlbldoos;                   // Doos tekst
    private JLabel JlblvoegProductToe;         //voeg Product toe tekst
    private JLabel JlblinvoerenOrder;          // Order invoeren tekst
    private JLabel JlbldoosCapaciteit;         // Doos capaciteit tekst
    private JLabel JlblproductGrootte;         // Grootte product tekst
    // panels
    private JPanel JpTitel;
    private JPanel JpAlgoritme;
    private JPanel JpProduct;
    private JList<Product> JlProductenLijst;
    private TekenPanel TpDrawProduct;
    //knoppen
    private JButton JbBestand;
    private JButton JbToevoegen;
    private JButton JbSimuleer;
    private JButton JbOk;
    private JButton JbOverzicht;
    private JButton JbReset;
    //andere componenten
    private JNumberTextField JtfCapacityProduct;
    private JSpinner JspCapacityBox;
    private DefaultListModel<Product> productList = new DefaultListModel<Product>();
    private JOptionPane JopGrootteProduct;
    private JComboBox JcbAlgoritmeLijst;

    private String[] AlgoritmeNamen = {"First Fit", "First Fit Decreasing", "Best Pick Fit", "Best Fit"};
    int value;


    public GUI() {

        setTitle("BPP simulator");
        setSize(1550 , 750);
        setLayout(new FlowLayout());
        setResizable(false);

        SpinnerModel spinnerModel = new SpinnerNumberModel(50, 10, 100, 1);

        JspCapacityBox = new JSpinner(spinnerModel);
        JtfCapacityProduct = new JNumberTextField();

        JopGrootteProduct = new JOptionPane();
        JcbAlgoritmeLijst = new JComboBox(AlgoritmeNamen);

        JpTitel = new JPanel();
        JpAlgoritme = new JPanel();
        JpProduct = new JPanel();
        JlProductenLijst = new JList<Product>(productList);
        TpDrawProduct = new TekenPanel();

        JpAlgoritme.setLayout(new GridLayout(8, 1));
        JpProduct.setLayout(new FlowLayout());

        JpTitel.setPreferredSize(new Dimension(1500, 100));
        JpAlgoritme.setPreferredSize(new Dimension(300, 600));
        JpProduct.setPreferredSize(new Dimension(300, 600));
        TpDrawProduct.setPreferredSize(new Dimension(900, 600));
        TpDrawProduct.setBackground(Color.white);

        // alle knoppen
        JbBestand = new JButton("Bestand");
        JbToevoegen = new JButton("Toevoegen");
        JbSimuleer = new JButton("Simuleer");
        JbOk = new JButton("OK");
        JbOverzicht = new JButton("Overzicht");
        JbReset = new JButton("Reset");

        // alle JLabels
        Jlbltitle = new JLabel("BPP - Simulator");
        JlblselecterenAlgoritme = new JLabel("Selecteren AlgoritmeNamen");
        JlblproductenTitel = new JLabel("Producten");
        Jlbldoos = new JLabel("Doos");
        JlblvoegProductToe = new JLabel("Voeg product toe");
        JlblinvoerenOrder = new JLabel("Invoeren order");
        JlblproductGrootte = new JLabel("product grootte:");
        JlbldoosCapaciteit = new JLabel("Doos Capaciteit:");

        Jlbltitle.setFont(new Font("Serif", Font.PLAIN, 30));
        JlblselecterenAlgoritme.setFont(new Font("Serif", Font.PLAIN, 20));
        JlblproductenTitel.setFont(new Font("Serif", Font.PLAIN, 20));
        Jlbldoos.setFont(new Font("Serif", Font.PLAIN, 20));
        JlblvoegProductToe.setFont(new Font("Serif", Font.PLAIN, 20));
        JlblinvoerenOrder.setFont(new Font("Serif", Font.PLAIN, 20));

        JtfCapacityProduct.setSize(20, 5);
        JtfCapacityProduct.setPreferredSize(new Dimension(40, 20));

        JbBestand.addActionListener(this);
        JbToevoegen.addActionListener(this);
        JbSimuleer.addActionListener(this);
        JbOk.addActionListener(this);
        JbOverzicht.addActionListener(this);
        JbReset.addActionListener(this);

        //panels aan GUI toevoegen
        add(JpTitel);           // titel panel toegevoegd aan GUI
        add(JpAlgoritme);       // Algoritme panel toegevoegd aan GUI
        add(JpProduct);         // Product panel toegevoegd aan GUI
        add(TpDrawProduct);     // Teken panel toegevoegd aan GUI


        // Titel panel componenten
        JpTitel.add(Jlbltitle); // Titel Jlabel toegevoegd aan Titel Panel

        // Algoritme panel componenten
        JpAlgoritme.add(JlblselecterenAlgoritme);   // Algoritme selecteren Jlabel toegevoegd aan Algoritme Panel
        JpAlgoritme.add(JcbAlgoritmeLijst);         // Algoritme lijst Jcombobox  toegevoegd aan Algoritme Panel
        JpAlgoritme.add(Jlbldoos);                  // Doos Jlabel toegevoegd aan Algoritme Panel
        JpAlgoritme.add(JlbldoosCapaciteit);        // Doos capaciteit Jlabel toegevoegd aan Algoritme Panel
        JpAlgoritme.add(JspCapacityBox);            // Capaciteit doos Jspinner toegevoegd aan Algoritme Panel
        JpAlgoritme.add(JbOk);                      // Ok Jbutton toegevoegd aan Algoritme Panel
      //  JpAlgoritme.add(JlblinvoerenOrder);         // Invoeren order Jlabel toegevoegd aan Algoritme Panel
       // JpAlgoritme.add(JbBestand);                 // Bestand Jbutton toegevoegd aan Algoritme Panel

        // Product panel componenten
        JpProduct.add(JlblproductenTitel);                  // Producten titel Jlabel toegevoegd aan Product Panel
        JpProduct.add(new JScrollPane(JlProductenLijst));   // Producten lijst scrollpane toegevoegd aan Product Panel
        JpProduct.add(JlblvoegProductToe);                  // Voeg product toe Jlabel toegevoegd aan Product Panel
        JpProduct.add(JlblproductGrootte);                  // Product grootte Jlabel toegevoegd aan Product Panel
        JpProduct.add(JtfCapacityProduct);                  // Capaciteit product Jtextfield toegevoegd aan Product Panel
        JpProduct.add(JbToevoegen);                         // Toevoegen knop toegevoegd aan Product Panel
        JpProduct.add(JbSimuleer);                          // Simuleer knop toegevoegd aan Product Panel
        JpProduct.add(JbReset);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == JbOk) {                          // knop om invoer product te bevestigen
            String selectedAlgorithm = (String) JcbAlgoritmeLijst.getSelectedItem();
            value = Integer.parseInt(JspCapacityBox.getValue().toString());    //Ingevoerde waarde
            Box.setCapacity(value);                                         //Zet de capaciteit van de doos
            System.out.println(Box.getCapacity());
            Product[] t = Arrays.stream(productList.toArray()).toArray(Product[]::new);
            List<Product> allProducts = Arrays.asList(t);
            if (selectedAlgorithm == "First Fit") {
                FirstFit firstFit = new FirstFit();
                List<Box> BoxList = firstFit.simulate(value, allProducts); //Runt Firstfit algoritme
                TpDrawProduct.setBoxes(BoxList);
                TpDrawProduct.repaint();
            } else if (selectedAlgorithm == "First Fit Decreasing") {
                FirstFitDecreasing firstFitDecreasing = new FirstFitDecreasing();
                List<Box> BoxList = firstFitDecreasing.simulate(value,allProducts);
                TpDrawProduct.setBoxes(BoxList);
                TpDrawProduct.repaint();
            } else if (selectedAlgorithm == "Best Pick Fit") {
                BestPickFit bestPickFit = new BestPickFit();
                List<Box> BoxList = bestPickFit.simulate(value,allProducts);
                TpDrawProduct.setBoxes(BoxList);
                TpDrawProduct.repaint();
            } else if (selectedAlgorithm == "Best Fit") {
                BestFit bestFit  = new BestFit();
                List<Box> BoxList = bestFit.simulate(value,allProducts);
                TpDrawProduct.setBoxes(BoxList);
                TpDrawProduct.repaint();
            }//Refreshed de GUI
        } else if (e.getSource() == JbBestand) {                        // knop om bestanden te uploaden
            final JFileChooser fc = new JFileChooser();                     // een filefinder voor de JSON product
            fc.setCurrentDirectory(new java.io.File("."));
            int returnVal = fc.showOpenDialog(this);
            if (returnVal != JFileChooser.APPROVE_OPTION) {
                return;
            }
            File f = fc.getSelectedFile();
        } else if (e.getSource() == JbToevoegen) {                     // knop om producten toe te voegen
            TpDrawProduct.set_SizeProduct(JtfCapacityProduct.getNumber());
            if (JtfCapacityProduct.getNumber() <= Box.getCapacity() && JtfCapacityProduct.getNumber() >= 1) { // product grootte vergelijken met doos grootte
                Product product = new Product(JtfCapacityProduct.getNumber());
                productList.addElement(product);
              //  System.out.println(productList.size());
            } else if (JtfCapacityProduct.getNumber() > Box.getCapacity()) {
                JopGrootteProduct.showMessageDialog(JbToevoegen, "Product te groot");

            } else if (JtfCapacityProduct.getNumber() < 1) {
                JopGrootteProduct.showMessageDialog(JbToevoegen, "Product te klein");
            }
        } else if (e.getSource() == JbSimuleer) {                      //Simuleerknop
            String selectedAlgorithm = (String) JcbAlgoritmeLijst.getSelectedItem();

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {

                    TpDrawProduct.add(JbOverzicht);
                    TpDrawProduct.validate();
                    TpDrawProduct.repaint();
                }
            });
            Product[] t = Arrays.stream(productList.toArray()).toArray(Product[]::new);
            List<Product> allProducts = Arrays.asList(t);
            if (selectedAlgorithm == "First Fit") {
                FirstFit firstFit = new FirstFit();
                List<Box> BoxList = firstFit.simulate(value, allProducts); //Runt Firstfit algoritme
                TpDrawProduct.setBoxes(BoxList);
                TpDrawProduct.repaint();
            } else if (selectedAlgorithm == "First Fit Decreasing") {
                FirstFitDecreasing firstFitDecreasing = new FirstFitDecreasing();
                List<Box> BoxList = firstFitDecreasing.simulate(value,allProducts);
                TpDrawProduct.setBoxes(BoxList);
                TpDrawProduct.repaint();
            } else if (selectedAlgorithm == "Best Pick Fit") {
                BestPickFit bestPickFit = new BestPickFit();
                List<Box> BoxList = bestPickFit.simulate(value,allProducts);
                TpDrawProduct.setBoxes(BoxList);
                TpDrawProduct.repaint();
            } else if (selectedAlgorithm == "Best Fit") {
                BestFit bestFit  = new BestFit();
                List<Box> BoxList = bestFit.simulate(value,allProducts);
                TpDrawProduct.setBoxes(BoxList);
                TpDrawProduct.repaint();
            }
            repaint();
        }else if (e.getSource() == JbOverzicht) {
            Product[] t = Arrays.stream(productList.toArray()).toArray(Product[]::new);
            List<Product> allProducts = Arrays.asList(t);
            GuiOverzicht gO = new GuiOverzicht(value, allProducts);
        }else if (e.getSource() == JbReset) {
            productList.clear();
            Graphics g = TpDrawProduct.getGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0,0,900,600);
          //  TpDrawProduct.getGraphics().setColor(Color.BLACK);

        }
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
