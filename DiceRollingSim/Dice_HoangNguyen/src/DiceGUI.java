/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hoang Nguyen
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.Scanner;
import java.awt.Color;


public class DiceGUI extends JFrame{
    
    private Color[] colors = new Color[3];
    private int diceNum = 1;
    Random randn = new Random();
    private int rn;
    private int[] rollNums = new int[6];
    private int total = 0;
    Icon[] rolls = new Icon[6];
    JLabel item1;
    JPanel dpanel = new JPanel();
    JLabel dLabel[] = new JLabel[6];
    JLabel dLabel2;
    JLabel NumLabel;
    JPanel panel;
    private int n;
    
    /**
     * Null Constructor
     * */
    public DiceGUI(){
        super("Default");
        setLayout(new GridLayout());
    
        setSize(1500,1000);
        createMenuBar();        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               

      createButtons();

      
     
      createDiceIconPanel();
     // add(dpanel2);
      //add(dpanel2);
      setVisible(true);
          } 
    
    /**
     * Constructor to take starting number of dice
     * @param startNum The number of starting dice
     * */
    public DiceGUI(int startNum){
        super("Default");
        setLayout(new GridLayout());
    
        setSize(1500,1000);
        createMenuBar();        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createButtons();
        createDiceIconPanel();
          for(int i = 0; i<startNum-1; i++)
        {
           addDiceIconPanel();
        }
      setVisible(true);
        
    }
    
    /**
     * Gets current number of dice
     * @return number of dice currently
     * */
    public int getdiceNum(){
        return diceNum;
    }
    
    /**
     * Sets the number of dice the user wants
     */
    public void setdiceNum(){
        int num = 0;
        //Catches the user if he/she tries to enter non-integers and pops up an error message
        try{num = Integer.parseInt( JOptionPane.showInputDialog(this,"Please enter number of Dice", "1"));}
        catch(java.lang.NumberFormatException e){
            System.err.println("Please enter an integer 1-6 only");
        }
        //Catches the user if he/she tries to enter anything above 6 or below 1
        if(num<=0 || num>6)
        {
        JOptionPane.showMessageDialog(this, "Error, invalid input. Please put an integer between 1 and 6 only");
        }
        //If we need to add dice
        else if(num>diceNum){
            for(int i = diceNum; i<num; i++)
            {
                addDiceIconPanel();
            }
        }
        //If we need to remove dice
        else{
            for(int i = diceNum; i>num; i--)
            {
                removeDiceIconPanel();
            }
        }
    }
    
    /**
     * Creates the initial dice to be used
     * */
    public void createDiceIconPanel(){
        
        //JPanel dpanel = new JPanel();
       
        n = 0;
        //Set rn to a random integer
        rn = randn.nextInt(6);
        //Fills up icon array with pictures of each side of a die
        rolls[0] = new ImageIcon(getClass().getResource("One.png"));
        rolls[1] = new ImageIcon(getClass().getResource("Two.png"));
        rolls[2] = new ImageIcon(getClass().getResource("Three.png"));
        rolls[3] = new ImageIcon(getClass().getResource("Four.png"));
        rolls[4] = new ImageIcon(getClass().getResource("Five.jpg"));
        rolls[5] = new ImageIcon(getClass().getResource("Six.png"));

        //Add first dice to the panel and add panel into the frame
        JLabel dLabel1 = new JLabel();
        dLabel1.setIcon(rolls[rn]);
        dLabel[0] = dLabel1;
        add(dpanel);
        dpanel.add(dLabel[0]);
        }
      
    /**
     * Method to roll the dice on the screen
     */
    public void rollDiceIconPanel(){
        //Generate a new random object
        Random randn2 = new Random();
        //Initialize the rollNums array to all 0's
        int rollNums[] = {0,0,0,0,0,0};
        int rng;
        total = 0;
        //Goes through all the current dice on the screen and sets them to a random new number
        for(int i = 0; i<diceNum; i++)
        {
        rng = randn2.nextInt(6);
        dLabel[i].setIcon(rolls[rng]);
        total += rng+1;
        rollNums[i] = rng+1;
        }
        
    }

    /**
     * Method to add a die to the panel
     */
    public void addDiceIconPanel(){
        //Catches if the user already has 6 dice and keeps track of the number of current dice
        if(diceNum == 6)
        {
         JOptionPane.showMessageDialog(this,"Cannot have more than 6 dice");
        }
        else{
        Random randn3 = new Random();
        int rng = randn3.nextInt(6);
        JLabel dLabeln = new JLabel();
        dLabeln.setIcon(rolls[rng]);
        dLabel[diceNum] = dLabeln;
        dpanel.add(dLabel[diceNum]);
        dpanel.repaint();
        diceNum++;
        }
    }
    /**
     * Removes a die and keeps track of how many are left
     */
    public void removeDiceIconPanel(){
        //Catches the user if he/she only has 1 die left
        if(diceNum==1)
        {
            JOptionPane.showMessageDialog(this, "Cannot have less than 1 die");
        }
        else{
        dpanel.remove(dLabel[diceNum-1]);
        dpanel.repaint();
        diceNum--;
        }
    }
    
