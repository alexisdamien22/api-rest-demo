package com.formation.apirestdemo.service;

import com.formation.apirestdemo.service.NotificationService;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary // implémentation choisie par défaut
public class ConsoleNotificationService implements NotificationService {
    @Override
    public void notifier(String destinataire, String message) {
        // Remplacé par un logger dans la Partie 4b
        System.out.println("[NOTIFICATION] " + destinataire + " : " + message);
    }
}
