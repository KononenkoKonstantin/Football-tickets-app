package football.spring.controller;

import football.spring.dto.request.GameSessionRequestDto;
import football.spring.dto.response.GameSessionResponseDto;
import football.spring.model.GameSession;
import football.spring.service.GameSessionService;
import football.spring.service.mapper.GameSessionMapper;
import football.spring.util.DateTimePatternUtil;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game-sessions")
public class GameSessionController {
    public static final String DATE_PATTERN = DateTimePatternUtil.DATE_PATTERN;
    private final GameSessionService gameSessionService;
    private final GameSessionMapper gameSessionMapper;

    public GameSessionController(GameSessionService gameSessionService,
                                 GameSessionMapper gameSessionMapper) {
        this.gameSessionService = gameSessionService;
        this.gameSessionMapper = gameSessionMapper;
    }

    @PostMapping
    public GameSessionResponseDto add(@RequestBody @Valid GameSessionRequestDto requestDto) {
        GameSession gameSession = gameSessionMapper.mapToModel(requestDto);
        gameSessionService.add(gameSession);
        return gameSessionMapper.mapToDto(gameSession);
    }

    @GetMapping("/available")
    public List<GameSessionResponseDto> getAll(@RequestParam Long gameId,
                                                @RequestParam
                                                @DateTimeFormat(pattern = DATE_PATTERN)
                                                        LocalDate date) {
        return gameSessionService.findAvailableSessions(gameId, date)
                .stream()
                .map(gameSessionMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public GameSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody @Valid GameSessionRequestDto requestDto) {
        GameSession gameSession = gameSessionMapper.mapToModel(requestDto);
        gameSession.setId(id);
        gameSessionService.update(gameSession);
        return gameSessionMapper.mapToDto(gameSession);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        gameSessionService.delete(id);
    }
}
