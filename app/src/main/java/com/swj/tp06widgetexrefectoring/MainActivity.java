package com.swj.tp06widgetexrefectoring;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.swj.tp06widgetexrefectoring.databinding.ActivityMainBinding;
import com.swj.tp06widgetexrefectoring.databinding.DialogBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    int clickCount=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding.ivOverflow.setOnClickListener(view ->
            Toast.makeText(MainActivity.this, "overflow", Toast.LENGTH_SHORT).show()
        );

        binding.ivHeart.setOnClickListener(view ->
            Toast.makeText(MainActivity.this, "Heart", Toast.LENGTH_SHORT).show()
        );

        binding.ivComment.setOnClickListener(view ->
            Toast.makeText(MainActivity.this, "Comment", Toast.LENGTH_SHORT).show()
        );

        binding.ivSend.setOnClickListener(view ->
            Toast.makeText(MainActivity.this, "Send", Toast.LENGTH_SHORT).show()
        );

        binding.ivBookmark.setOnClickListener(view ->
            Toast.makeText(MainActivity.this, "Bookmark", Toast.LENGTH_SHORT).show()
        );

        binding.ivCenterImg.setOnClickListener(view -> {
            DialogBinding dialogBinding = DialogBinding.inflate(getLayoutInflater());
            AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                                    .setView(dialogBinding.getRoot()).create();
            dialog.show();

            dialogBinding.dialogMainIv.setOnClickListener(view1 -> {
                if(clickCount == 0) dialogBinding.dialogMainIv.setImageResource(R.drawable.newyork);
                else if(clickCount == 1) dialogBinding.dialogMainIv.setImageResource(R.drawable.paris);
                else {
                    dialogBinding.dialogMainIv.setImageResource(R.drawable.sydney);
                    clickCount = -1;
                }
                clickCount++;
            });

            dialogBinding.dialogIv.setOnClickListener(view2 -> {
                if(clickCount == 0) dialogBinding.dialogMainIv.setImageResource(R.drawable.newyork);
                else if(clickCount == 1) dialogBinding.dialogMainIv.setImageResource(R.drawable.paris);
                else {
                    dialogBinding.dialogMainIv.setImageResource(R.drawable.sydney);
                    clickCount = -1;
                }
                clickCount++;
            });
        });
    }
}