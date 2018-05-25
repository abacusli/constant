package constant.tools.java.beans;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PatternDateEditor extends PropertyEditorSupport {

    private final String pattern;

    public PatternDateEditor(String pattern) {
        super();
        if (null == pattern) {
            this.pattern = "yyyy-MM-dd HH:mm:ss";
        } else {
            this.pattern = pattern;
        }
    }

    @Override
    public String getAsText() {
        Date value = (Date) getValue();
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return (value != null ? dateFormat.format(value) : null);
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (null == text) {
            // Treat empty String as null value.
            setValue(null);
        } else {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                Date date = dateFormat.parse(text);
                setValue(date);
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("Could not parse date: " + ex.getMessage(), ex);
            } catch (ParseException ex) {
                throw new IllegalArgumentException("Could not parse date: " + ex.getMessage(), ex);
            }
        }
    }

}
