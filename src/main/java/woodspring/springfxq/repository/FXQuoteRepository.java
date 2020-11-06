package woodspring.springfxq.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import  woodspring.springfxq.model.FXQuote;

public interface FXQuoteRepository extends MongoRepository<FXQuote, String>{
	

}
