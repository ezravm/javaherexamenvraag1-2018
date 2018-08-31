package edu.ap.spring.model;

import edu.ap.spring.jpa.Quote;
import edu.ap.spring.jpa.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuoteApp {
    private QuoteRepository repository;

    @Autowired
    public void setQuoteRepository(QuoteRepository quoteRepository) {this.repository = quoteRepository}

    private String[] quotes = {"Alas, I am dying beyond my means. (sipping champagne on his deathbed)",
            "As long as war is regarded as wicked, it will always have its  fascination. When it is looked upon as vulgar, it will cease to be popular.",
            "Democracy means simply the bludgeoning of the people by the people for the people.",
            "Fashion is a form of ugliness so intolerable that we have to alter it every six months.",
            "The only way to behave to a woman is to make love to her if she is pretty and to someone else if she is plain.",
            "The only way to get rid of a temptation is to yield to it.",
            "There is only one thing in the world worse than being talked about, and that is not being talked about.",
            "Whenever people agree with me I always feel I must be wrong.",
            "Why was I born with such contemporaries?",
            "Young men want to be faithful and are not; old men want to be faithless and cannot."};


    public void saveAllQuotes() {
        for (int i = 0;i < quotes.length;i++)
        {
            Quote newquote = new Quote(quotes[i]);
            repository.save(newquote);
        }
    }
}
