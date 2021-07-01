package football.spring.controller;

import football.spring.dto.request.StadiumRequestDto;
import football.spring.dto.response.StadiumResponseDto;
import football.spring.model.Stadium;
import football.spring.service.StadiumService;
import football.spring.service.mapper.StadiumMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stadiums")
public class StadiumController {
    private final StadiumService stadiumService;
    private final StadiumMapper stadiumMapper;

    public StadiumController(StadiumService stadiumService, StadiumMapper stadiumMapper) {
        this.stadiumService = stadiumService;
        this.stadiumMapper = stadiumMapper;
    }

    @PostMapping
    public StadiumResponseDto add(@RequestBody @Valid StadiumRequestDto requestDto) {
        Stadium stadium = stadiumService.add(stadiumMapper.mapToModel(requestDto));
        return stadiumMapper.mapToDto(stadium);
    }

    @GetMapping
    public List<StadiumResponseDto> getAll() {
        return stadiumService.getAll()
                .stream()
                .map(stadiumMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
