package edu.ap.spring.view;

import edu.ap.spring.model.QuoteApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

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
        try {
            quoteapp.saveAllQuotes();
        }
        catch (IOException ex) {
            System.out.println(ex);
        }
    }


    public void whenGetButtonClicked(ActionEvent actionEvent)
    {
        String[] s = quoteapp.getAllQuotes();
        for (int i = 0;i < s.length -1;i++)
        {
            ui.getAllequotes().append(s[i]);
        }
    }

    public void whenSearchButtonClicked(ActionEvent actionEvent)
    {

    }

}