    /**
     * Method to create the Menubar
    */
    public void createMenuBar(){
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu SetAndGet = new JMenu("Dice Number");
        JMenu Statistics = new JMenu("Statistics");
        JMenu Background = new JMenu("Background Color");
        JMenuItem roll = new JMenuItem("Roll");
        JMenuItem add = new JMenuItem("Add Dice");
        JMenuItem remove = new JMenuItem("Remove Dice");
        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem getNum = new JMenuItem("Count Number of Dice");
        JMenuItem setNum = new JMenuItem("Set Number of Dice");
        JMenuItem getMean = new JMenuItem("Average");
        JMenuItem getTot = new JMenuItem("Total");
        JMenuItem getSTD = new JMenuItem("Standard Deviation");
        JRadioButtonMenuItem setRed = new JRadioButtonMenuItem("Red");
        JRadioButtonMenuItem setGreen = new JRadioButtonMenuItem("Green");
        JRadioButtonMenuItem setBlue = new JRadioButtonMenuItem("Blue");
        
        exit.addActionListener((ActionEvent event) -> {System.exit(0);});
        roll.addActionListener((ActionEvent event) -> rollDiceIconPanel());
        add.addActionListener((ActionEvent event)-> addDiceIconPanel());
        remove.addActionListener((ActionEvent event)-> removeDiceIconPanel());
        getNum.addActionListener((ActionEvent event)-> JOptionPane.showMessageDialog(this, "You have " + getdiceNum() + " dice"));
        setNum.addActionListener((ActionEvent event)-> setdiceNum());
        getMean.addActionListener((ActionEvent event)-> getAverage(total, diceNum));
        getTot.addActionListener((ActionEvent event)-> JOptionPane.showMessageDialog(this,"Your total is: "+ total));
        getSTD.addActionListener((ActionEvent event)-> StdDev());
        setRed.addActionListener((ActionEvent event) -> setBackground(0));
        setGreen.addActionListener((ActionEvent event) -> setBackground(1));
        setBlue.addActionListener((ActionEvent event) -> setBackground(2));
        
        ButtonGroup BG = new ButtonGroup();
        BG.add(setRed);
        BG.add(setGreen);
        BG.add(setBlue);
        
        file.add(roll);
        file.add(add);
        file.add(remove);
        file.add(exit);
        SetAndGet.add(getNum);
        SetAndGet.add(setNum);
        Statistics.add(getTot);
        Statistics.add(getMean);
        Statistics.add(getSTD);
        Background.add(setRed);
        Background.add(setGreen);
        Background.add(setBlue);
        menubar.add(file);
        menubar.add(SetAndGet);
        menubar.add(Statistics);
        menubar.add(Background);

        setJMenuBar(menubar);
        //return menubar;
    }
    /**
     * Method to create the menu buttons and add functionality
     */
    public void createButtons(){
      JButton addD, rmD, DRoll;
      panel = new JPanel();
      add(panel);
      DRoll = new JButton("Roll!");
      addD = new JButton("Add Dice");
      rmD = new JButton("Remove Dice");
      DRoll.addActionListener((ActionEvent event)-> rollDiceIconPanel());
      addD.addActionListener((ActionEvent event)-> addDiceIconPanel());
      rmD.addActionListener((ActionEvent event)-> removeDiceIconPanel());
      panel.add(rmD);
      panel.add(DRoll);
      panel.add(addD);
    }

    /**
    *Method to get total of all the dice rolls
    * @return the total of the dice rolls
    */
    public int getTotal()
    {
        return total;
    }

    /**
     * Method to get the average of the dice rolls
     * @param i1 the total number of all the dice rolls
     * @param i2 the number of dice currently
     */
    public void getAverage(int i1, int i2)
    {
        double average = (double) i1/i2;
        JOptionPane.showMessageDialog(this, "Your average is: " + average);
        
    }
    
    /**
     * Method to get the average of the dice rolls as an int return type
     * @param i1 the total number of all the dice rolls
     * @param i2 the number of dice currently
     * @return the average of the current dice
     */
    public double average(int i1, int i2)
    {
       double average = (double) i1/i2;
       return average;
    }
    
    /**
     * Method to print out the standard deviation of the rolls in a new window
     */
    public void StdDev()
    {
        double dAvg = average(total, diceNum);
        double std = 0.0;
        for(int i = 0; i<diceNum; i++)
        {
            std += (dAvg-rollNums[i])*(dAvg-rollNums[i]);
        }
        std /= diceNum;
        JOptionPane.showMessageDialog(this, "Your standard deviation is: " + std);
    }
    
    /**
     * Method to set the background color
     * @param iColor Determines which color is to be used based on color array
     */
    public void setBackground(int iColor)
    {
        colors[0] = new Color(255, 0, 0);
        colors[1] = new Color(0, 255, 0);
        colors[2] = new Color(0, 0, 255);
        
        this.getContentPane().setBackground( colors[iColor]);

    }
}

 
