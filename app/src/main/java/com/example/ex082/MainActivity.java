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
    String [][] countries  = {{"Brazil", "Chile", "Argentina ", "Peru", "Venezuela", "Mexico","USA"},
                           {"Sudan", "Morocco", "Algeria", "Egypt", "Chad", "Cameroon","Ethiopia"},
                           {"Israel", "Japan", "India", "Russia", "Iran", "Iraq","China"},
                           {"Spain", "Italy", "France", "Germany", "Netherlands", "Portugal","United Kingdom"}};

    String [][] details = {{"Brasília", "210,147,125", "Portuguese", "Hino Nacional Brasileiro"}, // America
            {"Santiago","17,574,003","Spanish","Himno Nacional de Chile"},
            {"Buenos Aires","44,938,712", "Spanish","Himno Nacional Argentino"},
            {"Lima","32,824,358","Spanish","Himno Nacional del Perú"},
            {"Caracas","28,887,118","Spanish","Gloria al Bravo Pueblo"},
            {"Mexico City","128,649,565","Spanish", "Himno Nacional Mexicano"},
            {"Washington, D.C.","328,239,523","English","The Star-Spangled Banner"},
            {"Khartoum","41,592,539","Arabic","نحن جند الله، جند الوطن"}, // Africa
            {"Rabat","36,472,000","Moroccan Arabic, French","النشيد الوطني المغربي"},
            {"Algiers","43,600,000","Arabic, Berber","We Pledge - قسامان"},
            {"Cairo","100,075,480", "Arabic","بلادي، بلادي، بلادي - My country, my country, my country"},
            {"N'Djamena","13,670,084","Arabic, French","The Chadian Hymn - La Tchadienne"},
            {"Yaoundé", "26,545,864","English, French","O Cameroon, Cradle of our Forefathers"},
            {"Addis Ababa","109,224,414","Amharic","March Forward, Dear Mother Ethiopia"},
            {"Jerusalem","9,256,580","Hebrew","The Hope - התקווה"}, // Asia
            {"Tokyo","125,960,000","Japanese","Kimigayo - 君が代"},
            {"New Delhi","1,352,642,280", "Hindi, Indian English","Jana Gana Mana"},
            {"Moscow", "146,748,590","Russian","Государственный гимн Российской Федерации"},
            {"Tehran","83,183,741","Persian", "استقلال، آزادی، جمهوری اسلامی"},
            {"Baghdad","38,433,600","Arabic, Kurdish"," موطني - My Homeland"},
            {"Beijing","1,400,050,000","Standard Chinese","March of the Volunteers - 义勇军进行曲"},
            {"Madrid","47,431,256","Spanish","Marcha Real"}, // Europe
            {"Rome","60,317,116","Italian","Canto degli Italiani"},
            {"Paris","67,081,000","French","Liberté, égalité, fraternité"},
            {"Berlin","83,166,711","German","Deutschlandlied"},
            {"Amsterdam","17,418,808","Dutch, English, Papiamentu", "Wilhelmus van Nassouwe"},
            {"Portugal","10,295,909","Portuguese","A Portuguesa"},
            {"London","67,886,004","English","God Save the Queen"}};


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
        if (position != 0){
            capital.setText("");
            population.setText("");
            language.setText("");
            anthem.setText("");
            selectedContinet = position-1;
            adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, countries[selectedContinet]);
            lv.setAdapter(adp);
        }
        else{
            lv.setAdapter(null);
            capital.setText("");
            population.setText("");
            language.setText("");
            anthem.setText("");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        capital.setText(details[selectedContinet*7+position][0]);
        population.setText(details[selectedContinet*7+position][1]);
        language.setText(details[selectedContinet*7+position][2]);
        anthem.setText(details[selectedContinet*7+position][3]);
    }
}