package org.example.datastructure;

import lombok.Data;

/**
 * 这个实体类包含了二叉树节点的value、左子节点、右子节点和指向父节点的指针。可以根据需求进行修改和扩展。
 *
 * 需要注意的是，在构造函数中，我们默认将左子节点、右子节点和父节点初始化为null，因为有些二叉树节点并不一定拥有左右子节点和父节点，这样当节点不存在时，这些变量就能够保证为null。
 */
//@Data
public class TreeLinkNode extends TreeNode{
    //指向父亲结点的指针
    public TreeLinkNode parent = null;

    public TreeLinkNode() {
    }

    public TreeLinkNode(int val) {
        this.val = val;
    }

    public TreeLinkNode(int val, TreeNode left, TreeNode right, TreeLinkNode parent) {
        super(val, left, right);
        this.parent = parent;
    }

    public TreeLinkNode(int val, TreeLinkNode left, TreeLinkNode right, TreeLinkNode parent) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}
