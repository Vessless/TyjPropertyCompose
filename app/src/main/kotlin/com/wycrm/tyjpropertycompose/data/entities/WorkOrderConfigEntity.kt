package com.wycrm.tyjpropertycompose.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class WorkOrderConfigEntity(
    val urgentTypes: List<UrgentTypeEntity>,
    val workOrderProjectFundSources: List<WorkOrderProjectFundSourceEntity>,
    val workOrderProjectType: List<WorkOrderProjectTypeEntity>,
    val workOrderStates: List<WorkOrderStateEntity>,
    val workOrderTypeList: List<WorkOrderTypeListEntity>,
    val workOrderTypes: List<WorkOrderTypesEntity>
)