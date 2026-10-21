package com.formation.apirestdemo.service;
import com.formation.apirestdemo.model.Utilisateur;
import com.formation.apirestdemo.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
/**
* Service contenant la logique métier pour les utilisateurs.
* Le service est le chef d'orchestre : il coordonne les appels
* au repository et applique les règles métier.
*/
@Service
public class UtilisateurService {
private final UtilisateurRepository UtilisateurRepository;
/**
* Injection de dépendance par constructeur.
* Spring injecte automatiquement le UtilisateurRepository.
*/
public UtilisateurService(UtilisateurRepository UtilisateurRepository) {
this.UtilisateurRepository = UtilisateurRepository;
}
/**
* Retourne tous les utilisateurs.
*/
public List<Utilisateur> recupererTous() {
return UtilisateurRepository.findAll();
}
/**
* Retourne un utilisateur par son ID.
* @return Optional vide si le utilisateur n'existe pas.
*/
public Optional<Utilisateur> recupererParId(Long id) {
return UtilisateurRepository.findById(id);
}
/**
* Crée un nouveau utilisateur.
* @param utilisateur L'utilisateur à créer (sans ID).
* @return L'utilisateur créé (avec ID généré).
*/
public Utilisateur creer(Utilisateur utilisateur) {
// On s'assure que l'ID est null pour forcer une création (pas une mise à jour)
utilisateur.setId(null);
return UtilisateurRepository.save(utilisateur);
}
/**
* Met à jour un utilisateur existant.
* @param id L'ID de l'utilisateur à modifier.
* @param utilisateurModifie Les nouvelles valeurs.
* @return Optional contenant le utilisateur mis à jour, ou vide si l'ID n'existe
pas.
*/
public Optional<Utilisateur> mettreAJour(Long id, Utilisateur utilisateurModifie) {
return UtilisateurRepository.findById(id)
.map(utilisateurExistant -> {
utilisateurExistant.setNom(utilisateurModifie.getNom());
utilisateurExistant.setPrenom(utilisateurModifie.getPrenom());
utilisateurExistant.setEmail(utilisateurModifie.getEmail());
utilisateurExistant.setAge(utilisateurModifie.getAge());
return UtilisateurRepository.save(utilisateurExistant);
});
}
/**
* Supprime un utilisateur par son ID.
* @return true si le utilisateur existait et a été supprimé, false sinon.
*/
public boolean supprimer(Long id) {
if (UtilisateurRepository.existsById(id)) {
UtilisateurRepository.deleteById(id);
return true;
}
return false;
}
/**
* Recherche des utilisateurs par nom (recherche partielle, insensible à la casse).
*/
public List<Utilisateur> rechercherParNom(String nom) {
return UtilisateurRepository.findByNomContainingIgnoreCase(nom);
}
/**
* Recherche des utilisateurs par prenom (recherche partielle, insensible à la casse).
*/
public List<Utilisateur> rechercherParPrenom(String nom) {
return UtilisateurRepository.findByPrenomContainingIgnoreCase(nom);
}
/**
* Recherche des utilisateurs par email (recherche partielle, insensible à la casse).
*/
public List<Utilisateur> rechercherParEmail(String nom) {
return UtilisateurRepository.findByEmailContainingIgnoreCase(nom);
}
}