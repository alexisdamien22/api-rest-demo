package com.formation.apirestdemo.service;

@Service("emailNotification")
public class EmailNotificationService implements NotificationService {
    @Override
    public void notifier(String destinataire, String message) {
        // Envoi réel d'un e-mail (non implémenté dans ce cours)
    }
}