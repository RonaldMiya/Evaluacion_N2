package rmiya.com.evaluacion_n2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import rmiya.com.evaluacion_n2.R;
import rmiya.com.evaluacion_n2.adapters.CompanyAdapter;
import rmiya.com.evaluacion_n2.models.Company;
import rmiya.com.evaluacion_n2.repositories.CompanyRepository;

public class Search2Activity extends AppCompatActivity {

    private List<Company> mExampleList = CompanyRepository.getList();
    RecyclerView recyclerView;
    EditText editText;
    CompanyAdapter companyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search2);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        companyAdapter = new CompanyAdapter();
        companyAdapter.setCompany(CompanyRepository.getList());

        recyclerView.setAdapter(companyAdapter);

        editText = findViewById(R.id.buscar1);



        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

    }


    private void filter(String s) {

        ArrayList<Company> filteredList = new ArrayList<>();

        for (Company item : mExampleList) {
            if (item.getName().toLowerCase().contains(s.toLowerCase())) {filteredList.add(item);}
        }

        companyAdapter.filterList(filteredList);

    }


}
