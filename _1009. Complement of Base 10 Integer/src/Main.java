public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.bitwiseComplement(3));

        // 1 -> 1 -> 0
        // 0 -> 0 -> 1

        // 2 -> 10 -> 01
        // 3 -> 11 -> 00

        // 4 -> 100 -> 011
        //     3210
        //     0124

    }
}