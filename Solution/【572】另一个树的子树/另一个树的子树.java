/*
（1）因为是判断子树，而不是子结构，所以要完全相同
（2）写一个函数判断两棵树是否完全相同，剩下的就好写了
*/



class Solution {
    // 判断两树是否相等
    private boolean isEqual(TreeNode l, TreeNode r){
        if(l == null && r == null) return true;  //两树均空自然相等
        if(l == null || r == null) return false;  //一空一非空，自然不等
        if(l.val == r.val)   //递归判断
            return isEqual(l.left, r.left) && isEqual(l.right, r.right);
        return false;
    }

     // 判断 t 树是否是 s 树的子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null)
            return true;
        if(s == null || t == null) return false;
        if(s.val == t.val){
            return isEqual(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        // 根节点不同，那么就不同考虑s和t相等的情形了
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
}