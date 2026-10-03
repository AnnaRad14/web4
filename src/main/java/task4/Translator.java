package task4;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Translator {

    @WebMethod
    String translate(String word);
}