package reflect;//package com.meitun.datatree.constants;
//
//import lombok.Getter;
//
//import java.lang.reflect.Method;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.function.Function;
//
///**
// * @author wuchenlong
// * @Description
// * @date 上午11:13 2019/2/20
// */
//public enum COMMON_OPS {
//    /**
//     * @author wuchenlong
//     * 枚举类生成手机号
//     */
//    PHONE_NUMBER("generatePhoneNumber", "com.meitun.datatree.utils.PhoneNumberUtils", "genPhoneNumber", String.class),
//
//    /**
//     * @author wuchenlong
//     * 枚举类生成邮箱
//     */
//    EMAIL_ADDRESS("generateEmail", "com.meitun.datatree.utils.EmailUtils", "genEmailAddress", String.class),
//
//    RSA("RSAEncrypt", "com.meitun.datatree.utils.RSAUtils", "encryptByPublicKey", String.class),
//
//    BASE64("BASE64Encrypt", "com.meitun.datatree.utils.Base64Utils", "encodeMessage", String.class),
//
//    GET_SECRET("getSecret", "com.meitun.datatree.utils.GetSecretUtils", "getUrlWithSecret", String.class),
//
//    GET_ENCODEDUID("getEncodedUserId", "com.meitun.datatree.utils.UIDUtil", "encode", String.class),
//
//    BATCH_DELETE_CMS_COLUMNS("batchDeleteCmsColumns","com.meitun.datatree.utils.BatchDeleteCMSColumns", "batchDeleteCmsColumns", String[].class),
//
//    GENERATE_DATETIME("generateDatetime", "com.meitun.datatree.utils.DatetimeUtils", "generateDatetime", String.class),
//
//    GENERATE_TIMESTAMP("generateTimestamp", "com.meitun.datatree.utils.DatetimeUtils", "generateTimestamp", String.class),
//
//    GET_MEITUN_BACKEND_COOKIE("getMeitunBackendCookies", "com.meitun.datatree.utils.CookieUtils", "getMeitunBackendCookies", String[].class),
//
//    GET_LOGIN_STRING("getLoginString", "com.meitun.datatree.utils.CookieUtils", "getLoginString", String[].class);
//
//    @Getter
//    private final String op;
//
//    @Getter
//    private final String clazz;
//
//    @Getter
//    private final String method;
//
//    @Getter
//    private final Class[] classType;
//
//    COMMON_OPS(final String op, final String clazz, final String method, final Class... classType) {
//        this.op = op;
//        this.clazz = clazz;
//        this.method = method;
//        this.classType = classType;
//    }
//
//    public static Class<?> getClazz(final COMMON_OPS ops) throws ClassNotFoundException {
//        return Class.forName(ops.getClazz());
//    }
//
//    public static Method getMethod(final COMMON_OPS ops) throws ClassNotFoundException, java.lang.NoSuchMethodException {
//        return COMMON_OPS.getClazz(ops).getDeclaredMethod(ops.getMethod(), ops.getClassType());
//    }
//
//    public static COMMON_OPS getCommonOpByOperationType(final String op) {
//        for (final COMMON_OPS commonOps : values()) {
//            if (commonOps.getOp().equals(op))
//                return commonOps;
//        }
//        return null;
//    }
//
//    public static Object execute(final String opType, final String... data) throws Exception {
//        try{
//            final COMMON_OPS commonOps = getCommonOpByOperationType(opType);
//            if (commonOps == null)
//                return null;
//            final Method method = getMethod(commonOps);
//            return method.invoke(getClazz(commonOps), data.length > 1 ? new Object[]{data} : data);
//        } catch (Exception e){
//            e.printStackTrace();
//            throw e;
//        }
//
//    }
//
//    public static HashMap[] getAllCommonOp() {
//        return Arrays.stream(values())
//                .map((Function<COMMON_OPS, HashMap>) op -> {
//                    final HashMap<String, String> opInfoMap = new HashMap<>(2);
//                    opInfoMap.put("methodName", op.getOp());
//                    opInfoMap.put("paramCount", String.valueOf(op.classType.length));
//                    return opInfoMap;
//                })
//                .toArray(HashMap[]::new);
//    }
//}