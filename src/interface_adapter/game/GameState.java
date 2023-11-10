package src.interface_adapter.game;

public class GameState {

    private String prompt = "";
    private String promptError = null;
    private String history = "";
    private String historyError = null;

    public GameState(GameState copy) {
        prompt = copy.prompt;
        promptError = copy.promptError;

        history = copy.history;
        historyError = copy.historyError;
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

    public String getHistoryError() {
        return historyError;
    }

    public void setHistoryError(String historyError) {
        this.historyError = historyError;
    }

    @Override
    public String toString() {
        return "GameState{" +
               "prompt='" + prompt + '\'' +
                "history='" + history + '\'' +
               '}';
    }
}
