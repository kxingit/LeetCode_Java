/*
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 */
public class Codec {  
 
    public String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    private void serialize(TreeNode x, StringBuilder sb){
        if (x == null) {
            sb.append("# ");
        } else {
            sb.append(x.val + " ");
            serialize(x.left, sb);
            serialize(x.right, sb);
        }
    }
    
    public TreeNode deserialize(String s){
        if (s == null || s.length() == 0) return null;
        java.util.StringTokenizer st = new java.util.StringTokenizer(s, " ");
        return deserialize(st);
    }
    
    private TreeNode deserialize(java.util.StringTokenizer st){
        if (!st.hasMoreTokens())
            return null;
        String val = st.nextToken();
        if (val.equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserialize(st);
        root.right = deserialize(st);
        return root;
    }
}  

// v2
public class Codec {
    // 6:42 - 6:54
    java.util.StringTokenizer st;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "# ";
        }
        StringBuffer sb = new StringBuffer();
        sb.append(root.val + " ");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        
        return sb.toString();
    }
 
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) {
            return null;
        }
        st = new java.util.StringTokenizer(data, " ");
        return deserial(st);
    }
    
    public TreeNode deserial(java.util.StringTokenizer st) {
        if(!st.hasMoreTokens()) {
            return null;
        }
        String val = st.nextToken();
        if(val.equals("#")) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserial(st);
        root.right = deserial(st);
        
        return root;
    }
}

// v3
public class Codec {
    // 1:54 - 2:01
    java.util.StringTokenizer st;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String s = "";
        if(root == null) {
            s += "# ";
            return s;
        }
        
        s += root.val + " ";
        s += serialize(root.left);
        s += serialize(root.right);
        
        return s;
    }
 
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        st = new java.util.StringTokenizer(data);
        return deserial(st);
    }
    
    public TreeNode deserial(java.util.StringTokenizer st) {
        if(!st.hasMoreTokens()) {
            return null;
        }
        
        String val = st.nextToken();
        if(val.equals("#")) {
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserial(st);
        root.right = deserial(st);
        
        return root;
    }
}

// v4
public class Codec {
    // 10:46 - 12:26
 
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "# ";
        String res = "";
        res += root.val + " ";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }
 
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] sa = data.split(" ");
        System.out.print(Arrays.toString(sa));
        return deserial(sa, new int[]{0});
    }
    
    public TreeNode deserial(String[] sa, int[] i) { // need "reference" variable
        if(sa[i[0]].equals("#")) {
            i[0]++;
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(sa[i[0]]));
        i[0]++;
        root.left = deserial(sa, i);
        root.right = deserial(sa, i);
        
        return root;
    }
}

// v5
public class Codec {
    // 12:46 － 1:07
    int i = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "# ";
        String res = "";
        res += root.val + " ";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }
 
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] sa = data.split(" ");
        System.out.print(Arrays.toString(sa));
        i = 0;
        return deserial(sa);
    }
    
    public TreeNode deserial(String[] sa) {
        if(sa[i].equals("#")) {
            i++;
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(sa[i]));
        i++;
        root.left = deserial(sa);
        root.right = deserial(sa);
        
        return root;
    }
}


// v6: TLE
public class Codec {
    // 1:09 - 1:13
    int i = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res = "";
        if(root == null) return "#,";
        
        res += root.val + ",";
        res += serialize(root.left);
        res += serialize(root.right);
        
        i = 0;
        
        return res;
    }
 
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] sa = data.split(",");
        if(sa[i].equals("#")) {
            i++;
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(sa[i]));
        i++;
        root.left = deserialize(data);
        root.right = deserialize(data);
        
        return root;
    }
}

// v7
public class Codec {
    // 1:09 - 1:13 - 1:15
    int i = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res = "";
        if(root == null) return "#,";
        
        res += root.val + ",";
        res += serialize(root.left);
        res += serialize(root.right);
        
        return res;
    }
 
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialize(data.split(","));
    }
    
    public TreeNode deserialize(String[] sa) {
        if(sa[i].equals("#")) {
            i++;
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(sa[i]));
        i++;
        root.left = deserialize(sa);
        root.right = deserialize(sa);
        
        return root;
    }
}
