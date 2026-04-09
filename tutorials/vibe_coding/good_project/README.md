> 以下非Markdown引用部分均为GPT5-mini生成，说明文档不必按照以下格式整理，但请保证描述清楚你完成的project

# 简易图书管理系统（Maven Java Project）

本项目实现了一个简易图书管理系统的核心业务逻辑，并按照 Maven Java 标准目录布局组织代码。

## 目录结构

> 这部分输出可以在命令行使用`tree`命令生成，具体使用方式请向Agent学习

```text
good_project
├── src
│   ├── main
│   │   ├── java/com/ecnu/library
│   │   │   ├── Book.java
│   │   │   ├── Library.java
│   │   │   └── Main.java
│   │   └── resources
│   └── test
│       └── java/com/ecnu/library
│           ├── BookTest.java
│           └── LibraryTest.java
├── docs
│   └── testing.md
├── imgs
├── pom.xml
└── README.md
```

## 功能说明

> 对主要代码(Class)中的主要属性(Property)和方法(Method)进行说明

1. Book 实体类

- 字段：id, title, author, isBorrowed
- 提供全参构造器、Getter/Setter、toString

2. Library 管理类

- 使用 HashMap<String, Book> 以 id 索引图书
- 支持 addBook, borrowBook, returnBook, listAvailableBooks
- 完整处理重复 id、图书不存在、状态不合法等异常

3. Main 演示类

- 演示正常添加、借阅、归还流程
- 演示常见边界异常并打印信息

## 运行与测试

> 此处提供一个主要的测试用例，让我们知道：
>
> 1. 代码是否可以正常运行？
> 2. 代码是否符合题目要求？

在当前目录执行：

```bash
mvn test
mvn -q exec:java -Dexec.mainClass="com.ecnu.library.Main"
```

如果本地未启用 exec 插件，也可使用：

```bash
mvn -q -DskipTests compile
java -cp target/classes com.ecnu.library.Main
```

## 补充文档

> 当前文档为项目的**主**说明文档，不一定需要在一个文档中描述所有内容。
> 实际开发中，可以根据你的理解按功能模块等要素划分为多个说明文档。

补充说明文档见 [docs/project.md](docs/project.md)。

> 测试文档同理。

测试说明文档见 [docs/testing.md](docs/testing.md)。

## Vibe-coding

1. [Main Chat](./docs/chat.json)：在这段对话中实现了一个简单的图书馆系统。
2. ...

> 对于实际项目，一般需要提供多段对话，即多个`.json`文件，请参考`1.`提供文件引用并简要描述对话内容
