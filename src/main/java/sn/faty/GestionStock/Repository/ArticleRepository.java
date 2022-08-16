package sn.faty.GestionStock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.GestionStock.model.Article;

public interface ArticleRepository  extends JpaRepository<Article ,Long> {

   Article findByCodeArticle(String code);
}
