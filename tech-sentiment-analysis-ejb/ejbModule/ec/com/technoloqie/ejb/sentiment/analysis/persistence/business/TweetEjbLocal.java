package ec.com.technoloqie.ejb.sentiment.analysis.persistence.business;

import java.util.Collection;

import javax.ejb.Local;

import ec.com.technoloqie.ejb.sentiment.analysis.commons.entities.TweetEntity;
import ec.com.technoloqie.ejb.sentiment.analysis.commons.exception.SentimentAnalysisException;

@Local
public interface TweetEjbLocal {
	
	/**
	 * Utilizado para guardar en la tabla datos tweeter
	 * @param tweet
	 */
    public void createTweet(TweetEntity tweet) throws SentimentAnalysisException;
    
    /**
     * Utilizado para buscar un tweet por codigo
     * @param codigo
     * @return
     * @throws SentimentAnalysisException
     */
    public TweetEntity findTweetId(Integer codigo) throws SentimentAnalysisException;
    
    /**
     * Utilizado para buscar un tweet por su descripcion
     * @param descripcion
     * @return
     * @throws SentimentAnalysisException
     */
    public TweetEntity findTweetNombre(String descripcion) throws SentimentAnalysisException;
    
    /**
     * Utilizado para eliminar un tweet
     * @param tweet
     * @throws SentimentAnalysisException
     */
    public void deleteTweet(TweetEntity tweet) throws SentimentAnalysisException;
    
    /**
     * Utilizado para actualizar un tweet.
     * @param tweet
     * @return
     * @throws SentimentAnalysisException
     */
    public TweetEntity updateTweet(TweetEntity tweet) throws SentimentAnalysisException;
    
    /**
     * Utilizado para buscar todos los tweets
     * @return
     * @throws SentimentAnalysisException
     */
    public Collection <TweetEntity> findTweets() throws SentimentAnalysisException;
}
