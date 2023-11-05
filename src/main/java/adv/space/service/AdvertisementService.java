package adv.space.service;

import adv.space.dto.AdvertisementDto;
import adv.space.entity.AdvertisementEntity;
import adv.space.mapper.AdvertisementMapper;
import adv.space.repository.AdvertisementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 1ommy
 * @version 05.11.2023
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class AdvertisementService {
    private final AdvertisementRepository repository;
    private final AdvertisementMapper mapper;

    public List<AdvertisementDto> findAll() {
        return mapper.toListDto(repository.findAll());
    }

    public void create(AdvertisementDto dto) {
        AdvertisementEntity entity = mapper.toEntity(dto);
        repository.save(entity);
    }
}
