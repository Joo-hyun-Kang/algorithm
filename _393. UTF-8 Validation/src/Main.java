public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();

        int[] array1 = {255};
        System.out.println(s.validUtf8(array1));

        int[] array2 = {250,145,145,145,145};
        System.out.println(s.validUtf8(array2));

        array1 = new int[]{197, 130, 1};
        System.out.println(s.validUtf8(array1));

        array1 = new int[]{235, 140, 4};
        System.out.println(s.validUtf8(array1));

        array1 = new int[]{230,136,145};
        System.out.println(s.validUtf8(array1));
    }
}