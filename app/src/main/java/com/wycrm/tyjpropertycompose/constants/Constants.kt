package com.wycrm.tyjpropertycompose.constants

object Constants {

    const val DATABASE_NAME = "TYJ_property-db"

    const val SOURCE_TYPE = "android"

    //云平台 baseUrl
    const val CLOUD_BASE_URL = "https://test.wycrm.com.cn/x/wyapp/api/"

    //通讯技术部 baseUrl
    const val COMMUNICATION_BASE_URL = "https://chat-test.wycrm.com.cn/"

    const val SIP_URL = "talk-test"

    const val IMAGE_URL = "https://test.wycrm.com.cn/x/file/"

    //加密key
    const val KEY = "jZ5\$x!6yeAo1Qe^r"

    object UrlVersion {
        const val VER_1_0 = "v1.0/"
        const val VER_1_1 = "v1.1/"
        const val VER_2_0 = "v2.0/"
        const val VER_3_0 = "v3.0/"
    }


    /**
     * 通讯技术部接口
     */
    object CommunicationUrl {

        //放行条
        private const val COMMUNICATION_PORT = "ecp-server-greenlight/api/"

        //推送
        private const val COMMUNICATION_PUSH_PORT = "push-server/api/"

        //扫码
        private const val COMMUNICATION_SCAN_PORT = "ecp-server-scancodelogin/api/"

        //日志
        private const val COMMUNICATION_LOG_PORT = "ecp-manage-server/api/"

        //远程控制门口机
        private const val COMMUNICATION_CONTROL_PORT = "ecp-xhkamailio-server/api/"

        //远程控制门口机
        private const val COMMUNICATION_FACE_DEVICE_PORT = "ecp-server-facedevice/api/"

        //请求门控机
        private const val COMMUNICATION_MKJ_STATUS_PORT = "ecp-server-mkjstatus/api/"

        //人脸接口
        private const val COMMUNICATION_FACE_PORT = "ecp-server-face/api/"

        //访客
        private const val COMMUNICATION_VISITOR_PORT = "ecp-server-visitor/api/"

        //日志
        private const val COMMUNICATION_OPEN_LOG_PORT = "ecp-server-openLog/api/"

        //物业
        private const val COMMUNICATION_PROPERTY_PORT = "ecp-server-property/api/"

        //上传开门登录日志
        private const val COMMUNICATION_GATING_MACHINE_OPEN_LOG_LOGIN_PORT = "ecp-server-gateingMachineOpenLoglogin/api/"

        //开门日志
        private const val COMMUNICATION_GATING_MACHINE_OPEN_LOG_PORT = "ecp-server-gatingMachineOpenLog/api/"


        //物邻服务协议
        const val WL_SERVICE_PROTOCOL = "wl_service_protocol.html"

        //物邻隐私策略
        const val WL_PRIVACY_POLICY = "wl_privacy_policy_android.html"

        //上报手机厂商sdk token
        const val UPLOAD_TOKEN = COMMUNICATION_PUSH_PORT + UrlVersion.VER_1_0 + "upload-token"

        //查询人脸识别信息
        const val SELECT_FACE_RECOGNITION = COMMUNICATION_FACE_PORT + UrlVersion.VER_1_0 + "selectFaceDecognition"

        //注册人脸
        const val REGISTERED_FACE_RECOGNITION = COMMUNICATION_FACE_PORT + UrlVersion.VER_2_0 + "batchRegisteredFaceDecognition"

        //删除人脸
        const val DELETE_FACE_RECOGNITION = COMMUNICATION_FACE_PORT + UrlVersion.VER_2_0 + "deleteFaceDecognition"

        //根据日期查询某一个天的邀请信息。
        const val GET_INVITATION_DETAILS_BY_DATE = COMMUNICATION_VISITOR_PORT + UrlVersion.VER_1_0 + "getInvitationDetialsByDate"

        //根据arrangeNo 查找邀请的而信息
        const val GET_INVITATION_DETAILS_BY_ARRANGENO = COMMUNICATION_VISITOR_PORT + UrlVersion.VER_1_0 + "getInvitationDetialsByArrangeNo"

