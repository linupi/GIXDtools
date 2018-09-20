import java.util.ArrayList;
import java.io.*;
import org.apache.commons.math3.distribution.UniformRealDistribution;
/**
 * Write a description of class UnitCellList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UnitCellList
{
    // instance variables - replace the example below with your own
    private ArrayList myList;
    private double aMin;
    private double aMax;
    private int Na;
    private double bMin;
    private double bMax;
    private int Nb;
    private double cMin;
    private double cMax;
    private int Nc;
    private double alphaMin;
    private double alphaMax;
    private int Nalpha;
    private double betaMin;
    private double betaMax;
    private int Nbeta;
    private double gammaMin;
    private double gammaMax;
    private int Ngamma;
    /*
    private long ia;
    private long ib;
    private long ic;
    private long ialpha;
    private long ibeta;
    private long igamma;
*/
    /**
     * Constructor for objects of class UnitCellList
     */
    public UnitCellList()
    {
        // initialise instance variables
        myList = new ArrayList();
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    
    
    /*
    public void addRange1(double aMin,double aMax, int Na,double bMin,double bMax, int Nb,double cMin,double cMax, int Nc,double alphaMin,double alphaMax, int Nalpha,double betaMin,double betaMax, int Nbeta,double gammaMin,double gammaMax, int Ngamma)
    {
        // put your code here
        for(int ia=0;ia<Na;ia++)
        {
            double a=(aMax-aMin)/Na*ia+aMin;
            for(int ib=0;ib<Nb;ib++)
            {
                double b=(bMax-bMin)/Nb*ib+bMin;
                for(int ic=0;ic<Nc;ic++)
                {
                    double c=(cMax-cMin)/Nc*ic+cMin;
                    for(int ialpha=0;ialpha<Nalpha;ialpha++)
                    {
                        double alpha=(alphaMax-alphaMin)/Nalpha*ialpha+alphaMin;
                        for(int ibeta=0;ibeta<Nbeta;ibeta++)
                        {
                            double beta=(betaMax-betaMin)/Nbeta*ibeta+betaMin;
                            for(int igamma=0;igamma<Ngamma;igamma++)
                            {
                                double gamma=(gammaMax-gammaMin)/Ngamma*igamma+gammaMin;
                                add(new UnitCell(a , b , c, alpha , beta , gamma));
                            }
                        }
                    }
                }
            }
        }
    }
    */
   public   UnitCellList(BufferedReader cellFileReader,PrintWriter statusWriter)
    {  int samplesize;
       int dim;
       DoubleArrayList  unva;
       DoubleArrayList  usca;
       DoubleArrayList  pvla;
       DoubleArrayList  unvb;
       DoubleArrayList  uscb;
       DoubleArrayList  pvlb;
       DoubleArrayList  unvc;
       DoubleArrayList  uscc;
       DoubleArrayList  pvlc;
       DoubleArrayList  unvalpha;
       DoubleArrayList  uscalpha;
       DoubleArrayList  pvlalpha;
       DoubleArrayList  unvbeta;
       DoubleArrayList  uscbeta;
       DoubleArrayList  pvlbeta;
       DoubleArrayList  unvgamma;
       DoubleArrayList  uscgamma;
       DoubleArrayList  pvlgamma;
       
       try{        
        aMin=Double.parseDouble((cellFileReader.readLine()).split("=")[1]);
        aMax=Double.parseDouble((cellFileReader.readLine()).split("=")[1]);
        Na=Integer.parseInt((cellFileReader.readLine()).split("=")[1]);
        //Na=20;
        bMin=Double.parseDouble((cellFileReader.readLine()).split("=")[1]);
        bMax=Double.parseDouble((cellFileReader.readLine()).split("=")[1]);
        Nb=Integer.parseInt((cellFileReader.readLine()).split("=")[1]);
        //Nb=20;
        cMin=Double.parseDouble((cellFileReader.readLine()).split("=")[1]);
        cMax=Double.parseDouble((cellFileReader.readLine()).split("=")[1]);
        Nc=Integer.parseInt((cellFileReader.readLine()).split("=")[1]);
        //Nc=20;
        alphaMin=Double.parseDouble((cellFileReader.readLine()).split("=")[1]);
        alphaMax=Double.parseDouble((cellFileReader.readLine()).split("=")[1]);
        Nalpha=Integer.parseInt((cellFileReader.readLine()).split("=")[1]);
        //Nalpha=20;
        betaMin=Double.parseDouble((cellFileReader.readLine()).split("=")[1]);
        betaMax=Double.parseDouble((cellFileReader.readLine()).split("=")[1]);
        Nbeta=Integer.parseInt((cellFileReader.readLine()).split("=")[1]);
        //Nbeta=20;
        gammaMin=Double.parseDouble((cellFileReader.readLine()).split("=")[1]);
        gammaMax=Double.parseDouble((cellFileReader.readLine()).split("=")[1]);
        Ngamma=Integer.parseInt((cellFileReader.readLine()).split("=")[1]);
        //Ngamma=20;
        statusWriter.println("aMin="+aMin);
        statusWriter.println("aMax="+aMax);
        statusWriter.println("Na="+Na);
        statusWriter.println("bMin="+bMin);
        statusWriter.println("bMax="+bMax);
        statusWriter.println("Nb="+Nb);
        statusWriter.println("cMin="+cMin);
        statusWriter.println("cMax="+cMax);
        statusWriter.println("Nc="+Nc);
        statusWriter.println("alphaMin="+alphaMin);
        statusWriter.println("alphaMax="+alphaMax);
        statusWriter.println("Nalpha="+Nalpha);
        statusWriter.println("betaMin="+betaMin);
        statusWriter.println("betaMax="+betaMax);
        statusWriter.println("Nbeta="+Nbeta);
        statusWriter.println("gammaMin="+gammaMin);
        statusWriter.println("gammaMax="+gammaMax);
        statusWriter.println("Ngamma="+Ngamma);
        statusWriter.flush();
        
        }catch (Exception e){e.printStackTrace();}
        
        myList = new ArrayList();
       
       //System.out.println("addRange: Na :"+Na);
       samplesize=Na;
       dim=6;
       UniformRealDistribution d=new UniformRealDistribution(0,1);//for all uniformDistributed random variates 
       unva= new DoubleArrayList(d,samplesize); //List of uniformDistributed random variates a samplesize
         usca=new DoubleArrayList();//Apply LHC
         new DoubleArrayList(unva,usca);
         pvla=new DoubleArrayList();//Obtain the LHC using inverse CDF
         UniformRealDistribution adist=new UniformRealDistribution(aMin,aMax);
         new DoubleArrayList(adist,usca,pvla);
           //System.out.println("pvla");
           //pvla.ausgeben();
         // b //
         unvb= new DoubleArrayList(d,samplesize); //List of uniformDistributed random variates b  samplesize 
         uscb=new DoubleArrayList();//Apply LHC
         new DoubleArrayList(unvb,uscb);
         pvlb=new DoubleArrayList();//Obtain the LHC using inverse CDF
         UniformRealDistribution bdist=new UniformRealDistribution(bMin,bMax);
         new DoubleArrayList(bdist,uscb,pvlb);
           //System.out.println("pvlb");
           //pvlb.ausgeben();
         // c //
         unvc= new DoubleArrayList(d,samplesize); //List of uniformDistributed random variates c samplesize 
         uscc=new DoubleArrayList();//Apply LHC
         new DoubleArrayList(unvc,uscc);
         pvlc=new DoubleArrayList();//Obtain the LHC using inverse CDF
         UniformRealDistribution cdist=new UniformRealDistribution(cMin,cMax);
         new DoubleArrayList(cdist,uscc,pvlc);
           //System.out.println("pvlc");
           //pvlc.ausgeben();
         // alpha //
         unvalpha= new DoubleArrayList(d,samplesize); //List of uniformDistributed random variates alpha samplesize 
         //System.out.println("unvalpha");
         //unvalpha.ausgeben();
         uscalpha=new DoubleArrayList();//Apply LHC
         new DoubleArrayList(unvalpha,uscalpha);
         //System.out.println("uscalpha");
         //uscalpha.ausgeben();
         pvlalpha=new DoubleArrayList();//Obtain the LHC using inverse CDF
         UniformRealDistribution alphadist=new UniformRealDistribution(alphaMin,alphaMax);
         new DoubleArrayList(alphadist,uscalpha,pvlalpha);
         //System.out.println("pvlalpha");
         //pvlalpha.ausgeben();
         // beta //
         unvbeta= new DoubleArrayList(d,samplesize); //List of uniformDistributed random variates beta samplesize 
         //System.out.println("unvbeta");
         //unvbeta.ausgeben();
         uscbeta=new DoubleArrayList();//Apply LHC
         new DoubleArrayList(unvbeta,uscbeta);
         //System.out.println("uscbeta");
         //uscbeta.ausgeben();
         pvlbeta=new DoubleArrayList();//Obtain the LHC using inverse CDF
         UniformRealDistribution betadist=new UniformRealDistribution(betaMin,betaMax);
         new DoubleArrayList(betadist,uscbeta,pvlbeta);
         //System.out.println("pvlbeta");
         //pvlbeta.ausgeben(); 
         // gamma //
         unvgamma= new DoubleArrayList(d,samplesize); //List of uniformDistributed random variates gamma samplesize 
         //System.out.println("unvgamma");
         //unvgamma.ausgeben();
         uscgamma=new DoubleArrayList();//Apply LHC
         new DoubleArrayList(unvgamma,uscgamma);
         //System.out.println("uscgamma");
        //uscgamma.ausgeben();
         pvlgamma=new DoubleArrayList();//Obtain the LHC using inverse CDF
         UniformRealDistribution gammadist=new UniformRealDistribution(gammaMin,gammaMax);
         new DoubleArrayList(gammadist,uscgamma,pvlgamma);
         //System.out.println("pvlgamma");
        // pvlgamma.ausgeben();
         
        SimpleLH simpleLH= new SimpleLH(samplesize,dim); //
        //simpleLH.ausgeben();
        
        for (int i=0;i<samplesize;i++)
        
        {  UnitCell  unitCell =new  UnitCell(
            (double)pvla.get(simpleLH.getElement(i,0)),
            (double)pvlb.get(simpleLH.getElement(i,1)),
            (double)pvlc.get(simpleLH.getElement(i,2)),
            (double)pvlalpha.get(simpleLH.getElement(i,3)),
            (double)pvlbeta.get(simpleLH.getElement(i,4)),
            (double)pvlgamma.get(simpleLH.getElement(i,5)));
           //unitCell.ausgeben();
           add(unitCell);
        }
        
    }
    public void addRange(double aMin,double aMax, int Na,double bMin,double bMax, int Nb,double cMin,double cMax, int Nc,double alphaMin,double alphaMax, int Nalpha,double betaMin,double betaMax, int Nbeta,double gammaMin,double gammaMax, int Ngamma)
    {  int samplesize=Na;
       int dim=6;
       DoubleArrayList  unva;
       DoubleArrayList  usca;
       DoubleArrayList  pvla;
       DoubleArrayList  unvb;
       DoubleArrayList  uscb;
       DoubleArrayList  pvlb;
       DoubleArrayList  unvc;
       DoubleArrayList  uscc;
       DoubleArrayList  pvlc;
       DoubleArrayList  unvalpha;
       DoubleArrayList  uscalpha;
       DoubleArrayList  pvlalpha;
       DoubleArrayList  unvbeta;
       DoubleArrayList  uscbeta;
       DoubleArrayList  pvlbeta;
       DoubleArrayList  unvgamma;
       DoubleArrayList  uscgamma;
       DoubleArrayList  pvlgamma;
       //System.out.println("addRange: Na :"+Na);
       UniformRealDistribution d=new UniformRealDistribution(0,1);//for all uniformDistributed random variates 
       unva= new DoubleArrayList(d,samplesize); //List of uniformDistributed random variates a samplesize
         usca=new DoubleArrayList();//Apply LHC
         new DoubleArrayList(unva,usca);
         pvla=new DoubleArrayList();//Obtain the LHC using inverse CDF
         UniformRealDistribution adist=new UniformRealDistribution(aMin,aMax);
         new DoubleArrayList(adist,usca,pvla);
           //System.out.println("pvla");
           //pvla.ausgeben();
         // b //
         unvb= new DoubleArrayList(d,samplesize); //List of uniformDistributed random variates b  samplesize 
         uscb=new DoubleArrayList();//Apply LHC
         new DoubleArrayList(unvb,uscb);
         pvlb=new DoubleArrayList();//Obtain the LHC using inverse CDF
         UniformRealDistribution bdist=new UniformRealDistribution(bMin,bMax);
         new DoubleArrayList(bdist,uscb,pvlb);
           //System.out.println("pvlb");
           //pvlb.ausgeben();
         // c //
         unvc= new DoubleArrayList(d,samplesize); //List of uniformDistributed random variates c samplesize 
         uscc=new DoubleArrayList();//Apply LHC
         new DoubleArrayList(unvc,uscc);
         pvlc=new DoubleArrayList();//Obtain the LHC using inverse CDF
         UniformRealDistribution cdist=new UniformRealDistribution(cMin,cMax);
         new DoubleArrayList(cdist,uscc,pvlc);
           //System.out.println("pvlc");
           //pvlc.ausgeben();
         // alpha //
         unvalpha= new DoubleArrayList(d,samplesize); //List of uniformDistributed random variates alpha samplesize 
         //System.out.println("unvalpha");
         //unvalpha.ausgeben();
         uscalpha=new DoubleArrayList();//Apply LHC
         new DoubleArrayList(unvalpha,uscalpha);
         //System.out.println("uscalpha");
         //uscalpha.ausgeben();
         pvlalpha=new DoubleArrayList();//Obtain the LHC using inverse CDF
         UniformRealDistribution alphadist=new UniformRealDistribution(alphaMin,alphaMax);
         new DoubleArrayList(alphadist,uscalpha,pvlalpha);
         //System.out.println("pvlalpha");
         //pvlalpha.ausgeben();
         // beta //
         unvbeta= new DoubleArrayList(d,samplesize); //List of uniformDistributed random variates beta samplesize 
         //System.out.println("unvbeta");
         //unvbeta.ausgeben();
         uscbeta=new DoubleArrayList();//Apply LHC
         new DoubleArrayList(unvbeta,uscbeta);
         //System.out.println("uscbeta");
         //uscbeta.ausgeben();
         pvlbeta=new DoubleArrayList();//Obtain the LHC using inverse CDF
         UniformRealDistribution betadist=new UniformRealDistribution(betaMin,betaMax);
         new DoubleArrayList(betadist,uscbeta,pvlbeta);
         //System.out.println("pvlbeta");
         //pvlbeta.ausgeben(); 
         // gamma //
         unvgamma= new DoubleArrayList(d,samplesize); //List of uniformDistributed random variates gamma samplesize 
         //System.out.println("unvgamma");
         //unvgamma.ausgeben();
         uscgamma=new DoubleArrayList();//Apply LHC
         new DoubleArrayList(unvgamma,uscgamma);
         //System.out.println("uscgamma");
        //uscgamma.ausgeben();
         pvlgamma=new DoubleArrayList();//Obtain the LHC using inverse CDF
         UniformRealDistribution gammadist=new UniformRealDistribution(gammaMin,gammaMax);
         new DoubleArrayList(gammadist,uscgamma,pvlgamma);
         //System.out.println("pvlgamma");
         //pvlgamma.ausgeben();
         
        SimpleLH simpleLH= new SimpleLH(samplesize,dim); //
        //simpleLH.ausgeben();
        
        for (int i=0;i<samplesize;i++)
        
        {  UnitCell  unitCell =new  UnitCell(
            (double)pvla.get(simpleLH.getElement(i,0)),
            (double)pvlb.get(simpleLH.getElement(i,1)),
            (double)pvlc.get(simpleLH.getElement(i,2)),
            (double)pvlalpha.get(simpleLH.getElement(i,3)),
            (double)pvlbeta.get(simpleLH.getElement(i,4)),
            (double)pvlgamma.get(simpleLH.getElement(i,5)));
           //unitCell.ausgeben();
           add(unitCell);
        }
        
    }
    public void remove(int i)
    {
        myList.remove(i);
    }
    public void add(UnitCell u)
    {
        // put your code here
        myList.add(u);
    }
    public UnitCell get(int i)
    {
        // put your code here
        return (UnitCell) myList.get(i);
    }
    public int getSize()
    {
        return myList.size();
    }
}
