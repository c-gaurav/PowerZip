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
import javax.swing.JOptionPane;

public class NSNZ extends JFrame implements ActionListener
{
 
    class dele extends javax.swing.JFrame
    {	
    	public dele(String old,String newf,String[] file,int srct)
  	{
    		try  
    		{       		
    			BufferedInputStream origin=null;
       			FileOutputStream fos=new FileOutputStream(newf);
       			ZipOutputStream zos=new ZipOutputStream(new BufferedOutputStream(fos));
       			FileInputStream fis=new FileInputStream(old);
       			ZipInputStream zis=new ZipInputStream(new BufferedInputStream(fis));
       			ZipEntry entry,ent;
       			int count;
       			int c;
       			int i=0;
       			String ename;
       			byte[] data=new byte[1024]; 
       			while((entry=zis.getNextEntry())!=null)
       			{
	         		ename=entry.getName();
         			i++;
         			for(c=0;(c<srct)&&(!(ename.equals(file[c])));c++);
         			if(c!=srct)
         			{
	           			i=1; //Null operation(Just for place holding)
         			}
         			else
         			{
	         			ent=new ZipEntry(entry.getName());
         				zos.putNextEntry(ent);
         				while((count=zis.read(data,0,1024))!=-1)
         				{
	           				zos.write(data,0,count);
    	     				}
	         		}	
       			}
         		while(zis.available()==1);
         		zos.closeEntry();
         		zis.closeEntry(); 
         		zis.close();
         		zos.close();
         		fis.close();
         		fos.close();
         		File ol=new File(old);
         		ol.delete();
         		File nx=new File(old);
         		File f=new File(newf);
         		try
         		{
	         		f.renameTo(nx);
    	     		}
         		catch(Exception e)
         		{ 
           			JOptionPane.showMessageDialog((Component)null,"Error operation:"+e.getMessage(),"PowerZip 1.0",JOptionPane.OK_OPTION);
        		}
		}
      		catch(Exception e)
       		{
	        	JOptionPane.showMessageDialog((Component)null,"Error operation:"+e.getMessage(),"PowerZip 1.0",JOptionPane.OK_OPTION);
       		}
	}
    }


    class add extends javax.swing.JFrame
    { 	
	char d[]={'A','B','C','D','E','F','G'};
 	JLabel l1,l2,l3,l4,l5,l6;
 	JButton newbutton,openbutton,addbutton,extractbutton,upbutton,b6,b7,b8,b9;
 	JList li1,li2;
 	JComboBox cb;
 	JCheckBox c1,c2,c3;
 	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9;
 	File[] fl;
 	File fi;
 	newModel nm;
 	newRenderer nr;
 	String yamp=new String();
 	JScrollPane sp1,sp2;
 	String sb[]=new String[1000];
 	String sc[]=new String[1000];
 	String sf[]=new String[1000];
 	String sn[]=new String[1000];
 	int ctr=0,dtr=0;
 	int total;
 	long size;
	
