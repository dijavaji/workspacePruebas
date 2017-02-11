package ec.com.technoloqie.ejb.sentiment.analysis.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
			tweet.setId(1);
			tweet.setIdTweet((long)876543 );
			tweet.setDescription("prueba guarda");
			Date dateTweet = new Date( );
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd-hh:mm:ss");
			tweet.setDateTweet(dateTweet);
			// Crear una transacción e intertar objetos
			entityManager.getTransaction().begin();
			entityManager.persist(tweet);
			//entityManager.getTransaction().commit();
			entityManager.flush();
		}catch(Exception e){
			entityManager.getTransaction().rollback();
			throw new SentimentAnalysisException("Error al crear un tweet", e);
			
		}finally{
			//entityManager.close();
			//entityManagerFactory.close();
		}
	}
	
	
}
