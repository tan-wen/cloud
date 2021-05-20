package com.aoyang.wx.work.model.info.applets;

import com.aoyang.wx.work.model.info.Base;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @ClassName : AppletsInfo
 * @Description : 企业微信推送小程序消息
 *
 * touser	否	成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）
 * toparty	否	部门ID列表，多个接收者用‘|’分隔，最多支持100个。
 * totag	否	标签ID列表，多个接收者用‘|’分隔，最多支持100个。
 * msgtype	是	消息类型，此时固定为：miniprogram_notice
 * appid	是	小程序appid，必须是与当前应用关联的小程序
 * page	否	点击消息卡片后的小程序页面，仅限本小程序内的页面。该字段不填则消息点击后不跳转。
 * title	是	消息标题，长度限制4-12个汉字（支持id转译）
 * description	否	消息描述，长度限制4-12个汉字（支持id转译）
 * emphasis_first_item	否	是否放大第一个content_item
 * content_item	否	消息内容键值对，最多允许10个item
 * key	是	长度10个汉字以内
 * value	是	长度30个汉字以内（支持id转译）
 * enable_id_trans	否	表示是否开启id转译，0表示否，1表示是，默认0
 * enable_duplicate_check	否	表示是否开启重复消息检查，0表示否，1表示是，默认0
 * duplicate_check_interval	否	表示是否重复消息检查的时间间隔，默认1800s，最大不超过4小时
 *
 * {
 *    "touser" : "zhangsan|lisi",
 *    "toparty": "1|2",
 *    "totag": "1|2",
 *    "msgtype" : "miniprogram_notice",
 *    "miniprogram_notice" : {
 *         "appid": "wx123123123123123",
 *         "page": "pages/index?userid=zhangsan&orderid=123123123",
 *         "title": "会议室预订成功通知",
 *         "description": "4月27日 16:16",
 *         "emphasis_first_item": true,
 *         "content_item": [
 *             {
 *                 "key": "会议室",
 *                 "value": "402"
 *             },
 *             {
 *                 "key": "会议地点",
 *                 "value": "广州TIT-402会议室"
 *             },
 *             {
 *                 "key": "会议时间",
 *                 "value": "2018年8月1日 09:00-09:30"
 *             },
 *             {
 *                 "key": "参与人员",
 *                 "value": "周剑轩"
 *             }
 *         ]
 *     },
 *    "enable_id_trans": 0,
 *    "enable_duplicate_check": 0,
 *    "duplicate_check_interval": 1800
 * }
 *
 *
 * @Author : GC
 * @Date: 2021-05-19 08:49
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AppletsInfo extends Base {
    private MiniprogramNotice miniprogram_notice;
}
