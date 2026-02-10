# 序列与迭代器

## 实验内容

1. 定义 SequenceItem 类, 包含一个字符串作为数据, 并提供以下方法

    |方法 |说明|
    |---|---|
    |getData()   |返回所包含的字符串|
    |setData()   |设置所包含的字符串|

2. 定义 Sequence 接口, 包括以下方法

    |方法 |说明|
    |---|---|
    |add(item)          |将 SequenceItem 类型的对象 item 加入序列|
    |get(i)             |将第 i 个SequenceItem 对象返回|
    |remove(item)       |删除 item 对象|
    |contains(item)     |返回是否包含 item|
    |size()             |返回序列长度|
    |isEmpty()          |返回序列是否为空|
    |iterator()         |返回一个迭代器对象, 用于顺序访问序列元素 (见 SeqIterator 接口描述)|
    |reverseIterator()  |返回一个迭代器对象, 用于倒序访问序列元素|
    |biIterator()       |返回一个迭代器对象, 可以双向访问序列元素 (见 SeqBiIterator 接口描述)|
    |toArray()          |返回序列的数组表示|
    |equals(seq)        |返回该序列是否与 seq 序列相同|
    |toString()         |转化为 String|

3. 定义 SeqIterator 接口, 包括以下方法

    |方法 |说明|
    |---|---|
    |hasNext()          |返回是否能取下一个 SequenceItem 对象|
    |next()             |取下一个 SequenceItem 对象|
    |remove()           |删除前一个被返回的 SequenceItem 对象|

4. 定义 SeqBiIterator 接口, 扩展 SeqIterator 接口, 包含以下方法

    |方法 |说明|
    |---|---|
    |hasPrevious()      |返回是否能取前一个 SequenceItem 对象|
    |previous()         |取前一个 SequenceItem 对象|


5. 编写类 ArraySequence 用可变长度数组实现 Sequence 接口, 使用内部类实现 iterator(), reverseIterator(), biIterator(). (提示: 使用数组存储 SequenceItem 对象, 当数组容量不够时, 申请一个两倍长度的数组. 当数组元素数量小于容量的1/4时, 缩减数组长度为1/2).

6. 编写类 IteratorTest, 包含静态方法 `display(Iterator i)` 顺序输出 Sequence 的内容.

7. (选做) 编写类 LinkedSequence 用[链表](https://en.wanweibaike.com/wiki-linked%20list)实现 Sequence 接口, 使用内部类实现 iterator(), reverseIterator(), biIterator().

8. (选做) 请比较 LinkedSequence 与 ArraySequence 在插入, 删除, 访问(例如, 顺序访问, 倒序访问, 随机访问) 等操作的性能. 



