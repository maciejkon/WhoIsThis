package com.maciew.whoIsThis.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WhoIsThisService {

    private final ChatClient chatClient;

    public WhoIsThisService(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    public static final String WRITE_ME_LIST_OF_SONGS = """
            Write me the list Of song titles for this author:""";

    public ResponseEntity<String> getSongTitles(String authorName) {
        return new ResponseEntity<>(chatClient.prompt()
                .user(WRITE_ME_LIST_OF_SONGS+authorName)
                .call()
                .content()
                , HttpStatus.OK);
    }
}
