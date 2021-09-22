SELECT TABLE_NAME     表名,
       -- ORDINAL_POSITION 序号,
       IF(column_key = 'PRI', '是', '') AS '主键唯一', -- column_key='PRI' 时，为主键唯一索引，是返回“是”，否返回空 COLUMN_NAME 字段名称,
       COLUMN_COMMENT 注释,
       COLUMN_TYPE    数据类型,
       IF(IS_NULLABLE = 'NO', '是', '') AS '必填'    --  IS_NULLABLE = 'NO' 时，为必填，必填返回“是”，非必填返回空
       -- COLUMN_DEFAULT 默认值,
       -- CHARACTER_MAXIMUM_LENGTH 字符串最大长度【以字符为单位】,
       -- CHARACTER_OCTET_LENGTH 字符串最大长度【以字节为单位】,
       -- CHARACTER_SET_NAME 字符串字符集名称,
       -- COLLATION_NAME 字符串归类名称,
       -- NUMERIC_PRECISION 数字精度,
       -- NUMERIC_SCALE 数字刻度,
       -- DATETIME_PRECISION 时间分数秒精度

FROM INFORMATION_SCHEMA.COLUMNS
WHERE-- performance_schema 为数据库名称，到时候只需要修改成你要导出表结构的数据库即可
    table_schema = 'new3t_test'

-- AND
-- events_errors_summary_by_account_by_error 为表名，到时候换成你要导出的表的名称
-- 如果不写的话，默认会查询出该数据库中所有表的表结构；这里如果指定表名，则可以导出单独一个表的表结构
  and table_name = 't_project'

ORDER BY TABLE_NAME,
         ORDINAL_POSITION;
