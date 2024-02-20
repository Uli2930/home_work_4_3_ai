package com.geeks.home_work_4_3_ai.continent;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geeks.home_work_4_3_ai.OnItemClick;
import com.geeks.home_work_4_3_ai.R;
import com.geeks.home_work_4_3_ai.country.CountryFragment;
import com.geeks.home_work_4_3_ai.databinding.FragmentContinentBinding;

import java.util.ArrayList;


public class ContinentFragment extends Fragment implements OnItemClick {

    private FragmentContinentBinding binding;
    private  ArrayList<String> continentList = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentContinentBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        initAdapter();
    }

    private void initAdapter() {
        ContinentAdapter continentAdapter = new ContinentAdapter(continentList,this);
        binding.rvContinents.setAdapter(continentAdapter);
    }

    private void loadData() {
        continentList.add("Евразия");
        continentList.add("Северная Америка");
        continentList.add("Южная Америка");
        continentList.add("Африка");
        continentList.add("Австралия");
    }

    @Override
    public void onClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("keyPosition",position);
        CountryFragment countryFragment = new CountryFragment();
        countryFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, countryFragment).addToBackStack(null).commit();
    }

}
