**Hidden 1**

```
raw_hidden1.txt
  mary;;MARY@EXAMPLE.COM|   los    angeles  
john|john@example.com,beijing
```

要求：clean 模式

**Hidden 2**

```
raw_hidden2.txt


Amy,amy@example.com,Paris,

Bob,bob@example.com,London
```

要求：clean模式；空行判断；字段数量非法判断

**Hidden 3**

```
raw_hidden3.txt
A,a@@b.com,City
B,@b.com,City
C,a@b.,City
D,a@b.com,City
E,a@bcom,City
```

要求：emails模式；合法邮箱检查

**Hidden 4**

```
raw_hidden4.txt
X,User@Example.com,SH
Y,user@example.com,BJ
Z,USER@example.com,GZ
```

要求：`--format lower --dedup` 