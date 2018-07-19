package com.bst.service;

import com.bst.model.ingresoevento.PantallaIngreso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * Service class for sending notification messages.
 */
@Service
public class NotificationService {

    // The SimpMessagingTemplate is used to send Stomp over WebSocket messages.
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /**
     * Send notification to users subscribed on channel "/user/queue/notify".
     *
     * The message will be sent only to the user with the given username.
     *
     * @param pantallaIngreso The notification message.
     */
    public void notify(PantallaIngreso pantallaIngreso) {
        messagingTemplate.convertAndSend(
                "/acceso/notificar",
                pantallaIngreso
        );
        return;
    }

} // class NotificationService