 	static final int BUFFER=10240;
 	public add()
 	{
    		super("Add to "+nurl);
    		l1=new JLabel("Select Drive:");
    		l2=new JLabel("Select File or Folder:");
    		l3=new JLabel("Path:");
    		l4=new JLabel("Files to add:");
    		l5=new JLabel("Total : 0 files");
    		l6=new JLabel("Size  : 0 bytes");
                cb=new JComboBox();
  		li1=new JList();
    		li2=new JList();
    		sp2=new JScrollPane(li2);
    		li2.setVisibleRowCount(15);
    		File fk=new File("C:/");
    		fl=fk.listFiles();
    		Arrays.sort(fl);
    		nm=new  newModel(fl);
    		nr=new newRenderer();
    		li1.setModel(nm);
    		li1.setCellRenderer(nr);
    		li1.setVisibleRowCount(10);
    		sp1=new JScrollPane(li1);
		c1=new JCheckBox("Include Subfolders");
    		c2=new JCheckBox("Create Backup");
    		c3=new JCheckBox("Delete files on compression");
		newbutton=new JButton("Add");
    		openbutton=new JButton("Cancel");
    		addbutton=new JButton("File Desc..");
    		extractbutton=new JButton("Help");
    		upbutton=new JButton(new ImageIcon("images1/up.jpg"));
    		b6=new JButton(new ImageIcon("images1/add.jpg"));
    		b7=new JButton(new ImageIcon("images1/remove.jpg"));
    		b8=new JButton(new ImageIcon("images1/removeAll.jpg"));
    		Container c=getContentPane();
	    	c.setLayout(null);
    		l1.setBounds(10,60,100,25);
    		c.add(l1);
    		cb.setBounds(10,90,150,30);
    		c.add(cb);
    		l2.setBounds(10,150,150,25);
    		c.add(l2);
    		sp1.setBounds(10,180,150,150);
    		c.add(sp1);
    		l3.setBounds(10,330,200,25);
    		c.add(l3);
    		c1.setBounds(250,20,150,40);
    		c.add(c1);
    		c2.setBounds(250,60,125,40);
    		c.add(c2);
    		c3.setBounds(250,100,200,40);
    		c.add(c3);
    		l4.setBounds(250,150,150,25);
    		c.add(l4);
		sp2.setBounds(250,180,200,150);
    		c.add(sp2);
    		l5.setBounds(250,330,150,20);
    		c.add(l5);
    		l6.setBounds(250,350,150,20);
    		c.add(l6);
    		upbutton.setBounds(180,190,50,30);
    		c.add(upbutton);
    		b6.setBounds(180,220,50,30);
    		c.add(b6);
    		b7.setBounds(180,250,50,30);
    		c.add(b7);
    		b8.setBounds(180,280,50,30);
    		c.add(b8);
    		newbutton.setBounds(450,180,100,40);
    		c.add(newbutton);
    		openbutton.setBounds(450,220,100,40);
    		c.add(openbutton);
    		addbutton.setBounds(450,260,100,40);
    		c.add(addbutton);
    		extractbutton.setBounds(450,300,100,40);
    		c.add(extractbutton);
		upbutton.setEnabled(false); 
    		for(int i=0;i<d.length;i++)
    		{
       			File f=new File(String.valueOf(d[i])+":/");
       			if (f.exists())
         			cb.addItem(d[i]+":");
    		}
    		cb.setSelectedItem("C:");
    		newbutton.addActionListener(new ActionListener()
    		{
      			public void actionPerformed(ActionEvent e1)
      			{
      				boolean ds;
      				if(c3.isSelected())
      				{
        				int result=JOptionPane.showConfirmDialog((Component)null,"You selected the option to remove files on compression, This will result in file loss!! \n Do you want to continue?","PowerZip 1.0",JOptionPane.YES_NO_OPTION);
        				if(result==JOptionPane.YES_OPTION)
        				{
           					ds=true;
        				}
        				else
        				{
           					ds=false;
        				}
      				}
      				else
      				{
        				ds=true;
      				}
      				if(ds==true)
      				{
        				if(!addzipstate)
				        {
          					if(ctr==0)
          					{
             						JOptionPane.showMessageDialog((Component)null,"No file is selected!","PowerZip 1.0",JOptionPane.OK_OPTION);
          					}
          					else if (checkExist())
          					{
             						JOptionPane.showMessageDialog((Component)null,"Duplicate file exist! Remove that, otherwise you can't do Add operation","PowerZip 1.0",JOptionPane.OK_OPTION);           
          					} 
          					else
          					{
             						zipp(sf,nurl,sn);
             						ad.setVisible(false);
             						int rc;
	             					while((rc=dm.getRowCount())!=0)
        	     					{
                						dm.removeRow(0);
             						}
             						showfile(nurl);
          					}
        				}
        				else
        				{
          					if(ctr==0)
          					{
             						JOptionPane.showMessageDialog((Component)null,"No file is selected!","PowerZip 1.0",JOptionPane.OK_OPTION);
          					}
          					else if (checkExist())
          					{
             						JOptionPane.showMessageDialog((Component)null,"Duplicate file exist! Remove that, otherwise you can't do Add operation","PowerZip 1.0",JOptionPane.OK_OPTION);           
          					}
          					else
          					{
             						String f=new String(new File(url1).getParent());
             						int rnum2=getRandom(getRandom(2000));
             						f=f+"/tmp"+String.valueOf(rnum2)+".zip";
             						addn(url1,f,sf,sn);
             						ad.setVisible(false);	
             						int rc;
             						while((rc=dm.getRowCount())!=0)
             						{
               							dm.removeRow(0);
             						}
	             					showfile(url1);
          					}
					}
				} //end of if(ds==true)
      			}
    		});

    		openbutton.addActionListener(new ActionListener()
    		{
      			public void actionPerformed(ActionEvent e1)
      			{
      				
	      			i3.setEnabled(false);
   				i9.setEnabled(false);
   				i11.setEnabled(false);
   				i12.setEnabled(false);
   				i13.setEnabled(false);
   				i17.setEnabled(false);
   				i19.setEnabled(false);
   				i20.setEnabled(false);
   				i22.setEnabled(false);
   				i24.setEnabled(false);
   				addButton.setEnabled(false);
   				extractButton.setEnabled(false);
   				deleteButton.setEnabled(false);
        			ad.setVisible(false);
      			}   	
		});

    		addbutton.addActionListener(new ActionListener()
    		{
      			public void actionPerformed(ActionEvent e1)
      			{
        			if (li2.getSelectedIndex()<0)
        			{
           				JOptionPane.showMessageDialog((Container)null,"No file is selected","PowerZip 1.0",JOptionPane.OK_OPTION); 
        			}
        			else
        			{
        				fileDesc fdx=new fileDesc(sf[li2.getSelectedIndex()]);
        				fdx.setLocation(200,150);
        				fdx.setSize(300,300);
        				fdx.setVisible(true);
        			}
      			}
    		}); 

    		extractbutton.addActionListener(new ActionListener()
    		{
      			public void actionPerformed(ActionEvent e1)
      			{
        			help hp=new help();
        			hp.setSize(500,400);
        			hp.setLocation(50,50);
        			hp.setVisible(true);
      			}
    		}); 
    		cb.addItemListener(new ItemListener()
    		{
      			public void itemStateChanged(ItemEvent e)
      			{
        			if(e.getStateChange()==ItemEvent.SELECTED)
        			{
          				String s=(String)e.getItem();
          				File f=new File(s+"/");
          				fl=f.listFiles();
          				Arrays.sort(fl);  
          				nm=new  newModel(fl);
          				nr=new newRenderer();
          				li1.setModel(nm);
          				li1.setCellRenderer(nr);
          				li1.setBounds(10,180,100,150);
         			}
      			}
    		});

    		li1.addMouseListener(new MouseAdapter()
    		{
      			public void mouseClicked(MouseEvent me)
      			{
        			JList l=(JList)me.getSource();
        			int index=l.locationToIndex(me.getPoint());
        			if(me.getClickCount()==2)
        			{
          				File f=new File(fl[index].toString());
          				if(!f.isFile())
          				{
          					File[] fx=fl;
          					fl=f.listFiles();
          					Arrays.sort(fl);
          					if(!(fl.length==0))
          					{
           						nm=new  newModel(fl);
           						nr=new newRenderer();
           						li1.setModel(nm);
           						li1.setCellRenderer(nr);
           						upbutton.setEnabled(true);
          					}
          					else
            					fl=fx;
          				} 
        			}
        			else
        			{
          				if(!(fl.length==0))
          					l3.setText("Path:"+fl[index].toString());
        			}
      			}
    		});

	    	upbutton.addActionListener(new ActionListener()
    		{
      			public void actionPerformed(ActionEvent e)
      			{
        			File f=fl[0].getParentFile();
        			if(f.getParentFile()!=null)
        			{
          				File ft=f.getParentFile();
          				fl=ft.listFiles();
          				nm=new  newModel(fl);
          				nr=new newRenderer();
          				li1.setModel(nm);
          				li1.setCellRenderer(nr);
        			}
        			else
        			{
          				upbutton.setEnabled(false);
        			}
      			}
    		});


		b6.addActionListener(new ActionListener()
	        {
	            	public void actionPerformed(ActionEvent e)
      			{
        			int[] ind=li1.getSelectedIndices();
			        for(int i=0;i<ind.length;i++)
        			{
          				int x=ind[i];
	          
    				      	File f=new File(fl[x].toString());
			          	if(f.isFile())
          				{
           					int z=getFiles(f);
          				}
          				else if((f.isDirectory())&&(c1.isSelected()))
          				{
            					yamp=f.getParent();
            					int z=getsub(f);
          				}
          				else if(f.isDirectory())
          				{
            					int z=getDir(f);
          				}
        			}
        			li2.setListData(sf); 
        			if (checkExist())
        			{
           				JOptionPane.showMessageDialog((Component)null,"Duplicate file exist! Remove that, otherwise you can't do Add operation","PowerZip 1.0",JOptionPane.OK_OPTION);           
        			}  
        			size = 0;
        			for(int total=0;total<ctr;total++)
        			{		
             				fi=new File(sf[total]);
	             			size=size+fi.length();  
        			}
			       	l6.setText("Size  : "+ formatt(String.valueOf(size)) + " bytes");
        			l5.setText("Total : "+String.valueOf(ctr)+ " files");
        		}
     		});


                b7.addActionListener(new ActionListener()
     		{
       			public void actionPerformed(ActionEvent e)
       			{
         			String tf[]=new String[100];
         			String tn[]=new String[100];
         			int ind[]=li2.getSelectedIndices();
         			int dtr=0;
         			for(int i=0;i<ctr;i++)
         			{
           				int x=0;
           				while(x<ind.length)
           				{
        	     				if(i==ind[x]) break;
     	        				x++;
           				}
           				if(x==ind.length)
           				{
             					tf[dtr]=sf[i];
             					tn[dtr]=sn[i];
             					dtr++;
           				} 
         			}
         			ctr=dtr;
         			sf=tf;
         			sn=tn;
         			li2.setListData(sf);
         			size = 0;
         			for(int total=0;total<ctr;total++)
         			{
             				fi=new File(sf[total]);
	             			size=size+fi.length();  
         			}
			        l6.setText("Size  : "+ formatt(String.valueOf(size)) + " bytes");
         			l5.setText("Total : "+String.valueOf(ctr)+ " files");
       			}
     		});

     		b8.addActionListener(new ActionListener()
     		{
       			public void actionPerformed(ActionEvent e)
       			{
         			ctr=0;
         			sf=new String[100];
         			sn=new String[100];
         			li2.setListData(sf);
         			l6.setText("Size  : 0 bytes");
         			l5.setText("Total : 0 files"); 
       			}
     		});
 	}


 	public int getFiles(File f)
 	{
   		sf[ctr]=f.toString();
   		sn[ctr]=f.getName();
   		ctr++;
   		return 1;
 	}

	public int getDir(File f)
	{
		File[] fx=f.listFiles();
		if(fx.length==0) return 0;
		for(int i=0;i<fx.length;i++)
		{
			if(fx[i].isFile())
     			{
       				sf[ctr]=fx[i].toString();
       				sn[ctr]=getRelative(sf[ctr],f.getParent());
       				ctr++;
     			}
   		}
   		return 1;
 	}

