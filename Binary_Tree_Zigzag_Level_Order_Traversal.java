/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 10:51 - 10:59
        List<List<Integer>> result = new ArrayList();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int count = 0;
        while(!q.isEmpty()) {
            int n = q.size();
            List<Integer> level = new ArrayList();
            for(int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                if(count % 2 == 0) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val);
                }
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            count++;
            result.add(level);
        }
        return result;
    }
}

// v2 C++
class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        // 3:15
        vector<vector<int>> result;
        if(!root) return result;
        queue<TreeNode*> q;
        q.push(root);
        int nlevel = 0;
        while(!q.empty()) {
            int n = q.size();
            vector<int> level;
            for(int i = 0; i < n; i++) {
                TreeNode* node = q.front();
                q.pop();
                if(nlevel % 2) level.insert(level.begin(), node->val);
                else level.push_back(node->val);
                if(node->left) q.push(node->left);
                if(node->right) q.push(node->right);
            }
            nlevel++;
            result.push_back(level);
        }
        return result;
    }
};
