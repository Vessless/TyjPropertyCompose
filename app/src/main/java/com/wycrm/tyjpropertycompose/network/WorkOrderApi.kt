package com.wycrm.tyjpropertycompose.network

import com.wycrm.tyjpropertycompose.constants.Constants
import com.wycrm.tyjpropertycompose.data.BaseRequest
import com.wycrm.tyjpropertycompose.data.BaseResponse
import com.wycrm.tyjpropertycompose.data.PageResponse
import com.wycrm.tyjpropertycompose.data.entities.MyWorkOrderEntity
import com.wycrm.tyjpropertycompose.data.entities.WorkOrderConfigEntity
import com.wycrm.tyjpropertycompose.data.requests.CompanyAndProjectCode
import com.wycrm.tyjpropertycompose.data.requests.WorkOrder
import retrofit2.http.Body
import retrofit2.http.POST

interface WorkOrderApi {

    /**
     * 获取工单配置信息
     */
    @POST(Constants.CloudUrl.WORKER_ORDER_CONFIGURE)
    suspend fun getWorkOrderConfig(@Body request: BaseRequest<CompanyAndProjectCode>): BaseResponse<WorkOrderConfigEntity>

    /**
     * 获取我的工单
     */
    @POST(Constants.CloudUrl.GET_MY_WORKER_ORDER)
    suspend fun getMyWorkOrder(@Body request: BaseRequest<WorkOrder>): BaseResponse<PageResponse<MyWorkOrderEntity>>


}