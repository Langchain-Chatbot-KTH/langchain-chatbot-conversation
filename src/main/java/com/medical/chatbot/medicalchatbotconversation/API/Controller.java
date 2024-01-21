package com.medical.chatbot.medicalchatbotconversation.API;

import com.medical.chatbot.medicalchatbotconversation.BO.Entity.Conversation;
import com.medical.chatbot.medicalchatbotconversation.BO.Entity.Message;
import com.medical.chatbot.medicalchatbotconversation.BO.Services.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/conversations")
public class Controller {

    private final ConversationService conversationService;

    @Autowired
    public Controller(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @GetMapping("/getAllConversation")
    public List<Conversation> getAllConversations() {
        return conversationService.getAllConversations();
    }

    @GetMapping("/{id}")
    public Conversation getConversationById(@PathVariable Long id) {
        return conversationService.getConversationById(id).orElse(null);
    }

    @GetMapping("/getByOwnerId")
    public List<Conversation> getConversationsByOwnerId(@RequestParam UUID ownerId) {
        return conversationService.getConversationsByOwnerId(ownerId);
    }

    @PostMapping("/start")
    public Conversation startNewConversation(@RequestParam UUID ownerId) {
        return conversationService.startNewConversation(ownerId);
    }

    @PostMapping("/{conversationId}/send")
    public Conversation sendMessage(
            @PathVariable Long conversationId,
            @RequestParam String content,
            @RequestParam long senderId
    ) {
        return conversationService.sendMessage(conversationId, content, senderId);
    }

    @GetMapping("/{conversationId}/messages")
    public List<Message> getMessagesInConversation(@PathVariable Long conversationId) {
        return conversationService.getMessagesInConversation(conversationId);
    }

    @DeleteMapping("/{id}")
    public void deleteConversation(@PathVariable Long id) {
        conversationService.deleteConversation(id);
    }

    @GetMapping("/hasConversations")
    public boolean hasConversations(@RequestParam UUID ownerId) {
        return conversationService.hasConversations(ownerId);
    }
}

