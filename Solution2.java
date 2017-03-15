import java.util.*;
public class Solution {

	public static void main(String[] s) {
//		Scanner reader = new Scanner(System.in);  // Reading from System.in
//		System.out.println("Enter a number: ");
//		int n = reader.nextInt();

		Solution solution = new Solution();

		List res = solution.readBinaryWatch(Integer.parseInt(s[0]));
		
		System.out.print(Arrays.toString(res.toArray()));
	}

    public int int2bit(int x) {
        int num = 0, temp = x;
        while(temp != 0) {
            if((temp & 0x01) == 0x01) {
                num++;
            }
            temp >>= 1;
        }
        return num;
    }
 
    public List<String> readBinaryWatch(int num) {
        if(num < 0 || num > 10) return null;
        List<String> watches = new ArrayList<String>();
        for(int i = 0; i < 12; i++) {
            for(int j = 0; j < 60; j++) {
                if(int2bit(i) + int2bit(j) == num) {
                    if(j < 10)
                        watches.add(i + ":0" + j);
                    else
                        watches.add(i + ":" + j);
                }
            }
        }
        return watches;
    }

}
