package tree;

/**
 * TODO
 *
 * @author suxiongye
 * @date 2020/10/20 8:06 下午
 */
public class Node {
    int val;
    Node lChild;
    Node rChild;
    int height;

    public Node(int val) {
        new Node(val, null, null);
    }

    public Node(int val, Node lChild, Node rChild,int height) {
        this.val = val;
        this.lChild = lChild;
        this.rChild = rChild;
        this.height = height;
    }
}
