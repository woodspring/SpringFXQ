package woodspring.springfxq.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import woodspring.springfxq.model.FXQuote;
import woodspring.springfxq.repository.FXQuoteRepository;
import woodspring.springfxq.service.SpringFXQService;
import woodspring.springfxq.utils.FxSpotRate;



@Service("fxqServiceMongo")
public class FXQServiceMongoImpl implements SpringFXQService {
	private static final Logger looger = LoggerFactory.getLogger(FXQServiceMongoImpl.class);

	@Autowired
	FxSpotRate spotRate;
	
	@Autowired
	FXQuoteRepository fxQuoteRepo;
	
	@Override
	public List<FXQuote> getFXQuote() {
		List<FXQuote> retList = fxQuoteRepo.findAll().stream().sorted(comparatorKey()).collect(Collectors.toList());
		return retList;
	}

	@Override
	public List<FXQuote> getQuoteSymbol(String symbol) {
		List<FXQuote> retList = fxQuoteRepo.findBySymbol(symbol)
				.stream().sorted(comparatorKey())
				.collect(Collectors.toList());
		return retList;
	}

	@Override
	public List<FXQuote> getQuoteSymbolTenor(String symbol, String tenor) {
		List<FXQuote> retList = fxQuoteRepo.findBySymbolAndTenor(symbol,  tenor)
				.stream().sorted( comparatorKey())
				.collect(Collectors.toList());
		return retList;
	}

	@Override
	public List<FXQuote> getFXQuoteSorted() {
		return getFXQuote();
	}

	@Override
	public List<FXQuote> getQuoteSymbolSorted(String symbol) {
		return getQuoteSymbol(symbol);
	}

	@Override
	public List<FXQuote> getQuoteSymbolTenorSorted(String symbol, String tenor) {
		return getQuoteSymbolTenor(symbol, tenor);
	}
	
	private Comparator<FXQuote> comparatorKey() {
		Comparator<FXQuote> orderByKey = Comparator.comparing(FXQuote::getSymbol)
				.thenComparing(FXQuote::getTenor)
				.thenComparing(FXQuote::getPrice);
		return orderByKey;		
	}


}
