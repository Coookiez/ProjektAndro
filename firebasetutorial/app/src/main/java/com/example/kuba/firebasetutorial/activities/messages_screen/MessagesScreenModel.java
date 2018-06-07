package com.example.kuba.firebasetutorial.activities.messages_screen;

import com.example.kuba.firebasetutorial.Message;
import com.example.kuba.firebasetutorial.database.Database;
import com.example.kuba.firebasetutorial.database.FireDatabase;

import java.util.ArrayList;
import java.util.Map;

class MessagesScreenModel {

    private final static Database db = FireDatabase.getInstance();
    private MessagesScreenController controller;

    MessagesScreenModel(MessagesScreenController controller) {
        this.controller = controller;
    }

    void getUsersMessages(String uid, final String login, String direction, final Map<String, ArrayList<Message>> userMessages) {
        db.getUsersMessages(controller.view, uid, direction, login, userMessages);
    }
}
