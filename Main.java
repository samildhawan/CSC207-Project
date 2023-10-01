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

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        String prompt = "Translate 'Hello, World!' into french";

        String jsonInput =
                "{\n" +
                        "     \"model\": \"gpt-3.5-turbo\",\n" +
                        "     \"messages\": [{\"role\": \"user\", \"content\": \"" + prompt + "\"}],\n" +
                        "     \"temperature\": 0.7\n" +
                        "   }";

        RequestBody requestBody = RequestBody.create(MediaType.get("application/json; charset=utf-8"), jsonInput);

        Request request = new Request.Builder()
                .url(String.format(API_URL))
                .addHeader("Authorization", "Bearer " + API_TOKEN)
                .addHeader("Content-Type", "application/json")
                .post(requestBody).build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
