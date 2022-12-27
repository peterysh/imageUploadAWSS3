package toy.imageS3.upload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toy.imageS3.upload.domain.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
