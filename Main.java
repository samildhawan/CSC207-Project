import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import okhttp3.*;

public class Main {

    // Example of field to send.
    /*
    curl https://api.openai.com/v1/chat/completions \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer $OPENAI_API_KEY" \
  -d '{
     "model": "gpt-3.5-turbo",
     "messages": [{"role": "user", "content": "Say this is a test!"}],
     "temperature": 0.7
   }'
     */

    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    // load API_TOKEN from env variable.
    private static final String API_TOKEN = System.getenv("API_TOKEN");

    public static String getApiToken() {
        return API_TOKEN;
    }

    public static void main(String[] args) {
        OpenAiService service = new OpenAiService(getApiToken());
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt("Give me a D&D monster and its stats and abilities in full")
                .model("davinci-002")
                .echo(true)
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
