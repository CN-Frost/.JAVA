public class FindLengthOfLCIS {
    public static int findLengthOfLCIS(int[] nums) {
        if(nums.length==0)return 0;
        int Ans=1,temp=1;
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
