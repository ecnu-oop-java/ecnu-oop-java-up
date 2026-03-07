> 以下是一个示例，用于规范同学们在Projects提供的说明文档。
> 在阅读文档之前，清注意以下几点：
>
> 1. Markdown语法可以参考[Markdown教程](https://markdown.com.cn/basic-syntax/blockquotes.html#google_vignette)或者[Markdown Guide](https://www.markdownguide.org/basic-syntax/)进行学习；
> 2. 文档中所有[Markdown引用](https://markdown.com.cn/basic-syntax/blockquotes.html)都是对内容的解释，不需要添加到你的文档中；

# 说明文档

> 使用**一级标题**`项目名称`作为说明文档的标题。
> 一个project可能有多个sub projects。针对每个project都需要在对应目录下提供说明文档，例如：
>
> ```shell
>  ├──project01
>  │   └──README.md   # project01的说明文档
>  └───project02
>     ├───sub-project021
>     │  └───README.md # project021的说明文档
>     └───sub-project022
>        └───README.md # project0的说明文档
> ```
>
> 同学们需要根据自己需求，对完成的实验做适当的解释说明。

## Question1

> 使用**二级标题**`QuestionX`作为`实验内容`中每个问题的标题。
> 请严格按照问题顺序对说明进行排序。

### Question11

![](img/logo.png)

> 对于需要提供**图片**的问题，可以使用[Markdown图片语法](https://markdown.com.cn/basic-syntax/images.html)在文档中嵌入你的图片。
> 请注意，为了保证所插入图片的正常显示，请参考本文档在同级目录下创建`img`目录存放你的图片，并使用**相对路径**插入图片。

### Question12

> 如果一个问题包含多个子问题，如果有必要，**可以**使用**三级标题**`QuestionXX`进行说明。

## Question2

```Java
// example codes for Java
public class HelloWorld {
    public static void main (String args[]) {
        System.out.println("Hello World!");
    }
}
```

> 对于需要提供**代码**的问题，可以使用[Markdown代码语法](https://markdown.com.cn/basic-syntax/code.html)在文档中嵌入你的代码。

## QuestionN

## 补充说明

> 如果在完成`实验内容`外还有其他需要说明的内容，使用**二级标题**`补充说明`作为标题。
