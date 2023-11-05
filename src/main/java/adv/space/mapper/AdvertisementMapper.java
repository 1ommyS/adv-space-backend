package adv.space.mapper;

import adv.space.dto.AdvertisementDto;
import adv.space.dto.AreaEntityDto;
import adv.space.entity.AdvertisementEntity;
import adv.space.entity.AreaEntity;
import org.apache.catalina.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AdvertisementMapper {
    AdvertisementEntity toEntity(AdvertisementDto dto);

    AdvertisementDto toDto(AdvertisementEntity entity);

    List<AdvertisementDto> toListDto(List<AdvertisementEntity> list);

}