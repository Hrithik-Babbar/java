public class index {
    public static void main(String[] args) {
        User user1 = new User("Hrithik","8128891892");
        User user2 = new User("Rahul","8930129127");
        User user3 = new User("Austin","8912898912");
        user1.follow(user2);
        user1.follow(user3);
        user1.unfollow(user2);
        user1.createPost("my first post");
        user3.createPost("3rd user post 1");
        user1.getFeed().forEach(feed -> System.out.printf("%s%n", feed.getMessage()));
        user1.follow(user2);
        user2.createPost("2nd user post 2");
        System.out.println();
        user1.getFeed().forEach(feed -> System.out.printf("%s%n", feed.getMessage()));
    }
}
