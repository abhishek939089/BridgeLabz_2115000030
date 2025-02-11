class Friend {
    int id;
    Friend next;

    Friend(int id) {
        this.id = id;
        this.next = null;
    }
}

class User {
    int userId;
    String name;
    Friend friends;
    User next;

    User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.friends = null;
        this.next = null;
    }

    void addFriend(int friendId) {
        Friend newFriend = new Friend(friendId);
        newFriend.next = friends;
        friends = newFriend;
    }

    void displayFriends() {
        Friend temp = friends;
        while (temp != null) {
            System.out.print(temp.id + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class SocialNetwork {
    User head;

    void addUser(int userId, String name) {
        User newUser = new User(userId, name);
        newUser.next = head;
        head = newUser;
    }

    User searchUser(int userId) {
        User temp = head;
        while (temp != null && temp.userId != userId) temp = temp.next;
        return temp;
    }

    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();
        network.addUser(1, "Alice");
        network.addUser(2, "Bob");
        network.searchUser(1).addFriend(2);
        network.searchUser(2).addFriend(1);
        network.searchUser(1).displayFriends();
        network.searchUser(2).displayFriends();
    }
}
