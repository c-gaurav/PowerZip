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
class DeleteArchive extends javax.swing.JFrame
{
	JButton selectButton, deleteButton, cancelButton;
	JLabel l1,l3;
  	JTextField tf1;
  	String s1;
 	JPanel p4;
  	DeleteArchive()
	{
		super("Delete Archive...");				
		Container c=getContentPane();
	
 		l1= new JLabel("Delete Archive...");
 		l3= new JLabel("Waiting...");
		tf1=new JTextField(40);
		deleteButton= new JButton("Delete");
		cancelButton=new JButton("Cancel");
		selectButton=new JButton("Select file to delete");
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
      		
      		cancelButton.addActionListener(new ActionListener()
  		{
  			public void actionPerformed(ActionEvent e)
  			{
  				dispose();	
  			}	
  		});
      		deleteButton.addActionListener(new ActionListener()
      		{
      			public void actionPerformed(ActionEvent e)
      			{
      				File fdel= new File(s1);
      				delete(fdel);
      				      				
      			}
      		});
      		
      		p4= new JPanel();
  		p4.add(l1);
  		p4.add(tf1);
  		p4.add(selectButton);
  		p4.add(deleteButton);
  		p4.add(cancelButton);
  		p4.add(l3);
  		c.add(p4);
	}
  	public void delete(File sourceFile) 
    	{
        		try 
        		{
		            	if (!sourceFile.isDirectory()) 
    	        		{
	        	        	sourceFile.delete();
        		        	l3.setText("Done...");
            			} 
        		} 	
        		catch (Exception e) 
        		{		System.out.println(e);
	    	  			e.printStackTrace();
				 	l3.setText("Error in deletion...");
        		}
	}
	public static void main(String a[])
	{
		DeleteArchive da=new DeleteArchive();
		da.setVisible(true);
	}
}
