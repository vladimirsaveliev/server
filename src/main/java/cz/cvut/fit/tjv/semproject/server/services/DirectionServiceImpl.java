package cz.cvut.fit.tjv.semproject.server.services;

import cz.cvut.fit.tjv.semproject.server.entities.DirectionEntity;
import cz.cvut.fit.tjv.semproject.server.entities.DirectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class DirectionServiceImpl implements DirectionService {
    private final DirectionRepository directionRepository;

    @Autowired
    public DirectionServiceImpl(DirectionRepository directionRepository) {
        this.directionRepository = directionRepository;
    }

    @Override
    public DirectionEntity create(DirectionEntity data) {
        return directionRepository.save(data);
    }

    @Override
    public Optional<DirectionEntity> readById(String key) {
        return Optional.empty();
    }

    @Override
    public Page<DirectionEntity> readAll(Pageable pageable) {
        return null;
    }

    @Override
    public void update(DirectionEntity data) {

    }

    @Override
    public void delete(String key) {

    }
}
