package example.com.calendartest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by All User on 10/15/2015.
 */
public class DisplayEvent_Activity extends Activity {

    @Bind(R.id.eventAppearHere_Textview) TextView eventAppearHere_TextView;
    private int year, day;
    private String month;
    private String eventDescription, eventName;
    private EventObject eventObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_event_layout);
        ButterKnife.bind(this);

        retrieveData();

        extractData();

        eventAppearHere_TextView.setText("Event Name : " + eventName + "\n\n" + "Event at : " + year + "/" + month + "/" + day + "\n\n" + "Event Description : " + eventDescription);
    }

    private void extractData() {
        year = eventObject.getYear();
        month = eventObject.getMonth();
        day = eventObject.getDay();
        eventName = eventObject.getEventName();
        eventDescription = eventObject.getEventDescription();
    }

    private void retrieveData() {
        Intent intent = getIntent();
        eventObject = (EventObject) intent.getSerializableExtra("Event_Object");
    }
}
