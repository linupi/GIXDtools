import java.io.*;
import java.util.*;

/**
 * Write a description of class Histographer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Histographer
{
    // instance variables - replace the example below with your own
    HistoData a;
    HistoData b;
    HistoData c;
    HistoData alpha;
    HistoData beta;
    HistoData gamma;
    
    /**
     * Constructor for objects of class Histographer
     */
    public Histographer(String[] args)
    {
        double min;
        double max;
        int n;
        try{
            FileInputStream runFile = new FileInputStream(args[0]+"/run.txt");
            DataInputStream runStream = new DataInputStream(runFile);
            BufferedReader runReader = new BufferedReader(new InputStreamReader(runStream));
            runReader.readLine(); // skip first four rows in run.txt
            runReader.readLine();
            runReader.readLine();
            runReader.readLine();
            runReader.readLine();
            
            min=Double.parseDouble((runReader.readLine()).split("=")[1]);
            max=Double.parseDouble((runReader.readLine()).split("=")[1]);
            n=Integer.parseInt((runReader.readLine()).split("=")[1]);    
	    n=30;  
            a=new HistoData(min,max,n);
            
            min=Double.parseDouble((runReader.readLine()).split("=")[1]);
            max=Double.parseDouble((runReader.readLine()).split("=")[1]);
	    n=Integer.parseInt((runReader.readLine()).split("=")[1]);  
            n=30;  //   
            b=new HistoData(min,max,n);
            
            min=Double.parseDouble((runReader.readLine()).split("=")[1]);
            max=Double.parseDouble((runReader.readLine()).split("=")[1]);
	    n=Integer.parseInt((runReader.readLine()).split("=")[1]); 
            n=30; //    
            c=new HistoData(min,max,n);
            
            min=Double.parseDouble((runReader.readLine()).split("=")[1]);
            max=Double.parseDouble((runReader.readLine()).split("=")[1]);
	    n=Integer.parseInt((runReader.readLine()).split("=")[1]); 
            n=30; //    
            alpha=new HistoData(min,max,n);
            
            min=Double.parseDouble((runReader.readLine()).split("=")[1]);
            max=Double.parseDouble((runReader.readLine()).split("=")[1]);
	    n=Integer.parseInt((runReader.readLine()).split("=")[1]);
            n=30; //     
            beta=new HistoData(min,max,n);
            
            min=Double.parseDouble((runReader.readLine()).split("=")[1]);
            max=Double.parseDouble((runReader.readLine()).split("=")[1]);
	    n=Integer.parseInt((runReader.readLine()).split("=")[1]); 
            n=30; //    
            gamma=new HistoData(min,max,n);
            
            for(int i=2;i<args.length;i++)
            {
                FileInputStream myFile = new FileInputStream(args[0]+"/"+args[i]+".params");
                DataInputStream myStream = new DataInputStream(myFile);
                BufferedReader myReader = new BufferedReader(new InputStreamReader(myStream));
                
                myReader.readLine();//skip first row
                String strLine;
                while ((strLine = myReader.readLine()) != null)   { 
                     String[] cell=strLine.split("\t");
                     a.add(Double.parseDouble(cell[1]));
                     b.add(Double.parseDouble(cell[2]));
                     c.add(Double.parseDouble(cell[3]));
                     alpha.add(Double.parseDouble(cell[4]));
                     beta.add(Double.parseDouble(cell[5]));
                     gamma.add(Double.parseDouble(cell[6]));
                }
                myReader.close();
                myStream.close();
                myFile.close();
            }   
            a.save(args[0]+"/"+args[1]+"_a.txt");
            b.save(args[0]+"/"+args[1]+"_b.txt");
            c.save(args[0]+"/"+args[1]+"_c.txt");
            alpha.save(args[0]+"/"+args[1]+"_alpha.txt");
            beta.save(args[0]+"/"+args[1]+"_beta.txt");
            gamma.save(args[0]+"/"+args[1]+"_gamma.txt");
        }catch (Exception e){e.printStackTrace();}
    }

       // argumente: Verzeichnis Ziel-Prefix {quelldateien ohne .params}
        public static void main(String[] args)
    {
        new Histographer(args);
    }
}
