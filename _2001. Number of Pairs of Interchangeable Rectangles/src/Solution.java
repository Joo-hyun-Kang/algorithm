import java.util.HashSet;

class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        HashSet<Double> set = new HashSet<Double>();
        long count = 0;

        for (int i = 0; i < rectangles.length; ++i) {
            double ratio = rectangles[i][0] / (double)rectangles[i][0];
            
            if (set.contains(ratio)) {
                count++;
            } else {
                set.add(ratio);
            }
        }

        return count;
    }

}