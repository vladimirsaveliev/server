package cz.cvut.fit.tjv.semproject.server.rest_api;

import cz.cvut.fit.tjv.semproject.server.rest_model.AgencyDto;
import cz.cvut.fit.tjv.semproject.server.entities.AgencyEntity;
import cz.cvut.fit.tjv.semproject.server.entities.TicketEntity;
import cz.cvut.fit.tjv.semproject.server.services.AgencyService;
import cz.cvut.fit.tjv.semproject.server.services.ExistingEntityException;
import cz.cvut.fit.tjv.semproject.server.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/tbl_Agencies")
public class AgencyController {
    private final AgencyService agencyService;
    private final AgencyDtoAssembler agencyDtoAssembler;
    // This is to convert Collection<TicketEntity.bookingRef> to Collection<TicketEntity>
    private final TicketService ticketService;

    @Autowired
    public AgencyController(AgencyService agencyService, AgencyDtoAssembler agencyDtoAssembler, TicketService ticketService) {
        this.agencyService = agencyService;
        this.agencyDtoAssembler = agencyDtoAssembler;
        this.ticketService = ticketService;
    }

    // From Dto to Entity
    private AgencyEntity toEntity(AgencyDto agencyDto) {
        if (agencyDto == null)
            return null;
        Collection<String> bookingRefs = agencyDto.getBookingRefs();
        Collection<TicketEntity> tickets;
        if (bookingRefs == null) {
            tickets = null;
        } else {
            tickets = bookingRefs.stream().map(i -> ticketService.readById(i).orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT)))
                            .collect(Collectors.toList());
        }
        return new AgencyEntity(agencyDto.getAgencyName(), tickets);

    }

    @PostMapping
    public void create(@RequestBody AgencyDto agency) {
        try {
            agencyService.create(toEntity(agency));
        } catch (ExistingEntityException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{id}")
    public AgencyDto readOne(@PathVariable String id) {
        return agencyDtoAssembler.toModel(
                agencyService.readById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
        );
    }

    // @GetMapping
    // readAll should be here (optional)
    // Watch lecture Rest api web servers, week 10 p 1 (46 min)

    @PutMapping
    public void update(@RequestBody AgencyDto agency) {
        agencyService.update(toEntity(agency));
    }

    @DeleteMapping
    public void delete(@RequestParam String fromTo) {
        try {
            agencyService.delete(fromTo);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
