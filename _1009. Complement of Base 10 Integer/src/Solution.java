class Solution {
    public int bitwiseComplement(int n) {
        return doLoop(n);
    }

    public int doBitmask(int n) {
        if (n == 0) {
            return 1;
        }

        int mask = 1;
        while (mask < n) {
            mask = (mask << 1) | 1;
        }

        return ~n & mask;
    }

    private int doLoop(int value) {
        if (value == 0) {
            return 1;
        }

        int posValue = 1;
        int res = 0;
        while (value > 0) {
            if (value % 2 == 0) {
                res += posValue;
            }
            value /= 2;
            posValue <<= 1;
        }

        return res;
    }

    private int recursive(int value, int depths) {
        if (value == 0 && depths == 0) {
            return 1;
        }

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