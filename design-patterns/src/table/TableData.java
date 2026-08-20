package table;

import java.util.ArrayList;

public interface TableData<T> {
    void print(ArrayList<T> lista, boolean alignRight, String theme);
}
