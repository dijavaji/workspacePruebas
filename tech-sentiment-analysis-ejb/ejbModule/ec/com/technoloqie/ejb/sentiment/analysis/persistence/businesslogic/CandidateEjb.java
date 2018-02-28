package ec.com.technoloqie.ejb.sentiment.analysis.persistence.businesslogic;

import java.util.Collection;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ec.com.technoloqie.ejb.sentiment.analysis.commons.entities.CandidateEntity;
import ec.com.technoloqie.ejb.sentiment.analysis.commons.exception.SentimentAnalysisException;
import ec.com.technoloqie.ejb.sentiment.analysis.commons.log.SentimentAnalysisLog;
import ec.com.technoloqie.ejb.sentiment.analysis.persistence.business.CandidateEjbLocal;

/**
 * 
 * @author technoloqie
 *
 */
@Stateless
@LocalBean
public class CandidateEjb implements CandidateEjbLocal{
	
	@PersistenceContext(unitName = "tech-sentiment-analysis-ejb")
    private EntityManager em;

	@Override
	public Collection<CandidateEntity> findCandidates()throws SentimentAnalysisException {
		Collection <CandidateEntity> candidates;
		Session session = (Session)em.getDelegate();	//obtener el objeto Session con el que acceder a la API de hibernate.
		Transaction tx = null;
		try{
		 	tx = session.beginTransaction();
			Criteria cr = session.createCriteria(CandidateEntity.class);
			candidates = cr.list();
			tx.commit();
		}catch(Exception e){
			if (tx!=null) tx.rollback();
			SentimentAnalysisLog.error("Error al buscar los candidatos", e);
			throw new SentimentAnalysisException("Error al buscar los candidatos", e);
			
		}finally{
			session.close();
		}
		return candidates;
	}

}
