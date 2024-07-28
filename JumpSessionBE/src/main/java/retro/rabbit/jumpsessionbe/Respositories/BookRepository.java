package retro.rabbit.jumpsessionbe.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import retro.rabbit.jumpsessionbe.Models.Book;

@Repository
public interface BookRepository  extends JpaRepository<Book, Long> {
}
