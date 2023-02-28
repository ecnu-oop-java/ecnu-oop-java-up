# 长整数

## 简介
Java 内置的整数类型 `int` 为32 bit. 
它可以表示的整数范围为 $-2^{31}$ 到 $2^{31}-1$ (约40亿个数).
这些整数足够应对普通的任务. 但一些特殊任务, 可能需要能够支持更大范围的整数.
例如在加密算法(如 [RSA](https://en.wikipedia.org/wiki/RSA_(cryptosystem)) )中, 往往需要用到很大的素数. 素数越大, 加密算法越安全. 
又如, 在一些模拟程序中, 为了达到足够的精度, 需要能够支持更大的整数.
长整数以对它们的操作是
[高精度计算](https://en.wikipedia.org/wiki/Arbitrary-precision_arithmetic)
的一个基本组成部分.

Java 已经包含一个长整数类
[BigInteger](http://docs.oracle.com/javase/8/docs/api/java/math/BigInteger.html).
本次Project需要你自己动手实现一个类似的类. 


## 实验内容

1. 实现长整数类BigInt, 支持任意精度的整数及其运算. 包含以下 API :

    | 方法  |  说明|
    |--- | ---|
    |BigInt()                  | 默认构造函数, 初始化为0 |
    |BigInt(String s)          | 使用字符串构造长整数 |
    |BigInt add(BigInt x)      | 返回与 x 的和 |
    |BigInt subtract(BigInt x) | 返回与 x 的差 |
    |BigInt multiply(BigInt x) | 返回与 x 的积 |
    |BigInt divide(BigInt x)   | 返回除以 x 后的商 |
    |BigInt mod(BigInt x)      | 返回除以 x 后的余数 |
    |int compare(BigInt x)     | 返回1 如果大于 x, -1如果小于 x, 0如果相等 |
    |boolean equals(BigInt x)  |是否等于x |
    |String toString()         |返回字符串表示|

2. 使用 BigInt 计算阶乘函数 $n!$ 及指数函数 $2^n$.

3. 比较 BigInt 与 int 的性能差异 (例如做多次运算时间上的区别). 并尝试分析原因.

4. 比较 BigInt 与 Java 自中 BigInteger 的性能差异, 并尝试分析原因.

3. 除了已经使用的方法外, 你能否想到其他方法来实现 BigInt ?

