public class SmallestRepunitDivByK {
    public static int smallestRepunitDivByK(int K) {
    if(K%2==0||K%5==0)return -1;
    int r=1,count=1;
    while (r%K!=0){
        r=(r*10+1)%K;
        count++;
    }
    return count;
}
}
