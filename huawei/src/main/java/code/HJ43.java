package main.java.code;
import java.io.*;

public class HJ43 {
    /**
     * HJ43	迷宫问题
     * 迷宫问题
     * 题目描述
     * 定义一个二维数组N*M（其中2<=N<=10;2<=M<=10），如5 × 5数组下所示：
     * int maze[5][5] = {
     * 0, 1, 0, 0, 0,
     * 0, 1, 0, 1, 0,
     * 0, 0, 0, 0, 0,
     * 0, 1, 1, 1, 0,
     * 0, 0, 0, 1, 0,
     * };
     * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。入口点为[0,0],既第一空格是可以走的路。
     * 本题含有多组数据。
     * 输入描述:
     * 输入两个整数，分别表示二位数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
     * 输出描述:
     * 左上角到右下角的最短路径，格式如样例所示。
     * 示例1
     * 输入
     * 5 5
     * 0 1 0 0 0
     * 0 1 0 1 0
     * 0 0 0 0 0
     * 0 1 1 1 0
     * 0 0 0 1 0
     * 输出
     * (0,0)
     * (1,0)
     * (2,0)
     * (2,1)
     * (2,2)
     * (2,3)
     * (2,4)
     * (3,4)
     * (4,4)
     */
    public static class Main{
        public static void main(String[] args)throws Exception {
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            String str="";
            while((str=br.readLine())!=null) {
                String[] strs= str.split(" ");
                int m= Integer.parseInt(strs[0]);
                int n= Integer.parseInt(strs[1]);
                int[][] nums=new int[m][n];
                for(int i=0;i<m;i++){
                    String strr = br.readLine();
                    String[] b = strr.split(" ");
                    for(int j=0;j<n;j++){
                        nums[i][j] = Integer.parseInt(b[j]);
                    }
                }
                String[] res={""};
                peocess(nums,0,0,"(0,0)\n",res);
                if(res[0].length()==0) System.out.println("(0,0)");
                else System.out.println(res[0].substring(0,res[0].length()-1));
            }
        }
        public static void peocess(int[][]arr,int x,int y,String path,String[]res) {
            if ((x==arr.length-1)&&(y==arr[x].length-1)) {
                if (arr[x][y]==0)
                    res[0]=path;
                return;
            }
            if (x>arr.length-1||y>arr[x].length-1)
                return;
            if (x+1<arr.length&&arr[x+1][y]==0)
                peocess(arr,x+1,y,path+"("+(x+1)+","+y+")\n",res);
            if (y+1<arr[x].length&&arr[x][y+1]==0)
                peocess(arr,x,y+1,path+"("+x+","+(y+1)+")\n",res);
        }
    }
}
