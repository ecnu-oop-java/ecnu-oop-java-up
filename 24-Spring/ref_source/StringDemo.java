import java.io.* ;

public class StringDemo{
    public static void main(String[] args) {
        // example 1
        // String str;
        // str = new String("Hello World!");
        // System.out.println(str);
        // str = "Hello World!";
        // System.out.println(str);

        // example 2

        // String s1 = "abc";
        // String s2 = "abc";
        // String s3 = s1;
        // System.out.println(s1 == s2);
        // System.out.println(s3 == s2);
        // System.out.println(s1.equals(s2));
        // System.out.println(s2.equals(s3));

        // String s4 = new String("abc");
        // String s5 = new String("abc");
        // System.out.println(s4 == s5);
        // System.out.println(s4.equals(s5));

        // ==============10 basic methods====================
        String str1 = "  I love Java!  ";
        String str2 = " Java DON'T LOVE ME....";
        System.out.println("==== str1 and str2 ====");
        System.out.println(str1);
        System.out.println(str2);

        // 返回字符串的长度
        System.out.println("==== int length() ====");
        System.out.println(str1.length());
        System.out.println(str2.length());
        
        //将串中字符变成大写
        System.out.println("==== String toUpperCase() ====");
        System.out.println(str1.toUpperCase());
        System.out.println(str2.toUpperCase());
        
        //将串中字符变成小写
        System.out.println("==== String toLowerCase() ====");
        System.out.println(str1.toLowerCase());
        System.out.println(str2.toLowerCase());

        //返回位置i处的字符
        System.out.println("==== char charAt(int i) ====");
        System.out.println(str1.charAt(3));
        System.out.println(str1.charAt(10));

        // 返回从位置s到e的字符子串[s,e)
        System.out.println("==== String substring(int s,int e) ====");
        System.out.println(str1.substring(3,7));
        System.out.println(str2.substring(6, 12));

        // 返回从位置s到末尾的字符子串
        System.out.println("==== String substring(int s) ====");
        System.out.println(str1.substring(3));
        System.out.println(str2.substring(6));

        // 返回首次出现字符串s的位置
        System.out.println("==== int indexOf(String s) ====");
        System.out.println(str1.indexOf("a"));
        System.out.println(str1.indexOf("kkk"));

        // 返回在位置i之后首次出现s的位置
        System.out.println("==== int indexOf(String s,int i) ====");
        System.out.println(str1.indexOf("a", 11));

        // 返回一个新串，去除前后空白字符
        System.out.println("==== String trim() ====");
        System.out.println(str1.trim());
        System.out.println(str2.trim());

        // 返回一个新串，将a替换为b
        System.out.println("==== String replace(String a,String b) ====");
        System.out.println(str1.replace("Java", "Python"));
    }
}