        //查询某个月的邀请信息。
        const val GET_INVITATION_DETAILS_BY_MONTH = COMMUNICATION_VISITOR_PORT + UrlVersion.VER_1_0 + "getInvitationDetialsByMonth"

        //根据ID 查询 某个邀请的通行记录（日志）。
        const val FIND_INVITATION_RECORDS = COMMUNICATION_GATING_MACHINE_OPEN_LOG_PORT + UrlVersion.VER_1_0 + "findInvitationRecords"

        //物邻日志上报
        const val UPLOAD_WL_LOG = COMMUNICATION_GATING_MACHINE_OPEN_LOG_PORT + UrlVersion.VER_1_0 + "uploadWLLog"

        //扫码保存到服务器
        const val SCAN_SAVE_TAG = COMMUNICATION_SCAN_PORT + UrlVersion.VER_1_0 + "mk/scanSaveTag"

        // 根据账号查询门控机开门日志
        const val LOG_STATISTICS = COMMUNICATION_OPEN_LOG_PORT + UrlVersion.VER_1_0 + "logStatistics"

        // 日志查询
        const val LOG_QUERY = COMMUNICATION_OPEN_LOG_PORT + UrlVersion.VER_1_0 + "logQuery"

        // 门控机控制
        const val REMOTE_CONTROL = COMMUNICATION_OPEN_LOG_PORT + UrlVersion.VER_1_0 + "remote/control"

        // 绑定人脸设备
        const val GATING_CODE_AND_SERIAL_NO_BIND = COMMUNICATION_FACE_DEVICE_PORT + UrlVersion.VER_1_0 + "gatingCodeAndSerialNoBind"

        //查询人脸设备
        const val GATING_CODES_IS_FACE_DEVICE = COMMUNICATION_FACE_DEVICE_PORT + UrlVersion.VER_1_0 + "gatingCodesIsFaceDevice"

        // 解绑人脸设备
        const val GATING_CODE_SERIAL_UNBINDING = COMMUNICATION_FACE_DEVICE_PORT + UrlVersion.VER_1_0 + "gatingCodeSerialUnbundling"

        // 解绑人脸设备
        const val FACE_DEVICE_OPEN_DOOR = COMMUNICATION_FACE_DEVICE_PORT + UrlVersion.VER_1_0 + "faceDeviceOpenDoor";

        //根据项目Id获取项目下的门控机列表
        const val FIND_MKJ_INFO = COMMUNICATION_MKJ_STATUS_PORT + UrlVersion.VER_1_0 + "findMkjInfo"

        //物业员工查看开门密码
        const val QUERY_STAFF_PASSWORD = COMMUNICATION_PROPERTY_PORT + UrlVersion.VER_1_0 + "queryStaffPassword"

        //物业员工修改开门密码
        const val UPDATE_STAFF_PASSWORD = COMMUNICATION_PROPERTY_PORT + UrlVersion.VER_1_0 + "updateStaffPassword"

        //发送门口机命令接口sip命令
        const val GATE_CONTROL = COMMUNICATION_MKJ_STATUS_PORT + UrlVersion.VER_1_0 + "gateControl"

        // 门口机上报开门日志
        const val UPLOAD_OPEN_DOOR_LOG = COMMUNICATION_GATING_MACHINE_OPEN_LOG_LOGIN_PORT + UrlVersion.VER_1_0 + "uploadOpenDoorLog"

        //根据资产名字模糊搜索放行条
        const val GET_ITEMS_BY_BUILDING_NAME = COMMUNICATION_PORT + UrlVersion.VER_1_0 + "getItemsByBuildingName"

        //修改放行条的审核状态
        const val SET_GREEN_LIGHT_PROCESS_STATUS = COMMUNICATION_PORT + UrlVersion.VER_1_0 + "setGreenLightProcessStatus"

        //根据UUID搜索放行条。
        const val GET_ITEMS_BY_UUID = COMMUNICATION_PORT + UrlVersion.VER_1_0 + "getItemsByUUID"

        //员工人脸验证
        const val FACE_VERIFICATION = COMMUNICATION_FACE_PORT + UrlVersion.VER_1_0 + "doFaceSimilarity"

