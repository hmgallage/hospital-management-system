package com.hmsystem.Service;

import com.hmsystem.model.Store;
import com.hmsystem.model.Ward;

import java.util.List;

public interface Wardservice {

    Ward saveWard(Ward ward);
    List<Ward> getAllWards();
    Ward getWardById(long id);
    Ward updateWard(Ward ward, long id);
    void deleteWard(long id);
}
