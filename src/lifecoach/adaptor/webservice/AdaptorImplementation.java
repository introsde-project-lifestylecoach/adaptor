package lifecoach.adaptor.webservice;

import lifecoach.adaptor.model.Bmi;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import javax.jws.WebService;

import org.json.JSONObject;


//Service Implementation

@WebService(endpointInterface = "lifecoach.adaptor.webservice.Adaptor",
    serviceName="AdaptorService")
public class AdaptorImplementation implements Adaptor 
{	
	/* Manage Bmi*/	
	
    @Override
    public Bmi getBmi(float weight, float height, char sex, int age, float waist, float hip) 
    {    	
        int status;
		String body, result;
		Bmi bmi = new Bmi();
		
		System.out.println("Calcolate Bmi with: weight=" + weight + ", height=" + height + ", sex=" + sex
       		 + ", age=" + age + ", waist=" + waist + ", hip=" + hip);
		
		HttpResponse<JsonNode> response = null;
		
		try 
		{
			response = Unirest.post("https://bmi.p.mashape.com/")
			.header("X-Mashape-Key", "gEcJjJULFamshzRxpXpjKxV9heIBp11R29LjsnqYbdrYR10Dfs")
			.header("Content-Type", "application/json")
			.header("Accept", "application/json")
			.body("{\"weight\":{\"value\":\"" + weight + "\",\"unit\":\"kg\"},"
					+ "\"height\":{\"value\":\"" + height + "\",\"unit\":\"cm\"},"
					+ "\"sex\":\"" + sex + "\",\"age\":\"" + age + "\","
					+ "\"waist\":\"" + waist + "\",\"hip\":\"" + hip + "\"}")
			.asJson();
		} 
		catch (UnirestException e) 
		{
			// TODO Handle the exception
			e.printStackTrace();
		}
		
		if(response != null)
		{
			status = response.getStatus();		
			
			result = (status == 200 || status == 201 || status == 202 ? "OK" : "ERROR");		
			System.out.println("--> Result: " + result);
			
			
			body = response.getBody().toString();
			System.out.println(body);
			JSONObject jsonObject = new JSONObject(body);
			bmi.setIdeal_weight(jsonObject.getString("ideal_weight"));
	        JSONObject jsonBmi = jsonObject.getJSONObject("bmi");
	        bmi.setBmi_value(jsonBmi.getDouble("value"));
	        bmi.setBmi_status(jsonBmi.getString("status"));
	        bmi.setBmi_risk(jsonBmi.getString("risk"));
	        JSONObject jsonBmr = jsonObject.getJSONObject("bmr");
	        bmi.setBmr_value(jsonBmr.getDouble("value"));
	        JSONObject jsonWhr = jsonObject.getJSONObject("whr");
	        bmi.setWhr_status(jsonWhr.getString("status"));
	        
	        return bmi;
		}
		
        return null;
    }
}