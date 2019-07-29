package excelTask;

public class HelperBean {
	private String policyId;
	private Double bodyMassIndexImperial;
	private Integer HeightFeet;
	private Integer heightInches;
	private Integer weightPounds;
	public Integer getWeightPounds() {
		return weightPounds;
	}
	public void setWeightPounds(Integer weightPounds) {
		this.weightPounds = weightPounds;
	}
	public String getPolicyId() {
		return policyId;
	}
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	public Double getBodyMassIndexImperial() {
		return bodyMassIndexImperial;
	}
	public void setBodyMassIndexImperial(Double bodyMassIndexImperial) {
		this.bodyMassIndexImperial = bodyMassIndexImperial;
	}
	public Integer getHeightFeet() {
		return HeightFeet;
	}
	public void setHeightFeet(Integer heightFeet) {
		HeightFeet = heightFeet;
	}
	public Integer getHeightInches() {
		return heightInches;
	}
	public void setHeightInches(Integer heightInches) {
		this.heightInches = heightInches;
	}
	@Override
	public String toString() {
		return "HelperBean [policyId=" + policyId + ", bodyMassIndexImperial=" + bodyMassIndexImperial + ", HeightFeet="
				+ HeightFeet + ", heightInches=" + heightInches + ", weightPounds=" + weightPounds + "]";
	}
	
	
	

}
