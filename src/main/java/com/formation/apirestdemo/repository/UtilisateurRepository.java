package com.formation.apirestdemo.repository;
import com.formation.apirestdemo.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
* Repository pour l'entité Utilisateur.
* En héritant de JpaRepository, Spring génère automatiquement
* les méthodes CRUD : findAll(), findById(), save(), deleteById(), etc.
*
* Pas besoin d'écrire l'implémentation : Spring Data le fait pour nous.
*/
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
/**
* Recherche des utilisateurs dont le nom contient la chaîne donnée (insensible à la
casse).
* Spring Data génère automatiquement la requête SQL à partir du nom de la
méthode.
* Équivalent SQL : SELECT * FROM utilisateurs WHERE LOWER(nom) LIKE LOWER('%nom%')
*/
List<Utilisateur> findByNomContainingIgnoreCase(String nom);
/**
* Recherche des utilisateurs dont le prenom contient la chaîne donnée (insensible à la
casse).
* Équivalent SQL : SELECT * FROM utilisateurs WHERE LOWER(prenom) LIKE LOWER('%prenom%')
*/
List<Utilisateur> findByPrenomContainingIgnoreCase(String prenom);
/**
* Recherche des utilisateurs dont l'email contient la chaîne donnée (insensible à la
casse).
* Équivalent SQL : SELECT * FROM utilisateurs WHERE LOWER(email) LIKE LOWER('%email%')
*/
List<Utilisateur> findByEmailContainingIgnoreCase(String email);
/**
* Recherche des utilisateurs dont l'age est inférieur ou égal au montant donné.
* Équivalent SQL : SELECT * FROM utilisateurs WHERE age <= ?
*/
List<Utilisateur> findByAgeLessThanEqual(Integer age);
}