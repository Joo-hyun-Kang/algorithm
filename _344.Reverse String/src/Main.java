public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String text = "hello";
        char[] textArray = text.toCharArray();
        solution.reverseString(textArray);

        System.out.println(textArray);

    }
}