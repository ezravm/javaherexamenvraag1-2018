package edu.ap.spring.model;

import edu.ap.spring.jpa.Quote;
import edu.ap.spring.jpa.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

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
        String[] s = new String[9];
        int i = 0;
        Iterable<Quote> iterable = repository.findAll();
        for (Quote q : iterable) {
            s[i] = q.getQuote();
            i++;
        }
        return s;
    }

    public ArrayList<Quote> getSearchedQuote(String zoekwoord)
    {

        return repository.findAllByQuoteContaining(zoekwoord);


    }
}
