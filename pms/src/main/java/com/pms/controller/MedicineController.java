package com.pms.controller;

import com.pms.model.Medicine;
import com.pms.service.MedicineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicines")
public class MedicineController {

    private final MedicineService service;


    public MedicineController(MedicineService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Medicine addMedicine(@RequestBody Medicine medicine) {
        Medicine Medicine = new Medicine();
        return service.addMedicine(Medicine);
    }

    @GetMapping("/all")
    public List<Medicine> getAllMedicines() {
        return service.getAllMedicines();
    }
}
