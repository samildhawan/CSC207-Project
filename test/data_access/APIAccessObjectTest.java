package test.data_access;

import org.junit.Test;
import src.data_access.APIAccessObject;

import java.util.ArrayList;

public class APIAccessObjectTest {

    /*
    - Start a game, save, quit it, check for files

    - How to test ChatGPT server request?
    A:
     */

    // Test that ChatGPT server requests work
    @Test
    public void testChatGPT() {
        APIAccessObject api = new APIAccessObject();

        api.addSystemPrompt("You are a helpful assistant.");

        api.addUserPrompt("Where was it played?");

        String response = api.runChatGPT().get(0).getMessage().getContent();

        assert(!response.isEmpty());
    }


    @Test
    public void testChatGPTHistory() {
        APIAccessObject api = new APIAccessObject();

        // Test that it fails without history
        api.addSystemPrompt("You are a helpful assistant.");

        api.addUserPrompt("Where was it played?");

        String response = api.runChatGPT().get(0).getMessage().getContent();

        assert(!response.contains("Global Life"));

        api.clearMessages();

        // Test that it passes with history
        api.addSystemPrompt("You are a helpful assistant.");

        ArrayList<String[]> history = new ArrayList<String[]>();
        history.add(new String[]{"Who won the world series in 2020?", "The Los Angeles Dodgers won the World Series."});

        api.addHistory(history);

        api.addUserPrompt("Where was it played?");

        response = api.runChatGPT().get(0).getMessage().getContent();

        assert(response.toLowerCase().contains("globe life"));
    }

}
