package com.example.avaliacandidato;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText nomeUsuario, emailUsuario;
	Spinner spinnerHTML, spinnerCSS, spinnerJavaScript, spinnerPython, spinnerDjango, spinnerDesenvIos, spinnerDesenvAndroid;
	Button btnEnviar;
	String nomeDoUsuario, emailDoUsuario;
	Integer vlrHTML, vlrCSS, vlrJavaScript, vlrPython, vlrDjango, vlrDesenvIos, vlrDesenvAndroid;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		nomeUsuario = (EditText) findViewById(R.id.nomeUsuario);
		emailUsuario = (EditText) findViewById(R.id.emailUsuario);
		spinnerHTML = (Spinner) findViewById(R.id.spinnerHTML);
		spinnerCSS = (Spinner) findViewById(R.id.spinnerCSS);
		spinnerJavaScript = (Spinner) findViewById(R.id.spinnerJavaScript);
		spinnerPython = (Spinner) findViewById(R.id.spinnerPython);
		spinnerDjango = (Spinner) findViewById(R.id.spinnerDjango);
		spinnerDesenvIos = (Spinner) findViewById(R.id.spinnerDesenvIos);
		spinnerDesenvAndroid = (Spinner) findViewById(R.id.spinnerDesenvAndroid);
		btnEnviar = (Button) findViewById(R.id.btnEnviar);
		
		spinnerHTML.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int posicao, long arg3) {
				vlrHTML = (int) spinnerHTML.getItemIdAtPosition(posicao);
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		spinnerCSS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int posicao, long arg3) {
				vlrCSS = (int) spinnerCSS.getItemIdAtPosition(posicao);
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		spinnerJavaScript.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int posicao, long arg3) {
				vlrJavaScript = (int) spinnerJavaScript.getItemIdAtPosition(posicao);
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		spinnerPython.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int posicao, long arg3) {
				vlrPython = (int) spinnerPython.getItemIdAtPosition(posicao);
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		spinnerDjango.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int posicao, long arg3) {
				vlrDjango = (int) spinnerDjango.getItemIdAtPosition(posicao);
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		spinnerDesenvIos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int posicao, long arg3) {
				vlrDesenvIos = (int) spinnerDesenvIos.getItemIdAtPosition(posicao);
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		spinnerDesenvAndroid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int posicao, long arg3) {
				vlrDesenvAndroid = (int) spinnerDesenvAndroid.getItemIdAtPosition(posicao);
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		btnEnviar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				boolean situacaoFrontEnd;
				boolean situacaoBackEnd;
				boolean situacaoMobile;
				boolean camposObrigatorios;
				
				camposObrigatorios = validaCampos();
				
				if(camposObrigatorios == true) {
					nomeDoUsuario = nomeUsuario.getText().toString();
					emailDoUsuario = emailUsuario.getText().toString();
					
					// Método de critério já envia o e-mail se aprovado
					situacaoFrontEnd = criterioFronEnd(vlrHTML, vlrCSS, vlrJavaScript);
					situacaoBackEnd = criterioBackEnd(vlrPython, vlrDjango);
					situacaoMobile = criterioMobile(vlrDesenvIos, vlrDesenvAndroid);
					
					montaEmail(nomeDoUsuario, emailDoUsuario, situacaoFrontEnd, situacaoBackEnd, situacaoMobile);
					//enviaEmail("clbaldin@gmail.com", "Obrigado por se Candidatar", "Corpo do E-Mail");
				}
			}
		});
	}
	
	protected boolean validaCampos() {
		boolean obrigatorio = true;
		if (nomeUsuario.getText().toString().length() <= 0) {
			nomeUsuario.setError("Preencha o campo Nome!");
			nomeUsuario.requestFocus();
			obrigatorio = false;
		}
		if (emailUsuario.getText().toString().length() <= 0) {
			emailUsuario.setError("Preencha o campo E-Mail!");
			emailUsuario.requestFocus();
			obrigatorio = false;
		}
		return obrigatorio;
	}
	
	protected boolean criterioFronEnd(Integer notaHtml, Integer notaCSS, Integer notaJavaScript) { // para aprovar maior que 7 para os 3
		//String assuntoEmail;
		//String corpoEmail;
		if((notaHtml >= 7)&&(notaCSS >= 7)&&(notaJavaScript >= 7)) {
			//assuntoEmail = "Obrigado por se Candidatar";
			//corpoEmail = "Obrigado por se candidatar, assim que tivermos uma vaga disponível para programador Front-End entraremos em contato.";
			//enviaEmail(emailUsuario, assuntoEmail, corpoEmail);
			return true;
		} else {
			return false;
		}
	}
	
	protected boolean criterioBackEnd(Integer notaPython, Integer notaDjango) { // para aprovar maior que 7 para os 2
		//String assuntoEmail;
		//String corpoEmail;
		if((notaPython >= 7)&&(notaDjango >= 7)) {
			//assuntoEmail = "Obrigado por se Candidatar";
			//corpoEmail = "Obrigado por se candidatar, assim que tivermos uma vaga disponível para programador Back-End entraremos em contato.";
			//enviaEmail(emailUsuario, assuntoEmail, corpoEmail);
			return true;
		} else {
			return false;
		}
	}
	
	protected boolean criterioMobile(Integer notaIos, Integer notaAndroid) { // para aprovar maior que 7 para um dos 2
		//String assuntoEmail;
		//String corpoEmail;
		if((notaIos >= 7)||(notaAndroid >= 7)) {
			//assuntoEmail = "Obrigado por se Candidatar";
			//corpoEmail = "Obrigado por se candidatar, assim que tivermos uma vaga disponível para programador Mobile entraremos em contato.";
			//enviaEmail(emailUsuario, assuntoEmail, corpoEmail);
			return true;
		} else {
			return false;
		}
	}
	
	protected void montaEmail(String nome, String email, boolean fronEnd, boolean backEnd, boolean modile) {
		String assuntoEmail = "Obrigado por se Candidatar";
		String corpoEmail = nome + ", obrigado por se candidatar, ";
		if((fronEnd == true)&&(backEnd == false)&&(modile == false)) {
			corpoEmail = corpoEmail + "assim que tivermos uma vaga disponível para programador FRONT-END entraremos em contato.";
		} else if ((fronEnd == true)&&(backEnd == true)&&(modile == false)) {
			corpoEmail = corpoEmail + " assim que tivermos uma vaga disponível para programador FRONT-END ou BACK-END entraremos em contato.";
		} else if ((fronEnd == true)&&(backEnd == true)&&(modile == true)) {
			corpoEmail = corpoEmail + "assim que tivermos uma vaga disponível para programador FRONT-END, BACK-END ou MOBILE entraremos em contato.";
		} else if ((fronEnd == true)&&(backEnd == false)&&(modile == true)) {
			corpoEmail = corpoEmail + "assim que tivermos uma vaga disponível para programador FRONT-END ou MOBILE entraremos em contato.";
		} else if ((fronEnd == false)&&(backEnd == true)&&(modile == true)) {
			corpoEmail = corpoEmail + "assim que tivermos uma vaga disponível para programador BACK-END ou MOBILE entraremos em contato.";
		} else if ((fronEnd == false)&&(backEnd == true)&&(modile == false)) {
			corpoEmail = corpoEmail + "assim que tivermos uma vaga disponível para programador BACK-END entraremos em contato.";
		} else if ((fronEnd == false)&&(backEnd == false)&&(modile == true)) {
			corpoEmail = corpoEmail + "assim que tivermos uma vaga disponível para programador MOBILE entraremos em contato.";
		} else {
			corpoEmail = corpoEmail + "assim que tivermos uma vaga para programador disponível entraremos em contato.";
		}
		enviaEmail(email, assuntoEmail, corpoEmail);
	}

	protected void enviaEmail(String destinatario, String assunto, String corpo) {
		Log.i("Envio de E-Mail", "");

		String[] TO = {destinatario};
		Intent emailIntent = new Intent(Intent.ACTION_SEND);
		emailIntent.setData(Uri.parse("mailto:"));
		emailIntent.setType("text/plain");
		
		emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, assunto);
		emailIntent.putExtra(Intent.EXTRA_TEXT, corpo);

		try {
			startActivity(Intent.createChooser(emailIntent, "Enviando..."));
			finish();
			Log.i("E-Mail com Sucesso...", "");
		} catch (android.content.ActivityNotFoundException ex) {
			Toast.makeText(MainActivity.this, "Deve ser instalado um cliente de e-mail.", Toast.LENGTH_SHORT).show();
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
