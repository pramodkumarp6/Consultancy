package com.gravitational.consultancy.pramod.user.dash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.github.barteksc.pdfviewer.PDFView;
import com.gravitational.consultancy.pramod.user.R;
import com.gravitational.consultancy.pramod.user.adapter.DowonloadAdapter;
import com.gravitational.consultancy.pramod.user.model.DownloadItem;

import java.util.ArrayList;
import java.util.List;

public class Document_View extends AppCompatActivity {
    private PDFView pdfView;
    private RecyclerView recyclerView;

    private DowonloadAdapter dowonloadAdapter;

    private List<DownloadItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document__view);
        getSupportActionBar().setTitle("Document View");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().getHeight();



    }


    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
