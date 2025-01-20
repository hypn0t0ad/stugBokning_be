package com.example.stugbokning_be.service;

import com.example.stugbokning_be.entity.BookingEntity;
import com.example.stugbokning_be.entity.CabinEntity;
import com.example.stugbokning_be.exception.NotFoundException;
import com.example.stugbokning_be.model.BookCabinRequest;
import com.example.stugbokning_be.model.BookingResponse;
import com.example.stugbokning_be.model.VerifyCabinBookedResponse;
import com.example.stugbokning_be.model.CabinResponse;
import com.example.stugbokning_be.repository.BookingRepository;
import com.example.stugbokning_be.repository.CabinRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookCabinService {

    private final CabinRepository cabinRepository;
    private final BookingRepository bookingRepository;

    public List<CabinResponse> allAvaibleCabinsAndDates() {

        LocalDate start = LocalDate.of(2025, 2, 1);
        LocalDate until = LocalDate.of(2025, 2, 28);

        List<CabinResponse> respons = new ArrayList<>();
        Collection<CabinEntity> allCabins = cabinRepository.findAll();
        for (CabinEntity cabin : allCabins) {
            respons.add(avaibleDatesForCabin(cabin.getId(), start, until));
        }
        return respons;
    }

    public CabinResponse specificCabinAndDates(long id) {
        // Hårdkodar datum för att inte göra det alltför invecklat
        return avaibleDatesForCabin(id, LocalDate.now(), LocalDate.of(2025,3,28));
    }

    public VerifyCabinBookedResponse bookCabin(BookCabinRequest request) {
        CabinEntity cabin = cabinRepository.findById(request.id())
                .orElseThrow(() -> new NotFoundException("Cabin with id: " + request.id() + " can't be found"));

        BookingEntity newBooking = new BookingEntity();
        newBooking.setCabin(cabin);
        newBooking.setStart(request.start());
        newBooking.setUntill(request.until());
        bookingRepository.save(newBooking);
        return new VerifyCabinBookedResponse(
                newBooking.getCabin().toModel(), newBooking.getStart(), newBooking.getUntill());
    }

    public List<BookingResponse> allBookings() {
        return bookingRepository.findAll().stream()
                .map(e -> new BookingResponse(e.getCabin().toModel(), e.getStart(), e.getUntill())).toList();
    }

    private CabinResponse avaibleDatesForCabin(long id, LocalDate start, LocalDate untill) {
        Collection<BookingEntity> allBookingsForCabin = bookingRepository.findByStugaId(id);
        CabinEntity cabinEntity = cabinRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cabin with id " + id + " can't be found"));

        List<LocalDate> allBookedDaysForCabin = new ArrayList<>();
        for (BookingEntity booking : allBookingsForCabin) {
            allBookedDaysForCabin.addAll(datesBetween(booking.getStart(), booking.getUntill()));
        }
        List<LocalDate> daysBetweenSearch = datesBetween(start, untill);
        List<LocalDate> avaibleDaysForCabin = daysBetweenSearch.stream()
                .filter(d -> !allBookedDaysForCabin.contains(d)).toList();

        return new CabinResponse(
                cabinEntity.getId(),
                cabinEntity.getName(),
                cabinEntity.getPrice(),
                cabinEntity.getSize(),
                avaibleDaysForCabin
        );
    }

    private static List<LocalDate> datesBetween(LocalDate startDate, LocalDate untillDate) {
        List<LocalDate> dates = new ArrayList<>();
        LocalDate date = startDate;

        while (!date.isAfter(untillDate)) {
            dates.add(date);
            date = date.plusDays(1);
        }

        return dates;
    }
}
