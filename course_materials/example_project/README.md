# 前置知识

**Lab1-说明文档**是一个示例，用于帮助同学们在完成课程Projects时**管理项目目录结构**、**编写说明文档**等。

## Markdown

在阅读文档之前，清注意以下几点：

1. Markdown语法可以参考[Markdown教程](https://markdown.com.cn/basic-syntax/blockquotes.html#google_vignette)或者[Markdown Guide](https://www.markdownguide.org/basic-syntax/)进行学习；
2. 文档中所有[Markdown引用](https://markdown.com.cn/basic-syntax/blockquotes.html)都是对内容的解释，不需要添加到你的文档中；

## 项目目录组织

> 合理的、规范的项目目录结构可以提高代码可读性、降低项目管理难度等

不同编程语言有不同的目录结构规范，本课程参考[Standard Directory Layout for Maven Java](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html)提供示例结构如下：

```shell
├──project01
│   ├───src
│   │  └──main
│   │    ├── java                # 项目源代码目录
│   │    │   └── Example.java
│   │    └── resources           # 项目资源目录
│   │        └── exmaple.txt
│   ├─imgs                       # README.md的嵌入图片
│   ├─docs                       # 补充说明目录
│   └──README.md                 # 说明文档
└───project02
    ├───sub-project021
    │  ├───...
    │  ├───...
    │  └───README.md
    └───sub-project022
        ├───...
        ├───...
        └───README.md
```

**请所有同学参考以上目录结构整理自己的project**，以下是对目录结构的简单解释：

1. `/src/main/java`：项目代码目录，存放project涉及的java源代码；
2. `/src/main/resources`：项目资源目录，存放project设计的非代码文件，例如需要读写的`.txt`和`.jpg`文件等；
3. `/imgs`：存放项目说明文档`README.md`的嵌入图片；
4. `/docs`：补充说明目录，存放用于说明复杂项目的markdown文档；

---

# Lab1-说明文档

> 使用**一级标题**`项目名称`作为说明文档的标题。

## Question1

> 使用**二级标题**`QuestionX`作为`实验内容`中每个问题的标题。
> 请严格按照问题顺序对说明进行排序。

### Question11

![](imgs/logo.png)

> 对于需要提供**图片**的问题，可以使用[Markdown图片语法](https://markdown.com.cn/basic-syntax/images.html)在文档中嵌入你的图片。
> 请注意，为了保证所插入图片的正常显示，请参考本文档在同级目录下创建`img`目录存放你的图片，并使用**相对路径**插入图片。

### Question12

> 如果一个问题包含多个子问题，如果有必要，**可以**使用**三级标题**`QuestionXX`进行说明。

## Question2

> 对于需要提供**代码**的问题，使用[Markdown链接语法](https://markdown.com.cn/basic-syntax/links.html)添加解决该问题源代码的链接并按要求、适当进行文字说明，例如：

这是本题的源代码：[代码](src/main/java/Example.java)

> 对于代码复杂、需要额外解释的题目，可以使用[Markdown代码语法](https://markdown.com.cn/basic-syntax/code.html)在说明文档中内嵌你的代码，例如：

```java
public static void main (String args[]) {
    System.out.println("This is an example java code.");
}
```

说明：`main`方法会在控制台输出"This is an example java code."。

## QuestionN

## 补充说明

> 如果在完成`实验内容`外还有其他需要说明的内容，使用**二级标题**`补充说明`作为标题。

...

> 为了控制`/README.md`的内容长度，对于复杂的项目可以在项目`/docs`下提供更详细的说明文档，例如后续需要完成的vibe coding projects。
> 如果提供了额外的说明文档，请使用[Markdown链接语法](https://markdown.com.cn/basic-syntax/links.html)在本节`补充说明`中提供对应说明文档的链接（补充文档控制在3个以内）。例如：

本节说明在[example.md](docs/example.md).
