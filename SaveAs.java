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



class SaveAs extends javax.swing.JFrame
{
	SaveAs(String newName, File fo, File fn)
	{	
       	
        	String fTemp= fn+ "\\"+ fo.getName();
        	File FTemp= new File(fTemp);
           	if(fo.getParent().equals(FTemp.getParent()))
        	{
        		if(fo.getName().equals(newName))
        		{
        			int respi=JOptionPane.showConfirmDialog(null,"File Already Exists...OverWrite it","NSNZipper 1.0",JOptionPane.YES_NO_OPTION);
       				if (respi==JOptionPane.YES_OPTION) 
       				{
	       				
    		   		}
	       			if (respi==JOptionPane.NO_OPTION)
       				{
       				}	
    	    		}
    	    		else
    	    		{
    	    			File fileTemp= new File("data/");
    	    			copy(fo, fileTemp);
    	    			fileTemp= new File("data/"+fo.getName());
    	    			File FParent= fo.getParentFile();
    	    			rename(fileTemp, newName);   	    		
    	    			fileTemp= new File("data/"+ newName);
    	    			move(fileTemp, FParent);   	    		
    	    		}
    	        }
                else
                {
                	copy(fo, fn);
	        	rename(FTemp, newName);
                }
        	
       	}
		
			
	public void copy(File sourceFile, File targetPath) 
	{    
	    	try 
    		{
          		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile), 4096);
	            	File targetFile = new File(targetPath.getAbsolutePath() + "/" + sourceFile.getName());
    	        	BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFile), 4096);
                	int theChar;
           	    	while ((theChar = bis.read()) != -1) 
           	    	{
                   		bos.write(theChar);
               		}
               		bos.close();
               		bis.close();
          	
        	} 
        	catch (Exception e) 
        	{
           		System.out.println(e);
           		e.printStackTrace();
        	}
        }
        
        public void rename(File oldFile, String newName)
    	{
    		oldFile.renameTo(new File(oldFile.getParent() + "/" + newName));
    	}
    	
    	public void move(File sourceFile, File targetPath) 
	{
       		try 
       		{
       	   		sourceFile.renameTo(new File(targetPath.getAbsolutePath() + "/" + sourceFile.getName()));
       		} 
      		catch (Exception e) 
       		{
           		System.out.println(e);
           		e.printStackTrace();
       		}
    	}
}