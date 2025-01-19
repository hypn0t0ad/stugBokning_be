package com.example.stugbokning_be.service;

import com.example.stugbokning_be.entity.BookingEntity;
import com.example.stugbokning_be.model.BokningResponse;
import com.example.stugbokning_be.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookingService {

    private final BookingRepository bookingRepository;

    public List<BokningResponse> avaibleDatesForCabin() {
        Collection<BookingEntity> allBookings = bookingRepository.findAll();
        return allBookings.stream().map(BookingService::createBookingResponse).toList();
    }

    private static BokningResponse createBookingResponse(BookingEntity booking) {
        return new BokningResponse(
                booking.getCabin().toModel(),
                booking.getStart(),
                booking.getUntill()
        );
    }

}
