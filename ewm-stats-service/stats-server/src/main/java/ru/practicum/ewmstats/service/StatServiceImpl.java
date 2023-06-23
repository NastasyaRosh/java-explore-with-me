package ru.practicum.ewmstats.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.ewmstats.model.Hit;
import ru.practicum.ewmstats.model.ViewStats;
import ru.practicum.ewmstats.repository.StatRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StatServiceImpl implements StatService {
    private final StatRepository statRep;

    @Override
    @Transactional
    public Hit createHit(Hit hit) {
        return statRep.save(hit);
    }

    @Override
    public List<ViewStats> getStats(LocalDateTime start, LocalDateTime end, List<String> uris, Boolean unique) {
        List<ViewStats> stats;
        if (unique) {
            if (uris == null || uris.isEmpty()) {
                stats = statRep.getStatsUnique(start, end);
            } else {
                stats = statRep.getStatsUnique(start, end, uris, uris.size());
            }
        } else {
            if (uris == null || uris.isEmpty()) {
                stats = statRep.getStatsNotUnique(start, end);
            } else {
                stats = statRep.getStatsNotUnique(start, end, uris, uris.size());
            }
        }
        return stats;
    }
}