	public String getRelative(String a,String b)
	{
		StringTokenizer tok=new StringTokenizer(a,"\\");
		StringTokenizer toq=new StringTokenizer(b,"\\");
		int cnt=toq.countTokens();
		int cn=1;
		while(cn<=cnt)
		{
			tok.nextToken();
			cn++;
		}
		StringBuffer bf=new StringBuffer(); 
		while(tok.hasMoreTokens())
		{
      			bf.append(tok.nextToken());
			bf.append("/");
		}
		bf.deleteCharAt(bf.length()-1);
		return(new String(bf));
	}
	public int getsub(File f)
	{
		int z;
		File[] fx=f.listFiles();
		if(fx.length==0) return 0;
	  	for(int i=0;i<fx.length;i++)
   		{
     			if(fx[i].isFile())
     			{
       				sf[ctr]=fx[i].toString();
       				sn[ctr]=getRelative(sf[ctr],yamp);
       				ctr++;
     			}
	     		else if(fx[i].isDirectory())
       				z=getsub(fx[i]);
   		}
   		return 1;
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

	public boolean checkExist() 
	{
    		boolean chk=false;
		for(int i=0;i<ctr;i++)
		{
			for(int j=i+1;j<ctr;j++)
       			{
       	  			if(sf[i].equals(sf[j]))
       				{
       					chk=true;  
	            			break;
         			}
			}   
			if (chk==true) break;
		}
    		return chk; 
	}
 

	public void addn(String old,String newf,String[] fil,String[] nam)
	{
		try
    		{
			BufferedInputStream origin=null;
			FileOutputStream fos=new FileOutputStream(newf);
       			ZipOutputStream zos=new ZipOutputStream(new BufferedOutputStream(fos));
			FileInputStream fis=new FileInputStream(old);
			ZipInputStream zis=new ZipInputStream(new BufferedInputStream(fis));
			ZipEntry entry;
       			File ff,fl;
       			String urlx;
       			byte[] bdat=new byte[2048];
       			int cnt,m;
       			BufferedInputStream bis;
       			boolean back=false;
       			String urly = System.getProperty("user.dir") + System.getProperty("file.separator")+"backup";
		
				
       			while((entry=zis.getNextEntry())!=null)
       			{
         			int count;
         			byte[] data=new byte[2048];	
	       			ZipEntry ent=new ZipEntry(entry.getName());
       				zos.putNextEntry(ent);
       				while((count=zis.read(data,0,2048))!=-1)
       				{
       					zos.write(data,0,count);
         			}
			}
       			zis.close();
       			for(int i=0;i<ctr;i++)
         		{
       	   			byte[] data=new byte[2048];
     				FileInputStream fi=new FileInputStream(fil[i]);
       				origin=new BufferedInputStream(fi,2048);
       				ZipEntry entr=new ZipEntry(nam[i]);
       				zos.putNextEntry(entr);
       				int count;
       				while((count=origin.read(data,0,2048))!=-1)
       				{
	             			zos.write(data,0,count);
       				}
          			fi.close();
       	   			if(c2.isSelected())
       				{
       					urlx = System.getProperty("user.dir") + System.getProperty("file.separator")+"backup\\"+nam[i];
	             			FileInputStream filx=new FileInputStream(fil[i]);
	             			ff=new File(urlx);
			   
	             			StringTokenizer sto=new StringTokenizer(ff.toString(),"\\");
       					cnt=sto.countTokens();
       					m=1;
	             			StringBuffer sb=new StringBuffer();
	             			while(m<=cnt-1)
	             			{
	               				sb.append(sto.nextToken());
        					sb.append("/");
               					m++;
		       			}		
		       
             					sb.deleteCharAt(sb.length()-1);
             					String stf=new String(sb);
		             			fl=new File(stf);
		             			if(!fl.exists())
		       				fl.mkdirs();
             					if(!ff.exists())
                					ff.createNewFile();
		             			FileOutputStream folx=new FileOutputStream(ff);
             					bis=new BufferedInputStream(filx,2048);
		             			while((cnt=bis.read(bdat,0,2048))!=-1)
		             			{
		                			folx.write(bdat,0,cnt);
		             			}
		             			bis.close();
		             			filx.close();
		             			folx.close();
		             			back=true; 
	           		} 
        	   		if(c3.isSelected())
           			{
             				ff=new File(fil[i]);
		             		ff.delete();
	           		}
        	 	} 
         		zos.close();
         		if (back)
           			JOptionPane.showMessageDialog((Component)null,"Added files are backed up on the folder "+urly,"PowerZip 1.0",JOptionPane.OK_OPTION);           
	         	File ol=new File(old);
	         	ol.delete();
	         	File f=new File(newf);
	         	try
	       	 	{
        	 		f.renameTo(ol);
         		}
         		catch(Exception e)
	         	{ 
		        	JOptionPane.showMessageDialog((Component)null,"Add operation failed, some internal error occur!!","PowerZip 1.0",JOptionPane.OK_OPTION);           
	         	}
	      	
		}
      		catch(Exception e)
		{
	        	JOptionPane.showMessageDialog((Component)null,"Add operation failed, Some internal error occur\n Reason: "+e.getMessage(),"Javazip 1.0",JOptionPane.OK_OPTION);           
	      	}
	      		
      		
  	}



	public void zipp(String[] files,String path,String[] names)
  	{
		        
   		try 
   		{
	       		BufferedInputStream origin = null;
         		FileOutputStream dest = new FileOutputStream(path);
        		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
        		byte data[] = new byte[BUFFER];
        		File ff,fl;
        		String urlx;
        		byte[] bdat=new byte[2048];
        		int cnt,m;
        		BufferedInputStream bis;
        		boolean back=false;
		        String urly = System.getProperty("user.dir") + System.getProperty("file.separator")+"backup";
	
      			for (int i=0; i<ctr; i++)
        		{
	                	FileInputStream fi = new FileInputStream(files[i]);
       				origin = new BufferedInputStream(fi, BUFFER);
	            		ZipEntry entry = new ZipEntry(names[i]);
	            		entry.setSize(new File(files[i]).length());
	            		entry.setTime(new File(files[i]).lastModified());
	            		out.putNextEntry(entry);
	            		int count;
	            		while((count = origin.read(data, 0,BUFFER)) != -1)
	            		{
	               			out.write(data, 0, count);
	            		}
	            		origin.close();
	            		fi.close();
	            		if(c2.isSelected())
	       			{
        		     		urlx = System.getProperty("user.dir") + System.getProperty("file.separator")+"backup\\"+names[i];
             				FileInputStream filx=new FileInputStream(files[i]);
		             		ff=new File(urlx);	
			        
        		     		StringTokenizer sto=new StringTokenizer(ff.toString(),"\\");
             				cnt=sto.countTokens();
		             		m=1;
		             		StringBuffer sb=new StringBuffer();
		             		while(m<=cnt-1)
             				{
		               			sb.append(sto.nextToken());
		               			sb.append("/");
		               			m++;
		             		}
			          
             				sb.deleteCharAt(sb.length()-1);
	       				String stf=new String(sb);
        		     		fl=new File(stf);
             				if(!fl.exists())
               					fl.mkdirs();
		             		if(!ff.exists())
		                		ff.createNewFile();
		             		FileOutputStream folx=new FileOutputStream(ff);
		             		bis=new BufferedInputStream(filx,2048);
		             		while((cnt=bis.read(bdat,0,2048))!=-1)
		             		{
		                		folx.write(bdat,0,cnt);
		             		}
		             		bis.close();
		             		filx.close();
		             		folx.close(); 
		             		back=true;
	           		}
        		    	if(c3.isSelected())
	           		{
        		     		ff=new File(files[i]);
		             		ff.delete();
		      		}
		      	}
         		out.close();
         		if (back)
         			JOptionPane.showMessageDialog((Component)null,"Added files are backed up on the folder "+urly,"PowerZip 1.0",JOptionPane.OK_OPTION);
         	} 
	        catch(Exception e) 
	      	{
	       		JOptionPane.showMessageDialog((Component)null,"Some internal error occured, file cannot be created!!","PowerZip 1.0",JOptionPane.OK_OPTION);           
	      	}
	}
    }

 
    class extract extends javax.swing.JFrame
    {
	
