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
import java.util.StringTokenizer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
	//@Test
	public void saveTweet(){
		// Obtener la factoría de sesiones
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mysql-localhost");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try{
			TweetEntity tweet = new TweetEntity();
			//tweet.setId(2);
			tweet.setIdTweet((long)1234567 );
			tweet.setBioDescription("descripcion tweet prueba sec");
			Date dateTweet = new Date( );
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd-hh:mm:ss");
			tweet.setDateTweet(dateTweet);
			// Crear una transacción e intertar objetos
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
			final File folder = new File("/home/thc/Documents/Diego/AnalisisDatos/alianzaPais");
			Collection <String> filesNamesCol = listFilesForFolder(folder);
			
			//PrintWriter writer = new PrintWriter("/home/thc/Documents/Diego/completoPlano.txt", "UTF-8");
			  
			String line = null;
			SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
			Date date = null;
			for (String name : filesNamesCol) {
				BufferedReader br = new BufferedReader(new FileReader("/home/thc/Documents/Diego/AnalisisDatos/alianzaPais/" + name));
			    line = br.readLine();
				while(line != null){
					//writer.println(line);
					StringTokenizer st = new StringTokenizer(line,"|");
					TweetEntity twitt = new TweetEntity();
					//while (st.hasMoreTokens()) {  
				        //SentimentAnalysisLog.error(st.nextToken());
				        try {
				        	if(st.countTokens() == 17){
				        		if(st.hasMoreTokens()){
					        		date = formatter.parse(st.nextToken());
						            System.out.println(date);
						            //System.out.println(formatter.format(date));
						            twitt.setDateTweet(date);
					        	}	
					            twitt.setScreenName(st.nextToken());
					            twitt.setName(st.nextToken());
					            twitt.setTweet(st.nextToken());
					            twitt.setIdTweet(Long.parseLong(st.nextToken()));
					            twitt.setAplication(st.nextToken());
					            twitt.setFollowers(Integer.parseInt(st.nextToken()));
					            twitt.setFollow(Integer.parseInt(st.nextToken()));
					            twitt.setRetweet(Integer.parseInt(st.nextToken()));
					            twitt.setFavorite(Integer.parseInt(st.nextToken()));
					            char verifica = st.nextToken().charAt(0);
					            twitt.setVerified(verifica);
					            date = formatter.parse(st.nextToken());
					            twitt.setCreatedAt(date);
					            twitt.setLocation(st.nextToken());
					            twitt.setBioDescription(st.nextToken());
					            twitt.setProfileImageUrl(st.nextToken());
					            twitt.setGeoLocation(st.nextToken());
					            twitt.setUserId(Long.parseLong(st.nextToken()));

				        	}
				        	
				        } catch (ParseException e) {
				            e.printStackTrace();
				        }
				    // }  
					line = br.readLine();
				}
			}
		    //writer.close();
		}catch(IOException e){
			System.out.println("error");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public Collection <String> listFilesForFolder(final File folder) {
		@SuppressWarnings("rawtypes")
		Collection nameFilescol = new ArrayList<String>();
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isFile()) {
	            System.out.println("File " + fileEntry.getName());
	            nameFilescol.add(fileEntry.getName());
	          } else if (fileEntry.isDirectory()) {
	            System.out.println("Directory " + fileEntry.getName());
	          }
	    }
	    return nameFilescol;
	}
	
}
