package constant.tools.java.beans;

import java.beans.PropertyEditorSupport;
import java.util.Date;

public class LongDateEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        Date value = (Date) getValue();
        return (value != null ? String.valueOf(value.getTime()) : null);
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (null == text) {
            // Treat empty String as null value.
            setValue(null);
        } else {
            try {
                Date date = new Date(Long.valueOf(text));
                setValue(date);
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("Could not parse date: " + ex.getMessage(), ex);
            }
        }
    }

}
