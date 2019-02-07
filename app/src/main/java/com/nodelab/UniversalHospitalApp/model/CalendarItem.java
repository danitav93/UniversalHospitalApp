package com.nodelab.UniversalHospitalApp.model;



import com.alamkanak.weekview.WeekViewDisplayable;
import com.alamkanak.weekview.WeekViewEvent;



import org.joda.time.DateTime;


public class CalendarItem implements WeekViewDisplayable<CalendarItem> {

    private long id;
    private String title;
    private DateTime startTime;
    private DateTime endTime;
    private String location;
    private int color;

    /* ... */

    @Override
    public WeekViewEvent<CalendarItem> toWeekViewEvent() {
        // Note: It's important to pass "this" as the last argument to WeekViewEvent's constructor.
        // This way, the EventClickListener can return this object in its onEventClick() method.
        boolean isAllDay = true;
        return new WeekViewEvent<>(
                id, title, startTime.toGregorianCalendar(),
                endTime.toGregorianCalendar(), location, color, isAllDay, this
        );
    }

}
