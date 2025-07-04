package ec.com.technoloqie.ejb.sentiment.analysis.persistence.business;

import javax.ejb.Local;

import ec.com.technoloqie.ejb.sentiment.analysis.commons.exception.SentimentAnalysisException;

@Local
public interface SentimentAnalysisEjbLocal {
	
	public void executeDownloadsTweets() throws SentimentAnalysisException;
}
