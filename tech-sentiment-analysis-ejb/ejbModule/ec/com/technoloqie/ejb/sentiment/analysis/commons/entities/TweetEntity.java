package ec.com.technoloqie.ejb.sentiment.analysis.commons.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SASTDATOTWITTER")
public class TweetEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name="IDDATOTWITTER",nullable=false, unique=true)
	private Integer id;
	
	@Column(name="FECHA",nullable=false)
	private Date dateTweet;
	
	@Column(name="NOMBREUSUARIO")
	private String screenName;
	
	@Column(name="NOMBRECOMPLETO")
	private String name;
	
	@Column(name="TEXTOTWEET")
	private String tweet;
	
	@Column(name="TWEETID")
	private Long idTweet;
	
	@Column(name="APLICACION")
	private String aplication;
	
	@Column(name="FOLLOWERS")
	private Integer followers;
	
	@Column(name="FOLLOW")
	private Integer follow;
	
	@Column(name="RETWEET")
	private Integer retweet;
	
	@Column(name="FAVORITO")
	private Integer favorite;
	
	@Column(name="VERIFICAUSUARIO")
	private char verified;
	
	@Column(name="USUARIODESDE")
	private Date createdAt;
	
	@Column(name="LOCACION")
	private String location;
	
	@Column(name="BIODESCRIPCION")
	private String bioDescription;
	
	@Column(name="IMAGENPERFILURL")
	private String profileImageUrl;
	
	@Column(name="GEOLOCACION")
	private String geoLocation;
	
	@Column(name="IDUSUARIO")
	private Long userId;
	
	//getters and setters
	public Integer getId() {
		return this.id;
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
	public Integer getFavorite() {
		return favorite;
	}
	public void setFavorite(Integer favorite) {
		this.favorite = favorite;
	}
	public char getVerified() {
		return verified;
	}
	public void setVerified(char verified) {
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
	public String getBioDescription() {
		return bioDescription;
	}
	public void setBioDescription(String bioDescription) {
		this.bioDescription = bioDescription;
	}
	public String getProfileImageUrl() {
		return profileImageUrl;
	}
	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
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
	public Integer getFollow() {
		return follow;
	}
	public void setFollow(Integer follow) {
		this.follow = follow;
	}
	public Integer getRetweet() {
		return retweet;
	}
	public void setRetweet(Integer retweet) {
		this.retweet = retweet;
	}
}
