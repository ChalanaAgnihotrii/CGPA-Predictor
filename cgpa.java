import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class CGPAPredictor extends JFrame 
{
    // Declare variables for user interface components
    private JLabel label1, label2, label3, label4, label5;
    private JTextField field1, field2, field3, field4, field5;
    private JButton calculateButton, resetButton;
    private JPanel panel1, panel2;
    
    CGPAPredictor() {
        // Set up user interface components
        label1 = new JLabel("Enter your marks of CSE310 (out of 100):");
        label2 = new JLabel("Enter your marks of CSE316 (out of 100):");
        label3 = new JLabel("Enter your marks of INT404 (out of 100):");
        label4 = new JLabel("Enter your marks of CSD203 (out of 100):");
        label5 = new JLabel("Enter your marks of CSD204 (out of 100):");
        
        Font f = new Font("Arial",Font.PLAIN,40);
        label1.setFont(f);
        label2.setFont(f);
        label3.setFont(f);
        label4.setFont(f);
        label5.setFont(f);

        field1 = new JTextField(5);
        field2 = new JTextField(5);
        field3 = new JTextField(5);
        field4 = new JTextField(5);
        field5 = new JTextField(5);

        field1.setFont(f);
        field2.setFont(f);
        field3.setFont(f);
        field4.setFont(f);
        field5.setFont(f);

        calculateButton = new JButton("Calculate CGPA");
        resetButton = new JButton("Reset");
        calculateButton.setFont(new Font("Arial",Font.PLAIN,40));
        calculateButton.setBackground(Color.YELLOW);
        resetButton.setFont(new Font("Arial",Font.PLAIN,40));
        resetButton.setBackground(Color.YELLOW);
        panel1 = new JPanel(new GridLayout(5, 2));
        panel2 = new JPanel(new FlowLayout());
        
        // Add components to panels
        panel1.add(label1);
        panel1.add(field1);
        panel1.add(label2);
        panel1.add(field2);
        panel1.add(label3);
        panel1.add(field3);
        panel1.add(label4);
        panel1.add(field4);
        panel1.add(label5);
        panel1.add(field5); 
        panel2.add(calculateButton);
        panel2.add(resetButton);
        
        // Add panels to frame
        this.add(panel1, BorderLayout.CENTER);
        this.add(panel2, BorderLayout.SOUTH);
        
        // Set up action listeners for buttons
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateCGPA();
            }
        });
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });
        
        // Set up frame
   
        Color c = new Color(0,200,80);  
   
        this.setTitle("CGPA PREDICTOR");
        this.setSize(1500, 800);
        panel1.setBackground(c);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    // Method to calculate CGPA
    private void calculateCGPA() {
        
        try {
             int count = 0;
             // Get marks from text fields and convert to doubles
             double marks1 = Double.parseDouble(field1.getText());
             double marks2 = Double.parseDouble(field2.getText());
             double marks3 = Double.parseDouble(field3.getText());
             double marks4 = Double.parseDouble(field4.getText());
             double marks5 = Double.parseDouble(field5.getText());
      
              // Calculate total marks and CGPA

             if(marks1>100 | marks1<0)
             {
                field1.setText("Out Of Range"); 
                count =4;
             }
             if(marks2>100 | marks1<0)
             {
                field2.setText("Out Of Range"); 
                count =4;
             }
             if(marks3>100 | marks1<0)
             {
                field3.setText("Out Of Range"); 
                count =4;
             }
             if(marks4>100 | marks1<0)
             {
                field4.setText("Out Of Range"); 
                count =4;
             }
             if(marks5>100 | marks1<0)
             {
                field5.setText("Out Of Range"); 
                count =4;
             }
             
             System.out.print("count "+count);
           
             double totalMarks = marks1 + marks2 + marks3 + marks4 + marks5;
             double cgpa = totalMarks / 500 * 10;
        
        
	       if(cgpa<5.0 & count!=4)
             {
		     JOptionPane.showMessageDialog(this, "Your CGPA is " + String.format("%.2f",cgpa)+ " \n Please work hard ");
		 }
             else if(count!=4)
       	 {
       	   JOptionPane.showMessageDialog(this, "Your CGPA is " +  String.format("%.2f",cgpa)+ "\n Hurray you have a good CGPA " );
		 }
             else count = 0;
             System.out.print(count);
         }
   
         catch(Exception ex)
         {
             field1.setText("Invalid Input");
             field2.setText("Invalid Input");
             field3.setText("Invalid Input");
             field4.setText("Invalid Input");
             field5.setText("Invalid Input");
         }
  
    }
    
    // Method to reset text fields
    private void resetFields() {
        field1.setText("");
        field2.setText("");
        field3.setText("");
        field4.setText("");
        field5.setText("");
    }
    
    public static void main(String[] args) {
        new CGPAPredictor();
}
}