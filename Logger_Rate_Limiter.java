/*
 * Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.
 *
 * Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.
 *
 * It is possible that several messages arrive roughly at the same time.
 */

public class Logger {
    // 6:07 - 6:09 - 6:12
    
    HashMap<String, Integer> map;
 
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message) == false) {
            map.put(message, timestamp);
            return true;
        }
        
        int oldtime = map.get(message);
        if(timestamp - oldtime >= 10) {
            map.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }
}

// v2
public class Logger {
    // 10:23 - 10:25
    HashMap<String, Integer> map;
 
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message) == false) {
            map.put(message, timestamp);
            return true;
        } else {
            int oldtime = map.get(message);
            if(timestamp - oldtime >= 10) {
                map.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        }
    }
}
