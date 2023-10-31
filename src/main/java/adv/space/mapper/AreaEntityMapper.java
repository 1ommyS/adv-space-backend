package adv.space.mapper;

import adv.space.dto.AreaEntityDto;
import adv.space.entity.AreaEntity;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AreaEntityMapper {
    AreaEntity toEntity(AreaEntityDto areaEntityDto);

    AreaEntityDto toDto(AreaEntity areaEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AreaEntity partialUpdate(AreaEntityDto areaEntityDto, @MappingTarget AreaEntity areaEntity);
}