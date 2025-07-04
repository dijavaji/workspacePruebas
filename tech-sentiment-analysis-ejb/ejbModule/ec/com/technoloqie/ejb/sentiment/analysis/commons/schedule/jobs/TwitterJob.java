package ec.com.technoloqie.ejb.sentiment.analysis.commons.schedule.jobs;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;

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
import ec.com.technoloqie.ejb.sentiment.analysis.commons.entities.CandidateEntity;
import ec.com.technoloqie.ejb.sentiment.analysis.commons.entities.TweetEntity;
import ec.com.technoloqie.ejb.sentiment.analysis.commons.exception.SentimentAnalysisException;
import ec.com.technoloqie.ejb.sentiment.analysis.commons.log.SentimentAnalysisLog;
import ec.com.technoloqie.ejb.sentiment.analysis.persistence.business.CandidateEjbLocal;
import ec.com.technoloqie.ejb.sentiment.analysis.persistence.business.TweetEjbLocal;

@Stateless
public class TwitterJob implements Job{
	
	
	@EJB(name="tweetBean")
	private TweetEjbLocal tweetBean;
	@EJB(name="candidateBean")
	private CandidateEjbLocal candidateBean;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		SentimentAnalysisLog.info("inicializa la ejecucion del job de tweeter");
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
	        	Collection <CandidateEntity> candidatosCol = obtenerCandidatos();
	        	
	        	for (CandidateEntity candidato : candidatosCol) {
		        	Date dNow = new Date( );
		            SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd-hh:mm:ss");

		            SentimentAnalysisLog.info("Hora actual del job: " + ft.format(dNow));
		            Query query = new Query(candidato.getTwitter());
		            query.setCount(100);
		            //query.setLang("en");
		            //SimpleDateFormat ftU = new SimpleDateFormat ("yyyy-MM-dd");
		            query.setSince("2017-01-20");
		            //query.setUntil(ftU.format(dNow));
		            QueryResult result;
		            result = twitter.search(query);
		            List<Status> tweets = result.getTweets();
		            Collection <TweetEntity> tweetscol = new ArrayList<TweetEntity>();
		            for (Status tweet : tweets) {
		            	TweetEntity twitt = new TweetEntity();	//variable para agregar a la coleccion
		            	twitt.setDateTweet(tweet.getCreatedAt());	//fecha creacion del tweet
		            	twitt.setScreenName(tweet.getUser().getScreenName());	//nombre del usuario
		            	twitt.setName(tweet.getUser().getName());	//nombre del usuario completo
		            	twitt.setTweet(tweet.getText());		//tweet texto
		            	twitt.setIdTweet(tweet.getId());	//tweet id
		            	twitt.setAplication(tweet.getSource());	//aplicacion q envio el tweet
		            	twitt.setFollowers(tweet.getUser().getFollowersCount());	//followers
		            	twitt.setFollow(tweet.getUser().getFriendsCount());	//follows 
		            	twitt.setRetweet(tweet.getRetweetCount());		//retweets
		            	twitt.setFavorite(tweet.getFavoriteCount());	//favoritos
		            	if(tweet.getUser().isVerified()){	//Whether this user has a verified badge.
		            		char verifica = '1';
			            	twitt.setVerified(verifica);
		            	}else{
		            		char verifica = '0';
			            	twitt.setVerified(verifica);
		            	}
		            	twitt.setCreatedAt(tweet.getUser().getCreatedAt());	//creado desde
		            	twitt.setLocation(tweet.getUser().getLocation());		//location
		            	twitt.setBioDescription(tweet.getUser().getDescription());	//bio
		            	twitt.setProfileImageUrl(tweet.getUser().getProfileImageURL());	//imagen de perfil
		            	if(tweet.getGeoLocation() != null){
		            		twitt.setGeoLocation(tweet.getGeoLocation().toString());
		            	}else{
		            		twitt.setGeoLocation("null");
		            	}
		            		
		            	twitt.setUserIdTweet(tweet.getUser().getId());
		                //SentimentAnalysisLog.info(sb.toString());
		            	tweetscol.add(twitt);
		            }
		            insertTweets(tweetscol);
				}
	        } catch (TwitterException te) {
	            SentimentAnalysisLog.error("Error al buscar los tweets: " + te.getMessage());
	        }
	}

	private Collection <CandidateEntity> obtenerCandidatos() throws SentimentAnalysisException{
		Collection <CandidateEntity> candidatosCol = null;
		
		try {
			candidateBean = (CandidateEjbLocal) new InitialContext().lookup("java:global/tech-sentiment-analysis-ear/tech-sentiment-analysis-web/CandidateEjb!ec.com.technoloqie.ejb.sentiment.analysis.persistence.business.CandidateEjbLocal");
			candidatosCol = candidateBean.findCandidates();
		} catch (NamingException e) {
			SentimentAnalysisLog.error("Error al buscar los usuarios: " + e.getMessage());
			throw new SentimentAnalysisException();
		}
		
		//candidatosCol.add("Lenin");
		/*candidatosCol.add("LeninMorenoPAIS");
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
		candidatosCol.add("apguayas");*/
		return candidatosCol;
	}
	
	private void insertTweets(Collection<TweetEntity> tweetscol) {
		try {
			tweetBean = (TweetEjbLocal) new InitialContext().lookup("java:global/tech-sentiment-analysis-ear/tech-sentiment-analysis-web/TweetEjb!ec.com.technoloqie.ejb.sentiment.analysis.persistence.business.TweetEjbLocal");
			//tweetBean = new TweetEjb();
			 //new InitialContext().lookup("java:global/classes/TweetEjb");
			for (TweetEntity tweetEntity : tweetscol) {
				tweetBean.createTweet(tweetEntity);
			}
			
		} catch (Exception e) {
			SentimentAnalysisLog.error("Error al buscar el bean tweetejb: " + e);
		}
	}

	public TweetEjbLocal getTweetBean() {
		return tweetBean;
	}

	public void setTweetBean(TweetEjbLocal tweetBean) {
		this.tweetBean = tweetBean;
	}

	public CandidateEjbLocal getCandidateBean() {
		return candidateBean;
	}

	public void setCandidateBean(CandidateEjbLocal candidateBean) {
		this.candidateBean = candidateBean;
	}

}
