/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         int n1 = p.val;
         int n2 = q.val;

         ArrayList<TreeNode> path1 = new ArrayList<>();
         ArrayList<TreeNode> path2 = new ArrayList<>();

         getPath(root, n1, path1);
         getPath(root, n2, path2);

         int i = 0;
         for(; i < path1.size() && i < path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
         }
         TreeNode lca = path1.get(i - 1);
         return lca;
    }

    public static boolean getPath(TreeNode root, int n, ArrayList<TreeNode> path) {
        if(root == null){
            return false;
        }
        path.add(root);
        if(root.val == n){
            return true;
        }

        boolean left = getPath(root.left, n, path);
        boolean right = getPath(root.right, n, path);

        if(left || right){
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }
}