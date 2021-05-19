package com.aoyang.wx.work.model.qymsgInfo.videoinfo;

import com.aoyang.wx.work.model.qymsgInfo.Base;

/**
 * @ClassName : VideoInfo
 * @Description : 视频文件
 *
 * touser	否	成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）。特殊情况：指定为@all，则向关注该企业应用的全部成员发送
 * toparty	否	部门ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
 * totag	否	标签ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
 * msgtype	是	消息类型，此时固定为：video
 * agentid	是	企业应用的id，整型。企业内部开发，可在应用的设置页面查看；第三方服务商，可通过接口 获取企业授权信息 获取该参数值
 * media_id	是	视频媒体文件id，可以调用上传临时素材接口获取
 * title	否	视频消息的标题，不超过128个字节，超过会自动截断
 * description	否	视频消息的描述，不超过512个字节，超过会自动截断
 * safe	否	表示是否是保密消息，0表示可对外分享，1表示不能分享且内容显示水印，默认为0
 * enable_duplicate_check	否	表示是否开启重复消息检查，0表示否，1表示是，默认0
 * duplicate_check_interval	否	表示是否重复消息检查的时间间隔，默认1800s，最大不超过4小时
 *
 * {
 *    "touser" : "UserID1|UserID2|UserID3",
 *    "toparty" : "PartyID1|PartyID2",
 *    "totag" : "TagID1 | TagID2",
 *    "msgtype" : "video",
 *    "agentid" : 1,
 *    "video" : {
 *         "media_id" : "MEDIA_ID",
 *         "title" : "Title",
 *        "description" : "Description"
 *    },
 *    "safe":0,
 *    "enable_duplicate_check": 0,
 *    "duplicate_check_interval": 1800
 * }
 *
 * @Author : GC
 * @Date: 2021-05-19 11:00
 */
public class VideoInfo extends Base {
    private Integer agentid;
    private Integer safe;
    private Video video;
}
