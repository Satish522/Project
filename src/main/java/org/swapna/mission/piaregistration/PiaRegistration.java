package org.swapna.mission.piaregistration;

public class PiaRegistration {
	
	protected String piaName;
	protected int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPiaName() {
		return piaName;
	}

	public void setPiaName(String piaName) {
		this.piaName = piaName;
	}

	@Override
	public String toString() {
		return "PiaRegistrationBo [PIAName=" + piaName + ", id=" + id + "]";
	}





}
