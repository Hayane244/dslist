package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

/**
* Diferente do JpaRepository, Service não é um componente do sistema. Com isso é registra-lo utilizando 
* a annotetion @Service. Com isso é injetado dependências de componentes no sistema.
*/
@Service
public class GameService {

	// Implementação da função findAll injetando uma instancia do GameRepository
	// dentro do GameService:
	@Autowired
	private GameRepository gameRepository;

	//Está é uma função que retorna uma lista de GameMinDTO. 
	public List<GameMinDTO> findAll()  {
	/**
	* findall() é um metódo que gera uma consulta no Banco de Dados, para buscar todos os Games. 
    * O resultado da consulta (é uma tabela de games), será convertida para uma 
    * lista de games (List<Game>) e o resultado cai na váriavel result.
	*/
	List<Game> result = gameRepository.findAll();
	/**
	 * Retorna uma lista do tipo GameMinDTO, chamada dto, recebe result.stream. Map indica que todo 
	 * objeto original Game, será um novo objeto, tranforma em GameMinDTO, passando x como argumento. 
	 * .toList() volta esse stream para uma lista normal.
	 */
	return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
}
