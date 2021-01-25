import org.jetbrains.annotations.Contract;

import java.util.HashSet;
import java.util.Set;

public class RegionsBySlashes {
    public static int regionsBySlashes(String[] grid) {
        int n=grid.length;
        int[] f=new int[4*n*n];
        Set<Integer> count=new HashSet<>();
        for(int i=0;i<4*n*n;i++)f[i]=i;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               int cell=4*(i*n+j);
               mergeInside(f,cell,grid[i].charAt(j));
               if(i<n-1)merge(cell+3,cell+4*n,f);//mergeDown
               if(j<n-1)merge(cell+2,cell+5,f);//mergeRight
            }
        }
        for(int i=0;i<4*n*n;i++)count.add(find(i,f));
        return count.size();
    }
    static int find(int x,int[] f) { return x==f[x]?x:(f[x]=find(f[x],f)); }
    static void merge(int x,int y,int[] f){
        int rootX=find(x,f);
        int rootY=find(y,f);
        if(rootX!=rootY)f[rootX]=rootY;
    }
    static void mergeInside(int[] f, int cell, char divide)
    {
        if(divide=='/'){
            merge(cell,cell+1,f);
            merge(cell+2,cell+3,f);
        }
        else if(divide=='\\'){
            merge(cell,cell+2,f);
            merge(cell+1,cell+3,f);
        }
        else {
            merge(cell,cell+1,f);
            merge(cell,cell+2,f);
            merge(cell,cell+3,f);
        }
    }
}
