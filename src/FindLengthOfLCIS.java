public class FindLengthOfLCIS {
    public static int findLengthOfLCIS(int[] nums) {
        int Ans=1,temp=1;
        if(nums.length==0)return 0;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]>=nums[i+1]){
                Ans=Math.max(temp,Ans);
                temp=1;
            }
            else temp++;
        }
        return Math.max(temp,Ans);
    }
}
