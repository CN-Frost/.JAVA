import org.jetbrains.annotations.NotNull;

public class MinCostConnectPoints {
    static int[] f;
    public static int minCostConnectPoints(int[][] points) {
        int Ans=0;
        int n=points.length;
        int[] this.f=
        for(int i=0;i<n;i++)f=i;
        //初始化并查集
        Edge pointEdge=new Edge();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                pointEdge.len[i][j]=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
            }
        }//创建邻接矩阵
        Ans+=minEdge(pointEdge);
        //按边从小到大的顺序进行连接
        return Ans;
    }
    private static int minEdge( Edge X)
    {
        int minE=0,minI=0,minJ=0;
        for(int i=0;i<X.len.length-1;i++) {
            for (int j = i + 1; j < X.len.length; j++) {
                if (i == j || find(i) == find(j)) continue;
                //并查集检测
                if (minE == 0||X.len[i][j] < minE) {
                    minE = X.len[i][j];
                    minI = i;
                    minJ = j;
                }//更新最小边
            }
        }
        f[find(minI)] = find(minJ);//并查集合并
        return minE;
    }
    private static int find(int x) { return f[x] == x ? x : find(f[x]); }//并查集
}
class Edge{ int[][] len;}