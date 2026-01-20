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
     private int size = 0;

     public void add(K key) {
         root = addRecursively(root, key);
     }

     private INode<K> addRecursively(INode<K> current, K key) {
         if (current == null) {
             size++;
             return new MyBinaryNode<>(key);
         }

         if (key.compareTo(current.getKey()) < 0) {
             current.setLeft(addRecursively(current.getLeft(), key));
         } else {
             current.setRight(addRecursively(current.getRight(), key));
         }
         return current;
     }
     public boolean search(K key) {
         return searchRecursively(root, key);
     }

     private boolean searchRecursively(INode<K> current, K key) {

         if (current == null) {
             return false;
         }

         if (key.equals(current.getKey())) {
             return true;
         }

         if (key.compareTo(current.getKey()) < 0) {
             return searchRecursively(current.getLeft(), key);
         } else {
             return searchRecursively(current.getRight(), key);
         }
     }

     public int size() {
         return size;
     }
 }
 public class BinarySearchTree {

     public static void main(String[] args) {

         MyBinarySearchTree<Integer> bst = new MyBinarySearchTree<>();

         int[] values = {
                 56, 30, 70, 22, 40, 60, 95,
                 11, 16, 65, 63, 67, 3
         };

         for (int value : values) {
             bst.add(value);
         }
         int key=4;
         System.out.println("Is "+key+" present: " + bst.search(key));
     }
 }



