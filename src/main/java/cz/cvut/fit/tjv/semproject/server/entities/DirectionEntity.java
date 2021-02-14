package cz.cvut.fit.tjv.semproject.server.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;
// import org.springframework.data.annotation.Id;

@Entity
@Table(name="tbl_Directions")
public class DirectionEntity {
    // primary key example: PRG-DNK
    @Id
    @Column(name="db_direction")
    private String direction;

    // many-to-many association between directions and agencies
/*
    @Column(name="db_agencies")
    @ManyToMany
    @JoinTable(
            name="direction_agency",
            joinColumns = @JoinColumn(name = "directionId"),
            inverseJoinColumns = @JoinColumn(name = "agencyId")
    )
    private Set<AgencyEntity> agencySet;
*/
    // one-to-many association between the direction and tickets sold for this direction
    @OneToMany(mappedBy="fromTo")
    private Collection<TicketEntity> tickets;

    public DirectionEntity() {
    }

    public DirectionEntity(String fromTo, String agency) {
        this.direction = fromTo;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String fromTo) {
        this.direction = fromTo;
    }
 }