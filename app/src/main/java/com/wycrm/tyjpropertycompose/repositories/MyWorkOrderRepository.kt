package com.wycrm.tyjpropertycompose.repositories

import com.wycrm.tyjpropertycompose.data.BaseRequest
import com.wycrm.tyjpropertycompose.data.dao.UserDao
import com.wycrm.tyjpropertycompose.data.requests.AccountId
import com.wycrm.tyjpropertycompose.data.requests.CompanyAndProjectCode
import com.wycrm.tyjpropertycompose.data.requests.WorkOrder
import com.wycrm.tyjpropertycompose.network.UserApi
import com.wycrm.tyjpropertycompose.network.WorkOrderApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyWorkOrderRepository @Inject constructor(
    private val userApi: UserApi,
    private val workOrderApi: WorkOrderApi,
    private val userDao: UserDao
) {

    suspend fun getCompanyInfo(request: BaseRequest<AccountId>) = userApi.getCompanyInfo(request)

    suspend fun getWorkOrderConfig(request: BaseRequest<CompanyAndProjectCode>) = workOrderApi.getWorkOrderConfig(request)

    suspend fun getMyWorkOrder(request: BaseRequest<WorkOrder>) = workOrderApi.getMyWorkOrder(request)

    suspend fun getUser(phone:String) = userDao.getUserByPhone(phone)
}