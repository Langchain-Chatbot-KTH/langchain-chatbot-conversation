# SweBot Conversation API

This repository contains a Spring Boot application for a Medical Chatbot Conversation API. The API manages conversations and messages between the medical chatbot and users.

## Controller

### `Controller.java`

The controller class defines RESTful API endpoints for managing conversations and messages.

- `GET /api/conversations/getAllConversation`: Get all conversations.
- `GET /api/conversations/{id}`: Get conversation by ID.
- `GET /api/conversations/getByOwnerId`: Get conversations by owner ID.
- `POST /api/conversations/start`: Start a new conversation.
- `POST /api/conversations/{conversationId}/send`: Send a message in a conversation.
- `GET /api/conversations/{conversationId}/messages`: Get messages in a conversation.
- `DELETE /api/conversations/{id}`: Delete a conversation.
- `GET /api/conversations/hasConversations`: Check if a user has conversations.

## Entity Classes

### `Conversation.java`

The entity class represents a conversation. It has an ID, owner ID, and a list of messages.

### `Message.java`

The entity class represents a message in a conversation. It has an ID, content, and sender ID (0 for bot, 1 for human).

## Services

### `ConversationService.java`

The service class provides methods for interacting with conversations and messages.

- `getAllConversations()`: Get all conversations.
- `getConversationsByOwnerId(UUID ownerId)`: Get conversations by owner ID.
- `getConversationById(Long id)`: Get conversation by ID.
- `startNewConversation(UUID ownerId)`: Start a new conversation.
- `sendMessage(Long conversationId, String content, long senderId)`: Send a message in a conversation.
- `hasConversations(UUID ownerId)`: Check if a user has conversations.
- `getMessagesInConversation(Long conversationId)`: Get messages in a conversation.
- `deleteConversation(Long conversationId)`: Delete a conversation.

## Repositories

### `ConversationRepository.java`

The repository interface extends `CrudRepository` for managing `Conversation` entities.

- `existsByOwnerId(UUID ownerId)`: Check if a conversation exists for a given owner ID.
- `findAllByOwnerId(UUID ownerId)`: Find all conversations by owner ID.

### `MessageRepository.java`

The repository interface extends `CrudRepository` for managing `Message` entities.

## Configuration

### `CorsConfig.java`

A configuration class enabling Cross-Origin Resource Sharing (CORS) for specific origins.

- Allowed Origins: "http://localhost:3000", "http://127.0.0.1:3000"

### `application.properties`

Configuration properties for the Spring Boot application.

- Database URL: `jdbc:mysql://vm.cloud.cbh.kth.se:2776/ChatbotMessages`
- Database Credentials: Username: `root`, Password: `PASSWORD123`
- Show SQL statements: `true`
- Server Port: `8080`

### `pom.xml`

The Maven project configuration file.

Feel free to use this README as a starting point for your documentation. You can customize it further based on your project requirements.
