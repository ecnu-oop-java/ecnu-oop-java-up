# 基本类型与控制流

本次作业你将熟悉 Java 的基本类型 (primitive type), 表达式 (expression) 和控制结构 (control flow).
这些"面向过程"的方法是实现"面向对象"编程的基础. 另一方面, 你将复习模块化编程 (modular programming): 练习如何定义, 使用静态函数, 使用静态类编写一个简单的库. 希望此次作业能够帮助你了解 Java 的基础语法, 特别是它与 C 语言的区别. 同时, 希望通过强调"模块化"的概念, 为今后学习面向对象的设计打下基础.

## 基本类型的封装 (Wrappers of primitive types)

Java 为一些基本类型提供了封装 (Wrapper). 通过封装, Java 可以提供更丰富的面向的基本类型操作. 
以下我们以整型为例说明如何使用这些基本类型的封装. 考虑一个32位整型变量

```java
int a = 0;
```

用户可以对 a 进行加法, 乘法等运算. 但对一些较复杂的操作, 仍需要自行实现. 
例如, 给定一个由数字组成的字符串 ("12235"), 将其转换成对应的整数 (问题: C 语言这个功能是如何实现?).
为了更方便用户使用, Java 将整型封装成为 Integer 类, 并在其中提供了一些针对整型的复杂操作. 例如, 为了将字符串转换成为整型, Integer 类提供了静态方法 parseInt():

```java
String s = "12235";
int a = Integer.parseInt(s);
System.out.println(a == 12235);
```

又如, Integer 类提供了方法 toBinaryString(), 返回整形变量的二进制表示字符串:

```java
int a = 11235;
String s = Integer.toBinaryString(a):
System.out.println(s);
```

> 事实上, 除了使用 Integer 类的静态方法外, 我们也可以使用 Integer 类的对象: `Integer a = new Integer(11235);`. 在作为函数参数时, 或者在赋值表达式中, Integer 对象和 int 可以通用. 例如对于上面的 Integer 对象 a, 我们可以将其赋值给 int 型变量 b `int b = a;`, 反之亦然. Java 编译器提供了这些情况下 int 到 Integer 对象的自动转换 (称为 autoboxing), 以及 Integer 对象到 int 的转换 (称为 unboxing). 关于 autoboxing 和 unboxing 可以参考[这里](https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html).

