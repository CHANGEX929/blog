package com.changex.blog.tools;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志打印
 */
public class LogUtil {

        private static final Logger logger = LoggerFactory.getLogger("BIZ-LOGGER");

        public static void debug(String... messages) {
            if (logger.isDebugEnabled()) {
                logger.debug(mergeStrings(messages));
            }

        }

        public static void debug(Object... messages) {
            if (logger.isDebugEnabled()) {
                logger.debug(mergeObjects(messages));
            }

        }

        public static void info(Object... messages) {
            if (logger.isInfoEnabled()) {
                logger.info(mergeObjects(messages));
            }

        }

        public static void warn(Object... messages) {
            if (logger.isWarnEnabled()) {
                logger.warn(mergeObjects(messages));
            }

        }

        public static void warn(String... messages) {
            if (logger.isWarnEnabled()) {
                logger.warn(mergeObjects(messages));
            }

        }

        public static void error(String... messages) {
            if (logger.isErrorEnabled()) {
                logger.error(mergeStrings(messages));
            }

        }

        public static void error(Throwable e, String... messages) {
            if (logger.isErrorEnabled()) {
                if (e == null) {
                    logger.error(mergeStrings(messages));
                } else {
                    logger.error(mergeStrings(messages), e);
                }
            }

        }

        private static String mergeStrings(String[] strings) {
            if (strings == null) {
                return "";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                String[] arg1 = strings;
                int arg2 = strings.length;

                for (int arg3 = 0; arg3 < arg2; ++arg3) {
                    String string = arg1[arg3];
                    stringBuilder.append(string);
                }

                return stringBuilder.toString();
            }
        }

        private static String mergeObjects(Object[] objects) {
            if (objects == null) {
                return "";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                Object[] arg1 = objects;
                int arg2 = objects.length;

                for (int arg3 = 0; arg3 < arg2; ++arg3) {
                    Object obj = arg1[arg3];
                    if (obj != null) {
                        if (obj instanceof String) {
                            stringBuilder.append(obj);
                        } else {
                            stringBuilder.append(obj.toString());
                        }
                    }
                }

                return stringBuilder.toString();
            }
        }

        public static String toString(Object object) {
            return object == null
                    ? "null"
                    : (object instanceof String
                    ? (String) object
                    : ToStringBuilder.reflectionToString(object, ToStringStyle.SHORT_PREFIX_STYLE));
        }
}
