package src.interface_adapter.title;

import src.use_case.title.TitleInputBoundary;

public class TitleController {

    final TitleInputBoundary titleInputBoundary;

    public TitleController(TitleInputBoundary titleInputBoundary) {
        this.titleInputBoundary = titleInputBoundary;
    }

    public void execute(String state) {
        titleInputBoundary.execute(state);
    }
}