	JButton b1,b2,b3;
        JLabel l1;
    	JTextField tf2;
	JRadioButton r1,r2,r3;
    	JCheckBox c1;
    	ButtonGroup bg;
    	int mode;
    	String[] stv;
    	boolean ch;
    
    	extract(boolean choice)
    	{
      		super("Extract to..");
      		Container c=getContentPane();
      		stv=getNames();
			
		ch=choice;
				
      		b1=new JButton("Browse..");
      		b2=new JButton("Extract");
      		b3=new JButton("Cancel");

      		l1=new JLabel("Extract to:");

      		tf1=new JTextField(20);
      		tf2=new JTextField(15);

      		c1=new JCheckBox("Overwrite Files");

	      	r2=new JRadioButton("Selected Files");
      		r1=new JRadioButton("All Files");
      		r3=new JRadioButton("Files:(Spaces bet. Filenames)");
      		bg=new ButtonGroup();
      		bg.add(r1);
      		bg.add(r2);
      		bg.add(r3);

      		JPanel p1=new JPanel(new GridLayout(2,1));
      		p1.add(l1);
      		p1.add(tf1);

      		JPanel p2=new JPanel(new GridLayout(4,1));
      		p2.add(r1);
      		p2.add(r2);
      		p2.add(r3);
      		p2.add(tf2);

      		JPanel p3=new JPanel(new GridLayout(3,1));      
      		p3.add(b1);
      		p3.add(b2);
      		p3.add(b3);

      		c.add(p1,BorderLayout.NORTH);
      		c.add(p2,BorderLayout.CENTER);
      		c.add(p3,BorderLayout.EAST);
      		c.add(c1,BorderLayout.SOUTH);
      		tf2.setEnabled(false);
      		c1.setSelected(true);
      		
      		int[] sel=tl.getSelectedRows();
      		if(sel.length==0)
      		{
       			mode=1;
       			r1.setSelected(true);
      		}
      		else
      		{
      			mode=2;
      			r2.setSelected(true);
      		}
      		
      		if(ch==true)
      		{
      			b1.setEnabled(false);
      			b3.setEnabled(false);
      			tf1.setText("data\\");
      			tf1.setEditable(false);
      			r1.setEnabled(false);
      			r2.setEnabled(false);
      			r3.setEnabled(false);
      		}

      		r1.addItemListener(new ItemListener()
      		{
        		public void itemStateChanged(ItemEvent ie)
        		{
          			mode=1;
          			tf2.setEnabled(false);
        		}
      		});

      		r2.addItemListener(new ItemListener()
      		{
        		public void itemStateChanged(ItemEvent ie)
        		{
          			mode=2;
          			tf2.setEnabled(false);
        		}
      		});

      		r3.addItemListener(new ItemListener()
      		{
        		public void itemStateChanged(ItemEvent ie)
        		{
          			mode=3;
          			tf2.setEnabled(true);
        		}
      		});

      		b1.addActionListener(new ActionListener()
      		{
        		public void actionPerformed(ActionEvent e)
        		{
           			JFileChooser fc=new JFileChooser();
           			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
           			int res=fc.showDialog(null,null);
           			if (res==JFileChooser.APPROVE_OPTION)
           			{
	             			File f=fc.getSelectedFile();
        	     			String l=f.getPath();
             				//StringBuffer sb=new StringBuffer(l); 
             				String s=l.replace('\\','/');
             				tf1.setText(s);
           			}
        		}  
      		});

      		b2.addActionListener(new ActionListener()
      		{
        		public void actionPerformed(ActionEvent e2)
        		{
          			if(tf1.getText().equals(""))
          			{
           				JOptionPane.showMessageDialog((Component)null,"Extract to: Textbox should not be empty","PowerZip 1.0",JOptionPane.OK_OPTION);
          			}
          			else
          			{
          				boolean ow;
          				url=tf1.getText();
          				if(c1.isSelected())
           					ow=true;
          				else
           					ow=false;
          				unzipp(url,url1,mode,ow);
          				ex.setVisible(false);
          			}
        		}
      		});

      		b3.addActionListener(new ActionListener()
      		{
        		public void actionPerformed(ActionEvent e2)
        		{
          			ex.setVisible(false);
        		}
      		});
	}

    	public void unzipp(String path,String zip,int mode,boolean ow)
	{	
    		final int BUFFER=2048;
    		File op=new File(path);
    		String chk;
    		int mi;
    		if(!op.exists())
      		op.mkdirs();
    		String[] stm=getNums(mode);
    		if(((mode==2)||(mode==3))&&(stm.length==0))
    		{
    	   		JOptionPane.showMessageDialog((Component)null,"No files selected or specified!!\n Extraction not continued!!","PowerZip 1.0",JOptionPane.OK_OPTION);               
    		}
    		else
    		{ 
    			try
    			{
       				BufferedOutputStream dest = null;
       				FileInputStream fis = new FileInputStream(zip);
       				ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
       				ZipEntry entry;
       				int row=0;
       				while((entry = zis.getNextEntry()) != null)
       				{  
          				l1.setText("Status:Extracting:"+entry.getName()); 
          				if(entry.getSize()==0)
            				continue;
          				if((mode==2)||(mode==3))
          				{
            					chk=entry.getName();
        	    				for (mi=0;(mi<stm.length)&&(!(chk.equals(stm[mi])));mi++);
            					if(mi==stm.length)
            					{
             						row++;
            						continue;
            					}
          				}
          				File ft=new File(path+"/"+entry.getName());
          				pathOpenWith= ft.getAbsolutePath();
          				if((!ow)&&(ft.exists()))
          				{
            					continue;
          				}
          				StringTokenizer sto=new StringTokenizer(ft.toString(),"\\");
          				int cnt=sto.countTokens();
          				int m=1;
          				StringBuffer sb=new StringBuffer();
          				while(m<=cnt-1)
          				{
            					sb.append(sto.nextToken());
            					sb.append("/");
            					m++;
          				}
          				String stl=sto.nextToken();
          				sb.deleteCharAt(sb.length()-1);
          				String stf=new String(sb);
          				File fl=new File(stf);
          				if(!fl.exists())
            					fl.mkdirs();
		          
        				int count;
          				byte data[] = new byte[BUFFER];
          				FileOutputStream fos = new FileOutputStream(stf+"/"+stl);
          				dest = new BufferedOutputStream(fos, BUFFER);
          				while ((count = zis.read(data, 0, BUFFER))!= -1)
          				{
               					dest.write(data, 0, count);
          				}
          				dest.flush();
          				dest.close();
          				fos.close();
          				row++;
        			}
        			zis.closeEntry(); 
        			zis.close();
        			fis.close();
        			if(ch==true)
        			{
        				//openWith opw= new openWith(pathOpenWith, openWithChoice);
        			}
    			} 
    			catch(Exception e) 
      			{
       				JOptionPane.showMessageDialog((Component)null,"Error while extracting!!\n Extraction not continued!!","PowerZip 1.0",JOptionPane.OK_OPTION);        
      			}
   		}//end of else 
    		l1.setText("Status: Done");
	}

	public String[] getList()
	{
    		int ck=0;
    		String sel[]=new String[tl.getSelectedRowCount()];
      		for(int ci=0;ci<tl.getRowCount();ci++)
      		{
        		if(tl.isRowSelected(ci))
        		{
          			sel[ck]=String.valueOf(tl.getValueAt(ci,6))+ String.valueOf(tl.getValueAt(ci,0));
          			ck++;
        		}
      		} 
     		return sel;
	}

