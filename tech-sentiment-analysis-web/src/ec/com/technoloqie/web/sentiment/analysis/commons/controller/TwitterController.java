package ec.com.technoloqie.web.sentiment.analysis.commons.controller;

import java.io.Serializable;

import javax.ejb.EJB;

import ec.com.technoloqie.ejb.sentiment.analysis.persistence.business.TweetEjbLocal;

@SuppressWarnings("serial")
public class TwitterController implements Serializable{
	
	@EJB
	private TweetEjbLocal tweetBean;

}
