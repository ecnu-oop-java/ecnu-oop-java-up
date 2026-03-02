# 序列与迭代器

## 第一部分（手写代码完成）

### 基础接口与类定义

1. 定义 `SequenceItem` 类, 包含一个字符串作为数据, 并提供以下方法

   | 方法        | 说明               |
   | ----------- | ------------------ |
   | `getData()` | 返回所包含的字符串 |
   | `setData()` | 设置所包含的字符串 |

2. 定义 `Sequence` 接口, 包括以下方法

   | 方法                | 说明                                                         |
   | ------------------- | ------------------------------------------------------------ |
   | `add(item)`         | 将 `SequenceItem` 类型的对象 item 加入序列                   |
   | `get(i)`            | 将第 i 个 `SequenceItem` 对象返回                            |
   | `remove(item)`      | 删除 item 对象                                               |
   | `contains(item)`    | 返回是否包含 item                                            |
   | `size()`            | 返回序列长度                                                 |
   | `isEmpty()`         | 返回序列是否为空                                             |
   | `iterator()`        | 返回一个迭代器对象, 用于顺序访问序列元素 (见  `SeqIterator` 接口描述) |
   | `reverseIterator()` | 返回一个迭代器对象, 用于倒序访问序列元素                     |
   | `biIterator()`      | 返回一个迭代器对象, 可以双向访问序列元素 (见 `SeqBiIterator` 接口描述) |
   | `toArray()`         | 返回序列的数组表示                                           |
   | `equals(seq)`       | 返回该序列是否与 seq 序列相同                                |
   | `toString()`        | 转化为 String                                                |

3. 定义 `SeqIterator` 接口, 包括以下方法

   | 方法        | 说明                                   |
   | ----------- | -------------------------------------- |
   | `hasNext()` | 返回是否能取下一个 `SequenceItem` 对象 |
   | `next()`    | 取下一个 `SequenceItem` 对象           |
   | `remove()`  | 删除前一个被返回的 `SequenceItem` 对象 |

4. 定义 `SeqBiIterator` 接口, 扩展 `SeqIterator` 接口, 包含以下方法

   | 方法            | 说明                                   |
   | --------------- | -------------------------------------- |
   | `hasPrevious()` | 返回是否能取前一个 `SequenceItem` 对象 |
   | `previous()`    | 取前一个 `SequenceItem` 对象           |



### 构建容器

5. 实现类 `ArraySequence`：用可变长度数组实现 `Sequence` 接口。使用内部类实现 `iterator()`, `reverseIterator()`, `biIterator()`。
   - 提示：数组容量不足时申请 2 倍长度；元素量小于容量 1/4 时，缩减至 1/2。
6. 实现类 `LinkedSequence` 用双向链表实现 Sequence 接口, 使用内部类实现 `iterator()`, `reverseIterator()`, `biIterator()`.



### 多遍历策略

7. 在传统的编程思维中，遍历数组用 `for(int i...)`，遍历链表需要操作指针。如果我们要写一个通用的统计算法，必须为每种结构各写一遍。迭代器提供了一层“协议”，让算法不再关心底层实现。

   请编写算法工具类 `SequenceUtils`，实现以下**静态方法**。要求方法内部禁止使用 `get(i)`，必须且只能通过迭代器访问元素。

   | 方法                                           | 说明                                                         |
   | ---------------------------------------------- | ------------------------------------------------------------ |
   | `countContains(SeqIterator it, String target)` | 接收任意迭代器，统计并返回其中包含字符串 `target` 的元素个数。 |
   | `findLast(SeqBiIterator it, String target)`    | 接收双向迭代器，利用其逆序遍历能力，从后往前查找第一个匹配 `target` 的元素。 |
   | `compare(SeqIterator it1, SeqIterator it2)`    | 比较两个迭代器提供的数据流是否完全一致（无论它们来自数组还是链表）。 |

   

8. 编写测试类 `IteratorTest`，在 `main` 方法中完成以下逻辑：

   - 创建一个 `ArraySequence` 和一个 `LinkedSequence`，存入相同的数据。
   - 调用 `SequenceUtils.countContains`，将两个容器的 `iterator()` 分别传入。



### 实验思考

9. 在完成以上实验后，请回答以下问题：
   - 对于 `LinkedSequence`，使用 `for(int i=0; i<s.size(); i++) { s.get(i); }` 遍历和使用 `Iterator` 遍历，哪种效率更高？为什么？
   - 为什么不直接在 `Sequence` 接口里定义 `next()` 方法，而是要专门返回一个 `Iterator` 对象？（提示：如果两个线程想同时以不同进度遍历同一个序列，该怎么办？）
   - 如果未来我们需要增加一个“只访问序列中偶数下标元素”的功能，是应该修改 `Sequence` 类，还是新增一种 `Iterator` 的实现类？

