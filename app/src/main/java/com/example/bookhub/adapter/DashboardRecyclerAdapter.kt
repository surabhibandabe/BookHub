package com.example.bookhub.adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookhub.R
import com.example.bookhub.activity.DescriptionActivity
import com.example.bookhub.model.Book
import com.squareup.picasso.Picasso
import java.util.ArrayList

//import android.content.Context
//import android.content.Intent
//import android.view.LayoutInflater
//
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.LinearLayout
//
//import androidx.recyclerview.widget.RecyclerView
//import com.example.bookhub.R
//import java.util.ArrayList
//import android.widget.TextView
//import android.widget.Toast
//import com.example.bookhub.activity.DescriptionActivity
//import com.example.bookhub.model.Book
//import com.squareup.picasso.Picasso
class DashboardRecyclerAdapter(val context:Context,val itemList:ArrayList<Book>):RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.recycler_dashboard_single_row,parent,false)
         return DashboardViewHolder(view)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
               val book=itemList[position]
       holder.textBookName.text=book.bookName
        holder.textBookAuthor.text=book.bookAuthor
        holder.textBookPrice.text=book.bookPrice
        holder.textBookRating.text=book.bookRating
//        holder.imgBookImage.setImageResource(book.bookImage)
        Picasso.get().load(book.bookImage).error(R.drawable.default_book_cover).into(holder.imgBookImage)

        holder.Content.setOnClickListener {
            val intent= Intent(context, DescriptionActivity::class.java)
            intent.putExtra("book_id",book.bookId)
            context.startActivity(intent)
            }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
    class DashboardViewHolder(view:View):RecyclerView.ViewHolder(view){
        //
        val textBookName:TextView=view.findViewById(R.id.txtBookName)
        val textBookAuthor:TextView=view.findViewById(R.id.txtBookAuthor)
        val textBookPrice:TextView=view.findViewById(R.id.txtBookPrice)
        val textBookRating:TextView=view.findViewById(R.id.txtBookRating)
        val imgBookImage: ImageView =view.findViewById(R.id.imgBookImage)
        val Content: LinearLayout =view.findViewById(R.id.Content)
    }

}


//class DashboardRecyclerAdapter(val context:Context,val itemList:ArrayList<Book>) :RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder> (){
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
//        val view=LayoutInflater.from(parent.context).inflate(R.layout.recycler_dashboard_single_row,parent,false)
//        return DashboardViewHolder(view)
//
//    }
//
//    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
//        val book=itemList[position]
//        holder.textBookName.text=book.bookName
//        holder.textBookAuthor.text=book.bookAuthor
//        holder.textBookPrice.text=book.bookPrice
//        holder.textBookRating.text=book.bookRating
////        holder.imgBookImage.setImageResource(book.bookImage)
//        Picasso.get().load(book.bookImage).error(R.drawable.default_book_cover).into(holder.imgBookImage)
//
//        holder.Content.setOnClickListener {
//            val intent=Intent(context,DescriptionActivity::class.java)
//            intent.putExtra("book_id",book.bookId)
//            context.startActivity(intent)
//        }
//
//
//    }
//
//    override fun getItemCount(): Int {
//        return itemList.size
//
//    }
//    class DashboardViewHolder(view:View):RecyclerView.ViewHolder(view){
//        val textBookName:TextView=view.findViewById(R.id.txtBookName)
//        val textBookAuthor:TextView=view.findViewById(R.id.txtBookAuthor)
//        val textBookPrice:TextView=view.findViewById(R.id.txtBookPrice)
//       val textBookRating:TextView=view.findViewById(R.id.txtBookRating)
//      val imgBookImage:ImageView=view.findViewById(R.id.imgBookImage)
//        val Content:LinearLayout=view.findViewById(R.id.Content)
//    }
//
//}