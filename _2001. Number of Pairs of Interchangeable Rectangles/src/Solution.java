package src;

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
}
