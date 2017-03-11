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
