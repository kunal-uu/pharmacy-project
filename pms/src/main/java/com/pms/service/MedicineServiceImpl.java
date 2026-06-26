package com.pms.service;

import com.pms.model.Medicine;
import com.pms.repository.MedicineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository repo;

    public MedicineServiceImpl(MedicineRepository repo) {
        this.repo = repo;
    }

    @Override
    public Medicine addMedicine(Medicine medicine) {
        return null;
    }

    @Override
    public List<Medicine> getAllMedicines() {
        return repo.findAll();
    }
}


