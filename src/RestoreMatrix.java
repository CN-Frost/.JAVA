public class RestoreMatrix {
    public static int[][] restoreMatrix(int[] rowSum, int[] colSum){
        int i=0,j=0;
        int rowMax=rowSum.length,colMax=colSum.length;
        int[][] Ans=new int[rowMax][colMax];
        while (!(i==rowMax||j==colMax)){
            if(rowSum[i]<colSum[j])
            {
                Ans[i][j]=rowSum[i];
                for(int k=j+1;k<colMax;k++)Ans[i][k]=0;
                colSum[j]-=rowSum[i];
                i++;
            }
            else
            {
                Ans[i][j]=colSum[j];
                for(int k=i+1;k<rowMax;k++)Ans[k][j]=0;
                rowSum[i]-=colSum[j];
                j++;
            }
        }
        return Ans;
    }
}
