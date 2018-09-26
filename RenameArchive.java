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
import java.net.*;
import java.awt.datatransfer.*;
import java.util.Vector;	



class RenameArchive extends javax.swing.JFrame 
{
		JButton selectButton, renameButton, cancelButton;
  		JLabel l1,l2,l3;
  		JTextField tf1,tf2;
  		String s1,s2;
  		JPanel p5;
		
		RenameArchive()
		{
			super("Rename Archive...");
			Container c=getContentPane();
			l1= new JLabel("Rename Archive...");
  			l2= new JLabel("Enter new name");
  			l3= new JLabel("Waiting...");
  			tf1=new JTextField(20);
  			tf2=new JTextField(20);
  			
  			selectButton= new JButton("Select File to rename");
  			renameButton= new JButton("Rename");
  			cancelButton= new JButton("Cancel");
  			
  			selectButton.addActionListener(new ActionListener()
	      		{
		        	public void actionPerformed(ActionEvent e)
    	    			{
        	   			JFileChooser fc=new JFileChooser();
	        	   		fc.addChoosableFileFilter(new filter1());
           				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);	
           				int res=fc.showDialog(null,null);	
	           			if (res==JFileChooser.APPROVE_OPTION)
        	   			{
			           		File f=fc.getSelectedFile();
    	         				String l1=f.getPath();
		        	     		s1=l1.replace('\\','/');
		            	 		tf1.setText(s1);
		             		
           				}
        			}  
	      		});
      		
      			renameButton.addActionListener(new ActionListener()
      			{
      				public void actionPerformed(ActionEvent e)
      				{
      					File fo= new File(s1);
      					s2=tf2.getText();
      					rename(fo, s2);	
      					l3.setText("Done...");
      				}
      			});
      		
      			cancelButton.addActionListener(new ActionListener()
  			{
  				public void actionPerformed(ActionEvent e)
  				{
  					dispose();	
  				}	
  			});
      			p5= new JPanel();
      			p5.add(l1);
      			p5.add(tf1);
      			p5.add(selectButton);
      			p5.add(l2);
      			p5.add(tf2);
      			p5.add(renameButton);
      			p5.add(cancelButton);
      			p5.add(l3);
      			c.add(p5);
  			
		}
    		public void rename(File oldFile, String newName)
    		{
    			oldFile.renameTo(new File(oldFile.getParent() + "/" + newName));
    		}
    	
}
  