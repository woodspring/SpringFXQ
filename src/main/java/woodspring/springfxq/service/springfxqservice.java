package woodspring.springfxq.service;

import java.util.List;

import woodspring.springfxq.model.FXQuote;

public interface springfxqservice {
	
	List<FXQuote> getFXQuote();
	List<FXQuote> getQuoteSymbol(String symbol);
	List<FXQuote> getQuoteSymbolTenor(String symbol, String tenor);
	List<FXQuote> getFXQuoteSorted();

}
