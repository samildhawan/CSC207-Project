package src.interface_adapter.create_player;

public class CreatePlayerState {

    private String classes = "";
    private String classesError = null;
    private String prompt = "";
    private String promptError = null;
    private String history = "";
    private String historyError = null;

    public CreatePlayerState(CreatePlayerState copy){
        classes = copy.classes;
        classesError = copy.classesError;
        prompt = copy.prompt;
        promptError = copy.promptError;
        history = copy.history;
        historyError = copy.historyError;
    }
    public CreatePlayerState(){}

    public String getClasses() {
        return prompt;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getClassesError() {
        return classesError;
    }

    public void setClassesError(String classesError) {
        this.classesError = classesError;
    }
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
        return "CreatePlayerState{" +
                "classes'" + classes + '\'' +
                "prompt='" + prompt + '\'' +
                "history='" + history + '\'' +
                '}';
    }



}
