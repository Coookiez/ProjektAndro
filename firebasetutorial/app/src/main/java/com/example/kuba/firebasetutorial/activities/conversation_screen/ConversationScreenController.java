package com.example.kuba.firebasetutorial.activities.conversation_screen;

import android.content.Intent;

import com.example.kuba.firebasetutorial.Message;
import com.example.kuba.firebasetutorial.activities.write_new_message_screen.WriteNewMessageScreenView;

import java.util.ArrayList;


class ConversationScreenController {
    private ConversationScreenView view;
    private ConversationScreenModel model;
    ArrayList<Message> messages;
    String login;
    private String uid;
    private long messageCount;

    ConversationScreenController(ConversationScreenView view) {
        this.view = view;
        this.model = new ConversationScreenModel();
        login = view.getIntent().getStringExtra("LOGIN");
        uid = view.getIntent().getStringExtra("USERID");
        messageCount = view.getIntent().getLongExtra("MESSAGECOUNT", -1);
        messages = new ArrayList<>();
    }

    void startNewWriteMessageActivity() {
        Intent intent = new Intent(view, WriteNewMessageScreenView.class);
        intent.putExtra("USERID", uid);
        intent.putExtra("LOGIN", login);
        intent.putExtra("RECIPENTNAME", messages.get(0).getFromName().equals(login) ? messages.get(0).getToName() : messages.get(0).getFromName());
        intent.putExtra("MESSAGECOUNT", messageCount);
        view.startActivity(intent);
    }

    void setMessages() {
        ArrayList<Message> received = (ArrayList<Message>) view.getIntent().getSerializableExtra("MESSAGESRECEIVED");
        ArrayList<Message> sent = (ArrayList<Message>) view.getIntent().getSerializableExtra("MESSAGESSENT");
        model.setMessages(received, sent, messages);
    }
}
