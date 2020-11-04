package com.example.fragmentdannavigation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment implements View.OnClickListener {

    EditText edtCategoryName;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnSubCategory = view.findViewById(R.id.btn_sub_category);
        edtCategoryName = view.findViewById(R.id.edtNamaCategory);
        btnSubCategory.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_sub_category) {
            DetailCategoryFragment mDetailCategoryFragment = new DetailCategoryFragment();

            Bundle mBundle = new Bundle();
            mBundle.putString(DetailCategoryFragment.EXTRA_NAME, edtCategoryName.getText().toString());
            String description = "Ini dikirim dengan getter setter ";

            mDetailCategoryFragment.setArguments(mBundle);
            mDetailCategoryFragment.setDescription(description);

       /*
       Method addToBackStack akan menambahkan fragment ke backstack
       Behaviour dari back button akan cek fragment dari backstack,
       jika ada fragment di dalam backstack maka fragment yang akan di close / remove
       jika sudah tidak ada fragment di dalam backstack maka activity yang akan di close / finish
        */

            FragmentManager mFragmentManager = getFragmentManager();
            if (mFragmentManager != null) {
                mFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, mDetailCategoryFragment, DetailCategoryFragment.class.getSimpleName())
                        .addToBackStack(null)
                        .commit();
            }
        }
    }



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailCategoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailCategoryFragment newInstance(String param1, String param2) {
        DetailCategoryFragment fragment = new DetailCategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }
}