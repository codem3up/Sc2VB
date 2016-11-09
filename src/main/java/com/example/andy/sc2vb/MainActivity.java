package com.example.andy.sc2vb;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void selectRace(View v)
    {
        int race = v.getId();
        Intent intent;
        switch (race){
            case (R.id.zergBtn):
                intent = new Intent(v.getContext(), ZergActivity.class);
                v.getContext().startActivity(intent);
                break;
            case (R.id.terranBtn):
                intent = new Intent(v.getContext(), TerranActivity.class);
                v.getContext().startActivity(intent);
                break;
            case (R.id.protossBtn):
                intent = new Intent(v.getContext(), ProtossActivity.class);
                v.getContext().startActivity(intent);
                break;
        }
    }

    public void createBuild(View v)
    {
        final View d = v;
        android.app.AlertDialog.Builder dialogBuilder = new android.app.AlertDialog.Builder(this);
        final String[] races = {"Zerg", "Terran", "Protoss"};
        dialogBuilder.setTitle("Select a race");
        dialogBuilder.setItems(races, new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialog, int which){
                //	Toast.makeText(getApplicationContext(), races[which], Toast.LENGTH_SHORT).show();
                if(races[which].equals("Terran"))
                {
                    Intent intent = new Intent(d.getContext(), TerranCreateActivity.class);
                    d.getContext().startActivity(intent);
                }

                if(races[which].equals("Zerg"))
                {
                    Intent intent = new Intent(d.getContext(), ZergCreateActivity.class);
                    d.getContext().startActivity(intent);
                }

                if(races[which].equals("Protoss"))
                {
                    Intent intent = new Intent(d.getContext(), ProtossCreateActivity.class);
                    d.getContext().startActivity(intent);
                }
            }
        });
        android.app.AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

    public void downloadBuilds(View v)
    {}


}
