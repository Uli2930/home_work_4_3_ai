package com.geeks.home_work_4_3_ai.country;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.geeks.home_work_4_3_ai.databinding.FragmentCountryBinding;
import java.util.ArrayList;


public class CountryFragment extends Fragment {
    private FragmentCountryBinding binding;
    private ArrayList<String> countryList = new ArrayList<>();
    Integer position;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCountryBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        assert getArguments() != null;
        position = getArguments().getInt("keyPosition");
        CountryAdapter countryAdapter = new CountryAdapter(countryList);
        binding.rvCountry.setAdapter(countryAdapter);
        checkPosition(position);
    }

    private void checkPosition(int position) {
        switch (position) {
            case 0:
                loadEurasia();
                break;
            case 1:
                loadNorthAmerica();
                break;
            case 2:
                loadSouthAmerica();
                break;
            case 3:
                loadAfrica();
                break;
            case 4:
                loadAustralia();
                break;
        }
    }

    private void loadAustralia() {
        countryList.add("Австралия");
    }

    private void loadAfrica() {
        countryList.add("Нигерия");
        countryList.add("Танзания");
        countryList.add("Марокко");
        countryList.add("Гана");
        countryList.add("Кения");

    }

    private void loadSouthAmerica() {
        countryList.add("Панама");
        countryList.add("Колумбия");
        countryList.add("Перу");
        countryList.add("Чили");
        countryList.add("Аргентина");
    }

    private void loadNorthAmerica() {
        countryList.add("США");
        countryList.add("Ямайка");
        countryList.add("Канада");
        countryList.add("Мексика");
        countryList.add("Таити");
    }

    private void loadEurasia() {
        countryList.add("Кыргызстан");
        countryList.add("Узбекистан");
        countryList.add("Казахстан");
        countryList.add("Россия");
        countryList.add("Турция");
    }

}