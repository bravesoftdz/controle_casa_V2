package br.com.maciel.controle_casa_v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import br.com.maciel.controle_casa_v2.R;
import br.com.maciel.controle_casa_v2.dao.DataBaseConnector;
import br.com.maciel.controle_casa_v2.model.Configuracao;
import br.com.maciel.controle_casa_v2.utils.Utils;

public class ConfiguracaoActivity extends Activity {

	private EditText edtUrl;
	private Button btnSalvar;
	private Button btnCancelar;
	
	private Configuracao conf;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_configuracao);
	
		edtUrl = (EditText) findViewById(R.id.edtUrl);
		btnSalvar = (Button) findViewById(R.id.btnSalvar);
		btnCancelar = (Button) findViewById(R.id.btnCancelar);
		
		conf = Utils.getConfiguracao(getBaseContext());
		
		edtUrl.setText(conf.getUrl());
		
		metodosBotoes();
		
	}
	
	public void metodosBotoes(){
		btnSalvar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				conf.setUrl(edtUrl.getText().toString().trim());
				DataBaseConnector.updateConfiguracao(conf);		
				conf = null;
				finish();
			}
		});
		
		btnCancelar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				conf = null;
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.configuracao, menu);
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
