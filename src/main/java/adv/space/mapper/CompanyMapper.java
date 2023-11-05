package adv.space.mapper;

import adv.space.dto.CompanyDto;
import adv.space.dto.CreateCompanyDto;
import adv.space.entity.CompanyEntity;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CompanyMapper {
    CompanyEntity toEntity(CreateCompanyDto createCompanyDTO);

    CompanyDto toDto(CompanyEntity companyEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CompanyEntity partialUpdate(CreateCompanyDto createCompanyDTO, @MappingTarget CompanyEntity companyEntity);
}