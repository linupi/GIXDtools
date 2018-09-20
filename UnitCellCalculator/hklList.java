import java.util.ArrayList;
/**
 * Write a description of class hklList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class hklList 
{
    // instance variables - replace the example below with your own
    private ArrayList myList;

    /**
     * Constructor for objects of class hklList
     */
    public hklList()
    {
        // initialise instance variables
        myList = new ArrayList();    

/*
        for(int h=-4;h<=4;h++){
            for(int k=-4;k<=4;k++){
                for(int l=-4;l<=4;l++){
            add(new hkl(  h, k, l   ));
        }
        }
        }
        */

/// manual entries
add(new hkl(  	-1	,	0	,	5	 ));
add(new hkl(  	1	,	0	,	5	 ));
add(new hkl(  	0	,	-1	,	5	 ));
add(new hkl(  	0	,	1	,	5	 ));
add(new hkl(  	-1	,	-1	,	5	 ));
add(new hkl(  	1	,	-1	,	5	 ));
add(new hkl(  	-1	,	1	,	5	 ));
add(new hkl(  	1	,	1	,	5	 ));
add(new hkl(  	2	,	0	,	5	 ));
add(new hkl(  	2	,	0	,	5	 ));
        
add(new hkl(  	1	,	0	,	1	 ));
add(new hkl(  	1	,	0	,	2	 ));
add(new hkl(  	1	,	0	,	3	 ));
add(new hkl(  	1	,	0	,	4	 ));
add(new hkl(  	-1	,	0	,	0	 ));
add(new hkl(  	1	,	0	,	-1	 ));
add(new hkl(  	-1	,	0	,	1	 ));
add(new hkl(  	1	,	0	,	0	 ));
add(new hkl(  	-1	,	0	,	2	 ));
add(new hkl(  	-1	,	0	,	3	 ));
add(new hkl(  	-1	,	0	,	4	 ));
add(new hkl(  	1	,	1	,	-1	 ));
add(new hkl(  	-1	,	-1	,	-1	 ));
add(new hkl(  	1	,	1	,	0	 ));
add(new hkl(  	-1	,	-1	,	0	 ));
add(new hkl(  	1	,	1	,	1	 ));
add(new hkl(  	-1	,	-1	,	1	 ));
add(new hkl(  	1	,	1	,	2	 ));
add(new hkl(  	1	,	1	,	3	 ));
add(new hkl(  	1	,	1	,	4	 ));
add(new hkl(  	-1	,	-1	,	2	 ));
add(new hkl(  	-1	,	-1	,	3	 ));
add(new hkl(  	-1	,	-1	,	4	 ));
add(new hkl(  	0	,	-1	,	-2	 ));
add(new hkl(  	0	,	1	,	0	 ));
add(new hkl(  	0	,	-1	,	-1	 ));
add(new hkl(  	0	,	1	,	1	 ));
add(new hkl(  	0	,	-1	,	0	 ));
add(new hkl(  	0	,	1	,	2	 ));
add(new hkl(  	0	,	-1	,	1	 ));
add(new hkl(  	0	,	1	,	3	 ));
add(new hkl(  	0	,	-1	,	2	 ));
add(new hkl(  	0	,	1	,	4	 ));
add(new hkl(  	0	,	-1	,	3	 ));
add(new hkl(  	0	,	-1	,	4	 ));
add(new hkl(  	2	,	0	,	2	 ));
add(new hkl(  	2	,	0	,	3	 ));
add(new hkl(  	2	,	0	,	4	 ));
add(new hkl(  	2	,	0	,	-2	 ));
add(new hkl(  	-2	,	0	,	1	 ));
add(new hkl(  	2	,	0	,	-1	 ));
add(new hkl(  	-2	,	0	,	2	 ));
add(new hkl(  	2	,	0	,	0	 ));
add(new hkl(  	-2	,	0	,	3	 ));
add(new hkl(  	2	,	0	,	1	 ));
add(new hkl(  	-2	,	0	,	4	 ));
add(new hkl(  	2	,	1	,	3	 ));
add(new hkl(  	2	,	1	,	4	 ));
add(new hkl(  	-2	,	-1	,	0	 ));
add(new hkl(  	2	,	1	,	-1	 ));
add(new hkl(  	-2	,	-1	,	1	 ));
add(new hkl(  	2	,	1	,	0	 ));
add(new hkl(  	-2	,	-1	,	2	 ));
add(new hkl(  	2	,	1	,	1	 ));
add(new hkl(  	-2	,	-1	,	3	 ));
add(new hkl(  	2	,	1	,	2	 ));
add(new hkl(  	-2	,	-1	,	4	 ));
add(new hkl(  	1	,	-1	,	-2	 ));
add(new hkl(  	-1	,	1	,	1	 ));
add(new hkl(  	1	,	-1	,	-1	 ));
add(new hkl(  	-1	,	1	,	2	 ));
add(new hkl(  	1	,	-1	,	0	 ));
add(new hkl(  	-1	,	1	,	3	 ));
add(new hkl(  	1	,	-1	,	1	 ));
add(new hkl(  	-1	,	1	,	4	 ));
add(new hkl(  	1	,	-1	,	2	 ));
add(new hkl(  	1	,	-1	,	3	 ));
add(new hkl(  	1	,	-1	,	4	 ));
add(new hkl(  	-3	,	-1	,	0	 ));
add(new hkl(  	-3	,	-1	,	1	 ));
add(new hkl(  	3	,	1	,	-1	 ));
add(new hkl(  	3	,	1	,	0	 ));
add(new hkl(  	3	,	1	,	1	 ));
add(new hkl(  	3	,	1	,	2	 ));
add(new hkl(  	3	,	1	,	3	 ));
add(new hkl(  	3	,	1	,	4	 ));
add(new hkl(  	3	,	1	,	-2	 ));
add(new hkl(  	-3	,	-1	,	2	 ));
add(new hkl(  	-3	,	-1	,	3	 ));
add(new hkl(  	-3	,	-1	,	4	 ));
add(new hkl(  	3	,	0	,	4	 ));
add(new hkl(  	-3	,	0	,	1	 ));
add(new hkl(  	3	,	0	,	-3	 ));
add(new hkl(  	-3	,	0	,	2	 ));
add(new hkl(  	3	,	0	,	-2	 ));
add(new hkl(  	-3	,	0	,	3	 ));
add(new hkl(  	3	,	0	,	-1	 ));
add(new hkl(  	3	,	0	,	0	 ));
add(new hkl(  	3	,	0	,	1	 ));
add(new hkl(  	3	,	0	,	2	 ));
add(new hkl(  	3	,	0	,	3	 ));
add(new hkl(  	-3	,	0	,	4	 ));
add(new hkl(  	-2	,	1	,	1	 ));
add(new hkl(  	2	,	-1	,	-3	 ));
add(new hkl(  	-2	,	1	,	2	 ));
add(new hkl(  	2	,	-1	,	-2	 ));
add(new hkl(  	-2	,	1	,	3	 ));
add(new hkl(  	2	,	-1	,	-1	 ));
add(new hkl(  	-2	,	1	,	4	 ));
add(new hkl(  	2	,	-1	,	0	 ));
add(new hkl(  	2	,	-1	,	1	 ));
add(new hkl(  	2	,	-1	,	2	 ));
add(new hkl(  	2	,	-1	,	3	 ));
add(new hkl(  	2	,	-1	,	4	 ));
/*
add(new hkl(  	-1	,	-2	,	-2	 ));
add(new hkl(  	1	,	2	,	0	 ));
add(new hkl(  	-1	,	-2	,	-1	 ));
add(new hkl(  	1	,	2	,	1	 ));
add(new hkl(  	-1	,	-2	,	0	 ));
add(new hkl(  	1	,	2	,	2	 ));
add(new hkl(  	-1	,	-2	,	1	 ));
add(new hkl(  	1	,	2	,	3	 ));
add(new hkl(  	-1	,	-2	,	2	 ));
add(new hkl(  	1	,	2	,	4	 ));
add(new hkl(  	-1	,	-2	,	3	 ));
add(new hkl(  	-1	,	-2	,	4	 ));
add(new hkl(  	2	,	2	,	-1	 ));
add(new hkl(  	-2	,	-2	,	-1	 ));
add(new hkl(  	2	,	2	,	0	 ));
add(new hkl(  	-2	,	-2	,	0	 ));
add(new hkl(  	2	,	2	,	1	 ));
add(new hkl(  	-2	,	-2	,	1	 ));
add(new hkl(  	2	,	2	,	2	 ));
add(new hkl(  	-2	,	-2	,	2	 ));
add(new hkl(  	2	,	2	,	3	 ));
add(new hkl(  	-2	,	-2	,	3	 ));
add(new hkl(  	2	,	2	,	4	 ));
add(new hkl(  	-2	,	-2	,	4	 ));
add(new hkl(  	4	,	1	,	-3	 ));
add(new hkl(  	-4	,	-1	,	1	 ));
add(new hkl(  	4	,	1	,	-2	 ));
add(new hkl(  	-4	,	-1	,	2	 ));
add(new hkl(  	4	,	1	,	-1	 ));
add(new hkl(  	-4	,	-1	,	3	 ));
add(new hkl(  	4	,	1	,	0	 ));
add(new hkl(  	-4	,	-1	,	4	 ));
add(new hkl(  	4	,	1	,	1	 ));
add(new hkl(  	4	,	1	,	2	 ));
add(new hkl(  	4	,	1	,	3	 ));
add(new hkl(  	4	,	1	,	4	 ));
add(new hkl(  	0	,	2	,	1	 ));
add(new hkl(  	0	,	-2	,	-2	 ));
add(new hkl(  	0	,	2	,	2	 ));
add(new hkl(  	0	,	-2	,	-1	 ));
add(new hkl(  	0	,	2	,	3	 ));
add(new hkl(  	0	,	-2	,	0	 ));
add(new hkl(  	0	,	2	,	4	 ));
add(new hkl(  	0	,	-2	,	1	 ));
add(new hkl(  	0	,	-2	,	2	 ));
add(new hkl(  	0	,	-2	,	3	 ));
add(new hkl(  	0	,	-2	,	4	 ));
add(new hkl(  	3	,	2	,	-1	 ));
add(new hkl(  	-3	,	-2	,	0	 ));
add(new hkl(  	3	,	2	,	0	 ));
add(new hkl(  	-3	,	-2	,	1	 ));
add(new hkl(  	3	,	2	,	1	 ));
add(new hkl(  	-3	,	-2	,	2	 ));
add(new hkl(  	3	,	2	,	2	 ));
add(new hkl(  	3	,	2	,	3	 ));
add(new hkl(  	3	,	2	,	4	 ));
add(new hkl(  	-3	,	-2	,	3	 ));
add(new hkl(  	-3	,	-2	,	4	 ));
add(new hkl(  	4	,	0	,	4	 ));
add(new hkl(  	4	,	0	,	-4	 ));
add(new hkl(  	-4	,	0	,	2	 ));
add(new hkl(  	4	,	0	,	-3	 ));
add(new hkl(  	-4	,	0	,	3	 ));
add(new hkl(  	4	,	0	,	-2	 ));
add(new hkl(  	-4	,	0	,	4	 ));
add(new hkl(  	4	,	0	,	-1	 ));
add(new hkl(  	4	,	0	,	0	 ));
add(new hkl(  	4	,	0	,	1	 ));
add(new hkl(  	4	,	0	,	2	 ));
add(new hkl(  	4	,	0	,	3	 ));
add(new hkl(  	3	,	-1	,	-4	 ));
add(new hkl(  	-3	,	1	,	2	 ));
add(new hkl(  	3	,	-1	,	-3	 ));
add(new hkl(  	-3	,	1	,	3	 ));
add(new hkl(  	3	,	-1	,	-2	 ));
add(new hkl(  	-3	,	1	,	4	 ));
add(new hkl(  	3	,	-1	,	-1	 ));
add(new hkl(  	3	,	-1	,	0	 ));
add(new hkl(  	3	,	-1	,	1	 ));
add(new hkl(  	3	,	-1	,	2	 ));
add(new hkl(  	3	,	-1	,	3	 ));
add(new hkl(  	3	,	-1	,	4	 ));
add(new hkl(  	1	,	-2	,	-3	 ));
add(new hkl(  	-1	,	2	,	2	 ));
add(new hkl(  	1	,	-2	,	-2	 ));
add(new hkl(  	-1	,	2	,	3	 ));
add(new hkl(  	1	,	-2	,	-1	 ));
add(new hkl(  	-1	,	2	,	4	 ));
add(new hkl(  	1	,	-2	,	0	 ));
add(new hkl(  	1	,	-2	,	1	 ));
add(new hkl(  	1	,	-2	,	2	 ));
add(new hkl(  	1	,	-2	,	3	 ));
add(new hkl(  	1	,	-2	,	4	 ));
add(new hkl(  	-4	,	-2	,	0	 ));
add(new hkl(  	4	,	2	,	-2	 ));
add(new hkl(  	-4	,	-2	,	1	 ));
add(new hkl(  	4	,	2	,	-1	 ));
add(new hkl(  	-4	,	-2	,	2	 ));
add(new hkl(  	4	,	2	,	0	 ));
add(new hkl(  	-4	,	-2	,	3	 ));
add(new hkl(  	4	,	2	,	1	 ));
add(new hkl(  	4	,	2	,	2	 ));
add(new hkl(  	4	,	2	,	3	 ));
add(new hkl(  	4	,	2	,	4	 ));
add(new hkl(  	-4	,	-2	,	4	 ));
add(new hkl(  	2	,	-2	,	-4	 ));
add(new hkl(  	-2	,	2	,	2	 ));
add(new hkl(  	2	,	-2	,	-3	 ));
add(new hkl(  	-2	,	2	,	3	 ));
add(new hkl(  	2	,	-2	,	-2	 ));
add(new hkl(  	-2	,	2	,	4	 ));
add(new hkl(  	2	,	-2	,	-1	 ));
add(new hkl(  	2	,	-2	,	0	 ));
add(new hkl(  	2	,	-2	,	1	 ));
add(new hkl(  	2	,	-2	,	2	 ));
add(new hkl(  	2	,	-2	,	3	 ));
add(new hkl(  	2	,	-2	,	4	 ));
add(new hkl(  	-4	,	1	,	3	 ));
add(new hkl(  	4	,	-1	,	-4	 ));
add(new hkl(  	-4	,	1	,	4	 ));
add(new hkl(  	4	,	-1	,	-3	 ));
add(new hkl(  	4	,	-1	,	-2	 ));
add(new hkl(  	4	,	-1	,	-1	 ));
add(new hkl(  	4	,	-1	,	0	 ));
add(new hkl(  	4	,	-1	,	1	 ));
add(new hkl(  	4	,	-1	,	2	 ));
add(new hkl(  	4	,	-1	,	3	 ));
add(new hkl(  	4	,	-1	,	4	 ));
add(new hkl(  	2	,	3	,	0	 ));
add(new hkl(  	-2	,	-3	,	-2	 ));
add(new hkl(  	2	,	3	,	1	 ));
add(new hkl(  	-2	,	-3	,	-1	 ));
add(new hkl(  	2	,	3	,	2	 ));
add(new hkl(  	-2	,	-3	,	0	 ));
add(new hkl(  	2	,	3	,	3	 ));
add(new hkl(  	-2	,	-3	,	1	 ));
add(new hkl(  	2	,	3	,	4	 ));
add(new hkl(  	-2	,	-3	,	2	 ));
add(new hkl(  	-2	,	-3	,	3	 ));
add(new hkl(  	-2	,	-3	,	4	 ));
add(new hkl(  	-3	,	-3	,	-1	 ));
add(new hkl(  	3	,	3	,	0	 ));
add(new hkl(  	-3	,	-3	,	0	 ));
add(new hkl(  	3	,	3	,	1	 ));
add(new hkl(  	-3	,	-3	,	1	 ));
add(new hkl(  	3	,	3	,	2	 ));
add(new hkl(  	-3	,	-3	,	2	 ));
add(new hkl(  	3	,	3	,	3	 ));
add(new hkl(  	3	,	3	,	4	 ));
add(new hkl(  	-3	,	-3	,	3	 ));
add(new hkl(  	-3	,	-3	,	4	 ));

        */
        /*
add(new hkl(  -1, 0, 1   ));
add(new hkl( 1 ,0, 0   ));
add(new hkl(  -1, 0, 2  ));
add(new hkl(  1, 0, 1  ));
add(new hkl(  -1, 0, 3  ));
add(new hkl(  1, 0 ,2  ));
add(new hkl(  -1, 0, 4  ));
add(new hkl(  1 ,0, 3  ));
add(new hkl(  -1, 0 ,5  ));
add(new hkl(  1, 0 ,4  ));
add(new hkl(  1, -1 ,-1  ));
add(new hkl(  -1 ,-1, 0  ));
add(new hkl(  -1 ,-1 ,1  ));
add(new hkl(  1 ,1 ,2  ));
add(new hkl(  -1 ,-1 ,3  ));
add(new hkl(  1 ,1 ,4  ));
add(new hkl(  -1 ,-1, 5  ));
add(new hkl(  0 ,1, 1  ));
add(new hkl(  0, -1, 0  ));
add(new hkl(  0, 1, 2  ));
add(new hkl(  2, 0 ,0  ));
add(new hkl(  0 ,-1, 1  ));
add(new hkl(  0, 1 ,3  ));
add(new hkl(  2, 0 ,1  ));
add(new hkl(  0 ,1, 4  ));
add(new hkl(  2 ,0, 2  ));
add(new hkl(  0 ,-1, 4  ));
add(new hkl(  2, 0, 3  ));
add(new hkl(  2 ,1 ,2  ));
add(new hkl(  2 ,1 ,3  ));
add(new hkl(  -1, 1 ,2  ));
add(new hkl(  1 ,-1, 0  ));
add(new hkl( 1 ,-1, 1   ));
add(new hkl(  -1, 1, 5  ));
*/
//bis hier
/*
add(new hkl(    0   ,   2   ,   1   ));
add(new hkl(    0   ,   2   ,   2   ));
add(new hkl(    0   ,   3   ,   1   ));
add(new hkl(    0   ,   3   ,   2   ));
add(new hkl(    0   ,   3   ,   3   ));
add(new hkl(    0   ,   4   ,   2   ));
add(new hkl(    0   ,   4   ,   3   ));
add(new hkl(    1   ,   -4  ,   0   ));
add(new hkl(    1   ,   -3  ,   0   ));
add(new hkl(    1   ,   -3  ,   1   ));
add(new hkl(    1   ,   -2  ,   0   ));
add(new hkl(    1   ,   -2  ,   1   ));
add(new hkl(    1   ,   -1  ,   1   ));
add(new hkl(    1   ,   -1  ,   2   ));
add(new hkl(    1   ,   1   ,   1   ));
add(new hkl(    1   ,   1   ,   2   ));
add(new hkl(    1   ,   1   ,   3   ));
add(new hkl(    1   ,   2   ,   2   ));
add(new hkl(    1   ,   2   ,   3   ));
add(new hkl(    1   ,   3   ,   2   ));
add(new hkl(    1   ,   3   ,   3   ));
add(new hkl(    1   ,   4   ,   2   ));
add(new hkl(    1   ,   4   ,   3   ));
add(new hkl(    2   ,   -3  ,   1   ));
add(new hkl(    2   ,   -2  ,   1   ));
add(new hkl(    2   ,   -2  ,   2   ));
add(new hkl(    2   ,   -1  ,   1   ));
add(new hkl(    2   ,   -1  ,   2   ));
//add(new hkl(    2   ,   0   ,   2   ));
//add(new hkl(    2   ,   0   ,   3   ));
//add(new hkl(    2   ,   1   ,   2   ));
//add(new hkl(    2   ,   1   ,   3   ));
add(new hkl(    2   ,   2   ,   2   ));
add(new hkl(    2   ,   2   ,   3   ));
add(new hkl(    2   ,   2   ,   4   ));
add(new hkl(    2   ,   3   ,   3   ));
add(new hkl(    2   ,   3   ,   4   ));
add(new hkl(    3   ,   -1  ,   2   ));
add(new hkl(    3   ,   -1  ,   3   ));
add(new hkl(    3   ,   0   ,   2   ));
add(new hkl(    3   ,   0   ,   3   ));
add(new hkl(    3   ,   1   ,   3   ));
add(new hkl(    3   ,   2   ,   3   ));
add(new hkl(    3   ,   1   ,   4   ));
add(new hkl(    3   ,   2   ,   4   ));
*/

    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void add(hkl myhkl)
    {
        // put your code here
        myList.add(myhkl);
    }
    public hkl get(int i)
    {
        // put your code here
        return (hkl) myList.get(i);
    }
    public int getSize()
    {
        return myList.size();
    }
}
