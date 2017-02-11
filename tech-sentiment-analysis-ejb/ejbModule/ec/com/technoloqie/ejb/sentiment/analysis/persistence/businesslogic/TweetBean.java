package ec.com.technoloqie.ejb.sentiment.analysis.persistence.businesslogic;

import java.util.Collection;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ec.com.technoloqie.ejb.sentiment.analysis.commons.entities.TweetEntity;
import ec.com.technoloqie.ejb.sentiment.analysis.persistence.business.TweetBeanLocal;

/**
 * Session Bean implementation class TweetBean
 */
@Stateless
@LocalBean
public class TweetBean implements TweetBeanLocal {
	
	@PersistenceContext(unitName = "tech-sentiment-analysis-ejb")
    private EntityManager em;

	@Override
	public void createTweet(TweetEntity tweet) {
		em.persist(tweet);
		
	}

	@Override
	public TweetEntity findTweetId(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TweetEntity findTweetNombre(String nombre) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TweetEntity> criteria = cb.createQuery(TweetEntity.class);
        Root<TweetEntity> member = criteria.from(TweetEntity.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).where(cb.equal(member.get(Member_.email), email));
        criteria.select(member).where(cb.equal(member.get("nombre"), nombre));
        return em.createQuery(criteria).getSingleResult();
	}

	@Override
	public void deleteTweet(TweetEntity tweet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TweetEntity updateTweet(TweetEntity tweet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<TweetEntity> findTweets() {
		// TODO Auto-generated method stub
		return null;
	}

}