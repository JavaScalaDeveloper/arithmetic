package main.java.code;
import lombok.Data;

import java.io.*;
public class HJ16 {
    public static class Main{
        public static int dw = 100;
        public static void main(String[] args)throws IOException{
            boolean flag = true;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] firstArr = br.readLine().split(" ");
            int N = Integer.parseInt(firstArr[0]);
            int m = Integer.parseInt(firstArr[1]);
            Good[] A = new Good[m+1];
            for(int i = 1;i<=m;i++){
                String[] perArr = br.readLine().split(" ");
                int v = Integer.parseInt(perArr[0]);
                int p = Integer.parseInt(perArr[1]);
                int q = Integer.parseInt(perArr[2]);
                if(flag)
                    if(v%dw!=0){
                        flag = false;
                        dw = 10;
                        for(int j = 1;j<i;j++){
                            A[j].v = A[j].v*dw;
                        }
                    }
                v=v/dw;
                A[i] = new Good(v, p, q);
                if(q>0){
                    if(A[q].a1 == 0){
                        A[q].a1=i;
                    }else{
                        A[q].a2=i;
                    }
                }
            }
            N=N/dw;
            check(N,A);
        }

        public static void check(int N,Good[] A ){
            int[][] dp = new int[A.length][N+1];
            for(int i=1;i<A.length;i++){
                int v=-1,v1=-1,v2=-1,v3=-1,tmpDp=-1,tmpDp1=-1,tmpDp2=-1,tmpDp3=-1;
                v = A[i].v;//主件
                tmpDp = v*A[i].p;
                if(A[i].a2!=0&&A[i].a1!=0){//主件+附件1+附件2
                    v3 = v+A[A[i].a2].v+A[A[i].a1].v;
                    tmpDp3 = tmpDp + A[A[i].a2].v*A[A[i].a2].p+ A[A[i].a1].v*A[A[i].a1].p;
                }
                if(A[i].a1!=0){//主件+附件1
                    v1 = v+A[A[i].a1].v;
                    tmpDp1 = tmpDp + A[A[i].a1].v*A[A[i].a1].p;
                }
                if(A[i].a2!=0){//主件+附件2
                    v2 = v+A[A[i].a2].v;
                    tmpDp2 = tmpDp + A[A[i].a2].v*A[A[i].a2].p;
                }

                for(int j = i;j<=N;j++){
                    dp[i][j] = dp[i-1][j];
                    if(A[i].q==0){//是主件
                        if(j>=v&&v!=-1)dp[i][j] = Math.max(dp[i][j],dp[i-1][j-v]+tmpDp);
                        if(j>=v1&&v1!=-1)dp[i][j] = Math.max(dp[i][j],dp[i-1][j-v1]+tmpDp1);
                        if(j>=v2&&v2!=-1)dp[i][j] = Math.max(dp[i][j],dp[i-1][j-v2]+tmpDp2);
                        if(j>=v3&&v3!=-1)dp[i][j] = Math.max(dp[i][j],dp[i-1][j-v3]+tmpDp3);
                    }
                }

            }
            System.out.print(dp[A.length-1][N]*dw);

        }
    }
    @Data
    static class Good{
        public int v;//价值
        public int p;//重要度
        public int q;//是否是附件，>0附件，=0主件
        public int a1;//附件1编号
        public int a2;//附件2编号

        public Good(int v,int p,int q){
            this.v = v;
            this.p = p;
            this.q = q;
        }

    }
}
