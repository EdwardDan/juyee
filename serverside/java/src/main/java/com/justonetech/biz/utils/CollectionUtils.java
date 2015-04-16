package com.justonetech.biz.utils;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * User: juyee
 * Date: 12-4-27
 * Time: 下午2:10
 * To change this template use File | Settings | File Templates.
 */
public class CollectionUtils {

    public static <T> T getFirstEle(Collection<T> collection) {
        if (collection == null || collection.size() == 0) {
            return null;
        }
        return collection.iterator().next();
    }
}
