package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Agora entra a questão da ORM (Mapeamento Objeto Relacional). Para mapear um objeto game, 
 * para que ele vire um registro na tabela de games do Banco de Dados Relacional, é preciso
 * fazer algumas configurações. 
 * Em cima no nome da clase utilize a annotetion @Entity
 */

@Entity
//Essa annotetion configura a classe java para que ela seja equivalente a uma tabela do Banco Relacinal
@Table (name = "tb_game")
//Essa annotetion customiza o nome da Tabela no Banco de dados. O nome será tb_game

//Classe que vai representar um jogo
public class Game {
	
//Atributos de um game
	
	//Customizando o id como sendo chave primária:
	@Id
	//Para que esse id seja auto incrementado pelo Banco de Dados:
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	//IDENTITY é uma forma que ele vai indicar para o Banco gerar o id
	private Long id;
	private String title;
	
	/**year é m palavra reservada do Banco de Dados. Essa palavra pode causar
	* probema ao gerar o Banco de Dados do modelo Relacional com a JPA
	*/
	@Column(name = "game_year")
	private Integer year;
	private String genre;
	private String platforms;
	private Double score;
	private String imgUrl;
	
	@Column(columnDefinition = "TEXT")
	private String shortDescription;
	
	/**O valor que foi colocado na coluna longDescription é um valor muito grande. São muitos caracteres, e por isso 
	 * esse campo não pode ser uma String do Java. Embora a String aceite um valor alto, se não for colocado nada 
	 * no seu mapeamento a JPA entende que essa String será mapeada para um campo no Banco de Dadoscom até 255 caracteres.
	*  
	* Nesse caso é preciso colocar uma instrução para que a JPA na hora de gerar o Banco, 
	* gere esse campo como sendo um texto, e não um VARCHAR 255. Para isso é utilizado a annotetion @Column.
	*/
	@Column(columnDefinition = "TEXT")
	private String longDescription;
	
	// Construtor Game sem argumentos
	public Game () {
	}
	
	/**
	* Construtor com argumentos, para ter a possibilidade de instanciar um game 
	* já passando os argumentos para ele 
	*/
	public Game(Long id, String title, Integer year, String genre, String platforms, Double score, String imgUrl,
			String shortDescription, String longDescription) {
		
		/**
		* Palavra "this" referência o dado do próprio objeto. 
		* O primeiro id é o dado do objeto. O segundo id é o argumento que chegou no método.
		* Ou seja: O id do objeto recebe o id do método. 
		*/
		
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.platforms = platforms;
		this.score = score;
		this.imgUrl = imgUrl;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}
	
	//Métodos Getters e Setters dos atributos
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlatforms() {
		return platforms;
	}

	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	//Métodos Equals e HashCode para comparar dois games. Se eles são iguais ou não, utilizando o id
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
		Game other = (Game) obj;
		return id == other.id;
	}
	
	
	
}