```sql
create table goods;
(
	id bigint auto_increment comment '主键' primary key,
	creator bigint null comment '创建该数据的用户 Id',
	is_deleted varchar(1) charset utf8 default 'N' null comment '是否删除标记',
	spu_id bigint null comment 'spuId',
	is_on_sale varchar(1) charset utf8 null comment '是否上架 Y：是 N：否',
	goods_price decimal null comment '商品单价',
	goods_img varchar(255) charset utf8 null comment '商品图片',
	goods_sn varchar(16) charset utf8 null comment '商品编码',
	modify_time timestamp null comment '最近一次的修改时间',
	create_time timestamp null comment '创建时间',
	modifier bigint null comment '修改的人的 id'
)
comment '商品表' charset=utf8mb4;

create table order_INFO(
	id bigint auto_increment primary key,
	country_id bigint null comment '下单地址——国家',
	province_id bigint null comment '下单地址--省',
	city_id bigint null comment '下单地址--城市',
	district_id bigint null comment '下单地址--区',
	street_id bigint null comment '下单地址--街道',
	address varchar(128) charset utf8 null comment '详细收获地址',
	order_amount decimal null comment '订单金额',
	ship_fee decimal null comment '物流费用',
	remark varchar(256) charset utf8 null comment '订单备注',
	order_sn varchar(64) charset utf8 null comment '订单编码',
	store_id varchar(16) charset utf8 null comment '在哪个店铺下单',
	order_status varchar(64) charset utf8 null comment '订单状态',
	shipping_status varchar(64) charset utf8 null comment '物流状态',
	is_deleted varchar(1) charset utf8 default 'N' null comment '是否删除标记',
	modify_time timestamp null comment '最近一次的修改时间',
	create_time timestamp null comment '创建时间',
	creator bigint null comment '创建该数据的用户 Id',
	modifier bigint null comment '修改的人的 id'
) comment '订单表' charset=utf8mb4;

create table order_goods
(
	id bigint auto_increment primary key,
	order_id bigint null comment '订单 ID',
	goods_id bigint null comment '商品 id',
	goods_number int null comment '下单商品数量',
	sales_amount decimal null comment '售卖价格',
	ori_price decimal null comment '商品单价',
	snapshot json null comment '商品快照 JSON形式',
	spu_id bigint null comment 'SPUID',
	is_deleted varchar(1) charset utf8 default 'N' null comment '是否删除标记',
	modify_time timestamp null comment '最近一次的修改时间',
	create_time timestamp null comment '创建时间',
	creator bigint null comment '创建该数据的用户 Id',
	modifier bigint null comment '修改的人的 id'
)
comment '订单商品表' charset=utf8mb4;

create table spu
(
	id bigint auto_increment comment '主键' primary key,
	spu_sn varchar(32) charset utf8 null comment 'spu编码',
	brand_id bigint null comment '品牌 ID',
	store_id bigint null comment '店铺 ID',
	cat_id bigint null comment '品类 id',
	unit varchar(16) charset utf8 null comment '商品单位',
	goods_desc varchar(255) charset utf8 null comment '商品描述',
	remark varchar(256) charset utf8 null comment '备注',
	is_deleted varchar(1) charset utf8 default 'N' null comment '是否删除标记',
	modify_time timestamp null comment '最近一次的修改时间',
	create_time timestamp null comment '创建时间',
	creator bigint null comment '创建该数据的用户 Id',
	modifier bigint null comment '修改的人的 id'
)
COMMENT 'SPU 信息表' charset = utf8mb4;
CREATE TABLE store (
	id BIGINT auto_increment PRIMARY KEY,
	is_deleted VARCHAR ( 1 ) charset utf8 DEFAULT 'N' NULL COMMENT '是否删除标记',
	user_id BIGINT NULL COMMENT 'store 关联的用户 Id',
	store_name VARCHAR ( 64 ) charset utf8 NULL COMMENT '店铺名称',
	store_nick_name VARCHAR ( 64 ) charset utf8 NULL COMMENT '店铺昵称',
	contact_name VARCHAR ( 64 ) charset utf8 NULL COMMENT '联系人姓名',
	contact_mobile VARCHAR ( 11 ) charset utf8 NULL COMMENT '联系人手机号',
	biz_brand VARCHAR ( 128 ) charset utf8 NULL COMMENT '店铺主营品牌',
	biz_cat VARCHAR ( 128 ) charset utf8 NULL COMMENT '店铺经营分类',
	store_province_id BIGINT NULL COMMENT '店铺所在省份 id',
	store_city_id BIGINT NULL COMMENT '店铺所在城市 Id',
	store_district_id BIGINT NULL COMMENT '店铺所在区 id
	',
	store_street_id BIGINT NULL COMMENT '店铺所在街道 id',
	store_address VARCHAR ( 125 ) charset utf8 NULL COMMENT '店铺详细地址',
	business_time_begin VARCHAR ( 64 ) charset utf8 NULL COMMENT '营业时间-开始',
	business_time_end VARCHAR ( 64 ) charset utf8 NULL COMMENT '营业时间-结束',
	modify_time TIMESTAMP NULL COMMENT '最近一次的修改时间',
	create_time TIMESTAMP NULL COMMENT '创建时间',
	creator BIGINT NULL COMMENT '创建该数据的用户 Id',
	modifier BIGINT NULL COMMENT '修改的人的 id' 
) COMMENT '店铺表' charset = utf8mb4;
CREATE TABLE USER (
	id BIGINT NOT NULL COMMENT 'id ' PRIMARY KEY,
	is_deleted VARCHAR ( 1 ) charset utf8 DEFAULT 'N' NULL COMMENT '是否删除标记',
	nick_name VARCHAR ( 32 ) charset utf8 NULL,
	PASSWORD VARCHAR ( 125 ) charset utf8 NOT NULL,
	email VARCHAR ( 255 ) charset utf8 NULL COMMENT 'email',
	mobile VARCHAR ( 11 ) charset utf8 NOT NULL COMMENT '手机号码',
	user_name VARCHAR ( 32 ) charset utf8 NOT NULL COMMENT '用户名',
	modify_time TIMESTAMP NULL COMMENT '最近一次的修改时间',
	create_time TIMESTAMP NULL COMMENT '创建时间',
	creator BIGINT NULL COMMENT '创建该数据的用户 Id',
modifier BIGINT NULL COMMENT '修改的人的 id' 
) charset = utf8mb4;
```