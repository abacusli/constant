package constant.tools.convertor.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.Map;

public class Convertor {

    /**
     * 
     * @param responseMap
     * @param responseClass
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static <T> T convert(Map<String, String> responseMap, Class<T> responseClass) {
        if (null == responseMap || null == responseClass) {
            return null;
        }
        T responseObj = null;
        try {
            responseObj = responseClass.newInstance();
            Object value;
            for (Class<?> superClass = responseObj.getClass(); null != superClass
                    && superClass != Object.class; superClass = superClass.getSuperclass()) {
                for (Field field : superClass.getDeclaredFields()) {
                    if (Modifier.isStatic(field.getModifiers()) || !Modifier.isPrivate(field.getModifiers())
                            || field.getType() != String.class) {
                        continue;
                    }
                    value = responseMap.get(field.getName());
                    if (null == value) {
                        continue;
                    }
                    if (field.isAccessible()) {
                        field.set(responseObj, value);
                    } else {
                        field.setAccessible(true);
                        field.set(responseObj, value);
                        field.setAccessible(false);
                    }
                }
            }
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return responseObj;
    }

    /**
     * 
     * @param request
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static <T> Map<String, String> convert(T request) {
        Map<String, String> data = new LinkedHashMap<String, String>();
        if (null == request) {
            return data;
        }
        try {
            Object value;
            for (Class<?> superClass = request.getClass(); null != superClass
                    && superClass != Object.class; superClass = superClass.getSuperclass()) {
                for (Field field : superClass.getDeclaredFields()) {
                    if (Modifier.isStatic(field.getModifiers()) || !Modifier.isPrivate(field.getModifiers())
                            || field.getType() != String.class) {
                        continue;
                    }
                    if (field.isAccessible()) {
                        value = field.get(request);
                    } else {
                        field.setAccessible(true);
                        value = field.get(request);
                        field.setAccessible(false);
                    }
                    if (null == value) {
                        continue;
                    }
                    data.put(field.getName(), value.toString());
                }
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    /**
     * 
     * @param responseMap
     * @param responseClass
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static <T> T convertObject(Map<String, Object> responseMap, Class<T> responseClass) {
        if (null == responseMap || null == responseClass) {
            return null;
        }
        T responseObj = null;
        try {
            responseObj = responseClass.newInstance();
            Object value;
            for (Class<?> superClass = responseObj.getClass(); null != superClass
                    && superClass != Object.class; superClass = superClass.getSuperclass()) {
                for (Field field : superClass.getDeclaredFields()) {
                    if (Modifier.isStatic(field.getModifiers()) || !Modifier.isPrivate(field.getModifiers())) {
                        continue;
                    }
                    value = responseMap.get(field.getName());
                    if (null == value) {
                        continue;
                    }
                    if (field.isAccessible()) {
                        field.set(responseObj, value);
                    } else {
                        field.setAccessible(true);
                        field.set(responseObj, value);
                        field.setAccessible(false);
                    }
                }
            }
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return responseObj;
    }

    /**
     * 
     * @param request
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static <T> Map<String, Object> convertObject(T request) {
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        if (null == request) {
            return data;
        }
        try {
            Object value;
            for (Class<?> superClass = request.getClass(); null != superClass
                    && superClass != Object.class; superClass = superClass.getSuperclass()) {
                for (Field field : superClass.getDeclaredFields()) {
                    if (Modifier.isStatic(field.getModifiers()) || !Modifier.isPrivate(field.getModifiers())) {
                        continue;
                    }
                    if (field.isAccessible()) {
                        value = field.get(request);
                    } else {
                        field.setAccessible(true);
                        value = field.get(request);
                        field.setAccessible(false);
                    }
                    if (null == value) {
                        continue;
                    }
                    data.put(field.getName(), value);
                }
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
