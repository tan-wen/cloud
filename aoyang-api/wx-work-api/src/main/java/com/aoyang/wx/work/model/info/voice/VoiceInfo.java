package com.aoyang.wx.work.model.info.voice;

import com.aoyang.wx.work.model.info.Base;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @ClassName : VoiceInfo
 * @Description :语音消息
 *
 * touser	否	成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）。特殊情况：指定为@all，则向关注该企业应用的全部成员发送
 * toparty	否	部门ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
 * totag	否	标签ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
 * msgtype	是	消息类型，此时固定为：voice
 * agentid	是	企业应用的id，整型。企业内部开发，可在应用的设置页面查看；第三方服务商，可通过接口 获取企业授权信息 获取该参数值
 * media_id	是	语音文件id，可以调用上传临时素材接口获取
 * enable_duplicate_check	否	表示是否开启重复消息检查，0表示否，1表示是，默认0
 * duplicate_check_interval	否	表示是否重复消息检查的时间间隔，默认1800s，最大不超过4小时
 *
 * {
 *    "touser" : "UserID1|UserID2|UserID3",
 *    "toparty" : "PartyID1|PartyID2",
 *    "totag" : "TagID1 | TagID2",
 *    "msgtype" : "voice",
 *    "agentid" : 1,
 *    "voice" : {
 *         "media_id" : "MEDIA_ID"
 *    },
 *    "enable_duplicate_check": 0,
 *    "duplicate_check_interval": 1800
 * }
 *
 * @Author : GC
 * @Date: 2021-05-19 10:56
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class VoiceInfo extends Base {
    @JsonProperty(value = "agentid")
    private Integer agentId;
    private Integer safe;
    private Voice voice;
}
