package ma.oussama.hospital.service;

import ma.oussama.hospital.entities.Consultation;
import ma.oussama.hospital.entities.Medecin;
import ma.oussama.hospital.entities.Patient;
import ma.oussama.hospital.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
