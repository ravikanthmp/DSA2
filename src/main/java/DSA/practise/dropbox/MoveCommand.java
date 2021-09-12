package DSA.practise.dropbox;

public class MoveCommand implements Command {
    private final String backup;
    private int distance;
    private Editor editor;

    public MoveCommand(Editor editor, int distance) {

        this.editor = editor;
        this.backup = editor.getText();
        this.distance = distance;
    }

    @Override
    public void execute() {
        int oldCursor = editor.getCursor();
        int newCursor = oldCursor + distance;
        if (newCursor < 0){
            newCursor = 0;
        }else if (newCursor >= editor.getText().length()){
            newCursor = editor.getText().length() - 1;
        }
        editor.setCursor(newCursor);
    }

    @Override
    public void undo() {
        editor.setText(this.backup);
    }
}
