package adv.space.controller;

import adv.space.dto.CategoryDto;
import adv.space.dto.CreateCategoryDto;
import adv.space.entity.CategoryEntity;
import adv.space.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author 1ommy
 * @version 03.11.2023
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/category")
public class CategoryController {
    private final CategoryService service;

    @GetMapping
    public Page<CategoryEntity> getAllCategories(
            @RequestParam("start") int page,
            @RequestParam("pageSize") int pageSize
    ) {
        return service.getAllCategories(page, pageSize);
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@RequestParam long id) {
        return service.getCategoryById(id);
    }

    @PostMapping
    public ResponseEntity<String> createCategory(@RequestBody CreateCategoryDto dto) {
        service.createCategory(dto);

        return ResponseEntity.ok("Категория успешно создана");
    }
}
