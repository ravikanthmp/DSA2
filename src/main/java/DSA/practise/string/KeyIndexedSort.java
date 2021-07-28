package DSA.practise.string;

public class KeyIndexedSort {

    public static String sort(String s){
        char[] chars = s.toCharArray();
        sort(chars);
        return new String(chars);
    }
    public static void sort(char[] a){
        int R = 256; // Extended ASCII
        int[] count = new int[R + 1];
        char[] aux = new char[a.length];
        for (int i = 0; i < a.length; i++) {
            count[a[i] + 1]++;
        }
        // cum sum
        for (int i = 0; i < R - 1; i++) {
            count[i + 1] += count[i];
        }

        // copy
        for (int i = 0; i < a.length; i++) {
            aux[count[a[i]]++] = a[i];
        }

        // copy aux to a
        for (int i = 0; i < a.length; i++) {
                a[i] = aux[i];
        }

    }

    public static void main(String[] args) {
        String s = "vonsovnsdlknlxacvlvls    wbfnslofwnancldn";
        String sort = KeyIndexedSort.sort(s);
        System.out.println(sort);


    }
}