        //根据员工注册物邻APP的accountCode 查询登记的人脸
        const val QUERY_FACE_IMAGE_PATH = COMMUNICATION_FACE_PORT + UrlVersion.VER_1_0 + "queryFaceImagePath"

    }

    /**
     * 云技术部接口
     */
    object CloudUrl {
        //检查更新
        const val CHECK_UPDATE = UrlVersion.VER_1_0 + "mk/checkUpdate"

        //获取手机验证码
        const val VERIFICATION_CODE = UrlVersion.VER_1_0 + "verificationCode"

        //用户注册
        const val REGISTER = UrlVersion.VER_1_0 + "register"

        //用户修改手机号
        const val RESET_MOBILE = UrlVersion.VER_1_0 + "wlResetMobile"

        //用户登录
        const val LOGIN = UrlVersion.VER_1_0 + "login"

        //重置密码
        const val RESET_PASSWORD = UrlVersion.VER_1_0 + "resetPassword"

        //账号注销
        const val DEL_ACCOUNT = UrlVersion.VER_1_0 + "delAccount"

        //通过accountId查询实名验证
        const val IDENTIFICATION_BY_ACCOUNT_ID = UrlVersion.VER_1_0 + "identification/queryByAccountId"

        //添加实名验证
        const val ADD_IDENTIFICATION = UrlVersion.VER_1_0 + "identification/add"

        //修改实名验证
        const val MODIFY_IDENTIFICATION = UrlVersion.VER_1_0 + "identification/modify"

        //根据帐号ID 查询公司信息
        const val COMPANY_INFORMATION = UrlVersion.VER_1_0 + "companyInformation"

        //查看注册公司审核状态
        const val COMPANY_APPROVAL_INFO = UrlVersion.VER_1_0 + "company/approvalInfo"

        //公司修改
        const val COMPANY_MODIFY = UrlVersion.VER_1_0 + "company/modify"

        //公司注册
        const val COMPANY_REGISTER = UrlVersion.VER_1_0 + "company/register"

        //文件上传
        const val UPLOAD_FILE = UrlVersion.VER_1_0 + "file/uploadFile"

        //文件获取
        const val GET_FILE = UrlVersion.VER_1_0 + "file/get"

        //根据当前物邻登陆账户查询当前分配给我的工单
        const val GET_MY_WORKER_ORDER = UrlVersion.VER_3_0 + "ArrangeWorkOrder/getMyWorkOrder"

        // 根据工单编号+公司ID+项目ID修改工单内容
        const val MODIFY_WORKER_ORDER = UrlVersion.VER_3_0 + "ArrangeWorkOrder/modifyWorkOrder"

        //转单
        const val MODIFY_WORKER_ORDER_HANDLER = UrlVersion.VER_3_0 + "ArrangeWorkOrder/modifyWorkOrderHandler"

        //接受工单
        const val ACCEPT_WORKER_ORDER = UrlVersion.VER_3_0 + "ArrangeWorkOrder/acceptWorkOrder"

        //提交工单的处理单操作
        const val SUBMIT_PROCESS_ORDER = UrlVersion.VER_3_0 + "ArrangeWorkOrder/submitProcessOrder"

        //工单延时操作
        const val GET_CONSUMABLES_LIST = UrlVersion.VER_3_0 + "ArrangeWorkOrder/delayWorkOrder"

        //获取工单查询配置
        const val WORKER_ORDER_CONFIGURE = UrlVersion.VER_3_0 + "ArrangeWorkService/getAllWorkOrderConfigure"

        //获取当前项目下所有物业员工
        const val GET_ALL_STAFFS = UrlVersion.VER_3_0 + "ArrangeWorkService/getAllStaffs"

        //分页模糊查询当前项目下所有报单地址
        const val GET_ALL_WORK_ORDER_ADDRESS = UrlVersion.VER_3_0 + "ArrangeWorkService/getAllWorkOrderAddress"

        //新增服务请求工单
        const val ADD_WORD_ORDER_REQUEST = UrlVersion.VER_3_0 + "ArrangeWorkService/addWorkOrderByRequest"

        //分页模糊查询当前项目下所有的工单
        const val GET_ALL_WORK_ORDER = UrlVersion.VER_3_0 + "ArrangeWorkOrder/getAllWorkOrder"