	public String[] getEntries(String ent)
 	{
    		int i=0;
    		StringTokenizer tk=new StringTokenizer(tf2.getText()," ");
    		String[] sr=new String[tk.countTokens()];
    		while(tk.hasMoreTokens())
    		{
      			sr[i]=tk.nextToken();
      			i++;
    		}
    		return sr;
  	}
  	public String[] getNames()
  	{
    		int str=tl.getRowCount();
    		String[] st=new String[str];
    		for(int i=0;i<str;i++)
    		{
      			st[i]=(String)tl.getValueAt(i,0);
    		}
    		return st;
  	}

	public String[] getNums(int mde)
	{
		int ind=0;
		String chkr;
		int k;
		String[] st=getEntries(tf2.getText());
		String sr[]=getNames();
		String sm[]=getList();
		String cor[]=new String[st.length];
		if (mde==2)
		{
    			return sm;
		}
		else
		{
			for(int s=0;s<st.length;s++)
			{
     				for(k=0;(k<sr.length)&&(!(st[s].toLowerCase().trim().equals(sr[k].toLowerCase().trim())));k++);
     				if(k==sr.length) 
     				{
        				JOptionPane.showMessageDialog((Component)null,"File "+st[s]+" not found!!\n Extraction continues on other files!!","PowerZip 1.0",JOptionPane.OK_OPTION);        
     				}
     				else
     				{
       					cor[ind]=st[s];
       					ind++;
     				}
   			}
   			try
   			{
   				for(ind=0;ind<cor.length;ind++)
   				{
     					for(int ki=0;ki<sr.length;ki++)
     					{
       						chkr=(String)tl.getValueAt(ki,0);
       						if(cor[ind].toLowerCase().equals(chkr.toLowerCase()))
          						cor[ind]=String.valueOf(tl.getValueAt(ki,6))+String.valueOf(tl.getValueAt(ki,0));       
     					} 
   				}
   			}
   			catch(Exception ex)
   			{
     				JOptionPane.showMessageDialog((Component)null,"Error occured!!,\nIncorrect entries!!","PowerZip 1.0",JOptionPane.OK_OPTION);        
   			}
   			return cor;
   		}
   	}
    }


    public NSNZ(String s)
    {
        super("PowerZip... Powered by Java");
        tmpbuf = new byte[512];
        newstate = false;
        openstate = false;
        addzipstate = false;
        dpan = new JDesktopPane();
        c = getContentPane();
        frame = this;
        newButton = new JButton("New", new ImageIcon("images1/newImage11.jpg"));
        openButton = new JButton("Open", new ImageIcon("images1/openImage21.jpg"));
        addButton = new JButton("Add", new ImageIcon("images1/addImage31.jpg"));
        extractButton = new JButton("Extract", new ImageIcon("images1/extractImage41.jpg"));
        deleteButton = new JButton("Delete", new ImageIcon("images1/deleteImage51.jpg"));
        
        newButton.setRolloverIcon(new ImageIcon("images1/newImage12.jpg"));
        openButton.setRolloverIcon(new ImageIcon("images1/openImage22.jpg"));
        addButton.setRolloverIcon(new ImageIcon("images1/addImage32.jpg"));
        extractButton.setRolloverIcon(new ImageIcon("images1/extractImage42.jpg"));
        deleteButton.setRolloverIcon(new ImageIcon("images1/deleteImage52.jpg"));
        
        newButton.setDisabledIcon(new ImageIcon("images1/newImage13.jpg"));
        openButton.setDisabledIcon(new ImageIcon("images1/openImage23.jpg"));
        addButton.setDisabledIcon(new ImageIcon("images1/addImage33.jpg"));
        extractButton.setDisabledIcon(new ImageIcon("images1/extractImage43.jpg"));
        deleteButton.setDisabledIcon(new ImageIcon("images1/deleteImage53.jpg"));
        
        newButton.setPressedIcon(new ImageIcon("images1/newImage14.jpg"));
        openButton.setPressedIcon(new ImageIcon("images1/openImage24.jpg"));
        addButton.setPressedIcon(new ImageIcon("images1/addImage34.jpg"));
        extractButton.setPressedIcon(new ImageIcon("images1/extractImage44.jpg"));
        deleteButton.setPressedIcon(new ImageIcon("images1/deleteImage54.jpg"));
        
        newButton.setVerticalTextPosition(3);
        newButton.setHorizontalTextPosition(0);
        openButton.setVerticalTextPosition(3);
        openButton.setHorizontalTextPosition(0);
        addButton.setVerticalTextPosition(3);
        addButton.setHorizontalTextPosition(0);
        extractButton.setVerticalTextPosition(3);
        extractButton.setHorizontalTextPosition(0);
        deleteButton.setVerticalTextPosition(3);
        deleteButton.setHorizontalTextPosition(0);
        
        newButton.setToolTipText("Create a new Archive");
        openButton.setToolTipText("Open an Archive");
        addButton.setToolTipText("Add Files");
        extractButton.setToolTipText("Extract Files");
        deleteButton.setToolTipText("Delete Files");
        
        newButton.addActionListener(this);
        openButton.addActionListener(this);
        addButton.addActionListener(this);
        extractButton.addActionListener(this);
        deleteButton.addActionListener(this);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 5));
        p1.add(newButton);
        p1.add(openButton);
        p1.add(addButton);
        p1.add(extractButton);
        p1.add(deleteButton);
        
        l1 = new JLabel("Status:");
        l2 = new JLabel();
        l3 = new JLabel(new ImageIcon("images1/jav1.gif"));
        px = new JPanel(new GridLayout(1, 3));
        px.add(l1);
        px.add(l2);
        px.add(l3);
        tb = new JToolBar();
        tb.add(p1);
        tb.setBorderPainted(true);
        dm = new DefaultTableModel(0, 0);
        tl = new JTable(dm);
        dm.addColumn("Name");
        dm.addColumn("Modified");
        dm.addColumn("Size");
        dm.addColumn("Ratio");
        dm.addColumn("Packed");
        dm.addColumn("Attributes");
        dm.addColumn("Path");
        tl.setShowGrid(true);
        sp = new JScrollPane(tl);
        mb = new JMenuBar();
        m1 = new JMenu("File");
        m2 = new JMenu("Edit");
        m3 = new JMenu("Actions");
        m4 = new JMenu("Options");
        m5 = new JMenu("Help");
        i1 = new JMenuItem("New Archive", new ImageIcon("images1/newFileMenuItem.gif"));
        i2 = new JMenuItem("Open Archive", new ImageIcon("images1/openFileMenuItem.gif"));
        i3 = new JMenuItem("Close Archive", new ImageIcon("images1/closeFileMenuItem.gif"));
        i4 = new JMenuItem("Move Archive", new ImageIcon("images1/moveFileMenuItem.gif"));
        i5 = new JMenuItem("Copy Archive", new ImageIcon("images1/copyFileMenuItem.gif"));
        i6 = new JMenuItem("Rename", new ImageIcon("images1/renameFileMenuItem.gif"));
        i7 = new JMenuItem("Delete", new ImageIcon("images1/deleteFileMenuItem.gif"));
        i9 = new JMenuItem("Save As..", new ImageIcon("images1/saveFileMenuItem.gif"));
        i10 = new JMenuItem("Exit", new ImageIcon("images1/exitFileMenuItem.gif"));
        i11 = new JMenuItem("Select All");
        i12 = new JMenuItem("Deselect All");
        i13 = new JMenuItem("Invert Selection");
        i17 = new JMenuItem("Find", new ImageIcon("images1/findEditMenuItem.gif"));
        i19 = new JMenuItem("Add", new ImageIcon("images1/addActionMenuItem.gif"));
        i20 = new JMenuItem("Extract", new ImageIcon("images1/extractActionMenuItem.gif"));
        
        i22 = new JMenuItem("Delete", new ImageIcon("images1/deleteActionMenuItem.gif"));
        
