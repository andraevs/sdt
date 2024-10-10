package mediator;

import java.util.ArrayList;
import java.util.List;

interface ChatRoomMediator {
    void sendMessage(String message, User sender);
    void sendPrivateMessage(String message, User sender, User receiver);
    void addUser(User user);
}

class ChatRoom implements ChatRoomMediator {
    private List<User> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, User sender) {
        for (User user : users) {
            if (user != sender) {
                user.receiveMessage(message, sender);
            }
        }
    }

    @Override
    public void sendPrivateMessage(String message, User sender, User receiver) {
        if (users.contains(receiver)) {
            receiver.receivePrivateMessage(message, sender);
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}

class User {
    private String name;
    private ChatRoomMediator chatRoom;

    public User(String name, ChatRoomMediator chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
        chatRoom.addUser(this);
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message) {
        chatRoom.sendMessage(message, this);
    }

    public void sendPrivateMessage(String message, User receiver) {
        chatRoom.sendPrivateMessage(message, this, receiver);
    }

    public void receiveMessage(String message, User sender) {
        System.out.println("[" + name + " receives] " + sender.getName() + ": " + message);
    }

    public void receivePrivateMessage(String message, User sender) {
        System.out.println("[" + name + " receives private] " + sender.getName() + ": " + message);
    }
}

public class MediatorExample {
    public static void main(String[] args) {
        ChatRoomMediator chatRoom = new ChatRoom();

        User alice = new User("Alice", chatRoom);
        User bob = new User("Bob", chatRoom);
        User charlie = new User("Charlie", chatRoom);

        alice.sendMessage("Hello everyone!");
        bob.sendMessage("Hi Alice!");
        charlie.sendMessage("Good day!");

        alice.sendPrivateMessage("How are you, Bob?", bob);
    }
}
