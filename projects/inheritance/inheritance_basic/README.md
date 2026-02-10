# 继承与组合基础

## 实验内容

1. 定义 Name 类包含以下成员, 其中数据成员是私有的, 方法是公开的(一些方法的参数列表并不完整, 请补充完整).

    |数据成员   |说明|
    |---|---|
    |firstName  |名|
    |lastName   |姓|
 
    |方法 | 说明|
    |---|---|
    |Name()             |构造函数|
    |Name(f, l)         |构造函数, 其中f为名, l为姓|
    |getFirstName()     |返回名|
    |setFirstName(f)    |设置名|
    |getLastName()      |返回姓|
    |setLastName(f)     |设置姓|
    |toString()         |转化为String|

2. 定义 Person 类, 包含以下成员(所有方法都是公开的, 其中一些方法的参数列表并不完整, 请补充完整).

    |数据成员   |说明|
    |---|---|
    |name   |姓名( Name 对象, 公开的)|
    |age    |年龄(常量, 公开的)|
    |gender |性别(私有的)|
    
    |方法 | 说明|
    |---|---|
    |Person()           |构造函数|
    |Person(a, g, n)    |构造函数, 其中 a 为年龄, g 为性别, n 为姓名|
    |getGender()        |返回性别|
    |setGender()        |设置性别|
    |talk()             |输出"Hi, how is it going"|
    |talk(s)            |输出字符串对象s|
    |chatWith(p, s)     |p 为 Person 对象, s 为字符串对象. 输出"A to B: %s", 其中 A 是调用者的姓名, B 是 p 的姓名|

3. 请通过试验回答以下问题并说明原因
    * 在 Name 类的主函数中是否能访问 Name 对象的数据成员
    * 在 Person 类中(例如 chatWith 方法中)能否直接访问 name 对象的数据成员
    * 如果将 Name 的数据成员变为 package access, 上一个问题的答案会发生改变吗
    * 如果将 Person 类与 Name 类分别放入两个不同的包, 则以上问题的答案会发生改变吗

4. 定义 Student 类为 Person 类的子类. `talk()` 函数输出"Hi, how is your homework going?"
5. 定义 Teacher 类为 Person 类的子类. `talk()` 函数输出"Hi, how is your paper going?"
6. 请编写程序验证 Teacher, Student 类中talk()方法是动态绑定的. 
7. 定义 PersonFactory 类, 包含方法 `Person next()`, 随机生成一个 Teacher 或者 Student 对象
8. 利用 PersonFactory 类, 定义 Discussion 类, 其中包含若干 Teacher 对象和若干 Student 对象. 同时包含方法 broadcast(): 随机选择一个 Teacher 或者 Student 对象, 并对其余对象调用 chatWith() 方法.
9. 定义 ElderTeacher 类为 Teacher 类的子类, 要求 ElderTeacher 类最多只能有一个实例
10. 假设类 Sup 包含方法 f(), 返回值为类型A; 类 Sub 为 Sup 的子类, 包含方法 f(), 返回值为类型B. 通过程序试验回答以下问题. 
    * 若 A, B 类型相同, 运行程序会出现什么情况?
    * 若 A 为数组, B为 int, 会出现什么情况?
    * 若 B 是 A 的子类, 会出现什么情况?




