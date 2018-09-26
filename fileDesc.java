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



class fileDesc extends javax.swing.JFrame
{
     	JLabel la1,la2,la3,la4,la5;
     	JCheckBox c1,c2,c3;
     	JPanel p1,p2,p3,p4;
     	JButton b;
     	File fn;
     	String name,loc;
     	long size;
     	long modify;

    fileDesc(String s)
    {
        super((new StringBuilder()).append("NSNZipper - File Description (").append(s).append(")").toString());
        fn = new File(s);
        name = fn.getName();
        loc = fn.getParent();
        size = fn.length();
        modify = fn.lastModified();
        la1 = new JLabel((new StringBuilder()).append("    Name       : ").append(name).toString());
        la2 = new JLabel((new StringBuilder()).append("    Location  : ").append(loc).toString());
        la3 = new JLabel((new StringBuilder()).append("    Size          : ").append(formatt(String.valueOf(size))).append(" bytes").toString());
        la4 = new JLabel((new StringBuilder()).append("    Modified  : ").append(timeStr(modify)).toString());
        la5 = new JLabel("    Attributes:");
        c1 = new JCheckBox("Read Only");
        c2 = new JCheckBox("Hidden");
        c3 = new JCheckBox("Normal");
        if(!fn.canWrite())
        {
            c1.setSelected(true);
            if(fn.isHidden())
                c2.setSelected(true);
            else
                c3.setSelected(true);
        } else
        {
            c3.setSelected(true);
        }
        b = new JButton("OK");
     //   b.addActionListener(new  Object()     /* anonymous class not found */
//    class _anm1 {}

//);
        p2 = new JPanel(new GridLayout(1, 3));
        p2.add(c1);
        p2.add(c2);
        p2.add(c3);
        p3 = new JPanel(new FlowLayout());
        p3.add(la5);
        p3.add(p2);
        p4 = new JPanel(new FlowLayout(1));
        p4.add(b);
        p1 = new JPanel(new GridLayout(6, 1));
        p1.add(la1);
        p1.add(la2);
        p1.add(la3);
        p1.add(la4);
        p1.add(p3);
        p1.add(p4);
        getContentPane().add(p1);
    }	  
     	public String formatt(String k)
     	{
       		StringBuffer sbk=new StringBuffer(k); 
       		int len=sbk.length();
       		len=len-3;
       		while (len>0)
       		{
         		sbk.insert(len,',');
         		len=len-3;
       		}
       		return new String(sbk);
     	}    

     	public String timeStr(long time)
     	{
      		Date d = new Date(time);
      		String apm; 
      		int year = d.getYear() + 1900;
      		int month= d.getMonth()+1;
      		int day=d.getDate();
      		int hr=d.getHours();
      		int min=d.getMinutes();
      		int sec=d.getSeconds();
      		if(hr>12)
      			apm=" PM";
      		else
      			apm=" AM";  
      		String st=String.valueOf(day)+"/"+String.valueOf(month)+"/"+String.valueOf(year)+" "+String.valueOf(hr)+":"+String.valueOf(min)+":"+String.valueOf(sec)+apm;
      		return st;
     	}

	
} //end of class fileDesc
   
