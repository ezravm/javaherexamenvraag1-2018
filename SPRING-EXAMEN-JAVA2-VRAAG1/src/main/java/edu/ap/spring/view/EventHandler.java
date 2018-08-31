package edu.ap.spring.view;

import edu.ap.spring.jpa.Quote;
import edu.ap.spring.model.QuoteApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

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
            ui.getAllequotes().append("alle quotes zijn opgelagen. \n");
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
            ui.getAllequotes().append(s[i] + "\n");
        }
    }

    public void whenSearchButtonClicked(ActionEvent actionEvent)
    {
        String zoekwoord = ui.getZoekwoord().getText();
        ArrayList<Quote> q = quoteapp.getSearchedQuote(zoekwoord);
        for (Quote a: q ) {
            ui.getAllequotes().append(a.getQuote() + "\n");
        }
        }

    }


