package DSA.practise.dropbox;

public class Selection {
    private int start;
    private int end;

    private Selection(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static Selection of(int start, int end){
        return new Selection(start, end);
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
