package ec.com.technoloqie.ejb.sentiment.analysis.persistence.businesslogic;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.com.technoloqie.ejb.sentiment.analysis.commons.exception.SentimentAnalysisException;
import ec.com.technoloqie.ejb.sentiment.analysis.commons.log.SentimentAnalysisLog;
import ec.com.technoloqie.ejb.sentiment.analysis.commons.schedule.trigger.SentimentAnalysisTrigger;
import ec.com.technoloqie.ejb.sentiment.analysis.persistence.business.SentimentAnalysisEjbLocal;


@Stateless
@LocalBean
public class SentimentAnalysisEjb implements SentimentAnalysisEjbLocal{
	
	private SentimentAnalysisTrigger analysisTrigger;
	
	@Override
	public void executeDownloadsTweets() throws SentimentAnalysisException{
		try {
			analysisTrigger = new SentimentAnalysisTrigger();
			analysisTrigger.executeTriggerTwitter();
		 	//analysisTrigger.getScheduler();
		} catch (Exception e) {
			SentimentAnalysisLog.error("Error al ejecutar el trigger de twitter ", e);
			throw new SentimentAnalysisException("Error al ejecutar el trigger de twitter",e);
		}
		
	}
	
}
