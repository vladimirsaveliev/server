package cz.cvut.fit.tjv.semproject.server.rest_model;

import org.springframework.hateoas.RepresentationModel;

import java.util.Collection;

public class AgencyDto extends RepresentationModel<AgencyDto> {
    private String agencyName;
    private Collection<String> bookingRefs;

    public AgencyDto() {
    }

    public AgencyDto(String agencyName, Collection<String> bookingRefs) {
        this.agencyName = agencyName;
        this.bookingRefs = bookingRefs;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public Collection<String> getBookingRefs() {
        return bookingRefs;
    }

    public void setBookingRefs(Collection<String> bookingRefs) {
        this.bookingRefs = bookingRefs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AgencyDto agencyDto = (AgencyDto) o;

        if (agencyName != null ? !agencyName.equals(agencyDto.agencyName) : agencyDto.agencyName != null) return false;
        return bookingRefs != null ? bookingRefs.equals(agencyDto.bookingRefs) : agencyDto.bookingRefs == null;
    }

    @Override
    public int hashCode() {
        int result = agencyName != null ? agencyName.hashCode() : 0;
        result = 31 * result + (bookingRefs != null ? bookingRefs.hashCode() : 0);
        return result;
    }
}
