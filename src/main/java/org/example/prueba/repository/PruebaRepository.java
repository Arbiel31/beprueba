package org.example.prueba.repository;

import org.example.prueba.model.Prueba;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PruebaRepository extends ReactiveMongoRepository<Prueba,String>{

}
