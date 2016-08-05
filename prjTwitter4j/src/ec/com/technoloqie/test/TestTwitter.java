package ec.com.technoloqie.test;

import java.util.List;

import org.junit.Test;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TestTwitter {
	
	@Test
	public void searchForPublicTwetts(){
		ConfigurationBuilder cb = new ConfigurationBuilder();
	    cb.setDebugEnabled(true)
	          .setOAuthConsumerKey("j2q4tqEaB5l5tPRW5X2H9flRZ")
	          .setOAuthConsumerSecret("rlckxtUWZeqSLV1fbfB7ZenQWj6bC88dMwKj11cc8CY6OaHmYl")
	          .setOAuthAccessToken("2491865817-9qngSxV3tPzJ3q4BUsjNgKpmnB4d5LXq4Uw2nrO")
	          .setOAuthAccessTokenSecret("WnWfYFAqGZ8MzdgaaSYrT7hJ4zFpV8FxKtDbE1S54yIgM");
	    TwitterFactory tf = new TwitterFactory(cb.build());
	    Twitter twitter = tf.getInstance();
	        try {
	            Query query = new Query("lassoguillermo");
	            QueryResult result;
	            result = twitter.search(query);
	            List<Status> tweets = result.getTweets();
	            for (Status tweet : tweets) {
	                System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
	            }

	            System.exit(0);
	        } catch (TwitterException te) {
	            te.printStackTrace();
	            System.out.println("Failed to search tweets: " + te.getMessage());
	            System.exit(-1);
	        }
	}

}
