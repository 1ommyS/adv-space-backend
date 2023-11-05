package adv.space.service;

import adv.space.dto.CategoryDto;
import adv.space.dto.CreateCategoryDto;
import adv.space.entity.CategoryEntity;
import adv.space.mapper.CategoryEntityMapper;
import adv.space.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author 1ommy
 * @version 03.11.2023
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;
    private final CategoryEntityMapper mapper;

    public void createCategory(CreateCategoryDto dto) {
        log.info("CategoryService.createCategory | Method start. Input args: " + dto.title());

        var mappedEntity = mapper.toEntity(dto);
        log.info("CategoryService.createCategory | Mapped entity: " + mappedEntity.getTitle());

        var saved = repository.save(mappedEntity);
        log.info("CategoryService.createCategory | Saved entity: " + saved.getId());

    }

    public Page<CategoryEntity> getAllCategories(int page, int pageSize) {
        var pageable = PageRequest.of(page, pageSize);

        return repository.findAll(pageable);

    }

    public CategoryDto getCategoryById(long id) {
        return mapper.toBaseDto(
                repository.findById(id).orElseThrow(() -> {
                    log.error("CategoryService.getCategoryById | категория с такими айди не существует");
                    return new EntityNotFoundException();
                })
        );
    }
}
