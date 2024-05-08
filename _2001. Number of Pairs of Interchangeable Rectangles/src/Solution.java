package src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Integer> map = new HashMap<>();

        long count = 0;
        for (int[] rectangle : rectangles) {
            double value = rectangle[0] / (double) rectangle[1];
            if (map.containsKey(value)) {
                count += map.get(value);
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }
        }

        return count;
    }

//    public long interchangeableRectangles(int[][] rectangles) {
//        int length = rectangles.length;
//        double[] ratios = new double[length];
//
//        for (int i = 0; i < length; ++i) {
//            ratios[i] = rectangles[i][0] / (double) rectangles[i][1];
//        }
//        Arrays.sort(ratios);
//
//        long curr = 0;
//        long res = 0;
//        for (int j = 0; j < length - 1; j++) {
//            if (ratios[j] == ratios[j + 1]) {
//                curr++;
//                res += curr;
//            } else {
//                curr = 0;
//            }
//        }
//
//        return res;
//    }
}
