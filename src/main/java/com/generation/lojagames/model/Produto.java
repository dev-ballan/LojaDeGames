package com.generation.lojagames.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // GERAR UMA TABELA
@Table( name = "tb_produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT -- TRANSFERE A RESPONSABILIDADE DA GERAÇÃO DA CHAVE PARA O BD
	private Long id;
	
	@NotBlank(message = "O atributo Nome é Obrigatório e não pode utilizar espaços em branco!")
	@Size(min = 5, max = 100, message = "O atributo Nome deve conter no minimo 05 e no máximo 100 caracteres!")
	private String nome;
	
	@NotNull(message = "O atributo Descricao é Obrigatório!")
	@Size(min = 10, max = 1000, message = "O atributo Descricao deve conter no minimo 10 e no máximo 1000 caracteres!")
	private String descricao;
	
	@NotBlank(message = "O atributo console é Obrigatório e deve ser informado o tipo")
	private String console;
	
	private int quantidade;
	
	// @NotBlank(message = "O atributo Preco é Obrigatório e não pode utilizar espaços em branco!")
	@Digits(integer = 3, fraction = 2)
	private BigDecimal preco;
	
	private String foto;
	
	@NotNull(message = "O atributo Ano de Lancamento deve ser informado")
	private int anoLancamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	@ManyToOne
	@JsonIgnoreProperties("produto")
	 private Categoria categoria;

	

	
}
