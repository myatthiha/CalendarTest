package example.com.calendartest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateChangedListener;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by All User on 10/15/2015.
 */
public class Calendar_Activity extends Activity {
    @Bind(R.id.calendarFullScreen) MaterialCalendarView calendarView;

    private int y, m , d;
    private String month;
    private EventObject eventObject = new EventObject();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_layout);
        ButterKnife.bind(this);
        calendarView.setOnDateChangedListener(new OnDateChangedListener() {
            @Override
            public void onDateChanged(MaterialCalendarView widget, CalendarDay date) {

            }
        });

        calendarView.setOnDateChangedListener(new OnDateChangedListener() {
            @Override
            public void onDateChanged(MaterialCalendarView widget, CalendarDay date) {
                y = date.getYear();
                m = date.getMonth() + 1 ;
                changeMonthToString(m);
                d = date.getDay();

                addData();

                goToPostActivity();
            }
        });

    }

    private void addData() {
        eventObject.setDay(d);
        eventObject.setMonth(month);
        eventObject.setYear(y);
    }

    private void goToPostActivity() {
        Intent intent = new Intent(Calendar_Activity.this, CreateEvent_Activity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra("Event_Object", eventObject);
        startActivity(intent);
    }

    private void changeMonthToString(int m) {
        switch (m){
            case 1 :
                month = "January";
                break;
            case 2 :
                month = "February";
                break;
            case 3 :
                month = "March";
                break;
            case 4 :
                month = "April";
                break;
            case 5 :
                month = "May";
                break;
            case 6 :
                month = "June";
                break;
            case 7 :
                month = "July";
                break;
            case 8 :
                month = "August";
                break;
            case 9 :
                month = "September";
                break;
            case 10 :
                month = "October";
                break;
            case 11 :
                month = "November";
                break;
            case 12 :
                month = "December";
                break;
            default :
                break;
        }

    }

}
