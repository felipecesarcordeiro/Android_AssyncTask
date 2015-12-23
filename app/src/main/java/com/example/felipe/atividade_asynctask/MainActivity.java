/*Felipe César Cordeiro Campelo
 * Matricula : 20121004010 
 * 4°ano Integrado em informatica
 * github:felipecesarcordeiro e-mail:felipecesarcordeiro@gmail.com*/

package com.example.felipe.android_asynctask;

import android.view.*;
import android.widget.*;
import android.util.Log;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity 
{

    @Override
    protected void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button asyncTaskButton = (Button) findViewById(R.id.button);
        asyncTaskButton.setOnClickListener(new View.OnClickListener()); 
		{
            @Override
            public void onClick(View view) 
			{
                Log.i("NotificationWearApp", "Pressione o Botão");
                EditText nomeEditText = (EditText) findViewById(R.id.editText);
                String nome = nomeEditText.getText().toString();
                LoginAsyncTask loginAsyncTask = new LoginAsyncTask(view.getContext());
                String[] valores = {nome};
                loginAsyncTask.execute(valores);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
	{
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) 
		{
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
