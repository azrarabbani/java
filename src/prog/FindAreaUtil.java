package prog;

/**
 * Created by arabbani on 11/2/16.
 */
public class FindAreaUtil {

    private int[][] lake = {
            {0,0,0,0,0,1,1,1},
            {0,1,1,0,0,1,1,0},
            {0,1,1,0,0,1,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,1,1},
            {1,1,1,1,1,0,0,0},
            {0,1,1,1,0,0,0,0},
            {0,1,1,1,0,0,0,0}
    };

//    private int[][] lake = {
//            {1,0,0},
//            {0,1,1},
//            {0,0,1}
//    };

    //point of reference(x,y)
    // find area around it
    //got for left and right
    //for right: go k = y; l = x; keep y+ 1 to until x >= legth-1 or element contains 0 when return add to x until length -1 or or element contains 0; return initialize x =l keep
    //going up  until x < 0
    //for left go keep y- 1 until y < 0 or element contains 0
    //
    private boolean[][]  visited = {
            {false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false}

    };

    public int getLargestLandArea() {
        int maxArea = -1;
        for(int i = 0; i < lake.length; i++) {
            for (int j = 0; j < lake.length; j++) {
                if(lake[i][j] == 1 && !visited[i][j]) {
                    System.out.println("NNNNNNNext " +i+" , "+j);
                        int count = getLandArea(i, j, 0);
                    if(count > 0) {
                        System.out.println("Land Area " + count);
                    }
                    maxArea = Math.max(maxArea , count);
                }
            }
        }
        return maxArea;
    }
//    {1,0,0},
//    {0,1,1},
//    {0,0,1}
    private int getLandArea( int x, int y, int count ) {
        if(y >= lake.length || x < 0  || y < 0   || x >= lake.length || lake[x][y] == 0 || visited[x][y]) {
            return count;
        }
        visited[x][y] = true;
        return getLandArea(x, y + 1, count + 1) + getLandArea(x, y - 1, 0) + getLandArea(x - 1, y, 0) + getLandArea(x + 1, y, 0);
    }




//    private int getLandArea( int x, int y, int count ) {
//        System.out.println("Recursion : x="+x+ " , y="+y);
//        if(y >= lake.length || x < 0  || y < 0   || x >= lake.length || lake[x][y] == 0 || visited[x][y]) {
//            System.out.println("----- Returning : x="+x+ "  , y="+y+" , count="+count +", lake[x][y] ="+lake[x][y] +", visited[x][y]="+visited[x][y] );
//            // System.out.println("------------------------------------------------------------------");
//            return count;
//        }
//        visited[x][y] = true;
//        System.out.println("calling right:x="+x+ ",y="+y+",count="+count);
//        //return getLandArea(x, y + 1, count + 1) + getLandArea(x, y - 1, 0) + getLandArea(x - 1, y, 0) + getLandArea(x + 1, y, 0);
//        count = getLandArea(x, y + 1, count + 1);
//        System.out.println("calling left:x="+x+ ",y="+y+",count="+count);
//        count += getLandArea(x, y - 1, 0);
//        System.out.println("calling up:x="+x+ ",y="+y+",count="+count);
//        count += getLandArea(x - 1, y, 0);
//        System.out.println("calling down:x="+x+ ",y="+y+",count="+count);
//        count += getLandArea(x + 1, y, 0);
//        System.out.println("ending:x="+x+ ",y="+y+",count="+count);
//        System.out.println("------------------------------------------------------------------");
//        return count;
//    }


    /**
     * Recursion keeps calling until any of the base condition met,during this you need to do your work so that before going to next statement
     * it is already computed.
     * On return it resumes next line execution with the second last values
     * when returned happen.e.g. if returned for 1,3 then next line will be called for 1,2 and if it is also a recursive call then it will keep calling with the values before the last value
     * when it is finally returned it doesn't go to the first call of the method. It just keep returning from the line of recursive call
     *
     */
// fact(n - 1) * n
//    factR(6) = factR(5) * 6
//            = (factR(4) * 5) * 6
//            = ((factR(3) * 4) * 5) * 6
//            = (((factR(2) * 3) * 4) * 5) * 6
//            = ((((factR(1) * 2) * 3) * 4) * 5) * 6
//            = ((((1 * 2) * 3) * 4) * 5) * 6
//            = (((2 * 3) * 4) * 5) * 6
//            = ((6 * 4) * 5) * 6
//            = (24 * 5) * 6
//            = 120 * 6
//            = 720
    public static void main(String[] args) {
        System.out.println("Max Area " + new FindAreaUtil().getLargestLandArea() );
    }
}
