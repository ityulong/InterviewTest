package xaircraft.interviewtest.ContactImplement.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.List;

import xaircraft.interviewtest.ContactImplement.model.Contact;
import xaircraft.interviewtest.R;

/**
 * Created by chenyulong on 2017/9/6.
 */

public class ContactListAdapter extends ArrayAdapter<Contact> {
    private int idItemLayout;
    private SectionIndexer mIndexer;

    public ContactListAdapter(Context context, int resource, List<Contact> objects) {
        super(context, resource, objects);
        idItemLayout = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contact contact = getItem(position);
        LinearLayout layout = null;
        if (convertView == null) {
            layout = (LinearLayout) LayoutInflater.from(getContext()).inflate(idItemLayout, null);
        } else {
            layout = (LinearLayout) convertView;
        }
        TextView name = (TextView) layout.findViewById(R.id.tv_contact_name);
        LinearLayout sortKeyLayout = (LinearLayout) layout.findViewById(R.id.ly_contact_head);
        TextView sortKey = (TextView) layout.findViewById(R.id.tv_contact_title);
        name.setText(contact.getName());
        int section = mIndexer.getSectionForPosition(position);
        Log.d("adapter-test", "getView: " + "name : " + contact.getName() + ",position :" + position + ",section :" + section + ",getPositionForSection :" + mIndexer.getPositionForSection(section));
        if (position == mIndexer.getPositionForSection(section)) {
            Log.d("adapter-test", "getView: " + ",position :" + position + " is section :" + section + "`s first!");
            sortKey.setText(contact.getSortKey());
            sortKeyLayout.setVisibility(View.VISIBLE);
        } else {
            sortKeyLayout.setVisibility(View.GONE);
        }
        return layout;
    }

    public void setIndexer(SectionIndexer indexer) {
        mIndexer = indexer;
    }
}