        //根据工单编号查询所有的处理的记录的细节
        const val GET_WORK_ORDER_RECORD_DETAILS = UrlVersion.VER_3_0 + "ArrangeWorkService/getWorkOrderRecordDetails"

        //根据工单编号+处理单编号查询某个处理单记录的细节
        const val GET_PROCESS_ORDER_DETAILS = UrlVersion.VER_3_0 + "ArrangeWorkService/getProcessOrderDetails"

        // 查询某个公司+项目下面的 工单项目列表，根据条件筛查。
        const val GET_ALL_WORK_ORDER_PROJECT = UrlVersion.VER_3_0 + "ArrangeWorkItem/getAllWorkOrderProject"

        //将工单合并到项目里面
        const val MERGE_WORK_ORDER = UrlVersion.VER_3_0 + "ArrangeWorkItem/mergeWorkOrder"

        //新增项目工单
        const val ADD_WORK_ORDER_PROJECT = UrlVersion.VER_3_0 + "ArrangeWorkItem/addWorkOrderProject"

        //项目单的提交处理
        const val ADD_WORK_ORDER_PROJECT_PROCESS_ORDER = UrlVersion.VER_3_0 + "ArrangeWorkItem/addWorkOrderProjectProcessOrder"

        //查询项目工单下的合并的工单。
        const val GET_MERGE_WORK_ORDER = UrlVersion.VER_3_0 + "ArrangeWorkItem/getMergeWorkOrder"

        //根据工单项目的编号查询项目的详细情况。
        const val GET_WORK_ORDER_PROJECT_DETAIL = UrlVersion.VER_3_0 + "ArrangeWorkItem/getWorkOrderProjectDetail"

        // 获取某个项目单的处理记录（处理单的记录）。
        const val GET_WORK_ORDER_PROJECT_PROCESS_RECORDS = UrlVersion.VER_3_0 + "ArrangeWorkItem/getWorkOrderProjectProcessRecords"

        //根据工单项目的编号修改项目的详细情况。
        const val MODIFY_WORK_ORDER_PROJECT_DETAIL = UrlVersion.VER_3_0 + "ArrangeWorkItem/modifyWorkOrderProjectDetail"

        // 接收项目。
        const val ACCEPT_PROJECT = UrlVersion.VER_3_0 + "ArrangeWorkItem/receiveItemOrder"

        // 提交项目的延时操作
        const val DELAY_PROJECT_ORDER = UrlVersion.VER_3_0 + "ArrangeWorkItem/delayItemOrder"

        //提交项目的转单操作
        const val TRANSFER_PROJECT = UrlVersion.VER_3_0 + "ArrangeWorkItem/modifyWorkItemHandler"

        //根据处理类型编号和处理单编号查询某个处理单记录的细节
        const val PROCESS_ITEM_DETAILS = UrlVersion.VER_3_0 + "ArrangeWorkItem/getProcessItemDetails"

        //根据账号获取对应的门控机项目列表
        const val MK_PROJECT_LIST = UrlVersion.VER_1_0 + "mk/projectList"

        // 门控机控制
        const val MKJ_MANAGE = UrlVersion.VER_1_0 + "mk/mkjManager"

        //物邻用户搜索所有待审核的数据
        const val SEARCH_VEHICLE_INFO = UrlVersion.VER_1_0 + "wl/searchVehicleInfo"

        //物邻用户搜索所有审核过的数据
        const val GET_VEHICLE_INFO_RECORD = UrlVersion.VER_1_0 + "wl/getVehicleInfoRecord"

        //修改车辆的状态
        const val MODIFY_VEHICLE_INFO_STATUS = UrlVersion.VER_1_0 + "wl/modifyVehicleInfoStatus"

        //查询当月所有水表的抄表任务
        const val WMETER_TASK_CURRENT = UrlVersion.VER_1_0 + "wmeter/task/current"

        //查询水表历史任务(除当月外所有水表任务)
        const val WMETER_TASK_HISTORY = UrlVersion.VER_1_0 + "wmeter/task/history"

