package DSA.practise.dropbox;

public class AppendCommand implements Command{

    private final String toBeAppended;
    Editor editor;
    private final String backup;

    public AppendCommand(Editor editor, String toBeAppended) {
        this.editor = editor;
        this.toBeAppended = toBeAppended;
        this.backup = editor.getText();
    }

    @Override
    public void execute() {
        if (editor.getText() == null || editor.getText().isEmpty()){
            editor.setText(toBeAppended);
        }else {
            String original = editor.getText();
            StringBuilder before = new StringBuilder(original.substring(0, editor.getCursor()));
            StringBuilder after = new StringBuilder(original.substring(editor.getCursor()));
            StringBuilder edited = before.append(toBeAppended).append(after);
            editor.setText(edited.toString());
        }
        editor.setCursor(editor.getText().length() - 1);

    }

    @Override
    public void undo() {
        editor.setText(backup);
    }
}
