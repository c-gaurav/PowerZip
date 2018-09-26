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
import java.net.URL;
public class help extends javax.swing.JFrame
{
    	JEditorPane ep;
    	JScrollPane sp;
    	JButton b; 
    	URL urls[],temp[];
    	JPanel p;
    	help()
     	{
      		super("Help -PowerZip");
      		ep=new JEditorPane();
      		ep.setEditable(false);
		ep.addHyperlinkListener(new HyperlinkListener()
      		{
      			public void hyperlinkUpdate(HyperlinkEvent he)
      			{
        			if(he.getEventType()==HyperlinkEvent.EventType.ACTIVATED)
        			{
          					try
          					{
          						openpage(he.getURL());
          					}
          					catch(Exception e){} 
        			}
        		}
		});
      		sp=new JScrollPane(ep,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
      		b=new JButton("OK");
      		b.addActionListener(new ActionListener()
       		{
          			public void actionPerformed(ActionEvent ae)
          			{
             				setVisible(false);
          			}
       		});
      		p=new JPanel(new FlowLayout());
      		p.add(b);
      		getContentPane().setLayout(new BorderLayout());
      		getContentPane().add(p,BorderLayout.SOUTH);
      		getContentPane().add(sp,BorderLayout.CENTER);
      		String url1 = "file:" + System.getProperty("user.dir") +System.getProperty("file.separator") +"help.html";
      		try
      		{ 
      			ep.setPage(url1);
      		}
      		catch(Exception e)
      		{
      			
      		}
    	}  
	public void openpage(URL url)
    	{
     		try
     		{
       			ep.setPage(url);
     		}
     		catch(IOException ex2)
     		{
     			JOptionPane.showMessageDialog((Container)null,"Unable to locate the help file!!","PowerZip 1.0",JOptionPane.OK_OPTION);         
     		}
    	}
}
	
