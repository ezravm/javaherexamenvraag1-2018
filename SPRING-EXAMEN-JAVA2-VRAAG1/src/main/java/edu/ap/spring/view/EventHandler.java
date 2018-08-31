package edu.ap.spring.view;

import edu.ap.spring.model.QuoteApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.event.ActionEvent;

@Service
public class EventHandler {


    private UI ui;
    private QuoteApp quoteapp;

    @Autowired
    public void setUI(UI ui) {this.ui = ui;}

    @Autowired
    public void setQuoteapp(QuoteApp quoteapp) {
        this.quoteapp = quoteapp;
    }

    public void whenSaveButtonClicked(ActionEvent actionEvent)
    {
        quoteapp.saveAllQuotes();
    }

    public void whenGetButtonClicked(ActionEvent actionEvent)
    {
        String[] s = quoteapp.getAllQuotes();
        for (int i = 0;i < s.length -1;i++)
        {
            ui.getAllequotes().append(s[i]);
        }
    }

}
