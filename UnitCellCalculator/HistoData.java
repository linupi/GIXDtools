import java.io.*;
import java.util.*;
/**
 * Write a description of class HistoData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HistoData
{
    // instance variables - replace the example below with your own
    public long[] counts;
    public double[] values;
    public double min;
    public double max;
    public int n;
    public double delta;

    /**
     * Constructor for objects of class HistoData
     */
    public HistoData(double min, double max, int n)
    {
        // initialise instance variables
        counts = new long[n+1];
        for(int i=0;i<n+1;i++)
            counts[i]=0;
        values = new double[n+1];
        this.n=n;
        this.min=min;
        this.max=max;
        delta=(max-min)/(double)(n);
        initValues();
    }
    
    public void initValues()
    {
        for(int i=0;i<n+1;i++)
            values[i]=delta*(double)i+min;
    }
    
    public void add(double value)
    {
        //System.out.println((int)Math.round((value-min)/delta));
        counts[(int)Math.round((value-min)/delta)]++;
    }

    public void save(String path)
    {
        try{
            FileWriter outFile = new FileWriter(path);
            PrintWriter outWriter = new PrintWriter(outFile);
            for(int i=0;i<n+1;i++)
                outWriter.println(values[i]+"\t"+counts[i]);
            outWriter.close();
            outFile.close();
        }catch (Exception e){e.printStackTrace();}
    }
}
