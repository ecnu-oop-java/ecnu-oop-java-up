# 向量（Vector）

## 简介

[向量 (vector)](https://en.wikipedia.org/wiki/Euclidean_vector) 是数学与工程中最基础的对象之一。在欧几里得空间中，一个向量可以表示“方向 + 大小”，也可以看作从原点指向某点的有向线段。在二维/三维空间中，我们通常用坐标来表示向量：

$$
\mathbf{v} = (x, y) \in \mathbf{R}^2 \quad \text{或} \quad \mathbf{v} = (x, y, z)\in \mathbf{R}^3.
$$

更一般地，在 $n$ 维空间：

$$
\mathbf{v} = (v_1, v_2, \dots, v_n) \in \mathbf{R}^n.
$$

向量在物理（速度、力）、计算机图形学（位置、法向量）、机器学习（特征向量、嵌入表示）等领域无处不在。本 Project 通过实现向量类，练习设计清晰的 API，并理解不同表示方式下的向量运算。

------

## 向量的运算

考虑两个二维向量 $\mathbf{a}=(x_1,y_1)$ 与 $\mathbf{b}=(x_2,y_2)$。

- 加法 (addition):

$$
\mathbf{a}+\mathbf{b} = (x_1+x_2,, y_1+y_2)
$$

- 减法 (subtraction):

$$
\mathbf{a}-\mathbf{b} = (x_1-x_2,, y_1-y_2)
$$

- 数乘 (scalar multiplication):

$$
c\mathbf{a} = (cx_1,, cy_1)
$$

- 模长/范数 (magnitude / norm):

$$
|\mathbf{a}| = \sqrt{x_1^2+y_1^2}
$$

- 点积 (dot product):

$$
\mathbf{a}\cdot\mathbf{b} = x_1x_2+y_1y_2
$$

- 向量夹角：

$$
\cos\theta = \frac{\mathbf{a}\cdot\mathbf{b}}{|\mathbf{a}||\mathbf{b}|}
$$

- 二维“叉积”标量 (2D cross / oriented area):

$$
\mathbf{a}\times\mathbf{b} = x_1y_2 - y_1x_2
$$

## 极坐标形式 (Polar Form)

二维向量也可以用极坐标表示：

$$
\mathbf{v} = (r,\theta), \quad r\in[0,\infty),\ \theta\in(-\pi,\pi]
$$

与笛卡尔坐标的关系：

$$
x = r\cos\theta,\quad y=r\sin\theta
$$

反过来：

$$
r=\sqrt{x^2+y^2},\quad \theta=\mathrm{atan2}(y,x)
$$

极坐标下旋转非常方便：将角度加上 $\alpha$ 即可得到旋转后的向量。

------

## 实验内容

1. 定义 `VectorCart` 类，它使用笛卡尔坐标系来代表二维向量，包含以下 API 且为不可变的 (immutable)。

   | 方法                                | 说明                                                |
   | ----------------------------------- | --------------------------------------------------- |
   | `VectorCart(double x, double y)`    | 构造函数                                            |
   | `VectorCart add(VectorCart v)`      | 返回与 v 的和                                       |
   | `VectorCart subtract(VectorCart v)` | 返回与 v 的差                                       |
   | `VectorCart scale(double c)`        | 返回与实数 c 的数乘                                 |
   | `double dot(VectorCart v)`          | 返回点积                                            |
   | `double cross(VectorCart v)`        | 返回二维叉积标量 $x_1y_2-y_1x_2$                    |
   | `double norm()`                     | 返回模长 $|\mathbf{v}|$                             |
   | `VectorCart normalize()`            | 返回单位向量（长度为 1），零向量需处理异常/特殊返回 |
   | `double angleTo(VectorCart v)`      | 返回与 v 的夹角（弧度），需处理零向量               |
   | `double getX()`                     | 返回 x 分量                                         |
   | `double getY()`                     | 返回 y 分量                                         |
   | `boolean equals(VectorCart v)`      | 是否等于 v（注意 double 比较策略）                  |
   | `String toString()`                 | 字符串表示                                          |

2. 思考并回答以下问题：

   - 在 API 中加入方法 `VectorCart add(VectorCart a, VectorCart b)`（返回三个向量的和）是否合适？

   - 在 API 中加入方法 `VectorCart scale(double c)` 是否合适？如果已经有 `multiply`/`times` 命名，哪种更清晰？

   - 在 API 中加入方法 `boolean isZero()`（是否为零向量）是否合适？

   - 在 API 中加入方法 `void setX(double x)`（修改 x 分量）是否合适？为什么与 immutable 冲突？

   - 在 API 中去掉方法 `double norm()` 是否合适？（模长是否能由其他 API 间接得到？代价是什么？）

   - 在 API 中去掉减法 `subtract` 是否合适？（是否能由加法与 `scale(-1)` 表示？可读性如何？）

   - 在 API 中去掉 `getX()/getY()` 是否合适？（直接暴露字段 vs 封装）

   - 以下两种使用方法哪一种更好？为什么？

     ```java
     VectorCart a = new VectorCart(1, 2);
     VectorCart b = new VectorCart(3, 4);
     
     double x = a.getX() + b.getX();
     double y = a.getY() + b.getY();
     VectorCart c = new VectorCart(x, y);
     ```

     ```java
     VectorCart a = new VectorCart(1, 2);
     VectorCart b = new VectorCart(3, 4);
     VectorCart c = a.add(b);
     ```

3. 为 `VectorCart` 类增加方法 `VectorPolar toPolar()` 返回它的极坐标表示。

4. 为 `VectorCart` 类增加下列 API（极坐标下实现应更自然）：

   | 方法                                     | 说明                                       |
   | ---------------------------------------- | ------------------------------------------ |
   | `VectorPolar rotate(double alpha)`       | 返回将向量逆时针旋转 $\alpha$ 弧度后的结果 |
   | `double angle()`                         | 返回向量的极角 $\theta$                    |
   | `double radius()`                        | 返回向量的模长 $r$                         |
   | `VectorPolar projectOnto(VectorPolar v)` | 返回投影到 v 上的向量（需处理零向量）      |

5. 给定二维平面上的三个点 $A(x_1,y_1), B(x_2,y_2), C(x_3,y_3)$, 输出三角形面积与方向:

   - 用向量表示:
   $\overrightarrow{AB}=B-A$ ,
   $\overrightarrow{AC}=C-A$

   - 三角形面积:
      $$
      S = \frac{1}{2}\left|\overrightarrow{AB}\times\overrightarrow{AC}\right|
      $$

   - 方向: 若 $\overrightarrow{AB}\times\overrightarrow{AC} > 0$ 则 $A\to B\to C$ 为逆时针, 否则为顺时针(等于 0 则共线)

