/*
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 */
public class Solution {
    public int findComplement(int num) {
        // 2:38 - 2:39
        int mask = Integer.highestOneBit(num << 1) - 1;
        num = ~num;
        return num & mask;
    }
}

// v2
public class Solution {
    public int findComplement(int num) {
        int mask = Integer.highestOneBit(num) * 2 - 1;
        // int mask = Integer.highestOneBit(num << 1) - 1;
        num = ~num;
        return num & mask;
    }
}

// v3
public class Solution {
    public int findComplement(int num) {
        // 10:19 - 10:20
        int mask = Integer.highestOneBit(num) - 1;
        return (~num) & mask;
    }
}

// v4
public class Solution {
    public int findComplement(int num) {
        // 10:29 -10:49
        int i = 1;
        while((i << 1) > 0) {
            i = i << 1;
        }
        while((i & num) == 0) {
            i = i >> 1;
        }
        return (~num) & (i - 1);
    }
}
