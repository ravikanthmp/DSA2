package DSA.practise.dropbox;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Editor {
    private String text;
    private Selection selection;
    private int cursor;

    public Editor() {
        this.text = "";
        this.cursor = 0;
    }

    public Selection getSelection() {
        return selection == null ? Selection.of(cursor, cursor) : selection;
    }

    public boolean deleteSelection() {
        return false;
    }

    public void replaceSelection(String replacement) {
        Selection selection = getSelection();
        StringBuilder before = new StringBuilder(text.substring(0,
                Math.min(text.length(), selection.getStart())));
        StringBuilder after = selection.getEnd() < text.length() ? new StringBuilder(text.substring(selection.getEnd())) : new StringBuilder();
        StringBuilder between = new StringBuilder(replacement);
        this.text = before.append(between).append(after).toString();
        this.cursor = this.text.length() - 1;
        this.selection = null;
    }

    public void setSelection(int start, int end) {
        this.selection = Selection.of(start, end);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }

    public int getCursor() {
        return cursor;
    }

    public String[] textEditor1_2(String[][] queries) {

        Editor editor = new Editor();
        List<String> results = new ArrayList();
        for (String[] query : queries) {
            String command = query[0];


            if (command.equals("APPEND")) {
                String val = query[1];
                Command append = new AppendCommand(editor, val);
                append.execute();
            }else if (command.equals("BACKSPACE")){
                Command backspace = new BackspaceCommand(editor);
                backspace.execute();
            }else if (command.equals("MOVE")){
                String val = query[1];
                Command move = new MoveCommand(editor, Integer.parseInt(val));
                move.execute();
            }
            results.add(editor.getText());
        }
        String[] res = new String[results.size()];
        return results.toArray(res);
    }

    public static void main(String[] args) {
        Editor editor = new Editor();


        String[][] queries =
                {{"APPEND","Never give up"},
                        {"MOVE","12"},
                        {"APPEND","!"},
                        {"MOVE","11"},
                        {"APPEND","!"},
                        {"MOVE","10"},
                        {"APPEND","!"},
                        {"MOVE","9"},
                        {"APPEND","!"},
                        {"MOVE","8"},
                        {"APPEND","!"},
                        {"MOVE","7"},
                        {"APPEND","!"},
                        {"MOVE","6"},
                        {"APPEND","!"},
                        {"MOVE","5"},
                        {"APPEND","!"},
                        {"MOVE","4"},
                        {"APPEND","!"},
                        {"MOVE","3"},
                        {"APPEND","!"},
                        {"MOVE","2"},
                        {"APPEND","!"},
                        {"MOVE","1"},
                        {"APPEND","!"}};



        for (String s : editor.textEditor1_2(queries)) {
            System.out.println(s);
        }

    }


}
