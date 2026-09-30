package com.example.autopilot;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;
import android.provider.Settings;
import android.view.Gravity;
import android.widget.*;
import java.util.ArrayList;
public class MainActivity extends Activity {
    private LinearLayout list; private final ArrayList<String> tasks=new ArrayList<>();
    @Override public void onCreate(Bundle b){super.onCreate(b); build();}
    private TextView tx(String s,int z){TextView v=new TextView(this);v.setText(s);v.setTextColor(Color.WHITE);v.setTextSize(z);v.setPadding(24,18,24,18);return v;}
    private void build(){
        LinearLayout root=new LinearLayout(this);root.setOrientation(LinearLayout.VERTICAL);root.setPadding(24,24,24,24);root.setBackgroundColor(Color.rgb(11,16,32));
        TextView title=tx("AutoPilot",28);title.setGravity(Gravity.CENTER_VERTICAL);root.addView(title);
        TextView sub=tx("Phone automation maker — stable build",14);sub.setTextColor(Color.LTGRAY);root.addView(sub);
        Button access=new Button(this);access.setText("Enable Accessibility");access.setOnClickListener(v->startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)));root.addView(access);
        Button add=new Button(this);add.setText("Add automation");add.setOnClickListener(v->addTask());root.addView(add);
        Button clear=new Button(this);clear.setText("Clear automations");clear.setOnClickListener(v->{tasks.clear();render();});root.addView(clear);
        list=new LinearLayout(this);list.setOrientation(LinearLayout.VERTICAL);ScrollView scroll=new ScrollView(this);scroll.addView(list);root.addView(scroll,new LinearLayout.LayoutParams(-1,0,1));setContentView(root);render();
    }
    private void addTask(){
        EditText input=new EditText(this);input.setHint("Describe an automation");
        new android.app.AlertDialog.Builder(this).setTitle("New automation").setView(input).setPositiveButton("Save",(d,w)->{String s=input.getText().toString().trim();if(!s.isEmpty()){tasks.add(s);render();}}).setNegativeButton("Cancel",null).show();
    }
    private void render(){
        list.removeAllViews();if(tasks.isEmpty()){list.addView(tx("No automations yet. Add one above.",16));return;}
        for(int i=0;i<tasks.size();i++){final int k=i;LinearLayout row=new LinearLayout(this);row.setOrientation(LinearLayout.HORIZONTAL);TextView t=tx((i+1)+". "+tasks.get(i),16);row.addView(t,new LinearLayout.LayoutParams(0,-2,1));Button run=new Button(this);run.setText("Run");run.setOnClickListener(v->Toast.makeText(this,"Queued: "+tasks.get(k),Toast.LENGTH_SHORT).show());row.addView(run);list.addView(row);}
    }
}
