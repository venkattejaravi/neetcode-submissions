class Twitter {
    private static int timeStamp = 0;
    private Map<Integer, Tweet> tweets;
    private Map<Integer, Set<Integer>> follows;

    private class Tweet {
        int id;
        int time;
        Tweet next; 

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }

    public Twitter() {
        tweets = new HashMap<>();
        follows = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId, timeStamp++);
        newTweet.next = tweets.get(userId);
        tweets.put(userId, newTweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);

        follows.putIfAbsent(userId, new HashSet<>());
        follows.get(userId).add(userId);
        for(int followee: follows.get(userId)) {
            if(tweets.containsKey(followee)) {
                maxHeap.offer(tweets.get(followee));
            }
            
        }

        while(! maxHeap.isEmpty() && res.size() < 10 ) {
            Tweet tweet = maxHeap.poll();
            res.add(tweet.id);
            if(tweet.next != null) {
                maxHeap.offer(tweet.next);
            }
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(follows.containsKey(followerId)) {
            if(follows.get(followerId).contains(followeeId)) {
                follows.get(followerId).remove(followeeId);
            }
        }
    }
}
