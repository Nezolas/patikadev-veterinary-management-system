package com.veterinarymanagementsystem.service.concretes;

import com.veterinarymanagementsystem.core.exception.DataExistsException;
import com.veterinarymanagementsystem.core.exception.NotFoundException;
import com.veterinarymanagementsystem.core.utilities.Msg;
import com.veterinarymanagementsystem.core.utilities.ResultHelper;
import com.veterinarymanagementsystem.dto.Converter;
import com.veterinarymanagementsystem.dto.request.DoctorRequest;
import com.veterinarymanagementsystem.dto.response.DoctorResponse;
import com.veterinarymanagementsystem.entities.Doctor;
import com.veterinarymanagementsystem.mapper.DoctorMapper;
import com.veterinarymanagementsystem.repository.DoctorRepository;
import com.veterinarymanagementsystem.service.abstracts.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorManager implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Override
    public List<DoctorResponse> findAll() {
        return doctorMapper.asOutput(doctorRepository.findAll());
    }

    @Override
    public DoctorResponse getById(long id) {
        return doctorMapper.asOutput(doctorRepository.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND)));
    }

    @Override
    public DoctorResponse create(DoctorRequest request) {
        Optional<Doctor> isDoctorExist = doctorRepository.findByEmail(request.getEmail());
        if (isDoctorExist.isEmpty()){
            Doctor doctorSaved = doctorRepository.save(doctorMapper.asEntity(request));
            return doctorMapper.asOutput(doctorSaved);
        }
        throw new DataExistsException(Msg.DATA_EXISTS);
    }
/*    public DoctorResponse create(DoctorRequest request) {
*//*        Optional<Doctor> isDoctorExist = doctorRepository.findByEmail(request.getEmail());
        if (isDoctorExist.isEmpty()){
            Doctor doctorSaved = doctorRepository.save(doctorMapper.asEntity(request));
            return doctorMapper.asOutput(doctorSaved);
        }*//*
*//*        Doctor doctorSaved = this.doctorMapper.asEntity(request);
        this.doctorRepository.save(doctorSaved);*//*

//        Doctor doctorSaved = doctorRepository.save(doctorMapper.asEntity(request));
        return doctorMapper.asOutput(doctorSaved);
        throw new DataExistsException(Msg.DATA_EXISTS);
    }*/

    @Override
    public DoctorResponse update(long id, DoctorRequest request) {
        Optional<Doctor> doctorFromDb = doctorRepository.findById(id);
        if (doctorFromDb.isEmpty()) {
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        String newMail = request.getEmail();
        Optional<Doctor> newDoctor = doctorRepository.findByEmail(newMail);
        if (newDoctor.isPresent() && newDoctor.get().getId() != id) {
            throw new DataExistsException(Msg.DATA_EXISTS);
        }
        Doctor doctor = doctorFromDb.get();
        doctorMapper.update(doctor, request);
        return doctorMapper.asOutput(doctorRepository.save(doctor));
    }

    @Override
    public void deleteById(long id) {
        Optional<Doctor> doctorFromDb = doctorRepository.findById(id);
        if (doctorFromDb.isPresent()){
            doctorRepository.delete(doctorFromDb.get());
        } else {
            throw new NotFoundException(Msg.NOT_FOUND);
        }
    }
}
