import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

/**
 * Write a description of class DataListToImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DataListToImage
{
    // instance variables - replace the example below with your own
    /*
    private int qParaMinPx = 0;
    private int qParaMaxPx = 1251;
    private int qPerpMinPx = 0;
    private int qPerpMaxPx = 501;
    */
   private int qParaMinPx = 0;
    private int qParaMaxPx = 1251;
    private int qPerpMinPx = 0;
    private int qPerpMaxPx = 501;
    
    private static double qParaMinValue = 1;
    private static double qParaMaxValue = 3.5;
    private static double qPerpMinValue = 0;
    private static double qPerpMaxValue = 1;
    
    private static double qPerpPerPx = 0.002;
    private static double qParaPerPx = 0.002;
    
    //private static double qParaOffsetPx=qParaMinValue/qPerpPerPx;//so war es
    private static double qParaOffsetPx=qParaMinValue/qParaPerPx;
    //private static double qPerpOffsetPx=qParaMinValue/qPerpPerPx;// so war es
    private static double qPerpOffsetPx=qPerpMinValue/qPerpPerPx;
    
    /**
     * Constructor for objects of class DataListToImage
     */
    public DataListToImage(String[] args)
    {
        // initialise instance variables
        hklList myhklList = new hklList();
        int lengthhklList=myhklList.getSize();
        
        BufferedImage psImage = 
        new BufferedImage(qParaMaxPx,qPerpMaxPx,BufferedImage.TYPE_4BYTE_ABGR);
        WritableRaster raster = psImage.getRaster();
        
        try {
            FileInputStream fstream = new FileInputStream(args[0]+"/"+args[1]+".params");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine=null;
            br.readLine(); // skip first line
           
            while ((strLine = br.readLine()) != null)  
            { //System.out.println("strLine: "+strLine);
                String[] values=strLine.split("\t");
                //System.out.println("values:"+values[0]+" "+values[1]+" "+values[2]+" "+values[3]+" "+values[4]+" "+values[5]+" "+values[6]);
             //   FileWriter outFile = new FileWriter(args[0]+"/"+args[1]+"/"+ values[0] + ".q");
               // PrintWriter out = new PrintWriter(outFile);
               // out.println("#h\tk\tl\tqPara\tqPerp\t");
                for(int j=0;j<lengthhklList;j++)
                {  //System.out.println();
                    hkl myhkl=myhklList.get(j);
                    //myhkl.ausgeben();
                    UnitCell u= new UnitCell(Double.parseDouble(values[1]),Double.parseDouble(values[2]),Double.parseDouble(values[3]),Double.parseDouble(values[4]),Double.parseDouble(values[5]),Double.parseDouble(values[6]));
                   // u.ausgeben();
                    double[] res = u.calcQ(myhkl);
                    //System.out.println("res[0]="+res[0]+"res[1]="+res[1]+"res[2]="+res[2]);
                    double qpara=Math.sqrt(res[0]*res[0]+res[1]*res[1]);
                    //System.out.println("qpara="+qpara);
                    double qperp=res[2];
                    //System.out.println("qperp="+qperp);
                    int[] a={255,0,0,128};
                    int xPx = (int)((qpara/qParaPerPx)-qParaOffsetPx);               
                    int yPx = (qPerpMaxPx-1)-((int)((qperp/qPerpPerPx)-qPerpOffsetPx));
                    /*
                     System.out.println("xPx="+xPx);
                     System.out.println("yPx="+yPx);
                     System.out.println("qParaMinPx="+qParaMinPx);
                     System.out.println("qParaMaxPx="+qParaMaxPx);
                     System.out.println("qPerpMinPx="+qPerpMinPx);
                     System.out.println("qPerpMaxPx="+qPerpMaxPx);
                    */
                   // if(xPx>=qParaMinPx && yPx<qParaMaxPx && yPx>=qPerpMinPx && yPx<qPerpMaxPx) so war es
                    if(xPx>=qParaMinPx && xPx<qParaMaxPx && yPx>=qPerpMinPx && yPx<qPerpMaxPx)
                        raster.setPixel(xPx,yPx,a);
                       //System.out.println(xPx+ " "+ yPx);
                    
                    //out.println(myhkl.h + "\t" + myhkl.k  + "\t" + myhkl.l + "\t" + qPara + "\t" + qPerp );
                }
               // out.close();
            }
            ImageIO.write(psImage,"png",new File(args[0]+"/"+args[1]+"_directResults.png"));
            } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        new DataListToImage(args);
    }
}
