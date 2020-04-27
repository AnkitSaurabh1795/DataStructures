/*===================================================Level Order
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level)===================
*
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    
    void bfs(TreeNode A,ArrayList<ArrayList<Integer>> res){
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        while(true){
            ArrayList<Integer> curr = new ArrayList<>(); 
            
            int cnt = q.size();
            if(cnt == 0)
            break;
            while(cnt > 0){
                TreeNode tmp = q.poll();
                curr.add(tmp.val);
                if(tmp.left != null)
                    q.add(tmp.left);
                if(tmp.right != null)
                    q.add(tmp.right);
                
                cnt--;
            }
            res.add(curr);
        }
    }
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        int s = A.val;
        //HashSet<Integer> vis = new HashSet<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        bfs(A,res);
        return res;
    }
}
