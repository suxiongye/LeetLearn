package tree;

/**
 * TODO
 *
 * @author suxiongye
 * @date 2020/10/20 8:09 下午
 */
public class TreeCommonOpt {
    public Node rightRotate(Node node) {
        Node res = node.lChild;
        node.lChild = res.rChild;
        res.rChild = node;
    }
}
