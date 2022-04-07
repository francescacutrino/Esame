package it.devlecce.SpringWebGestioneProdotti.repository;

import it.devlecce.SpringWebGestioneProdotti.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {
    List<Prodotto> findByDataacquistoBetween(Date datada, Date dataa);
    List<Prodotto> findByDatascadenzaBetween(Date datada, Date dataa);
    List<Prodotto> findByNome(String nome);
}
