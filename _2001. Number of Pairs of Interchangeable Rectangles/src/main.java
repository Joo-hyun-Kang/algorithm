public class main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] rectangles = new int[][]
        {
            {4,8},{3,6},{10,20},{15,30}
        };
        System.out.println(s.interchangeableRectangles(rectangles));


        int[][] rectangles2 = new int[][]
        {
            {4,5},{7,8}
        };
        System.out.println(s.interchangeableRectangles(rectangles2));
    }
}
