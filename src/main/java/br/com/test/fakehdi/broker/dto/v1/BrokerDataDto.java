package br.com.test.fakehdi.broker.dto.v1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrokerDataDto {
	
	private String code;
	private Float commisionRate;
	private Boolean active;

}
