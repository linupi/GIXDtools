import java.io.*;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
/**
 * Write a description of class UnitCellCalculator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UnitCellCalculator
{
    // instance variables - replace the example below with your own
    private hklList myhklList;
    private UnitCellList myUnitCellList;
    //private UnitCellPsoudoStack myUnitCellPsoudoStack;
    private int lengthhklList;
    private long lengthUnitCellList;
    private Mask myMask;
    private int minSum=10;
    private int hitDiv=128;
    private int hitIncrement=4;
    private int resArrayListLength=100;
    private String maskPath;
    int maxsum;
    
    private FileInputStream cellFile;
    private DataInputStream cellStream;
    private BufferedReader cellFileReader;
    
    private FileWriter statusFile;
    private PrintWriter statusWriter;
    
    private double[] qPara;
    private double[] qPerp;
    
    private long startms;
    
    private ArrayList ucwl;
    
    /**
     * Constructor for objects of class UnitCellCalculator
     */
    public UnitCellCalculator(UnitCellList myUnitCellList,hklList myhklList)
    { this.myUnitCellList=myUnitCellList;
      this.myhklList= myhklList;
      this.lengthUnitCellList=myUnitCellList.getSize();
      this.lengthhklList=myhklList.getSize();
      qPara=new double[lengthhklList];
      qPerp=new double[lengthhklList];
    }
    public void unitCellCalculatorDemo()
     { for(int i=0;i<lengthUnitCellList;i++)
         { UnitCell u=myUnitCellList.get(i);
            for(int j=0;j<lengthhklList;j++)
            {
                hkl myhkl=myhklList.get(j);
                double[] res = u.calcQ(myhkl);
                qPara[j]=Math.sqrt(res[0]*res[0]+res[1]*res[1]);
                qPerp[j]=res[2];
                //sum += myMask.getMaskValue(qPara[j],qPerp[j])/hitDiv;
                //hier
                //System.out.println("hitDiv: "+hitDiv);
                System.out.println(myhkl.h + "\t" + myhkl.k  + "\t" + myhkl.l + "\t" + qPara[j] + "\t" + qPerp[j]);
            }
            }
     }
    public UnitCellCalculator(String configFile)
    {
        // initialise instance variables
        System.out.println("Welcome to UnitCellCalculator");
        init(configFile);
        run();
        finish();
    }

    private void init(String configFile)
    { 


        try{
            cellFile = new FileInputStream(configFile);
            cellStream = new DataInputStream(cellFile);
            cellFileReader = new BufferedReader(new InputStreamReader(cellStream));
            
            String r1=cellFileReader.readLine();
           
       
            cellFileReader.readLine(); //Trennzeile
            
            maskPath=(cellFileReader.readLine()).split("=")[1];
            myMask = new Mask("rawdata/"+maskPath);
            maskPath=maskPath.substring(0,maskPath.length()-4);
            if(!(new File(maskPath)).exists())
             (new File(maskPath)).mkdir();
             
            statusFile = new FileWriter(maskPath+"/run.txt");
            statusWriter = new PrintWriter(statusFile);
            statusWriter.println(r1);
            statusWriter.println("configfile="+configFile);
           
            statusWriter.println("mask="+maskPath);
            
            minSum=Integer.parseInt((cellFileReader.readLine()).split("=")[1]);
            statusWriter.println("minHit="+minSum);
            
            hitDiv=Integer.parseInt((cellFileReader.readLine()).split("=")[1]);
            statusWriter.println("hitDiv="+hitDiv);
            
            cellFileReader.readLine(); //Trennzeile
            
            statusWriter.flush();
        }catch (Exception e){e.printStackTrace();}
        

	Date startdate= new Date();


        myhklList = new hklList();
        lengthhklList=myhklList.getSize();
       // myUnitCellList = new UnitCellList();
       // myUnitCellPsoudoStack=new UnitCellPsoudoStack(9.21 , 4.86 , 21.58, 86.45 , 101.78 , 65.8,0.1,20,0.04,30); // 100°C manuelle startparameter
       // myUnitCellPsoudoStack=new UnitCellPsoudoStack(9.0 , 4.88 , 21.56, 85.88 , 101.37 , 66.11, 0.1,20,0.04,30); // 120°C manuelle startparameter
       // myUnitCellPsoudoStack=new UnitCellPsoudoStack(8.965 , 4.854 , 21.36, 85.52 , 101.04 , 65.8, 0.2,30,0.2,30); // 140°C manuelle startparameter
        //  myUnitCellList.addRange(9.0 , 4.89 , 21.65, 85 , 100.7 , 67.2,0.05,10);
       // myUnitCellList.add(new UnitCell(9.11 , 4.835 , 21.627, 85.047 , 101.41 , 67.41));
      //  lengthUnitCellList=myUnitCellList.getSize();
       // myUnitCellPsoudoStack=new UnitCellPsoudoStack(cellFileReader,statusWriter);
        myUnitCellList=new UnitCellList(cellFileReader,statusWriter);
        //lengthUnitCellList=myUnitCellPsoudoStack.length();
        lengthUnitCellList=myUnitCellList.getSize();
        qPara=new double[lengthhklList];
        qPerp=new double[lengthhklList];
        
        ucwl=new ArrayList();
        for(int i=0;i<resArrayListLength;i++) 
        {
            ucwl.add(new UnitCellWriter());
        }

	        System.out.println("Total runs to perfom: "+ lengthUnitCellList);
       
 	try{
            Date date= new Date();
            statusWriter.println("#*****************");
            statusWriter.println("lengthhklList: "+lengthhklList);
            statusWriter.println("tstart="+new Timestamp(date.getTime()));
            statusWriter.println("total_iterations="+lengthUnitCellList);
            startms=System.currentTimeMillis();
            statusWriter.flush();
        }catch (Exception e){e.printStackTrace();}
    }
    
    private void run()
    { 
        maxsum=minSum;
        long di=lengthUnitCellList/1000;
        if (di==0)
            di=1;
        //for(long i=0;i<lengthUnitCellList;i++)
        for(int i=0;i<lengthUnitCellList;i++)
        { //System.out.println("lengthUnitCellList: "+lengthUnitCellList);
            if((i+1)%di==0)
                 System.out.println("Run Nr. "+ i + " of " + lengthUnitCellList + " --> "+ i*100/lengthUnitCellList + "% done");
           UnitCell u=myUnitCellList.get(i);
            //UnitCell u=myUnitCellPsoudoStack.getNextUC();
            int sum=0;
            for(int j=0;j<lengthhklList;j++)
            {
                hkl myhkl=myhklList.get(j);
                double[] res = u.calcQ(myhkl);
                qPara[j]=Math.sqrt(res[0]*res[0]+res[1]*res[1]);
                qPerp[j]=res[2];
                sum += myMask.getMaskValue(qPara[j],qPerp[j])/hitDiv;
                //hier
                //System.out.println("hitDiv: "+hitDiv);
                //System.out.println(myhkl.h + "\t" + myhkl.k  + "\t" + myhkl.l + "\t" + qPara[j] + "\t" + qPerp[j]);
            }
            if(sum>maxsum)
            {
                maxsum=sum;
               // System.out.println("new max Hitsum: " + sum);
            }
            if(sum>=minSum && sum>maxsum-hitIncrement)
            {
              //  saveUnitCell( u, i,sum);
               // saveQ( i,sum);
            //  if(checkQ())
                saveUnitCellList( u,i,sum);
            }
         //   myUnitCellList.remove(0);
        }
        System.out.println("UnitCellCalculator done!");
    }
    
    private void finish()
    {
        for(int i=0;i<100;i++)
        {
            UnitCellWriter ucw = (UnitCellWriter)ucwl.get(i);
            if(ucw.exists)
                ucw.finish();
        }
        try{
            Date date= new Date();
            statusWriter.println("#*****************");
            statusWriter.println("tstop="+new Timestamp(date.getTime()));
            long stopms=System.currentTimeMillis();
            statusWriter.println("delta_t_h="+((double)(stopms-startms)/(1000.0*3600.0)));
            statusWriter.println("iterations_per_ms="+((double)lengthUnitCellList/(double)(stopms-startms)));
            statusWriter.println("minfullyCalcHitsum="+(maxsum-hitIncrement));
        }catch (Exception e){e.printStackTrace();}
        statusWriter.close();
    }
    
    private void saveUnitCellList(UnitCell u,long i,int sum)
    {
        UnitCellWriter ucw = (UnitCellWriter)ucwl.get(sum);
        if(!ucw.exists)
            ucw.init(maskPath,sum);
        ucw.write(u,i);
    }
    
    private void saveUnitCell(UnitCell u,long i,int sum)
    {
        try {
            if(!(new File(maskPath +"/"+ ((Integer)sum).toString())).exists())
                (new File(maskPath +"/"+ ((Integer)sum).toString())).mkdir();
            FileWriter outFile = new FileWriter(maskPath + "/" + sum + "/" + i + ".cell");
            PrintWriter out = new PrintWriter(outFile);
            
            // Also could be written as follows on one line
            // Printwriter out = new PrintWriter(new FileWriter(args[0]));
        
            // Write text to file
            out.println("a=\t"+u.a);
            out.println("b=\t"+u.b);
            out.println("c=\t"+u.c);
            out.println("alpha=\t"+u.alpha);
            out.println("beta=\t"+u.beta);
            out.println("gamma=\t"+u.gamma);
            out.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    private void saveQ(long i, int sum)
    {
        try {
            if(!(new File(maskPath +"/"+ ((Integer)sum).toString())).exists())
                (new File(maskPath +"/"+ ((Integer)sum).toString())).mkdir();
            FileWriter outFile = new FileWriter(maskPath + "/" + sum + "/" + i + ".q");
            PrintWriter out = new PrintWriter(outFile);
            
            // Also could be written as follows on one line
            // Printwriter out = new PrintWriter(new FileWriter(args[0]));
        
            // Write text to file
            out.println("#h\tk\tl\tqPara\tqPerp\t");
            for(int j=0;j<lengthhklList;j++)
            {
                hkl myhkl=myhklList.get(j);
                out.println(myhkl.h + "\t" + myhkl.k  + "\t" + myhkl.l + "\t" + qPara[j] + "\t" + qPerp[j] );
            }
            out.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
//     private boolean checkQ()
//     {
//         //Checks if the freshly calculated resultes are "good
//         if (Math.abs(qPerp[0]-qPerp[1])>0.055)
//             return true;
//         else
//             return false;
//     }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void main(String[] args)
    {
        new UnitCellCalculator(args[0]);
       //System.out.println(args[0]);
    }
}
