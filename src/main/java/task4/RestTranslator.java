package task4;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/translate")
public class RestTranslator {

    private final Map<String, String> dictionary =
            new HashMap<>();

    public RestTranslator() {

        dictionary.put("привіт", "hello");
        dictionary.put("кіт", "cat");
        dictionary.put("собака", "dog");
        dictionary.put("будинок", "house");
        dictionary.put("машина", "car");
        dictionary.put("книга", "book");
        dictionary.put("школа", "school");
        dictionary.put("університет", "university");
        dictionary.put("студент", "student");
        dictionary.put("вчитель", "teacher");
        dictionary.put("друг", "friend");
        dictionary.put("сім'я", "family");
        dictionary.put("вода", "water");
        dictionary.put("їжа", "food");
        dictionary.put("сонце", "sun");
        dictionary.put("місяць", "moon");
        dictionary.put("робота", "work");
        dictionary.put("комп'ютер", "computer");
        dictionary.put("телефон", "phone");
        dictionary.put("дякую", "thank you");
    }

    @GET
    @Path("/{word}")
    @Produces(MediaType.TEXT_PLAIN)
    public String translate(
            @PathParam("word") String word) {

        String result =
                dictionary.get(
                        word.toLowerCase().trim()
                );

        if (result == null) {
            return "Переклад не знайдено";
        }

        return result;
    }
}
