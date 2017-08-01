package com.procesosoperaciones.app;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.Menu;
import android.view.MenuItem;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.util.ArticleBuilder;

public class TracingDetailActivity extends AppCompatActivity {

    ArticleBuilder articleBuilder;
    DocumentView generalDocumentView;
    DocumentView commentDocumentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracing_detail);

        articleBuilder = new ArticleBuilder();
        generalDocumentView = (DocumentView) findViewById(R.id.generalDocumentView);
        commentDocumentView = (DocumentView) findViewById(R.id.commentDocumentView);

        articleBuilder.append(getResources().getText(R.string.perspective), false, new RelativeSizeSpan(2f), new StyleSpan(Typeface.BOLD));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //Item selected in menu.
        switch (item.getItemId()){
            case R.id.back:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

