package com.meryem.films.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
public class Film {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long idFilm;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nomFilm;
	
	@Min(value = 10)
	@Max(value = 10000)
	private Double prixFilm;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateCreation;
	
	@ManyToOne
	private Categorie categorie;
	
	public Film() 
	{
		super();
	}
	
	
	public Film(String nomFilm, Double prixFilm, Date dateCreation) {
		super();
		this.nomFilm = nomFilm;
		this.prixFilm = prixFilm;
		this.dateCreation = dateCreation;
	}


	public Long getIdFilm() {
		return idFilm;
	}
	public void setIdFilm(Long idFilm) {
		this.idFilm = idFilm;
	}
	public String getNomFilm() {
		return nomFilm;
	}
	public void setNomFilm(String nomFilm) {
		this.nomFilm = nomFilm;
	}
	public Double getPrixFilm() {
		return prixFilm;
	}
	public void setPrixFilm(Double prixFilm) {
		this.prixFilm = prixFilm;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	@Override
	public String toString() {
		return "Film [idFilm=" + idFilm + ", nomFilm=" + nomFilm + ", prixFilm=" + prixFilm + ", dateCreation="
				+ dateCreation + "]";
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
}
