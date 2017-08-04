package com.example.hien.contactviewpager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hien on 8/4/17.
 */

public class FragmentContact extends Fragment implements RcAdapter.IFContact {

    private RecyclerView rcContact;

    private RcAdapter mAdapter;

    private List<ItemContact> listItem;

    private static final String TAG = FragmentContact.class.getSimpleName();

    //onAttach tuong ung voi viec gan framgment vaoi activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Log.d(TAG, "___onAttach!!!");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "___onCreate");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViewByIds(view);
        initData();
        initComponents();
        setEvents(view);

    }

    private void initData() {

        listItem = new ArrayList<>();

        listItem.add(new ItemContact(android.R.drawable.sym_contact_card, "Person One"));
        listItem.add(new ItemContact(android.R.drawable.screen_background_dark, "Person Two"));
        listItem.add(new ItemContact(android.R.drawable.star_big_off, "Person Three"));
        listItem.add(new ItemContact(android.R.drawable.star_on, "Person Four"));
        listItem.add(new ItemContact(android.R.drawable.sym_def_app_icon, "Person Five"));
        listItem.add(new ItemContact(android.R.drawable.sym_contact_card, "Person Six"));
        listItem.add(new ItemContact(android.R.drawable.sym_def_app_icon, "Person Seven"));
        listItem.add(new ItemContact(android.R.drawable.ic_delete, "Person Eight"));
        listItem.add(new ItemContact(android.R.drawable.ic_dialog_info, "Person Nice"));
        listItem.add(new ItemContact(android.R.drawable.ic_input_get, "Person Ten"));
        listItem.add(new ItemContact(android.R.drawable.ic_input_add, "Person Eleven"));
        listItem.add(new ItemContact(android.R.drawable.ic_lock_idle_alarm, "Person 13"));
        listItem.add(new ItemContact(android.R.drawable.ic_lock_idle_low_battery, "Person 14"));
        listItem.add(new ItemContact(android.R.drawable.ic_dialog_map, "Person 15"));
        listItem.add(new ItemContact(android.R.drawable.ic_secure, "Person 16"));


    }

    private void setEvents(View view) {

    }

    private void initComponents() {

        mAdapter = new RcAdapter(this);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());

        manager.setOrientation(LinearLayoutManager.VERTICAL);

        DividerItemDecoration divider = new DividerItemDecoration(
                getContext(), manager.getOrientation());

        Drawable drawable = getResources().getDrawable(R.drawable.shape_drawer);

        divider.setDrawable(drawable);

        rcContact.addItemDecoration(divider);

        rcContact.setAdapter(mAdapter);
        rcContact.setLayoutManager(manager);


    }

    private void findViewByIds(View v) {
        rcContact = v.findViewById(R.id.rc_contact);

    }

    //ket thuc fragment  khi no duoc tach ra khoi fragment
    @Override
    public void onDetach() {
        Log.d(TAG, "__onDetach!!!");
        super.onDetach();
    }

    @Override
    public int getSize() {
        return listItem.size();
    }

    @Override
    public ItemContact getItemContact(int position) {
        return listItem.get(position);
    }

    @Override
    public void onClickItem(int position) {
        ItemContact itemContact = listItem.get(position);

        showMsg("Information: " + itemContact.getNamePerson());
    }

    private void showMsg(String msg){
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
