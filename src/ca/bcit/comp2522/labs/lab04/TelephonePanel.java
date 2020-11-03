package ca.bcit.comp2522.labs.lab04;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelephonePanel extends JPanel {

  /**
   * TelephonePanel Const.
   * Builds and assembles a telephone panel
   */
  public TelephonePanel() {
    //set border for this panel
    BorderLayout layout = new BorderLayout();
    final int gap = 10;
    layout.setHgap(gap);
    layout.setVgap(gap);
    //
    //create JLabel with "Your Telephone" title
    JLabel telLabel = new JLabel("Your Telephone");
    JPanel titPan = new JPanel();
    titPan.add(telLabel);
    //
    //add title with label to north of this panel
    this.add(titPan, BorderLayout.NORTH);
    //
    //create panel to hold keypad and give it 4x3 GridLayout
    JPanel numPan = new JPanel();
    GridLayout grid = new GridLayout(4, 3);
    numPan.setLayout(grid);
    //
    //add buttons representing keys to key panel
    MyButtonListener listen = new MyButtonListener();

    JButton buttonOne = new JButton("1");
    numPan.add(buttonOne);
    buttonOne.addActionListener(listen);
    //
    JButton buttonTwo = new JButton("2");
    numPan.add(buttonTwo);
    buttonTwo.addActionListener(listen);
    //
    JButton buttonThree = new JButton("3");
    numPan.add(buttonThree);
    buttonThree.addActionListener(listen);
    //
    JButton buttonFour = new JButton("4");
    numPan.add(buttonFour);
    buttonFour.addActionListener(listen);
    //
    JButton buttonFive = new JButton("5");
    numPan.add(buttonFive);
    buttonFive.addActionListener(listen);
    //
    JButton buttonSix = new JButton("6");
    numPan.add(buttonSix);
    buttonSix.addActionListener(listen);
    //
    JButton buttonSev = new JButton("7");
    numPan.add(buttonSev);
    buttonSev.addActionListener(listen);
    //
    JButton buttonEight = new JButton("8");
    numPan.add(buttonEight);
    buttonEight.addActionListener(listen);
    //
    JButton buttonNine = new JButton("9");
    numPan.add(buttonNine);
    buttonNine.addActionListener(listen);
    //
    JButton buttonPound = new JButton("#");
    numPan.add(buttonPound);
    buttonPound.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        System.out.println("Button Pressed: #");
      }
    });

    JButton buttonZero = new JButton("0");
    numPan.add(buttonZero);
    buttonZero.addActionListener(listen);

    JButton buttonAst = new JButton("*");
    numPan.add(buttonAst);
    buttonAst.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        System.out.println("Button Pressed: *");
      }
    });

    //
    //add key panel to center of this panel
    this.add(numPan, BorderLayout.SOUTH);
  }

  class MyButtonListener implements ActionListener {

    public void actionPerformed(final ActionEvent e) {
      char butt = e.getActionCommand().charAt(0);

      switch (butt) {
        case '1' -> System.out.println("Button pressed: 1");
        case '2' -> System.out.println("Button pressed: 2");
        case '3' -> System.out.println("Button pressed: 3");
        case '4' -> System.out.println("Button pressed: 4");
        case '5' -> System.out.println("Button pressed: 5");
        case '6' -> System.out.println("Button pressed: 6");
        case '7' -> System.out.println("Button pressed: 7");
        case '8' -> System.out.println("Button pressed: 8");
        case '9' -> System.out.println("Button pressed: 9");
        case '0' -> System.out.println("Button pressed: 0");
        default -> System.out.println("Not an option");
      }




    }
  }






}
