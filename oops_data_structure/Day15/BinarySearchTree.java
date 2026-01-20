 interface INode<K extends Comparable<K>> {
    K getKey();
    INode<K> getLeft();
    INode<K> getRight();
    void setLeft(INode<K> left);
    void setRight(INode<K> right);
}
 class MyBinaryNode<K extends Comparable<K>> implements INode<K> {

    private K key;
    private INode<K> left;
    private INode<K> right;

    public MyBinaryNode(K key) {
        this.key = key;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public INode<K> getLeft() {
        return left;
    }

    @Override
    public INode<K> getRight() {
        return right;
    }

    @Override
    public void setLeft(INode<K> left) {
        this.left = left;
    }

    @Override
    public void setRight(INode<K> right) {
        this.right = right;
    }
}
 class MyBinarySearchTree<K extends Comparable<K>> {

    private INode<K> root;

    public void add(K key) {
        root = addRecursively(root, key);
    }

    private INode<K> addRecursively(INode<K> current, K key) {

        if (current == null) {
            return new MyBinaryNode<>(key);
        }

        if (key.compareTo(current.getKey()) < 0) {
            current.setLeft(addRecursively(current.getLeft(), key));
        } else {
            current.setRight(addRecursively(current.getRight(), key));
        }

        return current;
    }

    public INode<K> getRoot() {
        return root;
    }
}
public class BinarySearchTree {

    public static void main(String[] args) {

        MyBinarySearchTree<Integer> bst = new MyBinarySearchTree<>();

        bst.add(56);  // root
        bst.add(30);  // left child
        bst.add(70);  // right child

        System.out.println("Root: " + bst.getRoot().getKey());
        System.out.println("Left Child: " + bst.getRoot().getLeft().getKey());
        System.out.println("Right Child: " + bst.getRoot().getRight().getKey());
    }
}
