package cz.cvut.fit.tjv.semproject.server.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tbl_Tickets")
public class TicketEntity {
    @Id
    @Column(name = "db_bookingRef")
    private String bookingRef;

    @Column(name = "db_departureDate")
    private Date departureDate;

    @Column(name = "db_price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "db_agencyName") // primary key of tbl_Agencies
    private AgencyEntity sellerAgency;

    @ManyToOne
    @JoinColumn(name = "db_direction") // primary key of tbl_Directions
    private DirectionEntity fromTo;

    public String getBookingRef() {
        return bookingRef;
    }

    public void setBookingRef(String bookingRef) {
        this.bookingRef = bookingRef;
    }
}
