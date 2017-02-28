/*
   There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.
 */
// TLE: 27 / 35 test cases passed.
public class Solution {
  public int bulbSwitch(int n) {
    // 10:34 - 10:37
    boolean[] isOn = new boolean[n + 1];
    for(int i = 1; i <= n; i++) {
      for(int j = 1; j <= n; j++) {
	if(i % j == 0) isOn[i] = !isOn[i];
      }
    }
    int res = 0;
    for(int i = 1; i <= n; i++) {
      if(isOn[i]) res++;
    }
    return res;
  }
}

// v2
public class Solution {
  public int bulbSwitch(int n) {
    int res = 1;
    while(res * res <= n) {
      res++;
    }
    return res - 1;
  }
}
