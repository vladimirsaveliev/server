package cz.cvut.fit.tjv.semproject.server.rest_model;

import org.springframework.hateoas.RepresentationModel;

import java.util.Collection;

public class DirectionDto extends RepresentationModel<DirectionDto> {
    private String direction;
    private Collection<String> bookingRefs;

    public DirectionDto() {
    }

    public DirectionDto(String direction, Collection<String> bookingRefs) {
        this.direction = direction;
        this.bookingRefs = bookingRefs;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
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

        DirectionDto that = (DirectionDto) o;

        if (direction != null ? !direction.equals(that.direction) : that.direction != null) return false;
        return bookingRefs != null ? bookingRefs.equals(that.bookingRefs) : that.bookingRefs == null;
    }

    @Override
    public int hashCode() {
        int result = direction != null ? direction.hashCode() : 0;
        result = 31 * result + (bookingRefs != null ? bookingRefs.hashCode() : 0);
        return result;
    }
}
