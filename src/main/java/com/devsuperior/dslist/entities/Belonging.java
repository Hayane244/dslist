package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//Essa annotetion configura a classe java para que ela seja equivalente a uma tabela do Banco Relacinal
@Entity
//Essa annotetion customiza o nome da Tabela no Banco de dados. 
@Table (name = "tb_belonging")
public class Belonging {
		
	@EmbeddedId
	private BelongingPk id = new BelongingPk();
	
	private Integer position;
	
	public Belonging() {
	}
	//Passando como argumento o Game e o GameList

	public Belonging(Game game, GameList list, Integer position) {
		id.setGame(game);
		id.setList(list);
		this.position = position;
	}
	public void setGame(Game game) {
 		id.setGame(game);
 	}
 
 	public Game getGame() {
 		return id.getGame();
 	}
 
 	public void setList(GameList list) {
 		id.setList(list);
 	}
 
 	public GameList getList() {
 		return id.getList();
 	}
 
 	public Integer getPosition() {
 		return position;
 	}
 
 	public void setPosition(Integer position) {
 		this.position = position;
 	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Belonging other = (Belonging) obj;
		return Objects.equals(id, other.id);
	}
	
}
