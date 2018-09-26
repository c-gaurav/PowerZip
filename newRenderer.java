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

  


class newRenderer extends JLabel implements ListCellRenderer 
{
	public newRenderer() 
    	{
	        setOpaque(true);
    	}
    
    	public Component getListCellRendererComponent(JList jlist, Object obj, int index, boolean isSelected,boolean focus) 
    	{
        	newModel model = (newModel)jlist.getModel();
	
        	setText((String)((Object[])obj)[0]);
        	setIcon((Icon)((Object[])obj)[1]);
        	if(!isSelected) 
        	{
	            	setBackground(jlist.getBackground());
            		setForeground(jlist.getForeground());
        	}
        	else 
        	{
            		setBackground(jlist.getSelectionBackground());
            		setForeground(jlist.getSelectionForeground());
        	}

    	        return this;
    	}
}