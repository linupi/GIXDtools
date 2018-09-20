import java.util.ArrayList;

import org.apache.commons.math3.distribution.UniformRealDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.WeibullDistribution;
/**
 * Write a description of class DoubleArrayList here.
 * 
 * @author (Linus Pithan) 
 * @version (a version number or a date)
 */
public class DoubleArrayList extends ArrayList
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class DoubleArrayList
     */
    public <Double>DoubleArrayList()
    {super();
        
    }
   public <Double> DoubleArrayList(UniformRealDistribution d,int sampleSize) 
    {   super();
        
        for (int i=0;i<sampleSize;i++)
        { 
            this.add(d.sample());
        }
       
    } 
    
    public <Double> DoubleArrayList(DoubleArrayList unv,DoubleArrayList usc) 
    {   int n= unv.size();
        double nn=(double)n;
        double x,y;
        for (int i=0;i<n;i++)
        { 
             x=(double)unv.get(i);        
             usc.add( x/n+i/nn);
        }
       
    }
    
    
    public <Double> DoubleArrayList(UniformRealDistribution idist,DoubleArrayList usc,DoubleArrayList pvl) 
    {   super();
        double x,y;
        int n= usc.size();
        for (int i=0;i<n;i++)
        {    x=(double) usc.get(i); 
             pvl.add(idist.inverseCumulativeProbability(x));
         }
       
    }

     
    public void ausgeben()
    { int n= this.size();
        
       for (int i=0;i<n;i++)
       {   
         System.out.println("i="+i+" "+this.get(i));
        }
        
    }
}
