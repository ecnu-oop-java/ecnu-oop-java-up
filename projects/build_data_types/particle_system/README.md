# 粒子系统

[粒子系统 (Particle System)](https://en.wikipedia.org/wiki/Particle_system)是一类常见的计算机图形/物理模拟方法。它用大量“粒子”来近似表现一些复杂现象，例如喷泉、水花、烟雾、火花、爆炸碎屑、落叶等。单个粒子的行为非常简单：它有位置、速度、寿命等状态，并在每一个时间步按照规则更新；但大量粒子叠加在一起，就会产生非常丰富的视觉效果。

在这个 Project 中，你需要围绕“粒子系统”设计并定义一个类。你需要从问题描述中归纳出合理的抽象、隐藏内部实现细节、给出清晰易用的接口，并用这些接口完成不同的粒子效果绘制。

------

## 简介

### 粒子模型 (Particle Model)

在二维平面中，一个粒子通常包含以下状态：

- 位置: $(x, y)$
- 速度: $(v_x, v_y)$
- 加速度: $(a_x, a_y)$
- 寿命: $life$（随时间减少，降到 0 则消失）
- 外观: 半径 $r$、颜色 $(R,G,B)$、透明度 $\alpha$

粒子系统的核心是：不断“发射”新粒子，并对所有存活粒子做更新与绘制。

### 运动更新 (Time Stepping)

令时间步长为 $\Delta t$。一种常见的离散更新方式是（欧拉法）：

- 速度更新:
  
$$
\mathbf{v}_{t+\Delta t} = \mathbf{v}_t + \mathbf{a}_t \Delta t
$$

- 位置更新:
  
$$
\mathbf{x}_{t+\Delta t} = \mathbf{x}*t + \mathbf{v}*{t+\Delta t}\Delta t
$$

其中 $\mathbf{x}=(x,y), \mathbf{v}=(v_x,v_y), \mathbf{a}=(a_x,a_y)$.

重力可以视为恒定加速度:

$$
\mathbf{a} = (0, -g)
$$

也可以加入阻力/阻尼(可选):

$$
\mathbf{v} \leftarrow \lambda \mathbf{v}, \quad \lambda \in (0,1)
$$

### 发射器 (Emitter)

发射器决定“新粒子从哪里来、初速度如何随机、初始寿命/大小/颜色如何设定”。例如：

- **喷泉**：从固定点向上方扇形发射，初速度带随机扰动
- **爆炸**：从一点向各个方向同时发射，初速度方向近似均匀随机
- **烟雾**：从固定区域缓慢上升，速度小、寿命长、透明度逐渐降低

你需要根据任务选择合适的参数化方式，并决定哪些参数作为命令行输入。

### StdDraw 包

[StdDraw 包](https://introcs.cs.princeton.edu/java/stdlib/StdDraw.java.html)封装了一些基本的画图方法。你可以用它绘制粒子（通常用小圆点/小圆表示）并形成动画。详细说明[参见文档](https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html)，你需要阅读使用该包进行动画绘制的部分。下面列出我们可能会用到的接口：

| 方法                                                 | 说明              |
| ---------------------------------------------------- | ----------------- |
| `StdDraw.setXscale(double minx, double maxx)`        | 设置画布 X 轴范围 |
| `StdDraw.setYscale(double miny, double maxy)`        | 设置画布 Y 轴范围 |
| `StdDraw.clear()`                                    | 清空画布          |
| `StdDraw.show()` 或 `StdDraw.show(int t)`            | 刷新显示/控制帧率 |
| `StdDraw.point(double x, double y)`                  | 画点              |
| `StdDraw.filledCircle(double x, double y, double r)` | 画实心圆          |
| `StdDraw.setPenColor(int r, int g, int b)`           | 设置画笔颜色      |

### Math 包

粒子系统需要随机数、角度与速度分解等计算。可以使用 [Java Math](https://docs.oracle.com/javase/7/docs/api/java/lang/Math.html) 包：

- 三角函数：`Math.sin`, `Math.cos`, `Math.toRadians`
- 随机函数：`Math.random`
- 幂与开方：`Math.pow`, `Math.sqrt`

------

## 实验内容

##### 第一部分：本部分作业需要手写代码完成

1. 设计并实现一个粒子类 `Particle`，代表一个粒子，需要至少具有以上粒子模型中的属性。

2. 设计并实现一个粒子系统类 `ParticleSystem`，使用户可以通过它绘制与控制粒子效果。

   最少应支持以下能力：

   - 发射粒子（一次发射多个或按时间持续发射）
   - 以固定时间步更新所有粒子状态（位置、速度、寿命等）
   - 将当前粒子绘制到画布上
   - 删除寿命结束的粒子，保证系统能长期运行

   提示：你需要自行决定 `ParticleSystem` 的数据成员与 API。可以用“内部类 Particle”，或用多个数组/ArrayList 保存粒子状态。

3. 实现并展示三种粒子效果之一（应可运行并可视化，保存截图或录屏）：

   - **喷泉 (Fountain)**：粒子从底部一点持续向上喷射，受重力下落，形成抛物线轨迹
   - **爆炸 (Explosion)**：粒子在某时刻从一点瞬间向四周爆开，逐渐消散
   - **烟雾 (Smoke)**：粒子从区域缓慢生成并上浮，速度较小，寿命较长，颜色/透明度可随时间变化

   示例喷泉效果：

   <img src="gif\fountain.gif" alt="gif/fountain.gif" style="zoom:50%;" />

4. 命令行参数控制。程序运行时从命令行读入参数，用于控制效果与规模。至少包含：

   - 模式：`fountain / explosion / smoke`
   - 粒子数量或发射速率（例如 `N` 或 `rate`）
   - 时间步长 `dt` 与/或运行时长 `T`

##### 第二部分：本部分可用 vibe coding 来实现

> **说明**：本部分作业请使用 AI 编程助手辅助完成。你的任务是设计合理的 Prompt（提示词），审查 AI 生成的代码逻辑，并将其整合到你之前的代码中。

1. 实现**第一部分T3**中的其他两类效果
2. 加入边界与反弹：当粒子碰到边界(如 $x<0$, $x>1$, $y<0$, $y>1$)时:
   - 反弹：对应速度分量取反
   - 加入能量损失：例如碰撞后速度乘以 $\lambda\in(0,1)$
3. 使用鼠标指针或其他任何方式控制粒子的发射点。
4. 在以上三类效果之外，自行设计一种新的效果并实现。