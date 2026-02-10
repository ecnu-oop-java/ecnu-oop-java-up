# 数值计算

## 背景

### 数值积分 (Numerical Integration)

微积分基本定理 (Newton-Leibniz 公式) $\int_a^b f(x)\mathrm{d}x = F(b) - F(a)$ 是求解定积分的重要方法. 但在实际应用中我们发现仅使用 N-L 公式是不够的. 一方面, 大部分可积函数的原函数不是初等函数(例如 $\frac{\sin(x)}{x}$ ), 无法使用 N-L 公式. 另一方面, 许多函数只是通过实验, 采样等方法获得若干自变量对应的函数值, 而无法确定函数的表达式. 针对这些问题, 我们需要近似算法来估计定积分的值, 其中数值积分是一类重要方法.

为了求解 $\int_a^b f(x)\mathrm{d}x$, 我们希望通过一个可积函数 $p(x)$ 来代替 $f(x)$. 一方面 $p(x)$ 的原函数比较容易求出. 另一方面, $p(x)$ 能够充分逼近 $f(x)$, 使得 $\int_a^b f(x) \approx \int_a^b p(x)$. 在这里, 我们将 $p(x)$ 取为n阶多项式函数 $p_n(x)$.

将积分区间 $[a, b]$ 以步长 $h=\frac{b-a}{n}$ 划分为 $n$ 等分. 以分点 $x_i = a+ih, i = 0, 1, ..., n$ 为结点, 做 $f(x)$ 的 [Lagrange 插值多项式](https://en.wikipedia.org/wiki/Lagrange_polynomial) $p_n(x)$ ,

$$\begin{eqnarray*}
f(x) \approx p_n(x) = \sum_{i=0}^n\left(\prod_{j=0, j\neq i}^n\frac{x-x_j}{x_i-x_j}\right)f(x_i)
\end{eqnarray*}$$

容易验证, $p_n(x_i) = f(x_i)$, 即在分点 $x_1, x_2, ..., x_n$ 处 $p_n(x) = f(x)$. 进一步有,

$$\begin{eqnarray*}
\int_a^bf(x)\mathrm{d}x \approx \int_a^b p_n(x)\mathrm{d}x = (b-a)\sum_{i=0}^nC_i^{(n)}f(x_i)
\end{eqnarray*}$$

其中,

$$\begin{eqnarray*}
C_i^{(n)} = \frac{1}{b-a} \int_a^b\prod_{j=0, j\neq i}^n\frac{x-x_j}{x_i-x_j}\mathrm{d}x
\end{eqnarray*}$$

令 $x = a+th$,

$$\begin{eqnarray*}
C_i^{(n)} = \frac{h}{b-a} \int_0^n\prod_{j=0, j\neq i}^n\frac{t-j}{i-j}\mathrm{d}t
= \frac{1}{n}\frac{(-1)^{n-i}}{i!(n-i)!} \int_0^n\prod_{j=0, j\neq i}^n(t-j)\mathrm{d}t
\end{eqnarray*}$$

这称为 *Newton-Cotes 积分公式*. 通过N-C公式计算定积分, 需要给定 $n+1$ 个分点处的函数值 $f(x_0), f(x_2), ..., f(x_n)$. $C_i^{(n)}$ 称为 Cotes 系数, 它与被积区间与被积函数 $f(x)$ 无关, 可以事先计算好. 

容易看出 $C_i^{(n)}$ 有如下性质

  - $C_i^{(n)} = C_{n-i}^{(n)}, \forall i = 0, 1, ..., n$
  - 由于对 $f(x)\equiv 1$, Newton-Cotes 公式精确成立, 因此

$$\begin{eqnarray*}
& \int_a^b 1\cdot\mathrm{d}x = (b-a)\sum_{i=0}^n C_i^{(n)} \\
\Rightarrow & \sum_{i=0}^n C_i^{(n)} = 1
\end{eqnarray*}$$

### 梯形公式

在 Newton-Cotes 公式中取 $n=1$ (即使用过点 $(a, f(a)), (b, f(b))$ 的线性函数来拟合 $f(x)$ ), 由 Cotes 系数的性质可得 $C_0^{(1)} = C_1^{(1)} = \frac{1}{2}$, 因此

$$\begin{eqnarray*}
\int_a^bf(x)\mathrm{d}x \approx \frac{b-a}{2}\left(f(a) + f(b)\right)
\end{eqnarray*}$$

几何意义是, 通过梯形的面积来近似函数 $f(x)$ 所围成的面积. 

### Simpson 公式

在 Newton-Cotes 公式中取 $n=2$, 

$$\begin{eqnarray*}
& C_0^{(2)} = \frac{1}{4}\int_0^2(t-1)(t-2)\mathrm{d}t = \frac{1}{6} = C_2^{(2)}\\
& C_1^{(2)} = 1- C_0^{(2)} - C_2^{(2)}= \frac{4}{6}
\end{eqnarray*}$$

因此得到 Simpson 公式:

$$\begin{eqnarray*}
\int_a^bf(x)\mathrm{d}x \approx \frac{b-a}{6}\left(f(a) + 4f\left(\frac{a+b}{2}\right)+ f(b)\right)
\end{eqnarray*}$$

### 复化的梯形公式

对积分区间直接使用梯形公式得到的近似往往比较粗略. 我们可以将积分区间 $[a, b]$ 划分为更小的区间, 通过在每一个小的区间上使用梯形公式得到更精确的结果. 这也称为复化的梯形公式.


将$[a, b]$ 以步长 $h=\frac{b-a}{m}$ 划分为 $m$ 等分. $x_i = a+ih, i = 0, 1, ..., m$. 在每一个小区间 $[x_{i-1}, x_i]$ 上使用梯形公式

$$\begin{eqnarray*}
\int_a^bf(x)\mathrm{d}x = \sum_{i=1}^m \int_{x_{i-1}}^{x_i} f(x)\mathrm{d}x \approx \sum_{i=1}^m \frac{h}{2}\left(f(x_{i-1}) + f(x_i)\right) = T_m^{(1)} 
\end{eqnarray*}$$

其中

$$\begin{eqnarray*}
T_m^{(1)}  = \frac{h}{2}\left(f(a) + f(b) + 2\sum_{i=1}^{m-1}f(x_i)\right)
\end{eqnarray*}$$

### 复化的 Simpson 公式

我们可以用同样的方法在小区间中使用 Simpson 公式. 
令 $x_{i-\frac{1}{2}}$ 为$[x_{i-1}, x_i]$ 的中点

$$\begin{eqnarray*}
\int_a^bf(x)\mathrm{d}x = \sum_{i=1}^m \int_{x_{i-1}}^{x_i} f(x)\mathrm{d}x \approx T_m^{(2)} 
\end{eqnarray*}$$

其中

$$\begin{eqnarray*}
T_m^{(2)}  = \frac{h}{6}\left(f(a) + f(b) + 2\sum_{i=1}^{m-1}f(x_i) + 4\sum_{i=1}^mf(x_{i-\frac{1}{2}})\right)
\end{eqnarray*}$$


## 实验内容

1. 定义接口 Function, 包含 eval 方法, 返回函数在自变量 x 处的取值.

```java
double eval(double x)
```

2. 定义 接口 DifferentiableFunction, 扩展 Function 接口表示可微函数, 包含 diff 方法, 返回导函数在变量 x 处的取值.

```java
double diff(double x)
```

3. 通过实现 DifferentiableFunction 接口, 实现以下类
  - Linear 类. 代表函数 $kx+b$, 其中 $k, b$ 为参数
  - Quadartic 类. 代表函数 $ax^2 + bx + c$ 其中, $a, b, c$ 为参数
  - Sin 类. 代表函数 $\sin(\omega x + \varphi)$, 其中 $\omega, \varphi$ 为参数
  - NormalPDF 类. 代表函数 $e^{-\frac{(x-\mu)^2}{2\sigma^2}}$, 其中 $\mu, \sigma$ 为参数.

4. 定义类 NewtonRoot , 包含方法 `findRoot`. 使用牛顿法寻找函数 f 的根 (见 Project 2 第6题).  并对以上四个函数类进行测试.

```java
double findRoot(DifferentiableFunction f)
```

5. 定义类 NewtonCatos, 包含方法 `Trapozoidal` 使用梯形公式计算 f 在 $[a, b]$ 上的积分. 同时包含方法 `Simpson`, 使用 Simpson 公式计算定积分. 对以上四个函数类进行测试. 

```java
double Trapozoidal(Function f, double a, double b)
double Simpson(Function f, double a, double b)
```


