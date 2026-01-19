
class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
public class LinkedList<T> {

    Node<T> head;

    public void append(T data) {
        if (head == null) {
            head = new Node<>(data);
            return;
        }
        Node<T> temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = new Node<>(data);
    }

    public Node<T> search(T key) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(key))
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(56);
        list.append(30);
        list.append(70);

        System.out.println(list.search(30) != null);
    }
}