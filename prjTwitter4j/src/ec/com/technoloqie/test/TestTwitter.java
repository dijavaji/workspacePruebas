package ec.com.technoloqie.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.json.DataObjectFactory;

/**
 * Clase de para probar el api de tweeter4j 
 * @author technoloqie
 *
 */
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
	            Query query = new Query("@MashiRafael");
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
	
	@Ignore
	public void jsonSearchTwetts() throws TwitterException{
		ConfigurationBuilder cb = new ConfigurationBuilder();
	    cb.setDebugEnabled(true)
	          .setOAuthConsumerKey("j2q4tqEaB5l5tPRW5X2H9flRZ")
	          .setOAuthConsumerSecret("rlckxtUWZeqSLV1fbfB7ZenQWj6bC88dMwKj11cc8CY6OaHmYl")
	          .setOAuthAccessToken("2491865817-9qngSxV3tPzJ3q4BUsjNgKpmnB4d5LXq4Uw2nrO")
	          .setOAuthAccessTokenSecret("WnWfYFAqGZ8MzdgaaSYrT7hJ4zFpV8FxKtDbE1S54yIgM");
	    TwitterFactory tf = new TwitterFactory(cb.build());
	    Twitter twitter = tf.getInstance();
		
		
	    //cb.setJSONStoreEnabled(true);

	    //Twitter twitter = new TwitterFactory(cb.build()).getInstance();
	    Query query = new Query("@MashiRafael");
	    QueryResult result = twitter.search(query);
	    List<Status> tweets = result.getTweets();
	    for (Status tweet : tweets) {
	        System.out.println(tweet.getGeoLocation() + ":" + tweet.getText());
	        String json = DataObjectFactory.getRawJSON(tweet);
	        System.out.println(json);
	    }
	}
	
	/**
	 * Prueba de guardado del retorno de los 20 mas recientes statuses, posteado por el usuario autentificado con los usuarios amigos. 
	 */
	@Test
	public void testStatusesTweet() {
		  //size(600, 400);

		  //Credentials
		  
		  ConfigurationBuilder cb = new ConfigurationBuilder();
		  cb.setOAuthConsumerKey("j2q4tqEaB5l5tPRW5X2H9flRZ");
		  cb.setOAuthConsumerSecret("rlckxtUWZeqSLV1fbfB7ZenQWj6bC88dMwKj11cc8CY6OaHmYl");
		  cb.setOAuthAccessToken("2491865817-9qngSxV3tPzJ3q4BUsjNgKpmnB4d5LXq4Uw2nrO");
		  cb.setOAuthAccessTokenSecret("WnWfYFAqGZ8MzdgaaSYrT7hJ4zFpV8FxKtDbE1S54yIgM");
		  cb.setDebugEnabled(true);
		  Twitter twitter = new TwitterFactory(cb.build()).getInstance();

		 System.out.println("Guardando public timeline.");
		        try {
		            new File("/home/thc/Documents/statuses").mkdir();
		            List<Status> statuses = twitter.getHomeTimeline();
		            for (Status status : statuses) {
		                String rawJSON = DataObjectFactory.getRawJSON(status);
		                String fileName = "/home/thc/Documents/statuses/" + status.getId() + ".json";
		                storeJSON(rawJSON, fileName);
		                System.out.println(fileName + " - " + status.getText());
		            }
		            System.out.print("\ndone.");
		            System.exit(0);
		        } catch (IOException ioe) {
		            ioe.printStackTrace();
		            System.out.println("Fallo al guardar los tweets: " + ioe.getMessage());
		        } catch (TwitterException te) {
		            te.printStackTrace();
		            System.out.println("Fallo al tomar la timeline: " + te.getMessage());
		            System.exit(-1);
		        }
		    

		}
	
	
	private static void storeJSON(String rawJSON, String fileName) throws IOException {
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            fos = new FileOutputStream(fileName);
            osw = new OutputStreamWriter(fos, "UTF-8");
            bw = new BufferedWriter(osw);
            bw.write(rawJSON);
            bw.flush();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ignore) {
                }
            }
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException ignore) {
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ignore) {
                }
            }
        }
	}     

}
