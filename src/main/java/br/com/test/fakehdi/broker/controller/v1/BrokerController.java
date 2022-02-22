package br.com.test.fakehdi.broker.controller.v1;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.test.fakehdi.broker.dto.v1.BrokerDto;
import br.com.test.fakehdi.broker.dto.v1.BrokerInfoDto;
import br.com.test.fakehdi.broker.service.BrokerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/insurance/v1/broker")
@RequiredArgsConstructor
public class BrokerController {
	
	private final BrokerService service;
	
	@GetMapping
	public List<BrokerInfoDto> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{document}")
	public BrokerInfoDto findById(@PathVariable("document") String document) {
		return service.findByDocument(document);
	}
	
	@PostMapping
	public BrokerInfoDto saveOne(@RequestBody BrokerDto dto) {
		return service.save(dto);
	}
	
	@PutMapping("/{document}")
	public BrokerInfoDto updateOne(@PathVariable("document") String document, @RequestBody BrokerDto dto) {
		return service.updateByDocument(document, dto);
	}
	
	@DeleteMapping("/{document}")
	public void updateOne(@PathVariable("document") String document) {
		service.deleteByDocument(document);
	}

}
