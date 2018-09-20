import java.io.*;
import java.util.*;
/**
 * Write a description of class HistoData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HistoData2D
{
    // instance variables - replace the example below with your own
    public long[][] counts;
    public double[] values1;
    public double[] values2;
    public double min1;
    public double max1;
    public int n1;
    public double delta1;
    public double min2;
    public double max2;
    public int n2;
    public double delta2;

    /**
     * Constructor for objects of class HistoData
     */
    public HistoData2D(double min1, double max1, int n1,double min2, double max2, int n2)
    {
        // initialise instance variables
        counts = new long[n1+1][n2+1];
        for(int i=0;i<n1+1;i++)
            for(int j=0;j<n2+1;j++)
                counts[i][j]=0;
        values1 = new double[n1+1];
        values2 = new double[n2+1];
        this.n1=n1;
        this.min1=min1;
        this.max1=max1;
        this.n2=n2;
        this.min2=min2;
        this.max2=max2;
        delta1=(max1-min1)/(double)(n1);
        delta2=(max2-min2)/(double)(n2);
        initValues();
    }
    
    public void initValues()
    {
        for(int i=0;i<n1+1;i++)
            values1[i]=delta1*(double)i+min1;
        for(int i=0;i<n2+1;i++)
            values2[i]=delta2*(double)i+min2;
    }
    
    public void add(double value1,double value2)
    {
        //System.out.println((int)Math.round((value-min)/delta));
        counts[(int)Math.round((value1-min1)/delta1)][(int)Math.round((value2-min2)/delta2)]++;
    }

    public void save(String path)
    {
        try{
            FileWriter outFile = new FileWriter(path);
            PrintWriter outWriter = new PrintWriter(outFile);
            for(int i=0;i<n1+1;i++)
            {
                for(int j=0;j<n2+1;j++)
                    outWriter.println(values1[i]+"\t"+values2[j]+"\t"+counts[i][j]);
                outWriter.println("");
            }
            outWriter.close();
            outFile.close();
        }catch (Exception e){e.printStackTrace();}
    }
}
