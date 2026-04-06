> 以下非Markdown引用部分均为GPT5-mini生成，说明文档不必按照以下格式整理，但请保证描述清楚你完成的project

# 简易图书管理系统（Maven Java Project）

本项目实现了一个简易图书管理系统的核心业务逻辑，并按照 Maven Java 标准目录布局组织代码。

## 目录结构

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

项目说明文档见 [docs/project.md](docs/project.md)。

测试说明文档见 [docs/testing.md](docs/testing.md)。

## Vibe-coding

1. [./docs/chat.json](Main Chat)：在这段对话中实现了一个简单的图书馆系统。

> ...(对于实际作业中的项目，可能需要提供多段对话，请参考1.简单描述对话内容)