        //根据taskId查询水表历史任务(除当月外所有水表任务)
        const val WMETER_TASK_DATA_BY_TASK_ID = UrlVersion.VER_1_0 + "wmeter/task/dataByTaskId"

        ////根据水表描述查询对应的水表数据
        const val WMETER_INFO = UrlVersion.VER_1_0 + "wmeter/info"

        //根据电表描述查询对应的水表数据
        const val WMETER_YEAR_DATA = UrlVersion.VER_1_0 + "wmeter/yearData"

        //上传水表数据
        const val WMETER_MODIFY_DATA = UrlVersion.VER_1_0 + "wmeter/modifyData"

        //查询当前公司和当前项目下水表的统计数据
        const val WMETER_STATISTICS = UrlVersion.VER_1_0 + "wmeter/statistics"

        //当前登陆用户查询自己的所有的待抄表数据
        const val WMETER_DATA = UrlVersion.VER_1_0 + "wmeter/data"

        //批量上传抄表数据
        const val WMETER_BATCH_ADD_AND_MODIFY_DATA = UrlVersion.VER_1_0 + "wmeter/batchAddAndModifyData"

        //单个正常提交抄表数据
        const val WMETER_ADD_AND_MODIFY_DATA = UrlVersion.VER_1_0 + "wmeter/addAndModifyData"

        //单个上传错误的原因
        const val WMETER_ERROR_REASON = UrlVersion.VER_1_0 + "wmeter/errorReason"

        //选择抄表错误的时候，拉取可能错误的月份的数据
        const val WMETER_GET_ERROR_READING_DATA = UrlVersion.VER_1_0 + "wmeter/getErrorReadingData"

        // 按照表的名字，搜索模糊搜索表数据
        const val WMETER_SEARCH_METER = UrlVersion.VER_1_0 + "wmeter/searchMeter"

        //按照月份拉取我再某个公司和项目下的历史水表任务以及响应的数据
        const val WMETER_GET_METER_READING_HISTORY = UrlVersion.VER_1_0 + "wmeter/getMeterReadingHistroy"

        //查询某个水表的历史数据
        const val WMETER_GET_METER_HISTORY = UrlVersion.VER_1_0 + "wmeter/getMeterHistroy"

        //获取项目区一级的建筑结构
        const val WMETER_GET_BUILDING_STRUCTURE = UrlVersion.VER_1_1 + "wmeter/getBuildingStructure"

        //通过区表id获取具体每个区的资产
        const val WMETER_GET_BUILDING_BY_CODE = UrlVersion.VER_1_1 + "wmeter/getBuildingByCode"

        //通过 buildingId查询当下资产
        const val WMETER_GET_BUILDING_ID_PROPERTY = UrlVersion.VER_1_1 + "wmeter/getBuildingIdProperty"

        // 获取公共资产
        const val WMETER_GET_PUBLIC_ASSETS_BUILDING = UrlVersion.VER_1_1 + "wmeter/getPublicAssetsBuilding"

        //通过 建筑id下的资产
        const val WMETER_GET_ENGINEERING_MANAGEMENT_BUILDING = UrlVersion.VER_1_1 + "wmeter/getEngineeringManagementBuilding"

        //查询某个水表的历史数据
        const val WMETER_GET_METER_HISTORY_1_1 = UrlVersion.VER_1_1 + "wmeter/getMeterHistroy"

        //通过父表Code获取下一级表的数据
        const val WMETER_GET_PARENT_METER_CODE_METER = UrlVersion.VER_1_1 + "wmeter/getParentMeterCodeMeter"

        //获取组表集合
        const val WMETER_GET_GROUP_METER = UrlVersion.VER_1_1 + "wmeter/getGroupMeter"

        //获取父表表集合
        const val WMETER_GET_PARENT_METER = UrlVersion.VER_1_1 + "wmeter/getParentMeter"

        //获取品牌集合
        const val WMETER_GET_BRAND_COLLECTION = UrlVersion.VER_1_1 + "wmeter/getBrandCollection"

        //新增水表
        const val WMETER_ADD_METER = UrlVersion.VER_1_1 + "wmeter/addMeter"

        //修改水表
        const val WMETER_EDIT_METER = UrlVersion.VER_1_1 + "wmeter/editMeter"

