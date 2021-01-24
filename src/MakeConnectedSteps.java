public class MakeConnectedSteps {
    private static int[] f;
    public static int makeConnected(int n, int[][] connections) {
        int Ans = 0, edge = connections.length;
        if (n > edge + 1) return -1;
        f = new int[n];
        for(int i=0;i<n;i++)f[i]=i;
        fUnion(connections);
        for(int i=1;i<n;i++)
        {
            if(find(i)!=find(0))
            {
                Ans++;
                f[find(i)]=f[0];
            }
        }
        return Ans;
    }
    private static void fUnion(int[][] edges){//初始化
        for(int[] edge:edges)
        {
            if(find(edge[0])!=find(edge[1])) {f[find(edge[0])]=f[edge[1]];}
        }//合并
    }
    private static int find(int x){
        return x==f[x]?x:(f[x] = find(f[x]));
    }
}
