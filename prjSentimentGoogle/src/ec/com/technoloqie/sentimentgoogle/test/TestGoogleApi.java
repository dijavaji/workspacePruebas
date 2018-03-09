package ec.com.technoloqie.sentimentgoogle.test;

import java.io.IOException;

import org.junit.Test;

import com.google.api.Page;
import com.google.cloud.language.v1beta2.AnalyzeSentimentResponse;
import com.google.cloud.language.v1beta2.Document;
import com.google.cloud.language.v1beta2.Document.Type;
import com.google.cloud.language.v1beta2.LanguageServiceClient;
import com.google.cloud.language.v1beta2.Sentiment;

public class TestGoogleApi {
	@Test
	public void test(){
		try {
			analyzingSentimentString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Sentiment analyzingSentimentString() throws IOException{
		String text = "Hello world positive";
		Sentiment sentiment = null;
		// Instantiate the Language client com.google.cloud.language.v1.LanguageServiceClient
		try (LanguageServiceClient language = LanguageServiceClient.create()) {
		  Document doc = Document.newBuilder()
		      .setContent(text)
		      .setType(Type.PLAIN_TEXT)
		      .build();
		  AnalyzeSentimentResponse response = language.analyzeSentiment(doc);
		  sentiment = response.getDocumentSentiment();
		  if (sentiment == null) {
		    System.out.println("No sentiment found");
		  } else {
		    System.out.printf("Sentiment magnitude: %.3f\n", sentiment.getMagnitude());
		    System.out.printf("Sentiment score: %.3f\n", sentiment.getScore());
		  }
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sentiment;
	}
	
	public void testCredentials(){
		// If you don't specify credentials when constructing the client, the
		// client library will look for credentials in the environment.

		/*Storage storage = StorageOptions.getDefaultInstance().getService();

		Page<Bucket> buckets = storage.list();
		for (Bucket bucket : buckets.iterateAll()) {
		  // do something with the info
		}*/
	}

}
