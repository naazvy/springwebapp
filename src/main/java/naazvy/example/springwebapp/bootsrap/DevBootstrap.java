package naazvy.example.springwebapp.bootsrap;

import naazvy.example.springwebapp.model.Author;
import naazvy.example.springwebapp.model.Book;
import naazvy.example.springwebapp.repositories.AuthorRepositories;
import naazvy.example.springwebapp.repositories.BookRepositories;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepositories authorRepositories;
    private BookRepositories bookRepositories;

    public DevBootstrap(AuthorRepositories authorRepositories, BookRepositories bookRepositories) {
        this.authorRepositories = authorRepositories;
        this.bookRepositories = bookRepositories;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Author fowler = new Author("Martin", "Fowler");
        Book peaa = new Book("Patterns of Enterprise Application Architecture",
                "ISBN-13 978-0321127426",
                "Addison-Wesley Professional; 1 edition (November 15, 2018)");
        peaa.getAuthors().add(fowler);
        authorRepositories.save(fowler);
        bookRepositories.save(peaa);


        Author martin = new Author("Robert C.","Martin");
        Book uncleBob = new Book("UML for Java Programmers",
                "ISBN-10: 0131428489",
                "Prentice Hall; 01 edition (27 May 2003)");
        uncleBob.getAuthors().add(martin);
        authorRepositories.save(martin);
        bookRepositories.save(uncleBob);
    }


}
