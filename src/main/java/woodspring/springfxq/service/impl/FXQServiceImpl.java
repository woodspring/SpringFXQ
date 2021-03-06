package woodspring.springfxq.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import woodspring.springfxq.model.FXQuote;
import woodspring.springfxq.service.springfxqservice;
import woodspring.springfxq.utils.FxSpotRate;

@Service
public class FXQServiceImpl implements springfxqservice {
	private static final Logger looger = LoggerFactory.getLogger(FXQServiceImpl.class);

	@Autowired
	FxSpotRate spotRate;

	private int randseed = 550;

	@Override
	public List<FXQuote> getFXQuote() {
		int num = (int) (Math.random() * randseed);
		List<FXQuote> retList = spotRate.getFXQuoteList(num);
		return retList;
	}

	@Override
	public List<FXQuote> getQuoteSymbol(String symbol) {
		int num = (int) (Math.random() * randseed);
		List<FXQuote> retList = spotRate.getFXQuoteList(num, symbol);
		return retList;
	}

	@Override
	public List<FXQuote> getQuoteSymbolTenor(String symbol, String tenor) {
		int num = (int) (Math.random() * randseed);
		List<FXQuote> retList = spotRate.getFXQuoteList(num, symbol, tenor);
		return retList;
	}

	@Override
	public List<FXQuote> getFXQuoteSorted() {
		int num = (int) (Math.random() * randseed);
		List<FXQuote> retList = spotRate.getFXQuoteList(num);
		Comparator<FXQuote> orderByKey = Comparator.comparing(FXQuote::getSymbol)
				.thenComparing(FXQuote::getPrice)
				.thenComparing(FXQuote::getTenor)
				;
		retList = retList.stream().sorted(orderByKey).collect(Collectors.toList());
		return retList;
	}

	@Override
	public List<FXQuote> getQuoteSymbolSorted(String symbol) {
		int num = (int) (Math.random() * randseed);
		List<FXQuote> retList = spotRate.getFXQuoteList(num, symbol);
		Comparator<FXQuote> orderByKey = Comparator.comparing(FXQuote::getSymbol)
				.thenComparing(FXQuote::getTenor).thenComparing(FXQuote::getPrice)
				
				;
		retList = retList.stream().sorted(orderByKey).collect(Collectors.toList());
		return retList;
	}

	@Override
	public List<FXQuote> getQuoteSymbolTenorSorted(String symbol, String tenor) {
		int num = (int) (Math.random() * randseed);
		List<FXQuote> retList = spotRate.getFXQuoteList(num, symbol, tenor);
		Comparator<FXQuote> orderByKey = Comparator.comparing(FXQuote::getSymbol)
				.thenComparing(FXQuote::getTenor)
				.thenComparing(FXQuote::getPrice)
				
				;
		retList = retList.stream().sorted(orderByKey).collect(Collectors.toList());
		return retList;
	}

}
