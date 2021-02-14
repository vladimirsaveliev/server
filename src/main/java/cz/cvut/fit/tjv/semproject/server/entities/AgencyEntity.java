package cz.cvut.fit.tjv.semproject.server.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name="tbl_Agencies")
public class AgencyEntity {
    // primary key example: Czech Airlines
    @Id
    @Column(name="db_agencyName")
    private String agencyName;

    public AgencyEntity(String agencyName, Collection<TicketEntity> soldTickets) {
        this.agencyName = agencyName;
        this.soldTickets = soldTickets;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public Collection<TicketEntity> getSoldTickets() {
        return soldTickets;
    }

    public void setSoldTickets(Collection<TicketEntity> soldTickets) {
        this.soldTickets = soldTickets;
    }

    /*    // many-to-many association between directions and agencies
        @ManyToMany(mappedBy = "direction_agency")
        private Set<DirectionEntity> directionSet;
    */
    // one-to-many association between the agency and tickets sold
    @OneToMany(mappedBy = "sellerAgency")
    private Collection<TicketEntity>  soldTickets;
}
