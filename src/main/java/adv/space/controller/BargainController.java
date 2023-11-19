package adv.space.controller;

import adv.space.dto.requests.CreateBargainDto;
import adv.space.dto.responses.BargainInformationDto;
import adv.space.dto.requests.RequestBargainInformationDto;
import adv.space.service.BargainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 1ommy
 * @version 15.11.2023
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/bargain")
public class BargainController {
    private final BargainService service;

    @GetMapping
    public List<BargainInformationDto> getInformationAboutBargainsBetweenUsers(@RequestBody RequestBargainInformationDto dto) {
        return service.getInformationAboutBargainBetweenUsers(dto);
    }

    @PostMapping
    public BargainInformationDto createNewBargain(@RequestBody CreateBargainDto dto) {
        return service.createNewBargain(dto);
    }

    @DeleteMapping
    public void closeBargain(@RequestParam("id") Long id) {
         service.closeBargain(id);
    }

}
