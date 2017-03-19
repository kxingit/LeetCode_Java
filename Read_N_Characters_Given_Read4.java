/*
   The API: int read4(char *buf) reads 4 characters at a time from a file.

   The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

   By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
   */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        // 4:09 - 4:12 - 4:35
        char[] tmp = new char[4];
        int len = 0;
        while(len < n) {
            int curcount = read4(tmp);
            for(int k = 0; k < curcount; k++) {
                buf[len + k] = tmp[k];
            }
            len += curcount;
            if(curcount < 4) break;
        }
        return Math.min(len, n);
    }
}

// v2
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buf4 = new char[4];
        int index = 0;
        
        while (index < n) {
            int size = read4(buf4);
            if(size == 0) break;
            for (int i = 0; i < size && index < n; i++) {
                buf[index++] = buf4[i];
            }
        }
        return index;
    }
}
