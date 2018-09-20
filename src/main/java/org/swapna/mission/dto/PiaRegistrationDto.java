package org.swapna.mission.dto;

public class PiaRegistrationDto {
	
	protected String PIAName;
	protected int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPIAName() {
		return PIAName;
	}

	public void setPIAName(String pIAName) {
		PIAName = pIAName;
	}

	@Override
	public String toString() {
		return "PiaRegistrationDto [PIAName=" + PIAName + ", id=" + id + "]";
	}



	
	

}
