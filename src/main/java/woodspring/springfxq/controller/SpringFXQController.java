package woodspring.springfxq.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD:src/main/java/woodspring/springfxq/controller/SpringFXQController.java
import org.springframework.beans.factory.annotation.Qualifier;
=======
import org.springframework.web.bind.annotation.CrossOrigin;
>>>>>>> a8ed6a8a11b980b621fbeed9ad4fc9d83d1628e0:src/main/java/woodspring/springfxq/controller/springfxqcontroller.java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import woodspring.springfxq.service.SpringFXQService;
import woodspring.springfxq.model.FXQuote;

@RestController
@RequestMapping("/FXQ")
public class SpringFXQController {
	private final static Logger logger = LoggerFactory.getLogger(SpringFXQController.class );
	
	@Autowired
	@Qualifier("fxqService")
	SpringFXQService fxqService;
	
	@Autowired
	@Qualifier("fxqServiceMongo")
	SpringFXQService fxqServiceMongo;
	
	@CrossOrigin
	@GetMapping("/list")
	public List<FXQuote> requestFXQoute() {
<<<<<<< HEAD:src/main/java/woodspring/springfxq/controller/SpringFXQController.java
		List<FXQuote> retList = fxqServiceMongo.getFXQuote();
=======
		
		List<FXQuote> retList = fxqService.getFXQuote();
		
>>>>>>> a8ed6a8a11b980b621fbeed9ad4fc9d83d1628e0:src/main/java/woodspring/springfxq/controller/springfxqcontroller.java
		return retList;		
	}
	
	@CrossOrigin
	@GetMapping("/symbol/{symbol}")
	public List<FXQuote> requestFXQoute(@PathVariable String symbol) {
		List<FXQuote> retList = fxqServiceMongo.getQuoteSymbol(symbol);
		return retList;		
	}
	
	@GetMapping("/symbol/{symbol}/tenor/{tenor}")
	public List<FXQuote> requestForFXQoute(@PathVariable String symbol, @PathVariable String tenor) {
		List<FXQuote> retList = fxqServiceMongo.getQuoteSymbolTenorSorted(symbol, tenor);
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
		List<FXQuote> retList = fxqServiceMongo.getQuoteSymbolTenor(symbol, tenor);
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
	
<<<<<<< HEAD:src/main/java/woodspring/springfxq/controller/SpringFXQController.java
	@GetMapping("/ssymbol/{symbol}")
=======
	@CrossOrigin
	@GetMapping("/symbols/{symbol}")
>>>>>>> a8ed6a8a11b980b621fbeed9ad4fc9d83d1628e0:src/main/java/woodspring/springfxq/controller/springfxqcontroller.java
	public List<FXQuote> requestFXQouteSorted(@PathVariable String symbol) {
		List<FXQuote> retList = fxqService.getQuoteSymbolSorted(symbol);
		return retList;		
	}

<<<<<<< HEAD:src/main/java/woodspring/springfxq/controller/SpringFXQController.java
	@GetMapping("/ssymbol/{symbol}/tenor/{tenor}")
=======
	@CrossOrigin
	@GetMapping("/symbols/{symbol}/tenor/{tenor}")
>>>>>>> a8ed6a8a11b980b621fbeed9ad4fc9d83d1628e0:src/main/java/woodspring/springfxq/controller/springfxqcontroller.java
	public List<FXQuote> requestFXQoute(@PathVariable String symbol, @PathVariable String tenor) {
		List<FXQuote> retList = fxqService.getQuoteSymbolTenorSorted(symbol, tenor);
		return retList;		
	}
}
