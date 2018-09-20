 
//import jaea.optimization.tools.Permutation; 
 //https://www.programcreek.com/java-api-examples/index.php?source_dir=iter-master/src/main/java/jaea/optimization/sampling/SimpleLH
/**
 * Simple algorithm to generate Latin-hypercube sampling 
 *  
 * @author Le Minh Nghia, NTU-Singapore 
 *  
 */ 
public class SimpleLH { 
 /**
  * Generate matrix (nSamples x nDim) so that each column is a permutation of 
  * 1->N 
  *  
  * @param N 
  *            Number of samples 
  * @param dim 
  *            Number of dimensions 
  */ 
 int samplesize;
 int dim;
 int[][] LH ;
 public SimpleLH(int samplesize, int dim)
 { this.samplesize=samplesize;
   this.dim=dim;
   LH=createSimpleLH(samplesize, dim);
    }
 private  int[][] createSimpleLH(int samplesize, int dim) { 
  int[][] LH = new int[samplesize][dim]; 
  Permutation permGen = new Permutation(); 
  for (int c = 0; c < dim; c++) { 
   int[] perm = permGen.getPerm(samplesize); 
   for (int r = 0; r < samplesize; r++) { 
    LH[r][c] = perm[r]; 
   } 
  } 
  return LH; 
 } 
 public void ausgeben()
 {
     for (int r = 0; r < samplesize; r++) { 
     for (int c = 0; c < dim; c++) 
     System.out.print(LH[r][c] + " "); 
     System.out.println(); 
    }
 }
 public int getElement(int row, int col)
 { return LH[row][col];
    }
 /**
  * @param args 
  */ 
 public static void main(String[] args) { 
  // TODO Auto-generated method stub 
  int N = 1000; 
  int d =6; 
  SimpleLH simpleLH= new SimpleLH(N,d); 
  simpleLH.ausgeben();
  } 
  
  
}