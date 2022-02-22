package br.com.test.fakehdi.broker.controller.v1;

import java.util.Objects;

import br.com.test.fakehdi.broker.dto.v1.BrokerDataDto;
import br.com.test.fakehdi.broker.dto.v1.BrokerDto;
import br.com.test.fakehdi.broker.dto.v1.BrokerInfoDto;
import br.com.test.fakehdi.broker.model.Broker;

public class BrokerMapper {

	public static BrokerDto toDto(Broker entity) {
		if (Objects.nonNull(entity)) {
			return BrokerDto.builder()
					.active(entity.getActive())
					.code(entity.getCode())
					.commisionRate(entity.getCommisionRate())
					.createDate(entity.getCreateDate())
					.document(entity.getDocument())
					.id(entity.getId())
					.name(entity.getName())
					.build();
		}
		return null;
	}	
	
	public static BrokerInfoDto toInfoDto(Broker entity) {
		if (Objects.nonNull(entity)) {
			return BrokerInfoDto.builder()
					.code(entity.getCode())
					.createDate(entity.getCreateDate())
					.document(entity.getDocument())
					.name(entity.getName())
					.build();
		}
		return null;
	}
	
	public static BrokerDataDto toDataDto(Broker entity) {
		if (Objects.nonNull(entity)) {
			return BrokerDataDto.builder()
					.active(entity.getActive())
					.code(entity.getCode())
					.commisionRate(entity.getCommisionRate())
					.build();
		}
		return null;
	}
	
	public static Broker toEntity(BrokerDto dto) {
		if (Objects.nonNull(dto)) {
			return Broker.builder()
					.active(dto.getActive())
					.code(dto.getCode())
					.commisionRate(dto.getCommisionRate())
					.createDate(dto.getCreateDate())
					.document(dto.getDocument())
					.id(dto.getId())
					.name(dto.getName())
					.build();
		}
		return null;
	}
	
	public static Broker updateEntity(BrokerDto dto, Broker entity) {
		if (Objects.nonNull(dto) && Objects.nonNull(entity)) {
			if (Objects.nonNull(dto.getActive())) {
				entity.setActive(dto.getActive());
			}
			if (Objects.nonNull(dto.getCode())) {
				entity.setCode(dto.getCode());
			}
			if (Objects.nonNull(dto.getCommisionRate())) {
				entity.setCommisionRate(dto.getCommisionRate());
			}
			if (Objects.nonNull(dto.getName())) {
				entity.setName(dto.getName());
			}
			return entity;
		}
		return null;
	}

}
