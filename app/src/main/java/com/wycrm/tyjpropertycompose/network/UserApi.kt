package com.wycrm.tyjpropertycompose.network


import com.wycrm.tyjpropertycompose.constants.Constants
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

/**
 * Description:
 * Date：2022/10/19 0019-15:27
 * Author: Ling
 */
interface UserApi {

    /**
     * 登录
     */
    @POST(Constants.CloudUrl.LOGIN)
    suspend fun login(@Body request: Any): Any

    /**
     * 实名验证
     */
    @POST(Constants.CloudUrl.IDENTIFICATION_BY_ACCOUNT_ID)
    suspend fun identificationByAccountId(@Body request: Any): List<Any>

    /**
     * 注册
     */
    @POST(Constants.CloudUrl.REGISTER)
    suspend fun register(@Body request: Any): Any

    /**
     * 登录
     */
    @POST(Constants.CloudUrl.VERIFICATION_CODE)
    suspend fun getVerifyCode(@Body request: Any): Any


    /**
     * 重置密码(找回密码)
     */
    suspend fun resetPassword(@Body request: Any): Any


    /**
     * 查询公司信息
     */
    @POST(Constants.CloudUrl.COMPANY_INFORMATION)
    suspend fun getCompanyInfo(@Body request: Any): List<Any>

    /**
     * 检测版本更新
     */
    @POST(Constants.CloudUrl.CHECK_UPDATE)
    suspend fun checkVersion(@Body request: Any): Any


    /**
     * 文件下载
     */
    @Streaming
    @GET
    suspend fun downloadFile(@Url fileUrl: String): Response<ResponseBody>
}