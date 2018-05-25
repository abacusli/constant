package constant.tools.db.jdbc.mysql;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MysqlStatement {

    private static final StringBuilder ts     = new StringBuilder();

    private static final StringBuilder tsName = new StringBuilder();

    /**
     * 
     * @param tableName
     * @return
     * @author abacus.li
     * @date 2017年9月29日
     *
     */
    public static final String generateCreateTableStatement(String tableName, String tableComment) {
        StringBuilder stringBuilder = new StringBuilder();

        ts.append("drop table if exists T_" + tableName + ";\n");

        tsName.append("\"T_" + tableName + "\",");

        stringBuilder.append("CREATE TABLE T_" + tableName + "" + " (\n");
        stringBuilder.append(
                "    " + tableName + "_ID BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '" + tableComment + "主键',\n");

        stringBuilder.append(
                "    " + tableName + "_GRP_ID BIGINT(20) NOT NULL DEFAULT 0 COMMENT '" + tableComment + "组主键',\n");
        stringBuilder.append("    APP_ID VARCHAR(32) NOT NULL DEFAULT '0' COMMENT '应用主键',\n");
        stringBuilder.append("    OWNER_ID VARCHAR(32) NOT NULL DEFAULT '0' COMMENT '所有者',\n");
        stringBuilder.append("    OWNER_TYPE INT(11) NOT NULL DEFAULT 0 COMMENT '所有者类型',\n");
        stringBuilder.append("    BIZ_TYPE INT(11) NOT NULL DEFAULT 0 COMMENT '业务类型',\n");
        stringBuilder.append("    SUB_BIZ_TYPE INT(11) NOT NULL DEFAULT 0 COMMENT '子业务类型',\n");
        stringBuilder
                .append("    " + tableName + "_TYPE INT(11) NOT NULL DEFAULT 0 COMMENT '" + tableComment + "类型',\n");
        stringBuilder.append("    " + tableName + "_CODE VARCHAR(128) NOT NULL COMMENT '" + tableComment + "编码',\n");
        stringBuilder.append("    " + tableName + "_NAME VARCHAR(512) NOT NULL COMMENT '" + tableComment + "名称',\n");
        stringBuilder.append("    " + tableName + "_ABBR VARCHAR(255) COMMENT '" + tableComment + "简称',\n");
        stringBuilder.append("    " + tableName + "_DESC VARCHAR(512) COMMENT '" + tableComment + "描述',\n");
        stringBuilder.append("    " + tableName + "_ICON VARCHAR(2048) COMMENT '" + tableComment + "图标',\n");
        stringBuilder.append("    " + tableName + "_URL VARCHAR(2048) COMMENT '" + tableComment + "网址',\n");
        stringBuilder.append("    LEVEL_CODE VARCHAR(32) COMMENT '等级编码[A,B,C,D,E,F,G,H,I,J,K,L,M,N]',\n");
        stringBuilder.append("    LEVEL_NUM INT(11) COMMENT '等级[1,2,3,4,5,6,7,8,9,10,11,12,13,14]',\n");
        stringBuilder.append("    LEAF INT(11) DEFAULT 1 COMMENT '叶子[0-非叶子,1-是叶子]',\n");
        stringBuilder.append("    IND_GRP VARCHAR(32) COMMENT '序号组',\n");
        stringBuilder.append("    IND_NO INT(11) NOT NULL DEFAULT 1 COMMENT '序号',\n");
        stringBuilder.append("    VISIBLE INT(11) NOT NULL DEFAULT 1 COMMENT '可见性[0-隐藏，1-显示]',\n");
        stringBuilder.append("    DELETED INT(11) NOT NULL DEFAULT 0 COMMENT '删除[0-未删除，1-已删除]',\n");
        stringBuilder.append("    CHECKED INT(11) NOT NULL DEFAULT 1 COMMENT '检查[0-已拒绝，1-已通过，2-待审核]',\n");
        stringBuilder.append("    ENABLED INT(11) NOT NULL DEFAULT 1 COMMENT '启用[0-未启用,1-已启用]',\n");

        stringBuilder.append("    PARENT_ID BIGINT(20) NOT NULL DEFAULT 0 COMMENT '父级主键',\n");
        stringBuilder.append("    PARENT_PATH VARCHAR(255) DEFAULT '0' COMMENT '父级主键路径如：0/1/2/3/4/5/6/7/8/9',\n");
        stringBuilder.append("    EXCEPTION_STATUS INT(11) NOT NULL DEFAULT 0 COMMENT '例外状态',\n");

        stringBuilder.append("    GMT_EXPIRED DATETIME COMMENT '过期时间',\n");
        stringBuilder.append("    GMT_CREATED DATETIME NOT NULL COMMENT '创建时间',\n");
        stringBuilder.append("    GMT_MODIFIED DATETIME COMMENT '修改时间',\n");
        stringBuilder.append("    USER_CREATED BIGINT(20) NOT NULL COMMENT '创建者',\n");
        stringBuilder.append("    USER_MODIFIED BIGINT(20) COMMENT '修改者',\n");
        stringBuilder.append("    STATUS INT(11) NOT NULL COMMENT '状态',\n");

        stringBuilder.append("    OPT1 VARCHAR(64) COMMENT '可选字段1',\n");
        stringBuilder.append("    OPT2 VARCHAR(64) COMMENT '可选字段2',\n");
        stringBuilder.append("    OPT3 VARCHAR(64) COMMENT '可选字段3',\n");

        stringBuilder.append("    EXT1 VARCHAR(128) COMMENT '额外字段1',\n");
        stringBuilder.append("    EXT2 VARCHAR(128) COMMENT '额外字段2',\n");
        stringBuilder.append("    EXT3 VARCHAR(128) COMMENT '额外字段3',\n");

        stringBuilder.append("    PRIMARY KEY (" + tableName + "_ID),\n");
        stringBuilder.append("    KEY AK_" + tableName + "_GRP_ID (" + tableName + "_GRP_ID),\n");
        stringBuilder.append("    KEY AK_APP_ID (APP_ID),\n");
        stringBuilder.append("    KEY AK_OWNER_ID (OWNER_ID),\n");
        stringBuilder.append("    KEY AK_OWNER_TYPE (OWNER_TYPE),\n");
        stringBuilder.append("    KEY AK_BIZ_TYPE (BIZ_TYPE),\n");
        stringBuilder.append("    KEY AK_PARENT_ID (PARENT_ID),\n");
        stringBuilder.append("    KEY AK_PARENT_PATH (PARENT_PATH),\n");
        stringBuilder.append("    KEY AK_STATUS (STATUS),\n");
        stringBuilder.append("    KEY AK_" + tableName + "_TYPE (" + tableName + "_TYPE),\n");
        stringBuilder.append("    KEY AK_" + tableName + "_CODE (" + tableName + "_CODE),\n");
        stringBuilder.append("    KEY AK_" + tableName + "_ABBR (" + tableName + "_ABBR),\n");

        stringBuilder.append("    UNIQUE KEY AK_UNQ_OWNER_ID (APP_ID , OWNER_ID , OWNER_TYPE , " + tableName
                + "_TYPE , " + tableName + "_CODE)\n");

        stringBuilder.append(")  ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT='" + tableComment + "信息表';\n");

        // ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;
        // alter table T_DOMAIN_PMT_CHNL_TP_CTL comment '域支付渠道时间段控制信息表';

        return stringBuilder.toString();
    }

    /**
     * 
     * @param tableName
     * @param tableNameRel
     * @param tableComment
     * @param tableCommentRel
     * @return
     * @author abacus.li
     * @date 2017年9月29日
     *
     */
    public static final String generateCreateRelTableStatement(String tableName, String tableNameRel,
            String tableComment, String tableCommentRel) {
        StringBuilder stringBuilder = new StringBuilder();
        String t = tableName + "_" + tableNameRel;

        ts.append("drop table if exists T_" + t + ";\n");

        tsName.append("\"T_" + t + "\",");

        String tc = tableComment + tableCommentRel;

        stringBuilder.append("CREATE TABLE T_" + t + " (\n");
        stringBuilder.append("    " + t + "_ID BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '" + tc + "主键',\n");

        stringBuilder
                .append("    " + tableName + "_ID BIGINT(20) NOT NULL DEFAULT 0 COMMENT '" + tableComment + "主键',\n");
        stringBuilder.append(
                "    " + tableNameRel + "_ID BIGINT(20) NOT NULL DEFAULT 0 COMMENT '" + tableCommentRel + "主键',\n");

        stringBuilder.append("    " + tableNameRel + "_PATH VARCHAR(512) DEFAULT '0' COMMENT '" + tableCommentRel
                + "主键路径如：0/1/2/3/4/5/6/7/8/9',\n");

        stringBuilder.append("    APP_ID VARCHAR(32) NOT NULL DEFAULT '0' COMMENT '应用主键',\n");
        stringBuilder.append("    OWNER_ID VARCHAR(32) NOT NULL DEFAULT '0' COMMENT '所有者',\n");
        stringBuilder.append("    OWNER_TYPE INT(11) NOT NULL DEFAULT 0 COMMENT '所有者类型',\n");
        stringBuilder.append("    BIZ_TYPE INT(11) NOT NULL DEFAULT 0 COMMENT '业务类型',\n");

        stringBuilder.append("    " + t + "_TYPE INT(11) NOT NULL DEFAULT 0 COMMENT '" + tc + "类型',\n");

        stringBuilder.append("    LEVEL_CODE VARCHAR(32) COMMENT '等级编码[A,B,C,D,E,F,G,H,I,J,K,L,M,N]',\n");
        stringBuilder.append("    LEVEL_NUM INT(11) COMMENT '等级[1,2,3,4,5,6,7,8,9,10,11,12,13,14]',\n");
        stringBuilder.append("    LEAF INT(11) DEFAULT 1 COMMENT '叶子[0-非叶子,1-是叶子]',\n");
        stringBuilder.append("    IND_GRP VARCHAR(32) COMMENT '序号组',\n");
        stringBuilder.append("    IND_NO INT(11) NOT NULL DEFAULT 1 COMMENT '序号',\n");
        stringBuilder.append("    VISIBLE INT(11) NOT NULL DEFAULT 1 COMMENT '可见性[0-隐藏，1-显示]',\n");
        stringBuilder.append("    DELETED INT(11) NOT NULL DEFAULT 0 COMMENT '删除[0-未删除，1-已删除]',\n");
        stringBuilder.append("    CHECKED INT(11) NOT NULL DEFAULT 1 COMMENT '检查[0-已拒绝，1-已通过，2-待审核]',\n");
        stringBuilder.append("    ENABLED INT(11) NOT NULL DEFAULT 1 COMMENT '启用[0-未启用,1-已启用]',\n");

        stringBuilder.append("    PARENT_ID BIGINT(20) NOT NULL DEFAULT 0 COMMENT '父级主键',\n");
        stringBuilder.append("    PARENT_PATH VARCHAR(255) DEFAULT '0' COMMENT '父级主键路径如：0/1/2/3/4/5/6/7/8/9',\n");
        stringBuilder.append("    EXCEPTION_STATUS INT(11) NOT NULL DEFAULT 0 COMMENT '例外状态',\n");

        stringBuilder.append("    GMT_EXPIRED DATETIME COMMENT '过期时间',\n");
        stringBuilder.append("    GMT_CREATED DATETIME NOT NULL COMMENT '创建时间',\n");
        stringBuilder.append("    GMT_MODIFIED DATETIME COMMENT '修改时间',\n");
        stringBuilder.append("    USER_CREATED BIGINT(20) NOT NULL COMMENT '创建者',\n");
        stringBuilder.append("    USER_MODIFIED BIGINT(20) COMMENT '修改者',\n");
        stringBuilder.append("    STATUS INT(11) NOT NULL COMMENT '状态',\n");

        stringBuilder.append("    OPT1 VARCHAR(64) COMMENT '可选字段1',\n");
        stringBuilder.append("    OPT2 VARCHAR(64) COMMENT '可选字段2',\n");
        stringBuilder.append("    OPT3 VARCHAR(64) COMMENT '可选字段3',\n");

        stringBuilder.append("    EXT1 VARCHAR(128) COMMENT '额外字段1',\n");
        stringBuilder.append("    EXT2 VARCHAR(128) COMMENT '额外字段2',\n");
        stringBuilder.append("    EXT3 VARCHAR(128) COMMENT '额外字段3',\n");

        stringBuilder.append("    PRIMARY KEY (" + t + "_ID),\n");

        stringBuilder.append("    KEY AK_APP_ID (APP_ID),\n");
        stringBuilder.append("    KEY AK_OWNER_ID (OWNER_ID),\n");
        stringBuilder.append("    KEY AK_OWNER_TYPE (OWNER_TYPE),\n");
        stringBuilder.append("    KEY AK_BIZ_TYPE (BIZ_TYPE),\n");
        stringBuilder.append("    KEY AK_PARENT_ID (PARENT_ID),\n");
        stringBuilder.append("    KEY AK_PARENT_PATH (PARENT_PATH),\n");
        stringBuilder.append("    KEY AK_STATUS (STATUS),\n");
        stringBuilder.append("    KEY AK_" + t + "_TYPE (" + t + "_TYPE),\n");

        stringBuilder.append("    KEY AK_" + tableName + "_ID (" + tableName + "_ID),\n");

        stringBuilder.append("    KEY AK_" + tableNameRel + "_ID (" + tableNameRel + "_ID),\n");

        stringBuilder.append("    UNIQUE KEY AK_UNQ_OWNER_ID (APP_ID , OWNER_ID , OWNER_TYPE , " + tableName + "_ID , "
                + tableNameRel + "_ID)\n");

        stringBuilder.append(")  ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT='" + tc + "信息表';\n");

        // ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;
        // alter table T_DOMAIN_PMT_CHNL_TP_CTL comment '域支付渠道时间段控制信息表';

        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("SYS_APPLICATION", "应用"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("SYS_ADMIN", "管理员"));

        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("SYS_MENU", "菜单"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("SYS_ROLE", "角色"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("SYS_ROLE", "MENU", "角色", "菜单"));
        stringBuilder
                .append("\n" + MysqlStatement.generateCreateRelTableStatement("SYS_AUTHORIZED", "ROLE", "被授权者", "角色"));

        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("SYS_LOGIN", "登录"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("SYS_PASSWD", "密码"));

        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("PARAM", "参数"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("PARAM_GRP", "参数组"));

        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("ANNOUNCEMENT", "公告"));

        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("REGION", "区域"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("ADDRESS", "地址"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("LOCATION", "位置"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("VERIFIED_CODE", "验证码"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("TOKEN", "令牌"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("FEEDBACK", "反馈"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("MESSAGE", "消息"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("ELEMENT", "元素"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("ELEMENT_GRP", "元素组"));

        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("CATEGORY", "类目"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("CTGRY_ATTR", "类目属性"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("CTGRY_ATTR_VAL", "类目属相值"));

        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("PHOTO", "图片"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("PHOTO_GRP", "图片组"));

        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("CERT", "证书"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("CERT", "PHOTO", "证书", "图片"));

        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("ACQ_INS", "收单机构"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("ISS_INS", "发卡机构"));

        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("PMT_TYPE", "支付类型"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("PMT_CHNL", "支付渠道"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("PMT_CHNL_PARAM", "支付渠道参数"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("PMT_CHNL_ISS_INS", "支付渠道发卡机构"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("PMT_CHNL_ACQ_INS", "支付渠道收单机构"));

        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("ENTERPRISE", "企业"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("ENTERPRISE", "REGION", "企业", "区域"));
        stringBuilder
                .append("\n" + MysqlStatement.generateCreateRelTableStatement("ENTERPRISE", "LOCATION", "企业", "位置"));
        stringBuilder
                .append("\n" + MysqlStatement.generateCreateRelTableStatement("ENTERPRISE", "ADDRESS", "企业", "地址"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("STORE", "商铺"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("STORE", "REGION", "商铺", "区域"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("STORE", "LOCATION", "商铺", "位置"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("STORE", "ADDRESS", "商铺", "地址"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("ENTERPRISE", "STORE", "企业", "商铺"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("PDT", "产品"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("PDT_GRP", "产品组"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("PDT_ATTR", "产品属性"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("PDT_ATTR_VAL", "产品属相值"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("PDT", "PHOTO", "产品", "图片"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("PDT", "CATEGORY", "产品", "类目"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("PDT_EVALUATE", "产品评价"));
        stringBuilder.append(
                "\n" + MysqlStatement.generateCreateRelTableStatement("PDT_EVALUATE", "EVALUATOR", "产品评价", "评价者"));

        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("STORE", "PDT", "商铺", "产品"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("ENTERPRISE", "PDT", "企业", "产品"));

        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("QR_CODE", "二维码"));

        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("BOSS", "平台"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("DOMAIN", "域"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("OEM", "O单"));

        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("BOSS", "OEM", "平台", "O单"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("OEM", "DOMAIN", "O单", "域"));

        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("PARTNER", "合作商"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("PARTNER", "QR_CODE", "合作商", "二维码"));

        stringBuilder.append("\n" + MysqlStatement.generateCreateTableStatement("MCH", "商户"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("MCH", "QR_CODE", "商户", "二维码"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("MCH", "CATEGORY", "商户", "类目"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("MCH", "REGION", "商户", "区域"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("MCH", "ENTERPRISE", "商户", "企业"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("MCH", "STORE", "商户", "商铺"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("PARTNER", "MCH", "合作商", "商户"));

        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("DOMAIN", "MCH", "域", "商户"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("DOMAIN", "PARTNER", "域", "合作商"));

        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("BOSS", "PMT_CHNL", "平台", "支付渠道"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("OEM", "PMT_CHNL", "O单", "支付渠道"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("DOMAIN", "PMT_CHNL", "域", "支付渠道"));
        stringBuilder.append("\n" + MysqlStatement.generateCreateRelTableStatement("MCH", "PMT_CHNL", "商户", "支付渠道"));
        stringBuilder
                .append("\n" + MysqlStatement.generateCreateRelTableStatement("PARTNER", "PMT_CHNL", "合作商", "支付渠道"));

        FileWriter o = new FileWriter(new File("./a.sql"));
        o.write(MysqlStatement.tsName.toString().toLowerCase() + "\n");
        o.write(MysqlStatement.ts.toString());
        o.write(stringBuilder.toString());
        o.close();

    }
}
