package com.veterinarymanagementsystem.service.concretes;

import com.veterinarymanagementsystem.core.exception.DataExistsException;
import com.veterinarymanagementsystem.core.exception.NotFoundException;
import com.veterinarymanagementsystem.core.utilities.Msg;
import com.veterinarymanagementsystem.dto.request.AvailableDateRequest;
import com.veterinarymanagementsystem.dto.response.AvailableDateResponse;
import com.veterinarymanagementsystem.entities.AvailableDate;
import com.veterinarymanagementsystem.mapper.AvailableDateMapper;
import com.veterinarymanagementsystem.repository.AvailableDateRepository;
import com.veterinarymanagementsystem.service.abstracts.AvailableDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AvailableDateManager implements AvailableDateService {
    private final AvailableDateRepository availableDateRepository;
    private final AvailableDateMapper availableDateMapper;


    @Override
    public List<AvailableDateResponse> findAll() {
        return availableDateMapper.asOutput(availableDateRepository.findAll());
    }

    @Override
    public AvailableDateResponse getById(long id) {
        return availableDateMapper.asOutput(availableDateRepository.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND)));
    }

    @Override
    public AvailableDateResponse create(AvailableDateRequest request) {
        Optional<AvailableDate> isDateExist = availableDateRepository.findByDoctorIdAndAvailableDate(request.getDoctor().getId(), request.getAvailableDate());
        if (isDateExist.isEmpty()){
            AvailableDate dateSaved = availableDateRepository.save(availableDateMapper.asEntity(request));
            return availableDateMapper.asOutput(dateSaved);
        }
        throw new DataExistsException(Msg.DATA_EXISTS);
    }

    @Override
    public AvailableDateResponse update(long id, AvailableDateRequest request) {
        Optional<AvailableDate> dateFromDb = availableDateRepository.findById(id);
        if (dateFromDb.isEmpty()){
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        long newDoctorId = request.getDoctor().getId();
        LocalDate newDate = request.getAvailableDate();
        Optional<AvailableDate> newAvailableDateObj = availableDateRepository.findByDoctorIdAndAvailableDate(newDoctorId, newDate);
        if (newAvailableDateObj.isPresent() && newAvailableDateObj.get().getId() != id){
            throw new DataExistsException(Msg.DATA_EXISTS);
        }
        AvailableDate availableDate = dateFromDb.get();
        availableDateMapper.update(availableDate, request);
        return availableDateMapper.asOutput(availableDateRepository.save(availableDate));
    }

    @Override
    public void deleteById(long id) {
        Optional<AvailableDate> availableDateFromDb = availableDateRepository.findById(id);
        if (availableDateFromDb.isPresent()){
            availableDateRepository.delete(availableDateFromDb.get());
        } else {
            throw new NotFoundException(Msg.NOT_FOUND);
        }
    }

    @Override
    public List<AvailableDateResponse> getDoctorAvailableDateInRange(long doctorId, LocalDate startDate, LocalDate endDate) {
        return availableDateMapper.asOutput(availableDateRepository.findByDoctorIdAndAvailableDateBetween(doctorId, startDate, endDate));
    }

    @Override
    public boolean existByDoctorIdAndAvailableDate(long doctorId, LocalDate availableDate) {
        return this.availableDateRepository.existsByDoctorIdAndAvailableDate(doctorId, availableDate);
    }

}
