package edu.ap.spring.model;

import edu.ap.spring.jpa.Quote;
import edu.ap.spring.jpa.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

@Component
public class QuoteApp {
    private QuoteRepository repository;

    @Autowired
    public void setQuoteRepository(QuoteRepository quoteRepository) {this.repository = quoteRepository;}


    public void saveAllQuotes()
        throws IOException
    {

        List<String> list = Files.readAllLines((new File("oscar_wilde.txt").toPath()));
        String[] s = list.toArray(new String[0]);
        for (int i = 0;i < (s.length - 1);i++)
        {
            Quote newquote = new Quote(s[i]);
            repository.save(newquote);
        }


    }


    public String[] getAllQuotes() {
        String[] s = null;
        int i = 0;
        Iterable<Quote> iterable = repository.findAll();
        for (Quote q : iterable) {
            s[i] = q.getQuote();
        }
        return s;
    }

    public String getSearchedQuote(String zoekwoord)
    {
        Quote existing = repository.findAllByQuoteContaining(zoekwoord);
        return existing.getQuote();
    }
}
