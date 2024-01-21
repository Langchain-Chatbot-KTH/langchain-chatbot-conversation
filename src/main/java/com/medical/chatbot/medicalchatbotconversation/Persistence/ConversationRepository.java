package com.medical.chatbot.medicalchatbotconversation.Persistence;

import com.medical.chatbot.medicalchatbotconversation.BO.Entity.Conversation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ConversationRepository extends CrudRepository<Conversation, Long> {
    boolean existsByOwnerId(UUID ownerId);
    List<Conversation> findAllByOwnerId(UUID ownerId);
}

