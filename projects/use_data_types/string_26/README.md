# 使用String

在这个Project中, 你将熟悉 Java String 类的使用. 
几乎每一个 Java 程序都会使用到 String 对象.
回忆一下, 在 C 语言中, 字符串的处理需要调用 `string.h` 中的字符串函数.
例如 `strcmp, strlen` 等. 而从面向对象编程的视角来看, 
它们可以看成每一个字符串提供给外界的访问接口. 
外部程序通过调用这些接口可以获得字符串的信息.
而相比起 C 语言中仅将有限的字符串操作作为标准库函数, 
String 类作为 Java 语言的一个部分(你不用 import 任何包就能使用 String),
提供了更丰富的接口. 
希望通过 String 你可以熟悉 Java 中类和对象的基本使用方法.

## String 简介

关于 String 类的详细信息, 
可以参考 [Java 文档](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html).
也可以阅读Thinking in Java 中的 String 一章. 下面列出一些 String 类的主要方法:

| 方法                               | 说明                                             |
| ---------------------------------- | ------------------------------------------------ |
| String(char []s)                   | 构造函数, 从字符串数组构造 String                |
| String(String s)                   | 构造函数, 用String s 构造                        |
| int length()                       | 返回字符串长度                                   |
| char charAt(int i)                 | 返回位置 i 处的字符                              |
| String substring(int s, int e)     | 返回从位置 s 到位置 e 的子串                     |
| String substring(int s)            | 返回从位置 s 开始的子串                          |
| String toUpperCase()               | 返回一个全大写的字符串                           |
| String toLowerCase()               | 返回一个全小写的字符串                           |
| boolean startsWith(String s)       | 是否以字符串 s 开头                              |
| boolean endsWith(String s)         | 是否以字符串 s 结尾                              |
| int indexOf(String s)              | 返回首次出现字符串 s 的位置                      |
| int indexOf(String s, int i)       | 返回位置 i 之后首次出现字符串 s 的位置           |
| int lastIndexOf(String s)          | 返回最后一次出现字符串 s 的位置                  |
| String trim()                      | 返回一个新的字符串, 去除了原字符串前后的空白字符 |
| String replace(String a, String b) | 返回一个新的字符串, 将原字符串中 a 替换为 b      |
| int compareTo(String a)            | 与字符串 a 通过词典序比较大小                    |

注意, Java 中 String 对象是**不可变的 (Immutable)**. 直观的说,
一旦创建了一个 String 对象, 就不能修改它. 
比如 `s.toUpperCase()` 并不是将 s 中的每个字符修改为对应的大写字符,
而是创建一个新的 String 对象, 这个对象中每个字符字符为原来字符的大写. 

## 实验内容

##### 第一部分：本部分作业需要手写代码完成

1. 给定一个字符串 （通过命令行参数形式，以下各题相同），判断其中是否含有"@"符号，输出"Yes"或"No"。

2. 给定一个邮箱字符串, 根据"@"将它分解成字串. 例如 example@163.com 分解成为 example, 163.com。(提示: 使用 split() 方法)

3. 给定一个代表文件路径的字符串, 输出其指向文件的扩展名。例如: /home/tom/documents/a.jpg 输出 jpg。

4. 从给定文件中读入若干行字符串，先忽略其大小写，然后判断是否是回文串（指字符串的任意等长前缀和倒序后缀相同，如aabaa，abccba为回文串，而abca，abcab等不是），输出所有回文串到一个新的文件。

5. 从命令行中读入两个二进制字符串，计算他们的和并用二进制字符串形式输出。

6. 编写程序 Cat.java, 它可以有任意多的命令行参数, 每个参数为一个文件名. Cat.java 将文件按照参数的顺序合并成一个文件, 并将合并后的文件内容输出到标准输出。

7. 给定一个字符串，代表一个10进制数。将其转换成10进制整数和2进制数，并依次输出到标准输出。

8. 给定一个文件，从中读入任意多行字符串，输出这些字符串的最大长度和最小长度到标准输出。

9. 给定一个文件，从中读入任意多行字符串，分别输出字典序最大和最小的字符串到一个新的文件。字典序是一种字符串排序规则，其是一种多关键字排序，以字符串的第 i 个字符作为第 i 关键字进行编码值大小比较，空字符小于字符集内任何字符（例：a<a**a**，abc**c**<abc**d**，waltw**a**z < waltw**e**y )。

10. 给定一个文件，统计其中26个英文小写字母出现的频率。

11. 给定一个字符串，判断它是否是一个合法的简单邮箱地址（要求如下）

    a. 整个字符串由大小写字母，数字以及"@"和"."字符组成

    b. 恰好存在一个"@"且不在字符串的开头或结尾

    c. "@"之前不存在"."，且其之后存在至少一个"."

    d. 每一个"."前后至少包含一个非特殊字符（字母或数字）

