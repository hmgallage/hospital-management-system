package com.hmsystem.Service.Impl;

import com.hmsystem.Service.Wardservice;
import com.hmsystem.exception.ResourceNotFoundException;
import com.hmsystem.model.UserAccount;
import com.hmsystem.model.Ward;
import com.hmsystem.repository.UserAccountRepository;
import com.hmsystem.repository.WardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WardServiceImpl implements Wardservice {

    private WardRepository wardRepository;

    public WardServiceImpl(WardRepository wardRepository) {
        this.wardRepository = wardRepository;
    }
    @Override
    public Ward saveWard(Ward ward) {
        return wardRepository.save(ward);
    }

    @Override
    public List<Ward> getAllWards() {
        return wardRepository.findAll();
    }

    @Override
    public Ward getWardById(long id) {
        return wardRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Ward", "Id", id));
    }

    @Override
    public Ward updateWard(Ward ward, long id) {
        // check whether patient with given id is exist in DB or not
        Ward existingWard = wardRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Ward", "Id", id));

        existingWard.setNoOfRooms(ward.getNoOfRooms());
        existingWard.setRoomAvailability(ward.getRoomAvailability());
        // save existing ward to DB
        wardRepository.save(existingWard);
        return existingWard;
    }

    @Override
    public void deleteWard(long id) {
        // check whether a Patient exist in a DB or not
        wardRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Ward", "Id", id));
        wardRepository.deleteById(id);

    }
}
