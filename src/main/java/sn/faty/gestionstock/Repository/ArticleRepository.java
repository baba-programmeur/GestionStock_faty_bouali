package sn.faty.gestionstock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.gestionstock.model.Article;

import java.util.List;

public interface ArticleRepository  extends JpaRepository<Article ,Long> {

   Article findByCodeArticle(String code);

   List<Article> findAllByCategoryId(Long id);

}
