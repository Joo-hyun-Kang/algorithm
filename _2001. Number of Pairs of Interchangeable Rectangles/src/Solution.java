import java.util.HashMap;
import java.util.Map;

class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Integer> map = new HashMap<>();

        for (int i = 0; i < rectangles.length; ++i) {
            double value = rectangles[i][0] / (double)rectangles[i][1];
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }
        }

        long count = 0;
        for (Map.Entry<Double, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                count += getfactoral(entry.getValue()) / 2;
            }
        }

        return count;
    }

    private long getfactoral(long value) {
        long res = 1;
        
        for (long i = value; i >= value - 1; --i) {
            res *= i;
        }

        return res;
    }
}