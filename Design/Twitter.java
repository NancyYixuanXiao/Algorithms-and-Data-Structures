public class Twitter {
    
    public static int timestamp = 0;
    Map<Integer, User> users;
    
    private class User {
        int userId;
        Set<Integer> followees;
        List<Tweet> tweets;
        public User(int userId) {
            this.userId = userId;
            followees = new HashSet<>();
            followees.add(userId);
            tweets = null;
        }
    }
    
    private class Tweet {
        int tweetId;
        int userId;
        int timestamp;
        public Tweet(int tweetId, int userId, int timestamp) {
            this.tweetId = tweetId;
            this.userId = userId;
            this.timestamp = timestamp;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        users = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) {
            users.put(userId, new User(userId));
        }
        if (users.get(userId).tweets == null) {
            users.get(userId).tweets = new ArrayList<>();
        }
        users.get(userId).tweets.add(new Tweet(tweetId, userId, timestamp++));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feeds = new ArrayList<>();
        if (!users.containsKey(userId)) {
            return feeds;
        }
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> (b.timestamp - a.timestamp));
        for (int id : users.get(userId).followees) {
            if (users.get(id).tweets != null) {
                for (Tweet tweet : users.get(id).tweets) {
                    pq.offer(tweet);
                }
            }
        }
        while (!pq.isEmpty() && feeds.size() < 10) {
            feeds.add(pq.poll().tweetId);
        }
        return feeds;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            users.put(followerId, new User(followerId));
        }
        if (!users.containsKey(followeeId)) {
            users.put(followeeId, new User(followeeId));
        }
        users.get(followerId).followees.add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (users.containsKey(followerId) && followerId != followeeId) {
            users.get(followerId).followees.remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
