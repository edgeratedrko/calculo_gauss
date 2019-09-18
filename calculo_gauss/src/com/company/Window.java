package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window extends JFrame {
     Integer[] options = {1,2,3,4,5,6,7,8,9,10};


    public Window() {
        setWindow();
        setElements();
    }

    public void setWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,800);
        setLayout(null);
        setVisible(true);
    }

    public void setElements() {
        JLabel select;
        select = new JLabel("Selecione o número de equações:");
        select.setBounds(175,100,300,50);
        select.setFont(new Font("Arial", Font.PLAIN, 20));
        add(select);
        select.setVisible(true);

        //JComboBox com opções
        JComboBox<Integer> c1_opt;
        c1_opt = new JComboBox<Integer>(options);
        c1_opt.setBounds(175, 150,50,30);
        add(c1_opt);
        c1_opt.setVisible(false);
        c1_opt.setVisible(true);

        c1_opt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                if(c1_opt.getSelectedItem().equals(2)) {
                    System.out.println("Oi");
                }
            }
        });
    }

}
