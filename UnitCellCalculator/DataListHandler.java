import java.io.*;
import java.util.*;

/**
 * Write a description of class Datahandler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DataListHandler
{
    // instance variables - replace the example below with your own
    
    /**
     * Constructor for objects of class Datahandler
     */
    public DataListHandler(String[] args)
    {
        hklList myhklList = new hklList();
        int lengthhklList=myhklList.getSize();
        try {
            if(!(new File(args[0]+"/"+args[1])).exists())
                (new File(args[0]+"/"+args[1])).mkdir();
            FileInputStream fstream = new FileInputStream(args[0]+"/"+args[1]+".params");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            br.readLine(); // skip first line
            while ((strLine = br.readLine()) != null)   {
                String[] values=strLine.split("\t");
                FileWriter outFile = new FileWriter(args[0]+"/"+args[1]+"/"+ values[0] + ".q");
                PrintWriter out = new PrintWriter(outFile);
                out.println("#h\tk\tl\tqPara\tqPerp\t");
                for(int j=0;j<lengthhklList;j++)
                {
                    hkl myhkl=myhklList.get(j);
                    UnitCell u= new UnitCell(Double.parseDouble(values[1]),Double.parseDouble(values[2]),Double.parseDouble(values[3]),Double.parseDouble(values[4]),Double.parseDouble(values[5]),Double.parseDouble(values[6]));
                    double[] res = u.calcQ(myhkl);
                    double qPara=Math.sqrt(res[0]*res[0]+res[1]*res[1]);
                    double qPerp=res[2];
                    out.println(myhkl.h + "\t" + myhkl.k  + "\t" + myhkl.l + "\t" + qPara + "\t" + qPerp );
                }
                out.close();
            }
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
        new DataListHandler(args);
    }
}
