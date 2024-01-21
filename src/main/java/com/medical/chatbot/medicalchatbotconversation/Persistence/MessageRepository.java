package com.medical.chatbot.medicalchatbotconversation.Persistence;

import com.medical.chatbot.medicalchatbotconversation.BO.Entity.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
