package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.Game;
/**
* Estendendo a interface JpaRepository
* dentro dos simbolos de maior e menor devemos colocar:
* O tipo da entidade e o tipo do id da entidade.
*/
public interface GameRepository extends JpaRepository<Game, Long> {

}