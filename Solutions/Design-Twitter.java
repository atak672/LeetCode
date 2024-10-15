// https://leetcode.com/problems/design-twitter

import java.util.Date;

class Twitter {
    int clock = 0; 
    

    // Need a few hashmaps
        // Followers (i.d. for a user gets who they follow)
        // Posts (i.d. for user gets their tweets (sorted reverse by posted date?). Can also do list and count backwards for most recent from end)


    private Map<Integer, Set<Integer>> following; // Maps user to their following
    private Map<Integer, List<Tweet>> tweets; // Maps user ID to their tweets

    public Twitter() {
        this.following = new HashMap<>(); 
        this.tweets = new HashMap<>(); 
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, clock)); // add to end of growing list  
        clock += 1;       
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if (! following.keySet().contains(userId)){
            following.putIfAbsent(userId, new HashSet<>());
            following.get(userId).add(userId);
        }
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.date, b.date)); // Not sure how natural ordering works ofr dates !! check
        for (int account : following.get(userId)){
            List<Tweet> tweetList = tweets.get(account);
            for (int i = 0; tweetList != null && i < tweetList.size() && i < 10; i++){
                pq.offer(tweetList.get(tweetList.size() - i - 1));
                if (pq.size() > 10){
                    pq.poll(); 
                }
            }
        }
        List<Integer> ret = new ArrayList<>();
        while (! pq.isEmpty()){
            Tweet val = pq.poll();
            System.out.print(val.date);
            System.out.print("\n");
            ret.add(val.id);
        }
       Collections.reverse(ret);
       return ret;
    }
    
    public void follow(int followerId, int followeeId) {
        if (! following.keySet().contains(followerId)){
            following.putIfAbsent(followerId, new HashSet<>());
            following.get(followerId).add(followerId);
        }
        following.get(followerId).add(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (! following.keySet().contains(followerId)){
            return;
        }

        following.get(followerId).remove(followeeId);        
    }

    public class Tweet {
        int date; 
        int id; 

        public Tweet(int id, int date){
            this.date = date; 
            this.id = id; 
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