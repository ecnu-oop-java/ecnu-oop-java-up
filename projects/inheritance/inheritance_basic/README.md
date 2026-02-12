## 第一部分：继承与组合基础

**说明：** 本部分请手写代码完成。

1. 定义 Name 类包含以下成员, 其中数据成员是私有的, 方法是公开的。

    |数据成员   |类型   |说明|
    |---|---|---|
    |firstName  |String  |名|
    |lastName   |String   |姓|

    |方法 | 说明|
    |---|---|
    |Name()             |无参构造函数，默认设为 "Unknown"|
    |Name(String f, String l)         |构造函数，初始化名和姓|
    |getFirstName()     |返回名|
    |setFirstName(String f)    |设置名|
    |getLastName()      |返回姓|
    |setLastName(String l)     |设置姓|
    |toString()         |转化为String，返回 "First Last" 格式字符串|
    |equals(Object obj) |比较两个 Name 对象内容是否一致（姓和名都相同即相同）|

2. 定义 Person 类, 包含以下成员。请注意封装性(数据成员私有，通过方法访问).

    |数据成员   |类型   |说明|
    |---|---|---|
    |name   |Name   |姓名( **组合关系**，Person 拥有 Name)|
    |age    |int    |年龄|
    |gender |Gender |性别，使用枚举类型；MALE, FEMALE|
    
    |方法 | 说明|
    |---|---|
    |Person()           |无参构造函数|
    |Person(int a, Gender g, Name n)    |构造函数，初始化年龄、性别、姓名|
    |getName() / setName(Name n)        |姓名访问器|
    |talk()             |输出 "Hi, how is it going?"|
    |talk(String topic)            |输出 "Let's talk about [topic]".|
    |chatWith(Person p, String topic)     |输出 "A to B: Let's talk about [topic]"，其中 A 是调用者的全名，B 是参数 p 的全名（复用 toString 和 talk）|
    
3. 请通过代码试验回答以下问题：
    - 在 Name 类的主函数中是否能访问 Name 对象的数据成员
    - 在 Person 类中(例如 chatWith 方法中)能否直接访问 name 对象的数据成员
    - 如果将 Name 的数据成员变为 package access，且 Person 和 Name 在同一个包中，答案会改变吗？
    - 如果将 Person 类与 Name 类分别放入两个不同的包，答案会改变吗？

4. 定义 Student 类为 Person 类的子类，并实现以下内容：

    - 添加成员变量 major (专业，String 类型)。
    - 编写构造函数：Student(int age, Gender gender, Name name, String major)，要求在子类构造函数中使用 super(...) 关键字显式调用父类 Person 的有参构造函数来初始化继承来的字段。
    - 重写 talk() 函数，输出 "Hi, how is your homework going?"
    - 重写 toString() 函数，在父类信息的基础上增加专业信息，格式如："Name, Age, Gender, Major: [major]"。

5. 定义 Teacher 类为 Person 类的子类，并实现以下内容：

    - 添加成员变量 subject (教学科目)。
    - 编写对应的构造函数（同样要求使用 super）。
    - 重写talk() 函数，输出"Hi, how is your paper going?"
    - 重写 toString() 函数，在父类信息的基础上增加教学科目信息。

6. 请编写程序验证 Teacher, Student 类中 talk() 方法是动态绑定的：

    - 创建一个 Person[] 数组（或 List<Person>）。
    - 向其中添加一个 Student 对象、一个 Teacher 对象和一个普通的 Person 对象。
    - 使用 for 循环遍历数组，对每个元素调用 talk() 方法。
    - **观察：** 尽管变量类型都是 Person，但输出结果是否不同？

7. 测试以下代码：

    ```java
    Person p = new Student(...); 
    p.talk(); 
    p.talk("Math"); 
    ```

    观察输出差异，并解释为什么 p.talk("Math")没有输出 Student 特有的内容（如果没有重写带参数版本的话）。

8. 定义 PersonFactory 类, 实现以下内容：

    - 包含静态方法 `Person createRandomPerson()`。
    - 利用随机数生成器，随机返回一个 Teacher 或 Student对象。
    - 提示：可以使用数组预存一些 First Name 和 Last Name 方便随机组合生成 Name对象。

9. 利用 PersonFactory 类, 定义 Discussion 类（讨论组），实现以下内容：

    - 内部维护一个 List<Person>。
    - 方法 addPerson(Person p)：加入一个人。
    - 方法 broadcast()：模拟群聊。逻辑如下：
      - 随机选择列表中的一个人作为“发言者”。
      - 让这位发言者对列表中的其他人逐一调用 `chatWith()`方法。

10. 定义 ElderTeacher 类为 Teacher 类的子类，实现以下内容：

    - 要求 ElderTeacher 全局只能有一个实例。
    - 构造函数私有化。
    - 提供 `public static ElderTeacher getInstance()` 方法。
    - 多次调用 getInstance()，验证检查返回对象的内存地址是否相同。

11. 假设我们不再希望程序中出现普通的 "Person" 对象（人必须有具体的身份），编写程序实现以下内容：

     - 修改 Person 类为 **抽象类 (abstract class)**。
     - 在 Person 中定义抽象方法 `public abstract void work();`。
     - 修改 Student 类，实现 work()，输出 "I am studying [major]."
     - 修改 Teacher 类，实现 work()，输出 "I am teaching [subject]."
     - 尝试：new Person()，观察编译器报错信息。

