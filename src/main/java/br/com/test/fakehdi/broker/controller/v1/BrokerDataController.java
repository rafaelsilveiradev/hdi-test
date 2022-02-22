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

import br.com.test.fakehdi.broker.dto.v1.BrokerDataDto;
import br.com.test.fakehdi.broker.dto.v1.BrokerDto;
import br.com.test.fakehdi.broker.service.BrokerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/insurance/v1/brokerData")
@RequiredArgsConstructor
public class BrokerDataController {
	
	private final BrokerService service;
	
	@GetMapping
	public List<BrokerDataDto> findAll() {
		return service.findAllBrokerData();
	}
	
	@GetMapping("/{code}")
	public BrokerDataDto findById(@PathVariable("code") String document) {
		return service.findByCode(document);
	}
	
	@PostMapping
	public BrokerDataDto saveOne(@RequestBody BrokerDto dto) {
		return service.saveData(dto);
	}
	
	@PutMapping("/{code}")
	public BrokerDataDto updateOne(@PathVariable("code") String code, @RequestBody BrokerDto dto) {
		return service.updateByCode(code, dto);
	}
	
	@DeleteMapping("/{code}")
	public void updateOne(@PathVariable("code") String code) {
		service.deleteByDocument(code);
	}

}
