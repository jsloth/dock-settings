package jsloth.docksettings;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class DockSettingsActivity extends Activity {
    private final String PREFS_NAME = "DockSettingsFile";
	private final List<Configuration> mConfigurationList = new ArrayList<DockSettingsActivity.Configuration>();    
    
    private abstract class Configuration {
    	protected String mName;

    	public Configuration(String name) {
    		mName = name;
		}
		
    	private String getName() {
			return mName;
		}
		
    	public abstract void save(SharedPreferences.Editor editor);
    }

    private class CheckBoxConfiguration extends Configuration
    {
    	private CheckBox mCheckBox;
		public CheckBoxConfiguration(String name, CheckBox cb) {
    		super(name);
    		mCheckBox = cb;
		}
		@Override
		public void save(Editor editor) {
			editor.putBoolean(mName, mCheckBox.isChecked());	
		}
    	
    }
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        
        CheckBox chkDimDisplay = (CheckBox) findViewById(R.id.chkDimDisplay);
        CheckBox chkDisableKeyLight = (CheckBox) findViewById(R.id.chkDisableKeyLight);
        CheckBox chkDisableScreenLock = (CheckBox) findViewById(R.id.chkDisableScreenLock);
        CheckBox chkVibrate = (CheckBox) findViewById(R.id.chkVibrate);
        
        mConfigurationList.add(new CheckBoxConfiguration("DimDisplay", chkDimDisplay));
        mConfigurationList.add(new CheckBoxConfiguration("DisableKeyLight", chkDisableKeyLight));
        mConfigurationList.add(new CheckBoxConfiguration("DisableScreenLock", chkDisableScreenLock));
        mConfigurationList.add(new CheckBoxConfiguration("Vibrate", chkVibrate));
        
        chkDimDisplay.setOnCheckedChangeListener(new ChkButtonListenerChange());
        chkDisableKeyLight.setOnCheckedChangeListener(new ChkButtonListenerChange());
        chkDisableScreenLock.setOnCheckedChangeListener(new ChkButtonListenerChange());
        chkVibrate.setOnCheckedChangeListener(new ChkButtonListenerChange());
        
    }
    
    @Override
    protected void onStop() {
    	super.onStop();
    	
        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences settings = getSharedPreferences(PREFS_NAME , 0);
        SharedPreferences.Editor editor = settings.edit();
        
        for (Configuration configuration : mConfigurationList) {
			configuration.save(editor);
		}

        // Commit the edits!
        editor.commit();
    }
    private class ChkButtonListenerChange implements android.widget.CompoundButton.OnCheckedChangeListener
    {

		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			// TODO Auto-generated method stub	
		}
    }
}