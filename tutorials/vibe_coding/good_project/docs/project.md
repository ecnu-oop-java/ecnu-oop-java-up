# 项目说明文档

## 1. 项目目标

本项目实现简易图书管理系统的核心业务逻辑，关注以下能力：

1. 图书信息管理。
2. 借阅状态流转。
3. 边界异常处理。
4. 可测试、可扩展的 Maven 工程结构。

## 2. 核心类设计

1. Book

- 角色：实体类，承载图书基础信息与借阅状态。
- 关键字段：id、title、author、isBorrowed。

2. Library

- 角色：领域服务类，封装核心业务规则。
- 内部存储：HashMap<String, Book>，键为 id。
- 关键方法：addBook、borrowBook、returnBook、listAvailableBooks。

3. Main

- 角色：示例入口。
- 用途：演示正常流程与异常边界。

## 3. 异常策略

1. IllegalArgumentException

- 新增图书参数非法（null book 或 null id）。
- 新增图书 id 重复。

2. NoSuchElementException

- 借阅或归还时指定 id 不存在。

3. IllegalStateException

- 借阅时图书已借出。
- 归还时图书未借出。

## 4. 目录约定

本项目遵循 Maven 标准布局：

1. src/main/java：主代码。
2. src/main/resources：资源文件。
3. src/test/java：测试代码。
4. docs：补充文档。
5. imgs：文档图片资源。

## 5. 运行与验证

1. 主程序运行：执行 Main 类。
2. 单元测试：执行 Maven test 生命周期。

详细测试策略见 [testing.md](testing.md)。
