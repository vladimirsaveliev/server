package cz.cvut.fit.tjv.semproject.server.rest_api;

import cz.cvut.fit.tjv.semproject.server.entities.DirectionEntity;
import cz.cvut.fit.tjv.semproject.server.services.DirectionService;
import cz.cvut.fit.tjv.semproject.server.services.ExistingEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(path="v1/api/tbl_Directions")
public class DirectionController {
    private final DirectionService directionService;

    @Autowired
    public DirectionController(DirectionService directionService) {
        this.directionService = directionService;
    }

    @PostMapping
    public void create(@RequestBody DirectionEntity direction) {
        try {
            directionService.create(direction);
        } catch (ExistingEntityException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{id}")
    public DirectionEntity readOne(@PathVariable String fromTo) {
        Optional<DirectionEntity> rc = directionService.readById(fromTo);
        return rc.get();
/*        return clientDtoAssembler.toModel(
                clientService.readyById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))).add(WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).readAll(0,10)).withRel(IanaLinkRelations.COLLECTION));
 */
    }

    /*@GetMapping
    public PagedModel<ClientDto> readAll(@RequestParam(defaultValue = "0") int page, @RequestParam (defaultValue = "10") int size) {
        Page<ClientsEntity> res = clientService.readAll(PageRequest.of(page, size));
        return pagedResourcesAssembler.toModel(res, clientDtoAssembler);
    }
*/
    // Update 1: http command PUT
    @PutMapping
    public void update(@RequestBody DirectionEntity directionEntity) {
        directionService.update(directionEntity);
    }

    @DeleteMapping
    public void delete(@RequestParam String fromTo) {
        try {
            directionService.delete(fromTo);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
