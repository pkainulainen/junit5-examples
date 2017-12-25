package net.petrikainulainen.junit5;

final class Message {

    private final String message;

    Message(String message) {
        this.message = message;
    }

    String getMessage() {
        return message;
    }
}
