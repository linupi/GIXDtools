import java.io.*;
import java.util.*;

/**
 * Write a description of class Datahandler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Datahandler
{
    // instance variables - replace the example below with your own
    hkl cond1_hkl = new hkl(-1,0,1);
    hkl cond2_hkl = new hkl(1,0,0);
    double deltaCond = 0.05;
    boolean cond1Found = false;
    boolean cond2Found = false;
    double cond1Perp;
    double cond2Perp;
    PrintWriter minMaxFile;
    PrintWriter paramFile;
    double aMax=0;
    double aMin=1000;
    double bMax=0;
    double bMin=1000;
    double cMax=0;
    double cMin=1000;
    double alphaMax=0;
    double alphaMin=1000;
    double betaMax=0;
    double betaMin=1000;
    double gammaMax=0;
    double gammaMin=1000;
    
    /**
     * Constructor for objects of class Datahandler
     */
    public Datahandler(String[] args)
    {
        try {
            File dir = new File(args[0]+"/"+args[1]);
            if(!(new File(args[0]+"/"+args[1]+"/resultes")).exists())
                (new File(args[0]+"/"+args[1]+"/resultes")).mkdir();
            FileWriter minMaxWriter = new FileWriter(args[0]+"/"+args[1]+"/resultes/minmax.txt");
            minMaxFile = new PrintWriter(minMaxWriter);
            FileWriter paramWriter = new FileWriter(args[0]+"/"+args[1]+"/resultes/params.txt");
            paramFile = new PrintWriter(paramWriter);
            paramFile.println("#runNr\ta\tb\tc\talpha\tbeta\tgamma");
            String[] child = dir.list();
            for(int i=0;i<child.length;i++)
            {
                if(child[i].contains(".q"))
                {   
                    FileInputStream fstream = new FileInputStream(args[0]+"/"+args[1]+"/"+child[i]);
                    DataInputStream in = new DataInputStream(fstream);
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    String strLine;
                    br.readLine(); // skip first line
                    while ((strLine = br.readLine()) != null)   {
                        // Print the content on the console
                       // System.out.println (strLine);
                       String[] values=strLine.split("\t");
                       if(Integer.parseInt(values[0])==cond1_hkl.h && Integer.parseInt(values[1])==cond1_hkl.k && Integer.parseInt(values[2])==cond1_hkl.l)
                       {
                          cond1Perp=Double.parseDouble(values[4]);
                          cond1Found=true;
                       } 
                       if(Integer.parseInt(values[0])==cond2_hkl.h && Integer.parseInt(values[1])==cond2_hkl.k && Integer.parseInt(values[2])==cond2_hkl.l)
                       {
                          cond2Perp=Double.parseDouble(values[4]);
                          cond2Found=true;
                       } 
                       if(cond1Found && cond2Found)
                        break;
                    }
                    in.close();
                    if(cond2Perp-cond1Perp>deltaCond)
                    {
                      //  System.out.println (cond2Perp-cond1Perp);
                        addToResults(args[0]+"/"+args[1]+"/",child[i]);
                    }
                }
            }
           
            minMaxFile.println("aMin=\t"+aMin);
            minMaxFile.println("aMax=\t"+aMax);
            minMaxFile.println("bMin=\t"+bMin);
            minMaxFile.println("bMax=\t"+bMax);
            minMaxFile.println("cMin=\t"+cMin);
            minMaxFile.println("cMax=\t"+cMax);
            minMaxFile.println("alphaMin=\t"+alphaMin);
            minMaxFile.println("alphaMax=\t"+alphaMax);
            minMaxFile.println("betaMin=\t"+betaMin);
            minMaxFile.println("betaMax=\t"+betaMax);
            minMaxFile.println("gammaMin=\t"+gammaMin);
            minMaxFile.println("gammaMax=\t"+gammaMax);
            
            minMaxFile.close();
            paramFile.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    void addToResults(String path ,String file)
    {
        try{
            String stringFN = file.substring(0,file.length()-2);
            System.out.println(stringFN);
            FileInputStream fstream = new FileInputStream(path+stringFN+".cell");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            double a=0;
            double b=0;
            double c=0;
            double alpha=0;
            double beta=0;
            double gamma=0;
            while ((strLine = br.readLine()) != null)   {   
                String[] values=strLine.split("=\t");
                //System.out.println(values[0]);
                if(values[0].equals("a"))
                {
                    a=Double.parseDouble(values[1]);
                    if(a>aMax)
                        aMax=a;
                    if(a<aMin)
                        aMin=a;
                }
                if(values[0].equals("b"))
                {
                    b=Double.parseDouble(values[1]);
                    if(b>bMax)
                        bMax=b;
                    if(b<bMin)
                        bMin=b;
                }
                if(values[0].equals("c"))
                {
                    c=Double.parseDouble(values[1]);
                    if(c>cMax)
                        cMax=c;
                    if(c<cMin)
                        cMin=c;
                }
                if(values[0].equals("alpha"))
                {
                    alpha=Double.parseDouble(values[1]);
                    if(alpha>alphaMax)
                        alphaMax=alpha;
                    if(alpha<alphaMin)
                        alphaMin=alpha;
                }
                if(values[0].equals("beta"))
                {
                    beta=Double.parseDouble(values[1]);
                    if(beta>betaMax)
                        betaMax=beta;
                    if(beta<betaMin)
                        betaMin=beta;
                }
                if(values[0].equals("gamma"))
                {
                    gamma=Double.parseDouble(values[1]);
                    if(gamma>gammaMax)
                        gammaMax=gamma;
                    if(gamma<gammaMin)
                        gammaMin=gamma;
                }
              
            }
            paramFile.println(stringFN+"\t"+a+"\t"+b+"\t"+c+"\t"+alpha+"\t"+beta+"\t"+gamma);
        } catch (Exception e){
            e.printStackTrace();  
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void main(String[] args)
    {
        new Datahandler(args);
    }
}
