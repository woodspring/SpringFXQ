package woodspring.springfxq.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class FXQuote {
	static final DecimalFormat f = new DecimalFormat("##.00000000");
	private String symbol;
	private String tenor;
	private String pxStr;
	private FXSpot fxSpot;

	public FXQuote(String symbol, String tenor, String price, FXSpot fxSpot) {
		this.symbol = symbol;
		this.tenor = tenor;
		this.pxStr = price;
		this.fxSpot = fxSpot;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getPrice() {
		return pxStr;
	}

	public void setPrice(String pxStr) {
		this.pxStr = pxStr;
	}

	public String getTenor() {
		return tenor;
	}

	public void setTenor(String tenor) {
		this.tenor = tenor;
	}

	public FXSpot getFxSpot() {
		return fxSpot;
	}

	public void setFxSpot(FXSpot fxSpot) {
		this.fxSpot = fxSpot;
	}
	
	public String toString() {
		StringBuffer strBuf = new StringBuffer();
		strBuf.append("symbol="+symbol+"|");
		strBuf.append("tenor="+tenor+"|");
		strBuf.append("price="+pxStr+"||");
		
		return strBuf.toString();
	}

}
