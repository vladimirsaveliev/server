package cz.cvut.fit.tjv.semproject.server.rest_api;

import cz.cvut.fit.tjv.semproject.server.entities.TicketEntity;
import cz.cvut.fit.tjv.semproject.server.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(path="v1/api/tbl_Tickets")
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/{id}")
    public TicketEntity readOne(@PathVariable String id) {
        Optional<TicketEntity> rc = ticketService.readById(id);
        return rc.get();
//        return clientDtoAssembler.toModel(
//                clientService.readyById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))).add(WebMvcLinkBuilder
//                .linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).readAll(0,10)).withRel(IanaLinkRelations.COLLECTION));
    }

}
