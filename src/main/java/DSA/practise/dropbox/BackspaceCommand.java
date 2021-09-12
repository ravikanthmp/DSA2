package DSA.practise.dropbox;

public class BackspaceCommand implements Command{

    Editor editor;
    private final String backup;

    public BackspaceCommand(Editor editor) {
        this.editor = editor;
        this.backup = editor.getText();
    }

    @Override
    public void execute() {
        if (editor.getText().length() > 0){
            String original = editor.getText();
            String newText = original.substring(0, original.length() -1);
            editor.setText(newText);
            editor.setCursor(editor.getText().length() - 1);

        }
    }

    @Override
    public void undo() {
        editor.setText(this.backup);
    }
}
