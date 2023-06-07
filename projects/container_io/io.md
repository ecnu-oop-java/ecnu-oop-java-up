# I/O

## 实验内容

1. 给定目录名, 找出该目录下的所有文件和子目录, 并递归的列出所有子目录的内容. 按照以下方式输出

```
parent_dir1:
           |- a.txt
           |- b.txt
           |- sub_dir1:
                      |- e.txt
                      |- f.txt
           |- c.txt
           |- d.txt
parent_dir2:
           | g.txt
...
```


2. 请**通过编写程序**, 比较带缓冲的流和不带缓冲的流在读写性能上的差距. 请给出实验程序源码, 并说明实验比较步骤和实验结果. 

<!--
3. 请阅读 [BufferedOutputStream](http://hg.openjdk.java.net/jdk7u/jdk7u/jdk/file/e146e0fb6dee/src/share/classes/java/io/BufferedInputStream.java) 和 
[DataInputStream](http://hg.openjdk.java.net/jdk7u/jdk7u/jdk/file/e146e0fb6dee/src/share/classes/java/io/DataInputStream.java) 的源代码 (openjdk), 请理解这两个类的继承关系, 每个方法的具体实现, 提交两个代码的逐行注释 (对 DataInputStream, 可以忽略 readUTF() 函数). 请在提交注释后的源文件, 源文件可以在这里下载[BufferedOutputStream.java](http://hg.openjdk.java.net/jdk7u/jdk7u/jdk/raw-file/e146e0fb6dee/src/share/classes/java/io/BufferedInputStream.java), [DataInputStream.java](http://hg.openjdk.java.net/jdk7u/jdk7u/jdk/raw-file/e146e0fb6dee/src/share/classes/java/io/DataInputStream.java).
-->

3. 请阅读 [DataInputStream](http://hg.openjdk.java.net/jdk7u/jdk7u/jdk/file/e146e0fb6dee/src/share/classes/java/io/DataInputStream.java) 的源代码 (openjdk), 请观察它的继承关系, 尝试理解每个方法的具体实现, 提交readBoolean(), readInt() 两个方法的逐行注释及算法说明。请提交注释后的源文件（可以在这里下载[DataInputStream.java](http://hg.openjdk.java.net/jdk7u/jdk7u/jdk/raw-file/e146e0fb6dee/src/share/classes/java/io/DataInputStream.java)）.

