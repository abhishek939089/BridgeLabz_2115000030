class Item {
    String name;
    int id, quantity;
    double price;
    Item next;

    Item(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    Item head;

    void addItemAtBeginning(int id, String name, int quantity, double price) {
        Item newItem = new Item(id, name, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    void addItemAtEnd(int id, String name, int quantity, double price) {
        Item newItem = new Item(id, name, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newItem;
    }

    void addItemAtPosition(int id, String name, int quantity, double price, int position) {
        if (position <= 1) {
            addItemAtBeginning(id, name, quantity, price);
            return;
        }
        Item newItem = new Item(id, name, quantity, price);
        Item temp = head;
        int count = 1;
        while (temp.next != null && count < position - 1) {
            temp = temp.next;
            count++;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }

    void removeItem(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.id != id) temp = temp.next;
        if (temp.next != null) temp.next = temp.next.next;
    }

    void updateQuantity(int id, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
    }

    Item searchById(int id) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    Item searchByName(String name) {
        Item temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) return temp;
            temp = temp.next;
        }
        return null;
    }

    double calculateTotalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        return total;
    }

    void displayInventory() {
        Item temp = head;
        while (temp != null) {
            System.out.println(temp.id + " " + temp.name + " " + temp.quantity + " " + temp.price);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addItemAtBeginning(1, "Laptop", 5, 800);
        inventory.addItemAtEnd(2, "Mouse", 10, 20);
        inventory.addItemAtPosition(3, "Keyboard", 7, 50, 2);
        inventory.displayInventory();
        System.out.println("Total Inventory Value: " + inventory.calculateTotalValue());
        inventory.updateQuantity(1, 10);
        inventory.removeItem(2);
        inventory.displayInventory();
        System.out.println("Total Inventory Value: " + inventory.calculateTotalValue());
    }
}
