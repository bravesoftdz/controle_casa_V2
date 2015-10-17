package br.com.maciel.controle_casa_v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ToggleButton;
import br.com.maciel.controle_casa_v2.R;
import br.com.maciel.controle_casa_v2.model.Configuracao;
import br.com.maciel.controle_casa_v2.utils.ClienteHttpGet;
import br.com.maciel.controle_casa_v2.utils.Utils;

public class LuzesActivity extends Activity {

	private ToggleButton tgbtnLampadaSala;
	private ToggleButton tgbtnLampadaCozinha;	
	private ToggleButton tgbtnLampadaHall;
	private ToggleButton tgbtnLampadaBanheiro;
	private ToggleButton tgbtnLampadaQuarto01;
	private ToggleButton tgbtnLampadaQuarto02;	
	private ClienteHttpGet clienteHttp;
	private Configuracao conf;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_luzes);
		
		tgbtnLampadaSala = (ToggleButton) findViewById(R.id.tgbtnLampadaSala);
		tgbtnLampadaCozinha = (ToggleButton) findViewById(R.id.tgbtnLampadaCozinha);		
		tgbtnLampadaHall = (ToggleButton) findViewById(R.id.tgbtnLampadaHall);
		tgbtnLampadaBanheiro = (ToggleButton) findViewById(R.id.tgbtnLampadaBanheiro);
		tgbtnLampadaQuarto01 = (ToggleButton) findViewById(R.id.tgbtnLampadaQuarto01);
		tgbtnLampadaQuarto02 = (ToggleButton) findViewById(R.id.tgbtnLampadaQuarto02);
		
		conf = Utils.getConfiguracao(getBaseContext());
		
		metodosBotoes();
	}
	
private void metodosBotoes() {
		
		/**
		 * 
		 */
		tgbtnLampadaSala.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (tgbtnLampadaSala.isChecked()){
					clienteHttp =  new ClienteHttpGet(conf.getUrl() + "?CMD=LAMSALAOFF");
				}else{
					clienteHttp =  new ClienteHttpGet(conf.getUrl() + "?CMD=LAMSALAON");
				}
			}
		});
		
		/**
		 * 
		 */
		tgbtnLampadaCozinha.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (tgbtnLampadaCozinha.isChecked()){
					clienteHttp =  new ClienteHttpGet(conf.getUrl() + "?CMD=LAMCOZOFF");
				}else{
					clienteHttp =  new ClienteHttpGet(conf.getUrl() + "?CMD=LAMCOZON");
				}
			}
		});
		
		/**
		 * 
		 */
		tgbtnLampadaHall.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (tgbtnLampadaHall.isChecked()){
					clienteHttp =  new ClienteHttpGet(conf.getUrl() + "?CMD=LAMHALLOFF");
				}else{
					clienteHttp =  new ClienteHttpGet(conf.getUrl() + "?CMD=LAMHALLON");
				}
			}
		});
		
		/**
		 * 
		 */
		tgbtnLampadaBanheiro.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (tgbtnLampadaBanheiro.isChecked()){
					clienteHttp =  new ClienteHttpGet(conf.getUrl() + "?CMD=LAMBANOFF");
				}else{
					clienteHttp =  new ClienteHttpGet(conf.getUrl() + "?CMD=LAMBANON");
				}
			}
		});
		
		/**
		 * 
		 */
		tgbtnLampadaQuarto01.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (tgbtnLampadaQuarto01.isChecked()){
					clienteHttp =  new ClienteHttpGet(conf.getUrl() + "?CMD=LAMQUA01OFF");
				}else{
					clienteHttp =  new ClienteHttpGet(conf.getUrl() + "?CMD=LAMQUA01ON");
				}
			}
		});
		
		/**
		 * 
		 */
		tgbtnLampadaQuarto02.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (tgbtnLampadaQuarto02.isChecked()){
					clienteHttp =  new ClienteHttpGet(conf.getUrl() + "?CMD=LAMQUA02OFF");
				}else{
					clienteHttp =  new ClienteHttpGet(conf.getUrl() + "?CMD=LAMQUA02ON");
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.luzes, menu);
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
