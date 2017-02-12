package ec.com.technoloqie.ejb.sentiment.analysis.commons.log;

import org.apache.log4j.Logger;


public final class SentimentAnalysisLog {
	
	static final Logger logger = Logger.getLogger(SentimentAnalysisLog.class);
	private static final SentimentAnalysisLog INSTANCIA = new SentimentAnalysisLog();
	
	public static void info(String parameter){
		logger.info(parameter);
	}
	
	public void debug(String parameter){
		logger.debug("This is debug : " + parameter);
		}
		
	public void warn(String parameter){
		logger.warn("This is warn : " + parameter);
		}
	
	public static void error(String parameter){
		logger.error(parameter);
	}
	
	public void fatal(String parameter){
		logger.fatal("This is fatal : " + parameter);
	}
	
	public static void getLog(){
		
	}

	public static void error(String string, Exception e) {
		error(string + e.getMessage());
	}
	
}
