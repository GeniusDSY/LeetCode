# 链表

## 单链表

### 简介

#### 定义与结构

单链表中的每个结点不仅包含值，还包含链接到下一个结点的引用字段。通过这种方式，单链表将所有结点按顺序组织起来。

下面是一个单链表的例子：
![单链表](http://picture.geniusdsy.cn/picture/20191221/2mBlYwcXlP2x.png?imageslim)

> [链表结构代码](https://github.com/GeniusDSY/LeetCode/blob/master/src/base/ListNode.java)

在大多数情况下，我们将使用头结点(第一个结点)来表示整个列表。

#### 操作

与数组不同，我们无法在常量时间内访问单链表中的随机元素。 如果我们想要获得第 i 个元素，我们必须从头结点逐个遍历。 我们按索引来访问元素平均要花费 O(N) 时间，其中 N 是链表的长度。

- 添加操作
    - 使用给定值初始化新结点 cur；
    ![mark](http://picture.geniusdsy.cn/picture/20191224/ru5QumHTJBXw.png?imageslim)
    - 将 cur 的“next”字段链接到 prev 的下一个结点 next；
    ![mark](http://picture.geniusdsy.cn/picture/20191224/BqWR2s44twCx.png?imageslim)
    - 将 prev 中的“next”字段链接到 cur 。
    ![mark](http://picture.geniusdsy.cn/picture/20191224/oJXIG8LdEkJs.png?imageslim)
    
与数组不同，我们不需要将所有元素移动到插入元素之后。因此，您可以在 O(1) 
时间复杂度中将新结点插入到链表中，这非常高效。

> 在开头添加新结点

众所周知，我们使用头结点来代表整个列表。
因此，在列表开头添加新节点时更新头结点 head 至关重要。
- 1、初始化一个新结点 cur；
- 2、将新结点链接到我们的原始头结点 head。
![mark](http://picture.geniusdsy.cn/picture/20191224/R5ctQ4ccFgw7.png?imageslim)
- 3、将 cur 指定为 head。
![mark](http://picture.geniusdsy.cn/picture/20191224/9tkEBfKX4oCO.png?imageslim)

- 删除操作

    - 找到 cur 的上一个结点 prev 及其下一个结点 next；
    - 接下来链接 prev 到 cur 的下一个节点 next。

在我们的第一步中，我们需要找出 prev 和 next。使用 cur 的参考字段很容易找出 next，但是，我们必须从头结点遍历链表，以找出 prev，它的平均时间是 O(N)，其中 N 是链表的长度。因此，删除结点的时间复杂度将是 O(N)。

空间复杂度为 O(1)，因为我们只需要常量空间来存储指针。

> 删除第一个结点

如果我们想删除第一个结点，策略会有所不同。

正如之前所提到的，我们使用头结点 head 来表示链表。我们的头是下面示例中的黑色结点 23。
![mark](http://picture.geniusdsy.cn/picture/20191224/KqhDLrVjic6d.png?imageslim)
如果想要删除第一个结点，我们可以简单地将下一个结点分配给 head。也就是说，删除之后我们的头将会是结点 6。
![mark](http://picture.geniusdsy.cn/picture/20191224/pmBfnEQabQvg.png?imageslim)
链表从头结点开始，因此结点 23 不再在我们的链表中。

## 双指针技巧(链表)
这正是我们在链表中使用两个速度不同的指针时会遇到的情况：

如果没有环，快指针将停在链表的末尾。
如果有环，快指针最终将与慢指针相遇。
> 这两个指针的适当速度应该是多少？

一个安全的选择是每次移动慢指针一步，而移动快指针两步。每一次迭代，快速指针将额外移动一步。如果环的长度为 M，经过 M 次迭代后，快指针肯定会多绕环一周，并赶上慢指针。
## 经典问题

## 双链表

## 链表题解
- [141 linked-list-cycle 环形链表](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/linked_list/LinkedListCycle.java)
- [707 design-linked-list 设计链表](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/linked_list/DesignLinkedList.java)