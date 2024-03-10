class Solution {
    public int bitwiseComplement(int n) {

        // nの２進法の補数
        //　10 => 1010　すぐ　0101　変換
        // 3
        // 0101
        //

        int copy = n;
        int res = 0;
        while (copy > 0) {
            if (copy % 2 == 0) {
                // 10
                // 5
                // 0 ->
            }

            copy /= 2;
        }

        return -1;
    }
}