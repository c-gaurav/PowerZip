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

class filter1 extends javax.swing.filechooser.FileFilter 
{
	public boolean accept(File fileobj) 
   	{
       		String extension = "";
       		if(fileobj.getPath().lastIndexOf('.') > 0)
         	extension = fileobj.getPath().substring(fileobj.getPath().lastIndexOf('.')+ 1).toLowerCase();
       		if(extension != "")
           		return extension.equals("zip");
       		else
       	    		return fileobj.isDirectory();
   	}

	public String getDescription()
   	{	
	    	return "ZIP Files (*.zip)";
   	}
}
