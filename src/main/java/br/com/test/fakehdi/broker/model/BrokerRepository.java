package br.com.test.fakehdi.broker.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrokerRepository extends JpaRepository<Broker, Long> {
	
	public Optional<Broker> findByDocument(String document);
	
	public Optional<Broker> findByCode(String code);

}
