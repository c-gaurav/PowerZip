import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.zip.*;
import java.util.zip.ZipEntry.*;
import java.io.IOException;
import java.io.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.util.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.*;
import java.util.*;
import java.text.*;
class Find extends JFrame
	{
		JButton FindButton;
		JLabel l1;
		JTextField tf1;
		JTable tm;
		Find(JTable tl)
		{
			super("Find...");
			tm=tl;	
			Container cp= getContentPane();
			l1= new JLabel("Enter text...");
			tf1= new JTextField(10);
			FindButton= new JButton("Find");
			FindButton.addActionListener(new ActionListener()
      			{
	        		public void actionPerformed(ActionEvent e)
    	    			{
    	    				String s=tf1.getText();
    		    			int k=0;
    	    				int j[]=null;
    	    				if(s==null)
    	    				{
		    	       			JOptionPane.showMessageDialog((Container)null,"Enter text please...","PowerZip1.0",JOptionPane.OK_OPTION);
        	   			}
        		   		for(int i=0; i<tm.getRowCount(); i++)
        		   		{
        	   				String ts= (String)tm.getValueAt(i,0);
        	   			
        	   				if(ts.contains(s))
        	   				{
        	   					tm.addRowSelectionInterval(i,i);
        	   					System.out.println(s+ "  "+ ts + "  "+ "true"+ i);
        	   			
        	   				}
					}
	 	   		}
    	    	});
    	    	JPanel p3= new JPanel();
         	p3.add(l1);
  		p3.add(tf1);
  		p3.add(FindButton);
  		cp.add(p3);
  	}
}

