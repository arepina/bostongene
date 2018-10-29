import javafx.util.Pair;

import java.util.ArrayList;

class Memory {

    private ArrayList<Pair<String, Integer>> numbers;

    Memory(){
        numbers = new ArrayList<>();
    }

    void addNumber(String str, int value) {
        numbers.add(new Pair<>(str, value));
    }

    void removeNumber(Pair<String, Integer> minimum) {
        numbers.remove(minimum);
    }

    void removeAll() {
        numbers = new ArrayList<>();
    }

    int getCount() {
        return numbers.size();
    }

    Pair<String, Integer> getMinimum() {
        if(numbers.size() == 0)
            return null;
        numbers.sort((o1, o2) -> {
            Integer firstValue = o1.getValue();
            Integer secondValue = o2.getValue();
            return firstValue.compareTo(secondValue);
        });
        return numbers.get(0);
    }


}
