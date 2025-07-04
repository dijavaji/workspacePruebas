package ec.com.technoloqie.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
	
	/**
	 *	Busca tweets y guarda en archivos planos. 
	 */
	@Test
	public void searchForPublicTwettsStored(){
		ConfigurationBuilder cb = new ConfigurationBuilder();
	    cb.setDebugEnabled(true)
	          .setOAuthConsumerKey("j2q4tqEaB5l5tPRW5X2H9flRZ")
	          .setOAuthConsumerSecret("rlckxtUWZeqSLV1fbfB7ZenQWj6bC88dMwKj11cc8CY6OaHmYl")
	          .setOAuthAccessToken("2491865817-9qngSxV3tPzJ3q4BUsjNgKpmnB4d5LXq4Uw2nrO")
	          .setOAuthAccessTokenSecret("WnWfYFAqGZ8MzdgaaSYrT7hJ4zFpV8FxKtDbE1S54yIgM");
	    TwitterFactory tf = new TwitterFactory(cb.build());
	    Twitter twitter = tf.getInstance();
	        try {
	        	String candidato= "MashiRafael";
	        	Date dNow = new Date( );
	            SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd-hh:mm:ss");

	            System.out.println("Current Date: " + ft.format(dNow));
	            Query query = new Query("@"+candidato);
	            query.setCount(100);
	            //query.setLang("en");
	            query.setSince("2017-01-20");
	            query.setUntil("2017-01-27");
	            QueryResult result;
	            result = twitter.search(query);
	            List<Status> tweets = result.getTweets();
	            StringBuilder sb = new StringBuilder();
	            PrintWriter writer = new PrintWriter("/home/thc/Documents/Diego/AnalisisDatos/alianzaPais/"+candidato+ft.format(dNow), "UTF-8");
	            for (Status tweet : tweets) {
	            	//sb = new StringBuilder();
	            	sb.delete(0, sb.length());
	                sb.append(tweet.getCreatedAt());	//fecha creacion del tweet
	                sb.append("|");
	                sb.append(tweet.getUser().getScreenName());	//nombre del usuario
	                sb.append("|");
	                sb.append(tweet.getUser().getName());	//nombre del usuario completo
	                sb.append("|");
	                sb.append(tweet.getText());		//tweet texto
	                sb.append("|");
	                sb.append(tweet.getId());	//tweet id
	                sb.append("|");
	                sb.append(tweet.getSource());	//aplicacion q envio el tweet
	                sb.append("|");
	                sb.append(tweet.getUser().getFollowersCount());	//followers
	                sb.append("|");
	                sb.append(tweet.getUser().getFriendsCount());	//follows 
	                sb.append("|");
	                sb.append(tweet.getRetweetCount());		//retweets
	                sb.append("|");
	                sb.append(tweet.getFavoriteCount());	//favoritos
	                sb.append("|");
	                sb.append(tweet.getUser().isVerified());		//Whether this user has a verified badge.
	                sb.append("|");
	                sb.append(tweet.getUser().getCreatedAt());	//creado desde
	                sb.append("|");
	                sb.append(tweet.getUser().getLocation());		//location
	                sb.append("|");
	                sb.append(tweet.getUser().getDescription());	//bio
	                sb.append("|");
	                sb.append(tweet.getUser().getProfileImageURL());	//imagen de perfil
	                sb.append("|");
	                sb.append(tweet.getGeoLocation());	
	                sb.append("|");
	                sb.append(tweet.getUser().getId());
	            	System.out.println(sb.toString());
	            	writer.println(sb);
	            }
	            writer.close();	
	            System.exit(0);
	        } catch (TwitterException te) {
	            te.printStackTrace();
	            System.out.println("Failed to search tweets: " + te.getMessage());
	            System.exit(-1);
	        }catch (IOException e){
	        	System.out.println("Error al escribir archivo: " + e.getMessage());
	        }
	}
	
	@Test
	public void storePlain(){
		File file = new File("/home/thc/Documents/Diego/AnalisisDatos/Hello1.txt");
	      
	      // creates the file
	      try {
			file.createNewFile();
			// creates a FileWriter Object
		      FileWriter writer = new FileWriter(file); 
		      
		      // Writes the content to the file
		      writer.write("This is an example/n");
		      writer.write("adfdafdfdafdafddasf");
		      writer.flush();
		      writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void storePlainPrint(){
		try{
		    PrintWriter writer = new PrintWriter("/home/thc/Documents/Diego/Hello1.txt", "UTF-8");
		    writer.println("The first line");
		    writer.println("The second line");
		    writer.close();
		} catch (IOException e) {
		   // do something
		}
	}
	
	@SuppressWarnings("resource")
	@Test
	public void readPlainFiles(){
		try{
			final File folder = new File("/home/thc/Documents/Diego/AnalisisDatos/alianzaPais");
			Collection <String> filesNamesCol =listFilesForFolder(folder);
			
			PrintWriter writer = new PrintWriter("/home/thc/Documents/Diego/completoPlano.txt", "UTF-8");
			String line;
			for (String name : filesNamesCol) {
				BufferedReader br = new BufferedReader(new FileReader("/home/thc/Documents/Diego/AnalisisDatos/alianzaPais/" + name));
			    line = br.readLine();
				while(line != null){
					writer.println(line);
					line = br.readLine();
				}
			}
		    writer.close();
		}catch(IOException e){
			System.out.println("error");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public Collection <String> listFilesForFolder(final File folder) {
		@SuppressWarnings("rawtypes")
		Collection nameFilescol = new ArrayList<String>();
	    for (final File fileEntry : folder.listFiles()) {
	        /*if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	            System.out.println(fileEntry.getName());
	        }*/
	        if (fileEntry.isFile()) {
	            System.out.println("File " + fileEntry.getName());
	            nameFilescol.add(fileEntry.getName());
	          } else if (fileEntry.isDirectory()) {
	            System.out.println("Directory " + fileEntry.getName());
	          }
	    }
	    return nameFilescol;
	}

	@Test
	public void read() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("/home/thc/Documents/Diego/AnalisisDatos/alianzaPais/apguayas2017.01.29-07:30:17"));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		}catch(Exception e){
			
		}
		 finally {
		    br.close();
		}
	}



}
