package com.medical.chatbot.swebotconversation.Persistence;

import com.medical.chatbot.swebotconversation.BO.Entity.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
