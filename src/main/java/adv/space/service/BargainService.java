package adv.space.service;

import adv.space.dto.requests.CreateBargainDto;
import adv.space.dto.requests.RequestBargainInformationDto;
import adv.space.dto.responses.BargainInformationDto;
import adv.space.mapper.BargainEntityMapper;
import adv.space.mapper.UserMapper;
import adv.space.repository.BargainRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 1ommy
 * @version 15.11.2023
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class BargainService {
    private final BargainRepository bargainRepository;
    private final BargainEntityMapper mapper;
    private final UserMapper userMapper;

    public List<BargainInformationDto> getInformationAboutBargainBetweenUsers(RequestBargainInformationDto dto) {
        var advertisierEntity = userMapper.toEntity(dto.advertisier());
        var customerEntity = userMapper.toEntity(dto.customer());
        return mapper.toDtoList(bargainRepository.findByAdvertiserAndCustomer(advertisierEntity, customerEntity));
    }

    public BargainInformationDto createNewBargain(CreateBargainDto dto) {
        return mapper.toDto(bargainRepository.save(mapper.toEntity(dto)));
    }

    public void closeBargain(Long id) {
        var bargain = bargainRepository.findById(id).orElseThrow(() -> {
            log.error("BargainService.closeBargain | Сделка с айди " + id + "не найдена");
            return new EntityNotFoundException("Сделка с айди " + id + "не найдена");
        });
        bargain.softDelete();
        bargainRepository.save(bargain);
    }
}
