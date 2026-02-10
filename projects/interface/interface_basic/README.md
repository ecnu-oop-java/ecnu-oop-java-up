# 接口与抽象类基础

## 实验内容

1. 定义并实现以下商品相关的类结构.

  - Item 抽象类.

    |数据成员| 说明|
    |---|---|
    |name (String, protected, final)    |商品名称|
    |cost (double, protected, final)    |价格|

    |方法  |说明|
    |---|---|
    |getCost()          |返回价格|
    |getName()          |返回名称|
    |costPerUnit()      |单价, 抽象方法|
    |toString()         |转化为 String|

  - Produce 类 (生鲜商品). 为 Item 的子类. 

    |数据成员| 说明|
    |---|---|
    |pounds (double, private)   |商品重量|
    |category (String, private) |种类 (例如: Vegetable, fruit)|

    |方法  |说明|
    |---|---|
    |costPerUnit()  |单价|
    |getPounds()    |返回重量(Kg)|
    |setPounds()    |设置重量|
    |getCategory()  |返回种类|
    |setCategory()  |设置种类|
    |toString()     |转化为 String|

  - Beverage 类 (饮品). 为 Item 的子类

    |数据成员| 说明|
    |---|---|
    |volume (double, private)               |商品体积(L)|
    |containerDeposit (double, private)     |回收费用|

    |方法  |说明|
    |---|---|
    |costPerUnit()      |单价 |
    |getCost()          |重写返回价格函数, 需回收费用|
    |getVolume()                |返回体积|
    |setVolume()                |设置体积|
    |getContainerDeposit()      |返回回收费用|
    |setContainerDeposit()      |设置回收费用|
    |toString()                 |转化为 String|


  - Package 类(包装在盒子中的商品). 为 Item 的子类

    |数据成员| 说明|
    |---|---|
    |length (double, private)    |包装盒的长度|
    |width  (double, private)    |包装的宽度|
    |height (double, private)    |包装的高度|

    |方法  |说明|
    |---|---|
    |costPerUnit()  |单价 |
    |getSize()      |返回体积|
    |toString()     |转化为 String|

  - ShoppingCart 类 (购物车).

    |数据成员| 说明|
    |---|---|
    |cart (array, private)      |放置 Item 的数组|
    |maxSize (int)              |cart数组长度|
    |currentSize (int)          |购物车当前有多少商品|

    |方法  |说明|
    |---|---|
    |addItem()           |添加商品|
    |display()           |输出商品信息|
    |totalCost()         |输出购物车内商品总价|
    |numberInCart(s)     |给定商品名称s, 查看购物车中有多少该商品|

2. 农场中有许多动物, 动物表示为 Animal 接口, 它包含方法

    |方法  |说明|
    |---|---|
    |String getType()   |返回动物的类型|
    |String getSound()  |返回动物的叫声(比如"moo" (牛), "cheep"(鸡), "oink" (猪))|

  - 编写Cow, Hen, Pig 类, 实现 Animal 接口.
  - 定义 Farm 类, 包含以下方法

    |数据成员| 说明|
    |---|---|
    |animals (array, private)   |包含农场中的动物|

    |方法  |说明|
    |---|---|
    |animalSound()  |打印农场中所有动物的叫声|

  - 另外有接口 MilkProvider, EggProvider, 分别包含方法 `getMilk()`, `getEgg()`. 修改 Cow, Hen 类的定义, 在实现 Animal 类基础上, 分别实现 MilkProvider 接口 和 EggProvider 接口.
  - 定义 Farmer 类, 包含方法 `fetchMilk(MilkProvider a), fetchEgg(EggProvider a)`. 
  - 在 Farm 类中添加数据成员 `Farmer farmer`, `MilkProvider []mp`, `EggProvider []ep`. 数组 `mp, ep` 分别包含 animal 数组中的 MilkProvider 和 EggProvider. 
  - 在 Farm 类中添加新方法 `produce()`, 对`mp, ep`数组中的对象, 调用 Farmer 对象的 `fetchMilk, fetchEgg` 方法.


