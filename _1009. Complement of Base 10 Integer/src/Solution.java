class Solution {
    public int bitwiseComplement(int n) {

        // nの２進法の補数
        //　10 => 1010　すぐ　0101　変換
        // 3
        // 0011
        // 0000

        // 5
        // 101
        // 010
        int res = recursive(n,0);

        return -1;
    }

    public int recursive(int value, int depths) {
        if (value == 0) {
            return 0;
        }

        int res = recursive(value / 2, depths + 1);

        if (value % 2 == 0) {
            // 多分いらない
            res += 0;
        } else {
            res += 2 * depths;
        }

        return res;
    }

    // 1 -> 1 -> 0
    // 0 -> 0 -> 1

    // 2 -> 10 -> 01
    // 3 -> 11 -> 00

    // 4 -> 100 -> 011
    //     3210
    //     0124

}