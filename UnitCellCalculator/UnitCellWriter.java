import java.io.*;

/**
 * Write a description of class UnitCellWriter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UnitCellWriter
{
    // instance variables - replace the example below with your own
    private FileWriter outFile;
    public PrintWriter out;
    boolean exists=false;
    private String path;
    private int sum;
    
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
     * Constructor for objects of class UnitCellWriter
       */
    
    public UnitCellWriter()
    {
        ;
    }
      
    public void init(String path ,int sum)
    {
        // initialise instance variables
        try {
            this.path=path;
            this.sum=sum;
            outFile = new FileWriter(path + "/" + sum + ".params");
            out = new PrintWriter(outFile);
            out.println("#runNr\ta\tb\tc\talpha\tbeta\tgamma");
            exists=true;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void write(UnitCell u, long run)
    {
        out.println(run+"\t"+u.a+"\t"+u.b+"\t"+u.c+"\t"+u.alpha+"\t"+u.beta+"\t"+u.gamma);
        if(u.a>aMax)
            aMax=u.a;
        if(u.a<aMin)
             aMin=u.a;
        if(u.b>bMax)
             bMax=u.b;
        if(u.b<bMin)
             bMin=u.b;
        if(u.c>cMax)
             cMax=u.c;
        if(u.c<cMin)
             cMin=u.c;
        if(u.alpha>alphaMax)
            alphaMax=u.alpha;
        if(u.alpha<alphaMin)
            alphaMin=u.alpha;
        if(u.beta>betaMax)
            betaMax=u.beta;
        if(u.beta<betaMin)
            betaMin=u.beta;
        if(u.gamma>gammaMax)
            gammaMax=u.gamma;
        if(u.gamma<gammaMin)
            gammaMin=u.gamma;
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    
    public void finish()
    {
        // initialise instance variables
        try {
            FileWriter outFile2 = new FileWriter(path + "/" + sum + ".minmax");
            PrintWriter out2 = new PrintWriter(outFile2);
            out2.println("aMin=\t"+aMin);
            out2.println("aMax=\t"+aMax);
            out2.println("bMin=\t"+bMin);
            out2.println("bMax=\t"+bMax);
            out2.println("cMin=\t"+cMin);
            out2.println("cMax=\t"+cMax);
            out2.println("alphaMin=\t"+alphaMin);
            out2.println("alphaMax=\t"+alphaMax);
            out2.println("betaMin=\t"+betaMin);
            out2.println("betaMax=\t"+betaMax);
            out2.println("gammaMin=\t"+gammaMin);
            out2.println("gammaMax=\t"+gammaMax);
            
            out2.close();
            out.close();
            exists=false;
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
