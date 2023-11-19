package adv.space.controller;

import adv.space.dto.responses.AdvertisementDto;
import adv.space.dto.responses.UserDto;
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

    @GetMapping("/{id}")
    public AdvertisementDto findById(@RequestParam Long id){
        return service.findById(id);
    }

    @GetMapping("/user")
    public List<AdvertisementDto> findByOwner(@RequestBody UserDto dto){
        return service.findByOwner(dto);
    }
}
