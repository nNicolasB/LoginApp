package com.example.constraintlayout_nicolasbarcha.contacts;
import com.example.constraintlayout_nicolasbarcha.R;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ContactViewHolder> {

    private List<Contact> contactList;
    private OnContactClickListener listener;

    public ContactListAdapter(List<Contact> contactList, OnContactClickListener listener) {
        this.contactList = contactList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        holder.name.setText(contact.getName());
        holder.phoneNumber.setText(contact.getPhoneNumber());
        holder.contactImage.setImageResource(contact.getImage());  // Set the contact image

        // Remove item on button click
        holder.removeButton.setOnClickListener(v -> {
            listener.onRemoveClick(contact);
        });

        // Handle item click
        holder.itemView.setOnClickListener(v -> {
            listener.onItemClick(contact);
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView name, phoneNumber;
        ImageView contactImage;  // Add ImageView reference
        Button removeButton;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.contactName);
            phoneNumber = itemView.findViewById(R.id.contactPhoneNumber);
            contactImage = itemView.findViewById(R.id.contactImage);  // Initialize ImageView
            removeButton = itemView.findViewById(R.id.buttonRemove);
        }
    }

    public interface OnContactClickListener {
        void onItemClick(Contact contact);
        void onRemoveClick(Contact contact);
    }
}
