package org.iii.domain;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Treatment {

	private final DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-mm-dd");
	private final DateTimeFormatter timeformat = DateTimeFormatter.ofPattern("H:mm");


	private LocalDate date;
	private LocalTime time;

	private Patient patient;
	private Physician physician;

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTime() {
		if(this.time !=null){
			return timeformat.format(this.time);
		}else{
			return "Error Date";
		}
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Physician getPhysician() {
		return physician;
	}

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}

}
