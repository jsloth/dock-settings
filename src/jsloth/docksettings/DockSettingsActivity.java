package jsloth.docksettings;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class DockSettingsActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        CheckBox chkDimDisplay = (CheckBox) findViewById(R.id.chkDimDisplay);
        CheckBox chkDisableKeyLight = (CheckBox) findViewById(R.id.chkDisableKeyLight);
        CheckBox chkDisableScreenLock = (CheckBox) findViewById(R.id.chkDisableScreenLock);
        CheckBox chkVibrate = (CheckBox) findViewById(R.id.chkVibrate);
        
        chkDimDisplay.setOnCheckedChangeListener(new ChkButtonListenerChange());
        chkDisableKeyLight.setOnCheckedChangeListener(new ChkButtonListenerChange());
        chkDisableScreenLock.setOnCheckedChangeListener(new ChkButtonListenerChange());
        chkVibrate.setOnCheckedChangeListener(new ChkButtonListenerChange());
        
    }
    
    private class ChkButtonListenerChange implements android.widget.CompoundButton.OnCheckedChangeListener
    {

		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			// TODO Auto-generated method stub	
		}
    }
}