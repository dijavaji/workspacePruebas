package ec.com.technoloqie.ejb.sentiment.analysis.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import ec.com.technoloqie.ejb.sentiment.analysis.commons.entities.TweetEntity;
import ec.com.technoloqie.ejb.sentiment.analysis.commons.exception.SentimentAnalysisException;

public class TestTweetHibernateJPA {
	
	@Test
	public void saveTweet(){
		// Obtener la factoría de sesiones
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tech-sentiment-analysis-ejb");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try{
			TweetEntity tweet = new TweetEntity();
			tweet.setId(1);
			tweet.setDescription("prueba guarda");
			Date dateTweet = new Date( );
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd-hh:mm:ss");
			tweet.setDateTweet(dateTweet);
			// Crear una transacción e intertar objetos
			entityManager.getTransaction().begin();
			entityManager.persist(tweet);
			
		}catch(Exception e){
			entityManager.getTransaction().rollback();
			throw new SentimentAnalysisException("Error al crear un tweet", e);
			
		}finally{
			entityManager.close();
			entityManagerFactory.close();
		}
	}
}
