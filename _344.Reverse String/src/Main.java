public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String text = "hello";
        char[] textArray = text.toCharArray();
        solution.reverseString(textArray);

        System.out.println(textArray);

        char[] text2 = {'s', 'y'};
        solution.reverseString(text2);
        System.out.println(text2);


    }
}