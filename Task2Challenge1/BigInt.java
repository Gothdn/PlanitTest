public class BigInt {
    final long _denom = 1000000000000000L;
    final int _digitLen = 15;
    final int _maxLen = 100001;
    long[] num;
    int len;

    public BigInt(long x) {
        num = new long[_maxLen];
        len = 0;
        while (x > 0) {
            num[len] = x % _denom;
            len++;
            x = x / _denom;
        }
    }

    public BigInt(long[] num, int len) {
        this.num = new long[_maxLen];
        this.num = num;
        this.len = len;
    }

    public BigInt(String s) {
        this.num = new long[_maxLen];
        len = 0;
        System.out.println(s + "\n");
        while (s.length() > _digitLen) {
            num[len] = Long.parseLong(s.substring(s.length() - _digitLen, s.length()));
            s = s.substring(0, s.length() - _digitLen);
            len++;
        }
        num[len] = Long.parseLong(s);
        len++;
    }

    public int length() {
        return len;
    }

    public long at(int i) {
        return num[i];
    }

    //  n1 always < n2
    public BigInt add(BigInt num2) {
        long[] res = new long[_maxLen];
        long t = 0;

        for (int i = 0; i < num2.length(); i++) {
            res[i] = (num[i] + num2.at(i) + t) % _denom;
            t = (num[i] + num2.at(i) + t) / _denom;
        }

        int l = num2.length();
        if (t > 0) {
            res[l] = t;
            l++;
        }
        return new BigInt(res, l);
    }

    //  n1 always > n2
    public BigInt subtract(BigInt num2) {
        long[] res = new long[_maxLen];
        long t = 0;
        for (int i = 0; i < len; i++) {
            res[i] = num[i] - num2.at(i) - t;
            if (res[i] < 0) {
                res[i] += _denom;
                t = 1;
            } else {
                t = 0;
            }
        }

        if (t < 0) {
            res[len - 1] = num[len - 1] - t;
        }

        if (res[len - 1] == 0) {
            len --;
        }

        return new BigInt(res, len);
    }

    public String toString() {
        String res = "";
        for (int i = 0; i < len; i++) {
            res = num[i] + res;
        }
        return res;
    }

    public int compare(BigInt num2) {
        if (len < num2.length()) {
            return -1;
        } else if (len > num2.length()) {
            return 1;
        }
        for (int i = len - 1; i >= 0; i--) {
            if (num[i] < num2.at(i)) {
                return -1;
            } else if (num[i] > num2.at(i)) {
                return 1;
            }
        }
        return 0;
    }
}