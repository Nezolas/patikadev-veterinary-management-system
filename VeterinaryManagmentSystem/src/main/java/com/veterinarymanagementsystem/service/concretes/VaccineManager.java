package com.veterinarymanagementsystem.service.concretes;

import com.veterinarymanagementsystem.core.exception.DataExistsException;
import com.veterinarymanagementsystem.core.exception.NotFoundException;
import com.veterinarymanagementsystem.core.utilities.Msg;
import com.veterinarymanagementsystem.dto.request.VaccineRequest;
import com.veterinarymanagementsystem.dto.response.VaccineResponse;
import com.veterinarymanagementsystem.entities.Vaccine;
import com.veterinarymanagementsystem.mapper.VaccineMapper;
import com.veterinarymanagementsystem.repository.VaccineRepository;
import com.veterinarymanagementsystem.service.abstracts.VaccineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VaccineManager implements VaccineService {
    private final VaccineRepository vaccineRepository;
    private final VaccineMapper vaccineMapper;

    @Override
    public List<VaccineResponse> findAll() {
        return vaccineMapper.asOutput(vaccineRepository.findAll());
    }

    @Override
    public VaccineResponse getById(long id) {
        return vaccineMapper.asOutput(vaccineRepository.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND)));
    }

    @Override
    public List<VaccineResponse> getByAnimal(long id) {
        if (vaccineRepository.findByAnimalId(id).isEmpty()){
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        return vaccineMapper.asOutput(vaccineRepository.findByAnimalId(id));
    }

    @Override
    public List<VaccineResponse> getVaccinesInDateRange(LocalDate startDate, LocalDate endDate) {
        return vaccineMapper.asOutput(vaccineRepository.findByProtectionEndDateBetween(startDate, endDate));
    }

    @Override
    public VaccineResponse create(VaccineRequest request) {
        Optional<Vaccine> isVaccineExist = vaccineRepository.findByNameAndCodeAndAnimalId(request.getName(),
                request.getCode(), request.getAnimal().getId());
        if (isVaccineExist.isEmpty()){
            Vaccine vaccineSaved = vaccineRepository.save(vaccineMapper.asEntity(request));
            return vaccineMapper.asOutput(vaccineSaved);
        } else {
            LocalDate today = LocalDate.now();
            LocalDate controlDate = isVaccineExist.get().getProtectionEndDate();
            if (controlDate.isBefore(today) || controlDate.isEqual(today)){  // Değerledirme 19 : Koruyuculuk bitiş tarihi kontrol ediliyor.
                Vaccine vaccineSaved = vaccineRepository.save(vaccineMapper.asEntity(request));
                return vaccineMapper.asOutput(vaccineSaved);
            }
            throw new DataExistsException(Msg.PROTECTION_CONTINUES);
        }
    }

    @Override
    public VaccineResponse update(long id, VaccineRequest request) {
        Optional<Vaccine> vaccineFromDb = vaccineRepository.findById(id);
        if (vaccineFromDb.isEmpty()){
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        Optional<Vaccine> newVaccine = vaccineRepository.findByNameAndCodeAndAnimalId(request.getName(),
                request.getCode(), request.getAnimal().getId());
        if (newVaccine.isPresent() && newVaccine.get().getId() != id){
            throw new DataExistsException(Msg.DATA_EXISTS);
        }
        vaccineMapper.update(vaccineFromDb.get(), request);
        return vaccineMapper.asOutput(vaccineRepository.save(vaccineFromDb.get()));
    }

    @Override
    public void deleteById(long id) {
        Optional<Vaccine> vaccineFromDb = vaccineRepository.findById(id);
        if (vaccineFromDb.isPresent()){
            vaccineRepository.delete(vaccineFromDb.get());
        } else {
            throw new NotFoundException(Msg.NOT_FOUND);
        }
    }
}
