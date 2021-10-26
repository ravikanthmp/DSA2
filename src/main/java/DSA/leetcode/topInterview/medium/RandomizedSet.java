package DSA.leetcode.topInterview.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

    Map<Integer, Integer> elementToIndex;
    ArrayList<Integer> indexToElement;

    public RandomizedSet() {
       elementToIndex = new HashMap<>();
       indexToElement = new ArrayList();
    }

    public boolean insert(int val) {
        if (elementToIndex.containsKey(val)){
            return false;
        }else {
            indexToElement.add(val);
            elementToIndex.put(val, indexToElement.size() - 1);
            return true;
        }
    }

    public boolean remove(int val) {
        if (!elementToIndex.containsKey(val)){
            return false;
        }else {
            int idx = elementToIndex.get(val);
            swap(elementToIndex, indexToElement, idx, indexToElement.size() - 1);
            elementToIndex.remove(val);
            indexToElement.remove(indexToElement.size() - 1);
            return true;
        }
    }

    private void swap(Map<Integer, Integer> elementToIndex, ArrayList<Integer> list, int i, int j){
        elementToIndex.put(list.get(j), i);
        elementToIndex.put(list.get(i), j);

        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public int getRandom() {
        int size = indexToElement.size();
        Random random = new Random();
        int idx = random.nextInt(size);
        return indexToElement.get(idx);
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(3);
        randomizedSet.remove(3);
        randomizedSet.remove(0);
        randomizedSet.insert(3);
        randomizedSet.getRandom();
        randomizedSet.remove(0);
    }
}
