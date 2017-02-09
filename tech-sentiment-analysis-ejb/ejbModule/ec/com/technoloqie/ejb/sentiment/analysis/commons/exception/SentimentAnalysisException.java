package ec.com.technoloqie.ejb.sentiment.analysis.commons.exception;

/**
 * Clase para el tratamiento de los errores que pueden ocurrir en la ejecucion del codigo
 * @author technoloqie
 *
 */
@SuppressWarnings("serial")
public class SentimentAnalysisException extends RuntimeException{
	
	public SentimentAnalysisException() {
        super();
    }
    
	public SentimentAnalysisException(String msg, Throwable nested) {
        super(msg, nested);
    }
    
	public SentimentAnalysisException(String message) {
        super(message);
    }
    
	public SentimentAnalysisException(Throwable nested) {
        super(nested);
    }

}
