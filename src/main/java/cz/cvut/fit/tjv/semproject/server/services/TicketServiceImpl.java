package cz.cvut.fit.tjv.semproject.server.services;

import cz.cvut.fit.tjv.semproject.server.entities.TicketEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {
    @Override
    public TicketEntity create(TicketEntity data) {
        return null;
    }

    @Override
    public Optional<TicketEntity> readById(String key) {
        return Optional.empty();
    }

    @Override
    public Page<TicketEntity> readAll(Pageable pageable) {
        return null;
    }

    @Override
    public void update(TicketEntity data) {

    }

    @Override
    public void delete(String key) {

    }
}
