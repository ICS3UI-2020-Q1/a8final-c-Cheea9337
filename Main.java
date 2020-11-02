import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel firstLabel;
  JLabel secondLabel;

  JTextField firstInput;
  JTextField counter;

  JButton increaseButton;
  JButton resetButton;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
  // initialize the main JPanel
  mainPanel = new JPanel();
  // disable any layout helpers
  mainPanel.setLayout(null);

  // create the labels
  firstLabel = new JLabel("Increase by: ");
  secondLabel = new JLabel("Counter: ");

  // give the labels their coordinate and size
  firstLabel.setBounds(50, 200, 100, 50);
  secondLabel.setBounds(50, 300, 100, 50);

  // initialize the input text fields
  firstInput = new JTextField("0");
  counter = new JTextField("0");

  // set the location and size 
  firstInput.setBounds(160, 200, 200, 50);
  counter.setBounds(160, 300, 200, 50);

  // disable the counter box so the user cannot type in it
  counter.setEnabled(false);

  // initilaize the buttons
  increaseButton = new JButton("Increase");
  resetButton = new JButton("Reset");

  // add an action listener to the buttons
  increaseButton.addActionListener(this);
  resetButton.addActionListener(this);

  // set the action command to the buttons 
  increaseButton.setActionCommand("increase");
  resetButton.setActionCommand("reset");

  // set the location and size 
  increaseButton.setBounds(50, 100, 200, 50);
  resetButton.setBounds(300, 100, 200, 50);

  // add the labels to the main panel 
  mainPanel.add(firstLabel);
  mainPanel.add(secondLabel);

  // add the text fields to the main panel 
  mainPanel.add(firstInput);
  mainPanel.add(counter);

  // add the buttons to the main panel 
  mainPanel.add(increaseButton);
  mainPanel.add(resetButton);

  // add the main panel to the frame
  frame.add(mainPanel);
    
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if(command.equals("increase")){
      // get the numbers from the text boxes
      String firstText = firstInput.getText();
      String secondText = counter.getText();

      // change the string into an integer
      int firstNumber = Integer.parseInt(firstText);
      int secondNumber = Integer.parseInt(secondText);

      if(secondNumber <= 9){

      // add the number to the count 
      int result = secondNumber + firstNumber;

      // change the counter to the increased number 
      counter.setText("" + result);
    }
    }

    if(command.equals("reset")){
      counter.setText("" + 0);
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
