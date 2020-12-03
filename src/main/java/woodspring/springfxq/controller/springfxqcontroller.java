package woodspring.springfxq.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import woodspring.springfxq.service.springfxqservice;
import woodspring.springfxq.model.FXQuote;

@RestController
@RequestMapping("/FXQ")
public class springfxqcontroller {
	private final static Logger logger = LoggerFactory.getLogger(springfxqcontroller.class );
	
	@Autowired
	springfxqservice fxqService;
	
	@CrossOrigin
	@GetMapping("/list")
	public List<FXQuote> requestFXQoute() {
		
		List<FXQuote> retList = fxqService.getFXQuote();
		
		return retList;		
	}
	
	@CrossOrigin
	@GetMapping("/symbol/{symbol}")
	public List<FXQuote> requestFXQoute(@PathVariable String symbol) {
		List<FXQuote> retList = fxqService.getQuoteSymbol(symbol);
		return retList;		
	}
	
	@CrossOrigin
	@GetMapping("/quote")
	@ResponseBody
	public List<FXQuote> requestForFXQuote(@RequestParam Map<String, String> requestParams) { 
		logger.info("request:{}", requestParams);
		String symbol = requestParams.get("symbol");
		String tenor = requestParams.get("tenor");
		logger.info("request:symbol:{}, tenor:{}", symbol, tenor);
		List<FXQuote> retList = fxqService.getQuoteSymbolTenor(symbol, tenor);
		return retList;
		
	}
	
	@CrossOrigin
	@GetMapping("/slist")
	public List<FXQuote> requestFXQouteSorted() {
		logger.info("start slist");
		List<FXQuote> retList = fxqService.getFXQuoteSorted();
		logger.info("response slist, retList:{}", retList);
		return retList;		
	}
	
	@CrossOrigin
	@GetMapping("/symbols/{symbol}")
	public List<FXQuote> requestFXQouteSorted(@PathVariable String symbol) {
		List<FXQuote> retList = fxqService.getQuoteSymbolSorted(symbol);
		return retList;		
	}

	@CrossOrigin
	@GetMapping("/symbols/{symbol}/tenor/{tenor}")
	public List<FXQuote> requestFXQoute(@PathVariable String symbol, @PathVariable String tenor) {
		List<FXQuote> retList = fxqService.getQuoteSymbolTenorSorted(symbol, tenor);
		return retList;		
	}
}
