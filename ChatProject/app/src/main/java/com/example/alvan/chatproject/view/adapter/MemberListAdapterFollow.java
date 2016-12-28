package com.example.alvan.chatproject.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alvan.chatproject.R;
import com.example.alvan.chatproject.model.mamber.Member;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alvan on 23/12/16.
 */

public class MemberListAdapterFollow extends RecyclerView.Adapter<MemberListAdapter.MemberViewHolder> {
    private List<Member> memberList;

    public MemberListAdapterFollow() {
        memberList = new ArrayList<>();
    }

    private void add(Member item) {
        memberList.add(item);
        notifyItemInserted(memberList.size() - 1);
    }

    public void addAll(List<Member> memberList) {
        for (Member member : memberList) {
            add(member);
        }
    }

    public void remove(Member item) {
        int position = memberList.indexOf(item);
        if (position > -1) {
            memberList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public Member getItem(int position){
        return memberList.get(position);
    }


    @Override
    public MemberListAdapter.MemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_acount, parent, false);
        MemberListAdapter.MemberViewHolder memberViewHolder = new MemberListAdapter.MemberViewHolder(view);
        return memberViewHolder;
    }

    @Override
    public void onBindViewHolder(MemberListAdapter.MemberViewHolder holder, int position) {
        final Member member = memberList.get(position);

        holder.memberThumb.setImageResource(member.getThumb());
        //holder.memberFollow.setImageResource(member.getFollow());
        holder.memberName.setText(member.getName());
        holder.memberTeam.setText(member.getTeam());
    }

    @Override
    public int getItemCount() {
        return memberList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    static class MemberViewHolder extends RecyclerView.ViewHolder {

        ImageView memberThumb;
        //mageView memberFollow;
        TextView memberName;
        TextView memberTeam;

        public MemberViewHolder(View itemView) {
            super(itemView);
            memberThumb = (ImageView) itemView.findViewById(R.id.thumb);
            memberName = (TextView) itemView.findViewById(R.id.name);
            memberTeam = (TextView) itemView.findViewById(R.id.team);
            //memberFollow = (ImageView) itemView.findViewById(R.id.follow);
        }
    }
}
