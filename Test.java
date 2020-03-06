输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list=new ArrayList<>();
        int l=1;
        int r=1;
        int sum=0;
        for(;r<target;r++){
            sum+=r;
            while(sum>target){
                sum-=l++;
            }
            if(sum==target){
                int[] tmp=new int[r-l+1];
                for(int i=0;i<tmp.length;i++){
                    tmp[i]=l+i;
                }
                list.add(tmp);
            }
        }
        int[][] res=new int[list.size()][];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }
}

class Solution {
    public int[][] findContinuousSequence(int target) {
        Stack<int[]> stack=new Stack<>();
        int sum=0;
        for(int i=2;i<target/2;i++){
            sum+=(i-1);
            int tmp=target-sum;
            if(tmp<=0){
                continue;
            }
            if(tmp%i==0){
                int start=tmp/i;
                int[] arr=new int[i];
                for(int j=0;j<arr.length;j++){
                    arr[j]=start+j;
                }
                stack.push(arr);
            }
        }
        int[][] res=new int[stack.size()][];
        int j=0;
        while(!stack.isEmpty()){
            res[j++]=stack.pop();
        }
        return res;
    }
}

