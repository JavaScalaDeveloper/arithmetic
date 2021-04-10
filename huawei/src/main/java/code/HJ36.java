package main.java.code;
import java.io.*;

public class HJ36 {
    /**
     * HJ36	字符串加密
     * 字符串加密
     * 题目描述
     * 有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。下面是它的工作原理：首先，选择一个单词作为密匙，如TRAILBLAZERS。如果单词中包含有重复的字母，只保留第1个，其余几个丢弃。现在，修改过的那个单词属于字母表的下面，如下所示：
     * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
     * T R A I L B Z E S C D F G H J K M N O P Q U V W X Y
     * 上面其他用字母表中剩余的字母填充完整。在对信息进行加密时，信息中的每个字母被固定于顶上那行，并用下面那行的对应字母一一取代原文的字母(字母字符的大小写状态应该保留)。因此，使用这个密匙，Attack AT DAWN(黎明时攻击)就会被加密为Tpptad TP ITVH。
     * 请实现下述接口，通过指定的密匙和明文得到密文。
     * 本题有多组输入数据。
     * 输入描述:
     * 先输入key和要加密的字符串
     * 输出描述:
     * 返回加密后的字符串
     * 示例1
     * 输入
     * nihao
     * ni
     * 输出
     * le
     */
    public static class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String key;
            while ((key = br.readLine()) != null) {
                char[] chars = key.toLowerCase().toCharArray();
                char[] dict = new char[26];
                int index = 0;
                tag1:
                for (char ch : chars) {
                    for (int i = 0; i < index; i++) {
                        if (ch == dict[i]) {
                            continue tag1;
                        }
                    }
                    dict[index] = ch;
                    index++;
                }
                char ch = 'a';
                tag2:
                for (int i = 0; i < 26; i++) {
                    for (int j = 0; j < index; j++) {
                        if (dict[j] == ch) {
                            ch++;
                            continue tag2;
                        }
                    }
                    dict[index] = ch;
                    ch++;
                    index++;
                }
                String str = br.readLine();
                char[] res = str.toCharArray();
                for (int i = 0; i < res.length; i++) {
                    if(res[i] - 'a'>=0){
                        res[i] = dict[res[i] - 'a'];
                    }else{
                        res[i] = dict[res[i] - 'A'];
                    }
                }
                System.out.println(String.valueOf(res));
            }
        }
    }
}
