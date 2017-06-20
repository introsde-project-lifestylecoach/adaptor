package lifecoach.adaptor.model;

public class Bmi 
{
	/*
	 * Basal metabolic rate (BMR): is the total number of calories that your body needs to perform basic, life-sustaining functions.
	 * Waist to hip ratio (WHR): is a measurement that compares the size of your waist in inches to the size of your hips in inches. 
	 * 							 Risk for developing heart disease can be estimated using your waist to hip ratio
	 */
	
	double bmi_value, bmr_value;
    String bmi_status, bmi_risk, ideal_weight, whr_status;
	
    public double getBmi_value() {
		return bmi_value;
	}
	
    public void setBmi_value(double bmi_value) {
		this.bmi_value = bmi_value;
	}
		
    public String getBmi_status() {
		return bmi_status;
	}
	
    public void setBmi_status(String bmi_status) {
		this.bmi_status = bmi_status;
	}
	
    public String getBmi_risk() {
		return bmi_risk;
	}
	
    public void setBmi_risk(String bmi_risk) {
		this.bmi_risk = bmi_risk;
	}
	
    public String getIdeal_weight() {
		return ideal_weight;
	}
	
    public void setIdeal_weight(String ideal_weight) {
		this.ideal_weight = ideal_weight;
	}
	
    public double getBmr_value() {
		return bmr_value;
	}
	
    public void setBmr_value(double bmr_value) {
		this.bmr_value = bmr_value;
	}
    
    public String getWhr_status() {
		return whr_status;
	}
	
    public void setWhr_status(String whr_status) {
		this.whr_status = whr_status;
	}    
}
