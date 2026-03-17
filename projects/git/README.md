# 使用版本控制系统 Git

## 概述

Git 是一种常用的分布式版本控制系统，可以帮助开发者管理项目代码的历史版本，记录每一次修改的内容，并在出现问题时回退到之前的版本。相比于直接复制多个“最终版”，“最终版2”，“最终版真的最终版”等文件夹的方式，Git 能以更加规范和高效的方式管理代码演化过程（或其他任何需要进行版本控制的项目文件夹）。

在实际的软件开发中，代码通常需要不断迭代：一方面要持续增加新功能、修复旧问题，另一方面还可能需要多人同时协作完成同一个项目。Git 提供了暂存、提交、分支、合并等机制，使开发者能够更清晰地组织修改过程，也使团队协作更加方便和安全。GitHub 则是在 Git 基础上的代码托管平台，支持远程仓库管理、代码共享、协作开发以及 Pull Request 等流程。

本实验的目的是让你熟悉日常开发中最常见的 Git 使用方法，并初步认识基于 GitHub 的协作开发流程。

## 安装和配置 Git

#### 在windows上安装

官方版本可以在 Git 官方网站下载。 打开 https://git-scm.com/download/win，下载会自动开始。

安装完成后，在`cmd`或`powershell`中输入`git --version`来确认安装状态。

其他操作系统的安装过程可以参见[这里](https://git-scm.com/book/zh/v2/%E8%B5%B7%E6%AD%A5-%E5%AE%89%E8%A3%85-Git)。

#### 配置 Git

安装完 Git 之后，要做的第一件事就是设置你的用户名和邮件地址。 这一点很重要，因为每一个 Git 提交都会使用这些信息，它们会写入到你的每一次提交中，不可更改：

```shell
$ git config --global user.name "YourName"
$ git config --global user.email YourMail@example.com
```

## 实验内容

1. 新建一个空目录，使用`git init`将其初始化为一个Git项目仓库。
2. 为这个新的项目添加一份README.md文件，输入任意几行字符串并保存退出。然后用`git add`先添加该文件到暂存区，最后用`git commit`进行第一次提交。
3. 运行`git status`查看当前仓库的状态，然后新增一个HelloWorld.java文件并输入打印"HelloWorld"的代码，接着再对README.md文件进行一些修改，保存后再次查看仓库状态。这时候仓库的状态和刚才有什么不一样？新增的信息说明什么？
4. 使用`git add .`命令将git追踪的所有更改保存到暂存区，然后进行提交。
5. 在README.md中添加对HelloWorld.java文件的简单说明，并在HelloWorld.java文件中修改代码，使其打印两次，将这两个改动分别提交到两次提交，提交信息分别为"change README.md"和"change HelloWorld.java"。是git的哪个功能可以让你进行这样的操作？
6. 运行`git branch`查看当前分支的名字，使用`git branch newbranch`新建一个名为`newbranch`的分支，并用`git checkout newbrach`切换到这个新分支上。在新分支上修改HelloWorld.java文件使其打印三次然后提交，切换回原来的分支在README.md添加几行修改并提交，最后使用`git merge newbranch`命令合并newbranch分支到当前分支。(如果你再任意时候忘记了你当前处于哪一分支上，可以运行`git branch`或`git log`来获取信息)
7. 新建一个分支，修改README.md文件中的某一行提交，然后切换回原来的分支，修改README.md文件中的同一行提交。这时将新分支合并到当前分支，发生了什么？`<<<<<<<`, `=======`, 和`>>>>>>>`符号都代表什么？通过编辑文件解决分支冲突并保留你想要的内容，用`git add` 完成合并来解决冲突以及`git commit`（或`git merge --continue`）
8. 用 `git log --graph` 来可视化你刚创建的合并历史。
9. 尝试创建一个Github账户，使用远程Git仓库来管理项目（你需要在Github中配置邮箱地址才可以使用）。新建一个Github仓库，在刚刚的本地目录中运行`git remote add <name> <url>`来建立本地和远程Github仓库的连接。然后运行`git push <remote> <local branch>:<remote branch>`将本地仓库推送至远程仓库。
10. 在另一个目录运行`git clone`命令从远程下载刚刚推送的仓库，进行一些修改并提交，最后推送到远程仓库。这时切换回原来的目录，运行`git fetch`和`git merge`（或直接运行`git pull`）获取远程仓库的最新更改并合并到本地仓库分支中。
11. 与一位同学（仓库管理者）交换Github仓库的地址，在Github中fork他\她的仓库，进行一些修改并提交，推送到远程仓库后创建一个新的`Pull Request`并与仓库的管理者进行交流，最后仓库的管理者决定对PR进行合并或关闭。

## 延伸阅读

1. [Missing Semester: Version Control and Git](https://missing.csail.mit.edu/2026/version-control/) (简单快速的理解Git工作原理与基础操作)
2. [Git 分支合并: merge 和 squash merge 以及 git rebase 之间的区别](https://zhuanlan.zhihu.com/p/519497650)
3. [Pro Git](https://git-scm.com/book/zh/v2): 第 1 到第 5 章包含大部分熟练使用 Git 所需的内容，后面的章节包含一些进阶内容（Git底层原理与高级操作等）。

