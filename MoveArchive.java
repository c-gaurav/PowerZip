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
class MoveArchive extends javax.swing.JFrame
{
	JButton sourceButton, destiButton, copyButton, cancelButton;
	JLabel l1,l3;
	JTextField tf1,tf2;
	String s1,s2;
	MoveArchive()
	{
		super("Move Archive...");
		Container c=getContentPane();
		l1= new JLabel("Move Archive...");
		tf1=new JTextField(40);
		tf2=new JTextField(40);
		l3= new JLabel("Waiting...");
		sourceButton= new JButton("Select File to Copy");
		destiButton= new JButton("Select Destination");
		copyButton= new JButton("Start Move");
		cancelButton=new JButton("Cancel");
		sourceButton.addActionListener(new ActionListener()
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
  			
  		destiButton.addActionListener(new ActionListener()
      		{
        			public void actionPerformed(ActionEvent e)
        			{
           				JFileChooser fc=new JFileChooser();
	           			fc.addChoosableFileFilter(new filter1());
	           			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	           			int res=fc.showDialog(null,null);
	           			if (res==JFileChooser.APPROVE_OPTION)
	           			{
		             			File f=fc.getSelectedFile();
		             			String l2=f.getPath();
		             			s2=l2.replace('\\','/');
		             			tf2.setText(s2);
             				}
        			}  
      		});
      		copyButton.addActionListener(new ActionListener()
      		{
      			public void actionPerformed(ActionEvent e)
        		{
        			File fs= new File(s1);
      				File fd= new File(s2);
      				move(fs, fd);
      			}	
      		});
 		cancelButton.addActionListener(new ActionListener()
  		{
  			public void actionPerformed(ActionEvent e)
  			{
  				dispose();	
  			}
  		});
    		  		
  		JPanel p3= new JPanel();
  		p3.add(l1);
  		p3.add(tf1);
  		p3.add(sourceButton);
  		p3.add(copyButton);
		p3.add(tf2);
  		p3.add(destiButton);
  		p3.add(cancelButton);
  		p3.add(l3);
  		c.add(p3);
  	}
  	public void move(File sourceFile, File targetPath) 
	{
       		try 
        
		{
        	   		sourceFile.renameTo(new File(targetPath.getAbsolutePath() + "/" + sourceFile.getName()));
        	   		l3.setText("Done...");
       		} 
       		catch (Exception e) 
       		{
            			System.out.println(e);
	            		e.printStackTrace();
       		}    	
	}
	public static void main(String a[])
	{
		MoveArchive ma=new MoveArchive();
		ma.setVisible(true);
	}
}

