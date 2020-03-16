/*
（1）这种方法表示的二叉树，每个节点的左右孩子节点必存在（因为不存在用 # 表示了，相当于存在）
（2）将字符串拆分，从后向前压栈
（3）遇到 # 直接入栈
（4）遇到数字 x，那就说明 x 是 根节点，弹出两个栈顶元素，并将这个数字 x 压栈，成为 x 的父结点的子结点
（5）如果是合法的，最后栈中只会剩一个根元素
*/



class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] ss = preorder.split(",");
        int len = ss.length;
        if(len == 1){  //特殊情况判断
            if(ss[0].equals("#")) 
                return true;
            return false;
        }
        Stack<String> stack = new Stack<String>();
        for(int i = len - 1; i >= 0; i --){   // 由后往前
            String s = ss[i];
            if(stack.empty()){
                stack.push(s);
                continue;
            }
            if(s.equals("#")){
                stack.push(s);
            }
            else{
                if(stack.size() < 2) return false;
                String s1 = stack.pop();
                String s2 = stack.pop();
                stack.push(s);
            }
        }
        if(stack.size() == 1)
            return true;
        return false;
    }
}