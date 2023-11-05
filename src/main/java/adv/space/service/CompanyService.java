package adv.space.service;

import adv.space.dto.CompanyDto;
import adv.space.dto.CreateCompanyDto;
import adv.space.entity.CompanyEntity;
import adv.space.mapper.CompanyMapper;
import adv.space.repository.CompanyRepository;
import adv.space.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystemException;
import java.util.List;

/**
 * @author 1ommy
 * @version 04.11.2023
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;
    private final CompanyRepository repository;
    private final CompanyMapper mapper;
    private final S3Service s3Service;

    public void createCompany(CreateCompanyDto dto) throws FileSystemException {
        log.info("CompanyService.createCompany | Начало создания компании: {}", dto.title());

        var company = CompanyEntity.builder()
                .title(dto.title())
                .description(dto.description())
                .build();
        log.debug("CompanyService.createCompany | Сущность компании сформирована: {}", company);

        String iconUrl = s3Service.uploadFile(dto.icon());
        log.debug("CompanyService.createCompany | Иконка загружена, URL: {}", iconUrl);
        company.setIconUrl(iconUrl);

        var user = userRepository.findById(dto.delegateId()).orElseThrow(() -> {
            log.error("CompanyService.createCompany | Представитель с id={} не найден", dto.delegateId());
            return new EntityNotFoundException("Представитель не найден");
        });
        log.info("CompanyService.createCompany | Представитель найден: {}", user);

        company.setDelegate(user);

        companyRepository.save(company);
        log.info("CompanyService.createCompany | Компания сохранена: {}", company);
    }

    public CompanyDto findCompanyByTitle(String title) {
        CompanyEntity company = repository.findByTitle(title).orElseThrow(() -> {
            log.error("CompanyService.findCompanyByTitle | Компания с этим названием не найдена");
            return new EntityNotFoundException("Компания не найдена");
        });
        return mapper.toDto(company);
    }

    public List<CompanyDto> findAll() {
        var companies = repository.findAll();
        return mapper.toDtoList(companies);
    }
}
