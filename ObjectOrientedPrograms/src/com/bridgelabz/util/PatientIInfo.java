package com.bridgelabz.util;

public class PatientIInfo {

	private String patientName;
	private String patientId;
	private String patientMobile;
	
	public PatientIInfo() {
		
	}

	public PatientIInfo(String patientName, String patientId, String patientMobile) {
		super();
		this.patientName = patientName;
		this.patientId = patientId;
		this.patientMobile = patientMobile;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientMobile() {
		return patientMobile;
	}

	public void setPatientMobile(String patientMobile) {
		this.patientMobile = patientMobile;
	}
	
}