12. 在 Person 类中定义一个方法 `public final void breathe()`，输出 "Breathing..."。然后尝试在 Student 类中重写 breathe() 方法，观察编译器报错信息，并解释原因。

13. 假设在我们的系统中，每个人都可以有一个“同伴”(Partner)。先修改以下内容：

     - 在 Person 类中添加一个方法 `public Person getPartner()`，默认返回 null（或者返回一个新的 Person 对象，具体实现不重要，重点是方法签名）。
     - 在 Student 类中重写 getPartner() 方法。

     然后请尝试以下几种重写方式，观察编译器（IDE）的反应，并回答问题：

     - 在 Student 类中，将方法定义为 `public Person getPartner() { ... }`（返回值类型与父类完全一致），请问编译能通过吗？
     - 在 Student 类中，将方法定义为 `public Student getPartner() { ... }`（返回值类型变成了 Student，它是 Person 的子类），请问编译能通过吗？如果能，这说明了 Java 允许子类重写方法时返回什么类型的引用？
     - 在 Student 类中，将方法定义为 `public Object getPartner() { ... }`（返回值类型变成了 Object，它是 Person 的父类），请问编译能通过吗？为什么？
     - 在 Student 类中，将方法定义为 `public int getPartner() { ... }`（返回值类型变成了基本数据类型），请问编译能通过吗？

14. 请定义 Role 类，包含以下成员：

    | 数据成员 | 类型   | 说明     |
    | -------- | ------ | -------- |
    | roleName | String | 角色名称 |

    | 方法                  | 说明                     |
    | --------------------- | ------------------------ |
    | Role()                | 无参构造函数             |
    | Role(String r)        | 构造函数，r 为角色名     |
    | getRoleName()         | 返回角色名称             |
    | setRoleName(String r) | 设置角色名称             |
    | roleTalk()            | 根据角色输出不同说话内容 |
    
    请修改 Person 类，添加成员变量：
    
    ```java
    private Role role;
    ```
    ----
    
    同时修改 talk()方法，使其调用 role.roleTalk()
    
    请通过试验回答以下问题并说明原因：
    
    - 此时 Person 与 Role 之间属于继承关系还是组合关系
    
    - 使用组合相比继承有什么优点
    - 如果以后增加新的角色类型，哪种方式更容易扩展



15. 请定义 Address类，包含以下成员：

    | 数据成员 | 类型   | 说明 |
    | -------- | ------ | ---- |
    | city     | String | 城市 |
    | street   | String | 街道 |
	----

    请在 Person类中新增：
    
    ```java
    private Address address;
    ```
    
    并要求：
    
    - Address 对象必须在 Person 构造函数中创建
    - 不允许通过 setter 直接整体替换 Address 对象
    
    请通过试验回答以下问题并说明原因：
    
    - Address 是否可以脱离 Person 单独存在
    - 如果 Person 对象被销毁，Address 对象是否应该继续存在
    - 此设计更接近聚合关系还是组合关系



## 第二部分：Vibe Coding 进阶挑战

**说明**：本部分作业请使用 AI 编程助手（如 Cursor, GitHub Copilot, ChatGPT 等）辅助完成。你的任务是设计合理的 Prompt（提示词），审查 AI 生成的代码逻辑，并将其整合到你之前的代码中。

16. 选课关系建模

    在真实学校系统中，学生可以选择多门课程，而一门课程也会被多个学生选择。系统需要能够正确记录这种关系，并保证数据不会出现不一致情况。

    请设计一个能够支持选课关系的数据模型，并利用 AI 辅助完成代码实现。系统至少应能够支持学生选课、课程查看已选学生，以及基本的选课人数限制功能。

    **在设计 Prompt 时，你需要特别思考**：当学生选择课程时，系统应如何保证课程对象与学生对象中的数据保持一致？如果只修改其中一方的数据，可能会产生什么问题？你应尝试让 AI 帮助你实现一个尽量不容易出错的数据维护方案。

    请提交你编写的 Prompt、AI 生成的初始代码、你发现的问题，以及最终修改后的代码实现。



17. 状态变化与行为驱动的系统模拟

    在真实系统中，对象不仅存储数据，还会随着时间变化产生状态变化。例如，一个人在长时间工作后可能会感到疲惫，在休息后恢复精力。不同类型的人在一天中的行为模式也可能不同。

    请基于现有 Person 体系，设计一个能够模拟“状态变化”和“行为执行”的简单系统，并使用 AI 辅助完成代码实现。

    系统应能够体现以下特征：

    - 对象具有可变化的状态属性
    - 对象可以执行不同类型的行为
    - 行为会对对象状态产生影响
    - 系统能够在时间推进过程中持续更新对象状态

    **在设计 Prompt 时，你需要自行决定：** 如何表示行为类型；如何控制行为发生的时机；如何避免对象进入不合理状态，例如当多个行为同时影响同一个状态属性时，应如何处理优先级问题。

    提交内容和上一题一致，同时你需要描述如何逐步完善需求描述，使 AI 能够正确实现系统行为逻辑的；以及 AI 在理解状态变化逻辑时最容易出错的地方。
