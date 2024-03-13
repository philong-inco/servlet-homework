package com.longph31848.assignment.util;

public class RenderQuery {

    public static String render(String column, String value){
        String valueConvert = value.trim().toLowerCase();
        String columnConvert = "LOWER(" + column + ")";
        return columnConvert + " LIKE " + "'%" + valueConvert + "' "
                + " OR " + columnConvert + " LIKE " + " '"+valueConvert + "%' "
                + " OR " + columnConvert + " LIKE " + "'%" + valueConvert + "%' ";
    }
}
