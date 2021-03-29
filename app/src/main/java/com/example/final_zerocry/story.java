package com.example.final_zerocry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

public class story extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        String[] urls={"https://wcd.nic.in/bbbp-schemes","https://pmmodiyojana.in/pradhanmantri-ration-subsidy-yojana/","https://nsdcindia.org/skillcentres","https://www.hindiyojna.com/solar-charkha-scheme/","https://pmkisan.gov.in/#","https://pmmodiyojana.in/tag/pradhanmantri-gramin-ujala-yojana-apply/","https://www.uday.gov.in/home.php","https://pmjay.gov.in/about/pmjay","https://pmayuclap.gov.in/","https://financialservices.gov.in/insurance-divisions/Government-Sponsored-Socially-Oriented-Insurance-Schemes/Pradhan-Mantri-Jeevan-Jyoti-Bima-Yojana(PMJJBY)","https://anct.org.in/loan/mudra-loan.html?gclid=Cj0KCQjw9YWDBhDyARIsADt6sGZtTCPQlRf5v9Ag0d4vr-ee1N_GDmzMCb-TWhtbfdGmthVi3aUbCt4aAvW5EALw_wcB","http://omms.nic.in/"};

        ArrayList<scheme> phr=new ArrayList<>();
        phr.add(new scheme("BETI BACHAO BETI PADHAO","Aim at Women Empowerment",R.drawable.beti,"https://wcd.nic.in/bbbp-schemes"));
        phr.add(new scheme("PM GARIB KALYAN YOJANA","Aims at SOCIAL UPLIFTING",R.drawable.modi,"https://pmmodiyojana.in/pradhanmantri-ration-subsidy-yojana/"));
        phr.add(new scheme("MISSION SKILL INDIA","Aims at employment",R.drawable.skill,"https://nsdcindia.org/skillcentres"));
        phr.add(new scheme("SOLAR CHARKHA YOJANA","Aims at employment",R.drawable.solar,"https://www.hindiyojna.com/solar-charkha-scheme/"));
        phr.add(new scheme("KISAN YOJANA","Aims at farmers' upliftment",R.drawable.kisan,"https://pmkisan.gov.in/#"));
        phr.add(new scheme("PM GRAMIN UJALA YOJANA","Incrementing electrical facilities",R.drawable.ujala,"https://pmmodiyojana.in/tag/pradhanmantri-gramin-ujala-yojana-apply/"));
        phr.add(new scheme("UJWAL DISCOM ASSURANCE YOJANA","Provides financial turnaround of power distribution companies",R.drawable.ujwal,"https://www.uday.gov.in/home.php"));
        phr.add(new scheme("PM JAN AROGYA YOJANA","Provides medical support",R.drawable.arogya,"https://pmjay.gov.in/about/pmjay"));
        phr.add(new scheme("PM AWAS YOJANA-URBAN","Aims at providing shelter to all",R.drawable.awas,"https://pmayuclap.gov.in/"));
        phr.add(new scheme("PADHAN MANTRI JEEVAN JYOTI BEEMA YOJANA","Aims at easy financial service",R.drawable.mantri,"https://financialservices.gov.in/insurance-divisions/Government-Sponsored-Socially-Oriented-Insurance-Schemes/Pradhan-Mantri-Jeevan-Jyoti-Bima-Yojana(PMJJBY)"));
        phr.add(new scheme("PM MUDRA YOJANA","Aims at easy business supporting financial loans",R.drawable.mudra,"https://anct.org.in/loan/mudra-loan.html?gclid=Cj0KCQjw9YWDBhDyARIsADt6sGZtTCPQlRf5v9Ag0d4vr-ee1N_GDmzMCb-TWhtbfdGmthVi3aUbCt4aAvW5EALw_wcB"));
        phr.add(new scheme("PM GRAM SADAK YOJANA","Aims to connect the villages to cities",R.drawable.sadak,"http://omms.nic.in/"));



        WordAdapter adapter=new WordAdapter(this,phr);
        ListView listView=(ListView)findViewById(R.id.phrases_ListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Toast.makeText(story.this, "You clicked"+phr.get(position), Toast.LENGTH_SHORT).show();
                Intent openLinksIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urls[position]));
                startActivity(openLinksIntent);

            }
        });

    }
}