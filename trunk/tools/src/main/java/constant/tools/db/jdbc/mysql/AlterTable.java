package constant.tools.db.jdbc.mysql;

public class AlterTable {

    public static final String generateAlterTableAddStatement(String tableName, String tableColumn, String dataType,
            String characterMaximumLength, String numericPrecision, String numericScale, boolean isNullable,
            String defaultValue, String columnComment, String afterColumn) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ALTER TABLE " + tableName.toUpperCase() + " ");
        stringBuilder.append("ADD COLUMN " + tableColumn.toUpperCase() + " ");

        if (null != characterMaximumLength) {
            stringBuilder.append(dataType.toUpperCase() + "(" + characterMaximumLength + ") ");
        } else if (null != numericPrecision && null != numericScale) {
            stringBuilder.append(dataType + "(" + numericPrecision + "," + numericScale + ") ");
        } else if (null != numericPrecision) {
            stringBuilder.append(dataType + "(" + numericPrecision + ") ");
        }

        if (!isNullable) {
            stringBuilder.append("NOT NULL ");
        }

        if (null != defaultValue) {
            stringBuilder.append("DEFAULT '" + defaultValue + "' ");
        }

        if (null != columnComment) {
            stringBuilder.append("COMMENT '" + columnComment + "' ");
        }
        if (null != afterColumn) {
            stringBuilder.append("AFTER " + afterColumn.toUpperCase() + " ");
        }
        return stringBuilder.toString();
    }

    public static final String generateAlterTableDropStatement(String tableName, String tableColumn) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ALTER TABLE " + tableName.toUpperCase() + " ");
        stringBuilder.append("DROP COLUMN " + tableColumn.toUpperCase() + " ");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String tableName = "t_boss";
        String tableColumn = "b";
        String dataType = "bigint";
        String characterMaximumLength = "20";
        String numericPrecision = null;
        String numericScale = null;
        String columnComment = "c";
        String defaultValue = "0";
        boolean isNullable = false;
        String afterColumn = "status";
        System.out.println(
                AlterTable.generateAlterTableAddStatement(tableName, tableColumn, dataType, characterMaximumLength,
                        numericPrecision, numericScale, isNullable, defaultValue, columnComment, afterColumn));
        System.out.println(AlterTable.generateAlterTableDropStatement(tableName, tableColumn));
    }

}
