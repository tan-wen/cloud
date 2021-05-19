package com.aoyang.wx.work.model.qymsgInfo.interactivetaskcardinfo;

import com.aoyang.wx.work.model.qymsgInfo.Base;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @ClassName : InteractiveTaskcardInfo
 * @Description : 任务卡片消息
 *
 * touser	否	成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）。特殊情况：指定为@all，则向关注该企业应用的全部成员发送
 * toparty	否	部门ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
 * totag	否	标签ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
 * msgtype	是	消息类型，此时固定为：interactive_taskcard
 * agentid	是	企业应用的id，整型。企业内部开发，可在应用的设置页面查看；第三方服务商，可通过接口 获取企业授权信息 获取该参数值
 * title	是	标题，不超过128个字节，超过会自动截断（支持id转译）
 * description	否	描述，不超过512个字节，超过会自动截断（支持id转译）
 * url	否	点击后跳转的链接。最长2048字节，请确保包含了协议头(http/https)
 * task_id	是	任务id，同一个应用发送的任务卡片消息的任务id不能重复，只能由数字、字母和“_-@”组成，最长支持128字节
 * btn	是	按钮列表，按钮个数为1~2个。
 * btn:key	是	按钮key值，用户点击后，会产生任务卡片回调事件，回调事件会带上该key值，只能由数字、字母和“_-@”组成，最长支持128字节
 * btn:name	是	按钮名称，最长支持18个字节，超过则截断
 * btn:color	否	按钮字体颜色，可选“red”或者“blue”,默认为“blue”
 * btn:is_bold	否	按钮字体是否加粗，默认false
 * enable_id_trans	否	表示是否开启id转译，0表示否，1表示是，默认0
 * enable_duplicate_check	否	表示是否开启重复消息检查，0表示否，1表示是，默认0
 * duplicate_check_interval	否	表示是否重复消息检查的时间间隔，默认1800s，最大不超过4小时
 *
 * {
 *    "touser" : "UserID1|UserID2|UserID3",
 *    "toparty" : "PartyID1 | PartyID2",
 *    "totag" : "TagID1 | TagID2",
 *    "msgtype" : "interactive_taskcard",
 *    "agentid" : 1,
 *    "interactive_taskcard" : {
 *         "title" : "赵明登的礼物申请",
 *         "description" : "礼品：A31茶具套装\n用途：赠与小黑科技张总经理",
 *         "url" : "URL",
 *         "task_id" : "taskid123",
 *         "btn":[
 *             {
 *                 "key": "key111",
 *                 "name": "批准",
 *                 "color":"red",
 *                 "is_bold": true
 *             },
 *             {
 *                 "key": "key222",
 *                 "name": "驳回"
 *             }
 *         ]
 *    },
 *    "enable_id_trans": 0,
 *    "enable_duplicate_check": 0,
 *    "duplicate_check_interval": 1800
 * }
 *
 * @Author : GC
 * @Date: 2021-05-19 13:18
 */
@Data
public class InteractiveTaskcardInfo extends Base {
    private Integer agentid;
    private InteractiveTaskcard interactive_taskcard;
}
