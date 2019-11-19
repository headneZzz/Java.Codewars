package kyu5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

public class PickPeaks {

    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        List<Integer> pos = new LinkedList<>();
        List<Integer> peaks = new LinkedList<>();
        int tempPos = 0;
        int tempPeak = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] > arr[i]) {
                tempPos = i + 1;
                tempPeak = arr[i + 1];
            }
            if (arr[i + 1] < arr[i])
                if (tempPos != 0) {
                    pos.add(tempPos);
                    peaks.add(tempPeak);
                    tempPeak = 0;
                    tempPos = 0;
                }
        }
        Map<String, List<Integer>> out = new HashMap<>();
        out.put("pos", pos);
        out.put("peaks", peaks);
        return out;
    }
}
