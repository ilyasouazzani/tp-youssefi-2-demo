package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class PatientController {

    private final PatientRepository patientRepository;

    @GetMapping("/patients")
    public String patients(Model model) {
        model.addAttribute("patients", patientRepository.findAll());
        return "patients";
    }
}
