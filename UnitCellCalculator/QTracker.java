import java.io.*;
import java.util.*;
/**
 * Write a description of class QTracker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QTracker
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class QTracker
     */
    public QTracker(String[] args)
    {
        // initialise instance variables
        double[] val={0,0,0,0,0,0};
        double[] err={0,0,0,0,0,0};
        double temperature;
        int h,k,l;
        //Dateiformat:
        //T a aerr b berr
        try {
                FileInputStream fstream = new FileInputStream(args[0]);
                DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String fname=args[0].substring(0,args[0].length()-4);
                System.out.println(fname);
                
                FileWriter outFile = new FileWriter( fname + "_"+ args[1] +args[2] +args[3] + ".q");
                PrintWriter out = new PrintWriter(outFile);
                out.println("#temp\tqPara\tqPerp\t");
                
                String strLine;
                h=Integer.parseInt(args[1]);
                k=Integer.parseInt(args[2]);
                l=Integer.parseInt(args[3]);
                hkl myhkl = new hkl(h,k,l);
                //br.readLine(); // skip first line
                while ((strLine = br.readLine()) != null)   {
                    if(!strLine.isEmpty())
                    if((strLine.charAt(0))!='#')
                    {
                        String[] values=strLine.split("\t"); 
                        temperature=Double.parseDouble(values[0]);
                        val[0]=Double.parseDouble(values[1]);
                        err[0]=Double.parseDouble(values[2]);
                        val[1]=Double.parseDouble(values[3]);
                        err[1]=Double.parseDouble(values[4]);
                        val[2]=Double.parseDouble(values[5]);
                        err[2]=Double.parseDouble(values[6]);
                        val[3]=Double.parseDouble(values[7]);
                        err[3]=Double.parseDouble(values[8]);
                        val[4]=Double.parseDouble(values[9]);
                        err[4]=Double.parseDouble(values[10]);
                        val[5]=Double.parseDouble(values[11]);
                        err[5]=Double.parseDouble(values[12]);
                        
                        UnitCell u= new UnitCell(val[0],val[1],val[2],val[3],val[4],val[5]);
                        double[] res = u.calcQ(myhkl);
                        double qpara=Math.sqrt(res[0]*res[0]+res[1]*res[1]);
                        double qperp=res[2];
                        
                        double dqpara=0;
                        double dqperp=0;
                        double qpara1;
                        double qperp1;
                        UnitCell u1;
                        u1= new UnitCell(val[0]+err[0],val[1],val[2],val[3],val[4],val[5]);
                        res = u1.calcQ(myhkl);
                        qpara1=Math.sqrt(res[0]*res[0]+res[1]*res[1]);
                        qperp1=res[2];
                        if(Math.abs(qpara1-qpara)>dqpara){dqpara=Math.abs(qpara1-qpara);}
                        if(Math.abs(qperp1-qperp)>dqperp){dqperp=Math.abs(qperp1-qperp);}
                        
                        u1= new UnitCell(val[0],val[1]+err[1],val[2],val[3],val[4],val[5]);
                        res = u1.calcQ(myhkl);
                        qpara1=Math.sqrt(res[0]*res[0]+res[1]*res[1]);
                        qperp1=res[2];
                        if(Math.abs(qpara1-qpara)>dqpara){dqpara=Math.abs(qpara1-qpara);}
                        if(Math.abs(qperp1-qperp)>dqperp){dqperp=Math.abs(qperp1-qperp);}
                        
                        u1= new UnitCell(val[0],val[1],val[2]+err[2],val[3],val[4],val[5]);
                        res = u1.calcQ(myhkl);
                        qpara1=Math.sqrt(res[0]*res[0]+res[1]*res[1]);
                        qperp1=res[2];
                        if(Math.abs(qpara1-qpara)>dqpara){dqpara=Math.abs(qpara1-qpara);}
                        if(Math.abs(qperp1-qperp)>dqperp){dqperp=Math.abs(qperp1-qperp);}
                        
                        u1= new UnitCell(val[0],val[1],val[2],val[3]+err[3],val[4],val[5]);
                        res = u1.calcQ(myhkl);
                        qpara1=Math.sqrt(res[0]*res[0]+res[1]*res[1]);
                        qperp1=res[2];
                        if(Math.abs(qpara1-qpara)>dqpara){dqpara=Math.abs(qpara1-qpara);}
                        if(Math.abs(qperp1-qperp)>dqperp){dqperp=Math.abs(qperp1-qperp);}
                        
                        u1= new UnitCell(val[0],val[1],val[2],val[3],val[4]+err[4],val[5]);
                        res = u1.calcQ(myhkl);
                        qpara1=Math.sqrt(res[0]*res[0]+res[1]*res[1]);
                        qperp1=res[2];
                        if(Math.abs(qpara1-qpara)>dqpara){dqpara=Math.abs(qpara1-qpara);}
                        if(Math.abs(qperp1-qperp)>dqperp){dqperp=Math.abs(qperp1-qperp);}
                        
                        u1= new UnitCell(val[0],val[1],val[2],val[3],val[4],val[5]+err[5]);
                        res = u1.calcQ(myhkl);
                        qpara1=Math.sqrt(res[0]*res[0]+res[1]*res[1]);
                        qperp1=res[2];
                        if(Math.abs(qpara1-qpara)>dqpara){dqpara=Math.abs(qpara1-qpara);}
                        if(Math.abs(qperp1-qperp)>dqperp){dqperp=Math.abs(qperp1-qperp);}
                        
                        out.println(temperature+ "\t" + qpara + "\t" + qperp +"\t" + dqpara+"\t" + dqperp);
                    }
                }
                    out.close();
                }catch (Exception e){e.printStackTrace();}
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void main(String[] args)
    {
        new QTracker(args);
    }
}
