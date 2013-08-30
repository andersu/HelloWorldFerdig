package no.nith.android.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button buttonHello;
	private EditText editTextName;
	private TextView textViewResult; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initViews();
		initListeners();
	}

	private void initViews() {
		buttonHello = (Button) findViewById(R.id.buttonHello);
		editTextName = (EditText) findViewById(R.id.editTextName);
		textViewResult = (TextView) findViewById(R.id.textViewResult);
	}
	
	private void initListeners() {
		buttonHello.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sayHello();
			}
		});
		
		editTextName.setOnKeyListener(new View.OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
					sayHello();
				}
				return false;
			}
		}); 
	}
	
	private void sayHello() {
		String name = editTextName.getText().toString();
		String helloName = "Hello, " + name + "!";
		textViewResult.setText(helloName);
		editTextName.setText("");
	}

}
