package com.aston.utils;

import com.aston.datatypes.enums.SortingMode;

import java.util.List;

public abstract class SearchEngine {
    public static <T extends Comparable<T>> int search(List<T> list, T key, SortingMode mode) {
        SortingEngine.sort(list, mode);

        int low = 0;
        int high = list.size() - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            T midVal = list.get(mid);
            int cmp = midVal.compareTo(key);

            if(cmp < 0){
                low = mid + 1;
            } else if(cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
