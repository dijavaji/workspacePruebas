package ec.com.technoloqie.ejb.sentiment.analysis.commons.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SASTDATOTWITTER")
public class TweetEntity {
	
	@Id
    @GeneratedValue
	private Integer id;
	
	@Column(name="FECHA",nullable=false)
	private Date dateTweet;
	
	@Column(name="NOMBREUSUARIO")
	private String screenName;
	
	@Column(name="NOMBRECOMPLETO")
	private String name;
	
	@Column(name="TEXTOTWEET")
	private String tweet;
	
	@Column(name="IDDATOTWITTER")
	private Long idTweet;
	
	@Column(name="APLICACION")
	private String aplication;
	
	@Column(name="FOLLOWERS")
	private Integer followers;
	
	@Column(name="FOLLOWRETWEET")
	private Integer followretweet;
	
	@Column(name="FAVORITO")
	private Integer favorite;
	
	@Column(name="VERIFICAUSUARIO")
	private String verified;
	
	@Column(name="USUARIODESDE")
	private Date createdAt;
	
	@Column(name="LOCACION")
	private String location;
	
	@Column(name="BIODESCRIPCION")
	private String description;
	
	@Column(name="IMAGENPERFILURL")
	private String prfileImageUrl;
	
	@Column(name="GEOLOCACION")
	private String geoLocation;
	
	@Column(name="IDUSUARIO")
	private Long userId;
	
	//getters and setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDateTweet() {
		return dateTweet;
	}
	public void setDateTweet(Date dateTweet) {
		this.dateTweet = dateTweet;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTweet() {
		return tweet;
	}
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}
	public Long getIdTweet() {
		return idTweet;
	}
	public void setIdTweet(Long idTweet) {
		this.idTweet = idTweet;
	}
	public String getAplication() {
		return aplication;
	}
	public void setAplication(String aplication) {
		this.aplication = aplication;
	}
	public Integer getFollowers() {
		return followers;
	}
	public void setFollowers(Integer followers) {
		this.followers = followers;
	}
	public Integer getFollowretweet() {
		return followretweet;
	}
	public void setFollowretweet(Integer followretweet) {
		this.followretweet = followretweet;
	}
	public Integer getFavorite() {
		return favorite;
	}
	public void setFavorite(Integer favorite) {
		this.favorite = favorite;
	}
	public String getVerified() {
		return verified;
	}
	public void setVerified(String verified) {
		this.verified = verified;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrfileImageUrl() {
		return prfileImageUrl;
	}
	public void setPrfileImageUrl(String prfileImageUrl) {
		this.prfileImageUrl = prfileImageUrl;
	}
	public String getGeoLocation() {
		return geoLocation;
	}
	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
