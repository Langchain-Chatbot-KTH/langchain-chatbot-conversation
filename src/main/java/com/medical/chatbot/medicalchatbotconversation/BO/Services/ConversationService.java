package com.medical.chatbot.medicalchatbotconversation.BO.Services;

import com.medical.chatbot.medicalchatbotconversation.BO.Entity.Conversation;
import com.medical.chatbot.medicalchatbotconversation.BO.Entity.Message;
import com.medical.chatbot.medicalchatbotconversation.Persistence.ConversationRepository;
import com.medical.chatbot.medicalchatbotconversation.Persistence.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConversationService {

    private final ConversationRepository conversationRepository;
    private final MessageRepository messageRepository;

    @Autowired
    public ConversationService(ConversationRepository conversationRepository, MessageRepository messageRepository) {
        this.conversationRepository = conversationRepository;
        this.messageRepository = messageRepository;
    }

    public List<Conversation> getAllConversations() {
        return (List<Conversation>) conversationRepository.findAll();
    }

    public List<Conversation> getConversationsByOwnerId(UUID ownerId) {
        return conversationRepository.findAllByOwnerId(ownerId);
    }
    public Optional<Conversation> getConversationById(Long id) {
        return conversationRepository.findById(id);
    }

    public Conversation startNewConversation(UUID ownerId) {
        Conversation conversation = new Conversation(ownerId, null);
        return conversationRepository.save(conversation);
    }

    public Conversation sendMessage(Long conversationId, String content, long senderId) {
        Optional<Conversation> optionalConversation = conversationRepository.findById(conversationId);
        if (optionalConversation.isPresent()) {
            Conversation conversation = optionalConversation.get();
            Message message = new Message(conversation, content, senderId);
            if (conversation.getMessages() == null) {
                conversation.setMessages(List.of(message));
            } else {
                conversation.getMessages().add(message);
            }
            conversationRepository.save(conversation);
            return conversation;
        } else {
            return null;
        }
    }

    public boolean hasConversations(UUID ownerId) {
        return conversationRepository.existsByOwnerId(ownerId);
    }

    public List<Message> getMessagesInConversation(Long conversationId) {
        Optional<Conversation> optionalConversation = conversationRepository.findById(conversationId);
        return optionalConversation.map(Conversation::getMessages).orElse(null);
    }

    public void deleteConversation(Long conversationId) {
        conversationRepository.deleteById(conversationId);
    }
}

