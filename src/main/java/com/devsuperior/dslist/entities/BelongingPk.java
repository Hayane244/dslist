package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class BelongingPk {
	
	//Annotetion Muitos para Um:
	@ManyToOne
	//Configurando o nome da chave primária:
	@JoinColumn(name = "game_id")
	//Referência a Game.
	private Game game;

	@ManyToOne
	@JoinColumn(name = "list_id")
	//Referência a GameList.
	private GameList list;
	
	public BelongingPk() {
	}

	public BelongingPk(Game game, GameList list) {
		this.game = game;
		this.list = list;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameList getList() {
		return list;
	}

	public void setList(GameList list) {
		this.list = list;
	}

	@Override
	public int hashCode() {
		return Objects.hash(game, list);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPk other = (BelongingPk) obj;
		return Objects.equals(game, other.game) && Objects.equals(list, other.list);
	}

	
}
