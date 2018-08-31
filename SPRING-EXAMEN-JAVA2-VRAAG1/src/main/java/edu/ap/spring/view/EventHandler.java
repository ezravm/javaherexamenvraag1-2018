package edu.ap.spring.view;

import edu.ap.spring.model.QuoteApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.event.ActionEvent;

@Service
public class EventHandler {

    @Autowired
    private UI ui;
    private QuoteApp quoteapp;

    public void whenSaveButtonClicked(ActionEvent actionevent)
    {
        quoteapp.saveAllQuotes();
    }

}
