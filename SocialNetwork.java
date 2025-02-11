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
        if (isFriend(friendId)) return; 
        Friend newFriend = new Friend(friendId);
        newFriend.next = friends;
        friends = newFriend;
    }

    void removeFriend(int friendId) {
        if (friends == null) return;
        if (friends.id == friendId) {
            friends = friends.next;
            return;
        }
        Friend temp = friends;
        while (temp.next != null && temp.next.id != friendId) temp = temp.next;
        if (temp.next != null) temp.next = temp.next.next;
    }

    boolean isFriend(int friendId) {
        Friend temp = friends;
        while (temp != null) {
            if (temp.id == friendId) return true;
            temp = temp.next;
        }
        return false;
    }

    void displayFriends() {
        System.out.print("Friends of " + name + " (" + userId + "): ");
        if (friends == null) {
            System.out.println("No friends.");
            return;
        }
        Friend temp = friends;
        while (temp != null) {
            System.out.print(temp.id + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    int countFriends() {
        int count = 0;
        Friend temp = friends;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

class SocialNetwork {
    User head;

    void addUser(int userId, String name) {
        if (searchUser(userId) != null) {
            System.out.println("User ID " + userId + " already exists.");
            return;
        }
        User newUser = new User(userId, name);
        newUser.next = head;
        head = newUser;
    }

    User searchUser(int userId) {
        User temp = head;
        while (temp != null && temp.userId != userId) temp = temp.next;
        return temp;
    }

    void addFriendship(int userId1, int userId2) {
        User user1 = searchUser(userId1);
        User user2 = searchUser(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("Invalid user(s). Friendship not added.");
            return;
        }
        user1.addFriend(userId2);
        user2.addFriend(userId1);
    }

    void removeFriendship(int userId1, int userId2) {
        User user1 = searchUser(userId1);
        User user2 = searchUser(userId2);
        if (user1 == null || user2 == null) return;
        user1.removeFriend(userId2);
        user2.removeFriend(userId1);
    }

    void findMutualFriends(int userId1, int userId2) {
        User user1 = searchUser(userId1);
        User user2 = searchUser(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("Invalid user(s). Cannot find mutual friends.");
            return;
        }
        System.out.print("Mutual Friends of " + user1.name + " and " + user2.name + ": ");
        boolean found = false;
        Friend temp = user1.friends;
        while (temp != null) {
            if (user2.isFriend(temp.id)) {
                System.out.print(temp.id + " ");
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.print("None");
        System.out.println();
    }

    void displayAllUsers() {
        User temp = head;
        while (temp != null) {
            System.out.println("User ID: " + temp.userId + ", Name: " + temp.name);
            temp.displayFriends();
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();
        network.addUser(1, "Alice");
        network.addUser(2, "Bob");
        network.addUser(3, "Charlie");

        network.addFriendship(1, 2);
        network.addFriendship(1, 3);
        network.addFriendship(2, 3);

        network.displayAllUsers();
        network.findMutualFriends(1, 2);

        network.removeFriendship(1, 3);
        network.displayAllUsers();
    }
}
