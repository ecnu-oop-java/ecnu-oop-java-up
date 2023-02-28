# 熟悉数组，字符串以及FileIO

在实验过程中我们将频繁使用数组，字符串和文件操作。希望通过本次实验大家能够熟悉这些内容。

## 字符串

1. 逐个运行**StringDemo.java**中的代码。（自己运行熟悉，不用提交）
<!--
2. 给定一个不含空格的字符串(通过命令行输入),打印该字符串，并打印其长度、小写形式、大写形式。
-->

## 数组

1. 逐个运行**ArrayDemo.java**中的代码。（自己运行熟悉，不用提交）
<!--
2. 给定命令行参数 n1, n2 创建两个整型二维数组，第一个数组的大小是n1 * n2, 第二个数组的大小是n1 * n2，并利用Math.random()函数为每个元素赋予随机值，分别打印出来，然后计算两个数组的对应元素和，把最终的结果再打印出来。
-->

## 文件IO

1. 学会调用 **FileIO.java** 中的函数。

   - 调用4次writeStringToFile()，逐行写入以下内容到test.txt中(总共四行)

      ```
      《老人与海》这本小说是根据真人真事写的。第一次世界大战结束后，海明威移居古巴，认识了老渔民格雷戈里奥·富恩特斯。
      1930年，海明威乘的船在暴风雨中沉没，富恩特斯搭救了海明威。从此，海明威与富恩特斯结下了深厚的友谊，并经常一起出海捕鱼。
      The novel The Old Man and the Sea is based on a real story. After the end of World War I, Hemingway moved to Cuba, where he met an old fisherman, Gregorio Fuentes.
      In 1930, Hemingway was rescued by Fuentes when his boat sank in a storm. From then on, Hemingway and Fuentes formed a deep friendship, and often went fishing together.
      ```

   - 针对test.txt文件，调用getCharFromFile()，返回第5个字符，并打印出来。
   - 针对test.txt文件，调用getLineFromFile(),返回第3行，并打印出来。
   - 针对test.txt文件，调用getAllLinesFromFile()，返回所有行，并打印出来。
