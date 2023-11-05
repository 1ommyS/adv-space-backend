package adv.space.mapper;

import adv.space.dto.CompanyDto;
import adv.space.dto.CreateCompanyDto;
import adv.space.entity.CompanyEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CompanyMapper {
    CompanyEntity toEntity(CreateCompanyDto createCompanyDTO);

    CompanyDto toDto(CompanyEntity companyEntity);
    List<CompanyDto> toDtoList(List<CompanyEntity> companyEntityList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CompanyEntity partialUpdate(CreateCompanyDto createCompanyDTO, @MappingTarget CompanyEntity companyEntity);
}