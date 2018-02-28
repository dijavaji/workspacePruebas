package ec.com.technoloqie.ejb.sentiment.analysis.persistence.business;

import java.util.Collection;

import javax.ejb.Local;

import ec.com.technoloqie.ejb.sentiment.analysis.commons.entities.CandidateEntity;
import ec.com.technoloqie.ejb.sentiment.analysis.commons.exception.SentimentAnalysisException;

@Local
public interface CandidateEjbLocal {
	
	/**
     * Utilizado para buscar todos los tweets
     * @return
     * @throws SentimentAnalysisException
     */
    public Collection <CandidateEntity> findCandidates() throws SentimentAnalysisException;

}
