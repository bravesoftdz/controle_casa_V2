package br.com.maciel.controle_casa_v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class TelevisaoActivity extends Activity {

	private Button btnDesligarLigar;
	private Button btnCanalMais;
	private Button btnCanalMenos;
	private Button btnVolumeMais;
	private Button btnVolumeMenos;
	private Button btnDigitarCanal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_televisao);

		btnDesligarLigar = (Button) findViewById(R.id.btnDesligarLigar);
		btnCanalMais = (Button) findViewById(R.id.btnCanalMais);
		btnCanalMenos = (Button) findViewById(R.id.btnCanalMenos);
		btnVolumeMais = (Button) findViewById(R.id.btnVolumeMais);
		btnVolumeMenos = (Button) findViewById(R.id.btnVolumeMenos);
		btnDigitarCanal = (Button) findViewById(R.id.btnDigitarCanal);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.televisao, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
