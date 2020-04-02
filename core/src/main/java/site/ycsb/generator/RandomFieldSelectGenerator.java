package site.ycsb.generator;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * Generates longs randomly uniform from an interval.
 */
public class RandomFieldSelectGenerator {


  public int[] getFields(int lb, int ub, int count) {
    int interval = ub - lb;
    int[] arr = IntStream.range(lb, ub).toArray();
    int[] ret = new int[count];
    for (int i = ub-1, k =0; i >= 0; i--, k++) {
      if(k == count) {
        break;
      }
      int j = Math.abs(ThreadLocalRandom.current().nextInt()) % (interval - k);

      // Swap arr[i] with the element at random index
      int temp = arr[i];
      arr[i] = arr[j];
      ret[k] = arr[j];
      arr[j] = temp;

    }

    return ret;
  }

}