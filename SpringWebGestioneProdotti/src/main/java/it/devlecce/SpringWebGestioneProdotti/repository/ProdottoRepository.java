package it.devlecce.SpringWebGestioneProdotti.repository;

import it.devlecce.SpringWebGestioneProdotti.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {
}
