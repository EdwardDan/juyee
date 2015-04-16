package com.justonetech.biz.manager;

import com.justonetech.core.utils.StringHelper;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * description:
 * User: Chenjp
 * Date: 14-3-28 上午9:56
 */
public class TreeIdTest {
    private static Logger logger = LoggerFactory.getLogger(TreeIdTest.class);

    private static final int treeidIncrease = 1;
    private static final String FORMAT_TYPE = "%05d";

    //获取后续treeId
    public static String getNextTreeId(String parentTreeId,String maxTreeId){
        int maxId = 0;
        if (!StringHelper.isEmpty(maxTreeId)) {
            String[] ss = com.justonetech.core.utils.StringHelper.stringToStringArray(maxTreeId, ".");
            String s = ss[ss.length - 1];
            maxId = Integer.parseInt(s);
        }
        String nextId = String.format(FORMAT_TYPE, maxId+treeidIncrease);
        if(parentTreeId != null){
            return parentTreeId+"."+nextId;
        }else{
            return nextId;
        }
    }

    @Test
    public void testMethod1() {
        System.out.println("s1 = " + getNextTreeId(null,null));
        System.out.println("s2 = " + getNextTreeId(null,"00002"));
        System.out.println("s3 = " + getNextTreeId(null,"00002.00003"));
        System.out.println("s4 = " + getNextTreeId("00001","00002.00003"));
        System.out.println("s5 = " + getNextTreeId("00001.00002","00002.00003"));
    }
}