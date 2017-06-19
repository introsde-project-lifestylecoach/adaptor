package lifecoach.adaptor.model;

public class Bmi 
{
	char sex;
	int age;
	float weight, height, waist, hip;
	
	public Bmi(char sex, int age, float weight, float height, float waist, float hip) {
		super();
		this.sex = sex;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.waist = waist;
		this.hip = hip;
	}
}
