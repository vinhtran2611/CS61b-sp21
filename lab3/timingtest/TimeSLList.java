package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static AList<Integer> creatAList(int begin, int nums){
        int lastElem = begin;
        AList<Integer> Ns = new AList<Integer>();
        for(int i = 0; i < nums; i++){
            Ns.addLast(lastElem);
            lastElem *= 2;
        }
        return Ns;
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = creatAList(1000, 8);
        AList<Double> times = new AList<Double>();
        AList<Integer> opCounts = new AList<Integer>();

        for(int i = 0; i < Ns.size(); i++){
            //Create an SLList.
            SLList<Integer> tempList = new SLList<Integer>();

            //Add N items to the SLList.
            for(int n = 0; n < Ns.get(i); n++){
                tempList.addLast(n);
            }

            //Start the timer.
            Stopwatch sw = new Stopwatch();
            //Perform M getLast operations on the SLList.
            for(int k = 0; k < 10000; k++){
                int val = tempList.getLast();
            }
            times.addLast(sw.elapsedTime());
            opCounts.addLast(10000);
        }

        printTimingTable(Ns, times, opCounts);

    }

}
