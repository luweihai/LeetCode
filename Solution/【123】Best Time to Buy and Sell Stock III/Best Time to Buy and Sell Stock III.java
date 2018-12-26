/*
121题的拓展，121题只需要交易一次，顺序遍历一遍即可找到最大差。
现在可以交易两次，我们容易想到，只要计算出所有prices[0,i]和prices[I,len-1]的和，找到最大的即可。
对于prices[0,i] 同121题，只需遍历一次储存到leftProfit[]中即可。
对于prices[I,len-1],我们可以从后往前遍历一遍即可。储存在rightProfit[]中
切记右边部分只能从右到左遍历
最后找到i使得firstProfit[I]+SecondProfit[I]最大就是最大贸易值。
*/



class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int length = prices.length;
        int[] leftProfit = new int[length];
        int[] rightProfit = new int[length];
        
        int minPrice = prices[0]; // 记录遍历过程中当前结点左边的最小的价格
        for(int i = 0 ; i < length ; i ++){  // 其实这个循环就是只买卖一次的时候的最大收益
            if(prices[i] < minPrice)        
                minPrice = prices[i];
            leftProfit[i] = prices[i] - minPrice; 
            if(i != 0 && leftProfit[i] < leftProfit[i-1])  // 此处保证当前结点的最大收益是基于之前遍历的结点
                leftProfit[i] = leftProfit[i-1];
        }
        
        int maxPrice = prices[length - 1];  // 记录遍历过程中当前结点右边的最大的价格
        for(int i = length - 1 ; i >= 0 ; i --){  // 右边部分的最大收益，就要从右边到左边遍历
            if(prices[i] > maxPrice)             
                maxPrice = prices[i];
            rightProfit[i] = maxPrice - prices[i];
            if( i != length - 1 && rightProfit[i] < rightProfit[i+1]) // 此处保证当前结点的最大收益是基于之前遍历的结点
                rightProfit[i] = rightProfit[i+1];
        }
        int result = 0;
        for(int i = 0 ; i < length ; i ++){
            int temp = leftProfit[i] + rightProfit[i];
            if(temp > result)
                result = temp;
        }
        return result ;
    }
}