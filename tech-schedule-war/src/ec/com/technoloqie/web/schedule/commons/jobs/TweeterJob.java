package ec.com.technoloqie.web.schedule.commons.jobs;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TweeterJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("inicializa");
		searchForPublicTwettsStored();
		
	}
	
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
	        	Collection <String> candidatosCol = obtenerCandidatos();
	        	
	        	for (String candidato : candidatosCol) {
	        		//String candidato= "MashiRafael";
		        	Date dNow = new Date( );
		            SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd-hh:mm:ss");

		            System.out.println("Current Date: " + ft.format(dNow));
		            Query query = new Query("@"+candidato);
		            query.setCount(100);
		            //query.setLang("en");
		            SimpleDateFormat ftU = new SimpleDateFormat ("yyyy-MM-dd");
		            query.setSince("2017-01-20");
		            //query.setUntil(ftU.format(dNow));
		            QueryResult result;
		            result = twitter.search(query);
		            List<Status> tweets = result.getTweets();
		            StringBuilder sb = new StringBuilder();
		            PrintWriter writer = new PrintWriter("/home/thc/Documents/Diego/AnalisisDatos/alianzaPais/"+candidato+ft.format(dNow)+".txt", "UTF-8");
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
				}
	            //System.exit(0);
	        } catch (TwitterException te) {
	            te.printStackTrace();
	            System.out.println("Failed to search tweets: " + te.getMessage());
	            System.exit(-1);
	        }catch (IOException e){
	        	System.out.println("Error al escribir archivo: " + e.getMessage());
	        }
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Collection <String> obtenerCandidatos() {
		Collection <String> candidatosCol = new ArrayList();
		candidatosCol.add("Lenin");
		candidatosCol.add("LeninMorenoPAIS");
		candidatosCol.add("35PAIS");
		candidatosCol.add("35apd2gye");
		candidatosCol.add("GabrielaEsPais");
		candidatosCol.add("JorgeGlas"); 
		candidatosCol.add("WendyVeraEc"); 
		candidatosCol.add("lolysalazar35"); 
		candidatosCol.add("35PAIS");
		candidatosCol.add("ppsesa");
		candidatosCol.add("viviana_bonilla"); 
		candidatosCol.add("albertoariasra");
		candidatosCol.add("Distrito4AP");
		candidatosCol.add("MashiRafael");
		candidatosCol.add("j_serranv");
		candidatosCol.add("PichinchaPAIS");
		candidatosCol.add("35ap_d_c_quito");
		candidatosCol.add("pameaguirre1");
		candidatosCol.add("PichinchaPAIS");
		candidatosCol.add("cabezasconcejal");
		candidatosCol.add("blascoluna");
		candidatosCol.add("VamosLenin");
		candidatosCol.add("BloqueAP35"); 
		candidatosCol.add("dorissoliz");
		candidatosCol.add("marcelaguinaga"); 
		candidatosCol.add("apguayas");
		return candidatosCol;
	}

}
