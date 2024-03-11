class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }

        return recursive(n,0);
    }

    private int recursive(int value, int depths) {
        if (value == 0) {
            return 0;
        }

        int res = recursive(value / 2, depths + 1);

        // 現時点の数位置の値を知る様にする
        int posValue = 1;
        for (int i = 0; i < depths; i++) {
            posValue *= 2;
        }

        if (value % 2 == 0) {
            res += posValue;
        }

        return res;
    }



}