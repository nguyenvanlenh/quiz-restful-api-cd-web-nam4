package com.nlu.model.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="exam_numbers")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ExamNumber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="exam_id")
	private Exam exam;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "examnumber_ques",
	joinColumns = @JoinColumn(name = "examnumber_id"),
	inverseJoinColumns = @JoinColumn(name = "question_id"))
	private Set<Question> listQuestions;
	
	@OneToMany(mappedBy = "examNumber")
	private Set<WorkTime> listWorkTimes;
}
