package cz.cvut.fit.tjv.semproject.server.rest_api;

import cz.cvut.fit.tjv.semproject.server.rest_model.AgencyDto;
import cz.cvut.fit.tjv.semproject.server.entities.AgencyEntity;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AgencyDtoAssembler extends RepresentationModelAssemblerSupport<AgencyEntity, AgencyDto> {
    public AgencyDtoAssembler() {
        super(AgencyController.class, AgencyDto.class);
    }

    // Translation from AgencyEntity to AgencyDto
    @Override
    public AgencyDto toModel(AgencyEntity entity) {
        if (entity == null)
                return null;
        return new AgencyDto(
            entity.getAgencyName(),
            // Collection<TicketEntity> -> Collection<TicketEntity.bookingRef>
            entity.getSoldTickets() == null ?
                    null : entity.getSoldTickets().stream().map(i -> i.getBookingRef()).collect(Collectors.toList())
        );
    }
}
