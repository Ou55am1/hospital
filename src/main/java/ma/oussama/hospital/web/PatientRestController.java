package ma.oussama.hospital.web;

import ma.oussama.hospital.entities.Patient;
import ma.oussama.hospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/Patient")
    public List<Patient>patientList(){
        return patientRepository.findAll();
    }
}
