package br.com.maciel.controle_casa_v2.utils;

import android.content.Context;
import android.database.Cursor;
import br.com.maciel.controle_casa_v2.dao.DataBaseConnector;
import br.com.maciel.controle_casa_v2.model.Configuracao;

public class Utils {
	
	public static Configuracao getConfiguracao(Context contexto){
		DataBaseConnector dataBaseConnector;
		
		Configuracao configuracao;
		//Seta o contexto no conector
		dataBaseConnector = new DataBaseConnector(contexto);
		//Abre a conexao
		dataBaseConnector.open();
		//o cursor recebe a configuracao
		Cursor cursor = dataBaseConnector.getConfiguracao();
		//move o cursor para o inicio
		cursor.moveToPosition(0);
		//seta o objeto com as informcoes do cursor
		configuracao = new Configuracao(cursor.getInt(0),
				cursor.getString(1));
		
		return configuracao;
	}

}