关于 Integer 类的详细文档在[这里](https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html).
除了整型外, 对于一些其他基本类型也有类似的封装:
[Boolean](https://docs.oracle.com/javase/7/docs/api/java/lang/Boolean.html),
[Byte](https://docs.oracle.com/javase/7/docs/api/java/lang/Byte.html),
[Character](https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html),
[Double](https://docs.oracle.com/javase/7/docs/api/java/lang/Double.html),
[Float](https://docs.oracle.com/javase/7/docs/api/java/lang/Float.html),
[Long](https://docs.oracle.com/javase/7/docs/api/java/lang/Long.html),
[Short](https://docs.oracle.com/javase/7/docs/api/java/lang/Short.html).

## 随机数

我们可以使用 Math 包中的 random 方法产生 0 到1 间的随机数: 

```java
double r = Math.random();
```

例如, 以下代码将以概率 p 输出1, 以概率 1-p 输出0:

```java
double r = Math.random();
if (r < p)
    return 1;
else
    return 0;
```

> [Random 类](https://docs.oracle.com/javase/7/docs/api/java/util/Random.html) 也提供了产生随机数的接口. 


##实验内容

### 基本类型和控制语句

1. 以下表达式是否能够通过编译? 如果能够通过, 表达式的类型是什么? 表达式的值是什么? 请尝试解释原因.
    * 1 == True
    * 1 == true 
    * 0 == false
    * 2 + "ab"
    * 2.3 + "ab"
    * 2 + 'a'
    * 2 * "ab"
    * 2 * 'a'
    * 1 + 1.0
    * 1/3
    * 1.0/3

2. 假设`int a = 2147483647;` (即, `Integer.MAX_VALUE`). 请问以下语句的输出值是什么? 并解释原因.

    ```java
    System.out.println(a);
    System.out.println(a + 1);
    System.out.println(2 - a);
    System.out.println(-2 - a);
    System.out.println(2 * a);
    System.out.println(4 * a);
    ```

3. 函数`Math.sqrt(double t)` 计算一个数的平方根. 表达式`Math.sqrt(2)*Math.sqrt(2) == 2`的值是什么?

4. 给定命令行参数 x1, y1, x2, y2. 计算平面上的点 (x1, y1) 和 (x2, y2) 的距离. 

5. 计算函数 $\log x, x, x\log x, x^2, x^3$ 在 $x=1, 2, 4, 8, 16, ..., 2048$ 处的值. 并比较它们的增长速度. 

6. 使用牛顿法([1](https://en.wikipedia.org/wiki/Newton%27s_method),[2](http://gitlinux.net/2018-12-27-newton-method/))计算平方根.  对于可导函数 $f(x)$, 牛顿法用于计算 $f$ 的零点 ( $f(x) = 0$ ). 令 $f(x)$ 在 $t$ 的导数为 $f'(t)$. 给定初始值 $x_0$, 首先计算过点 $(x_0, f(x_0))$, 斜率为 $f'(x_0)$ 的直线与 $x$ 轴的交点, 令该点为 $x_1$. 对 $x_1$, 计算过点 $(x_1, f(x_1))$, 斜率为 $f'(x_1)$ 的直线与 $x$ 轴的焦点, 令其为 $x_2$ . 重复以上过程直到得到点 $x_n$ 使得 $f(x_n) = 0$ (过程参见[1](http://archives.math.utk.edu/visual.calculus/3/newton.5/1.html)). 计算 $\sqrt{c}$ 等价于找函数 $f(x) = x^2 -c$ 的零点. 

7. 给定5个整数 (通过命令行参数), 找出它们的中位数 (即第3大的数). 
<!--
8. 给定5个整数 (通过命令行参数), 找出它们的中位数, 要求使用"比较"操作的次数不超过6次. 是否存在算法能够使用更少的比较操作找到中位数? 
9. 一对夫妻希望得到男孩和女孩. 他们不停的生孩子, 直到一个不同性别的孩子出生. 假设生男孩和女孩的概率均为 0.5. 请通过模拟, 计算出他们平均会有多少个孩子. 并输出有多少可能性有2个孩子, 3个孩子和4个孩子. 假设概率不是 0.5, 结果会有什么不同?
-->

### 数组

8. 以下程序的运行结果是什么?

```java
int[] a = { 1, 2, 3 };
int[] b = { 1, 2, 3 };
System.out.println(a == b);
```

9. Hadamard 矩阵 $H(N)$ 为 $2^{N-1}\times 2^{N-1}$ 的方阵. 矩阵中的元素为 0 或者 1. $H(1) = [1]$, 

$$\begin{eqnarray*}
H(N) = 
\begin{bmatrix}
H(N-1) & H(N-1) \\
H(N-1) & \neg H(N-1)
\end{bmatrix}
\end{eqnarray*}$$

其中 $\neg H(N-1)$ 表示将$H(N-1)$中的0变成1, 1变成0. 例如:

$$\begin{eqnarray*}
H(2) = 
\begin{bmatrix}
1 & 1 \\
1 & 0
\end{bmatrix},
H(3) = 
\begin{bmatrix}
1 & 1 & 1 & 1 \\
1 & 0 & 1 & 0 \\
1 & 1 & 0 & 0 \\
1 & 0 & 0 & 1 
\end{bmatrix}
\end{eqnarray*}$$

给定 $N$, 请输出 $H(N)$.

10. Alice 去参加一个聚会. Bob 也在这个聚会中. 看到 Alice 之后, Bob 把一个和 Alice 有关的八卦谣言告诉了他的一个同伴. 随后谣言开始在聚会中传播. 假设人们都按照以下方式传递谣言: 如果他第一次听到, 则从其他的人中随机选择一个 (除了告诉他的那个人和Alice), 将谣言传递出去. 如果他已经知道了这个谣言, 那么他停止传播. 请通过模拟来估计在谣言传播停止前, 所有人(除了 Alice)都知道这个谣言的概率. 同时, 请估计听到谣言人数的期望值. 

11. 给定整数 N , 输出 1 到 N 的所有排列. 利用本题测试第7题中寻找中位数的算法是否正确.

12. 任何 1 到 N 的排列可以定义一个 $\{1, 2, ..., N\}$ 到自身的函数 (称为一个 N 阶[置换](https://en.wikipedia.org/wiki/Permutation)). 例如, 令排列 $(2, 5, 4, 3, 1)$ 对应的置换为 $\sigma$, 则它的取值为 

$$\begin{eqnarray*}
\sigma(1) = 2, ~ \sigma(2) = 5, ~ \sigma(3) = 4, ~ \sigma(4) = 3, ~ \sigma(5) = 1.
\end{eqnarray*}$$

置换 $\sigma, \tau$ 的积定义为它们的函数复合 $\tau\circ\sigma$ (即, $\tau\circ\sigma(i) = \tau(\sigma(i)), ~ \forall i$). 显然 $\tau\circ\sigma$ 同样为一个置换. 例如若 $\tau = (2, 1, 4, 5, 3), \sigma=(2, 5, 4, 3, 1)$, 则 $\tau\circ\sigma$ 的取值为

$$\begin{eqnarray*}
\tau\circ\sigma(1) = \tau(\sigma(1)) = \tau(2) = 1 \\
\tau\circ\sigma(2) = \tau(\sigma(2)) = \tau(5) = 3 \\
\tau\circ\sigma(3) = \tau(\sigma(3)) = \tau(4) = 5 \\
\tau\circ\sigma(4) = \tau(\sigma(4)) = \tau(3) = 4 \\ 
\tau\circ\sigma(5) = \tau(\sigma(5)) = \tau(1) = 2
\end{eqnarray*}$$

因此 $\tau\circ\sigma = (1, 3, 5, 4, 2)$ . 定义衡等置换 $e = (1,2,..N)$ (即, $e(i) = i, ~ \forall i$ ).
定义置换 $\sigma$ 的逆 $\sigma^{-1}$ 满足 $\sigma\circ\sigma^{-1} = \sigma^{-1}\circ\sigma = e$. 给定一个置换, 输出它的逆. 要求除了存储置换的数组外不能使用其他的数组.


13. 8 皇后问题. 我们可以用排列代表国际象棋棋盘上皇后的位置. 例如排列 $(5, 2, 4, 1, 3)$ 可以代表如下棋盘的布局
```
    * * * Q * 
    * Q * * * 
    * * * * Q 
    * * Q * * 
    Q * * * * 
```
其中, 每一个Q代表一个皇后, 星号表示空白棋格. 给定排列, 输出其代表的棋盘是否是一个"安全"的棋盘, 要求除了存储排列的数组外, 不能使用其他的数组. 国际象棋规则中, 一个皇后可以 "吃掉" 任何和它处于同一直线上的棋子(即同列, 同行, 同对角线, 同反对角线). 例如, 以下棋盘中A, B, C, D位置的棋子都可以被皇后吃掉, 类似的位置被称为"不安全位置".
```
    * * B * * 
    * A * * * 
    * * Q * C
    * * * * * 
    D * * * * 
```
一个"安全"的棋盘为棋盘中所有皇后都处在安全位置 (不会被其他的皇后吃掉.)


14. 给定N, 输出N阶蛇型矩阵 $S(N)$ . 以下分别是 $S(1), S(2), S(3), S(4)$ .

$$\begin{eqnarray*}
S(1) = 
\begin{bmatrix}
1
\end{bmatrix},
S(2) = 
\begin{bmatrix}
1 & 2 \\
4 & 3
\end{bmatrix},
S(3) = 
\begin{bmatrix}
1 & 2 & 3 \\
8 & 9 & 4 \\
7 & 6 & 5
\end{bmatrix},
S(4) = 
\begin{bmatrix}
1 & 2 & 3 & 4 \\
12 & 13 & 14 & 5\\
11 & 16 & 15 & 6\\
10 & 9 & 8 & 7
\end{bmatrix}
\end{eqnarray*}$$

<!--
17. [歌德巴赫猜想](https://en.wikipedia.org/wiki/Goldbach%27s_conjecture). 1742年, 歌德巴赫 (Goldbach) 在写给欧拉 (Euler) 的信中提出提出如下猜想: 任何大于2的偶数都能写成两个素数的和. 例如16 = 11 + 5 = 3 + 13.  这个猜想至今仍未被证实. 但对于$N < 4\times 10^{18}$的偶数,  通过计算机穷举可以确定该猜想成立. 给定N, 输出它的素数分解. 
-->

### 库文件

15. 编写库文件 Statistic.java, 包含如下静态方法:

    |方法 |说明|
    |---| --- |
    |double max(double a[])         |返回数组a中的最大值|
    |double min(double a[])         |返回数组a中的最小值|
    |double mean(double a[])        |返回数组a的均值|
    |double variance(double a[])    |返回数组a的方差|
    |double select(double a[], k)   |返回数组a中第k大的数|
    |int []histogram(double a[])    |返回数组b, b[i]表示a[i]在a中出现的次数|
    
    假定数据文件的格式为每行一个[0, 1]间的数字. 编写程序Compute.java, 从命令行获得数据文件的名称, 输出该文件中数字的最大值, 均值, 方差, 中位数. 同时输出出现次数最多的数, 最靠近均值的数, 与均值的距离小于1倍方差, 2倍方差, 3倍方差的数. 


