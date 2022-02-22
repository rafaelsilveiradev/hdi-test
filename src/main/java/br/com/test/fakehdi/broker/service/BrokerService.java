package br.com.test.fakehdi.broker.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.test.fakehdi.broker.controller.v1.BrokerMapper;
import br.com.test.fakehdi.broker.dto.v1.BrokerDataDto;
import br.com.test.fakehdi.broker.dto.v1.BrokerDto;
import br.com.test.fakehdi.broker.dto.v1.BrokerInfoDto;
import br.com.test.fakehdi.broker.model.Broker;
import br.com.test.fakehdi.broker.model.BrokerRepository;
import br.com.test.fakehdi.exception.NotFoundException;

@Service
public class BrokerService {
	
	private final BrokerRepository brokerRepository;
	
	public BrokerService(BrokerRepository brokerRepository) {
		this.brokerRepository = brokerRepository;
	}

	public List<BrokerInfoDto> findAll() { 
		return brokerRepository.findAll().stream()
				.map(BrokerMapper::toInfoDto).collect(Collectors.toList());
	}
	
	public List<BrokerDataDto> findAllBrokerData() { 
		return brokerRepository.findAll().stream()
				.map(BrokerMapper::toDataDto).collect(Collectors.toList());
	}
	
	public BrokerInfoDto findByDocument(String document) { 
		try { 
			return BrokerMapper.toInfoDto(
				brokerRepository.findByDocument(document).orElseThrow());
		} catch(NoSuchElementException nsee) {
			throw new NotFoundException("Corretor não encontrado");
		}
	}
	
	public BrokerDataDto findByCode(String code) { 
		try { 
			return BrokerMapper.toDataDto(
				brokerRepository.findByCode(code).orElseThrow());
		} catch(NoSuchElementException nsee) {
			throw new NotFoundException("Corretor não encontrado");
		}
	}
	
	public BrokerInfoDto updateByDocument(String document, BrokerDto dto) { 
		try { 
			Broker broker = brokerRepository.findByDocument(document).orElseThrow();
			return BrokerMapper.toInfoDto(brokerRepository.save(BrokerMapper.updateEntity(dto, broker)));
		} catch(NoSuchElementException nsee) {
			throw new NotFoundException("Corretor não encontrado");
		}
	}
	
	public BrokerDataDto updateByCode(String code, BrokerDto dto) { 
		try { 
			Broker broker = brokerRepository.findByCode(code).orElseThrow();
			return BrokerMapper.toDataDto(brokerRepository.save(BrokerMapper.updateEntity(dto, broker)));
		} catch(NoSuchElementException nsee) {
			throw new NotFoundException("Corretor não encontrado");
		}
	}
	
	public void deleteByDocument(String document) { 
		try { 
			Broker broker = brokerRepository.findByDocument(document).orElseThrow();
			brokerRepository.deleteById(broker.getId());
		} catch(NoSuchElementException nsee) {
			throw new NotFoundException("Corretor não encontrado");
		}
	}
	
	public void deleteByCode(String code) { 
		try { 
			Broker broker = brokerRepository.findByCode(code).orElseThrow();
			brokerRepository.deleteById(broker.getId());
		} catch(NoSuchElementException nsee) {
			throw new NotFoundException("Corretor não encontrado");
		}
	}
	
	public BrokerInfoDto save(BrokerDto dto) {
		return BrokerMapper.toInfoDto(brokerRepository.save(BrokerMapper.toEntity(dto)));
	}
	
	public BrokerDataDto saveData(BrokerDto dto) {
		return BrokerMapper.toDataDto(brokerRepository.save(BrokerMapper.toEntity(dto)));
	}
	
}
