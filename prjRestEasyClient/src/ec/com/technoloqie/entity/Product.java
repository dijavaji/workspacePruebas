package ec.com.technoloqie.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {

	String name;
	Integer qty;
 
	public Product(){
		
	}
	public Product(String name, Integer qty){
		this.name = name;
		this.qty = qty;
	}
	
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public int getQty() {
		return qty;
	}
 
	public void setQty(Integer qty) {
		this.qty = qty;
	}
}
