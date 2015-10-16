package example.com.calendartest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by All User on 10/15/2015.
 */
public class CreateEvent_Activity extends Activity{

    @Bind(R.id.eventDescription_Edittext) EditText eventDescription_Edittext;
    @Bind(R.id.eventName_Edittext) EditText eventName_Edittext;
    @Bind(R.id.createEvent_Button) Button createEvent_Button;

    private EventObject eventObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_event_layout);
        ButterKnife.bind(this);

        createEvent_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                retrieveData();

                addData();

                goToDisplayActivity();
            }
        });


    }
    private void addData() {
        eventObject.setEventName("" + eventName_Edittext.getText().toString());
        eventObject.setEventDescription("" + eventDescription_Edittext.getText().toString());
    }

    private void retrieveData() {
        Intent intent = getIntent();
        eventObject = (EventObject) intent.getSerializableExtra("Event_Object");
    }

    private void goToDisplayActivity() {
        Intent intent = new Intent(CreateEvent_Activity.this, DisplayEvent_Activity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra("Event_Object", eventObject);
        startActivity(intent);
    }
}
