package adv.space.mapper;

import adv.space.dto.responses.AdvertisementDto;
import adv.space.entity.AdvertisementEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AdvertisementMapper {
    AdvertisementEntity toEntity(AdvertisementDto dto);

    AdvertisementDto toDto(AdvertisementEntity entity);

    List<AdvertisementDto> toListDto(List<AdvertisementEntity> list);

}