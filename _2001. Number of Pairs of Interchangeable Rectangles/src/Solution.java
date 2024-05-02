class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        double[] ratios = new double[rectangles.length];
        long count = 0;

        for (int i = 0; i < rectangles.length; ++i) {
            ratios[i] = rectangles[i][0] / (double)rectangles[i][1];
        }

        for (int i = 0; i < rectangles.length; i++) {
            for (int j = i + 1; j < rectangles.length; j++) {
                if (ratios[i] == ratios[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}