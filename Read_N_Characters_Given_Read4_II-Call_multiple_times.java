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
    char[] buf4 = new char[4];
    int buf4size = 0;
    int buf4idx = 0;
    public int read(char[] buf, int n) {
        // 11:47 - 11:55 - 12:10
        int i = 0;
        
        while(i < n) {
            if(buf4idx == buf4size) {
                buf4size = read4(buf4);
                buf4idx = 0;
                if(buf4size == 0) break;
            } 
            
            if(buf4idx < buf4size) {
                buf[i++] = buf4[buf4idx++];
            }
        }
        return i;
    }
}

// v2
public class Solution extends Reader4 {
    // 12:17 - 12:19
    char[] buf4 = new char[4];
    int buf4size = 0;
    int buf4idx = 0;
    
    public int read(char[] buf, int n) {
        int i = 0;
        
        while(i < n) {
            if(buf4idx == buf4size) {
                buf4size = read4(buf4);
                buf4idx = 0;
                if(buf4size == 0) break;
            }
            
            if(buf4idx < buf4size) {
                buf[i++] = buf4[buf4idx++];
            }
        }
        
        return i;
    }
}
