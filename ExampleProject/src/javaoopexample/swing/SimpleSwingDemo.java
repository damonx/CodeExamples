package javaoopexample.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SimpleSwingDemo extends JFrame implements ActionListener{
  private JLabel jLabel;
  private JButton jButton;
  private String labelPrefix ="Number of button clicks: ";
  private int numClicks = 0;

  public SimpleSwingDemo(String title){
   super(title);
   
   jLabel = new JLabel(labelPrefix + "0");
   jButton = new JButton("I am a Swing button!");

   // ��������������: ��������Alt-i��������������Button
   jButton.setMnemonic('i');

   //����������������Button������������
   jButton.setToolTipText("Press me");

   jButton.addActionListener(this);

/* //wrong
   setLayout(new GridLayout(2, 1));
   add(jLabel) ;
   add(jButton);
*/
  
   Container contentPane=getContentPane();
   contentPane.setLayout(new GridLayout(2, 1));
   contentPane.add(jLabel) ;
   contentPane.add(jButton);

   pack();
   setVisible(true);

   //����������JFrame����������������������
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void actionPerformed(ActionEvent e) {
    numClicks++;
    jLabel.setText(labelPrefix + numClicks);
  }

  public static void main(String[] args) {
    new SimpleSwingDemo("Hello");
  }
}


/****************************************************
 * ������������                                     *
 * ������<<Java������������>>                       *
 * ��������������www.javathinker.org                *
 ***************************************************/
