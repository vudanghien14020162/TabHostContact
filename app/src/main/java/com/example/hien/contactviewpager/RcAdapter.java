package com.example.hien.contactviewpager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hien on 8/4/17.
 */

public class RcAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements View.OnClickListener {

    private IFContact mIF;

    public RcAdapter(IFContact mIF) {
        this.mIF = mIF;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_contact, parent, false);

        ViewContact contact = new ViewContact(view, this);

        return contact;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemContact contact = mIF.getItemContact(position);

        ViewContact viewContact = (ViewContact) holder;

        viewContact.tvName.setText(contact.getNamePerson());
        viewContact.imgFace.setImageResource(contact.getIdContact());

    }

    @Override
    public int getItemCount() {
        return mIF.getSize();
    }

    @Override
    public void onClick(View view) {

        IGetPosition IGetPosition = (IGetPosition) view.getTag();

        int position = IGetPosition.getPosition();

        mIF.onClickItem(position);

    }

    private class ViewContact extends RecyclerView.ViewHolder{

        private ImageView imgFace;
        private TextView tvName;

        public ViewContact(View itemView, View.OnClickListener click) {
            super(itemView);

            imgFace = itemView.findViewById(R.id.img_contact);
            tvName = itemView.findViewById(R.id.tv_contact);

            IGetPosition getPosition = new IGetPosition() {
                @Override
                public int getPosition() {
                    return getAdapterPosition();
                }
            };

            itemView.setTag(getPosition);
            itemView.setOnClickListener(click);

        }
    }

    public interface IFContact{

        int getSize();

        ItemContact getItemContact(int position);

        void onClickItem(int position);

    }
}
