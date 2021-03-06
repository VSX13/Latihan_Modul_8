package com.example.myfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class SecondFragment : Fragment() {
    private var pageViewModel: PageViewModel? = null
    private var txtName: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProviders.
        of(requireActivity()).
        get(PageViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second,
            container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        txtName = view.findViewById(R.id.textViewName)
        pageViewModel!!.name.observe(requireActivity(),
            Observer { s -> txtName!!.text = s })
    }
    companion object {
        fun newInstance(): SecondFragment {
            return SecondFragment()
        }
    }
}
