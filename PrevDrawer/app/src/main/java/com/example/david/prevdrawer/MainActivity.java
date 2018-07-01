package com.example.david.prevdrawer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Connection c = new Connection();
    Connection c2 = new Connection();
    String estado = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Menu 1");
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_menu1:
                fragment = new Menu1();
                break;
            case R.id.nav_menu2:
                fragment = new Menu2();
                break;
            case R.id.nav_menu3:
                fragment = new Menu3();
                break;
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        //calling the method displayselectedscreen and passing the id of selected menu
        displaySelectedScreen(item.getItemId());
        //make this method blank
        return true;
    }

    public void buscar(View view) throws Exception {

        EditText text = (EditText) view.findViewById(R.id.City);
        String nome = text.getText().toString();
        //tratamento da excessão sem digitar uma cidade
        if (TextUtils.isEmpty(nome.toString())) {
            text.setError("Digite uma Cidade");
            /*return;*/
        }



        TextView resultArea = (TextView) view.findViewById(R.id.result);
        resultArea.setVisibility(View.VISIBLE);

        //IMAGE VIEWS DOS ÍCONES DE CONDIÇÃO DO TEMPO

        final ImageView icone1 = (ImageView) view.findViewById(R.id.icone1);
        final ImageView icone1n = (ImageView) view.findViewById(R.id.icone1n);
        final ImageView icone2 = (ImageView) view.findViewById(R.id.icone2);
        final ImageView icone2n = (ImageView) view.findViewById(R.id.icone2n);
        final ImageView icone2r = (ImageView) view.findViewById(R.id.icone2r);
        final ImageView icone2rn = (ImageView) view.findViewById(R.id.icone2rn);
        final ImageView icone3 = (ImageView) view.findViewById(R.id.icone3);
        final ImageView icone3n = (ImageView) view.findViewById(R.id.icone3n);
        final ImageView icone3tm =  (ImageView) view.findViewById(R.id.icone3tm);
        final ImageView icone4 =  (ImageView) view.findViewById(R.id.icone4);
        final ImageView icone4n =  (ImageView) view.findViewById(R.id.icone4n);
        final ImageView icone4r =  (ImageView) view.findViewById(R.id.icone4r);
        final ImageView icone4rn =  (ImageView) view.findViewById(R.id.icone4rn);
        final ImageView icone4t =  (ImageView) view.findViewById(R.id.icone4t);
        final ImageView icone4tn =  (ImageView) view.findViewById(R.id.icone4tn);
        final ImageView icone5 =  (ImageView) view.findViewById(R.id.icone5);
        final ImageView icone5n =  (ImageView) view.findViewById(R.id.icone5n);
        final ImageView icone6 =  (ImageView) view.findViewById(R.id.icone6);
        final ImageView icone6n =  (ImageView) view.findViewById(R.id.icone6n);
        final ImageView icone7 =  (ImageView) view.findViewById(R.id.icone7);
        final ImageView icone7n =  (ImageView) view.findViewById(R.id.icone7n);
        final ImageView icone8 =  (ImageView) view.findViewById(R.id.icone8);
        final ImageView icone8n =  (ImageView) view.findViewById(R.id.icone8n);
        final ImageView icone9 =  (ImageView) view.findViewById(R.id.icone9);
        final ImageView icone9n =  (ImageView) view.findViewById(R.id.icone9n);


        Weather weather = c.sendGetId(nome, estado);

        // Tratamento da excessão de cidade errada ou inexistente.
        if (weather.getName()== null) {
            StringBuilder sb = new StringBuilder();
            sb.append("-------------------------------------"+"\n");
            sb.append("         CIDADE OU ESTADO            "+"\n");
            sb.append("             INVÁLIDO                "+"\n");
            sb.append("         POR FAVOR DIGITE            "+"\n");
            sb.append("             NOVAMENTE!              "+"\n");
            sb.append("-------------------------------------"+"\n");
            resultArea.setText(sb);


        } else {
            Weather weather2 = c2.sendGet2(weather.getId());

            String ic = weather2.getData().getIcon().toString();

            //If else para mostrar os ícones do tempo nas cidades
            if (ic.equals("1")){icone1.getDrawable();icone1.setVisibility(View.VISIBLE);
            }else if(ic.equals("1n")){icone1n.getDrawable();icone1n.setVisibility(View.VISIBLE);
            }else if(ic.equals("2")) {icone2.getDrawable();icone2.setVisibility(View.VISIBLE);
            }else if(ic.equals("2n")){icone2n.getDrawable();icone2n.setVisibility(View.VISIBLE);
            }else if(ic.equals("2r")){icone2r.getDrawable();icone2r.setVisibility(View.VISIBLE);
            }else if(ic.equals("2rn")){icone2rn.getDrawable();icone2rn.setVisibility(View.VISIBLE);
            }else if(ic.equals("3")){icone3.getDrawable();icone3.setVisibility(View.VISIBLE);
            }else if(ic.equals("3n")){icone3n.getDrawable();icone3n.setVisibility(View.VISIBLE);
            }else if (ic.equals("3tm")){icone3tm.getDrawable();icone3tm.setVisibility(View.VISIBLE);
            }else if (ic.equals("4")){icone4.getDrawable();icone4.setVisibility(View.VISIBLE);
            }else if (ic.equals("4n")){icone4n.getDrawable();icone4n.setVisibility(View.VISIBLE);
            }else if (ic.equals("4r")){icone4r.getDrawable();icone4r.setVisibility(View.VISIBLE);
            }else if (ic.equals("4rn")){icone4rn.getDrawable();icone4rn.setVisibility(View.VISIBLE);
            }else if (ic.equals("4t")){icone4t.getDrawable();icone4t.setVisibility(View.VISIBLE);
            }else if (ic.equals("4tn")){icone4tn.getDrawable();icone4tn.setVisibility(View.VISIBLE);
            }else if (ic.equals("5")){icone5.getDrawable();icone5.setVisibility(View.VISIBLE);
            }else if (ic.equals("5n")){icone5n.getDrawable();icone5n.setVisibility(View.VISIBLE);
            }else if (ic.equals("6")){icone6.getDrawable();icone6.setVisibility(View.VISIBLE);
            }else if (ic.equals("6n")){icone6n.getDrawable();icone6n.setVisibility(View.VISIBLE);
            }else if (ic.equals("7")){icone7.getDrawable();icone7.setVisibility(View.VISIBLE);
            }else if (ic.equals("7n")){icone7n.getDrawable();icone7n.setVisibility(View.VISIBLE);
            }else if (ic.equals("8")){icone8.getDrawable();icone8.setVisibility(View.VISIBLE);
            }else if (ic.equals("8n")){icone8n.getDrawable();icone8n.setVisibility(View.VISIBLE);
            }else if (ic.equals("9")){icone9.getDrawable();icone9.setVisibility(View.VISIBLE);
            }else if (ic.equals("9n")){icone9n.getDrawable();icone9n.setVisibility(View.VISIBLE);
            }else{
            }

            StringBuilder sb = new StringBuilder();
            sb.append("--------------------------------------------------" + "\n");
            sb.append("\n");
            sb.append("    Data: " + weather2.getData().getDia() + "\n");
            sb.append("\n");
            sb.append("    Cidade: " + weather.getName() + "\n");
            sb.append("    ID: " + Integer.toString(weather.getId()) + "\n");
            sb.append("    Estado: " + weather.getState().toString() + "\n");
            sb.append("    País: " + weather.getCountry().toString() + "\n");
            sb.append("    Temperatura: " + Double.toString(weather2.getData().getTemperature()) + " °C" + "\n");
            sb.append("    Direção do Vento: " + weather2.getData().getWindDirection().toString() + "\n");
            sb.append("    Velocidade do Vento: " + Integer.toString(weather2.getData().getWindVelocity()) + " km/h" + "\n");
            sb.append("    Humidade: " + Integer.toString(weather2.getData().getHumidity()) + " %" + "\n");
            sb.append("    Condição: " + weather2.getData().getCondition().toString() + "\n");
            sb.append("    Pressão: " + weather2.getData().getPressure().toString() + "\n");
            sb.append("    Sensação Térmica: " + weather2.getData().getSensation().toString() + " °C" + "\n");
            sb.append("----------------------------------------------------");


            resultArea.setText(sb);





        }


    }





}