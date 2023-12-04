package src.interface_adapter.game;

public class GameState {

    private String prompt = "";
    private String promptError = null;
    private String history = "";

    public GameState(GameState copy) {
        prompt = copy.prompt;
        promptError = copy.promptError;

        history = copy.history;
    }

    public GameState() {}

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getPromptError() {
        return promptError;
    }

    public void setPromptError(String promptError) {
        this.promptError = promptError;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
