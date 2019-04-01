package naazvy.example.springwebapp.bootsrap;

import naazvy.example.springwebapp.model.Author;
import naazvy.example.springwebapp.model.Book;
import naazvy.example.springwebapp.model.Publisher;
import naazvy.example.springwebapp.repositories.AuthorRepositories;
import naazvy.example.springwebapp.repositories.BookRepositories;
import naazvy.example.springwebapp.repositories.PublisherRepositories;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepositories authorRepositories;
    private BookRepositories bookRepositories;
    private PublisherRepositories publisherRepositories;

    public DevBootstrap(AuthorRepositories authorRepositories, BookRepositories bookRepositories, PublisherRepositories publisherRepositories) {
        this.authorRepositories = authorRepositories;
        this.bookRepositories = bookRepositories;
        this.publisherRepositories = publisherRepositories;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Publisher publisher1 = new Publisher();
        publisher1.setName("Addison-Wesley Professional; 1 edition (November 15, 2018)");
        publisherRepositories.save(publisher1);

        Author fowler = new Author("Martin", "Fowler");
        Book peaa = new Book("Patterns of Enterprise Application Architecture",
                "ISBN-13 978-0321127426",
                publisher1);
        peaa.getAuthors().add(fowler);
        authorRepositories.save(fowler);
        bookRepositories.save(peaa);


        Publisher publisher2 = new Publisher();
        publisher2.setName("Prentice Hall; 01 edition (27 May 2003)");
        publisherRepositories.save(publisher2);

        Author martin = new Author("Robert C.","Martin");
        Book uncleBob = new Book("UML for Java Programmers",
                "ISBN-10: 0131428489",
                publisher2);
        uncleBob.getAuthors().add(martin);
        authorRepositories.save(martin);
        bookRepositories.save(uncleBob);
    }


}
