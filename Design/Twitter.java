public class Twitter {
    public static int timestamp = 0;
    private class Tweet {
        int userId;
        int tweetId;
        int timestamp;
        public Tweet(int userId, int tweetId, int timestamp) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }
    Map<Integer, Set<Integer>> follows;
    Map<Integer, List<Tweet>> tweets;
    /** Initialize your data structure here. */
    public Twitter() {
        follows = new HashMap<>();
        tweets = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!follows.containsKey(userId)) {
            follows.put(userId, new HashSet<Integer>());
            follows.get(userId).add(userId);
        }
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<Tweet>());
        }
        tweets.get(userId).add(new Tweet(userId, tweetId, timestamp++));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        if (!follows.containsKey(userId)) {
            return feed;
        }
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> (b.timestamp - a.timestamp));
        for (int user : follows.get(userId)) {
            if (tweets.containsKey(user)) {
                for (Tweet tweet : tweets.get(user)) {
                    pq.offer(tweet);
                }
            }
        }
        while (!pq.isEmpty() && feed.size() < 10) {
            feed.add(pq.poll().tweetId);
        }
        return feed;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!follows.containsKey(followerId)) {
            follows.put(followerId, new HashSet<Integer>());
            follows.get(followerId).add(followerId);
        }
        follows.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId) && followerId != followeeId) {
            follows.get(followerId).remove(followeeId);
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
