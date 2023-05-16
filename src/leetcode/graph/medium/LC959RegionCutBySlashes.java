package leetcode.graph.medium;

public class LC959RegionCutBySlashes {

    public static void main(String[] args) {
        String[] grid = {"/\\","\\/"};

        int len=grid.length;
        int dots=len+1;
        DisjointSetBySize ds=new DisjointSetBySize(dots*dots);

        int count=1;
        for(int i=0;i<dots;i++){
            for(int j=0;j<dots;j++){
                if(i==0 || j==0 || i==dots-1 || j==dots-1){
                    int dotLocation=i*dots+j;
                    ds.unionBySize(0,dotLocation);
                }
            }
        }

        for(int i=0;i<grid.length;i++){
            char[] stringArray=grid[i].toCharArray();
            for(int j=0;j<stringArray.length;j++){
                if(stringArray[j]=='/'){
                    int left=(i+1)*dots+j;
                    int right=i*dots+(j+1);
                    int pLeft=ds.findParent(left);
                    int pRight=ds.findParent(right);
                    if(pLeft==pRight)
                        count++;
                    ds.unionBySize(left,right);
                }else if(stringArray[j]=='\\'){
                    int left=i*dots+j;
                    int right=(i+1)*dots+(j+1);
                    int pLeft=ds.findParent(left);
                    int pRight=ds.findParent(right);
                    if(pLeft==pRight)
                        count++;
                    ds.unionBySize(left,right);
                }
            }
        }
        System.out.println(count);
    }
}
