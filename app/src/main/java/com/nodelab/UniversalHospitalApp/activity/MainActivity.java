package com.nodelab.UniversalHospitalApp.activity;

import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.alamkanak.weekview.EventClickListener;
import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewDisplayable;
import com.alamkanak.weekview.WeekViewEvent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.nodelab.UniversalHospitalApp.R;
import com.nodelab.UniversalHospitalApp.model.CalendarItem;
import com.nodelab.UniversalHospitalApp.singleton.LoggedUser;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    WeekView<CalendarItem> weekView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setCalendar();

    }

    private void setCalendar() {

        weekView = findViewById(R.id.weekView);


        weekView.setOnEventClickListener(new EventClickListener<CalendarItem>() {
            @Override
            public void onEventClick(CalendarItem event, RectF eventRect) {
                // Do something with the CalendarItem
            }
        });

        // WeekView has infinite horizontal scrolling. Therefore, you need to provide the events
        // of a month whenever that the currently displayed month changes.
        weekView.setMonthChangeListener(new MonthLoader.MonthChangeListener<CalendarItem>() {
            @Override
            public List<WeekViewDisplayable<CalendarItem>> onMonthChange(Calendar startDate, Calendar endDate) {
                List<WeekViewDisplayable<CalendarItem>> list= new ArrayList<>();
                return list;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.logout:
                signOut();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void signOut() {
        LoggedUser.getGoogleSignInClient().signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
    }

}
