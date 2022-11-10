package org.sid.jpaapp;

import org.sid.jpaapp.entities.Patient;
import org.sid.jpaapp.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaAppApplication implements CommandLineRunner {
    @Autowired  //Faire l'injection des dépandences avec les annotations
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Ajouter des patients
       patientRepository.save(new Patient(null,"Hicham",new Date(), false,2500));
        patientRepository.save(new Patient(null,"Mouad",new Date(), false,2600));
        patientRepository.save(new Patient(null,"Amine",new Date(), true,2700));
        patientRepository.save(new Patient(null,"Khadija",new Date(), false,2900));

        //Afficher la liste des patients

        patientRepository.findAll().forEach(p-> {
            System.out.println(p.toString());
        });
        //Je veux chercher un patient x

        Patient patient=patientRepository.findById(4L).get(); //L parce que id est de type Long
        System.out.println(patient.getNom());

        //Afficher les patients dont le nom contient un keyword/ ou bien juste les patients qui sont malades
        //  patient contient la lettre H
        List<Patient> patients =patientRepository.findByNomContains("H"); //  patient contientcla lettre H
         patients.forEach(p->{
             System.out.println(p.toString());
        });

        //Récupérer tous les patients qui sont malades
        List<Patient> patients2 =patientRepository.findByMalade(true); //Récupérer tous les patients qui sont malades
        patients2.forEach(p->{
            System.out.println(p.toString());
        });

        //Récupérer les patients par leurs noms et qui sont pas malades, combiner les deux méthodes
        List<Patient> patients3 =patientRepository.findByNomContainsAndMalade("H", true); //  patient contientcla lettre H
        patients3.forEach(p->{
            System.out.println(p.toString());
        });

        //Supprimer un patient
        patientRepository.deleteById(2L);
        Page<Patient> pagePatients =patientRepository.findAll(PageRequest.of(0,2));//pagination, je veux que deux patients a partir de la page 0
        System.out.println("Nombre de pages:"+pagePatients.getTotalPages()); // Afficher le nombre des pages
        List<Patient> listPatients=pagePatients.getContent();
                listPatients.forEach(p->{
            System.out.println(p.toString());
        });
    }
}
