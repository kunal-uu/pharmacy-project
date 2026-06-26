package com.pms.service;

import com.pms.model.Medicine;

import java.util.List;

public interface MedicineService {
    Medicine addMedicine(Medicine medicine);
    List<Medicine> getAllMedicines();
}
