package tradeBlotter.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TRADEDATA")
public class TradeInfo implements Serializable{
	
	private String tradeID;
	private String tradeType;
	private String submissionDate;
	private String status;
	private String isin;
	private String product;
	private String quantity;
	private String price;
	private String quoteVolume;
	private String terms;
	private String traderID;
	private String firmName;
	
	@Id
	public String getTradeID() {
		return tradeID;
	}
	public void setTradeID(String tradeID) {
		this.tradeID = tradeID;
	}
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	public String getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(String submissionDate) {
		this.submissionDate = submissionDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIsin() {
		return isin;
	}
	public void setIsin(String isin) {
		this.isin = isin;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuoteVolume() {
		return quoteVolume;
	}
	public void setQuoteVolume(String quoteVolume) {
		this.quoteVolume = quoteVolume;
	}
	public String getTerms() {
		return terms;
	}
	public void setTerms(String terms) {
		this.terms = terms;
	}
	public String getTraderID() {
		return traderID;
	}
	public void setTraderID(String traderID) {
		this.traderID = traderID;
	}
	public String getFirmName() {
		return firmName;
	}
	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}

	
	
	
	
	
	
	
	
	
	
	
}