        //换表
        const val WMETER_CHANGE_METER = UrlVersion.VER_1_1 + "wmeter/changeMeter"

        //修改表状态
        const val WMETER_UPDATE_METER_STATE = UrlVersion.VER_1_1 + "wmeter/updateMeterState"

        //删除表
        const val WMETER_DELMETER = UrlVersion.VER_1_1 + "wmeter/delMeter"

        //查询父水表
        const val WMETER_SEARCH_PARENT_METER_CODE_METER = UrlVersion.VER_1_1 + "wmeter/searchParentMeterCodeMeter"

        //查询当月所有电表的抄表任务
        const val EMETER_TASK_CURRENT = UrlVersion.VER_1_0 + "emeter/task/current"

        //查询电表历史任务(除当月外所有电表任务)
        const val EMETER_TASK_HISTORY = UrlVersion.VER_1_0 + "emeter/task/history"

        //通过taskId查询水表历史任务
        const val EMETER_TASK_DATA_BY_TASK_ID = UrlVersion.VER_1_0 + "emeter/task/dataByTaskId"

        //根据电表描述查询对应的电表数据
        const val EMETER_INFO = UrlVersion.VER_1_0 + "emeter/info"

        //根据电表描述查询对应的电表数据
        const val EMETER_YEAR_DATA = UrlVersion.VER_1_0 + "emeter/yearData"

        //上传电表数据
        const val EMETER_MODIFY_DATA = UrlVersion.VER_1_0 + "emeter/modifyData"

        //查询当前公司和当前项目下电表的统计数据
        const val EMETER_STATISTICS = UrlVersion.VER_1_0 + "emeter/statistics"

        //当前登陆用户查询自己的所有的待抄表数据
        const val EMETER_DATA = UrlVersion.VER_1_0 + "emeter/data"

        //批量上传电表数据
        const val EMETER_BATCH_ADD_AND_MODIFY_DATA = UrlVersion.VER_1_0 + "emeter/batchAddAndModifyData"

        //单个正常提交电表数据
        const val EMETER_ADD_AND_MODIFY_DATA = UrlVersion.VER_1_0 + "emeter/addAndModifyData"

        //单个上传电表错误的原因
        const val EMETER_ERROR_REASON = UrlVersion.VER_1_0 + "emeter/errorReason"

        //选择抄电表错误的时候，拉取可能错误的月份的数据
        const val EMETER_GET_ERROR_READING_DATA = UrlVersion.VER_1_0 + "emeter/getErrorReadingData"

        //按照月份拉取我再某个公司和项目下的历史电表任务以及响应的数据
        const val EMETER_GET_METER_READING_HISTORY = UrlVersion.VER_1_0 + "emeter/getMeterReadingHistroy"

        //查询某个电表的历史数据
        const val METER_GET_METER_HISTORY = UrlVersion.VER_1_0 + "emeter/getMeterHistroy"

        //单个上传错误的原因
        const val EMETER_ERROR_REASON_1_1 = UrlVersion.VER_1_1 + "emeter/errorReason"

        //按照月份拉取我再某个公司和项目下的历史电表任务以及响应的数据
        const val EMETER_GET_METER_READING_HISTORY_1_1 = UrlVersion.VER_1_1 + "emeter/getMeterReadingHistroy"

        //获取项目区一级的建筑结构
        const val EMETER_GET_BUILDING_STRUCTURE = UrlVersion.VER_1_1 + "emeter/getBuildingStructure"

        //通过区表id获取具体每个区的资产
        const val EMETER_GET_BUILDING_BY_CODE = UrlVersion.VER_1_1 + "emeter/getBuildingByCode"

        //用户可以通过 bulidingId下的资产
        const val EMETER_GET_BUILDING_ID_PROPERTY = UrlVersion.VER_1_1 + "emeter/getBuildingIdProperty"

        //获取公共资产
        const val EMETER_GET_PUBLIC_ASSETS_BUILDING = UrlVersion.VER_1_1 + "emeter/getPublicAssetsBuilding"

        //用户可以通过 建筑id下的资产
        const val EMETER_GET_ENGINEERING_MANAGEMENT_BUILDING = UrlVersion.VER_1_1 + "emeter/getEngineeringManagementBuilding"

