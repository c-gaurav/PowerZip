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

  
	
	
class newModel extends DefaultListModel
{
	public newModel(File[] f) 
	{
    		for(int i= 0; i< f.length; i++)
        	{
          		if(f[i].isDirectory())
          		{
            			addElement(new Object[] {f[i].getName(),new ImageIcon("dir.gif")});
          		}
          		else
          		{
            			addElement(new Object[] {f[i].getName(),new ImageIcon("fil.gif")});
          		}
        	}
    	}
}