/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
*/
public class Solution {
    public String simplifyPath(String path) {
        // 1:10 - 1:14 - 1:22
        String[] input = path.split("/");
        List<String> output = new ArrayList();
        
        for(String dir : input) {
            if(dir.equals("")) continue;
            if(dir.equals(".")) {
                continue;
            } else if(dir.equals("..")) {
                if(output.size() > 0) {
                    output.remove(output.size() - 1);
                }
            } else {
                output.add(dir);
            }
        }
        
        String res = "/";
        for(String s : output) {
            res += s + "/";
        }
        
        if(res.length() == 1) return res;
        return res.substring(0, res.length() - 1); // bug, from '0'
    }
}

// v2
public class Solution {
    public String simplifyPath(String path) {
        // 1:10 - 1:14 - 1:22
        String[] input = path.split("/");
        List<String> output = new ArrayList();
        
        for(String dir : input) {
            if(dir.equals("")) continue;
            if(dir.equals(".")) {
                continue;
            } else if(dir.equals("..")) {
                if(output.size() > 0) {
                    output.remove(output.size() - 1);
                }
            } else {
                output.add(dir);
            }
        }
        
        String res = "";
        for(String s : output) {
            res += "/" + s;
        }
        
        if(res.length() == 0) return "/";
        return res;
    }
}

// v3
public class Solution {
    public String simplifyPath(String path) {
        // 1:10 - 1:14 - 1:22
        String[] input = path.split("/");
        List<String> output = new ArrayList();
        
        for(String dir : input) {
            if(dir.equals("")) continue;
            if(dir.equals(".")) {
                continue;
            } else if(dir.equals("..")) {
                if(output.size() > 0) {
                    output.remove(output.size() - 1);
                }
            } else {
                output.add(dir);
            }
        }
        
        StringBuffer res = new StringBuffer();
        for(String s : output) {
            res.append("/");
            res.append(s);
        }
        
        if(res.length() == 0) return "/";
        return res.toString();
    }
}
