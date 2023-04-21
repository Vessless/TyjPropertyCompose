package com.wycrm.tyjpropertycompose.ui.uistate

import com.wycrm.tyjpropertycompose.data.entities.CompanyInfoEntity

sealed class SelectProjectUiState {
    data class ProjectList(val projectList: List<CompanyInfoEntity>) : SelectProjectUiState()
}