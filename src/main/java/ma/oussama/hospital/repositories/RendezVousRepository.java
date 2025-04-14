package ma.oussama.hospital.repositories;

import ma.oussama.hospital.entities.Patient;
import ma.oussama.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, String> {
}
