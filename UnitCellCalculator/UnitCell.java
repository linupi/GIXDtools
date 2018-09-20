//import java.lang.Math;
//import org.apache.commons.math3.distribution.UniformRealDistribution;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import Jama.*; 
/**
 * Write a description of class UnitCell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UnitCell
{
    // instance variables - replace the example below with your own
    public double a;
    public double b;
    public double c;
    public double alpha;
    public double beta;
    public double gamma;
    private Matrix UB;
    Vector3D a1;
    Vector3D a2;
    Vector3D a3;
    Vector3D a1_r;
    Vector3D a2_r;
    Vector3D a3_r;
    double volc;

    /**
     * Constructor for objects of class UnitCell
     */
    public UnitCell(double a, double b, double c, double alpha, double beta, double gamma)
    {
        // initialise instance variables
        this.a=a;
        this.b=b;
        this.c=c;
        this.alpha=alpha;
        this.beta=beta;
        this.gamma=gamma;
        a1=new Vector3D(a,0,0);
        a2=new Vector3D(b*Math.cos(gamma/180*Math.PI),b*Math.sin(gamma/180*Math.PI),0);
        double c1=c*Math.cos(beta/180*Math.PI);
        double c2=c*((Math.cos(alpha/180*Math.PI)-Math.cos(gamma/180*Math.PI)*Math.cos(beta/180*Math.PI))/Math.sin(gamma/180*Math.PI));
        double c3=Math.sqrt(c*c-c1*c1-c2*c2);
        a3=new Vector3D(c1,c2,c3);
        //volc =  np.dot(np.cross(a1,a2), a3 )
        Vector3D u=a1.crossProduct(a2);
        volc=a1.crossProduct(a2).dotProduct(a3);
        //a1_r = (2*np.pi*np.cross(a2,a3))/volc
        a1_r =(a2.crossProduct(a3)).scalarMultiply(2*Math.PI/volc) ;
        //a2_r = (2*np.pi*np.cross(a3,a1))/volc
        a2_r =(a3.crossProduct(a1)).scalarMultiply(2*Math.PI/volc) ;
        //a3_r = (2*np.pi*np.cross(a1,a2))/volc
        a3_r =(a1.crossProduct(a2)).scalarMultiply(2*Math.PI/volc) ;
    }
    public void ausgeben()
    { System.out.println("UnitCell: a="+this.a+" b="+this.b+" c="+this.c+" alpha="+this.alpha+" beta="+this.beta+" gamma="+this.gamma);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public double[] calcQ(hkl myhkl)
    { //q = h*a1_r + k*a2_r + l* a3_r
        Vector3D q=((a1_r.scalarMultiply(myhkl.h)).add(myhkl.k,a2_r)).add(myhkl.l,a3_r); 
        return q.toArray();
       
    }

}
