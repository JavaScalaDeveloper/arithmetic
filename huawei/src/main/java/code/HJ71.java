package main.java.code;
/**
 * 题目描述
 * 问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。现要求各位实现字符串通配符的算法。
 * 要求：
 * 实现如下2个通配符：
 * *：匹配0个或以上的字符（字符由英文字母和数字0-9组成，不区分大小写。下同）
 * ？：匹配1个字符
 * 输入：
 * 通配符表达式；
 * 一组字符串。
 * 输出：
 * 返回匹配的结果，正确输出true，错误输出false
 * 本题含有多组样例输入！
 * 输入描述:
 * 先输入一个带有通配符的字符串，再输入一个需要匹配的字符串
 * 输出描述:
 * 返回匹配的结果，正确输出true，错误输出false
 * 示例1
 * 输入
 * te?t*.*
 * txt12.xls
 * 输出
 * false
 */

import java.io.*;
class HJ71{
    public static class Main{
        public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String regx ;
            while(null != (regx = br.readLine())){
                String content = br.readLine();
                System.out.println(match(content.toCharArray(),0,regx.toCharArray(),0));
            }
        }

        public static boolean match(char[] content,int offsetContent,char[] regx,int offsetRegx){
            while(offsetContent < content.length && offsetRegx < regx.length){
                if('*' == regx[offsetRegx]){
                    if(offsetRegx == regx.length-1){
                        return true;
                    }else if(isMatch(content[offsetContent],regx[offsetRegx+1]) && match(content,offsetContent,regx,offsetRegx+1)){
                        return true;
                    }else{
                        offsetContent++;
                    }

                }else if('?' == regx[offsetRegx] || content[offsetContent] == regx[offsetRegx]){
                    offsetContent++;
                    offsetRegx++;
                }else{
                    return false;
                }


            }
            return (offsetContent==content.length)&&(offsetRegx==regx.length);
        }

        public static boolean isMatch(char contentChar,char regxChar){
            return '*'==regxChar || '?'==regxChar || contentChar == regxChar;
        }
    }
}
