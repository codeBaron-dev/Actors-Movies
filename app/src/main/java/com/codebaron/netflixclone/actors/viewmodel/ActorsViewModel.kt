package com.codebaron.netflixclone.actors.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codebaron.netflixclone.actors.model.id.ActorsIds
import com.codebaron.netflixclone.actors.model.videos.Resource
import com.codebaron.netflixclone.repository.RequestRepositories
import com.codebaron.netflixclone.utilities.REGIONS
import com.codebaron.netflixclone.utilities.getCurrentDayNumber
import com.codebaron.netflixclone.utilities.getCurrentMonthNumber
import com.codebaron.netflixclone.utilities.subString
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActorsViewModel @Inject constructor(private val requestRepositories: RequestRepositories) :
    ViewModel() {

    private val _actorsIds = MutableLiveData<List<ActorsIds>>()
    private val _randomActorId = MutableLiveData<String>()
    private val _actorsVideos = MutableLiveData<Resource>()

    fun getAllActorsId(): LiveData<List<ActorsIds>> {
        viewModelScope.launch {
            val ids = requestRepositories.getActorsIds(
                getCurrentMonthNumber().toString(),
                getCurrentDayNumber().toString()
            )
            try {
                _actorsIds.postValue(ids)
                val randomId = ids?.random()
                _randomActorId.postValue(subString(randomId.toString()))
            } catch (exception: Exception) {
                exception.message
            }
        }
        return _actorsIds
    }

    fun getAllActorsVideos(): LiveData<Resource> {
        viewModelScope.launch {
            val videos = _randomActorId.value?.let {
                requestRepositories.getActorVideos(
                    it,
                    REGIONS.random()
                )
            }
            try {
                _actorsVideos.postValue(videos)
            } catch (exception: Exception) {
                exception.message
            }
        }
        return _actorsVideos
    }
}