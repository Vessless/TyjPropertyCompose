package com.wycrm.tyjpropertycompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.wycrm.tyjpropertycompose.data.entities.CompanyInfoEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SelectProjectViewModel @Inject constructor(

) : ViewModel() {
    var projectList :List<CompanyInfoEntity>? = mutableListOf()



}