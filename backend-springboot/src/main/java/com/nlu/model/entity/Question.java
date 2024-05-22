package com.nlu.model.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "questions")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name_question")
	private String nameQuestion;

	@OneToMany(mappedBy = "question",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Option> options;
	@JsonIgnore
	@ManyToMany(mappedBy = "listQuestions", fetch = FetchType.EAGER)
    private Set<ExamNumber> listExamNumbers;
	
	public Question(Long id, String nameQuestion, Set<Option> options) {
	    this.id = id;
	    this.nameQuestion = nameQuestion;
	    this.options = options;
	}
	
	
	
}
