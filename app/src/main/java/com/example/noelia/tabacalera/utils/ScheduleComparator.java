package com.example.noelia.tabacalera.utils;

import com.example.noelia.tabacalera.workshops.WorkshopsDataProvider;

import java.util.Comparator;

/**
 * Created by Noelia on 27/08/2016.
 */
public class ScheduleComparator implements Comparator<WorkshopsDataProvider> {

    @Override
    public int compare(WorkshopsDataProvider lhs, WorkshopsDataProvider rhs) {
        if (lhs == null || rhs == null) return 0; // Ensure avoid crash

        int res = String.CASE_INSENSITIVE_ORDER.compare(lhs.getSchedule(), rhs.getSchedule());
//        if (res == 0) {
//            res = lhs.getSchedule().compareTo(rhs.getSchedule());
//        }
//        return res;
        return (res != 0) ? res : lhs.getSchedule().compareTo(rhs.getSchedule());
    }
}