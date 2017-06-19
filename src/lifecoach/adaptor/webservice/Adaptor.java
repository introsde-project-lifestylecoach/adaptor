package lifecoach.adaptor.webservice;

import lifecoach.adaptor.model.Bmi;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface Adaptor 
{
	/* Bmi */
    
	@WebMethod(operationName="getBmi")
    @WebResult(name="bmi") 
    public Bmi getBmi(@WebParam(name="weight") float weight, @WebParam(name="height") float height, 
    		@WebParam(name="sex") char sex, @WebParam(name="age") int age,
    		@WebParam(name="waist") float waist, @WebParam(name="hip") float hip);
}
