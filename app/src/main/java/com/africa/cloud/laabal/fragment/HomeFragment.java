package com.africa.cloud.laabal.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.africa.cloud.laabal.R;
import com.africa.cloud.laabal.activity.AboutUsActivity;
import com.africa.cloud.laabal.activity.CritiqueActivity;
import com.africa.cloud.laabal.activity.InscriptionClientsActivity;
import com.africa.cloud.laabal.activity.NewsActivity;
import com.africa.cloud.laabal.activity.PrivacyPolicyActivity;
import com.africa.cloud.laabal.activity.ReclamationActivity;
import com.africa.cloud.laabal.activity.SuggestionActivity;
import com.africa.cloud.laabal.activity.ZonesActivity;
import com.africa.cloud.laabal.models.Reclamation;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Activity context;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        context=getActivity();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }




    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void onStart(){
        super.onStart();
        TextView noti=(TextView) context.findViewById(R.id.notification);
        noti.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                Intent intent=new Intent(context, InscriptionClientsActivity.class);
                startActivity(intent);
            }

        });


        TextView inscription = (TextView) context.findViewById(R.id.inscrire);
        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inscription = new Intent(context,InscriptionClientsActivity.class);
                startActivity(inscription);
            }
        });

        TextView zones = (TextView) context.findViewById(R.id.zones);
        zones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent zone = new Intent(context, ZonesActivity.class);
                startActivity(zone);
            }
        });


        TextView reclams = (TextView) context.findViewById(R.id.reclamation);
        reclams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent reclam = new Intent(context, ReclamationActivity.class);
                startActivity(reclam);
            }
        });


        TextView criti = (TextView) context.findViewById(R.id.critique);
        criti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent crit = new Intent(context, CritiqueActivity.class);
                startActivity(crit);
            }
        });


        TextView sug = (TextView) context.findViewById(R.id.suggestion);
        sug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sugger = new Intent(context, SuggestionActivity.class);
                startActivity(sugger);
            }
        });


        TextView prom = (TextView) context.findViewById(R.id.promoteurs);
        prom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent promo = new Intent(context, PrivacyPolicyActivity.class);
                startActivity(promo);

            }
        });

        TextView propos = (TextView) context.findViewById(R.id.laabal);
        propos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent laabal = new Intent(context, AboutUsActivity.class);
                startActivity(laabal);
            }
        });


        TextView nouve = (TextView) context.findViewById(R.id.nouveaute);
        nouve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent news = new Intent(context, NewsActivity.class);
                startActivity(news);
            }
        });

    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
}
