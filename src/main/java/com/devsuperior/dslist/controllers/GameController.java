package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameService;

//Configura a classe para ser um Controlador
@RestController
//Mapeia o recurso que será chamado de /games. Isso configura o caminho que vai ser respondido na API
@RequestMapping(value = "/games")
public class GameController {
	
	//Injetando uma instancia do GameService dentro do GameController:
		@Autowired
		private GameService gameService;

	
	/*
	 * Como o verbo Get é um endpoint para obter os objetos, é ele que será utilizado. 
	 * Configuração o metódo para Get, com a anootetion @GetMapping:
	 */
	@GetMapping
	//Esse metódo retorna uma lista de games:
	public List<GameMinDTO> findAll ( )  {
		List<GameMinDTO> result = gameService.findAll( );
		return result;
	}
}