12. 实现一个Clean.java类，实现对文件的批处理功能，输入文件格式如下：

    - 每行包含 3 个字段：`name email city`
    - 字段之间分隔符可能是 **逗号`,` 或分号`;` 或竖线`|`**（混用也可能）。
    - 字段内可能有多余空格、大小写混乱、偶尔缺字段。

    Clean.java需要包含以下命令行参数以便控制其行为：

    | 选项       | 用法                    | 说明                                                         |
    | ---------- | ----------------------- | ------------------------------------------------------------ |
    | `-i`       | `-i in.txt`             | 输入文件（必选）                                             |
    | `-o`       | `-o out.txt`            | 输出文件（可选，默认标准输出）                               |
    | `--bad`    | `--bad bad.txt`         | 把不合格行输出到 bad.txt（可选；不指定则丢弃坏行）           |
    | `--mode`   | `--mode clean|emails`   | 运行模式：`clean` 生成清洗后的三列数据；`emails` 只输出邮箱名单 |
    | `--format` | `--format lower|formal` | 清洗强度：`lower`=全行字母转小写；`formal`=每个字段 trim，name/city 首字母大写，email 小写 |
    | `--dedup`  | `--dedup`               | 仅在 `emails` 模式下生效：邮箱去重（保持首次出现顺序）       |

    坏行定义：（1）分割后字段数不是 3（2）email 不合法（满足任意条件）

    完成Clean.java类之后，你需要实现如下功能：

    1. 生成可导入的规范化通讯录（并分离坏数据）

       ```bash
       java Clean -i raw.txt -o clean.txt --bad bad.txt --mode clean --format formal
       ```

       结果：

       a. `clean.txt`：规范化后的 `Name,email,City`（可以规定输出统一用逗号）

       b. `bad.txt`：原样输出不合格行（便于人工修改）

    2. 从原始数据导出群发邮件名单

       ```bash
       java Clean -i raw.txt -o emails.txt --mode emails --format lower --dedup
       ```

       结果：`emails.txt`：每行一个邮箱，小写、去重，能直接用于群发/导入邮箱客户端

    3. 快速统一小写

       ```bash
       java Clean -i raw.txt --mode clean --format lower
       ```

    ​		结果：输出到标准输出

    4. 加入几个新的命令行参数，使得使用功能1时可以额外输出一份日志，记录该程序运行时有用的数据和状态（例如坏行的数量）。你需要自己定义这些命令行参数，用于控制日志的输出和输出日志的行为/数据等，设计好后使用AI辅助完成该功能，检查是否每个新定义的命令行参数都是有意义的。



##### 第二部分：本部分可用 vibe coding 来实现

> **说明**：本部分作业请使用 AI 编程助手辅助完成。你的任务是设计合理的 Prompt（提示词），审查 AI 生成的代码逻辑，并将其整合到你之前的代码中。

**邮件群发工具**：在社团或班级里，经常会从不同来源收集通讯录（Excel 导出、表单、复制粘贴、群里手敲），格式混乱、大小写不统一、分隔符不一致、还夹杂坏数据。你需要做一个命令行小工具，先把通讯录清洗成可导入的规范格式，再基于清洗出的邮箱名单构建一个安全的群发邮件助手，用于发送通知/活动报名/作业提醒等。

你的程序至少要包含以下功能：

1. **通讯录清洗（Clean）**

- 具有**第一部分T12** Clean.java 中的全部功能。
- 可以导出**仅包含邮箱**的名单，供下一阶段使用，并支持去重。

2. **安全群发邮件助手（Mailer）**

- 从 `Clean` 导出的邮箱名单读取收件人列表。
- 支持给定邮件模板（主题 + 正文），并做简单的个性化（比如替换 `{name}`、`{city}` 这类占位符）。
- 支持**一键发送**：将所有处理好的邮件群发至所有收件人。
- 支持**预览模式**：不真的发送，而是把即将发送的每封邮件生成到本地 `outbox/`，便于人工确认。
- 支持**发送记录**：能生成一份sent log，至少包含时间、收件人、主题、结果（成功/失败原因）。
- 支持**安全策略**：例如限速/分批、重复发送保护、可跳过黑名单文件等。



**测试说明与样例**

样例分为两部分，公开样例和测试样例。公开样例如下所示，用于帮助实现完整的程序和初步检查程序中的问题，测试样例（未发布）用于检查最终程序的完善程度与可用性。

对于每一个样例，你都需要编写一个命令行程序来调用你的 Java 程序，并生成按要求命名的输出文件，通过样例的要求是所有的输出文件与正确的输出文件**按字符对比**完全一致。

**样例 1**

```txt
 alice , Alice@Example.COM , shanghai 
Bob;bob@example.com;Beijing
charlie| charlie@example.com |   New   York
Daisy, daisyexample.com, Paris
Eve, eve@evil., LA
Frank|frank@foo.com
,,,
  Grace  ; GRACE@EXAMPLE.COM ; shen zhen  
```

要求：clean 模式，formal 输出

`output.txt`

```txt
Alice,alice@example.com,Shanghai
Bob,bob@example.com,Beijing
Charlie,charlie@example.com,New York
Grace,grace@example.com,Shen Zhen
```

`bad.txt`

```txt
Daisy, daisyexample.com, Paris
Eve, eve@evil., LA
Frank|frank@foo.com
,,,
```



**样例 2**

```txt
Tom|TOM@EXAMPLE.COM|Hangzhou
tom,tom@example.com,hangzhou
Jerry; jerry@Example.Com ; Shanghai
BadGuy|badguy.example.com|Nowhere
ALICE, Alice@Example.COM, SH
```

要求：emails 模式，lower 输出，去重

`emails.txt`

```txt
tom@example.com
jerry@example.com
alice@example.com
```



**样例 3**

```txt
Alice,alice@example.com,Shanghai
Bob,bob@example.com,Beijing
Charlie,charlie@example.com,New York
Grace,grace@example.com,Shen Zhen
```

要求：生成 emails.txt，对于每一个收件人，生成对应邮件内容

`emails.txt`：

```txt
alice@example.com
bob@example.com
charlie@example.com
grace@example.com
```

邮件模板：

```txt
To: {email}
Subject: Club Notice: Welcome {name}

Hi {name},
Your city is {city}.
See you at the club!
```

