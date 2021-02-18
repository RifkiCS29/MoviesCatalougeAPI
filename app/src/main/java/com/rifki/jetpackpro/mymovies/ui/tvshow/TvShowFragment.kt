package com.rifki.jetpackpro.mymovies.ui.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.rifki.jetpackpro.mymovies.databinding.FragmentTvShowBinding
import com.rifki.jetpackpro.mymovies.viewmodel.ViewModelFactory

class TvShowFragment : Fragment() {

    private var _fragmentTvShowBinding: FragmentTvShowBinding? =  null
    private val binding get() = _fragmentTvShowBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _fragmentTvShowBinding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

            val tvShowAdapter = TvShowAdapter()

            binding?.progressBar?.visibility = View.VISIBLE
            viewModel.getTvShows().observe(viewLifecycleOwner, { tvShows ->
                binding?.progressBar?.visibility = View.GONE
                tvShowAdapter.setTvShows(tvShows)
                tvShowAdapter.notifyDataSetChanged()
            })

            binding?.let {
                with(it.rvTvShows) {
                    layoutManager = GridLayoutManager(context, 2)
                    setHasFixedSize(true)
                    adapter = tvShowAdapter
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentTvShowBinding = null
    }
}