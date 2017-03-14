package ec.com.technoloqie.ejb.sentiment.analysis.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import ec.com.technoloqie.ejb.sentiment.analysis.commons.entities.TweetEntity;
import ec.com.technoloqie.ejb.sentiment.analysis.commons.exception.SentimentAnalysisException;
import ec.com.technoloqie.ejb.sentiment.analysis.commons.log.SentimentAnalysisLog;
import ec.com.technoloqie.ejb.sentiment.analysis.persistence.dao.GenericDAO;

public class TestTweetHibernateJPA {
		
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static GenericDAO dao;
	//private static GenericSearchDAO sdao;
	@Test
	public void saveTweet(){
		// Obtener la factoría de sesiones
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mysql-localhost");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try{
			TweetEntity tweet = new TweetEntity();
			//tweet.setId(2);
			//tweet.setIdTweet((long)1234567 );
			tweet.setBioDescription("descripcion tweet prueba sec");
			Date dateTweet = new Date( );
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd-hh:mm:ss");
			tweet.setDateTweet(dateTweet);
			// Crear una transaccion e intertar objetos
			entityManager.getTransaction().begin();
			entityManager.persist(tweet);
			entityManager.flush();
			entityManager.getTransaction().commit();
		}catch(Exception e){
			entityManager.getTransaction().rollback();
			throw new SentimentAnalysisException("Error al crear un tweet", e);
			
		}finally{
			//entityManager.close();
			//entityManagerFactory.close();
		}
	}
	
	@Test
	public void listCandidato(){
		// Obtener la factoría de sesiones
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mysql-localhost");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Session session = (Session)entityManager.getDelegate();	//obtener el objeto Session con el que acceder a la API de hibernate.
		Transaction tx = null;
		try{
		 	tx = session.beginTransaction();
			Criteria cr = session.createCriteria(TweetEntity.class);
			Collection <TweetEntity> results = cr.list();
			for (TweetEntity object : results) {
				SentimentAnalysisLog.info("tweet: " + object.getBioDescription());
			}
		}catch(Exception e){
			if (tx!=null) tx.rollback();
			SentimentAnalysisLog.error("Error al buscar un tweet", e);
			throw new SentimentAnalysisException("Error al buscar un tweet", e);
			
		}finally{
			session.close();
		}
	}
	
	@SuppressWarnings("resource")
	@Test
	public void readPlainFiles(){
		try{
			final File folder = new File("D:\\Mis Documentos\\Diego\\AnalisisDatos\\alianzaPais");
			Collection <String> filesNamesCol = listFilesForFolder(folder);
			
			//PrintWriter writer = new PrintWriter("/home/thc/Documents/Diego/completoPlano.txt", "UTF-8");
			  
			String line = null;
			SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", Locale.ENGLISH);
			Date date = null;
			Collection <TweetEntity> tweetscol = new ArrayList<TweetEntity>();
			Boolean guarda = Boolean.TRUE;
			for (String name : filesNamesCol) {
				BufferedReader br = new BufferedReader(new FileReader("D:\\Mis Documentos\\Diego\\AnalisisDatos\\alianzaPais\\" + name));
				tweetscol.clear();
			    line = br.readLine();
				while(line != null){
					//writer.println(line);
					StringTokenizer st = new StringTokenizer(line,"|");
					TweetEntity twitt = new TweetEntity();
					//while (st.hasMoreTokens()) {  
				        //SentimentAnalysisLog.error(st.nextToken());
				        try {
				        	if(st.countTokens() <= 17){
				        		if(st.hasMoreTokens()){
					        		date = formatter.parse(st.nextToken());
						            System.out.println(date);
						            //System.out.println(formatter.format(date));
						            twitt.setDateTweet(date);
					        	}
				        		if(st.hasMoreTokens()){
				        			twitt.setScreenName(st.nextToken());
				        		}
				        		if(st.hasMoreTokens()){
				        			twitt.setName(st.nextToken());
				        		}
				        		if(st.hasMoreTokens()){
				        			twitt.setTweet(st.nextToken());
				        		}
				        		if(st.hasMoreTokens()){
				        			twitt.setIdTweet(Long.parseLong(st.nextToken()));
				        		}
				        		if(st.hasMoreTokens()){
				        			twitt.setAplication(st.nextToken());
				        		}
				        		if(st.hasMoreTokens()){
				        			twitt.setFollowers(Integer.parseInt(st.nextToken()));
				        		}	
				        		if(st.hasMoreTokens()){
				        			twitt.setFollow(Integer.parseInt(st.nextToken()));
				        		}
				        		if(st.hasMoreTokens()){
				        			twitt.setRetweet(Integer.parseInt(st.nextToken()));
				        		}
				        		if(st.hasMoreTokens()){
				        			twitt.setFavorite(Integer.parseInt(st.nextToken()));
				        		}
				        		
				        		if(st.hasMoreTokens()){
				        			if(StringUtils.equals("false",st.nextToken())){
						            	char verifica = '0';
						            	twitt.setVerified(verifica);
						            }else{
						            	char verifica = '1';
						            	twitt.setVerified(verifica);
						            }
				        		}
				        		//User Since
				        		if(st.hasMoreTokens()){
				        			date = formatter.parse(st.nextToken());
				        			twitt.setCreatedAt(date);
				        		}
				        		if(st.hasMoreTokens()){
				        			twitt.setLocation(st.nextToken());
				        		}
				        		if(st.hasMoreTokens()){
				        			twitt.setBioDescription(st.nextToken());	
					        	}
				        		if(st.hasMoreTokens()){
				        			twitt.setProfileImageUrl(st.nextToken());
					        	}
				        		if(st.hasMoreTokens()){
				        			twitt.setGeoLocation(st.nextToken());
					        	}
				        		if(st.hasMoreTokens()){
				        			twitt.setUserId(Long.parseLong(st.nextToken()));
					        	}
				        	}
				        	
				        } catch (ParseException e) {
				        	SentimentAnalysisLog.error("Error al transformar una fecha. ", e);
				        	//throw new SentimentAnalysisException("Error al transformar una fecha.",e);
				        	guarda = Boolean.FALSE;
				        }catch(NumberFormatException e){
				        	SentimentAnalysisLog.error("Error al transformar un numero. ", e);
				        	//throw new SentimentAnalysisException("Error al transformar una fecha.",e);
				        	guarda = Boolean.FALSE;
				        }
				        
				    // }
				    if(guarda){
				    	tweetscol.add(twitt);
				    }    
					line = br.readLine();
					guarda = Boolean.TRUE;
				}
				insertTweets(tweetscol);
			}
		    //writer.close();
		}catch(IOException e){
			SentimentAnalysisLog.error("Error al leer los archivos. ");
			throw new SentimentAnalysisException("Error al leer los archivos. ",e);
		}
		
	}
	
	private void insertTweets(Collection<TweetEntity> tweetscol) {
		
		for (TweetEntity tweetEntity : tweetscol) {
			saveTweet(tweetEntity);
		}
	}

	@SuppressWarnings("unchecked")
	public Collection <String> listFilesForFolder(final File folder) {
		@SuppressWarnings("rawtypes")
		Collection nameFilescol = new ArrayList<String>();
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isFile()) {
	        	SentimentAnalysisLog.info("File " + fileEntry.getName());
	            nameFilescol.add(fileEntry.getName());
	          } else if (fileEntry.isDirectory()) {
	        	  SentimentAnalysisLog.info("Directory " + fileEntry.getName());
	          }
	    }
	    return nameFilescol;
	}
	
	public void saveTweet(TweetEntity twitt){
		// Obtener la factoria de sesiones
		entityManagerFactory = Persistence.createEntityManagerFactory("mysql-localhost");
		entityManager = entityManagerFactory.createEntityManager();
		
		try{
			twitt.setIdTweet((long)1234567 );
			// Crear una transaccion e intertar objetos
			entityManager.getTransaction().begin();
			entityManager.persist(twitt);
			entityManager.flush();
			entityManager.getTransaction().commit();
		}catch(Exception e){
			entityManager.getTransaction().rollback();
			throw new SentimentAnalysisException("Error al crear un tweet", e);
			
		}finally{
			//entityManager.close();
			//entityManagerFactory.close();
		}
	}
	
	@Test
	public void deleteRepeadList(){
		
		 ArrayList<String> lst = new ArrayList<String>();
		    lst.add("ABC");
		    lst.add("ABC");
		    lst.add("ABCD");
		    lst.add("ABCD");
		    lst.add("ABCE");
		    lst.add("ABC");
		    
		    System.out.println("Duplicates List "+lst);

		    Object[] st = lst.toArray();
		      for (Object s : st) {
		        if (lst.indexOf(s) != lst.lastIndexOf(s)) {
		            lst.remove(lst.lastIndexOf(s));
		         }
		      }

		    System.out.println("Distinct List "+lst);
	}
	
}
