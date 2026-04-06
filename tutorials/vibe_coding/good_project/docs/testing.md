# 测试文档

本文档说明简易图书管理系统的测试策略、覆盖范围和执行方式。

## 1. 测试目标

1. 验证核心业务逻辑的正确性。
2. 验证异常分支行为符合预期。
3. 验证实体类 Book 的基本数据行为和字符串表示。

## 2. 测试范围

1. LibraryTest

- addBook：正常添加、空对象、空 id、重复 id
- borrowBook：正常借阅、借不存在图书、重复借阅
- returnBook：正常归还、还不存在图书、还未借出图书
- listAvailableBooks：过滤逻辑是否正确

2. BookTest

- Getter/Setter 行为正确性
- toString 是否包含关键字段

## 3. 测试用例设计摘要

1. 正向用例

- 添加唯一 id 图书后，可借列表数量增加。
- 借出图书后，可借列表中不再包含该图书。
- 归还图书后，可借列表中重新包含该图书。

2. 异常用例

- 添加重复 id 抛 IllegalArgumentException。
- 借阅不存在 id 抛 NoSuchElementException。
- 重复借阅抛 IllegalStateException。
- 归还未借出图书抛 IllegalStateException。
- 归还不存在 id 抛 NoSuchElementException。

## 4. 执行方式

在项目根目录运行：

```bash
mvn test
```

Maven Surefire 会自动发现并执行 src/test/java 下以 Test 结尾的测试类。

## 5. 预期结果

1. 所有测试通过。
2. 失败时可在控制台查看失败测试名与断言差异。
3. 若需定位问题，可结合 Main 的流程演示快速复现异常场景。
