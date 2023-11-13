package src.use_case.create_player;

public class CreatePlayerInputData {

    final private String prompt;

    public CreatePlayerInputData(String prompt){
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }
}
