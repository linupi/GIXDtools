import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Write a description of class Mask here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mask
{
    // instance variables - replace the example below with your own
     int qParaMinPx = 0;
     //int qParaMaxPx = 1251;//1166
     int qParaMaxPx = 1166;//1166
     int qPerpMinPx = 0;
    // int qPerpMaxPx = 501;//566
      int qPerpMaxPx = 566;//566
    
    //private static double qParaMinValue = 1;//0.3
    private static double qParaMinValue = 0.3;//0.3
    private static double qParaMaxValue = 3.5;//3.5
    //private static double qPerpMinValue = 0;//-0.0985
    private static double qPerpMinValue = -0.0985;//-0.0985
    //private static double qPerpMaxValue = 1;//1.7
    private static double qPerpMaxValue = 1.7;//1.7
    
    //private static double qPerpPerPx = 0.002;//0.003
    private static double qPerpPerPx = 0.003;//0.003
    //private static double qParaPerPx = 0.002;//0.003
    private static double qParaPerPx = 0.003;//0.003
    
    private static double qParaOffsetPx=qParaMinValue/qPerpPerPx;
    private static double qPerpOffsetPx=qPerpMinValue/qPerpPerPx;
    
    private BufferedImage img;

    /**
     * Constructor for objects of class Mask
     */
     public Mask()
     {
        }
    public Mask(String myMask)
    {
        // initialise instance variables
        try {
            img = ImageIO.read(new File(myMask));
            
            System.out.println(img.getWidth());
            System.out.println(img.getHeight());
             /*
            for(int i=0;i<10;i++)
            {
                for(int j=0;j<10;j++)
                {
                    int pixel = img.getRGB(j,i);
                    int alpha = (pixel >> 24) & 0xff;
                    System.out.print(alpha + " ");
                }
                System.out.println(" ");
            }
            */
            
        } catch (IOException e) {e.printStackTrace();}
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int getXpx(double qpara, double qperp)
    {
        return (int)((qpara/qParaPerPx)-qParaOffsetPx); 
    }
    public int getYpx(double qpara, double qperp)
    {
        // put your code here
        return  (qPerpMaxPx-1)-((int)((qperp/qPerpPerPx)-qPerpOffsetPx));
    }
    
    public double getMaskValue(double qpara, double qperp)
    {
        // put your code here
        int xPx = (int)((qpara/qParaPerPx)-qParaOffsetPx); 
        int yPx = (qPerpMaxPx-1)-((int)((qperp/qPerpPerPx)-qPerpOffsetPx));
        //System.out.println(xPx + " " + yPx + " " + qpara + " " + qperp);
        if(xPx>=0 && xPx<qParaMaxPx && yPx>=0 && yPx<qPerpMaxPx)
        {
            int pixel = img.getRGB(xPx,yPx);
            //System.out.println(xPx + " " +yPx);
            return (pixel >> 24) & 0xff;
        }
        else
            return 0;
    }
    public static void main(String[] args)
    {
        Mask mask=new Mask("metal_ptcdi_maske.png");
        
    }
}
