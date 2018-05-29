package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
public class GuiOverzicht extends JFrame{
    private TekenPanel JpFirstFit;
    private TekenPanel JpFirstFitDecreasing;
    private TekenPanel JpBestFit;
    private JLabel JlFirstFit;
    private JLabel JlFirstFitDecreasing;
    private JLabel JlBestFit;

    public GuiOverzicht(int value, List<Product> allProducts){
        setTitle("BPP simulator overzicht");
        setSize(2000 , 750);
        setLayout(new FlowLayout());
        setResizable(false);

        JlBestFit = new JLabel("Best Fit");
        JlFirstFit = new JLabel("First Fit");
        JlFirstFitDecreasing = new JLabel("First Fit Decreasing");

        JlBestFit.setFont(new Font("Serif", Font.PLAIN, 30));
        JlFirstFit.setFont(new Font("Serif", Font.PLAIN, 30));
        JlFirstFitDecreasing.setFont(new Font("Serif", Font.PLAIN, 30));

        JpBestFit = new TekenPanel();
        JpFirstFit = new TekenPanel();
        JpFirstFitDecreasing = new TekenPanel();

        JpBestFit.setPreferredSize(new Dimension(630,700));
        JpFirstFit.setPreferredSize(new Dimension(630,700));
        JpFirstFitDecreasing.setPreferredSize(new Dimension(630,700));
        add(JpFirstFit);
        FirstFit firstFit = new FirstFit();
        List<Box> BoxList1 = firstFit.simulate(value, allProducts); //Runt Firstfit algoritme
        JpFirstFit.setBoxes(BoxList1);
        JpFirstFit.repaint();

        add(JpFirstFitDecreasing);
        FirstFitDecreasing firstFitDecreasing = new FirstFitDecreasing();
        List<Box> BoxList2 = firstFitDecreasing.simulate(value,allProducts);
        JpFirstFitDecreasing.setBoxes(BoxList2);
        JpFirstFitDecreasing.repaint();

        add(JpBestFit);
        BestFit bestFit  = new BestFit();
        List<Box> BoxList3 = bestFit.simulate(value,allProducts);
        JpBestFit.setBoxes(BoxList3);
        JpBestFit.repaint();

        JpBestFit.add(JlBestFit);
        JpFirstFit.add(JlFirstFit);
        JpFirstFitDecreasing.add(JlFirstFitDecreasing);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
