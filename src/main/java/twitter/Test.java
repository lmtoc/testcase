package twitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * User: luomeichen
 * Date: 2023/5/5
 * Time: 10:45 AM
 */

public class Test {


    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(2, 5);
        twitter.postTweet(2, 1);
        twitter.postTweet(2, 2);
        twitter.postTweet(2, 3);
        twitter.postTweet(2, 6);
        twitter.postTweet(2, 7);
        twitter.postTweet(2, 8);
        twitter.postTweet(2, 9);
        twitter.postTweet(2, 10);
        twitter.postTweet(2, 11);
        twitter.postTweet(2, 12);
        twitter.postTweet(2, 13);
        System.out.println(twitter.getNewsFeed(2));
        twitter.follow(1, 2);
        System.out.println(twitter.getNewsFeed(1));


        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
        System.out.println(twitter.getNewsFeed(2));



    }

}


class Twitter {

    private Map<Integer, Set<Integer>> followerMap = new HashMap<>();

    private Map<Integer, Set<Integer>> followeeMap = new HashMap<>();

    private Map<Integer, ArrayList<PostContent>> userIdToFeeds = new HashMap<>();
    private Map<Integer, ArrayList<PostContent>> userIdToPosts = new HashMap<>();

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        // 获取所有的关注userId的用户，并为他们产生新的实时流
        Set<Integer> follower = followeeMap.get(userId);
        PostContent postContent = new PostContent(tweetId, userId);

        if (follower != null) {
            // feed流新增内容
            for (Integer followerSingle : follower) {
                addPostForUserId(followerSingle, postContent);
            }
        }
        // 记录用户发布的内容
        ArrayList<PostContent> userPosted = userIdToPosts.getOrDefault(userId, new ArrayList<>());
        if (userPosted == null) {
            userPosted = new ArrayList<>();
        }
        userPosted.add(postContent);
        userIdToPosts.put(userId, userPosted);

        //更新本人的feed流
        addPostForUserId(userId, postContent);

    }

    public void addPostForUserId(Integer userId, PostContent postContent) {
        ArrayList<PostContent> postIds = userIdToFeeds.get(userId);
        // if (postId != null && postIds.size() >= 10) {
        // postId.removeLast();
        // } else
        if (postIds == null) {
            postIds = new ArrayList<PostContent>();
        }
        if (postContent == null) {
            return;
        }
        postIds.add(postContent);
        userIdToFeeds.put(userId, postIds);
    }

    public List<Integer> getNewsFeed(int userId) {
        ArrayList<PostContent> result = userIdToFeeds.get(userId);
        if (result == null || result.size() == 0) {
            return new ArrayList<>();
        }
        List<Integer> postIds = new ArrayList<>();
        if (result.size() > 10) {
            postIds = result.subList(result.size() - 10, result.size()).stream().map(post -> post.postId).collect(Collectors.toList());
        } else {
            postIds = result.stream().map(post -> post.postId).collect(Collectors.toList());

        }
        Collections.reverse(postIds);
        return postIds;

    }

    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }
        // 更新关注者关系
        Set<Integer> follower = followerMap.getOrDefault(followerId, new HashSet<>());
        if (follower == null || follower.isEmpty()) {
            follower = new HashSet<>();
        }
        if(follower.contains(followeeId)){   //禁止重复操作
            return ;
        }
        follower.add(followeeId);

        followerMap.put(followerId, follower);
        // 更新被关注者关系

        Set<Integer> followee = followeeMap.getOrDefault(followeeId, new HashSet<>());
        if (followee == null || followee.isEmpty()) {
            followee = new HashSet<>();
        }
        followee.add(followerId);
        followeeMap.put(followeeId, followee);


        addPostForUserId(followerId, followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId) { // 自己不能关注自己
            return;
        }
        // 更新关注者关系
        Set<Integer> follower = followerMap.getOrDefault(followerId, new HashSet<>());
        if (follower == null || follower.isEmpty()) {
            follower = new HashSet<>();
        }
        follower.remove(Integer.valueOf(followeeId));

        followerMap.put(followerId, follower);
        // 更新被关注者关系
        Set<Integer> followee = followeeMap.getOrDefault(followeeId, new HashSet<>());
        if (followee == null || followee.isEmpty()) {
            followee = new HashSet<>();
        }
        followee.remove(followerId);
        followeeMap.put(followeeId, followee);

        removePostByUserId(followerId, followeeId);
    }

    private void addPostForUserId(Integer userIdInteger, Integer needAddUserId) {
        ArrayList<PostContent> feeds = userIdToFeeds.get(userIdInteger);


        ArrayList<PostContent> needAdd = userIdToPosts.get(needAddUserId);
        if (needAdd == null || needAdd.isEmpty()) { // 没有需要新增的首页内容
            return;
        }
        ArrayList<PostContent> newFeeds = new ArrayList<>();

        //原本首页没有东西的情况直接添加即可
        if (feeds == null) {
            newFeeds.addAll(needAdd);
            userIdToFeeds.put(userIdInteger, newFeeds);
            return;
        }

        PostContent currentAdd = null;
        Integer needAddIndex = 0;
        Integer originFeedIndex = 0;
        Integer feedOriginSize = feeds.size();
        while (needAddIndex < needAdd.size()) {
            // 如果feed流到了末尾，那么直接接上，并且break即可
            if (originFeedIndex >= feedOriginSize || feeds.get(originFeedIndex) == null) {
                newFeeds.addAll(needAdd.subList(needAddIndex, needAdd.size()));
                break;
            }
            //比对当前的需要添加的post与 originFeedItem 的发送时间，如果 originFeedItem 的时间更大
            //那么就 originFeedIndex 后移；
            //这样做的目标是 找到第一个比 needAdd 时间小的，并且将needAdd插入在他前面
            //插入后则 needAddIndex++；needAdd = getNext()
            currentAdd = needAdd.get(needAddIndex);
            PostContent feedItem = feeds.get(originFeedIndex);
            if (feedItem.postTimeMills < currentAdd.postTimeMills) {
                newFeeds.add(feedItem);
                originFeedIndex++;
            } else { //移动坐标选择
                newFeeds.add(currentAdd);
                needAddIndex++;
            }

        }
        //最后需要判断原来的有没有空
        if (originFeedIndex < feedOriginSize) {
            newFeeds.addAll(feeds.subList(originFeedIndex, feedOriginSize));

        }
        userIdToFeeds.put(userIdInteger, newFeeds);

    }


    private void removePostByUserId(Integer userId, Integer rmUserId) {
        ArrayList<PostContent> feeds = userIdToFeeds.get(userId);
        if (feeds == null || feeds.isEmpty()) {
            return;
        }


        ArrayList<PostContent> resultFeeds = new ArrayList();

        for (PostContent feeContent : feeds) { //直接用博文内部的发送者记录来判断是否需要移除
            if (feeContent == null || feeContent.creatorId == rmUserId) {
                continue;
            }
            resultFeeds.add(feeContent);
        }
        userIdToFeeds.put(userId, resultFeeds);
    }

    private class PostContent {

        public Integer postId;

        public Long postTimeMills;

        public Integer creatorId;

        public PostContent(Integer postId, Integer creatorId) {
            this.postId = postId;
            this.creatorId = creatorId;
            this.postTimeMills = System.nanoTime();
        }

    }


}

