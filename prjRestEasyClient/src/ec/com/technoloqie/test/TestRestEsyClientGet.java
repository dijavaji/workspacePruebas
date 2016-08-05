package ec.com.technoloqie.test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestRestEsyClientGet {
	
	private static final Logger log = LoggerFactory.getLogger(TestRestEsyClientGet.class);
	
	/**
	 * Prueba de cliente rest para consumir un webservice de prueba utilizando  RESTEasy enviando un “GET” request.
	 * http://rest-service.guides.spring.io/greeting 
	 * Se utiliza tutorial mkyoung RESTful Java client with RESTEasy client framework
	 * @author dvasquez
	 */
	@org.junit.Test
	public void consumingRestClient(){
		 try {

				ClientRequest request = new ClientRequest("http://rest-service.guides.spring.io/greeting");
				request.accept("application/json");
				ClientResponse<String> response = request.get(String.class);

				if (response.getStatus() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(response.getEntity().getBytes())));

				String output;
				System.out.println("Output from Server .... \n");
				//log.info("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
					//log.info(output);
				}

			  }catch (IOException e) {

				e.printStackTrace();

			  } catch (Exception e) {

				e.printStackTrace();

			  }

	}

}
