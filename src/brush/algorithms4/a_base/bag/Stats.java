package brush.algorithms4.a_base.bag;

import brush.algorithms4.library.StdLib.StdIn;
import brush.algorithms4.library.StdLib.StdOut;
import brush.algorithms4.library.bag.Bag;

/**
 * @author: lazecoding
 * @date: 2021/2/1 22:33
 * @description:
 */
public class Stats {
    public static void main(String[] args) {

        // read in numbers
        Bag<Double> numbers = new Bag<Double>();
        while (!StdIn.isEmpty()) {
            numbers.add(StdIn.readDouble());
        }
        int N = numbers.size();

        // compute mean
        double sum = 0.0;
        for (double x : numbers)
            sum += x;
        double mean = sum/N;

        // compute standard deviation
        sum = 0.0;
        for (double x : numbers) {
            sum += (x - mean) * (x - mean);
        }
        double std = Math.sqrt(sum/(N-1));

        StdOut.printf("Mean:    %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }
}
