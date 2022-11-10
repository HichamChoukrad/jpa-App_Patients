package org.sid.jpaapp.repositories;

import org.sid.jpaapp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long>  /*type de ID(Long)*/ {
      public List<Patient> findByNomContains(String name); //Afficher les patients dont le nom contient un keyword/ ou bien juste les patients qui sont malades

      public List<Patient> findByMalade(boolean b); //Récupérer tous les patients qui sont malades

      public  List<Patient> findByNomContainsAndMalade(String name, boolean b); //Récupérer les patients par leurs noms et qui sont pas malades, combiner les deux méthodes

}
