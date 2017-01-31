package ec.com.technoloqie.ejb.sentiment.analysis.business;

import java.util.Collection;

import javax.ejb.Local;

import ec.com.technoloqie.ejb.sentiment.analysis.entities.TweetEntity;

@Local
public interface TweetBeanLocal {
	//public void crearUsuario(String nombre, String direccion, String email);
    public void createTweet(TweetEntity tweet);
    public TweetEntity findTweetId(Integer codigo);
    public TweetEntity findTweetNombre(String nombre);
    public void deleteTweet(TweetEntity tweet);
    public TweetEntity updateTweet(TweetEntity tweet);
    public Collection <TweetEntity> findTweets();
}
