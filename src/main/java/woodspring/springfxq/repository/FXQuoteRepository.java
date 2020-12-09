package woodspring.springfxq.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import  woodspring.springfxq.model.FXQuote;

public interface FXQuoteRepository extends MongoRepository<FXQuote, String>{
	List<FXQuote> findBySymbol(String symbol);
	List<FXQuote> findBySymbolAndTenor(String symbol, String tenor);
	

}
