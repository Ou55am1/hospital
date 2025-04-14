package ma.oussama.hospital.repositories;

import ma.oussama.hospital.entities.Consultation;
import ma.oussama.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
