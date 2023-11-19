package adv.space.mapper;

import adv.space.dto.responses.CategoryDto;
import adv.space.dto.requests.CreateCategoryDto;
import adv.space.entity.CategoryEntity;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryEntityMapper {
    CategoryEntity toEntity(CreateCategoryDto createCategoryDTO);

    CreateCategoryDto toDto(CategoryEntity categoryEntity);

    CategoryDto toBaseDto(CategoryEntity categoryEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CategoryEntity partialUpdate(CreateCategoryDto createCategoryDTO, @MappingTarget CategoryEntity categoryEntity);
}