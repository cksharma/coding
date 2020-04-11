package ElectionComission;

import java.io.Serializable;

public class Voters implements Serializable
{
	private String voterName;
	private String gender;
	private DOB dob;
	Voters(String voterName, String gender, DOB dob)
	{
		this.voterName = voterName;
		this.gender = gender;
		this.dob = dob;
	}
	
	
	
	public String getVoterName() {
		return voterName;
	}



	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getDob() {
		return dob.toString();
	}



	public void setDob(DOB dob) {
		this.dob = dob;
	}



	@Override
	public String toString() 
	{
		return "[ VoterName =  " + voterName + ",   Gender = " + gender + ",   dob = " + dob.toString() + "]";
	}
}
