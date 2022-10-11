### 10、流程图

``` mermaid
graph LR
A[开始]
	A-->B[中间]
	B-->C[结束]
```

> markdown是轻量级的文本编辑器，mermaid画图时不能同时从上到下，又从左到右；

> - 节点名不能与关键字同名
> - 使用引号可以避免不必要的麻烦，如避免与关键字同名

#### 10.1 图方向

- TB，从上到下
- TD，从上到下
- BT，从下到上
- RL，从右到左
- LR， 从左到右

例如：

```mermaid
graph TB
A(START)
A-->B[NEXT]
B-->C{case}
C-->D(finish)
```

``` mermaid
graph BT
A(start)
A-->B[step]
B-->C{finish}
```

```mermaid
graph LR
A-->B
B-->C
C-->D
D-->A
```

####  10.2 节点形状

> 节点的形状不同

- 默认节点A
- 文本节点B[bname]
- 圆角节点C（cname）
- 圆形节点D（（dname））
- 非对称节点E>ename]
- 菱形节点P{fname}

```mermaid
graph TB
A
B[bname]
C(cname)
D((dname))
E>ename]
F{fname}
```

#### 10.3 连线类型

> 节点之间的连线也有不同的方式，可以在连线中添加标签

- 箭头连接 A1-->B1
- 开放连接 A2-->B2
- 标签连接 A3-text-B3
- 箭头标签连接 A4-text->B4
- 虚线开放连接 A5.-B5
- 虚线箭头连接A6-.->B6
- 标签虚线连接A7-.text->B8
- 粗线开放连接A9===B9
- 粗线箭头连接A10==>B10
- 标签粗线开放连接A11== text ==B11
- 标签粗箭头连接A12== text ==>B12 

```mermaid
graph TB
A1-->B1
A2---B2
A3--text---B3
A4--text-->B4
A5-.-B5
A6-.->B6
A7-.text.-B7
A8-.text.->B8
A9===B9
A10==>B10
A11==text===B11
A12==text==>B12
```

#### 子图（subgraph）

```mermaid
graph TB

subgraph  one
A(start)-->B[deal]
end

style A fill:#f9f,stroke:#333,stroke-width:4px
style B fill:#bbf,stroke:#f66,stroke-width:2px,color:#fff,stroke-dasharray: 5, 5

subgraph two
C(start)-->D[DEAL]
end

B-->D
```

#### 序列图

- participant

  参与者，相当于定义模块，可通过设定参与者（participant）的顺序控制展示顺序；

  如下：

  ```sequence
    participant A 
    participant B 
  ```

  ```sequence
  participant B
  participant A
  ```

  ##### ==使用别名==

  ```sequence
  participant A as Dog
  participant B as Cat
  
  Dog->Cat:hello
  ```

  ##### ==note==(注释)

  - 

  ```sequence
  participant A
  participant B
  note right of A:Text
  note  left of A:test
  ```

  ##### ==循环==

  - 示例有问题

  ```sequence
  loop 
  
  end
  ```