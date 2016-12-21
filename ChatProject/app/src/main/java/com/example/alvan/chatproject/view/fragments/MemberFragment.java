package com.example.alvan.chatproject.view.fragments;

/**
 * Created by tkcbintang on 22/12/16.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alvan.chatproject.R;
import com.example.alvan.chatproject.view.adapter.MemberListAdapter;
import com.example.alvan.chatproject.model.mamber.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberFragment extends Fragment {

    private RecyclerView listMember;
    private LinearLayoutManager linearLayoutManager;
    private MemberListAdapter memberListAdapter;

    protected Context context;

    public static MemberFragment newInstance(){
        return new MemberFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recycler_view_frag, container, false);

        listMember = (RecyclerView) rootView.findViewById(R.id.listmamber);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        linearLayoutManager = new LinearLayoutManager(context);
        memberListAdapter = new MemberListAdapter();

        listMember.setLayoutManager(linearLayoutManager);
        listMember.setAdapter(memberListAdapter);

        loadData();
    }

    private void loadData(){
        List<Member> memberList = new ArrayList<>();
        Member member;

        int thumb[] = {R.drawable.ayana_shahab, R.drawable.beby_chaseara_anadila, R.drawable.delima_rizky,
                R.drawable.dena_siti_rohyati, R.drawable.elaine_hartanto, R.drawable.frieska_anastasia_laksani,
               };

        String name[] = {"Ayana Shahab", "Beby Chaesara Anadila", "Delima Rizky", "Dena Siti Rohyati",
                "Elaine Hartanto", "Frieska Anastasia Laksani", "Gabriella M. W.", "Ghaida Farisya",
                "Jennifer Rachel Natasya", "Jessica Vania Widjaja", "Jessica Veranda", "Melody Nurramdhani Laksani",
                "Nabilah Ratna Ayu Azalia", "Rezky Wiranti Dhike", "Sendy Ariani", "Shania Junianatha",
                "Shinta Naomi", "Sofia Meifaliani", "Sonia Natalia", "Thalia Ivanka Elizabeth"};

        String team = "Isi Pesan";

        for(int i=0; i < thumb.length; i++){
            member = new Member();

            member.setId(i+1);
            member.setName(name[i]);
            member.setTeam(team);
            member.setThumb(thumb[i]);

            memberList.add(member);
        }

        memberListAdapter.addAll(memberList);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
