package ma.oussama.hospital.repositories;

import ma.oussama.hospital.entities.Medecin;
import ma.oussama.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String name);
}
