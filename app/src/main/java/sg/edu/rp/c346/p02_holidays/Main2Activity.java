package sg.edu.rp.c346.p02_holidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<holidays> holiday, secular, religion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv = (ListView) this.findViewById(R.id.lv2);

        // Create a few food objects in Food array
        holiday = new ArrayList<holidays>();
        secular = new ArrayList<holidays>();
        religion = new ArrayList<holidays>();

        secular.add(new holidays("New Year's Day", R.drawable.new_year, "1 January 2020"));
        religion.add(new holidays("Chinese New Year", R.drawable.cny, "25-26 January 2020"));
        religion.add(new holidays("Good Friday", R.drawable.good_friday, "10 April 2020"));
        secular.add(new holidays("Labour Day", R.drawable.labour_day, "1 May 2020"));
        secular.add(new holidays("Vesak Day", R.drawable.vesak_day, "7 May 2020"));
        secular.add(new holidays("Hari Raya Puasa", R.drawable.hari_raya_puasa, "24 May 2020"));
        secular.add(new holidays("Hari Raya Haji", R.drawable.hari_raya_haji, "31 July 2020"));
        secular.add(new holidays("National Day", R.drawable.national_day, "9 August 2020"));
        secular.add(new holidays("Deepavali", R.drawable.deepavali, "14 November 2020"));
        secular.add(new holidays("Christmas Day", R.drawable.christmas, "25 December 2020"));
        // Link this Activity object, the row.xml layout for
        //  each row and the food String array together

        Intent i = getIntent();
        int number = i.getIntExtra("number", 0);

        if(number == 0){
            holiday = secular;
        }else{
            holiday = religion;
        }

        aa = new HolidaysAdapter(this, R.layout.ethnic, holiday);
        lv.setAdapter(aa);



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                holidays selected = holiday.get(position);

                Toast.makeText(Main2Activity.this, selected.getName()
                                + " Date: " + selected.getDate(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }

}
