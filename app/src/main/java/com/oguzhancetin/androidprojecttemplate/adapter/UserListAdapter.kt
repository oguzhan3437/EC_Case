package com.oguzhancetin.androidprojecttemplate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oguzhancetin.androidprojecttemplate.databinding.UserCardBinding
import com.oguzhancetin.androidprojecttemplate.model.User

class UserListAdapter(
    private val context: Context,
    private var userList: List<User>,
    private val onClickCard: (User) -> Unit
) :
    RecyclerView.Adapter<UserListAdapter.ViewHolder>() {


    class ViewHolder(
        private val binding: UserCardBinding,
        private val onClickCard: (User) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(user: User) {
            binding.textView.text = user.userName
            binding.root.setOnClickListener {
                onClickCard.invoke(user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            UserCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onClickCard
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun refreshList(userList: List<User>) {
        this.userList = userList
        notifyDataSetChanged()
    }


}
