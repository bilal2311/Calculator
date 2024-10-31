import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame jFrame;
    JTextField jTextField;

    JButton[] numberButton=new JButton[10];
    JButton[] functionButton=new JButton[9];

    JButton addButton, subButton, mulButton ,divButton,decButton,eqlButton,delButton,clrButton,negButton;
    JPanel jPanel;

    Font myFont =new Font("Ink Free",Font.BOLD,30);
    double num1=0,num2=0,result=0;
    char operator;

    public Calculator() {

        jFrame=new JFrame("Calculator");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(420,550);
        jFrame.setLayout(null);
        jTextField=new JTextField();
        jTextField.setBounds(50,25,300,50);
        jTextField.setFont(myFont);
        jTextField.setEditable(false);

        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        eqlButton=new JButton("=");
        delButton=new JButton("Delete");
        clrButton=new JButton("Clear");
        negButton   =new JButton("(-)");

        //filling the array

        functionButton[0]=addButton;
        functionButton[1]=subButton;
        functionButton[2]=mulButton;
        functionButton[3]=divButton;
        functionButton[4]=decButton;
        functionButton[5]=eqlButton;
        functionButton[6]=delButton;
        functionButton[7]=clrButton;
        functionButton[8]=negButton;

        for(int i=0 ;i<9;i++){
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setFocusable(false);
        }

        for(int i=0 ;i<10;i++){
            numberButton[i]=new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(myFont);
            numberButton[i].setFocusable(false);
        }
        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        jPanel=new JPanel();
        jPanel.setBounds(50,100,300,300);
        jPanel.setLayout(new GridLayout(4,4,10,10));
        //jPanel.setBackground(Color.GRAY);
        jPanel.add(numberButton[1]);
        jPanel.add(numberButton[2]);
        jPanel.add(numberButton[3]);
        jPanel.add(addButton);

        jPanel.add(numberButton[4]);
        jPanel.add(numberButton[5]);
        jPanel.add(numberButton[6]);
        jPanel.add(subButton);

        jPanel.add(numberButton[7]);
        jPanel.add(numberButton[8]);
        jPanel.add(numberButton[9]);
        jPanel.add(mulButton);
        jPanel.add(decButton);
        jPanel.add(numberButton[0]);
        jPanel.add(eqlButton);
        jPanel.add(divButton);
        jPanel.add(negButton);

        jFrame.add(jPanel);
        jFrame.add(negButton);
        jFrame.add(delButton);
        jFrame.add(clrButton);
        jFrame.add(jTextField);
        jFrame.setVisible(true);
    }

    public static void main(String args[]){
        Calculator calculator=new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i=0;i<10;i++){
            if(e.getSource()==numberButton[i]){
                jTextField.setText(jTextField.getText().concat(String.valueOf(i)));

            }
        }
        if(e.getSource()==decButton){
            jTextField.setText(jTextField.getText().concat(String.valueOf(".")));
        }
        if(e.getSource()==addButton){
           num1=Double.parseDouble(jTextField.getText());
           operator='+';
           jTextField.setText("");
        }
        if(e.getSource()==subButton){
            num1=Double.parseDouble(jTextField.getText());
            operator='-';
            jTextField.setText("");
        }
        if(e.getSource()==mulButton){
            num1=Double.parseDouble(jTextField.getText());
            operator='*';
            jTextField.setText("");
        }
        if(e.getSource()==divButton){
            num1=Double.parseDouble(jTextField.getText());
            operator='/';
            jTextField.setText("");
        }
        if(e.getSource()==eqlButton){
            num2=Double.parseDouble(jTextField.getText());
            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            }
            jTextField.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource()==clrButton){
            jTextField.setText("");
        }
        if(e.getSource()==delButton){
           String s=jTextField.getText();
           jTextField.setText("");
           for(int i=0;i<s.length()-1;i++){
               jTextField.setText(jTextField.getText()+s.charAt(i));
            }
        }
        if(e.getSource()==negButton){
            double temp =Double.parseDouble(jTextField.getText());
            temp *=-1;
            jTextField.setText(String.valueOf(temp));
        }

    }
}
