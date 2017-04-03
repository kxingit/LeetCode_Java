/*
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 */
public class BSTIterator {
    
    // 3:48 - 3:53
    private Stack<TreeNode> stack;
 
    public BSTIterator(TreeNode root) {
         stack = new Stack();
         this.pushLeft(stack, root);
    }
 
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() > 0;
    }
 
    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        if(node.right != null) {
            this.pushLeft(stack, node.right);
        }
        return node.val;
    }
    
    private void pushLeft(Stack<TreeNode> stack, TreeNode root) {
        if(root == null) return;
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}

// v2
public class BSTIterator {
    // 8:51 - 8:56
    public Stack<TreeNode> stack = new Stack();
    public TreeNode node;
    
    public BSTIterator(TreeNode root) {
        this.node = root;
      while(node != null) {
          stack.push(node);
          node = node.left;
      }  
        
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        node = stack.pop();
        TreeNode p = node.right;
        while(p != null) {
            stack.push(p);
            p = p.left;
        }
        return node.val;
    }
}


// v3
public class BSTIterator {
    // 10:13 - 10:16
    Stack<TreeNode> stack;
 
    public BSTIterator(TreeNode root) {
        stack = new Stack();
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
 
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() > 0;
    }
 
    /** @return the next smallest number */
    public int next() {
        TreeNode res = stack.pop();
        TreeNode node = res.right;
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
        return res.val;
    }
}


// v4
public class BSTIterator {
    // 4:36 - 4:42
    Stack<TreeNode> stack;
    TreeNode root;
 
    public BSTIterator(TreeNode root) {
        stack = new Stack();
        this.root = root;
        while(this.root != null) {
            stack.push(this.root);
            this.root = this.root.left;
        }
    }
 
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() > 0;
    }
 
    /** @return the next smallest number */
    public int next() {
        root = stack.pop();
        int res = root.val;
        if(root.right != null) {
            root = root.right;
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
        }
        return res;
        
    }
}

// v5: improved
public class BSTIterator {
    // 4:36 - 4:42 - 4:45
    Stack<TreeNode> stack;
 
    public BSTIterator(TreeNode root) {
        stack = new Stack();
        root = root;
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
 
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() > 0;
    }
 
    /** @return the next smallest number */
    public int next() {
        TreeNode root = stack.pop();
        int res = root.val;
        root = root.right;
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
        return res;
        
    }
}
