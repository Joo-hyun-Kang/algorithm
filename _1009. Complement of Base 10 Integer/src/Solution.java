class Solution {
    public int bitwiseComplement(int n) {
        return doLoop(n);
    }

    private int doLoop(int value) {
        if (value == 0) {
            return 1;
        }

        int deps = 0;
        int res = 0;
        while (value > 0) {
            if (value % 2 == 0) {
                res += 1 * Math.pow(2, deps);
            }
            value /= 2;
            deps++;
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