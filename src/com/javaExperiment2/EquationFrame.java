package com.javaExperiment2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class EquationFrame extends JFrame implements ActionListener{
    SquareEquation equation;
    JTextField textA,textB,textC;
    JTextArea showRoots;
    JButton controlButton;
    public EquationFrame(){
        equation=new SquareEquation();
        textA=new JTextField(8);
        textB=new JTextField(8);
        textC=new JTextField(8);
        controlButton =new JButton("确定");
        JPanel pNorth=new JPanel();
        pNorth.add(new JLabel("二次项系数："));
        pNorth.add(textA);
        pNorth.add(new JLabel("一次项系数："));
        pNorth.add(textB);
        pNorth.add(new JLabel("常数项系数："));
        pNorth.add(textC);
        pNorth.add(controlButton);
        controlButton.addActionListener(this);
        getContentPane().add(pNorth,BorderLayout.NORTH);
        showRoots=new JTextArea();
        JScrollPane scrollPane=new JScrollPane(showRoots);
        getContentPane().add(scrollPane,BorderLayout.CENTER);
        setSize(630,160);
        Dimension scnSize=Toolkit.getDefaultToolkit().getDefaultToolkit().getScreenSize();
        Dimension frmSize=this.getSize();
        this.setLocation((scnSize.width-frmSize.width)/2,
                (scnSize.height-frmSize.height)/2);
        validate();
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        try{
            double a=Double.parseDouble(textA.getText());
            double b=Double.parseDouble(textB.getText());
            double c=Double.parseDouble(textC.getText());
            equation.setA(a);
            equation.setB(b);
            equation.setC(c);
            showRoots.append("根: "+equation.getRootOne());
            showRoots.append(" 根："+equation.getRootTwo()+"\n");
        }catch(Exception ex)
        {
            showRoots.append(ex.getMessage()+"\n");
        }
    }
}