### 实验思考

9. 在完成以上实验后，请回答以下问题：

   - 对于 `LinkedSequence`，使用 `for(int i=0; i<s.size(); i++) { s.get(i); }` 遍历和使用 `Iterator` 遍历，哪种效率更高？为什么？

   - 为什么不直接在 `Sequence` 接口里定义 `next()` 方法，而是要专门返回一个 `Iterator` 对象？（选做）
   
     > **【背景知识：多线程魔法与“共享危机”】**
     > 在平时的编程中，我们的程序就像是一个“单人玩家”，代码总是从 `main` 方法的第一行严格按顺序执行到最后一行。但在现实中，计算机通常会同时做很多事情。在 Java 中，我们可以让程序变成“多人游戏”，这就需要用到**线程（Thread）**。你可以把“线程”想象成是你雇佣的“小工人”。
     > 
     > 
     > 
     > **体验一下召唤小工人：**
     > 运行以下代码，观察控制台输出，你会发现工人 A 和工人 B 的输出是交替、混合在一起的。这就是多线程“并发”干活的直观表现。
     > ```java
     > public class ThreadDemo {
     >     public static void main(String[] args) {
     >         Thread workerA = new Thread(() -> {
     >             for (int i = 1; i <= 5; i++) {
     >                 System.out.println("工人A 正在处理第 " + i + " 个数据");
     >                 try { Thread.sleep(100); } catch (Exception e) {}
     >             }
     >         });
     >         Thread workerB = new Thread(() -> {
     >             for (int i = 1; i <= 5; i++) {
     >                 System.out.println("工人B 正在处理第 " + i + " 个数据");
     >                 try { Thread.sleep(100); } catch (Exception e) {}
     >             }
     >         });
     >         workerA.start();
     >         workerB.start();
     >     }
     > }
     > ```
     > **两人同看一本书的挑战：**
     > 假设 `Sequence` 是一本放在公共桌子上的书。如果把 `next()` 方法直接写在 `Sequence` 内部，就意味着“当前读到了第几页”这个进度记录，是直接保存在这本书（容器本身）里的。
     > 这时，工人A（线程A）和工人B（线程B）都想各自从头到尾读完这本书，于是他们在同一个 `Sequence` 对象上，交替着调用 `next()` 方法往前读。
     > 
     > *结合上面的代码想象一下，工人A读了一会儿去休息了，期间工人B接着调用 `next()` 往下读。等工人A回来继续调用 `next()` 时，会发生什么灾难？现在的 `Iterator` 设计模式（每次调用都返回一个全新的迭代器对象）是如何巧妙解决这个问题的？*

   - 如果未来我们需要增加一个“只访问序列中偶数下标元素”的功能，是应该修改 `Sequence` 类，还是新增一种 `Iterator` 的实现类？


## 第二部分（vibe coding 实现）

本部分作业请使用 AI 编程助手辅助完成。

10. 某系统记录了大量日志信息，每条日志用一个 `SequenceItem` 表示。日志内容可能包含运行状态、错误信息、用户操作等信息。现在请基于你已经实现的 `Sequence` 与迭代器体系，设计一个简单的日志分析模块。

    为保证输入格式统一，本实验规定每条日志文本采用如下格式（字段之间用竖线分隔）：

    ```
    LEVEL|timestamp|message
    ```

    其中 `LEVEL` 只能取 `INFO`、`WARN`、`ERROR` 三种之一；`timestamp` 使用整数（例如秒级或毫秒级都可以，只要统一）；`message` 为一段不含竖线的文本。例如：

    ```
    ERROR|1700000123|Null pointer in ModuleA
    WARN|1700000200|Slow response
    INFO|1700000300|User login
    ```

    你需要实现若干典型的日志分析操作，完成以下功能：

    - 统计某类日志出现的次数。若日志格式不合法，该条日志应被忽略并计入“非法日志计数”
    - 根据关键字或者日志类型查找最近一次出现的某个日志
    - 比较两个日志序列是否完全一致
    - 进行日志筛选，即保留包含特定信息的日志

    在实现以上功能时，所有分析过程只能通过迭代器访问数据，不能使用 `get(i)` 或依赖底层结构，同一套分析代码应能同时处理 `ArraySequence` 与 `LinkedSequence`。
