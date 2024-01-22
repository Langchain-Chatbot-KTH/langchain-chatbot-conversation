package com.medical.chatbot.swebotconversation.Persistence;

import com.medical.chatbot.swebotconversation.BO.Entity.Conversation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ConversationRepository extends CrudRepository<Conversation, Long> {
    boolean existsByOwnerId(UUID ownerId);
    List<Conversation> findAllByOwnerId(UUID ownerId);
}

