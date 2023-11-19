package adv.space.controller;

import adv.space.dto.responses.CompanyDto;
import adv.space.dto.requests.CreateCompanyDto;
import adv.space.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.FileSystemException;
import java.util.List;

/**
 * @author 1ommy
 * @version 04.11.2023
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {
    private final CompanyService service;

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody CreateCompanyDto dto) throws FileSystemException {
        service.createCompany(dto);
        return ResponseEntity.ok("Компания успешно создана");
    }

    @GetMapping
    public List<CompanyDto> getAllCompanies() {
        return service.findAll();
    }
}