        i24 = new JMenu("Open with");
        i25 = new JMenu("Skin");
        i26 = new JMenuItem("About PowerZip", new ImageIcon("images1/aboutHelpMenuItem.gif"));
        i27 = new JMenuItem("Help", new ImageIcon("images1/helpHelpMenuItem.gif"));
        i25.add(i25_1 = new JRadioButtonMenuItem("Metal"));
        i25.add(i25_2 = new JRadioButtonMenuItem("Motif"));
        i25.add(i25_3 = new JRadioButtonMenuItem("Windows"));
        ButtonGroup buttongroup = new ButtonGroup();
        buttongroup.add(i25_1);
        buttongroup.add(i25_2);
        buttongroup.add(i25_3);
        i24_1 = new JMenuItem("Media Player");
        i24_2 = new JMenuItem("Text Viewer");
        i24_3 = new JMenuItem("Image Viewer");
        i24_1.addActionListener(this);
        i24_2.addActionListener(this);
        i24_3.addActionListener(this);
        i1.addActionListener(this);
        i2.addActionListener(this);
        i3.addActionListener(this);
        i4.addActionListener(this);
        i5.addActionListener(this);
        i6.addActionListener(this);
        i7.addActionListener(this);
        i9.addActionListener(this);
        i10.addActionListener(this);
        i11.addActionListener(this);
        i12.addActionListener(this);
        i13.addActionListener(this);
        i17.addActionListener(this);
        i19.addActionListener(this);
        i20.addActionListener(this);
        
        i22.addActionListener(this);
        
        i24.addActionListener(this);
        i26.addActionListener(this);
        i27.addActionListener(this);
        i25_1.addActionListener(this);
        i25_2.addActionListener(this);
        i25_3.addActionListener(this);
        i1.setAccelerator(KeyStroke.getKeyStroke(78, 2));
        i2.setAccelerator(KeyStroke.getKeyStroke(79, 2));
        i3.setAccelerator(KeyStroke.getKeyStroke(67, 2));
        i4.setAccelerator(KeyStroke.getKeyStroke(77, 2));
        i5.setAccelerator(KeyStroke.getKeyStroke(69, 2));
        i6.setAccelerator(KeyStroke.getKeyStroke(82, 2));
        i7.setAccelerator(KeyStroke.getKeyStroke(68, 2));
        i9.setAccelerator(KeyStroke.getKeyStroke(65, 2));
        i10.setAccelerator(KeyStroke.getKeyStroke(88, 2));
        i11.setAccelerator(KeyStroke.getKeyStroke(65, 2));
        i12.setAccelerator(KeyStroke.getKeyStroke(68, 2));
        i13.setAccelerator(KeyStroke.getKeyStroke(73, 2));
        i17.setAccelerator(KeyStroke.getKeyStroke(70, 2));
        i19.setAccelerator(KeyStroke.getKeyStroke(65, 2));
        i20.setAccelerator(KeyStroke.getKeyStroke(69, 2));
       
        i22.setAccelerator(KeyStroke.getKeyStroke(68, 2));
       
        i26.setAccelerator(KeyStroke.getKeyStroke(65, 2));
        i27.setAccelerator(KeyStroke.getKeyStroke(72, 2));
        m1.setMnemonic(70);
        m2.setMnemonic(69);
        m3.setMnemonic(79);
        m4.setMnemonic(65);
        m5.setMnemonic(72);
        i25.setMnemonic(83);
        i1.setMnemonic(78);
        i2.setMnemonic(79);
        i3.setMnemonic(67);
        i4.setMnemonic(77);
        i5.setMnemonic(69);
        i6.setMnemonic(82);
        i7.setMnemonic(68);
        i9.setMnemonic(65);
        i10.setMnemonic(88);
        i11.setMnemonic(65);
        i12.setMnemonic(68);
        i13.setMnemonic(73);
        i17.setMnemonic(70);
        i19.setMnemonic(65);
        i20.setMnemonic(69);
       
        i22.setMnemonic(68);
       
        i24.setMnemonic(67);
        i26.setMnemonic(65);
        i27.setMnemonic(72);
        i25.add(i25_1);
        i25.add(i25_2);
        i25.add(i25_3);
        i24.add(i24_1);
        i24.add(i24_2);
        i24.add(i24_3);
        m1.add(i1);
        m1.add(i2);
        m1.add(i3);
        m1.add(i4);
        m1.add(i5);
        m1.addSeparator();
        m1.add(i6);
        m1.add(i7);
        m1.add(i9);
        m1.addSeparator();
        m1.add(i10);
        m2.add(i11);
        m2.add(i12);
        m2.add(i13);
        m2.addSeparator();
        m2.add(i17);
        m3.add(i19);
        m3.add(i20);
       
        m3.add(i22);
        m3.addSeparator();
       
        m3.addSeparator();
        m3.add(i24);
        m4.add(i25);
        m5.add(i26);
        m5.addSeparator();
        m5.add(i27);
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        mb.add(m4);
        mb.add(m5);
        setJMenuBar(mb);
        c.add(px, "South");
        c.add(p1, "North");
        c.add(sp, "Center");
        i3.setEnabled(false);
        i9.setEnabled(false);
        i11.setEnabled(false);
        i12.setEnabled(false);
        i13.setEnabled(false);
        i17.setEnabled(false);
        i19.setEnabled(false);
        i20.setEnabled(false);
        i22.setEnabled(false);
        i24.setEnabled(false);
        addButton.setEnabled(false);
        extractButton.setEnabled(false);

