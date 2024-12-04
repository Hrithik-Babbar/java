import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private final Double userId;
    private String name;
    private String phone;
    List<Post>posts;
    HashSet<User>followers;
    HashSet<User> followings;
    List<Post>feeds;

    public User(String name, String phone) {
        this.userId = Math.random();
        this.name = name;
        this.phone = phone;
        this.posts = new ArrayList<>();
        this.followers = new HashSet<>();
        this.followings = new HashSet<>();
        feeds = new ArrayList<>();
    }

    public Double getId() {
        return userId;
    }
    public void follow(User user){
        this.followings.add(user);
        user.getFollowed(this);
    }
    public void unfollow(User user){
        this.followings.remove(user);
        user.getUnfollowed(this);
    }
    public void getFollowed(User user){
        this.followers.add(user);
    }
    public void getUnfollowed(User user){
        this.followers.remove(user);
    }
    public void createPost(String message) {
        Post post = new Post(message);
        this.posts.add(post);
        this.followers.forEach(follower -> {
            follower.addToFeed(post);
        });
    }
    public List<Post> getPosts(){
        return this.posts;
    }
    public void deletePost(Double id) {
        this.posts.removeIf(item -> item.getId().equals(id));
    }
    public void addToFeed(Post post){
        this.feeds.add(post);
    }
    public List<Post> getFeed(Integer skip,Integer limit){
        return this.feeds.stream()
                .skip(skip)
                .limit(limit)
                .collect(Collectors.toList());
    }
    public List<Post> getFeed(){
        return this.feeds;
    }
}
