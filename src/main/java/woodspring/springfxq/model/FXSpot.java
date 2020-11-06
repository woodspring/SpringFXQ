package woodspring.springfxq.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//@XmlRootElement(name = "FXSpot")
@XmlAccessorType(XmlAccessType.FIELD)
@Document
public class FXSpot {
	static final DecimalFormat f = new DecimalFormat("##.00000000");
	@Id
	private String id;
	@NotNull
	@NotBlank
	private String symbol;
	@NotNull
	@NotBlank
	private String tenor;
	private String pxStr;
	private long quoteTime;
	private BigDecimal price;
	
	//private int notation;
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
		this.pxStr = f.format(price);
	}
	public String getPriceString() {
		return pxStr;
	}
	@Override
	public String toString() {
		return "FXSpot [symbol=" + symbol + ", price=" + price + ", tenor=" + tenor + ", quoteTime=" + quoteTime + "]";
	}
	public String getTenor() {
		return tenor;
	}
	public void setTenor(String tenor) {
		this.tenor = tenor;
	}
	public long getQuoteTime() {
		return quoteTime;
	}
	public void setQuoteTime(long quoteTime) {
		this.quoteTime = quoteTime;
	}

}