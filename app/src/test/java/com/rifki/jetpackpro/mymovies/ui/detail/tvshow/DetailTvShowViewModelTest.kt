package com.rifki.jetpackpro.mymovies.ui.detail.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.rifki.jetpackpro.mymovies.data.source.MovieAppRepository
import com.rifki.jetpackpro.mymovies.data.source.local.entity.DetailTvShowEntity
import com.rifki.jetpackpro.mymovies.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest{
    
    
    private lateinit var viewModel: DetailTvShowViewModel

    private val dummyTvShow = DataDummy.generateDetailTvShow()
    private val dummyTvShowId = dummyTvShow.id.toString()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieAppRepository: MovieAppRepository

    @Mock
    private lateinit var observer: Observer<DetailTvShowEntity>

    @Before
    fun setup() {
        viewModel = DetailTvShowViewModel(movieAppRepository)
    }

    @Test
    fun getTvShow() {
        val tvShow = MutableLiveData<DetailTvShowEntity>()
        tvShow.value = dummyTvShow

        `when`(movieAppRepository.getDetailTvShow(dummyTvShowId)).thenReturn(tvShow)
        viewModel.setSelectedTvShow(dummyTvShowId)
        val detailTvShowEntity = viewModel.getTvShow().value as DetailTvShowEntity
        Mockito.verify(movieAppRepository).getDetailTvShow(dummyTvShowId)
        assertNotNull(detailTvShowEntity)

        assertEquals(dummyTvShow.backdropPath, detailTvShowEntity.backdropPath)
        assertEquals(dummyTvShow.genres, detailTvShowEntity.genres)
        assertEquals(dummyTvShow.firstAirDate, detailTvShowEntity.firstAirDate)
        assertEquals(dummyTvShow.overview, detailTvShowEntity.overview)
        assertEquals(dummyTvShow.posterPath, detailTvShowEntity.posterPath)
        assertEquals(dummyTvShow.voteAverage.toString(), detailTvShowEntity.voteAverage.toString())
        assertEquals(dummyTvShow.name, detailTvShowEntity.name)
        assertEquals(dummyTvShow.tagline, detailTvShowEntity.tagline)

        viewModel.getTvShow().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTvShow)
    }
}