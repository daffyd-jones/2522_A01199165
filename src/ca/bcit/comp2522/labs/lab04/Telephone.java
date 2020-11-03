package ca.bcit.comp2522.labs.lab04;

import javax.swing.*;

public class Telephone {

  public static void main(final String[] args) {

    JFrame frame = new JFrame("Telephone");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new TelephonePanel());
    frame.pack();
    frame.setVisible(true);
  }

}
