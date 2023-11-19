package adv.space.mapper;

import adv.space.dto.requests.CreateBargainDto;
import adv.space.dto.responses.BargainInformationDto;
import adv.space.entity.BargainEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BargainEntityMapper {
    BargainEntity toEntity(BargainInformationDto bargainInformationDto);
    BargainEntity toEntity(CreateBargainDto createBargainDto);

    BargainInformationDto toDto(BargainEntity bargainEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    BargainEntity partialUpdate(BargainInformationDto bargainInformationDto, @MappingTarget BargainEntity bargainEntity);

    List<BargainInformationDto> toDtoList(List<BargainEntity> byAdvertiserAndCustomer);
}