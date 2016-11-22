package prog;

/**
 * Created by arabbani on 11/23/15.
 */
public class MissingDuplicate {

    int Sum;
    int SumN;
    int P=1;
    int Np=1;
    int a,b;


    public long  missingNumbers(int [] arrA, int range){
        SumN = range*(range+1)/2;
        for(int i=0;i<arrA.length;i++){
            Sum +=arrA[i];
        }
        int s= SumN-Sum;
        long missing = 0;
        int duplicate =0;
        missing = s + duplicate;
        double SumNCopy = SumN;
        while(SumNCopy > 10) {
            SumNCopy = SumNCopy / Math.abs(s);
        }
        missing = Math.round(Math.ceil(SumNCopy)) + s;
//        for(int i=0;i<arrA.length;i++){
//            P *=arrA[i];
//        }
//        for(int i=1;i<=range;i++){
//            Np *=i;
//        }
//        int product = Np/P;
////		System.out.println(product);
//        int diffSqr = (int)Math.sqrt(s*s-4*product); // (a-b)^2 = (a+b)^2-4ab
//        a = (s+diffSqr)/2;
//        b= s-a;

        return missing;
    }

    private static void commonEleemntsInArray(int[] a, int[] b) {
        int i = 0, j = 0;

        while (i < a.length && j < b.length) {

            if (a[i] > b[j]) {
                j++;
            } else if (b[j] > a[i]) {
                i++;
            } else {
                System.out.println(a[i]);
                i++;
                j++;
            }
        }

    }


    public void printDuplicateNum(int[] numbers , int startingSeq, int endingSeq) {
        if(numbers == null) {
            System.out.println("List is null!");
            return;
        }
        int size = endingSeq ;
        if(numbers.length <= 1) {
            System.out.println("List length is not sufficient to carry duplicates.");
            return;
        }
        boolean[] visited = new boolean[size+2];
        for(int i = 0 ; i < numbers.length ; i++) {
            if(!visited[numbers[i]]) {
                visited[numbers[i]] = true;
            } else {
                System.out.println(" Duplicate num is "+numbers[i]);
                return ;
            }

        }
        System.out.println(" No duplicate found");
    }

    //it can be resolvedvsimply by keeping track of eah of the number already visited

    public static void main(String[] args) {
//        int[] A = { 2, 1,6, 3, 5, 5, 7, 9,10, 8 };
//        MissingDuplicate i = new MissingDuplicate();
//        System.out.println("Missing duplicate is " + i.find(A));

        int [] arrA = {10,2,3,5,6,4,8,9,9,1};
        MissingDuplicate f = new MissingDuplicate();
//        long result = f.missingNumbers(arrA, 10);
//        System.out.println("Missing numbers are :" + result);
        f.printDuplicateNum(arrA, 1, 10);
    }

}