package ma.oussama.hospital;

import ma.oussama.hospital.entities.*;
import ma.oussama.hospital.repositories.ConsultationRepository;
import ma.oussama.hospital.repositories.MedecinRepository;
import ma.oussama.hospital.repositories.PatientRepository;
import ma.oussama.hospital.repositories.RendezVousRepository;
import ma.oussama.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}
	@Bean
	CommandLineRunner start(IHospitalService hospitalService,PatientRepository patientRepository,MedecinRepository medecinRepository,ConsultationRepository consultationRepository,RendezVousRepository rendezVousRepository) {
		return args -> {
			Stream.of("Mohamed","oussama","mehdi")
					.forEach(name -> {
						Patient patient = new Patient();
						patient.setNom(name);
						patient.setDateNaissance(new Date());
						patient.setMalade(false);
						hospitalService.savePatient(patient);
					});
			Stream.of("amine","marwa","ali")
					.forEach(name -> {
						Medecin medecin = new Medecin();
						medecin.setNom(name);
						medecin.setEmail(name+"@gmail.com");
						medecin.setSpecialite(Math.random()>0.5?"Generale":"Dentiste");
						hospitalService.saveMedecin(medecin);
					});
			Patient patient = patientRepository.findById(1L).orElse(null);
			Patient patient1= patientRepository.findByNom("Mohamed");

			Medecin medecin = medecinRepository.findByNom("ali");

			RendezVous rendezVous= new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setPatient(patient);
			rendezVous.setMedecin(medecin);
			RendezVous saveDRDV = hospitalService.saveRDV(rendezVous);
			System.out.println(saveDRDV.getId());

			RendezVous rendezVous1= rendezVousRepository.findAll().get(0);
			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Rapport de la consultation .................");
			consultationRepository.save(consultation);
		};
	}

}
