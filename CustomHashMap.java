class CustomHashMap {
    private static class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private final int SIZE = 1000;
    private Node[] map;

    public CustomHashMap() {
        map = new Node[SIZE];
    }

    private int getIndex(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        Node head = map[index];

        if (head == null) {
            map[index] = new Node(key, value);
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        if (current.key == key) {
            current.value = value;
        } else {
            current.next = new Node(key, value);
        }
    }

    public int get(int key) {
        int index = getIndex(key);
        Node current = map[index];

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }

        return -1;
    }

    public void remove(int key) {
        int index = getIndex(key);
        Node current = map[index];
        Node prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    map[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public static void main(String[] args) {
        CustomHashMap hashMap = new CustomHashMap();
        hashMap.put(1, 10);
        hashMap.put(2, 20);
        System.out.println(hashMap.get(1));
        hashMap.remove(1);
        System.out.println(hashMap.get(1));
    }
}
