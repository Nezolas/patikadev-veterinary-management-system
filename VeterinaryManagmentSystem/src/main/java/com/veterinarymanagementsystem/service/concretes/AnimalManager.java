package com.veterinarymanagementsystem.service.concretes;

import com.veterinarymanagementsystem.core.exception.DataExistsException;
import com.veterinarymanagementsystem.core.exception.NotFoundException;
import com.veterinarymanagementsystem.core.utilities.Msg;
import com.veterinarymanagementsystem.dto.request.AnimalRequest;
import com.veterinarymanagementsystem.dto.response.AnimalResponse;
import com.veterinarymanagementsystem.entities.Animal;
import com.veterinarymanagementsystem.mapper.AnimalMapper;
import com.veterinarymanagementsystem.repository.AnimalRepository;
import com.veterinarymanagementsystem.service.abstracts.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnimalManager implements AnimalService {
    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;

    @Override
    public List<AnimalResponse> findAll() {
        return animalMapper.asOutput(animalRepository.findAll());
    }

    @Override
    public AnimalResponse getById(Long id) {
        return animalMapper.asOutput(animalRepository.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND)));
    }


    @Override
    public List<AnimalResponse> getByCustomer(Long id) {
        if (animalRepository.findByCustomerId(id).isEmpty()){
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        return animalMapper.asOutput(animalRepository.findByCustomerId(id));
    }

    @Override
    public AnimalResponse create(AnimalRequest request) {
        Optional<Animal> isAnimalExist = animalRepository.findByCustomerIdAndName(request.getCustomer().getId(), request.getName());
        if (isAnimalExist.isEmpty()){
            Animal animalSaved = animalRepository.save(animalMapper.asEntity(request));
            return animalMapper.asOutput(animalSaved);
        }
        throw new DataExistsException(Msg.DATA_EXISTS);
    }

    @Override
    public AnimalResponse update(Long id, AnimalRequest request) {
        Optional<Animal> animalFromDb = animalRepository.findById(id);
        if (animalFromDb.isEmpty()){
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        long newCustomerId = request.getCustomer().getId();
        String newName = request.getName();
        Optional<Animal> newAnimal = animalRepository.findByCustomerIdAndName(newCustomerId, newName);
        if (newAnimal.isPresent() && newAnimal.get().getId() != id){
            throw new DataExistsException(Msg.DATA_EXISTS);
        }
        Animal animal = animalFromDb.get();
        animalMapper.update(animal, request);
        return animalMapper.asOutput(animalRepository.save(animal));
    }

    @Override
    public void deleteById(Long id) {
        Optional<Animal> animalFromDb = animalRepository.findById(id);
        if (animalFromDb.isPresent()){
            animalRepository.delete(animalFromDb.get());
        } else {
            throw new NotFoundException(Msg.NOT_FOUND);
        }
    }

    @Override
    public List<AnimalResponse> getByName(String name) {
        if (animalRepository.findByNameIgnoreCase(name).isEmpty()){
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        return animalMapper.asOutput(animalRepository.findByNameIgnoreCase(name));
    }

}
