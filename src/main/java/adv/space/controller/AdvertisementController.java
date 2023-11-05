package adv.space.controller;

import adv.space.dto.AdvertisementDto;
import adv.space.entity.AdvertisementEntity;
import adv.space.service.AdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 1ommy
 * @version 05.11.2023
 */

@RestController
@RequestMapping("api/v1/advertisement")
@RequiredArgsConstructor
public class AdvertisementController {
    private final AdvertisementService service;

    @GetMapping
    public List<AdvertisementDto> findAll() {
        return service.findAll();
    }

    @PostMapping
    public void create(@RequestBody AdvertisementDto dto) {
        service.create(dto);
    }
}
