package cz.cvut.fit.tjv.semproject.server.services;

import cz.cvut.fit.tjv.semproject.server.entities.AgencyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgencyServiceImpl implements AgencyService {
    @Override
    public AgencyEntity create(AgencyEntity data) {
        return null;
    }

    @Override
    public Optional<AgencyEntity> readById(String key) {
        return Optional.empty();
    }

    @Override
    public Page<AgencyEntity> readAll(Pageable pageable) {
        return null;
    }

    @Override
    public void update(AgencyEntity data) {

    }

    @Override
    public void delete(String key) {

    }
}