        //查询某个电表的历史数据
        const val EMETER_GET_METER_HISTORY_1_1 = UrlVersion.VER_1_1 + "emeter/getMeterHistroy"

        //通过父表Code获取下一级表的数据
        const val EMETER_GET_PARENT_METER_CODE_METER = UrlVersion.VER_1_1 + "emeter/getParentMeterCodeMeter"

        //获取组表集合
        const val EMETER_GET_GROUP_METER = UrlVersion.VER_1_1 + "emeter/getGroupMeter"

        //获取父表表集合
        const val EMETER_GET_PARENT_METER = UrlVersion.VER_1_1 + "emeter/getParentMeter"

        //获取品牌集合
        const val EMETER_GET_BRAND_COLLECTION = UrlVersion.VER_1_1 + "emeter/getBrandCollection"

        //新增电表
        const val EMETER_ADD_METER = UrlVersion.VER_1_1 + "emeter/addMeter"

        //修改电表
        const val EMETER_EDIT_METER = UrlVersion.VER_1_1 + "emeter/editMeter"

        //换表
        const val EMETER_CHANGE_METER = UrlVersion.VER_1_1 + "emeter/changeMeter"

        //修改电表状态
        const val EMETER_UPDATE_METER_STATE = UrlVersion.VER_1_1 + "emeter/updateMeterState"

        //删除电表状态
        const val EMETER_DEL_METER = UrlVersion.VER_1_1 + "emeter/delMeter"

        //查询父电表
        const val EMETER_SEARCH_PARENT_METER_CODE_METER = UrlVersion.VER_1_1 + "emeter/searchParentMeterCodeMeter"

        // 获取重要客户
        const val GET_MAJOR_CUSTOMERS = UrlVersion.VER_1_0 + "majorCust/getMajorCustomers"

        //分页查询某公司某个项目的所有重点客户的轨迹。
        const val GET_ALL_LOCUS_LOG = UrlVersion.VER_1_0 + "majorCust/getAllLocusLog"

        //分页查询某个客户的轨迹日志
        const val GET_LOCUS_LOG = UrlVersion.VER_1_0 + "majorCust/getLocusLog"

        //根据经纬度获取位置详情
        const val GET_LOCATION_ADDRESS = UrlVersion.VER_1_0 + "RosterPunch/getLocationAddress"

        //判断是否在时间范围
        const val IS_PUNCH_TIME = UrlVersion.VER_1_0 + "RosterPunch/isPunchTime"

        //打卡
        const val PUNCH = UrlVersion.VER_1_0 + "RosterPunch/punch"

        //获取打卡记录
        const val GET_PUNCH_RECORDS = UrlVersion.VER_1_0 + "RosterPunch/getPunchRecords"

        //获取打卡月度统计
        const val GET_PUNCH_REPORT = UrlVersion.VER_1_0 + "RosterPunch/getPunchReport"

        //获取迟到明细
        const val GET_PUNCH_LATE_RECORDS = UrlVersion.VER_1_0 + "RosterPunchLog/getPunchbeLateRecords"

        // 获取登陆者计划打卡数据
        const val GET_MY_PLAN_PUNCH = UrlVersion.VER_1_0 + "RosterPunchLog/getMyPlanPunch"

        //异常打卡
        const val EXCEPTION_PUNCH = UrlVersion.VER_1_0 + "RosterPunch/exceptionPunch"

        // 查询当前登陆者所管辖人员的考勤统计数据
        const val GET_PUNCH_STATISTICS = UrlVersion.VER_1_0 + "RosterPunch/getPunchStatistics"

        //根据考勤类型查询当前登陆者所管辖人员的考勤数据的详细情况
        const val GET_PUNCH_STATISTICS_DETAILS_BY_PUNCH_TYPE = UrlVersion.VER_1_0 + "RosterPunch/getPunchStatisticsDetailsByPunchType"

        //根据员工手机号或者工号，查询该员工的打卡细节。
        const val GET_EMPLOYEE_PUNCH_DETAILS = "RosterPunch/getEmployeePunchDetails"

    }

}