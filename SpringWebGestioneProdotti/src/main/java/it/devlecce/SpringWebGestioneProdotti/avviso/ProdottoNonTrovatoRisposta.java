package it.devlecce.SpringWebGestioneProdotti.avviso;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProdottoNonTrovatoRisposta {

        @ResponseBody
        @ExceptionHandler(ProdottoNonTrovato.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public String UtenteNonTrovato (ProdottoNonTrovato ex) {
            return "Eccezione: " + ex.getMessage();

        }
    }

