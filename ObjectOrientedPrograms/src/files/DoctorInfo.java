package files;

public class DoctorInfo {

	private String docName;
	private String docId;
	private String specialization;
	private String availability;
	
	public DoctorInfo() {
		
	}
	public DoctorInfo(String docName, String docId, String specialization, String availability) {
		super();
		this.docName = docName;
		this.docId = docId;
		this.specialization = specialization;
		this.availability = availability;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
}
