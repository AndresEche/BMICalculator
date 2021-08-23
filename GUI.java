import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GUI{


    public GUI() {
        JFrame bmi = new JFrame("BMI Calculator");
        bmi.setLayout(null);

        JLabel title = new JLabel("Andres' BMI Calculator");
        title.setBounds(90,10,150,30);
        bmi.add(title);

        JLabel height = new JLabel("Height (Inches): ");
        JTextField heightText = new JTextField();
        height.setBounds(50,50,120,30);
        heightText.setBounds(170,50,100,30);
        bmi.add(height);
        bmi.add(heightText);

        JLabel weight = new JLabel("Weight (Pounds): ");
        JTextField weightText = new JTextField();
        weight.setBounds(50,80,120,30);
        weightText.setBounds(170,80,100,30);
        bmi.add(weight);
        bmi.add(weightText);

        JButton calc = new JButton("Calculate");
        JLabel show = new JLabel();
        calc.setBounds(50, 110, 100, 30);
        show.setBounds(170, 110, 200, 30);
        bmi.add(calc);
        bmi.add(show);

        JLabel error = new JLabel();
        error.setBounds(50, 140, 130, 30);
        bmi.add(error);

        JLabel health = new JLabel();
        health.setBounds(170, 125, 150, 30);
        bmi.add(health);

        bmi.setVisible(true);
        bmi.setSize(350,250);


        calc.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                double m, kg, result= 0;
                    try {
                        m = Double.parseDouble(heightText.getText()) * 0.0254;
                        kg = Double.parseDouble(weightText.getText()) * 0.453592;
                        result = kg / (Math.pow(m,2));
                        show.setText("BMI: " + String.format("%.1f", result));

                        if (result < 18.5) health.setText("(Underweight)");
                        else if(result >= 18.5 && result < 25) health.setText("(Normal Weight)");
                        else if (result >= 25 && result < 30) health.setText("(Overweight)");
                        else health.setText("(Obese)");

                        error.setText("");

                    } catch(Exception ex) {
                        error.setText("Error, Invalid Input!");
                        show.setText("");
                        health.setText("");
                    }

            }
        });

        bmi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



}
