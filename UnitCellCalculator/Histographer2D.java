import java.io.*;
import java.util.*;

/**
 * Write a description of class Histographer2D here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Histographer2D
{
    // instance variables - replace the example below with your own
    HistoData2D ab;
    HistoData2D ac;
    HistoData2D aalpha;
    HistoData2D abeta;
    HistoData2D agamma;
    HistoData2D bc;
    HistoData2D balpha;
    HistoData2D bbeta;
    HistoData2D bgamma;
    HistoData2D calpha;
    HistoData2D cbeta;
    HistoData2D cgamma;
    HistoData2D alphabeta;
    HistoData2D alphagamma;
    HistoData2D betagamma;
    /**
     * Constructor for objects of class Histographer2D
     */
    public Histographer2D(String[] args)
    {
        double[] min = new double [6];
        double[] max = new double [6];
        int[] n=new int[6];
        try{
            FileInputStream runFile = new FileInputStream(args[0]+"/run.txt");
            DataInputStream runStream = new DataInputStream(runFile);
            BufferedReader runReader = new BufferedReader(new InputStreamReader(runStream));
            runReader.readLine(); // skip first four rows in run.txt
            runReader.readLine();
            runReader.readLine();
            runReader.readLine();
            runReader.readLine();
            
            min[0]=Double.parseDouble((runReader.readLine()).split("=")[1]);
            max[0]=Double.parseDouble((runReader.readLine()).split("=")[1]);
            n[0]=Integer.parseInt((runReader.readLine()).split("=")[1]);     
            
            min[1]=Double.parseDouble((runReader.readLine()).split("=")[1]);
            max[1]=Double.parseDouble((runReader.readLine()).split("=")[1]);
            n[1]=Integer.parseInt((runReader.readLine()).split("=")[1]);     
            
            min[2]=Double.parseDouble((runReader.readLine()).split("=")[1]);
            max[2]=Double.parseDouble((runReader.readLine()).split("=")[1]);
            n[2]=Integer.parseInt((runReader.readLine()).split("=")[1]);     
            
            min[3]=Double.parseDouble((runReader.readLine()).split("=")[1]);
            max[3]=Double.parseDouble((runReader.readLine()).split("=")[1]);
            n[3]=Integer.parseInt((runReader.readLine()).split("=")[1]);     
            
            min[4]=Double.parseDouble((runReader.readLine()).split("=")[1]);
            max[4]=Double.parseDouble((runReader.readLine()).split("=")[1]);
            n[4]=Integer.parseInt((runReader.readLine()).split("=")[1]);     
            
            min[5]=Double.parseDouble((runReader.readLine()).split("=")[1]);
            max[5]=Double.parseDouble((runReader.readLine()).split("=")[1]);
            n[5]=Integer.parseInt((runReader.readLine()).split("=")[1]);     
            
             ab=new HistoData2D(min[0],max[0],n[0],min[1],max[1],n[1]);   
             ac=new HistoData2D(min[0],max[0],n[0],min[2],max[2],n[2]);
             aalpha=new HistoData2D(min[0],max[0],n[0],min[3],max[3],n[3]);
             abeta=new HistoData2D(min[0],max[0],n[0],min[4],max[4],n[4]);
             agamma=new HistoData2D(min[0],max[0],n[0],min[5],max[5],n[5]);   
             bc=new HistoData2D(min[1],max[1],n[1],min[2],max[2],n[2]);  
             balpha=new HistoData2D(min[1],max[1],n[1],min[3],max[3],n[3]);
             bbeta=new HistoData2D(min[1],max[1],n[1],min[4],max[4],n[4]);
             bgamma=new HistoData2D(min[1],max[1],n[1],min[5],max[5],n[5]);
             calpha=new HistoData2D(min[2],max[2],n[2],min[3],max[3],n[3]);
             cbeta=new HistoData2D(min[2],max[2],n[2],min[4],max[4],n[4]);
             cgamma=new HistoData2D(min[2],max[2],n[2],min[5],max[5],n[5]);
             alphabeta=new HistoData2D(min[3],max[3],n[3],min[4],max[4],n[4]);
             alphagamma=new HistoData2D(min[3],max[3],n[3],min[5],max[5],n[5]);
             betagamma=new HistoData2D(min[4],max[4],n[4],min[5],max[5],n[5]);
            
            for(int i=2;i<args.length;i++)
            {
                FileInputStream myFile = new FileInputStream(args[0]+"/"+args[i]+".params");
                DataInputStream myStream = new DataInputStream(myFile);
                BufferedReader myReader = new BufferedReader(new InputStreamReader(myStream));
                
                myReader.readLine();//skip first row
                String strLine;
                double a,b,c,alpha,beta,gamma;
                while ((strLine = myReader.readLine()) != null)   { 
                     String[] cell=strLine.split("\t");
                     a=Double.parseDouble(cell[1]);
                     b=Double.parseDouble(cell[2]);
                     c=Double.parseDouble(cell[3]);
                     alpha=Double.parseDouble(cell[4]);
                     beta=Double.parseDouble(cell[5]);
                     gamma=Double.parseDouble(cell[6]);
                     ab.add(a,b);
                     ac.add(a,c);
                     aalpha.add(a,alpha);
                     abeta.add(a,beta);
                     agamma.add(a,gamma);
                     bc.add(b,c);
                     balpha.add(b,alpha);
                     bbeta.add(b,beta);
                     bgamma.add(b,gamma);
                     calpha.add(c,alpha);
                     cbeta.add(c,beta);
                     cgamma.add(c,gamma);
                     alphabeta.add(alpha,beta);
                     alphagamma.add(alpha,gamma);
                     betagamma.add(beta,gamma);

                 
                     
                }
                myReader.close();
                myStream.close();
                myFile.close();
            }   
            ab.save(args[0]+"/"+args[1]+"_ab.txt");
            ac.save(args[0]+"/"+args[1]+"_ac.txt");
            aalpha.save(args[0]+"/"+args[1]+"_aalpha.txt");
            abeta.save(args[0]+"/"+args[1]+"_abeta.txt");
            agamma.save(args[0]+"/"+args[1]+"_agamma.txt");
            bc.save(args[0]+"/"+args[1]+"_bc.txt");
            balpha.save(args[0]+"/"+args[1]+"_balpha.txt");
            bbeta.save(args[0]+"/"+args[1]+"_bbeta.txt");
            bgamma.save(args[0]+"/"+args[1]+"_bgamma.txt");
            calpha.save(args[0]+"/"+args[1]+"_calpha.txt");
            cbeta.save(args[0]+"/"+args[1]+"_cbeta.txt");
            cgamma.save(args[0]+"/"+args[1]+"_cgamma.txt");
            alphabeta.save(args[0]+"/"+args[1]+"_alphabeta.txt");
            alphagamma.save(args[0]+"/"+args[1]+"_alphagamma.txt");
            betagamma.save(args[0]+"/"+args[1]+"_betagamma.txt");
        }catch (Exception e){e.printStackTrace();}
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
        public static void main(String[] args)
    {
        new Histographer2D(args);
    }
}
