package com.android.a83terminalseekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.projects.alshell.android.Terminal;
import com.projects.alshell.android.TerminalAnimationType;
import com.projects.alshell.android.TerminalChangedListener;
import com.projects.alshell.android.TerminalSeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TerminalSeekBar terminalSeekBar;
    ArrayList<Terminal> terminals = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        terminalSeekBar = (TerminalSeekBar) findViewById(R.id.seekBar);

        //add to list
        terminals.add(new Terminal(10, Color.CYAN,"This",Terminal.DEFAULT_PRIORITY_NORMAL));
        terminals.add(new Terminal(25, Color.GREEN,"Is",Terminal.DEFAULT_PRIORITY_MEDIATE));
        terminals.add(new Terminal(50, Color.YELLOW,"Terminal",Terminal.DEFAULT_PRIORITY_HIGH));
        terminals.add(new Terminal(70, Color.RED,"SeekBar",Terminal.DEFAULT_PRIORITY_HIGH));
        terminals.add(new Terminal(100, Color.WHITE,"Example",Terminal.DEFAULT_PRIORITY_MEDIATE));

        terminalSeekBar.setTerminals(terminals);
        terminalSeekBar.enablePriorityBlinking(TerminalAnimationType.BLINK_ACTIVE);
        terminalSeekBar.setTerminalChangedListener(new TerminalChangedListener() {
            @Override
            public void onTerminalChanged(Terminal terminal) {
                Toast.makeText(MainActivity.this, ""+terminal.getInformation(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}