package src;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] rectangles = new int[][]
        {
            {4,8},{3,6},{10,20},{15,30}
        };
        System.out.println(s.interchangeableRectangles(rectangles));


        int[][] rectangles2 = new int[][]
        {
            {4,2},{1,3},{4,1},{4,2},{2,4},{1,1},{1,1}
        };
        System.out.println(s.interchangeableRectangles(rectangles2));
    }
}
