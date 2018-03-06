package ec.com.technoloqie.rserve.test;

import java.io.IOException;

import org.junit.Test;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class TestRserve {
	
	@Test
	public void TesComputeMean() {
        RConnection connection = null;

        try {
            /* Create a connection to Rserve instance running
             * on default port 6311
             */
            connection = new RConnection();

            String vector = "c(1,2,3,4)";
            connection.eval("meanVal=mean(" + vector + ")");
            double mean = connection.eval("meanVal").asDouble();
            System.out.println("The mean of given vector is=" + mean);
        } catch (RserveException e) {
            e.printStackTrace();
        } catch (REXPMismatchException e) {
            e.printStackTrace();
        }finally{
            connection.close();
        }
    }
	
	/**
	 * Calling User-defined R functions 
	 */
	@Test
	public void callingUserFunction() {
        RConnection connection = null;

        try {
            /* Create a connection to Rserve instance running on default port
             * 6311
             */
            connection = new RConnection("127.0.0.1",6311);

            /* Note four slashes (\\\\) in the path */
            connection.eval("source('/home/thc/workspacePruebas/prjRserve/resources/myScript.R')");
            int num1 = 10;
            int num2 = 20;
            int sum = connection.eval("myAdd("+num1+","+num2+")").asInteger();
            System.out.println("The sum is=" + sum);
        } catch (RserveException e) {
            e.printStackTrace();
        } catch (REXPMismatchException e) {
            e.printStackTrace();
        }
    }
	
	@Test
	public void testExecuteFunction(){
		RConnection connection = null;
		try {
			connection = new RConnection("192.168.1.2",6311);
			String[] myarr = new String[]{"c(1,2,3,4)"};
			String mean = executeStringFunction(connection,"mean",myarr);
			System.out.println("The mean of given vector is=" + mean);
		} catch (RserveException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Executes an R function (return: String)
	 * 
	 * @param function
	 *        name of the R function
	 * @param parameters
	 *        array of parameters required by the function
	 * 
	 *        TODO: make more generic - not just for Strings ...
	 */
	public static String executeStringFunction(RConnection conn, String function, String[] parameters) {

	    try {
	        // create request
	        String request = "try(" + function + "(";
	        for (String parameter : parameters) {
	            request += parameter + ",";
	        }
	        // remove last ","
	        request = request.substring(0, request.length() - 1);
	        request += "))";
	        // execute function
	        REXP xp = conn.parseAndEval(request);
	        if (xp.inherits("try-error")) {
	            close(conn);
	            throw new IOException("failed to execute function '" + function + "'; \nrequest: " + request + "; \nError: " + xp.asString());
	        }
	        String retval = xp.asString();
	        return retval;
	    }
	    catch (Exception e) {
	        return null;
	    }
	}
	
	/**
	 * Close R connection
	 */
	private static void close(RConnection conn) {
	    try {
	        REXP xp = conn.parseAndEval("gc()");
	        if (xp.inherits("try-error")) {
	            throw new IOException("failed to load R workspace; \nError: " + xp.asString());
	        }
	        conn.close();
	    }
	    catch (Exception e) {
	        // do nothing
	        // should not occur
	        // TODO: ...
	    }
	}

}
