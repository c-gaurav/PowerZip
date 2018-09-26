import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class about extends javax.swing.JFrame
{
 	JLabel la1,la2,la3,la4,la5;
     	JTextArea ta;
     	JScrollPane sp;
     	JPanel p1,p2,p3,p4,p5;
     	JButton b;
     	JLabel img;
        about()
        {
	       	super("About PowerZip 1.0");
    	        la1=new JLabel("  Name       : PowerZip(Zip tool in Java)");
		la2=new JLabel("  Version  : 1.0");
       		la3=new JLabel("  Developed by : 	Gaurav");
       		la4=new JLabel("                            PIET, Panipat");
       		la5=new JLabel("                          batch 2016-2020 ");
       		img=new JLabel(new ImageIcon("images1/about.jpg"));
       		ta=new JTextArea(5,30);       
       		ta.setText(" This software is licensed as free software to \n"+ 
                			  "  use and distribution,\n");
       		sp=new JScrollPane(ta);
       		b=new JButton("OK"); 
       		b.addActionListener(new ActionListener()
       		{
         			public void actionPerformed(ActionEvent ae)
          			{
		             		dispose();
          			}
       		});  
	        p2=new JPanel(new GridLayout(5,1));
       		p2.add(la1);
       		p2.add(la2);
       		p2.add(la3);
       		p2.add(la4);
       		p2.add(la5);
                p4=new JPanel(new FlowLayout(FlowLayout.CENTER));
	        p4.add(b);
                p5=new JPanel(new GridLayout(1,2));
       		p5.add(img);
       		p5.add(p2);
       
        
       		p3=new JPanel(new GridLayout(2,1));
       		p3.add(p5);
       		p3.add(sp); 
                p1=new JPanel(new BorderLayout());
       		p1.add(p4,BorderLayout.SOUTH);
       		//p1.add(img,BorderLayout.WEST);
       		p1.add(p3,BorderLayout.CENTER);
       		//p1.add(p3,BorderLayout.CENTER);
                getContentPane().add(p1);
         }
	public static void main(String s[])
	{
		about ab=new about();
		ab.show();
	}
} 