        fc1 = new JFileChooser("C:\\javazip");
        fc1.addChoosableFileFilter(new filter1());
        fc1.addChoosableFileFilter(new filter2());
        fc2 = new JFileChooser("C:\\javazip");
        fc2.addChoosableFileFilter(new filter2());
        fc2.addChoosableFileFilter(new filter1());
        rndm = new Random();
        if(s == "Metal")
            i25_1.setSelected(true);
        else
        if(s == "Motif")
            i25_2.setSelected(true);
        else
        if(s == "Windows")
            i25_3.setSelected(true);
    }

    public static void main(String args[])
    {
        String s = null;
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            if(UIManager.getLookAndFeel().getName() == "Windows")
                s = "Windows";
            else
            if(UIManager.getLookAndFeel().getName() == "CDE/Motif")
                s = "Motif";
            else
            if(UIManager.getLookAndFeel().getName() == "Metal")
                s = "Metal";
        }
        catch(Exception exception)
        {
            System.err.println((new StringBuilder()).append("Error loading L&F: ").append(exception).toString());
        }
        NSNZ nz = new NSNZ(s);
        nz.setSize(720, 540);
        nz.show();
    }

    public void showfile(String s)
    {
        try
        {
            Object obj = null;
            FileInputStream fileinputstream = new FileInputStream(s);
            url1 = s;
            ZipFile zipfile = new ZipFile(s);
            Enumeration enumeration = zipfile.entries();
            fcount = 0;
            fsize = 0.0F;
            do
            {
                if(!enumeration.hasMoreElements())
                    break;
                ZipEntry zipentry = (ZipEntry)enumeration.nextElement();
                if(zipentry.getSize() != 0L)
                {
                    boolean flag = false;
                    String s1 = new String();
                    StringBuffer stringbuffer = new StringBuffer();
                    StringTokenizer stringtokenizer = new StringTokenizer(zipentry.getName(), "/");
                    int i = stringtokenizer.countTokens();
                    String s2 = javToDos(zipentry.getTime());
                    int j = (int)((zipentry.getCompressedSize() * 100L) / zipentry.getSize());
                    Object aobj[] = new Object[8];
                    if(i == 1)
                    {
                        s1 = stringtokenizer.nextToken();
                    } 
		    else
                    {
                        for(int k = 1; k <= i - 1; k++)
                        {
                            stringbuffer.append(stringtokenizer.nextToken());
                            stringbuffer.append("/");
                        }

                        s1 = stringtokenizer.nextToken();
                    }
                    fcount++;
                    fsize = fsize + (float)(int)zipentry.getSize();
                    int l = zipentry.getMethod();
                    String s3;
                    if(l == 8)
                        s3 = "A";
                    else
                        s3 = "";
                    aobj[0] = s1;
                    aobj[1] = s2;
                    aobj[2] = String.valueOf(zipentry.getSize());
                    aobj[3] = (new StringBuilder()).append(String.valueOf(100 - j)).append("%").toString();
                    aobj[4] = String.valueOf(zipentry.getCompressedSize());
                    aobj[5] = s3;
                    aobj[6] = stringbuffer;
                    dm.addRow(aobj);
                    setTitle((new StringBuilder()).append("PowerZip 1.0 - ").append(s).toString());
                    NumberFormat numberformat = NumberFormat.getInstance();
                    numberformat.setMaximumFractionDigits(2);
                    String s4;
                    if(fsize >= 1024F)
                    {
                        s4 = (new StringBuilder()).append(numberformat.format(fsize / 1024F)).append(" KB").toString();
                        if(fsize / 1024F >= 1024F)
                        {
                            fsize = fsize / 1024F;
                            s4 = (new StringBuilder()).append(numberformat.format(fsize / 1024F)).append(" MB").toString();
                        }
                    }
		    else
                    {
                        s4 = (new StringBuilder()).append(formatt(String.valueOf((int)fsize))).append(" bytes").toString();
                    }
                    l2.setText((new StringBuilder()).append(String.valueOf(fcount)).append(" Files    ").append(s4).toString());
                    l1.setText("Status:Success");
                }
            } while(true);
            zipfile.close();
            fileinputstream.close();
        }
        catch(Exception exception)
        {
            JOptionPane.showMessageDialog((Component)null, "Unreadable zip file error", "PowerZip 1.0", 0);
        }
    }

    public int getRandom(int i)
    {
        return rndm.nextInt(i);
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        if(actionevent.getSource() == newButton || actionevent.getSource() == i1)
        {
            int i = fc1.showSaveDialog(null);
            if(i == 0)
            {
                nurl = fc1.getSelectedFile().getPath();
                String s = nurl.substring(nurl.length() - 4, nurl.length());
                if(!s.equals(".zip"))
                    nurl = (new StringBuilder()).append(nurl).append(".zip").toString();
                File file = new File(nurl);
                if(file.exists())
                {
                    int j4 = JOptionPane.showConfirmDialog((Component)null, "File already exists.Want to replace?", "PowerZip 1.0", 0);
                    if(j4 == 0)
                    {
                        ad = new add();
                        ad.setLocation(150, 150);
                        ad.setSize(600, 450);
                        ad.show();
                        addzipstate = false;
                    }
                } 
		else
                {
                    ad = new add();
                    ad.setLocation(150, 150);
                    ad.setSize(600, 450);
                    ad.show();
                    addzipstate = false;
                }
                i3.setEnabled(true);
                i9.setEnabled(true);
                i11.setEnabled(true);
                i12.setEnabled(true);
                i13.setEnabled(true);
                i17.setEnabled(true);
                i19.setEnabled(true);
                i20.setEnabled(true);
                i22.setEnabled(true);
                i24.setEnabled(true);
                addButton.setEnabled(true);
                extractButton.setEnabled(true);
                deleteButton.setEnabled(true);
            }
	    else
            {
                i3.setEnabled(false);
                i9.setEnabled(false);
                i11.setEnabled(false);
                i12.setEnabled(false);
                i13.setEnabled(false);
                i17.setEnabled(false);
                i19.setEnabled(false);
                i20.setEnabled(false);
                i22.setEnabled(false);
                i24.setEnabled(false);
                addButton.setEnabled(false);
                extractButton.setEnabled(false);
                deleteButton.setEnabled(false);
            }
            openstate = false;
            newstate = true;
        } 
	else if(actionevent.getSource() == openButton || actionevent.getSource() == i2)
        {
            int j;
            if(openstate)
                while((j = dm.getRowCount()) != 0) 
                {
                    dm.removeRow(0);
                    l2.setText(null);
                }
            j = fc2.showOpenDialog(null);
            if(j == 0)
            {
                l1.setText("Status:Opening..");
                l3.setIcon(new ImageIcon("images1/jav.gif"));
                int j2;
                while((j2 = dm.getRowCount()) != 0) 
                    dm.removeRow(0);
                curfile = fc2.getSelectedFile().getPath();
                nurl = curfile;
                showfile(curfile);
                i3.setEnabled(true);
                i9.setEnabled(true);
                i11.setEnabled(true);
                i12.setEnabled(true);
                i13.setEnabled(true);
                i17.setEnabled(true);
                i19.setEnabled(true);
                i20.setEnabled(true);
                i22.setEnabled(true);
                i24.setEnabled(true);
                addButton.setEnabled(true);
                extractButton.setEnabled(true);
                deleteButton.setEnabled(true);
            } 
	    else
            {
                i3.setEnabled(false);
                i9.setEnabled(false);
                i11.setEnabled(false);
                i12.setEnabled(false);
                i13.setEnabled(false);
                i17.setEnabled(false);
                i19.setEnabled(false);
                i20.setEnabled(false);
                i22.setEnabled(false);
                i24.setEnabled(false);
                addButton.setEnabled(false);
                extractButton.setEnabled(false);
                deleteButton.setEnabled(false);
            }
            l3.setIcon(new ImageIcon("images1/jav1.gif"));
            openstate = true;
            newstate = false;
        } 
	else if(actionevent.getSource() == addButton || actionevent.getSource() == i19)
        {
            if(url1 == null)
            {
                JOptionPane.showMessageDialog((Container)null, "No file is opened", "PowerZip 1.0", 0);
            } 
	    else
            {
                addzipstate = true;
                ad = new add();
                ad.setLocation(150, 100);
                ad.setSize(600, 450);
                ad.show();
            }
        } 
	else if(actionevent.getSource() == extractButton || actionevent.getSource() == i20)
        {
            ex = new extract(false);
            ex.setSize(300, 200);
            ex.setLocation(150, 150);
            ex.show();
        } 
	else if(actionevent.getSource() == deleteButton || actionevent.getSource() == i22)
        {
            int k = JOptionPane.showConfirmDialog(null, "Sure to permanently remove the selected file(s)?", "PowerZip 1.0", 0);
            if(k == 0)
            {
                l1.setText("Status:Deleting..");
                int k2 = 0;
                int k3 = tl.getSelectedRowCount();
                String as[] = new String[tl.getRowCount()];
                for(int k4 = 0; k4 < tl.getRowCount(); k4++)
                    if(tl.isRowSelected(k4))
                    {
                        as[k2] = (new StringBuilder()).append(String.valueOf(tl.getValueAt(k4, 6))).append(String.valueOf(tl.getValueAt(k4, 0))).toString();
                        k2++;
                    }

                if(k3 == 0)
                {
                    JOptionPane.showMessageDialog((Container)null, "No file is selected to remove!!", "PowerZip 1.0", 0);
                } 
		else
                {
                    String s3 = new String((new File(url1)).getParent());
                    int l4 = getRandom(getRandom(1000));
                    s3 = (new StringBuilder()).append(s3).append("/tmp").append(String.valueOf(l4)).append(".zip").toString();
                    dele dele1 = new dele(url1, s3, as, k3);
                    int j5;
                    while((j5 = dm.getRowCount()) != 0) 
                        dm.removeRow(0);
                    showfile(url1);
                }
            }
        } 
	else if(actionevent.getSource() == i10)
        {
            int l = JOptionPane.showConfirmDialog(null, "Sure to exit", "PowerZip 1.0", 0);
            if(l == 0)
                System.exit(0);
            if(l != 1);
        } 
	else if(actionevent.getSource() == i6)
        {
            RenameArchive renamearchive = new RenameArchive();
            renamearchive.setSize(200, 200);
            renamearchive.setLocation(100, 50);
            renamearchive.setVisible(true);
        } 
	else if(actionevent.getSource() == i26)
        {
            about about1 = new about();
            about1.setSize(500, 400);
            about1.setLocation(100, 50);
            about1.setVisible(true);
        } 
	else if(actionevent.getSource() == i27)
        {
            help help1 = new help();
            help1.setSize(500, 400);
            help1.setLocation(50, 50);
            help1.setVisible(true);
        } 
	else if(actionevent.getSource() == i4)
        {
            MoveArchive movearchive = new MoveArchive();
            movearchive.setSize(350, 200);
            movearchive.setLocation(50, 50);
            movearchive.setVisible(true);
        } 
	else if(actionevent.getSource() == i5)
        {
            CopyArchive copyarchive = new CopyArchive();
            copyarchive.setSize(350, 200);
            copyarchive.setLocation(50, 50);
            copyarchive.setVisible(true);
        } 
	else if(actionevent.getSource() == i7)
        {
            DeleteArchive deletearchive = new DeleteArchive();
            deletearchive.setSize(350, 150);
            deletearchive.setLocation(50, 50);
            deletearchive.setVisible(true);
        } 
	else if(actionevent.getSource() == i3)
        {
            i3.setEnabled(false);
            i9.setEnabled(false);
            i11.setEnabled(false);
            i12.setEnabled(false);
            i13.setEnabled(false);
            i17.setEnabled(false);
            i19.setEnabled(false);
            i20.setEnabled(false);
            i22.setEnabled(false);
            i24.setEnabled(false);
            addButton.setEnabled(false);
            extractButton.setEnabled(false);
            deleteButton.setEnabled(false);
            l2.setText(null);
            int j1;
            while((j1 = dm.getRowCount()) != 0) 
                dm.removeRow(0);
        } 
	else if(actionevent.getSource() == i11)
            tl.selectAll();
        else if(actionevent.getSource() == i12)
            tl.clearSelection();
        else if(actionevent.getSource() == i13)
        {
            int ai[] = tl.getSelectedRows();
            tl.selectAll();
            for(int j3 = 0; j3 < ai.length; j3++)
                tl.removeRowSelectionInterval(ai[j3], ai[j3]);

        } 
	else if(actionevent.getSource() == i9)
        {
            int k1 = fc1.showSaveDialog(null);
            if(k1 == 0)
            {
                String s1 = fc1.getSelectedFile().getPath();
                String s2 = s1.substring(s1.length() - 4, s1.length());
                if(!s2.equals(".zip"))
                    s1 = (new StringBuilder()).append(s1).append(".zip").toString();
                File file1 = new File(s1);
                File file2 = new File((new StringBuilder()).append(file1.getParent()).append("\\").toString());
                File file3 = new File(nurl);
                String s4 = file1.getName();
                SaveAs saveas = new SaveAs(s4, file3, file2);
            }
        }
	else if(actionevent.getSource() == i24_1 || actionevent.getSource() == i24_2 || actionevent.getSource() == i24_3)
        {
            if(actionevent.getSource() == i24_1)
                openWithChoice = 1;
            else if(actionevent.getSource() == i24_2)
                openWithChoice = 2;
            else if(actionevent.getSource() == i24_3)
                openWithChoice = 3;
            if(tl.getSelectedRowCount() == 0)
                JOptionPane.showMessageDialog((Container)null, "Select a file to open", "PowerZip 1.0", 0);
            else if(tl.getSelectedRowCount() >= 2)
            {
                JOptionPane.showMessageDialog((Container)null, "MultiSelection not allowed", "PowerZip 1.0", 0);
            }
   	    else
            {
                ex = new extract(true);
                ex.setSize(300, 200);
                ex.setLocation(150, 150);
                ex.show();
            }
        } 
	else if(actionevent.getSource() == i17)
        {
            Find find = new Find(tl);
            find.setSize(100, 200);
            find.setLocation(150, 150);
            find.show();
        } 
	else if(actionevent.getSource() == i25_3)
        {
            lnf = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
            setLookAndFeel();
        } 
	else if(actionevent.getSource() == i25_1)
        {
            lnf = "javax.swing.plaf.metal.MetalLookAndFeel";
            setLookAndFeel();
        } 
	else if(actionevent.getSource() == i25_2)
        {
            lnf = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
            setLookAndFeel();
        }
    }

    public void setLookAndFeel()
    {
        try
        {
            UIManager.setLookAndFeel(lnf);
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception exception)
        {
            JOptionPane.showMessageDialog(null, (new StringBuilder()).append("").append(exception).toString());
        }
    }

    public String javToDos(long l)
    {
        Date date = new Date(l);
        int i = date.getYear() + 1900;
        int j = date.getMonth() + 1;
        int k = date.getDate();
        int j1 = date.getHours();
        int k1 = date.getMinutes();
        int j2 = date.getSeconds();
        String s = (new StringBuilder()).append(String.valueOf(k)).append("/").append(String.valueOf(j)).append("/").append(String.valueOf(i)).append(" ").append(String.valueOf(j1)).append(":").append(String.valueOf(k1)).toString();
        return s;
    }

    public String formatt(String s)
    {
        StringBuffer stringbuffer = new StringBuffer(s);
        int i = stringbuffer.length();
        for(i -= 3; i > 0; i -= 3)
            stringbuffer.insert(i, ',');

        return new String(stringbuffer);
    }

    JButton newButton;
    JButton openButton;
    JButton addButton;
    JButton extractButton;
    JButton deleteButton;
    
    JMenuBar mb;
    JScrollPane sp;
    JMenu m1;
    JMenu m2;
    JMenu m3;
    JMenu m4;
    JMenu m5;
    JMenu i25;
    JMenu i24;
    JMenuItem i1;
    JMenuItem i2;
    JMenuItem i3;
    JMenuItem i4;
    JMenuItem i5;
    JMenuItem i6;
    JMenuItem i7;
    JMenuItem i8;
    JMenuItem i9;
    JMenuItem i10;
    JMenuItem iii;
    JMenuItem i11;
    JMenuItem i12;
    JMenuItem i13;
    JMenuItem i14;
    JMenuItem i15;
    JMenuItem i16;
    JMenuItem i17;
    JMenuItem i19;
    JMenuItem i20;
 
    JMenuItem i22;
 
    JMenuItem i26;
    JMenuItem i27;
    JMenuItem i24_1;
    JMenuItem i24_2;
    JMenuItem i24_3;
    JRadioButtonMenuItem i25_1;
    JRadioButtonMenuItem i25_2;
    JRadioButtonMenuItem i25_3;
    JTable tl;
    JTable t2;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JTextField tf1;
    JPanel p1;
    JPanel p2;
    JPanel px;
    DefaultTableModel dm;
    JFileChooser fc1;
    JFileChooser fc2;
    JDesktopPane dpan;
    extract ex;
    add ad;
    String url;
    String url1;
    String nurl;
    String curfile;
    String lnf;
    Hashtable ht;
    Random rndm;
    String st[];
    int fcount;
    float fsize;
    byte tmpbuf[];
    boolean newstate;
    boolean openstate;
    boolean addzipstate;
    Container c;
    JFrame frame;
    ButtonGroup lookAndFeelButtonGroup;
    String pathOpenWith;
    int openWithChoice;
    JToolBar tb;
    static String metal = "Metal";
    static String metalClassName = "javax.swing.plaf.metal.MetalLookAndFeel";
    static String motif = "Motif";
    static String motifClassName = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
    static String windows = "Windows";
    static String windowsClassName = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

}

