package com.svhub.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.joanzapata.android.iconify.IconDrawable;
import com.joanzapata.android.iconify.Iconify;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.svhub.R;
import com.svhub.base.FormItemHolder;

import org.w3c.dom.Text;

import java.util.Vector;
import java.util.zip.Inflater;

/**
 * Created by Martin on 26.04.2015.
 */
public class UserWelcomeFragment extends Fragment {
    ParseUser user;
    LayoutInflater inflater;
    View root;
    public UserWelcomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_main_screen, container, false);
        this.inflater =inflater;
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        user = ParseUser.getCurrentUser();
        if(user==null){
            Intent intent = new Intent(this.getActivity(), LoginActivity.class);
            startActivity(intent);
        }else{
            try {
                user.fetch();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            View welcome = inflater.inflate(R.layout.cardviewprofile,null, false);
            TextView txt_username = (TextView)welcome.findViewById(R.id.txtView_username);
            txt_username.setText(user.getString("fullname"));


            /* adding attributes for users*/
            String[] itemLabels= getActivity().getResources().getStringArray(R.array.formItems);
            String[] itemicons= getActivity().getResources().getStringArray(R.array.formIcons);
            String[] itemkeys= getActivity().getResources().getStringArray(R.array.formItemsKeys);
            LinearLayout formHolder = (LinearLayout)welcome.findViewById(R.id.formItemsHolder);
            int i =0;
            for(String item:itemLabels ){
                View itemroot = inflater.inflate(R.layout.formview,null,false);
                ((ImageView)itemroot.findViewById(R.id.iv_form_icon)).setImageDrawable(
                        new IconDrawable(getActivity(),Enum.valueOf(Iconify.IconValue.class,itemicons[i])));
                Object  itemData= user.get(itemkeys[i++]);
                if(itemData!=null){
                    ((TextView)itemroot.findViewById((R.id.tv_form_input))).setText(itemData.toString());
                }

                ((TextView)itemroot.findViewById((R.id.tv_form_input))).setHint(item);
                formHolder.addView(itemroot);
            }

            LinearLayout content = (LinearLayout)root.findViewById(R.id.mainFragmentContent);
            content.addView(welcome);

        }
    }
}
