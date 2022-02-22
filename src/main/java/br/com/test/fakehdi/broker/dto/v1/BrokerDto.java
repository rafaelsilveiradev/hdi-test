package br.com.test.fakehdi.broker.dto.v1;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrokerDto {
	
	private Long id;
	private String name;
	private String document;
	private String code;
	private Float commisionRate;
	private Boolean active;
	private Date createDate;

}
