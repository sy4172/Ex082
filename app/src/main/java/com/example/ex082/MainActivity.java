package com.example.ex082;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    Spinner spin;
    ListView lv;
    TextView capital, population, language, anthem;
    ArrayAdapter<String> adp;
    int selectedContinet;

    String[] continent = {"Continent", "America", "Africa", "Asia", "Europe"};
    String[][] america = {{"Brazil", "Chile", "Argentina ", "Peru", "Venezuela", "Mexico","USA"},
                          {"Brasília", "Santiago", "Buenos Aires", "Lima", "Caracas", "Mexico City","Washington, D.C."},
                          {"210,147,125", "17,574,003", "44,938,712", "32,824,358", "28,887,118", "128,649,565","328,239,523"},
                          {"Portuguese", "Spanish", "Spanish", "Spanish", "Spanish", "Spanish","English"},
                          {"Hino Nacional Brasileiro", "Himno Nacional de Chile", "Himno Nacional Argentino", "Himno Nacional del Perú", "Gloria al Bravo Pueblo", "Himno Nacional Mexicano","The Star-Spangled Banner"}};

    String[][] africa = {{"Sudan", "Morocco", "Algeria", "Egypt", "Chad", "Cameroon","Ethiopia"},
                         {"Khartoum", "Rabat", "Algiers", "Cairo", "N'Djamena", "Yaoundé","Addis Ababa"},
                         {"41,592,539", "36,472,000", "43,600,000", "100,075,480", "13,670,084", "26,545,864","109,224,414"},
                        {"Arabic", "Moroccan Arabic, French", "Arabic, Berber", "Arabic", "Arabic, French", "English, French","Amharic"},
                        {"نحن جند الله، جند الوطن", "النشيد الوطني المغربي", "We Pledge - قسامان", "بلادي، بلادي، بلادي - My country, my country, my country", "The Chadian Hymn - La Tchadienne", "O Cameroon, Cradle of our Forefathers","March Forward, Dear Mother Ethiopia"}};

    String[][] asia = {{"Israel", "Japan", "India", "Russia", "Iran", "Iraq","China"},
                        {"Jerusalem", "Tokyo", "New Delhi", "Moscow", "Tehran", "Baghdad","Beijing"},
                        {"9,256,580", "125,960,000", "1,352,642,280", "146,748,590", "83,183,741", "38,433,600","1,400,050,000"},
                        {"Hebrew", "Japanese", "Hindi, Indian English", "Russian", "Persian", "Arabic, Kurdish","Standard Chinese"},
                        {" The Hope - התקווה", "Kimigayo - 君が代", "Jana Gana Mana", "Государственный гимн Российской Федерации", "استقلال، آزادی، جمهوری اسلامی", " موطني - My Homeland","March of the Volunteers - 义勇军进行曲"}};

    String[][] europe = {{"Spain", "Italy", "France", "Germany", "Netherlands", "Portugal","United Kingdom"},
                        {"Madrid", "Rome", "Paris", "Berlin", "Amsterdam", "Portugal","London"},
                        {"47,431,256", "60,317,116", "67,081,000", "83,166,711", "17,418,808", "10,295,909","67,886,004"},
                        {"Spanish", "Italian", "French", "German", "Dutch, English, Papiamentu", "Portuguese","English"},
                        {"Marcha Real", "Canto degli Italiani", "Liberté, égalité, fraternité", "Deutschlandlied", "Wilhelmus van Nassouwe", "A Portuguesa","God Save the Queen"},};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin = findViewById(R.id.spin);
        lv = findViewById(R.id.lv);
        capital = findViewById(R.id.capital);
        population = findViewById(R.id.population);
        language = findViewById(R.id.language);
        anthem = findViewById(R.id.anthem);

        spin.setOnItemSelectedListener(this);
        adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, continent);
        spin.setAdapter(adp);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 1:{
                capital.setText("");
                population.setText("");
                language.setText("");
                anthem.setText("");
                adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, america[0]);
                selectedContinet = 1;
                lv.setAdapter(adp);
            }
            break;

            case 2:{
                capital.setText("");
                population.setText("");
                language.setText("");
                anthem.setText("");
                adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, africa[0]);
                selectedContinet = 2;
                lv.setAdapter(adp);
            }
            break;

            case 3:{
                capital.setText("");
                population.setText("");
                language.setText("");
                anthem.setText("");
                adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, asia[0]);
                selectedContinet = 3;
                lv.setAdapter(adp);
            }
            break;

            case 4:{
                capital.setText("");
                population.setText("");
                language.setText("");
                anthem.setText("");
                adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, europe[0]);
                selectedContinet = 4;
                lv.setAdapter(adp);
            }
            break;

            default:{
                capital.setText("");
                population.setText("");
                language.setText("");
                anthem.setText("");
                lv.setAdapter(null);
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (selectedContinet){
            case 1:{
                capital.setText(america[1][position]);
                population.setText(america[2][position]);
                language.setText(america[3][position]);
                anthem.setText(america[4][position]);
            }
            break;

            case 2:{
                capital.setText(africa[1][position]);
                population.setText(africa[2][position]);
                language.setText(africa[3][position]);
                anthem.setText(africa[4][position]);
            }
            break;

            case 3:{
                capital.setText(asia[1][position]);
                population.setText(asia[2][position]);
                language.setText(asia[3][position]);
                anthem.setText(asia[4][position]);
            }
            break;

            case 4:{
                capital.setText(europe[1][position]);
                population.setText(europe[2][position]);
                language.setText(europe[3][position]);
                anthem.setText(europe[4][position]);
            }
            break;

            default:{
                capital.setText("");
                population.setText("");
                language.setText("");
                anthem.setText("");
            }
        }
    }
}