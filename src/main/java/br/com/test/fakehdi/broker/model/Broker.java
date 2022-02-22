package br.com.test.fakehdi.broker.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_broker")
public class Broker {
		
	@Id @GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String document;
	
	@Column(nullable = false)
	private String code;
	
	@Column(nullable = false)
	private Float commisionRate;
	
	@Column(nullable = false)
	private Boolean active;
	
	@Column(nullable = false)
	private Date createDate;
	
	@PrePersist
	private void createDateNow() {
		if (Objects.isNull(createDate))
			this.createDate = new Date();
	}

}
