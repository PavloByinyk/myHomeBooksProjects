package ua.com.pbyinyk.criminalintent;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 1 on 29.04.2016.
 */
public class CrimeListFragment extends Fragment {
    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter crimeAdapter;
    private boolean mSubtitleVisible;
    private static final String SAVED_SUBTITLE_VISIBLE = "subtitle";
    private Callbacks mCallbacks;
    /**
     * Обязательный интерфейс для активности-хоста.
     */
    public interface Callbacks {
        void onCrimeSelected(Crime crime);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallbacks = (Callbacks) activity;
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(savedInstanceState!=null){
            mSubtitleVisible=savedInstanceState.getBoolean(SAVED_SUBTITLE_VISIBLE);
        }
        View view=inflater.inflate(R.layout.fragment_crime_list,container,false);
        mCrimeRecyclerView=(RecyclerView)view.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(SAVED_SUBTITLE_VISIBLE,mSubtitleVisible);
    }

    public void updateUI() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();
        if (crimeAdapter == null) {
            crimeAdapter = new CrimeAdapter(crimes);
            mCrimeRecyclerView.setAdapter(crimeAdapter);
        } else {
            crimeAdapter.setCrimes(crimes);
            crimeAdapter.notifyDataSetChanged();
        }
        updateSubtitle();
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_crime_list,menu);

        MenuItem subtitleItem = menu.findItem(R.id.menu_item_show_subtitle);
        if (mSubtitleVisible) {
            subtitleItem.setTitle(R.string.hide_subtitle);
        } else {
            subtitleItem.setTitle(R.string.show_subtitle);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_new_crime:
                Crime crime = new Crime();
                CrimeLab.get(getActivity()).addCrime(crime);
                updateUI();
                mCallbacks.onCrimeSelected(crime);
                return true;
            case R.id.menu_item_show_subtitle:
                mSubtitleVisible = !mSubtitleVisible;
                getActivity().invalidateOptionsMenu();
                updateSubtitle();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateSubtitle() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        int crimeCount = crimeLab.getCrimes().size();
        String subtitle = getString(R.string.subtitle_format, crimeCount);
        if (!mSubtitleVisible) {
            subtitle = null;
        }
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setSubtitle(subtitle);
    }

    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private CheckBox mSolvedCheckBox;

        private Crime mCrime;

        public CrimeHolder(View itemView) {
            super(itemView);
            mTitleTextView = (TextView) itemView.findViewById(R.id.crime_list_item_titleTextView);
            mDateTextView=(TextView) itemView.findViewById(R.id.crime_list_item_dateTextView);
            mSolvedCheckBox=(CheckBox) itemView.findViewById(R.id.crime_list_item_solvedCheckBox);

            itemView.setOnClickListener(this);

        }
        public void bindCrime(Crime crime) {
            mCrime = crime;
            mTitleTextView.setText(mCrime.getmTitle());
            mDateTextView.setText(mCrime.getmDate().toString());
            mSolvedCheckBox.setChecked(mCrime.ismSolved());
        }

        @Override
        public void onClick(View v) {
            mCallbacks.onCrimeSelected(mCrime);

        }
    }
    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {
        private List<Crime> mCrimes;
        public CrimeAdapter(List<Crime> crimes) {
            mCrimes = crimes;
        }

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater=LayoutInflater.from(getActivity());
            View v=inflater.inflate(R.layout.list_item_crime,parent,false);

            return new CrimeHolder(v);
        }

        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            Crime crime=mCrimes.get(position);
            holder.bindCrime(crime);
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }

        public void setCrimes(List<Crime> crimes) {
            mCrimes = crimes;
        }
    }
    }
