
# 使用String

在这个Project中, 你将熟悉 Java String 类的使用. 
几乎每一个 Java 程序都会使用到 String 对象.
回忆一下, 在 C 语言中, 字符串的处理需要调用 `string.h` 中的字符串函数.
例如 `strcmp, strlen` 等. 而从面向对象编程的视角来看, 
它们可以看成每一个字符串提供给外界的访问接口. 
外部程序通过调用这些接口可以获得字符串的信息.
而相比起 C 语言中仅将有限的字符串操作作为标准库函数, 
String 类作为 Java 语言的一个部分(你不用 import 任何包就能使用 String),
提供了更丰富的接口. 
希望通过 String 你可以熟悉 Java 中类和对象的基本使用方法.

## String 简介

关于 String 类的详细信息, 
可以参考 [Java 文档](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html).
也可以阅读Thinking in Java 中的 String 一章. 下面列出一些 String 类的主要方法:

|方法  | 说明|
|---|---|
|String(char []s)                    |构造函数, 从字符串数组构造 String|
|String(String s)                    |构造函数, 用String s 构造|
|int length()                        |返回字符串长度|
|char charAt(int i)                  |返回位置 i 处的字符|
|String substring(int s, int e)      |返回从位置 s 到位置 e 的子串|
|String substring(int s)             |返回从位置 s 开始的子串|
|String toUpperCase()                |返回一个全大写的字符串|
|String toLowerCase()                |返回一个全小写的字符串|
|boolean startsWith(String s)        |是否以字符串 s 开头|
|boolean endsWith(String s)          |是否以字符串 s 结尾|
|int indexOf(String s)               |返回首次出现字符串 s 的位置|
|int indexOf(String s, int i)        |返回位置 i 之后首次出现字符串 s 的位置|
|int lastIndexOf(String s)           |返回最后一次出现字符串 s 的位置|
|String trim()                       |返回一个新的字符串, 去除了原字符串前后的空白字符|
|String replace(String a, String b)  |返回一个新的字符串, 将原字符串中 a 替换为 b|
|int compareTo(String a)             |与字符串 a 通过词典序比较大小|


注意, Java 中 String 对象是**不可变的 (Immutable)**. 直观的说,
一旦创建了一个 String 对象, 就不能修改它. 
比如 `s.toUpperCase()` 并不是将 s 中的每个字符修改为对应的大写字符,
而是创建一个新的 String 对象, 这个对象中每个字符字符为原来字符的大写. 

## 实验内容

1. 给定一个字符串 (通过命令行参数形式, 以下各题相同), 判断它是否是一个网址 (假设所有网址以"http:" 开头).
2. 给定一个网址字符串, 根据 "." 将它分解成字串. 例如 http://www.ecnu.edu.cn 分解成为 http://www, ecnu, edu, cn. (提示: 使用 split() 方法)
3. 给定一个代表文件的字符串, 输出它的扩展名. 例如: a.jpg 输出 jpg.
4. 给定一个代表 Unix 文件路径的字符串, 输出它的路径名与文件名. 例如 /home/tom/documents/a.jpg, 路径名为 /home/tom/documents/, 文件名为 a.jpg
5. 从命令行中读入一串字符, 将其中的单引号替换成双引号, 输出到标准输出. 
6. 编写程序 Cat.java, 它可以有任意多的命令行参数, 每个参数为一个文件名. Cat.java 将文件按照参数的顺序合并成一个文件, 并将合并后的文件内容输出到标准输出.
7. 给定一个字符串, 代表一个16进制数. 将其转换成10进制整数, 输出到标准输出. 
8. 给定一个文件, 其中每行一个词. 输出包含字符最多的词. 如果存在多个这样的词(假设不超过10个), 则将它们都输出. 
9. 给定一个字符串, 将其倒序输出. 要求不使用循环语句. 
10. 给定一个文件, 统计其中26个英文小写字母出现的频率. 
11. 编写程序 Print.java, 它有以下命令行选项, 根据不同的选项得到不同的运行结果.

    |选项|用法举例    |说明|
    |---|---|---|
    |-t |`java Print -t type`    |若 type=n 则输出0到9的数字, type=a 则输出a到z的字母, 默认 type=n (即不带 -t 选项执行 `java Print` 将输出数字)|
    |-o |`java Print -o out.txt` |输出到文件out.txt. 默认输出到标准输出|
    |-h |`java Print -h`         |输出帮助信息到标准输出, 不输出其他信息|

    例如 `java Print -t a -o a.txt` 将输出 a 到 z 到文件 a.txt. `java Print -o b.txt` 输出数字0到9到 b.txt. `java Print -t a`, 将输出 a 到 z 到标准输出.  `java Print -h` 输出的帮助信息为

    ```shell
    usage: % java Print [OPTIONS]
    -t type       if type=n print 0-9, if type=a print a-z. Default: type=n
    -o out.txt    outputs to out.txt, Default: standard out
    -h            print this help informantion
    ```

除了以上列出的三种选项, 如果输入其他的选项将输出错误信息 "Wrong options", 随后打印帮助信息并退出.

12. 给定一个字符串, 判断它能否作为一个安全的密码. 安全密码的要求如下:
    * 至少8个字符
    * 包含至少1个数字
    * 至少包含一个大写字母
    * 至少包含一个非字母字符


