package woodspring.springfxq.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import woodspring.springfxq.model.FXSpot;

public interface  FXSpotRepository  extends MongoRepository<FXSpot, String> {

}
