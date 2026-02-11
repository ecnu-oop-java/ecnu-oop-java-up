# 有理数（BigRational）

## 简介

Java 内置的浮点数类型 `float/double` 可以表示很大的范围，但它们对很多十进制小数（例如 0.1）只能做近似表示，因此在连续运算时会产生舍入误差与累积误差。在一些任务中，我们希望结果是**精确的**，而不是“差不多”。

一个常见的精确表示方法是使用**有理数**：用分子与分母两个整数来表示一个数

$$
\frac{p}{q}, \quad q \neq 0
$$

只要分子分母都是整数，有理数就能精确表示有限小数、循环小数以及大量数学计算过程中的中间结果。

Java 提供了高精度整数类 [BigInteger](http://docs.oracle.com/javase/8/docs/api/java/math/BigInteger.html) ，但本 Project 需要你动手实现一个**任意精度的有理数类** `BigRational`，从而理解：

- 如何设计良好的类接口（API）
- 如何定义数据表示与规范化（约分、符号统一）
- 如何实现精确运算与比较
- 精确计算与性能之间的取舍

------

## 实验内容

1. 实现有理数类 `BigRational`，支持任意精度有理数及其运算。包含以下 API：

   | 方法                                  | 说明                                                         |
   | ------------------------------------- | ------------------------------------------------------------ |
   | `BigRational()`                       | 默认构造函数，初始化为 0（即 0/1）                           |
   | `BigRational(String s)`               | 使用字符串构造有理数（如 `"123/456"`, `"-7/3"`, `"2.5"`, `"0"`, `"-0.125"`） |
   | `BigRational add(BigRational x)`      | 返回与 x 的和                                                |
   | `BigRational subtract(BigRational x)` | 返回与 x 的差                                                |
   | `BigRational multiply(BigRational x)` | 返回与 x 的积                                                |
   | `BigRational divide(BigRational x)`   | 返回除以 x 后的商（x ≠ 0）                                   |
   | `int compare(BigRational x)`          | 返回 1 如果大于 x，-1 如果小于 x，0 如果相等                 |
   | `boolean equals(BigRational x)`       | 是否等于 x（按数学意义相等）                                 |
   | `String toString()`                   | 返回字符串表示（推荐输出最简分数形式，如 `"-7/3"` 或 `"5"`） |

   **实现要求：**

   - 内部表示使用两个任意精度整数：`numerator`（分子）与 `denominator`（分母），可直接使用 Java `BigInteger`，也可复用你自己实现的 `BigInt`。
   - 构造与每次运算后必须**规范化**（normalize）：
     1. 分母永远为正（符号放在分子上）
     2. 分子分母必须约分到最简（使用最大公约数gcd实现）
     3. 0 必须表示为 `0/1`

2. 使用 `BigRational` 完成精确计算任务:

- 计算调和级数
        
$$
H_n=\sum_{k=1}^{n}\frac{1}{k}
$$

  要求输出 `H_n` 的精确分数表示（可能非常大），并给出其十进制近似（实现 `toDecimal(int digits)`）。
    
- 计算连分数逼近：

1. $\sqrt{2}$ 的连分数逼近: $[1;2,2,2,\dots]$
2. $e$ 的连分数逼近: $[2;1,2,1,1,4,1,1,6,\dots]$

  给定一个连分数：
     
$$
[a_0; a_1, a_2, \dots, a_k]
= a_0 + \cfrac{1}{a_1 + \cfrac{1}{a_2 + \cdots + \cfrac{1}{a_k}}}
$$

  其中 $a_0$ 是整数, $a_i(i\ge 1)$ 是正整数.

  把长度从 0 增加到 k 的这些值：
      
$$
C_0=[a_0],\ C_1=[a_0;a_1],\ \dots,\ C_k=[a_0;a_1,\dots,a_k]
$$
      
  称为该连分数的 **k 阶收敛（convergent）**, 每个 $C_k$ 都是一个有理数, 所以你必须用 `BigRational` 精确表示与输出它.

3. 比较 `BigRational` 与 `double` 的精度与性能差异（例如做多次运算的时间区别），并尝试分析原因。

4. 除了已经使用的方法外，你能否想到其他方法来实现“精确数值计算”？