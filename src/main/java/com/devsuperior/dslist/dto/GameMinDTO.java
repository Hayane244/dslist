package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;

public class GameMinDTO {

	private Long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;
	
	//As annotetions foram apagadas pois o DTO não está mapeado com o Banco
	
	GameMinDTO() {
	}

	/** 
	* Construtor que recebe a entidade. Será gerado o GameMinDTO copiando os dados da entidade. Ou seja, será nstansiado o 
	* GameMinDTO a partir de um objeto Game, copiando os dados do Game para o GameMinDTO.
	*/
	public GameMinDTO(Game entity) {
		//Busca o id da entidade e salva no id do DTO
		id = entity.getId();
		title = entity.getTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getLongDescription();
	//Nesse caso não precisa do this pois não há mais ambiguidade. Ou seja, não há um parâmetro com o mesmo nome do campo.
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}
}
