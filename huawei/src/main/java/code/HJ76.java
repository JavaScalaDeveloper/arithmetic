package main.java.code;
import java.io.*;
public class HJ76 {
public static class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
            int num = Integer.parseInt(str);
            System.out.println(method(num));
        }
    }
    public static String method(int m){
        int temp = m*m ;
        StringBuilder sb = new StringBuilder() ;
        for(int i=0;i<m;i++){
            if(m%2!=0){
                sb.append(temp-2*(m/2)+2*i).append("+") ;
            }else{
                sb.append(temp-m+1+2*i).append("+") ; ;
            }
        }
        return sb.substring(0,sb.length()-1);
    }
}
}
